package com;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class TestConfig {

    private static String browser = "yandex";

    public static void apply() {

        if (TestConfig.browser.equals("yandex")) {
            File yandexDriverExecutable = new File("/WebDriver\\bin\\yandexdriver.exe");
            System.setProperty("webdriver.chrome.driver", yandexDriverExecutable.getAbsolutePath());
        }

        Configuration.browser = TestConfig.browser;
        WebDriverRunner.setWebDriver(new ChromeDriver());
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
}
