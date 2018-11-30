<template>
  <div id="app">
    <input v-model="keyword" placeholder="검색 키워드 입력">
    <button v-on:click="searchKeyword">검색하기</button>
    <div v-if="hasResult">
      <div v-for="location in locations" v-bind:key="location.id">
        <h2>{{location.place_name}}</h2>
      </div>
      <div v-if="hasResult">
        <b-pagination v-on:input="searchPage" size="lg"
                      v-bind:total-rows="total_row"
                      :per-page="10"
                      v-model="currentPage" :hide-goto-end-buttons="true"
                      next-text="next" prev-text="prev" align="center">
        </b-pagination>
        {{is_end}}
        <br>
      </div>
    </div>
  </div>
</template>
<script>

export default {
  name: 'app',
  data: function () {
    return {
      locations: [],
      keyword: '',
      currentPage: 1,
      is_end: true,
      total_row: 100
    }
  },
  computed: {
    hasResult: function () {
      return this.locations.length > 0
    }
  },
  methods: {
    searchPage: function () {
      const baseURI = 'http://localhost:8080/keyword/search?keyword='
      this.$http.get(`${baseURI}` + this.keyword + '&page=' + this.currentPage)
        .then((result) => {
          this.locations = result.data.documents
          this.is_end = result.data.meta.is_end
          if (this.is_end === true) {
            this.total_row = 10 * this.currentPage
          }
        })
    },
    searchKeyword: function () {
      this.currentPage = 1
      const baseURI = 'http://localhost:8080/keyword/search?keyword='
      this.$http.get(`${baseURI}` + this.keyword + '&page=' + this.currentPage)
        .then((result) => {
          this.locations = result.data.documents
          this.total_row = 100
          this.is_end = result.data.meta.is_end
          if (this.is_end === true) {
            this.total_row = 10 * this.currentPage
          }
        })
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  max-width: 560px;
  text-align:center;
}
</style>
