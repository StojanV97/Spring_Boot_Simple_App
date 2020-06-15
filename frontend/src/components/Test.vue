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
                <v-btn class="btnbtnbtn" @click="$router.push('/tutorial')">Tutorial</v-btn>
              </li>

            </ul>
          </nav>
        </div>
      </header>
      <div id="div-flex">
        <div class="box">
          <ListComponent
            @previewPainter="previewPainter($event)"
            @editPainterEvent="editPainter($event)"
            @deleteEvent="updatePainters"
            @painterEvent="openPaintings($event)"
            v-bind:painter="painters"
          />
          <div class="my-2">
            <v-btn
              x-large
              color="warning"
              dark
              class="duzme"
              @click="addPainterFunction"
            >Add Painter</v-btn>
          </div>
        </div>
        <div class="box">
          <v-img
            src="./../assets/world.jpg"
            :aspect-ratio="16/9"
            height="74%"
            width="120%"
            max-width="630"
          ></v-img>

          <div class="my-2">
            <v-btn x-large color="error" dark id="duzme">Clear Map</v-btn>
          </div>
        </div>
        <div class="box" id="box-art">
          <Art
            @deleteSlikaEvent="deleteSlika($event)"
            @detailsSlikaEvent="detailsSlika($event)"
            @eeee="editSlika($event)"
            v-bind:painterArt="painterr"
          />
          <div class="my-2">
            <v-btn
              x-large
              color="warning"
              dark
              class="duzme"
              :disabled="addArtDisabled == false"
              @click="addArtFunction"
            >Add Art</v-btn>
          </div>
        </div>
      </div>
      <footer>
        <p>Painter and their arts, Copyright Mihanine &copy; 2020</p>
      </footer>
    </div>
    <v-dialog v-model="showAddPainter" width="1200">
      <v-card>
        <v-card-title class="grey darken-2">User</v-card-title>
        <v-container>
          <AddPainter />
        </v-container>
        <v-card-actions>
          <v-spacer />
          <v-btn text color="primary" @click="showAddPainter = false">Close</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
    <v-dialog v-model="editPainterDialog" width="1200">
      <v-card>
        <v-card-title class="grey darken-2">Edit Painter</v-card-title>
        <v-container>
          <EditPainter v-bind:painter="pejnter2" />
        </v-container>
        <v-card-actions>
          <v-spacer />
          <v-btn text color="primary" @click="editPainterDialog = false">Close</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
    <v-dialog v-model="previewUser" width="400">
      <v-card>
        <v-card-title class="grey darken-2">User</v-card-title>
        <v-container id="container">
          <PreviewPainter v-bind:painter="pejnter" />
        </v-container>
        <v-card-actions>
          <v-spacer />
          <v-btn text color="primary" @click="previewUser = false">Close</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
    <v-dialog v-model="showDetailsSlika" width="800">
      <v-card>
        <v-card-title class="grey darken-2">Art</v-card-title>
        <v-container>
          <PreviewArt v-bind:art="art" />
        </v-container>
        <v-card-actions>
          <v-spacer />
          <v-btn text color="primary" @click="showDetailsSlika = false">Close</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
    <v-dialog v-model="editSlikaDialog" width="800">
      <v-card>
        <v-card-title class="grey darken-2">Art</v-card-title>
        <v-container>
          <EditArt v-bind:art="art" />
        </v-container>
        <v-card-actions>
          <v-spacer />
          <v-btn text color="primary" @click="editSlikaDialog = false">Close</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
    <v-dialog v-model="addArtDialog" width="800">
      <v-card>
        <v-card-title class="grey darken-2">Add Art</v-card-title>
        <v-container>
          <AddArt />
        </v-container>
        <v-card-actions>
          <v-spacer />
          <v-btn text color="primary" @click="addArtDialog = false">Close</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-app>
</template>



<script>
import ListComponent from "../components/ListComponent";
import Art from "../components/Art";
import api from "../components/backend-api";
import AddPainter from "../components/AddPainter";
import EditPainter from "../components/EditPainter";
import PreviewPainter from "../components/PreviewPainter";
import PreviewArt from "../components/PreviewArt";
import EditArt from "../components/EditArt";
import AddArt from "../components/AddArt";

export default {
  components: {
    ListComponent,
    Art,
    AddPainter,
    EditPainter,
    PreviewPainter,
    PreviewArt,
    EditArt,
    AddArt
  },
  data: () => ({
    addArtDialog: false,
    showDetailsSlika: false,
    art: "",
    editSlikaDialog: false,
    previewUser: false,
    editPainterDialog: false,
    addArtDisabled: false,
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
    painters: [],
    painterr: "",
    showAddPainter: false,
    pejnter: "",
    pejnter2: ""
  }),

  mounted() {
    console.log("Mounted");
    api
      .getAllPainters()
      .then(response => {
        console.log(response.data);
        this.painters = response.data;
        console.log("asdasdsds");
      })
      .catch(e => {
        console.log(e);
      });
  },
  methods: {
    validate() {
      this.$refs.form.validate();
    },
    reset() {
      this.$refs.form.reset();
    },
    resetValidation() {
      this.$refs.form.resetValidation();
    },
    openPaintings(event) {
      this.addArtDisabled = true;
      console.log(event);
      this.painterr = event;
    },
    updatePainters() {
      api
        .getAllPainters()
        .then(response => {
          console.log(response.data);
          this.painters = response.data;
          this.painterr = [];
          this.addArtDisabled = false;
        })
        .catch(e => {
          console.log(e);
        });
    },
    addPainterFunction() {
      this.showAddPainter = true;
    },
    editPainter(event) {
      this.pejnter2 = event;
      this.editPainterDialog = true;

      console.log(this.pejnter2);
      //   api
      //     .editPainter(event.id)
      //     .then(response => {
      //       this.painters = response.data;
      //     })
      //     .cath(e => {});
    },
    previewPainter(event) {
      this.previewUser = true;
      this.pejnter = event;
    },
    editSlika(event) {
      console.log("EVENT");
      this.editSlikaDialog = true;
      this.art = event;
    },
    detailsSlika(event) {
      this.showDetailsSlika = true;
      console.log(event);
      this.art = event;
    },
    deleteSlika(event) {
      api
        .deleteArt(event.id)
        .then(response => {})
        .catch(e => {});
    },
    addArtFunction() {
      this.addArtDialog = true;
    }
  }
};
</script>


<style  scoped>
.duzme:disabled,
button[disabled] {
  border: 1px solid #999999;
  background-color: black;
  color: black;
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
  background-color: #baffbb;
}
footer {
  margin-top: 0%;
  padding: 20px;
  height: 70px;
  color: #ffffff;
  background-color: #35424a;
  text-align: center;
}
#box-art {
  margin-left: 8%;
}
.box {
  margin-left: 1%;
  margin-right: 20px;
  width: 30%;
}
#div-flex {
  height: 80vh;
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

@media screen and (max-width: 1366px) {
  /* insert styles here */
  footer {
    margin-top: 10%;
    padding: 30px;
    height: 70px;
    color: #ffffff;
    background-color: #35424a;
    text-align: center;
  }
}
@media screen and (max-width: 1280px) {
  footer {
    margin-top: 10%;
    padding: 30px;
    height: 70px;
    color: #ffffff;
    background-color: #35424a;
    text-align: center;
  }
  /* insert styles here */
}
</style>
