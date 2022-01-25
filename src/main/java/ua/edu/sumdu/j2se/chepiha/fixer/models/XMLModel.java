package ua.edu.sumdu.j2se.chepiha.fixer.models;

import ua.edu.sumdu.j2se.chepiha.fixer.models.Group.Group;
import ua.edu.sumdu.j2se.chepiha.fixer.services.JaxbObjectToXML;
import ua.edu.sumdu.j2se.chepiha.fixer.services.JaxbXMLToObject;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class XMLModel {
    String fileIn;
    String fileOut;
    Group group;


    public XMLModel() {
        group = new Group();
    }

    public void setFileIn(String fileIn) {
        this.fileIn = fileIn;
    }

    public void setFileOut(String fileOut) {
        this.fileOut = fileOut;
    }

    public String getFileIn() {
        return fileIn;
    }

    public String getFileOut() {
        return fileOut;
    }

    public String getFullFileIn() {
        return "xml/load/"+ getFileIn() +".xml";
    }

    public String getFullFileOut() {
        return "xml/load/"+ getFileOut() +".xml";
    }

    public void startCopy(){
        try{
            group = JaxbXMLToObject.main(getFullFileIn());
            VerifyRules verifyRules = new VerifyRules(true);
            verifyRules.verifyAverage(group);
            JaxbObjectToXML.main(getFullFileOut(), group);
        } catch (JAXBException | XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
