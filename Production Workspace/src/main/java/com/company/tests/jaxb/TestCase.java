package com.company.tests.jaxb;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "testcase")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"id","summary","description","steps"})
public class TestCase {
    String status;
    String id;
    String summary;
    String description;
    Steps steps;

    @XmlAttribute(name = "status")
    public String getStatus() {
        return status;
    }

    public TestCase setStatus(String status) {
        this.status = status;
        return this;
    }

    @XmlElement(name = "id")
    public String getId() {
        return id;
    }

    public TestCase setId(String id) {
        this.id = id;
        return this;
    }

    @XmlElement(name = "summary")
    public String getSummary() {
        return summary;
    }

    public TestCase setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    @XmlElement(name = "description")
    public String getDescription() {
        return description;
    }

    public TestCase setDescription(String description) {
        this.description = description;
        return this;
    }

    @XmlElement(name = "steps", type = Steps.class)
    public Steps getSteps() {
        return steps;
    }

    public TestCase setSteps(Steps steps) {
        this.steps = steps;
        return this;
    }
}
