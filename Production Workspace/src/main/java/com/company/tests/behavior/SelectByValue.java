package com.company.tests.behavior;

import com.company.tests.core.CommonActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class SelectByValue extends SelectABS {
    public SelectByValue(String by) {
        switch (by) {
            case "id":
                selectBehavior = new SelectByIDWithValue();
                break;
            case "css":
                selectBehavior = new SelectByCssWithValue();
                break;
            case "xpath":
                selectBehavior = new SelectByXPathWithValue();
                break;
            case "name":
                selectBehavior = new SelectByNameWithValue();
                break;
            default:
                System.out.println("select locator not supported");
        }
    }
}

class SelectByIDWithValue implements SelectBehavior {

    @Override
    public void selectDropdown(String locator, String option) {
        WebElement webElement = CommonActions.getWebElementById(locator);
        Select select = new Select(webElement);
        select.selectByValue(option);
    }
}

class SelectByNameWithValue implements SelectBehavior {

    @Override
    public void selectDropdown(String locator, String option) {
        WebElement webElement = CommonActions.getWebElementByName(locator);
        Select select = new Select(webElement);
        select.selectByValue(option);
    }
}

class SelectByXPathWithValue implements SelectBehavior {

    @Override
    public void selectDropdown(String locator, String option) {
        WebElement webElement = CommonActions.getWebElementByXPath(locator);
        Select select = new Select(webElement);
        select.selectByValue(option);
    }
}

class SelectByCssWithValue implements SelectBehavior {

    @Override
    public void selectDropdown(String locator, String option) {
        WebElement webElement = CommonActions.getWebElementByCss(locator);
        Select select = new Select(webElement);
        select.selectByValue(option);
    }
}
