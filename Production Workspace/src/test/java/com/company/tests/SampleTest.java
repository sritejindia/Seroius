package com.company.tests;

import com.company.tests.core.ActionExecutor;
import com.company.tests.core.CommonActions;
import com.company.tests.core.CommonFunctions;
import com.company.tests.jaxb.Action;
import com.company.tests.jaxb.Step;
import com.company.tests.jaxb.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import com.company.tests.jaxb.ReadFromJAXB;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SampleTest {

    public static final String IN_PROGRESS = "In Progress";
    public static final String PASSED = "Passed";
    public static final String FAILED = "Failed";

    @ParameterizedTest
    @DisplayName("This is my first fucking testy77")
    @ValueSource(strings = {"TC100"})
    public void myFirstTest(String testCasePath) {
        TestCase testCase = ReadFromJAXB.readFromJAXBContext(testCasePath);

        if(null != testCase) {
            CommonFunctions.log("**************************************************");
            CommonFunctions.log("Found testcase :" + testCase.getId() + " : " + testCase.getSummary());
            CommonFunctions.log("Number of steps: " + testCase.getSteps().getStepList().size());
            CommonFunctions.log("Current status is :" + testCase.getStatus());

            testCase.setStatus(IN_PROGRESS);

            try {
                for (Step step : testCase.getSteps().getStepList()) {
                    CommonFunctions.log("Executing step: " + step.getId());
                    step.setStatus(IN_PROGRESS);
                    try {

                        for (Action action: step.getActionList()) {
                            CommonFunctions.log("Executing action: " + action.getName());
                            if(!action.getEvent().startsWith("verify")) {
                                new ActionExecutor().executeAction(action);
                            } else {
                                String expectedValue = action.getValue();
                                String actualValue= CommonActions.getElementText(action.getBy(), action.getLocator());

                                assertEquals(expectedValue, actualValue,"Both are unequal");

                            }
                        }

                        step.setStatus(PASSED);
                    } catch (Exception e) {
                        step.setStatus(FAILED);
                    } finally {
                        CommonFunctions.log("Step "+ step.getId() + " status is " + step.getStatus());
                    }
                }
                testCase.setStatus(PASSED);
            } catch (Exception e) {
                testCase.setStatus(FAILED);
            }
            finally {
                CommonFunctions.log("Final status is :" + testCase.getStatus());
            }
        }

        else {
            fail("No valid testcase found in the "+ testCasePath +".xml");
        }
    }

}
