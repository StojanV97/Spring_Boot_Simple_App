<template>
  <v-app id="main-div">
    <div>
      <header>
        <div class="container">
          <div id="branding">
            <h1>
              <span class="highlight">Art</span> Museum
            </h1>
          </div>
          <nav id="lu">
            <ul>
              <li>
                <v-btn class="btnbtnbtn" @click="$router.push('/home-page')">Home Page</v-btn>
              </li>
              <li>
                <v-btn class="btnbtnbtn" @click="$router.push('/table-view')">Table View</v-btn>
              </li>
              <li>
                <v-btn class="btnbtnbtn">Tutorial</v-btn>
              </li>
              <li>
                <v-btn class="btnbtnbtn">Help</v-btn>
              </li>
            </ul>
          </nav>
        </div>
      </header>
      <v-card>
        <v-card-title>
          Paintnings
          <v-spacer></v-spacer>
          <v-text-field
            v-model="search"
            append-icon="mdi-magnify"
            label="Search"
            single-line
            hide-details
          ></v-text-field>
        </v-card-title>
        <v-data-table
          id="vcard"
          :headers="headers"
          :items="paintnings"
          :search="search"
          height="480px"
        >
          <template v-slot:item.action="{ item }">
            <v-icon large @click="showPainter(item)">mdi-account</v-icon>
          </template>
        </v-data-table>
      </v-card>
      <footer>
        <p>Painter and their arts, Copyright Mihanine &copy; 2020</p>
      </footer>
    </div>
    <v-dialog v-model="previewUser" width="400">
      <v-card>
        <v-card-title class="grey darken-2">User</v-card-title>
        <v-container id="container">
          <v-text-field v-model="painter.firstName" label="First Name" outlined shaped></v-text-field>
          <v-text-field v-model="painter.lastName" label="Last Name" outlined shaped></v-text-field>
          <v-text-field v-model="painter.id" label="ID" outlined shaped></v-text-field>
          <v-text-field v-model="painter.dateOfBirth" label="Date of birth" outlined shaped></v-text-field>
          <v-text-field
            v-if="painter.dateOfDeath != undefined"
            v-model="painter.dateOfDeath"
            label="Date of death"
            outlined
            shaped
          ></v-text-field>
        </v-container>
        <v-card-actions>
          <v-spacer />
          <v-btn text color="primary" @click="previewUser = false">Close</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-app>
</template>



<script>
import ListComponent from "../components/ListComponent";
import Art from "../components/Art";
import api from "../components/backend-api";
export default {
  components: {
    ListComponent,

    Art
  },
  data: () => ({
    previewUser: false,
    valid: true,
    name: "",
    nameRules: [
      v => !!v || "Name is required",
      v => (v && v.length <= 10) || "Name must be less than 10 characters"
    ],
    email: "",
    emailRules: [
      v => !!v || "E-mail is required",
      v => /.+@.+\..+/.test(v) || "E-mail must be valid"
    ],
    select: null,
    items: ["Item 1", "Item 2", "Item 3", "Item 4"],
    checkbox: false,
    search: "",
    headers: [
      { text: "Name", value: "name" },
      { text: "Art Period", value: "artPeriod" },
      { text: "Creation Date", value: "creationDate" },
      { text: "Current Location", value: "currentLocation" },
      { text: "Show painter", value: "action" }
    ],
    paintnings: [],
    painter: ""
  }),
  mounted() {
    api
      .getAllPaintnings()
      .then(response => {
        this.paintnings = response.data;
      })
      .catch(e => {
        console.log(e);
      });
  },
  methods: {
    showPainter(item) {
      api
        .getPainter(item.painterId)
        .then(response => {
          this.painter = response.data;
          console.log(this.painter);
          this.previewUser = true;
        })
        .catch(e => {
          console.log(e);
        });
    },
    validate() {
      this.$refs.form.validate();
    },
    reset() {
      this.$refs.form.reset();
    },
    resetValidation() {
      this.$refs.form.resetValidation();
    }
  }
};
</script>


<style  scoped>
#vcard {
  margin-left: 1%;
}
#lu {
  margin-top: -5px;
}
.btnbtnbtn {
  color: #35424a;
  background-color: #35424a;
}
#duzme {
  margin-left: 10%;
  width: 100%;
  margin-top: 10%;
}
.duzme {
  margin-top: 11%;
  width: 100%;
}
#main-div {
  height: 85vh;
  background-color: #baffbb;
}
footer {
  margin-top: 0%;
  padding: 30px;
  height: 70px;
  color: #ffffff;
  background-color: #35424a;
  text-align: center;
}
#box-art {
  margin-left: 8%;
}
.box {
  margin-left: 2%;
  margin-right: 20px;
  width: 30%;
}
#div-flex {
  height: 75vh;
  padding-right: 0%;
  padding-top: 60px;
  margin-left: 0;
  margin-right: 20px;
  width: 100%;
  display: flex;
}
body {
  font: 15px/1.5 Arial, Helvetica, sans-serif;
  padding: 0;
  margin: 0;
}

/* Global */
.container {
  width: 80%;
  margin: auto;
  overflow: hidden;
}

.dark {
  padding: 15px;
  background: #35424a;
  color: #ffffff;
  margin-top: 10px;
  margin-bottom: 10px;
}

/* Header **/
header {
  background: #35424a;
  color: #ffffff;
  padding-top: 30px;
  margin-left: -20px;
  min-height: 70px;
  border-bottom: #e8491d 3px solid;
}

header a {
  color: #ffffff;
  text-decoration: none;
  text-transform: uppercase;
  font-size: 16px;
}

header li {
  float: left;
  display: inline;
  padding: 0 20px 0 20px;
}

header #branding {
  margin-top: -15px;

  float: left;
}

header #branding h1 {
  margin: 0;
}

header nav {
  float: right;
  margin-top: 10px;
}

header .highlight,
header .current a {
  color: #e8491d;
  font-weight: bold;
}

header a:hover {
  color: #cccccc;
  font-weight: bold;
}

/* insert styles here */
</style>