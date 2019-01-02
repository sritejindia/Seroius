package com.company.tests.behavior;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Row {
    String rowNum;
    WebElement element;
    List<Column> columns;

    public String getRowNum() {
        return rowNum;
    }

    public Row setRowNum(String rowNum) {
        this.rowNum = rowNum;
        return this;
    }

    public WebElement getElement() {
        return element;
    }

    public Row setElement(WebElement element) {
        this.element = element;
        return this;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public Row setColumns(List<Column> columns) {
        this.columns = columns;
        return this;
    }
}
