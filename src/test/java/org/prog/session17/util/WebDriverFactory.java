package org.prog.session17.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {

    public static WebDriver getDriver() throws MalformedURLException {
        String envType = System.getProperty("env.type", "local");
        if ("local".equalsIgnoreCase(envType)) {
            return new ChromeDriver();
        } else if ("grid".equalsIgnoreCase(envType)) {
            return new RemoteWebDriver(
                    new URL("http://localhost:4444/"), new ChromeOptions());
        } else if ("jenkins".equalsIgnoreCase(envType)) {
            return new RemoteWebDriver(
                    new URL("http://selenium-hub:4444/"), new ChromeOptions());
        } else {
            throw new RuntimeException("Unknown env type. Set env.type=local OR env.type=jenkins");
        }
    }
}
