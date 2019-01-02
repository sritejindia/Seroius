package com.company.tests.behavior;

import com.company.tests.core.CommonActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class SelectByVisibleText extends SelectABS {
    public SelectByVisibleText(String by) {
        switch (by) {
            case "id":
                selectBehavior = new SelectByIDWithVisibleText();
                break;
            case "css":
                selectBehavior = new SelectByCssWithVisibleText();
                break;
            case "xpath":
                selectBehavior = new SelectByXPathWithVisibleText();
                break;
            case "name":
                selectBehavior = new SelectByNameWithVisibleText();
                break;
            default:
                System.out.println("select locator not supported");
        }
    }
}

class SelectByIDWithVisibleText implements SelectBehavior {

    @Override
    public void selectDropdown(String locator, String option) {
        WebElement webElement = CommonActions.getWebElementById(locator);
        Select select = new Select(webElement);
        select.selectByVisibleText(option);
    }
}

class SelectByNameWithVisibleText implements SelectBehavior {

    @Override
    public void selectDropdown(String locator, String option) {
        WebElement webElement = CommonActions.getWebElementByName(locator);
        Select select = new Select(webElement);
        select.selectByVisibleText(option);
    }
}

class SelectByXPathWithVisibleText implements SelectBehavior {

    @Override
    public void selectDropdown(String locator, String option) {
        WebElement webElement = CommonActions.getWebElementByXPath(locator);
        Select select = new Select(webElement);
        select.selectByVisibleText(option);
    }
}

class SelectByCssWithVisibleText implements SelectBehavior {

    @Override
    public void selectDropdown(String locator, String option) {
        WebElement webElement = CommonActions.getWebElementByCss(locator);
        Select select = new Select(webElement);
        select.selectByVisibleText(option);
    }
}
