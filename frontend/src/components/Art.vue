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
    <v-data-table
      :headers="headers"
      :items="$props.painterArt.arts"
      :search="search"
      height="190px"
    >
      <template v-slot:item.avatar="{ item }">
        <v-avatar>
          <v-img :src="item.avatar"></v-img>
        </v-avatar>
      </template>
      <template v-slot:item.delete="{ item }">
        <v-icon medium @click="deleteItem(item)">mdi-delete</v-icon>
      </template>
      <template v-slot:item.details="{ item }">
        <v-icon medium @click="details(item)">mdi-tooltip-image</v-icon>
      </template>
      <template v-slot:item.actionEdit="{ item }">
        <v-icon medium @click="edit(item)">mdi-pencil</v-icon>
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
  props: ["painterArt"],
  data: () => ({
    search: "",
    headers: [
      { text: "Name", value: "name" },
      { text: "Edit", value: "actionEdit" },
      { text: "Details", value: "details" },
      { text: "Delete", value: "delete" }
    ]
  }),
  methods: {
    edit(item) {
      this.$emit("eeee", item);
    },
    details(item) {
      this.$emit("detailsSlikaEvent", item);
    },
    deleteItem(item) {
      //console.log(item);
      this.$emit("deleteSlikaEvent", item);
      const index = this.$props.painterArt.arts.indexOf(item);
      if (index != -1) {
        this.$props.painterArt.arts.splice(index, 1);
      }
    }
  }
};
</script>