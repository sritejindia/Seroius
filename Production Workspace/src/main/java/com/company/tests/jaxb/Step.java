package com.company.tests.jaxb;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "step")
@XmlAccessorType(XmlAccessType.FIELD)
public class Step {

    @XmlAttribute(name = "id")
    String id;

    @XmlAttribute(name = "status")
    String status;

    @XmlElement(name = "action", type = Action.class)
    List<Action> actionList;

    public String getId() {
        return id;
    }

    public Step setId(String id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Step setStatus(String status) {
        this.status = status;
        return this;
    }

    public List<Action> getActionList() {
        return actionList;
    }

    public Step setActionList(List<Action> actionList) {
        this.actionList = actionList;
        return this;
    }
}
