<template>
  <v-app id="dsa">
    <v-form v-model="valid">
      <v-container class="override">
        <v-row>
          <v-col cols="12" md="6">
            <v-text-field
              v-model="$props.painter.firstName"
              :readonly="true"
              label="First name"
              outlined
            ></v-text-field>
          </v-col>

          <v-col cols="12" md="6">
            <v-text-field
              v-model="$props.painter.lastName"
              :readonly="true"
              label="Last name"
              outlined
            ></v-text-field>
          </v-col>

          <v-col class="d-flex" cols="12" sm="6">
            <v-text-field
              v-model="$props.painter.artPeriod"
              :readonly="true"
              label="Art period"
              outlined
            ></v-text-field>
          </v-col>

          <v-col cols="12" md="6">
            <v-text-field
              v-model="$props.painter.nationality"
              label="Nationality"
              :readonly="true"
              outlined
            ></v-text-field>
          </v-col>

          <v-col cols="12" md="6">
            <v-text-field
              v-model="$props.painter.dateOfBirth"
              label="Date of birth "
              :readonly="true"
              outlined
            ></v-text-field>
          </v-col>
          <v-col cols="12" md="6">
            <v-text-field
              v-model="$props.painter.dateOfDeath"
              label="Date of death  "
              :readonly="true"
              outlined
            ></v-text-field>
          </v-col>
          <v-img
            alt="Vuetify Logo"
            class="shrink mr-2"
            contain
            src="../assets/Salvador-Dali-828x1024.jpg"
            transition="scale-transition"
            width="100"
          />
        </v-row>
      </v-container>
    </v-form>
  </v-app>
</template>

<style  scoped>
#dsa {
  height: 500px;
}
</style>
<script>
import api from "./backend-api";
export default {
  props: ["painter"],
  data: () => ({
    rules: [
      value =>
        !value ||
        value.size < 2000000 ||
        "Avatar size should be less than 2 MB!"
    ],
    valid: false,
    artist: {
      artistID: "",
      firstname: "",
      lastname: "",
      dateOfBirth: "",
      nationality: "",
      artPeriod: "",
      dateOfDeath: "",
      iconPath: ""
    },

    nameRules: [v => !!v || "Artist Name is required"],
    email: "",
    dateOfbirthrules: [v => !!v || "Date of birth is required "],

    nationalityRules: [v => !!v || "Nationality is required"]
  }),
  mounted() {},
  methods: {
    cancel() {}
  }
};
</script>