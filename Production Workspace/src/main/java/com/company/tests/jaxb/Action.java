package com.company.tests.jaxb;


import javax.xml.bind.annotation.*;

@XmlRootElement(name = "action")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
public class Action {

    String event;
    String by;
    String locator;
    String name;
    String value;
    boolean result; // only for verify action

    @XmlAttribute(name = "event")
    public String getEvent() {
        return event;
    }

    public Action setEvent(String event) {
        this.event = event;
        return this;
    }

    @XmlAttribute(name = "name")
    public String getName() {
        return name;
    }

    public Action setName(String name) {
        this.name = name;
        return this;
    }

    @XmlAttribute(name = "by")
    public String getBy() {
        return by;
    }

    public Action setBy(String by) {
        this.by = by;
        return this;
    }

    @XmlAttribute(name = "locator")
    public String getLocator() {
        return locator;
    }

    public Action setLocator(String locator) {
        this.locator = locator;
        return this;
    }

    @XmlAttribute(name = "value")
    public String getValue() {
        return value;
    }

    public Action setValue(String value) {
        this.value = value;
        return this;
    }

    @XmlAttribute(name = "result")
    public boolean getResult() {
        return result;
    }

    public Action setResult(boolean result) {
        this.result = result;
        return this;
    }

    @Override
    public String toString() {
        return "Perfom " + event + " at location: " + locator + " by " + by +" with value: " + value;
    }
}
