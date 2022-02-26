package edu.missouriwestern.agrant4;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, JAXBException {
        File simpleXML = new File("zz_woz.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Credentials.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Credentials credentials = (Credentials) jaxbUnmarshaller.unmarshal(simpleXML);
        System.out.println(credentials);
    }
}
