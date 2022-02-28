package edu.missouriwestern.agrant4.arrayDemo;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import static jakarta.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT;

/**
 * This is an example of using marshalling and unmarshalling
 * to convert XML to and from Java POJOs. Further, in this
 * example we demonstrate this while storing the objects
 * in a List/ArrayList.
 *
 * @authors:  Will Malita, Aaron Grant, Melissa Bayer, Christin Wilson
 * @since: February 2022
 */

public class ArrayParsing {
    public static void main(String[] args) {
        //Putting the web address into a String.
        String address = "https://civilserviceusa.github.io/us-states/data/states.xml";
        //Loading from the website and printing the ArrayList of State objects we created.
        System.out.println("\nCONVERTING TO ARRAYLIST OF OBJECTS");
        loadToObject(address);
        //I did not want to type (manually set) all the data, so ...
        //I store the ArrayList returned from Unmarshalling in this ArrayList of State objects.
        ArrayList<State> stList = loadToObject(address);
        //Then I create a new set of states....
        States sts = new States();
        //and set the collection of states to the State Objects list (which is the ArrayList of State Objects).
        sts.setStates(stList);
        System.out.println("\nCONVERTING ARRAYLIST OF OBJECTS TO XML\n Please look in toXML.xml");
        loadToXML(sts);
    } //End of main method.

    /**
     * The loadToObject function loads XML from a URL address and
     * uses JAXB unmarshalling to convert it to an ArrayList of Java Objects.
     * @param address
     * @return
     */
    public static ArrayList<State> loadToObject(String address) {
        ArrayList<State> stList = new ArrayList<State>();
        try {
            //Setting to the new instance of the XML Annotated class.
            JAXBContext jaxbContext = JAXBContext.newInstance(States.class);
            //Creating the URL to read from address.
            URL url = new URL(address);
            //Creating the Unmarshaller.
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            //Unmarshalling the URL and mapping it to the XML Annotated class States.
            States sts = (States) jaxbUnmarshaller.unmarshal(url);
            //For each state inside the States List, sts.getStates(), print out its corresponding data.
            for(State st : sts.getStates()) {
                System.out.println(st);
                stList.add(st);
            } //End of for/each.
            //JAXBContext.newInstance() throws an Exception.
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        } //End of generic catch.
        return stList;
    } //End of loadToObject.

    /**
     * The loadToXML function uses JAXB Marshalling to
     * write an ArrayList of Java Objects to an XML file.
     * @param states
     */
    public static void loadToXML(States states) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(States.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(JAXB_FORMATTED_OUTPUT, true);
            //jaxbMarshaller.marshal(states, System.out);
            jaxbMarshaller.marshal(states, new File("toXML.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        } //End of catch.
    } //End of loadToXML.
} //End of ArrayParsing class.
