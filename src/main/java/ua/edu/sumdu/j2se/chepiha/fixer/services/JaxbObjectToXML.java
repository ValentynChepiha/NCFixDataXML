package ua.edu.sumdu.j2se.chepiha.fixer.services;

import ua.edu.sumdu.j2se.chepiha.fixer.models.Group.Group;
import ua.edu.sumdu.j2se.chepiha.fixer.models.Group.Student;
import ua.edu.sumdu.j2se.chepiha.fixer.models.Group.Subject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class JaxbObjectToXML {
    public static void main(String fileName, Group dataGroup) throws JAXBException {
        File file = new File(fileName);
        JAXBContext jaxbContext = JAXBContext.newInstance(Group.class, Student.class, Subject.class);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        jaxbMarshaller.marshal(dataGroup, file);
    }
}
