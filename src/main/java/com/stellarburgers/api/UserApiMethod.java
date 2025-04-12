package com.stellarburgers.api;

import com.google.gson.Gson;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import static com.stellarburgers.api.ApiConstants.*;


public class UserApiMethod extends BaseApiMethod {
    private static final Gson gson = new Gson(); // Используем Gson для сериализации

   @Step("Запрос на создание пользователя")
    public String createUser(String email, String password, String name) {
        UserModel.UserData userData = new UserModel.UserData(email, password, name);
        String body = gson.toJson(userData);
       Response response = sendPostRequest(CREATE_USER_ENDPOINT,"", body);
       var responseData = response.as(ServerResponseModel.class);
       return responseData.accessToken;
    }

    @Step("Запрос на авторизацию пользователя")
    public Response loginUser(String email, String password, String name) {
        UserModel.UserData userData = new UserModel.UserData(email, password, name);
        String body = gson.toJson(userData);
        return sendPostRequest(LOGIN_USER_ENDPOINT,"", body);
    }


    @Step("Запрос на удаление пользователя")
    public void deleteUser(String accessToken) {
        if (accessToken!=null) {
            sendDeleteRequest(USER_INFO_ENDPOINT, accessToken);
        }
    }
    @Step("Запрос на логин и удаление пользователя")
    public void killUser(String email, String password, String name) {
        String ACCESS_TOKEN;
        Response response = new UserApiMethod().loginUser(email, password, name);
        var responseData = response.as(ServerResponseModel.class);
        ACCESS_TOKEN  = responseData.accessToken;
        new UserApiMethod().deleteUser(ACCESS_TOKEN);
    }

}
