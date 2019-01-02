package com.company.tests.behavior;

import org.openqa.selenium.WebDriver;

public abstract class ClickABS  {
    ClickBehavior clickBehavior;

    public ClickBehavior getClickBehavior() {
        return clickBehavior;
    }

    public ClickABS setClickBehavior(ClickBehavior clickBehavior) {
        this.clickBehavior = clickBehavior;
        return this;
    }

    public void performClick(String locator) {
        clickBehavior.click(locator);
    }
}
