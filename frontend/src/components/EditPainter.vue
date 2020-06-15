<template>
  <v-app class="asd">
    <v-form v-model="valid">
      <v-container>
        <v-row>
          <v-col cols="12" md="6">
            <v-text-field
              v-model="$props.painter.firstName"
              :rules="nameRules"
              :counter="10"
              label="First name"
              required
            ></v-text-field>
          </v-col>

          <v-col cols="12" md="6">
            <v-text-field
              v-model="$props.painter.lastName"
              :rules="nameRules"
              :counter="10"
              label="Last name"
              required
            ></v-text-field>
          </v-col>

          <v-col class="d-flex" cols="12" sm="6">
            <v-select
              required
              v-model="$props.painter.artPeriod"
              :items="artPeriods"
              label="Art period "
              outlined
            ></v-select>
          </v-col>

          <v-col cols="12" md="6">
            <v-text-field
              v-model="$props.painter.nationality"
              :rules="nationalityRules"
              label="Nationality"
              required
            ></v-text-field>
          </v-col>
          <v-col cols="12" md="4">
            <v-file-input
              :rules="rules"
              accept="image/png, image/jpeg, image/bmp"
              placeholder="Pick an picture"
              prepend-icon="mdi-panorama"
              label="Picture"
            ></v-file-input>
          </v-col>
          <v-col cols="12" md="4">
            <v-btn @click="onSubmit" id="sbm" color="green">Submit</v-btn>
          </v-col>

          <v-col cols="12" md="8"></v-col>
        </v-row>
      </v-container>
    </v-form>
    <v-snackbar v-model="snackbar">
      {{ text }}
      <template v-slot:action="{ attrs }">
        <v-btn color="pink" text v-bind="attrs" @click="snackbar = false">Close</v-btn>
      </template>
    </v-snackbar>
  </v-app>
</template>

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
    snackbar: true,
    text: "",
    nameRules: [v => !!v || "Artist Name is required"],
    email: "",
    dateOfbirthrules: [v => !!v || "Date of birth is required "],

    nationalityRules: [v => !!v || "Nationality is required"],

    artPeriods: [
      "Klasicizam",
      "Postimpresionizam",
      "Impresionizam",
      "Kubizam",
      "Romantizam",
      "Gotika",
      "Barok",
      "Moderna Umestnost",
      "Renesansa",
      "Humanizam"
    ],
    date: "",
    date2: "",
    menu: false,
    menu2: false,
    modal: false
  }),
  mounted() {},
  methods: {
    onSubmit() {
      this.artist.firstname = this.firstName;
      this.artist.lastname = this.lastName;
      this.artist.artPeriod = this.artperiod;
      this.artist.nationality = this.nationality;
      this.artist.iconPath = this.path.link;
      console.log(this.path.link);

      this.artist.dateOfBirth = this.date;

      console.log(this.artist);
      api
        .editPainter(
          this.artist.artistID,
          this.artist.firstname,
          this.artist.lastname,
          this.artist.dateOfBirth,
          this.artist.dateOfDeath,
          this.artist.nationality,
          this.artist.artPeriod,
          "this.artist.iconPath"
        )
        .then(response => {
          this.text = "Edited!";
          this.snackbar = true;
          console.log(this.artist);
          console.log(response.data);
        });
    }
  }
};
</script>

<style>
#sbm {
  margin-top: 140px;
  margin-left: -100px;
}
.addPicture {
  height: 20px;
}
.asd {
  height: 400px;
}
</style>