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
        return AXIOS.get(`/secured/`, {
            auth: {
                username: user,
                password: password
            }
        });
    },
    addPainter(firstName, lastName, dateOfBirth, dateOfDeath, nationality, artPeriod, iconPath) {
        return AXIOS.post("/painter/add/" + firstName + "/" + lastName + "/" + dateOfBirth + "/" + dateOfDeath + "/" + nationality + "/" + artPeriod + "/" + iconPath);
    },
    editPainter(artistID, firstName, lastName, dateOfBirth, dateOfDeath, nationality, artPeriod, iconPath) {
        return AXIOS.post("/painter/edit/" + artistID + "/" + firstName + "/" + lastName + "/" + dateOfBirth + "/" + dateOfDeath + "/" + nationality + "/" + artPeriod + "/" + iconPath);
    },
    deletePainter(painterID) {
        return AXIOS.post("/painter/delete/" + painterID);
    },


    getAllPaintnings() {
        return AXIOS.get("/get-all-paintnings");
    },
    getPainter(id) {
        return AXIOS.get("/get-painter/" + id)
    },
    addPainting() {
        return AXIOS.post('/painting/add/' + 'name' + "/" + 'painterID' + "/" + 'creationDate' + "/" + 'currentLocation' + "/" + 'technique' + "/" + 'description' + "/" + 'artPeriod' + "/" + 'iconPath')
    }
    ,
    deleteArt(artID) {
        return AXIOS.post("/art/delete/" + artID);
    }
    ,
    getAllPainters() {
        return AXIOS.get("/get-all-painters")
    }
}


