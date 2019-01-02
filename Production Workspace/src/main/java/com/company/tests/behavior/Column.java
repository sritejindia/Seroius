package com.company.tests.behavior;

import org.openqa.selenium.WebElement;

public class Column {
    String rowNum;
    String colNum;
    Row row;
    WebElement columnElement;

    public String getRowNum() {
        return rowNum;
    }

    public Column setRowNum(String rowNum) {
        this.rowNum = rowNum;
        return this;
    }

    public String getColNum() {
        return colNum;
    }

    public Column setColNum(String colNum) {
        this.colNum = colNum;
        return this;
    }

    public WebElement getColumnElement() {
        return columnElement;
    }

    public Column setColumnElement(WebElement columnElement) {
        this.columnElement = columnElement;
        return this;
    }

    public Row getRow() {
        return row;
    }

    public Column setRow(Row row) {
        this.row = row;
        return this;
    }
}
