<template>
  <div>
    <MainWindow/>
  </div>
</template>

<script>
import MainWindow from "@/components/MainWindow";

export default {
  name: 'App',
  components: {
    MainWindow
  },

}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
