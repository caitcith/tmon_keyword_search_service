<template>
  <div id="app">
    <input v-model="keyword" placeholder="검색 키워드 입력">
    <button v-on:click="searchTerm">검색하기</button>
    <div v-if="hasResult">
      <div v-for="location in locations" v-bind:key="location.id">
        <h2>{{location.place_name}}</h2>
      </div>
      <div v-if="hasResult">
        <b-pagination size="lg" :total-rows="100" v-model="currentPage" :per-page="10">
        </b-pagination>
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
      currentPage: 1
    }
  },
  computed: {
    hasResult: function () {
      return this.locations.length > 0
    }
  },
  methods: {
    searchTerm: function () {
      const baseURI = 'http://localhost:8080/keyword/search?keyword='
      this.$http.get(`${baseURI}` + this.keyword + '&page=' + this.currentPage)
        .then((result) => {
          console.log(result)
          this.locations = result.data.documents
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
