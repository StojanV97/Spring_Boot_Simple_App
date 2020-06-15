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
                                :readonly=true
                                label="First name"
                                outlined
                        ></v-text-field>
                    </v-col>

                    <v-col
                            cols="12"
                            md="6"
                    >
                        <v-text-field
                                v-model="this.artist.lastname"
                                :readonly=true
                                label="Last name"
                                outlined
                        ></v-text-field>
                    </v-col>




                    <v-col class="d-flex" cols="12" sm="6">

                        <v-text-field
                                v-model="this.artist.artPeriod"
                                :readonly=true
                                label="Art period"
                                outlined
                        ></v-text-field>
                    </v-col>

                    <v-col
                            cols="12"
                            md="6"
                    >
                        <v-text-field
                                v-model="this.artist.nationality"
                                label="Nationality"
                                :readonly=true
                                outlined
                        ></v-text-field>
                    </v-col>

                    <v-col
                            cols="12"
                            md="6"
                    >
                        <v-text-field
                                v-model="this.artist.dateOfBirth"
                                label="Date of birth "
                                :readonly=true
                                outlined
                        ></v-text-field>
                    </v-col>
                    <v-col
                            cols="12"
                            md="6"
                    >
                        <v-text-field
                                v-model="this.artist.dateOfDeath"
                                label="Date of death  "
                                :readonly=true
                                outlined
                        ></v-text-field>
                    </v-col>

                    <v-col
                            cols="12"
                            md="0"
                    >

                        <v-icon size="200px">mdi-panorama</v-icon>
                    </v-col>
                    <v-img
                            alt="Vuetify Logo"
                            class="shrink mr-2"
                            contain
                            src="https://cdn.vuetifyjs.com/images/logos/vuetify-logo-dark.png"
                            transition="scale-transition"
                            width="100"
                    />
                    <v-col
                            cols="12"
                            md="10"
                    >
                        <v-btn>Close</v-btn>
                    </v-col>
                </v-row>
            </v-container>
        </v-form>

    </v-app>
</template>

<script>
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
                avatarLink:'',
                dateOfDeath:'',
                iconPath:''

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

        }),
        mounted() {
        },
        methods:{

            onSubmit(){

            },
        }

    }
</script>