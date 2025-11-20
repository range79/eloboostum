# Eloboostum api
## This is a api for account boost for games like (valorant,cs2,etc..) 
* login -jwt(blacklist added)
* rare limiting added
* for docs open clone install run ant open https://localhost:8080/swagger-ui/index.html
## installation
### 1.clone the app
```shell
git clone https://github.com/range79/eloboostum
```

### 2. rename example.env to .env fill the env files

### 3. Run with this command if you run in some other IDE:
```shell
export $(grep -v '^#' src/main/resources/.env | xargs) && ./gradlew bootRun
```

### If you're using IntelliJ IDEA, add env file in app startup
