<template>
  <v-card id="tabla">
    <v-card-title>
      Painters
      <v-spacer></v-spacer>
      <v-text-field
        v-model="search"
        append-icon="mdi-magnify"
        label="Search"
        single-line
        hide-details
      ></v-text-field>
    </v-card-title>
    <v-data-table :headers="headers" :items="$props.painter" :search="search" height="190px">
      <template v-slot:item.avatar="{ item }">
        <v-img draggable height="30px" width="30px" src="../assets/Salvador-Dali-828x1024.jpg" />
      </template>
      <template v-slot:item.actionShow="{ item }">
        <v-icon medium @click="show(item)">mdi-arrow-right-bold</v-icon>
      </template>
      <template v-slot:item.info="{ item }">
        <v-icon medium @click="preview(item)">mdi-account</v-icon>
      </template>
      <template v-slot:item.actionEdit="{ item }">
        <v-icon medium @click="edit(item)">mdi-pencil</v-icon>
      </template>
      <template v-slot:item.delete="{ item }">
        <v-icon medium @click="deleteItem(item)">mdi-delete</v-icon>
      </template>
    </v-data-table>
  </v-card>
</template>

<style  scoped>
#tabla {
  width: 100%;
  padding: 20px;
}
</style>
<script>
import api from "../components/backend-api";

export default {
  props: ["painter"],
  data: () => ({
    search: "",
    headers: [
      { text: "Avatar", value: "avatar" },
      { text: "Name", value: "firstName" },
      { text: "Edit", value: "actionEdit" },
      { text: "Del", value: "delete" },
      { text: "Details", value: "info" },
      { text: "Art", value: "actionShow" }
    ],

    items: [
      {
        active: true,
        title: "Ranee",
        avatar: "../assets/Salvador-Dali-828x1024.jpg"
      },
      {
        title: "Cindy",
        avatar: "https://cdn.vuetifyjs.com/images/lists/3.jpg"
      },
      {
        title: "Ali",
        avatar: "https://cdn.vuetifyjs.com/images/lists/4.jpg"
      }
    ],
    items2: [
      {
        title: "Travis",
        avatar: "https://cdn.vuetifyjs.com/images/lists/5.jpg"
      }
    ]
  }),
  methods: {
    getImgUrl(path) {
      var images = require.context("../assets/", false, /\.jpg$/);
      return images("./" + path);
    },
    show(item) {
      this.$emit("painterEvent", item);
      localStorage.setItem("artistId", item.painterId);
    },
    deleteItem(item) {
      api.deletePainter(item.id).then(response => {
        this.$emit("deleteEvent");
      });
    },
    edit(item) {
      console.log(item);
      this.$emit("editPainterEvent", item);
    },
    preview(item) {
      this.$emit("previewPainter", item);
    }
  }
};
</script>