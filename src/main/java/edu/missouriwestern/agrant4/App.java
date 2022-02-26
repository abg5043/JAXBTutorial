package edu.missouriwestern.agrant4;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This app demonstrates how to use JAXB to turn an xml file into an object (unmarshall)
 * and then a java object into an xml file (marshall)
 *
 * @since February 2022
 * @author Aaron Grant Christin Wilson, Will Malita, and Melissa Bayer
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, JAXBException {

        //This is an example of unmarshalling
        File simpleXML = new File("zz_woz.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Credentials.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Credentials credentials = (Credentials) jaxbUnmarshaller.unmarshal(simpleXML);
        System.out.println(credentials);

        //This is an example of taking that same object and marshalling it into an xml file
        Credentials newCredentials = new Credentials(
            "missouriwestern.edu",
            "587398",
            "best hint ever",
            "Team Awesome",
            "BadPass"
            );

        JAXBContext jaxbContext2 = JAXBContext.newInstance(Credentials.class);
        Marshaller jaxbMarshaller = jaxbContext2.createMarshaller();

        jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

        jaxbMarshaller.marshal( newCredentials, new File ("newCredentials.xml"));
        jaxbMarshaller.marshal( newCredentials, System.out);


    }
}
