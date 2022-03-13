<template>
  <div class="w-50 mx-auto mt-4">
    <table>
      <tbody>
      <tr v-for="(item, i) of items" :key="i">
        <td v-for="(td, j) of item" :key="i + '-' + j" class="p-1">
          {{ items[i][j] }}
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Table",
  props: {
    items: Array
  }
}
</script>

<style scoped>
table, th, td {
  border: 1px solid black;
}
</style>