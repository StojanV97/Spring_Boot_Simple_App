<template>
  <div id="main-div">
    <header>
      <div class="container">
        <div id="branding">
          <h1>
            <span class="highlight">Art</span> Museum
          </h1>
        </div>
        <nav>
          <ul>
            <li class="current">
              <a>Table View</a>
            </li>
            <li>
              <a>Tutorial</a>
            </li>
            <li>
              <a>Help</a>
            </li>
          </ul>
        </nav>
      </div>
    </header>
    <div id="div-flex">
      <div class="box">
        <ListComponent />

        <div class="my-2">
          <v-btn x-large color="warning" dark class="duzme">Add Painter</v-btn>
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
        <Art />
        <div class="my-2">
          <v-btn x-large color="warning" dark class="duzme">Add Art</v-btn>
        </div>
      </div>
    </div>
    <footer>
      <p>Painter and their arts, Copyright Mihanine &copy; 2020</p>
    </footer>
  </div>
</template>


<style  scoped>
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
  margin-top: 5%;
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

<script>
import ListComponent from "../components/ListComponent";
import Art from "../components/Art";
export default {
  components: {
    ListComponent,
    Art
  },
  data: () => ({
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
    checkbox: false
  }),

  methods: {
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

