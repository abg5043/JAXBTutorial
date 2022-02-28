package edu.missouriwestern.agrant4.nestedDemo;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import javax.xml.stream.XMLStreamException;
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
public class NestedXMLDemo
{
    public static void main( String[] args ) throws FileNotFoundException, JAXBException, XMLStreamException {

        //This is an example of unmarshalling a nested XML
        File nestedXML = new File("KSTJ.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(CurrentObservation.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        CurrentObservation currentObservation = (CurrentObservation) jaxbUnmarshaller.unmarshal(nestedXML);
        System.out.println(currentObservation);

        //This is an example of marshalling a nested XML
        jaxbContext = JAXBContext.newInstance(CurrentObservation.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
        jaxbMarshaller.setProperty( Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "http://www.weather.gov/view/current_observation.xsd");
        jaxbMarshaller.marshal( currentObservation, new File ("newObservations.xml"));
        jaxbMarshaller.marshal( currentObservation, System.out);
    }
}
