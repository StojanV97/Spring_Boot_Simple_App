<template>
  <v-app id="asd">
    <v-form v-model="valid">
      <v-container>
        <v-row>
          <v-col cols="12" md="6">
            <v-text-field outlined v-model="art.name" :rules="nameRules" label="Art name" required></v-text-field>
          </v-col>

          <v-col cols="12" sm="6" md="6">
            <v-menu
              ref="menu"
              :rules="nameRules"
              v-model="menu"
              :close-on-content-click="false"
              :return-value.sync="date"
              transition="scale-transition"
              offset-y
              min-width="290px"
            >
              <template v-slot:activator="{ on, attrs }">
                <v-text-field
                  outlined
                  v-model="date"
                  label="Date of creation"
                  readonly
                  v-bind="attrs"
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker v-model="date" no-title scrollable>
                <v-spacer></v-spacer>
                <v-btn text color="primary" @click="menu = false">Cancel</v-btn>
                <v-btn text color="primary" @click="$refs.menu.save(date)">OK</v-btn>
              </v-date-picker>
            </v-menu>
          </v-col>

          <v-col class="d-flex" cols="12" sm="6">
            <v-select
              required
              :rules="nameRules"
              v-model="art.artPeriod"
              :items="artPeriods"
              label="Art period "
              outlined
            ></v-select>
          </v-col>

          <v-col cols="12" md="6">
            <v-select
              required
              :rules="nameRules"
              v-model="art.technique"
              :items="techniques"
              label="Techniques "
              outlined
            ></v-select>
          </v-col>

          <v-col cols="6" md="6">
            <v-file-input
              outlined
              :rules="rules"
              accept="image/png, image/jpeg, image/bmp"
              placeholder="Pick an picture"
              prepend-icon="mdi-panorama"
              label="Picture"
            ></v-file-input>
          </v-col>
          <v-col cols="12" md="12">
            <v-textarea
              outlined
              :rules="nameRules"
              v-model="art.description"
              label="Description"
              required
            ></v-textarea>
          </v-col>

          <v-col cols="12" md="4">
            <v-btn color="green" @click="onSubmit" id="sbmt">Submit</v-btn>
          </v-col>
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
import api from "../components/backend-api";

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
      iconPath:
        "https://cdn.discordapp.com/attachments/690534792537702400/721866661161992272/HCI_DTI_FINAL.png"
    },
    art: {
      name: "",
      creationDate: "",
      technique: "",
      description: "",
      artPeriod: "",
      iconPath: "",
      painterId: "",
      currentLocation: ""
    },

    nameRules: [v => !!v || "Item is required"],
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
    techniques: [
      "pastel",
      "kolaž",
      "vitraž",
      "tapiserija",
      "grafit",
      "ugljen",
      "ulje",
      "akril",
      "akvarel",
      "gvaš",
      "tempera",
      "mozaik",
      "enkaustika"
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
      this.art.painterID = localStorage.getItem("artistId");
      this.art.creationDate = this.date;
      console.log(localStorage.getItem("artistID"));
      console.log(this.art);
      console.log("asdasadas");
      api.addA(this.art).then(response => {
        this.text = "Art Created!";
        this.snackbar = true;
        console.log(response);
      });
      console.log("asdasadas");
    }
  }
};
</script>

<style>
#sbmt {
  margin-top: -80px;
}
#asd {
  height: 570px;
}
.addPicture {
  height: 20px;
}
</style>