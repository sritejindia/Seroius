package com.company.tests.core;

import com.company.tests.jaxb.Action;
import com.company.tests.behavior.*;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActionExecutor {
    public void executeAction(Action action) {
        switch (action.getEvent().toLowerCase()) {
            case "open":
                new Open().launch(CommonActions.getCurrentWebDriver(),action.getValue());
                break;
            case "click":
                Click click = new Click(action.getBy());
                click.performClick(action.getLocator());
                CommonFunctions.log("Performed click:" + action.getName());
                break;
            case "selectbytext":
                SelectByVisibleText selectByVisibleText = new SelectByVisibleText(action.getBy());
                selectByVisibleText.selectDropdown(action.getLocator(), action.getValue());
                CommonFunctions.log("Selected dropdown text:" + action.getValue());
                break;
            case "selectbyvalue":
                SelectByValue selectByValue = new SelectByValue(action.getBy());
                selectByValue.selectDropdown(action.getLocator(), action.getValue());
                CommonFunctions.log("Selected dropdown value:" + action.getValue());
                break;
            case "selectbyindex":
                SelectByIndex selectByIndex = new SelectByIndex(action.getBy());
                selectByIndex.selectDropdown(action.getLocator(), action.getValue());
                CommonFunctions.log("Selected dropdown index:" + action.getValue());
                break;
            case "table-click":
                String locator = action.getLocator();
                String[] tokens = locator.split(";");
                String tableString = tokens[0];
                String rowString = tokens[1];
                String columnString = tokens[2];
                CommonFunctions.log(tableString);
                CommonFunctions.log(rowString);
                CommonFunctions.log(columnString);

                Pattern pattern = Pattern.compile("\\((.*?)\\)");

                Matcher matcher = pattern.matcher(tableString);
                while (matcher.find()) {
                    CommonFunctions.log("Star is : " + matcher.group(1));
                }


                break;
            default:
                CommonFunctions.log("Invalid action event: " + action.getEvent());

        }
    }
}
