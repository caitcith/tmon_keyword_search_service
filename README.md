[APPLICATION CUURENT VERSION] <br>
-0.0.1.SNAPSHOT

[SPRING BOOT VERSION] <br>
-2.0.5.RELEASE

[테스트 BULD 환경]<br>
o JDK 1.8 or later<br>
o Maven 3.2+<br>
o mysql-server-community-5.7.24.0<br>
o mongodb v4.0.4<br>
o nodejs v8.14.0<br>
o git<br>
o npm package version<br>
"@vue/cli": "^3.2.1"<br>
"axios": "^0.18.0"<br>
"bootstrap-vue": "^2.0.0-rc.11"<br>
"es6-promise": "^4.2.5"<br>
"vue": "^2.5.17"<br>
"vue-router": "^3.0.1"<br>

[BUILD 및 실행]
# mysql-installer-community-5.7.24.0 설치(설치시 TCP/IP Port 3306로 설정), mongodb v4.0.4 설치, nodejs v8.14.0 설치
# git 설치
# mysql 5.7 database 생성 및 유저 설정
#*루트유저 로그인  > mysql -uroot -p <br>
#*db_exmaple database 생성 <br>
mysql> CREATE SCHEMA `db_exmaple` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci; <br>
#*springuser 추가 mysql> create user 'springuser'@'%' identified by 'qwer1234'; <br>
#* springuser에게 database 권한(모든 권한) 추가 #*mysql> grant all on db_example.* to 'springuser'@'%'; <br>

#* Macosx mongodb 설치 방법 
#* sudo brew install mongodb
#* Windows -> https://www.mongodb.com/download-center/community 에서 v4.0.4 download 후 설치
#* 돋보기 -> 서비스 검색 -> MongoDB Server 실행 확인(미 실행시 실행)
# mongod 

# git clone https://github.com/caitcith/tmon_keyword_search_service.git
# cd tmon_keyword_search_service
# cd frontend
# npm install --save vue
# npm run build
# cd ..
# chmod 0755 mvnw
# spring boot 실행
#* local 환경에서 실행 <br>
./mvnw spring-boot:run -P local 
#* release 환경에서 실행 <br>
./mvnw spring-boot:run -P release 
