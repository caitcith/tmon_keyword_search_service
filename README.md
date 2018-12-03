[APPLICATION CUURENT VERSION]
-0.0.1.SNAPSHOT

[SPRING BOOT VERSION]
-2.0.5.RELEASE

[테스트 BULD 환경]
o JDK 1.8 or later
o Maven 3.2+
o mysql-server-community-5.7.24.0
o mongodb v4.0.4
o nodejs v8.14.0
o git
o npm package version
"@vue/cli": "^3.2.1"
"axios": "^0.18.0"
"bootstrap-vue": "^2.0.0-rc.11"
"es6-promise": "^4.2.5"
"vue": "^2.5.17"
"vue-router": "^3.0.1"

[BUILD 및 실행]
1. mysql-installer-community-5.7.24.0 설치(설치시 TCP/IP Port 3306로 설정), mongodb v4.0.4 설치, nodejs v8.14.0 설치
2. mysql 5.7 database 생성 및 유저 설정
1) 루트유저 로그인  
> mysql -uroot -p 
2) db_exmaple database 생성
mysql> CREATE SCHEMA `db_exmaple` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
3) springuser 추가
mysql> create user 'springuser'@'%' identified by 'qwer1234'; 
4) springuser에게 database 권한(모든 권한) 추가
mysql> grant all on db_example.* to 'springuser'@'%'; 

3. mongod 실행

4. MaxOSX ctrl+shift 후 terminal.app 또는 windows 시작의 git bash(설치필요) 실행
5. git clone https://github.com/caitcith/tmon_keyword_search_service.git
6. cd tmon_keyword_search_service
7. cd frontend
8. npm install -save vue
9. npm run build
10. cd ..
11. chmod 0755 mvnw
12. ./mvnw spring-boot:run
   
[JAR 파일 실행]
