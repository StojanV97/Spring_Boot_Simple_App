<template>
  <v-app>
    <v-form v-model="valid">
      <v-container>
        <v-row class="d-flex">
          <v-col cols="12" md="6">
            <v-text-field
              outlined
              v-model="$props.art.name"
              :rules="nameRules"
              label="Art name"
              required
            ></v-text-field>
            <v-text-field
              outlined
              v-model="$props.art.currentLocation"
              label="Current Location"
              required
            ></v-text-field>
          </v-col>

          <v-col cols="12" md="6">
            <v-menu
              ref="menu"
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
              class="select"
              required
              v-model="$props.art.artPeriod"
              :items="artPeriods"
              label="Art period "
              outlined
            ></v-select>
          </v-col>
          <v-col cols="12" md="6">
            <v-select
              required
              v-model="$props.art.technique"
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
            <v-textarea outlined v-model="$props.art.description" label="Description" required></v-textarea>
          </v-col>

          <v-col cols="12" md="4">
            <v-btn @click="onSubmit">Submit</v-btn>
          </v-col>
        </v-row>
      </v-container>
    </v-form>
  </v-app>
</template>

<script>
import api from "./backend-api";

export default {
  props: ["art"],
  data: () => ({
    rules: [
      value =>
        !value ||
        value.size < 2000000 ||
        "Avatar size should be less than 2 MB!"
    ],
    valid: false,
    artist: {
      firstname: "",
      lastname: "",
      iconPath:
        "https://cdn.discordapp.com/attachments/690534792537702400/721866661161992272/HCI_DTI_FINAL.png"
    },

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
    date: new Date().toISOString().substr(0, 10),
    date2: "",
    menu: false,
    menu2: false,
    modal: false
  }),
  mounted() {},
  methods: {}
};
</script>

<style>
.addPicture {
  height: 20px;
}
</style>