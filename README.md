[APPLICATION CUURENT VERSION]
-0.0.1.SNAPSHOT

[SPRING BOOT]
-2.0.5.RELEASE

[BULD 환경]
JDK 1.8 or later
Maven 3.2+
mongodb v4.0.4 
git
"@vue/cli": "^3.2.1"
"axios": "^0.18.0"
"bootstrap-vue": "^2.0.0-rc.11"
"es6-promise": "^4.2.5"
"vue": "^2.5.17"
"vue-router": "^3.0.1"

[BUILD 및 실행]
1. mysql-installer-community-5.7.24.0 설치(설치시 TCP/IP Port 3306로 설정)
2. database 생성 및 USER생성 및 DB 권한 추가(상세 명령어 추가 예정)
3. MaxOSX ctrl+shift 후 terminal.app 또는 windows 시작의 git bash(설치필요) 실행
4. git clone https://github.com/caitcith/tmon_keyword_search_service.git
5. cd tmon_keyword_search_service
6. cd frontend
7. npm install -save vue
8. npm run build
9. cd ..
10. chmod 0755 mvnw
11. ./mvnw spring-boot:run
   
[JAR 파일 실행]
