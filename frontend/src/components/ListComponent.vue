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
    <v-data-table :headers="headers" :items="items" :search="search" height="190px">
      <template v-slot:item.avatar="{ item }">
        <v-avatar>
          <v-img :src="item.avatar"></v-img>
        </v-avatar>
      </template>
      <template v-slot:item.actionShow="{ item }">
        <v-icon medium @click="deleteItem(item)">mdi-arrow-right-bold</v-icon>
      </template>
      <template v-slot:item.info="{ item }">
        <v-icon medium @click="deleteItem(item)">mdi-account</v-icon>
      </template>
      <template v-slot:item.actionEdit="{ item }">
        <v-icon medium @click="deleteItem(item)">mdi-pencil</v-icon>
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
export default {
  data: () => ({
    search: "",
    headers: [
      { text: "Avatar", value: "avatar" },
      { text: "Name", value: "title" },
      { text: "Edit", value: "actionEdit" },
      { text: "Del", value: "delete" },
      { text: "Details", value: "info" },
      { text: "Art", value: "actionShow" }
    ],
    items: [
      {
        active: true,
        title: "Jason",
        avatar: require("../assets/Salvador-Dali-828x1024.jpg")
      },
      {
        active: true,
        title: "Ranee",
        avatar: "https://cdn.vuetifyjs.com/images/lists/2.jpg"
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
  })
};
</script>