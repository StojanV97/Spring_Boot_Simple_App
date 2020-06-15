import axios from 'axios'

const AXIOS = axios.create({
  baseURL: `/api`,
  timeout: 1000
});


export default {
    hello() {
        return AXIOS.get(`/hello`);
    },
    getUser(userId) {
        return AXIOS.get(`/user/` + userId);
    },
    createUser(firstName, lastName) {
        return AXIOS.post(`/user/` + firstName + '/' + lastName);
    },
    getSecured(user, password) {
        return AXIOS.get(`/secured/`,{
            auth: {
                username: user,
                password: password
            }});
    },
    addPainter(firstName,lastName,dateOfBirth,dateOfDeath,nationality,artPeriod,iconPath) {
        return AXIOS.post("/painter/add/"+ firstName + "/" +lastName + "/" + dateOfBirth +"/" + dateOfDeath+ "/"+ nationality +"/" + artPeriod+"/"+ iconPath);
    },
    editPainter(artistID, firstName,lastName,dateOfBirth,dateOfDeath,nationality,artPeriod,iconPath) {
        return AXIOS.post("/painter/edit/"+ artistID + "/"+firstName + "/" +lastName + "/" + dateOfBirth +"/" + dateOfDeath+ "/"+ nationality +"/" + artPeriod+"/"+ iconPath);
    },
    deletePainter(painterID) {
        return AXIOS.post("/painter/delete/"+painterID);
    },
    updatePainter(firstName,lastName,dateOfBirth,dateOfDeath,nationality,artPeriod,iconPath){
        return AXIOS.post("/painter/update/"+ firstName + "/" +lastName + "/" + dateOfBirth +"/" + dateOfDeath+ "/"+ nationality +"/" + artPeriod+"/"+ iconPath);
    },
    getPainter(painterID){
        return AXIOS.get("/painter/" + painterID);
    }



}


