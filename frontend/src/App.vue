<template>
  <div id="app">
    <div v-if="hasResultTopKeywords">
      <div v-for="(topKeyword, index) in topKeywords" v-bind:key="topKeyword._id">
        <a>{{index + 1}}위 검색어 : {{topKeyword._id}} 검색회수 : {{topKeyword.count}}<a/><br/>
      </div>
    </div>
    <input v-model="keyword" placeholder="검색 키워드 입력">
    <button v-on:click="searchKeyword">검색하기</button>
    <div v-if="hasResult">
      <div v-for="location in locations" v-bind:key="location.id">
        <a v-on:click="viewLocationDetail($event, location)">{{location.place_name}}</a><br/>
      </div>
      <div v-if="hasResult">
        <b-pagination v-on:input="searchPage" size="lg"
                      v-bind:total-rows="totalRows"
                      :per-page="10"
                      v-model="currentPage" :hide-goto-end-buttons="true"
                      next-text="다음" prev-text="이전" align="center">
        </b-pagination>
        <br>
      </div>
    </div>
  </div>
</template>
<script>

export default {
  mounted () {
    console.log('mounted this page')
    this.$nextTick(function () {
      const baseURI = 'http://localhost:8080/keyword/top?limit=10'
      this.$http.get(`${baseURI}`)
        .then((result) => {
          this.topKeywords = result.data
          console.log(this.topKeywords)
        })
    })
  },
  name: 'app',
  data: function () {
    return {
      locations: [],
      keyword: '',
      currentPage: 1,
      isEnd: true,
      totalRows: 100,
      topKeywords: []
    }
  },
  computed: {
    hasResult: function () {
      return this.locations.length > 0
    },
    hasResultTopKeywords : function () {
      return this.topKeywords.length > 0
    }
  },
  methods: {
    searchPage: function () {
      const baseURI = 'http://localhost:8080/keyword/search?keyword='
      this.$http.get(`${baseURI}` + this.keyword + '&page=' + this.currentPage)
        .then((result) => {
          console.log(result)
          this.locations = result.data.documents
          this.isEnd = result.data.meta.is_end
          if (this.isEnd === true) {
            this.totalRows = 10 * this.currentPage
          }
        })
    },
    searchKeyword: function () {
      this.currentPage = 1
      const baseURI = 'http://localhost:8080/keyword/search?keyword='
      this.$http.get(`${baseURI}` + this.keyword + '&page=' + this.currentPage + '&submitSearchInfo=true')
        .then((result) => {
          console.log(result)
          this.locations = result.data.documents
          this.totalRows = 100
          this.isEnd = result.data.meta.is_end
          if (this.isEnd === true) {
            this.totalRows = 10 * this.currentPage
          }
        })
    },
    viewLocationDetail: function (event, location) {
      let locationInfo = location.address_name + '\n'

      alert(locationInfo)
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
.location-list-item {

}
</style>
