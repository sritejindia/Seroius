package com.company.tests.behavior;

import com.company.tests.core.CommonActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class SelectByIndex extends SelectABS {
    public SelectByIndex(String by) {
        switch (by) {
            case "id":
                selectBehavior = new SelectByIDWithIndex();
                break;
            case "css":
                selectBehavior = new SelectByCssWithIndex();
                break;
            case "xpath":
                selectBehavior = new SelectByXPathWithIndex();
                break;
            case "name":
                selectBehavior = new SelectByNameWithIndex();
                break;
            default:
                System.out.println("select locator not supported");
        }
    }
}

class SelectByIDWithIndex implements SelectBehavior {

    @Override
    public void selectDropdown(String locator, String option) {

        WebElement webElement = CommonActions.getWebElementById(locator);
        Select select = new Select(webElement);
        select.selectByIndex(Integer.valueOf(option));
    }
}

class SelectByNameWithIndex implements SelectBehavior {

    @Override
    public void selectDropdown(String locator, String option) {
        WebElement webElement = CommonActions.getWebElementByName(locator);
        Select select = new Select(webElement);
        select.selectByIndex(Integer.valueOf(option));
    }
}

class SelectByXPathWithIndex implements SelectBehavior {

    @Override
    public void selectDropdown(String locator, String option) {
        WebElement webElement = CommonActions.getWebElementByXPath(locator);
        Select select = new Select(webElement);
        select.selectByIndex(Integer.valueOf(option));
    }
}

class SelectByCssWithIndex implements SelectBehavior {

    @Override
    public void selectDropdown(String locator, String option) {
        WebElement webElement = CommonActions.getWebElementByCss(locator);
        Select select = new Select(webElement);
        select.selectByIndex(Integer.valueOf(option));
    }
}
