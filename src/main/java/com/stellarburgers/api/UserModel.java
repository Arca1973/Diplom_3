package com.stellarburgers.api;

public class UserModel {// Класс для хранения данных пользователя
    public static class UserData {
        private String email;
        private String password;
        private String name;

        public UserData(String email, String password, String name) {
            this.email = email;
            this.password = password;
            this.name = name;
        }
    }
}