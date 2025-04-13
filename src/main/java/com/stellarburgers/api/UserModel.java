package com.stellarburgers.api;

import lombok.AllArgsConstructor;
import lombok.Data;

public class UserModel {
    // Класс для хранения данных пользователя
    @Data
    @AllArgsConstructor
    public static class UserData {
        private String email;
        private String password;
        private String name;
    }
}