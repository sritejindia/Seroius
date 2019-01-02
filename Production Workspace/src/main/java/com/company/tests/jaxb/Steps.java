package com.company.tests.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "steps")
@XmlAccessorType(XmlAccessType.FIELD)
public class Steps {

    @XmlElement(name = "step", type = Step.class)
    List<Step> stepList;

    public List<Step> getStepList() {
        return stepList;
    }

    public Steps setStepList(List<Step> stepList) {
        this.stepList = stepList;
        return this;
    }
}
