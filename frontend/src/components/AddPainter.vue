<template>
  <v-app id="asd">
    <v-form v-model="valid" id="formaa">
      <v-row>
        <v-col cols="12" md="6">
          <v-text-field v-model="firstName" :rules="nameRules" label="First name" required></v-text-field>
        </v-col>

        <v-col cols="12" md="6">
          <v-text-field v-model="lastName" :rules="nameRules" label="Last name" required></v-text-field>
        </v-col>

        <v-col class="d-flex" cols="12" sm="6">
          <v-select required v-model="artperiod" :items="artPeriods" label="Art period " outlined></v-select>
        </v-col>

        <v-col cols="12" md="6">
          <v-text-field
            v-model="nationality"
            :rules="nationalityRules"
            label="Nationality"
            required
          ></v-text-field>
        </v-col>
        <v-col cols="12" md="4">
          <v-file-input
            :rules="rules"
            v-model="path"
            accept="image/png, image/jpeg, image/bmp"
            placeholder="Pick an picture"
            prepend-icon="mdi-panorama"
            label="Picture"
            required
          ></v-file-input>
        </v-col>

        <v-col cols="12" sm="6" md="4">
          <v-menu
            ref="menu"
            v-model="menu"
            :close-on-content-click="false"
            :return-value.sync="date"
            transition="scale-transition"
            offset-y
            min-width="290px"
            required
          >
            <template v-slot:activator="{ on, attrs }">
              <v-text-field
                v-model="date"
                label="Date of birth"
                readonly
                v-bind="attrs"
                v-on="on"
                required
              ></v-text-field>
            </template>
            <v-date-picker v-model="date" no-title scrollable required>
              <v-spacer></v-spacer>
              <v-btn text color="primary" @click="menu = false">Cancel</v-btn>
              <v-btn text color="primary" @click="$refs.menu.save(date)">OK</v-btn>
            </v-date-picker>
          </v-menu>
        </v-col>
        <v-col cols="12" md="4">
          <v-menu
            ref="menu2"
            v-model="menu2"
            :close-on-content-click="false"
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
              <v-btn text color="primary" @click="$refs.menu2.save(date)">OK</v-btn>
            </v-date-picker>
          </v-menu>
        </v-col>

        <v-col cols="12" md="4">
          <v-btn @click="onSubmit" color="blue">Submit</v-btn>
        </v-col>
      </v-row>
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
  data: () => ({
    rules: [
      value =>
        !value ||
        value.size < 2000000 ||
        "Avatar size should be less than 2 MB!"
    ],
    valid: false,
    snackbar: false,
    text: "",
    artist: {
      firstname: "",
      lastname: "",
      dateOfBirth: "",
      nationality: "",
      artPeriod: "",
      dateOfDeath: null,
      iconPath: ""
    },
    path: "",
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
    modal: false,
    firstName: "",
    lastName: "",
    nationality: "",
    artperiod: ""
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
        .addPainter(
          this.artist.firstname,
          this.artist.lastname,
          this.artist.dateOfBirth,
          this.artist.dateOfDeath,
          this.artist.nationality,
          this.artist.artPeriod,
          "this.artist.iconPath"
        )
        .then(response => {
          this.text = "Painter added!";
          this.snackbar = true;
          console.log(this.artist);
          console.log(response.data);
        });
    }
  }
};
</script>

<style scoped>
#asd {
  height: 400px;
}
#formaa {
  height: 800px;
}
.addPicture {
  height: 20px;
}
</style>