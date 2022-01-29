package com;

import com.model.Tokens;
import com.model.User;
import com.model.UserRegisterResponse;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserOperations {

    public static final String EMAIL_POSTFIX = "@yandex.ru";

    /*
     метод регистрации нового пользователя
     возвращает мапу с данными: имя, пароль, имэйл
     если регистрация не удалась, возвращает пустую мапу
     */
    @Step("Register user using API-request")
    public static Map<String, String> register(User user) {

        // создаём и заполняем мапу для передачи трех параметров в тело запроса
        Map<String, String> inputDataMap = new HashMap<>();
        inputDataMap.put("email", user.getEmail());
        inputDataMap.put("password", user.getPassword());
        inputDataMap.put("name", user.getName());

        // отправляем запрос на регистрацию пользователя и десериализуем ответ в переменную response
        UserRegisterResponse response = given()
                .spec(Base.getBaseSpec())
                .and()
                .body(inputDataMap)
                .when()
                .post("auth/register")
                .body()
                .as(UserRegisterResponse.class);

        // возвращаем мапу с данными
        Map<String, String> responseData = new HashMap<>();
        if (response != null) {
            responseData.put("email", response.getUser().getEmail());
            responseData.put("name", response.getUser().getName());
            responseData.put("password", user.getPassword());

            // токен, нужный для удаления пользователя, кладем в статическое поле класса с токенами
            // убираем слово Bearer в начале токена
            // так же запоминаем refreshToken
            Tokens.setAccessToken(response.getAccessToken().substring(7));
            Tokens.setRefreshToken(response.getRefreshToken());
        }
        return responseData;
    }

    //метод авторизации пользователя
    @Step("Log in user using API-request")
    public static Map<String, String> login(User user) {
        Map<String, String> inputDataMap = new HashMap<>();
        inputDataMap.put("email", user.getEmail());
        inputDataMap.put("password", user.getPassword());
        inputDataMap.put("name", user.getName());

        UserRegisterResponse response = given()
                .spec(Base.getBaseSpec())
                .and()
                .body(inputDataMap)
                .when()
                .post("auth/login")
                .body()
                .as(UserRegisterResponse.class);

        Map<String, String> responseData = new HashMap<>();
        if (response != null) {
            responseData.put("email", response.getUser().getEmail());
            responseData.put("name", response.getUser().getName());
            responseData.put("password", user.getPassword());
            responseData.put("success", String.valueOf(response.isSuccess()));

            Tokens.setAccessToken(response.getAccessToken().substring(7));
            Tokens.setRefreshToken(response.getRefreshToken());
        }
        return responseData;
    }

    /*
     метод удаления пользователя по токену, возвращенному после создания
     пользователя. Удаляем только в случае, если token заполнен.
     */
    @Step("Delete user using API-request")
    public static void delete() {
        if (Tokens.getAccessToken() == null) {
            return;
        }
        given()
                .spec(Base.getBaseSpec())
                .auth().oauth2(Tokens.getAccessToken())
                .when()
                .delete("auth/user")
                .then()
                .statusCode(202);
    }
}
