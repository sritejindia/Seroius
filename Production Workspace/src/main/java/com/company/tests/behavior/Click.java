package com.company.tests.behavior;

import com.company.tests.core.CommonActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class Click extends ClickABS {
    public Click(String by) {
        switch (by.toLowerCase()) {
            case "id":
                clickBehavior = new ClickByID();
                break;
            case "css":
                clickBehavior = new ClickByCss();
                break;
            case "xpath":
                clickBehavior = new ClickByXPath();
                break;
            case "name":
                clickBehavior = new ClickByName();
                break;
            case "linktext":
                clickBehavior = new ClickByLinkText();
                break;
            case "partiallinktext":
                clickBehavior = new ClickByPartialLinText();
                break;
            default:
                System.out.println("click locator not supported");
        }
    }

    private class ClickByLinkText implements ClickBehavior {
        @Override
        public void click(String locator) {
            CommonActions.getWebElementByLinkText(locator).click();
        }
    }

    private class ClickByPartialLinText implements ClickBehavior {
        @Override
        public void click(String locator) {
            CommonActions.getWebElementByPartialLinkText(locator).click();
        }
    }
    private class ClickByXPath implements ClickBehavior {
        @Override
        public void click(String locator) {
            CommonActions.getWebElementByXPath(locator).click();
        }
    }

    private class ClickByCss implements ClickBehavior {
        @Override
        public void click(String locator) {
            CommonActions.getWebElementByCss(locator).click();
        }
    }

    private class ClickByID implements ClickBehavior {
        @Override
        public void click(String locator) {
            CommonActions.getWebElementById(locator).click();
        }
    }

    private class ClickByName implements ClickBehavior {
        @Override
        public void click(String locator) {
            CommonActions.getWebElementByName(locator).click();
        }
    }
}

