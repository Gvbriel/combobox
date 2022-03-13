import { createApp } from "vue";
import App from "./App.vue";
import vSelect from "vue-select";
import ElementPlus from "element-plus";
import Vue from "vue";
import store from "./store";
import "element-plus/dist/index.css";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap";

const app = createApp(App);
app.component("v-select", vSelect);
app.use(ElementPlus);
app.use(store);
app.config.devtools = true;

app.mount("#app");
