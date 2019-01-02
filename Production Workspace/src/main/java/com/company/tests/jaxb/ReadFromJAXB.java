package com.company.tests.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

public class ReadFromJAXB {
    public static TestCase readFromJAXBContext(String testCaseName) {
        TestCase testCase=null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TestCase.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Marshaller marshaller = jaxbContext.createMarshaller();
            InputStream inputStream = ReadFromJAXB.class.getResourceAsStream("/"+testCaseName+".xml");
            testCase = (TestCase) unmarshaller.unmarshal(inputStream);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return testCase;
        }

    }
}
