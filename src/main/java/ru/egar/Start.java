package ru.egar;

import ru.xml.Specification;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

public class Start {
    public static final String DEFAULT_DATE_UNMARSHALLING_FILE = "specification.xml";

    public static InputStream getInputStream(String file) {
        ClassLoader classLoader = Start.class.getClassLoader();
        return classLoader.getResourceAsStream(file);
    }

    public static Specification unmarshalDates(InputStream inputFile) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Specification.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Specification) jaxbUnmarshaller.unmarshal(inputFile);
    }

    public static void main(String[] args) throws JAXBException {
        Specification specification = unmarshalDates(getInputStream(DEFAULT_DATE_UNMARSHALLING_FILE));
        System.out.println(specification);
    }
}

