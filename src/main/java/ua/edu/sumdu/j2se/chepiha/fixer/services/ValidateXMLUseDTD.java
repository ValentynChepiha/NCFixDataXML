package ua.edu.sumdu.j2se.chepiha.fixer.services;

import java.io.IOException;

import javax.xml.parsers.*;

import org.xml.sax.*;

public class ValidateXMLUseDTD {

    // validate using SAX (DTD as defined in the XML)
    public static boolean validateUseSAX(String fileName)
            throws ParserConfigurationException, IOException
    {
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setValidating(true);
            factory.setNamespaceAware(true);

            SAXParser parser = factory.newSAXParser();

            XMLReader reader = parser.getXMLReader();
            reader.setErrorHandler(
                    new ErrorHandler() {
                        public void warning(SAXParseException e) throws SAXException {
                            System.out.println("WARNING : " + e.getMessage()); // do nothing
                        }

                        public void error(SAXParseException e) throws SAXException {
                            System.out.println("ERROR : " + e.getMessage());
                            throw e;
                        }

                        public void fatalError(SAXParseException e) throws SAXException {
                            System.out.println("FATAL : " + e.getMessage());
                            throw e;
                        }
                    }
            );
            reader.parse( new InputSource(fileName) );
            return true;
        }
        catch (ParserConfigurationException pce) {
            throw pce;
        }
        catch (IOException io) {
            throw io;
        }
        catch (SAXException se){
            return false;
        }
    }

}
