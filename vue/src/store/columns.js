import axios from "axios";

const api = "http://localhost:8080/api/v1/data";

let config = {
  headers: {
    Accept: "application/json",
    "Access-Control-Allow-Origin": "*",
  },
};

const state = {
  columns: [],
  result: [],
};

const getters = {
  getColumns: (state) => state.columns,
  getResult: (state) => state.result,
};

const actions = {
  async fetchColumns({ commit, state }) {
    const response = await axios.get(api, config);
    commit("setColumns", response.data);
  },
  async sendCol({ commit }, send) {
    const response = await axios.get(api + `/${send.opcja}/${send.item}`);
    commit("setResult", response.data);
  },
};

const mutations = {
  setColumns: (state, columns) => (state.columns = columns),
  setResult: (state, result) => (state.result = result),
};

export default {
  state,
  getters,
  actions,
  mutations,
};
