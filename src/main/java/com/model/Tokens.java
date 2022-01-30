package com.model;

import com.codeborne.selenide.WebDriverRunner;


public class Tokens {
    private static String accessToken;
    private static String refreshToken;
    private static String accessTokenName = "accessToken";
    private static String refreshTokenName = "refreshToken";
    private static String accessTokenPrefix = "Bearer ";


    public static String getAccessToken() {
        return accessToken;
    }

    public static void setAccessToken(String accessToken) {
        Tokens.accessToken = accessToken;
    }

    public static String getRefreshToken() {
        return refreshToken;
    }

    public static void setRefreshToken(String refreshToken) {
        Tokens.refreshToken = refreshToken;
    }

    public static void cleanTokens() {
        Tokens.accessToken = null;
        Tokens.refreshToken = null;
    }

    public static void setTokensInLocalStorage() {

        String jsCommand = "localStorage.setItem(arguments[0], arguments[1]);";
        WebDriverRunner.driver().executeJavaScript(jsCommand, accessTokenName, accessTokenPrefix + accessToken);
        WebDriverRunner.driver().executeJavaScript(jsCommand, refreshTokenName, refreshToken);
    }

    public static void clearLocalStorage() {
        WebDriverRunner.driver().executeJavaScript("localStorage.clear()");
    }
}
