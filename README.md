[APPLICATION CUURENT VERSION]
-0.0.1.SNAPSHOT

[SPRING BOOT]
-2.0.5.RELEASE

[BULD 환경]
JDK 1.8 or later
Maven 3.2+
git

[BUILD 및 실행]
1. mysql-installer-community-5.7.24.0 설치(설치시 TCP/IP Port 10002로 설정)
2. database 생성 및 USER생성 및 DB 권한 추가(상세 명령어 추가 예정)
3. MaxOSX ctrl+shift 후 terminal.app 또는 windows 시작의 git bash(설치필요) 실행
4. git clone https://github.com/caitcith/tmon_keyword_search_service.git
5. cd tmon_keyword_search_service
6. 윈도우 : ./mvnw spring-boot:run
   MAXOSX : ./mvnw spring-boot:run
   
[JAR 파일 실행]