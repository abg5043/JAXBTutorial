package edu.missouriwestern.agrant4.simpleDemo;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

/**
 * This app demonstrates how to use JAXB to turn a simple xml file into an object (unmarshall)
 * and then a java object into an xml file (marshall)
 *
 * @since February 2022
 * @author Aaron Grant Christin Wilson, Will Malita, and Melissa Bayer
 *
 */
public class SimpleXMLDemo
{
    public static void main( String[] args ) {

        //try-catch catches JAXBException
        try {
            //This is an example of unmarshalling with a simple XML
            File simpleXML = new File("zz_woz.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Credentials.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Credentials credentials = (Credentials) jaxbUnmarshaller.unmarshal(simpleXML);
            System.out.println(credentials);

            //This is an example of taking that same object and marshalling it into an xml file with a simple XML
            Password password = new Password();
            password.setPass("Bad Pass");
            password.setXhint("Best hint ever");
            Credentials newCredentials = new Credentials(
                "missouriwestern.edu",
                "587398",
                "Team Awesome",
                password
            );
            jaxbContext = JAXBContext.newInstance(Credentials.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
            jaxbMarshaller.marshal( newCredentials, new File ("newCredentials.xml"));
            jaxbMarshaller.marshal( newCredentials, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
