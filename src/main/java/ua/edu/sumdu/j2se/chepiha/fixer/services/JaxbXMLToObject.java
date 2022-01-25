package ua.edu.sumdu.j2se.chepiha.fixer.services;

import ua.edu.sumdu.j2se.chepiha.fixer.models.Group.Group;
import ua.edu.sumdu.j2se.chepiha.fixer.models.Group.Student;
import ua.edu.sumdu.j2se.chepiha.fixer.models.Group.Subject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;

public class JaxbXMLToObject {
    public static Group main(String fileName) throws JAXBException, XMLStreamException, IOException {
        Group group = new Group();

        JAXBContext jaxbContext = JAXBContext.newInstance(Group.class, Student.class, Subject.class);

        XMLInputFactory xif = XMLInputFactory.newFactory();
        xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
        XMLStreamReader xsr = xif.createXMLStreamReader(new StreamSource(fileName));

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        group = (Group) jaxbUnmarshaller.unmarshal(xsr);

        return group;
    }
}
