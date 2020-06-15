<template>
    <v-app>
        <v-form v-model="valid">
            <v-container>
                <v-row>
                    <v-col
                            cols="12"
                            md="6"
                    >
                        <v-text-field
                                v-model="this.artist.firstname"
                                :rules="nameRules"
                                :counter="10"
                                label="First name"
                                required
                        ></v-text-field>
                    </v-col>

                    <v-col
                            cols="12"
                            md="6"
                    >
                        <v-text-field
                                v-model="this.artist.lastname"
                                :rules="nameRules"
                                :counter="10"
                                label="Last name"
                                required
                        ></v-text-field>
                    </v-col>




                    <v-col class="d-flex" cols="12" sm="6">
                        <v-select
                                required
                                v-model="this.artist.artPeriod"
                                :items="artPeriods"
                                label="Art period "
                                outlined
                        ></v-select>
                    </v-col>

                    <v-col
                            cols="12"
                            md="6"
                    >
                        <v-text-field
                                v-model="this.artist.nationality"
                                :rules="nationalityRules"
                                label="Nationality"
                                required
                        ></v-text-field>
                    </v-col>
                    <v-col
                            cols="12"
                            md="4"
                    >
                        <v-img
                                alt="Vuetify Logo"
                                class="shrink mr-2"
                                contain
                                src="https://cdn.vuetifyjs.com/images/logos/vuetify-logo-dark.png"
                                transition="scale-transition"
                                width="100"
                        />
                        <v-file-input
                                :rules="rules"
                                accept="image/png, image/jpeg, image/bmp"
                                placeholder="Pick an picture"
                                prepend-icon="mdi-panorama"
                                label="Picture"
                        ></v-file-input>

                    </v-col>

                    <v-col cols="12" sm="6" md="4">
                        <v-menu
                                ref="menu"
                                v-model="this.artist.dateOfBirth"
                                :close-on-content-click="false"
                                :return-value.sync="date"
                                transition="scale-transition"
                                offset-y
                                min-width="290px"
                        >
                            <template v-slot:activator="{ on, attrs }">
                                <v-text-field
                                        v-model="date"
                                        label="Date of birth "
                                        readonly
                                        v-bind="attrs"
                                        v-on="on"
                                ></v-text-field>
                            </template>
                            <v-date-picker v-model="date" no-title scrollable>
                                <v-spacer></v-spacer>
                                <v-btn text color="primary" @click="menu2 = false">Cancel</v-btn>
                                <v-btn text color="primary" @click="$refs.menu.save(date)">OK</v-btn>
                            </v-date-picker>
                        </v-menu>
                    </v-col>
                    <v-col
                            cols="12"
                            md="4"
                    >
                        <v-menu
                                ref="menu"
                                v-model="this.artist.dateOfDeath"
                                :close-on-content-click="false"
                                :return-value.sync="date2"
                                transition="scale-transition"
                                offset-y
                                min-width="290px"
                        >
                            <template v-slot:activator="{ on, attrs }">
                                <v-text-field
                                        v-model="date2"
                                        label="Date of birth (if the artist died)"
                                        readonly
                                        v-bind="attrs"
                                        v-on="on"
                                ></v-text-field>
                            </template>
                            <v-date-picker v-model="date2" no-title scrollable>
                                <v-spacer></v-spacer>
                                <v-btn text color="primary" @click="menu2 = false">Cancel</v-btn>
                                <v-btn text color="primary" @click="$refs.menu.save(date2)">OK</v-btn>
                            </v-date-picker>
                        </v-menu>
                    </v-col>

                    <v-col
                            cols="12"
                            md="4"
                    >
                        <v-btn @click="onSubmit">
                            Submit
                        </v-btn>

                    </v-col>

                    <v-col
                            cols="12"
                            md="8"
                    >
                        <v-btn>Close</v-btn>
                    </v-col>
                </v-row>
            </v-container>
        </v-form>

    </v-app>
</template>

<script>
    import api from "./backend-api";

    export default {
        data: () => ({
            rules: [
                value => !value || value.size < 2000000 || 'Avatar size should be less than 2 MB!',
            ],
            valid: false,
            artist:{
                firstname: '',
                lastname: '',
                dateOfBirth:'',
                nationality:'',
                artPeriod:'',
                iconPath:'',
                dateOfDeath:''

            },

            nameRules: [
                v => !!v || 'Artist Name is required',
            ],
            email: '',
            dateOfbirthrules: [
                v => !!v || 'Date of birth is required ',
            ],

            nationalityRules: [
                v => !!v || 'Nationality is required',
            ],

            artPeriods:["Klasicizam", "Postimpresionizam", "Impresionizam", "Kubizam", "Romantizam", "Gotika", "Barok", "Moderna Umestnost", "Renesansa" , "Humanizam"],
            date: '',
            date2: '',
            menu: false,
            menu2:false,
            modal: false,

        }),
        mounted() {
            api.getPainter(1).then(response=>{
                this.artist.dateOfBirth = response.data.dateOfBirth;
                this.artist.dateOfDeath = response.data.dateOfDeath;
                this.artist.lastname = response.data.lastName;
                this.artist.firstname = response.data.firstName;
                this.artist.nationality = response.data.nationality;
                this.artist.iconPath = response.data.iconPath;
                this.artist.artPeriod = response.data.artPeriod;
                this.date = response.data.dateOfBirth;
                this.date2 = response.data.dateOfBirth;

            })
        },
        methods:{

            onSubmit(){

                this.artist.firstname = this.firstName;
                this.artist.lastname = this.lastName;
                this.artist.artPeriod=this.artperiod;
                this.artist.nationality = this.nationality;

                this.artist.iconPath = this.path.link;
                console.log(this.path.link);

                this.artist.dateOfBirth = this.date;

                console.log(this.artist);
                api.editPainter(this.artist.artistID, this.artist.firstname,this.artist.lastname, this.artist.dateOfBirth,this.artist.dateOfDeath,this.artist.nationality, this.artist.artPeriod,'this.artist.iconPath').then(response=>{
                    console.log(this.artist);
                    console.log(response.data);
                })
            },
        }

    }
</script>

<style>

    .addPicture{
        height: 20px;
    }
</style>