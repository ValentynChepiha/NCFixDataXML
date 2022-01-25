package ua.edu.sumdu.j2se.chepiha.fixer.controllers;

import ua.edu.sumdu.j2se.chepiha.fixer.services.ValidateXMLUseDTD;
import ua.edu.sumdu.j2se.chepiha.fixer.models.XMLModel;
import ua.edu.sumdu.j2se.chepiha.fixer.views.XMLView;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XMLController {

    XMLModel model = null;
    XMLView view = null;

    public XMLController() {
        model = new XMLModel();
        view = new XMLView();
    }

    public void run(){
        view.loadString("Input data file name (*.xml): ");
        model.setFileIn(view.getLoadedString());

        view.loadString("Input result file name (*.xml): ");
        model.setFileOut(view.getLoadedString());

        try {
            boolean validate = ValidateXMLUseDTD.validateUseSAX(model.getFullFileIn());

            if(validate){
                model.startCopy();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
