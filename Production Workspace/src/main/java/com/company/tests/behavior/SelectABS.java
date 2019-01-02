package com.company.tests.behavior;

import org.openqa.selenium.WebDriver;

public abstract class SelectABS {
    SelectBehavior selectBehavior;

    public SelectBehavior getSelectBehavior() {
        return selectBehavior;
    }

    public SelectABS setSelectBehavior(SelectBehavior selectBehavior) {
        this.selectBehavior = selectBehavior;
        return this;
    }

    public void selectDropdown(String locator, String option) {
        selectBehavior.selectDropdown(locator, option);
    }
}
