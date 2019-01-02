package com.company.tests.behavior;

import org.openqa.selenium.WebDriver;

public class Open {
    public void launch(WebDriver currentWebDriver, String value) {
        currentWebDriver.get(value);
        currentWebDriver.manage().window().maximize();
    }
}
