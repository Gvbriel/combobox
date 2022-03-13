<template>
  <div class="container">
    <div>
      <h5>Wybierz z Comobobox'a kolumne oraz odpowiednia opcje:</h5>
      <el-select v-model="item" placeholder="Wybierz kolumne">
        <el-option
            v-for="item in getColumns"
            :key="item"
            :label="item"
            :value="item"
        ></el-option>
      </el-select>
    </div>
    <div>
      <button class="btn-primary rounded m-1" @click="sendColumn('UNIQUE')">Unikalne</button>
      <button class="btn-primary rounded m-1" @click="sendColumn('DUPLICATES')">Duplikaty</button>
    </div>
    <div class="row">
      <Table :items="getResult"/>
    </div>
  </div>
</template>

<script>
import {mapActions, mapGetters} from "vuex";
import Table from "@/components/Table";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Column",
  components: {Table},
  data() {
    return {
      item: 'kolumna1',
    }
  },
  methods: {
    ...mapActions(['fetchColumns', 'sendCol']),
    sendColumn(opcja) {
      let send = {
        opcja: opcja,
        item: this.item
      }
      this.sendCol(send)
    }
  },
  computed: mapGetters(['getColumns', 'getResult']),
  created() {
    this.fetchColumns()
  }
}
</script>

<style scoped>

</style>