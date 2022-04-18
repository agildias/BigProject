package com.agildias.StepDefinition;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Hook {
    public static WebDriver webDriver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().deleteAllCookies();
        webDriver.get("https://staging.cicle.app/");
        webDriver.manage().window().maximize();

        ChromeOptions chrome_options = new ChromeOptions();

//        chrome_options.addArguments("--disable-extensions");
//        chrome_options.addArguments("--disable-popup-blocking");
//        chrome_options.addArguments("--profile-directory=Default");
//        chrome_options.addArguments("--ignore-certificate-errors");
//        chrome_options.addArguments("--disable-plugins-discovery");
//		chrome_options.addArguments("--incognito");
//        chrome_options.addArguments("user_agent=DN");
//        chrome_options.addArguments("user-data-dir=C:\\Users\\agild\\AppData\\Local\\Google\\Chrome\\User Data");
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
//        webDriver = new ChromeDriver(chrome_options);
//        webDriver.get("https://staging.cicle.app/");
//        webDriver.manage().window().maximize();

    }

    @After
    public void closeBrowser() {
        webDriver.quit();

    }
}
