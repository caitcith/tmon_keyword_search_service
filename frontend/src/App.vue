<template>
  <div id="app">
    <div class="search-rank-box">
      <h1>검색어 순위</h1>
      <div v-if="hasResultTopKeywords">
        <div v-for="(topKeyword, index) in topKeywords" v-bind:key="topKeyword._id">
          <a>{{index + 1}}위 {{topKeyword._id}} - 조회수: {{topKeyword.count}}</a><br/>
        </div>
      </div>
    </div>
    <div class="left-box">
      <input v-model="keyword" placeholder="검색 키워드 입력">
      <button v-on:click="searchKeyword">검색하기</button>
      <div v-if="hasResult">
        <div v-for="location in locations" v-bind:key="location.id">
          <a v-on:click="viewLocationDetail($event, location)">{{location.place_name}}</a><br/>
        </div>
        <div v-if="hasResult">
          <b-pagination v-on:input="searchKeywordGet" size="sm"
                        v-bind:total-rows="totalRows"
                        :per-page="10"
                        v-model="currentPage" :hide-goto-end-buttons="true"
                        align="left">
          </b-pagination>
          <br>
        </div>
      </div>
    </div>
    <div class="right-box">
      <h2>상세 정보</h2>
      <div v-if="hasDetail">
        <ul>
          <li>장 소 명 : {{locationDetail.place_name}}</li>
          <li>카테고리 : {{locationDetail.category_name}}</li>
          <li>카테고리 그룹 : {{locationDetail.category_group_name}}</li>
          <li>전화번호 : {{locationDetail.phone}}</li>
          <li>지번주소 : {{locationDetail.address_name}}</li>
          <li>도로명주소: {{locationDetail.road_address_name}}</li>
          <li>경도 : {{locationDetail.x}}</li>
          <li>위도 : {{locationDetail.y}}</li>
          <li>홈페이지 :{{locationDetail.place_url}}</li>
        </ul>
      </div>
    </div>
  </div>
</template>
<script>

export default {
  mounted () {
    console.log('mounted this page')
    this.$nextTick(function () {
      this.getTopKeywords()
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
      topKeywords: [],
      locationDetail: undefined,
      submitSearchInfo: false
    }
  },
  computed: {
    hasResult: function () {
      return this.locations.length > 0
    },
    hasResultTopKeywords: function () {
      return this.topKeywords.length > 0
    },
    hasDetail: function () {
      return this.locationDetail
    }
  },
  methods: {
    getTopKeywords: function () {
      const baseURI = 'http://localhost:8080/keyword/top?limit=10'
      this.$http.get(`${baseURI}`)
        .then((result) => {
          this.topKeywords = result.data
          console.log(this.topKeywords)
        })
    },
    searchKeyword: function () {
      this.totalRows = 100
      this.currentPage = 1
      this.submitSearchInfo = true
      this.searchKeywordGet()
      this.getTopKeywords()
    },
    searchKeywordGet: function () {
      var self = this
      const baseURI = 'http://localhost:8080/keyword/search?keyword='
      fetch(`${baseURI}` + encodeURI(this.keyword) + '&page=' + this.currentPage + '&submitSearchInfo=' + this.submitSearchInfo)
        .then(function (response) {
          console.log(response)
          return response.json()
        })
        .then(function (result) {
          console.log(result)
          self.locations = result.documents
          self.isEnd = result.meta.is_end
          if (self.isEnd === true) {
            self.totalRows = 10 * self.currentPage
          }
        }).catch(function (error) {
          alert(error)
        })
      this.submitSearchInfo = false
    },
    viewLocationDetail: function (event, location) {
      this.locationDetail = location
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
  width: 100%;
  text-align:left;
  display: inline-block;
}
.search-rank-box {
  width: 34%;
  float: left;
}
.left-box {
  width: 33%;
  float: left;
}
.right-box {
  width: 33%;
  float: left;
}
</style>
