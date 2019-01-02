package com.company.tests.core;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class CommonActions {
    private static WebDriver mDriver;

    public synchronized static WebDriver getCurrentWebDriver() {

        if(null == mDriver) {
            try {
                mDriver = new SafariDriver();
                CommonFunctions.log("Initiating a new web driver instance.");
            } finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanUp()));
            }
        }
        return mDriver;
    }

    private static class BrowserCleanUp implements Runnable {
        @Override
        public void run() {
            close();
        }
    }

    public static void close() {
        try {
            getCurrentWebDriver().quit();
            mDriver = null;
            CommonFunctions.log("Closing the browser");
        }catch (UnreachableBrowserException e) {
            CommonFunctions.log("Unable to close the browser");
        }
    }

    public static String getElementText(String by, String locator) {
        String text=null;

        switch (by) {
            case "id":
                text = getWebElementById(locator).getText();
                break;
            case "name":
                text = getWebElementByName(locator).getText();
                break;
            case "xpath":
                text = getWebElementByXPath(locator).getText();
                break;
            case "css":
                text = getWebElementByCss(locator).getText();
                break;
            case "classname":
                text = getWebElementByClassName(locator).getText();
                break;
            case "linkText":
                text = getWebElementByLinkText(locator).getText();
                break;
            case "partialLinkText":
                text = getWebElementByPartialLinkText(locator).getText();
                break;
            case "tagName":
                text = getWebElementByTagName(locator).getText();
                break;
        }

        return text;
    }

    public static WebElement getWebElementById(String locator) {
        WebElement element=null;

        Wait webDriverWait = new FluentWait<WebDriver>(getCurrentWebDriver())
                .withTimeout(Duration.ofSeconds(20))
                .withMessage("Waiting for element with id: " + locator)
                .pollingEvery(Duration.ofSeconds(4))
                .ignoring(NoSuchElementException.class);

        element = (WebElement) webDriverWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id(locator));
            }
        });

        return element;
    }

    public static WebElement getWebElementByName(String locator) {
        WebElement element=null;

        Wait webDriverWait = new FluentWait<WebDriver>(getCurrentWebDriver())
                .withTimeout(Duration.ofSeconds(20))
                .withMessage("Waiting for element with id: " + locator)
                .pollingEvery(Duration.ofSeconds(4))
                .ignoring(NoSuchElementException.class);

        element = (WebElement) webDriverWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.name(locator));
            }
        });

        return element;
    }

    public static WebElement getWebElementByXPath(String locator) {
        WebElement element=null;

        Wait webDriverWait = new FluentWait<WebDriver>(getCurrentWebDriver())
                .withTimeout(Duration.ofSeconds(20))
                .withMessage("Waiting for element with id: " + locator)
                .pollingEvery(Duration.ofSeconds(4))
                .ignoring(NoSuchElementException.class);

        element = (WebElement) webDriverWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(locator));
            }
        });

        return element;
    }

    public static WebElement getWebElementByCss(String locator) {
        WebElement element=null;

        Wait webDriverWait = new FluentWait<WebDriver>(getCurrentWebDriver())
                .withTimeout(Duration.ofSeconds(20))
                .withMessage("Waiting for element with id: " + locator)
                .pollingEvery(Duration.ofSeconds(4))
                .ignoring(NoSuchElementException.class);

        element = (WebElement) webDriverWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.cssSelector(locator));
            }
        });

        return element;
    }

    public static WebElement getWebElementByLinkText(String locator) {
        WebElement element=null;

        Wait webDriverWait = new FluentWait<WebDriver>(getCurrentWebDriver())
                .withTimeout(Duration.ofSeconds(20))
                .withMessage("Waiting for element with id: " + locator)
                .pollingEvery(Duration.ofSeconds(4))
                .ignoring(NoSuchElementException.class);

        element = (WebElement) webDriverWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.linkText(locator));
            }
        });

        return element;
    }

    public static WebElement getWebElementByPartialLinkText(String locator) {
        WebElement element=null;

        Wait webDriverWait = new FluentWait<WebDriver>(getCurrentWebDriver())
                .withTimeout(Duration.ofSeconds(20))
                .withMessage("Waiting for element with id: " + locator)
                .pollingEvery(Duration.ofSeconds(4))
                .ignoring(NoSuchElementException.class);

        element = (WebElement) webDriverWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.partialLinkText(locator));
            }
        });

        return element;
    }

    public static WebElement getWebElementByClassName(String locator) {
        WebElement element=null;

        Wait webDriverWait = new FluentWait<WebDriver>(getCurrentWebDriver())
                .withTimeout(Duration.ofSeconds(20))
                .withMessage("Waiting for element with id: " + locator)
                .pollingEvery(Duration.ofSeconds(4))
                .ignoring(NoSuchElementException.class);

        element = (WebElement) webDriverWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.className(locator));
            }
        });

        return element;
    }

    public static WebElement getWebElementByTagName(String locator) {
        WebElement element=null;

        Wait webDriverWait = new FluentWait<WebDriver>(getCurrentWebDriver())
                .withTimeout(Duration.ofSeconds(20))
                .withMessage("Waiting for element with id: " + locator)
                .pollingEvery(Duration.ofSeconds(4))
                .ignoring(NoSuchElementException.class);

        element = (WebElement) webDriverWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.tagName(locator));
            }
        });

        return element;
    }
}
