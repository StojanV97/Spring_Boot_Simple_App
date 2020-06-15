<template>
  <v-card id="tabla">
    <v-card-title>
      {{$props.painter}}
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
      <template v-slot:item.delete="{ item }">
        <v-icon medium @click="deleteItem(item)">mdi-delete</v-icon>
      </template>
      <template v-slot:item.actionEdit="{ item }">
        <v-icon medium @click="deleteItem(item)">mdi-pencil</v-icon>
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
  props: ["painter"],
  data: () => ({
    search: "",
    headers: [
      { text: "Name", value: "name" },
      { text: "Edit", value: "actionEdit" },
      { text: "Delete", value: "delete" }
    ],
    items: [
      {
        active: true,
        title: "Jason Oner",
        avatar: "https://cdn.vuetifyjs.com/images/lists/1.jpg"
      },
      {
        active: true,
        title: "Ranee Carlson",
        avatar: "https://cdn.vuetifyjs.com/images/lists/2.jpg"
      },
      {
        title: "Cindy Baker",
        avatar: "https://cdn.vuetifyjs.com/images/lists/3.jpg"
      },
      {
        title: "Ali Connors",
        avatar: "https://cdn.vuetifyjs.com/images/lists/4.jpg"
      }
    ],
    items2: [
      {
        title: "Travis Howard",
        avatar: "https://cdn.vuetifyjs.com/images/lists/5.jpg"
      }
    ]
  })
};
</script>