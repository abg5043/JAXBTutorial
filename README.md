
# JAXBTutorial
## What is JAXB?
JAXB stands for Java Architecture XML Binding. It is a tool that is used by Java developers to map Java to XML representations. Today, JAXB  is also  known as Jakarta XML binding.<br/><br/>

## Removal of JAXB from the Java JDK:
JAXB became a part of the JDK in Java 6. In Java 11 (2018), JAXB was removed from the JDK. 
- JAXB is still a part of the JDK in Java 6,7, and 8.
- JAXB is still a part of Java 9 and 10 but it has been disabled or not included in the module path. 
- In Java 11 it is completely removed.

Versions exist:  JAXB 1.0 &  JAXB 2.0, Jakarta 3.0<br/><br/>

## Since it has been removed:
JAXB (Jakarta XML Binding) can still be utilized. To do so, you will need to use the following dependencies. 
We learned that different versions of the dependencies will require different import statements. 

````Java

<!-- JAXB API only -->
  <dependency>
      <groupId>jakarta.xml.bind</groupId>
      <artifactId>jakarta.xml.bind-api</artifactId>
      <version>3.0.0</version>
  </dependency>

  <!-- JAXB RI, Jakarta XML Binding -->
  <dependency>
      <groupId>com.sun.xml.bind</groupId>
      <artifactId>jaxb-impl</artifactId>
      <version>3.0.0</version>
      <scope>runtime</scope>
  </dependency>

```` 
<br/>

## The two main features/operations of JAXB are: 
- **````Marshalling```` -> converting a Java Object into XML** 
- **```` Unmarshalling```` -> converting XML to a Java Object** 
<br/>

## JAXB Annotations and their meaning:
JAXB uses JAXB Annotations in classes to be able to use the above features. The annotations below are ones we use throughout this tutorial.

We use this XML in our first example, however, I am going to use it here to better explain these annotations:
````XML
<?xml version="1.0"?>
  <credentials>
      <host>woz.cs.missouriwestern.edu</host>
      <port>33006</port> <!--This isn't the right port, by the way -->
      <user>csc</user>
      <password xhint="room where woz is located It definitily is not '!😈湯🦊🚴'">********</password>
  </credentials>
````
- @XmlRootElement : Its purpose is to uniquely associate a root element in XML with a Java class. For instance, credentials holds host, password, port, and user elements, credentials is the root element. We create classes based upon our root element(s).

- @XmlElement : is an XML element derived from a property name. For example, ````<host>missouriwestern.edu</host>```` is an element.

- @XmlAttribute : is an XML attribute derived from content within the element. For instance, in ````<password xhint="room where woz is located It definitily is not '!😈湯🦊🚴'">********</password>>```` 'xhint' is the attribute. Attributes usually play the role of informative, giving more information about the XML elements.

- @XmlValue : is the value of an attribute. For instance, in ````<password xhint="room where woz is located It definitily is not '!😈湯🦊🚴'">********</password>>````the value of the 'xhint' is "room where woz is located It definitily is not '!😈湯🦊🚴".

- @XmlAccessorType : Defines the fields and properties of the Java classes that JAXB will use for binding. 

<br/>  


## Example 1: Simple XML File (simple)
  - This is the XML we will be Unmarshalling & Marshalling.
  ````XML
  <?xml version="1.0"?>
  <credentials>
      <host>woz.cs.missouriwestern.edu</host>
      <port>33006</port> <!--This isn't the right port, by the way -->
      <user>csc</user>
      <password xhint="room where woz is located It definitily is not '!😈湯🦊🚴'">********</password>
  </credentials>
````
#### Unmarshalling (XML to Java Object)
  - Step 1: Create a POJO with JAXB Annotations.
````Java 
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "credentials" )
public class Credentials {

  //Create fields for every xml attribute and element
  private String host;
  private String port;
  private String user;
  private Password password;
  
  //Create constructor and pass in all elements
  public Credentials(String host, String port, String user, Password password) {
    this.host = host;
    this.port = port;
    this.user = user;
    this.password = password;
  } //End of constructor.

  //To make JAXB work, we need a no-arg constructor
  public Credentials() {};

  //Any element with annotations need to be objects with their own annotations.
  
  //Always put XML annotations for elements above the setter for each field.  
  @XmlElement( name = "host")
  
  public void setHost(String host) {
    this.host = host;
  } //End of setHost.
  
  public String getHost() {
    return host;
  } //End of getHost.
  
  /* --- REMAINING GETTERS & SETTERS --- */
  
  /* --- TO STRING --- */
    //I would suggest making a toString so that you can easily read & print the object.
} //End of Credentials class.

````
- Step 2: Create another class so that we can grab the 'xhint' attribute and its value.

  Explanation: @XmlAttribute grabs the attribute but not the value. We must make a new class for the element that contains the attribute and its value. This is why we make another class called password. Here we can grab the attribute and its value. In summary,  if you want to extract the value of an attribute you have to make an object for the specific element. 
````XML
 <password xhint="room where woz is located It definitily is not '!😈湯🦊🚴'">********</password>
````
````Java
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Password {
  @XmlAttribute(name = "xhint")
  private String xhint;

  @XmlValue
  private String pass;

  public String getPass() {
    return pass;
  } //End of getPass.

  public void setPass(String pass) {
    this.pass = pass;
  } //End of setPass.

  public String getXhint() {
    return xhint;
  } //End of getXhint.

  public void setXhint(String xhint) {
    this.xhint = xhint;
  } //End of setXhint.

  @Override
  public String toString() {
    return "Password{" +
        "xhint='" + xhint + '\'' +
        ", pass='" + pass + '\'' +
        '}';
  } //End of toString.
} //End of Password class.
````
-  Step 3: Unmarshalling in the main.
````Java
public static void main( String[] args ) {

        //try-catch catches JAXBException
        try {
            //This is an example of unmarshalling with a simple XML
            //Here we are reading it in from a local file.
            File simpleXML = new File("zz_woz.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Credentials.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Credentials credentials = (Credentials) jaxbUnmarshaller.unmarshal(simpleXML);
            System.out.println(credentials);
         } catch (JAXBException e) {
            e.printStackTrace();
            System.exit(1);
        } //End of catch.
    } //End of main.
````
- Credentials printed to console:
````Java
Credentials {user=csc, password=Password{xhint='room where woz is located It definitily is not '!😈湯🦊🚴'', pass='********'}, host=woz.cs.missouriwestern.edu, port=33006,  }
````

#### Marshalling (Java Object to XML)
  - When we marshal we will use the above Credentials and Password classes.

````Java
public static void main( String[] args ) {

 //try-catch catches JAXBException
  try {
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
        } //End of catch.
    } //End of main.
````
- Output in 'newCredentials.xml' file:
````XML
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<credentials>
    <host>missouriwestern.edu</host>
    <password xhint="Best hint ever">Bad Pass</password>
    <port>587398</port>
    <user>Team Awesome</user>
</credentials>
````

<br/>

## Example 2: Nested XML File (complex)
- We will be loading the XML from this [local weather url](https://w1.weather.gov/xml/current_obs/KSTJ.xml). The url contains the local weather in the form of nested XML.
#### Unmarshalling (XML to Java Object)
  - Step 1: Make the first XML annotated class
 ````Java
 import jakarta.xml.bind.annotation.*;

/**
 * This class is the root class for an xml file of current observations.
 */
@XmlRootElement(name = "current_observation")
//This annotation means that we put the annotations above the field names instead of setters
@XmlAccessorType(XmlAccessType.FIELD)
public class CurrentObservation {
  //Create fields for every xml attribute and element
  @XmlAttribute(name = "version")
  private double version;
  /*
   * You cannot unmarshal the xsi:noNamespaceSchemaLocation annotation, but you can instruct the marshaller
   * to include it as notated in the App.java file. Similarly, notice the package-info.java file that tells the marshaller
   * to include other information about namespace. You cannot, though, seem to be able to import that information
   * with the unmarshaller.
   */
  @XmlElement( name = "credit")
  private String credit;
  @XmlElement( name = "credit_URL")
  private String creditUrl;
  //For elements with nested elements, make the parent element an object
  //Each of the nested elements will be @XmlElements within that object
  @XmlElement( name = "image")
  private Image image;
  @XmlElement( name = "suggested_pickup")
  private String suggestedPickup;
  @XmlElement( name = "suggested_pickup_period")
  private int suggestedPickupPeriod;
  /* --- AND THE REST OF THE ELEMENTS HERE--- */
  
  //To make JAXB work, we need a no-arg constructor
  public CurrentObservation() {}
 
 //Then you can make another constructor that can take in arguments.
 public CurrentObservation(double version, String credit, String creditUrl, Image image, String suggestedPickup, 
 int suggestedPickupPeriod, String location, String stationID, double latitude, double longitude, String observationTime, 
 String observationTimeRFC822, String weather, String temperatureString, double tempF, double tempC, int relativeHumidity, 
 String windString, String windDir, int windDegrees, double windMPH, int windKT, String pressureString, 
 double pressureMB, double pressureIn, String dewpointString, double dewPointF, double dewPointC, 
 double visibilityMi, String iconURLBase, String twoDayHistoryUrl, String iconUrlName, String obUrl, S
 tring disclaimerUrl, String copyrightUrl, String privacyPolicyUrl) {
    this.credit = credit;
    this.creditUrl = creditUrl;
    this.image = image;
    this.suggestedPickup = suggestedPickup;
    this.suggestedPickupPeriod = suggestedPickupPeriod;
    //The rest here...
} //End of the CurrentObservation constructor.


/* --- ALL GETTERS & SETTERS HERE --- */ 
  
/* --- TOSTRING HERE--- */ 
  
 ````
  - Step 2 : Make another XML annotated class.
 ````Java
 import jakarta.xml.bind.annotation.XmlElement;

public class Image {
  private String url;
  private String title;
  private String link;

  public String getUrl() {
    return url;
  }

  @XmlElement( name = "url")
  public void setUrl(String url) {
    this.url = url;
  }

  public String getTitle() {
    return title;
  }

  @XmlElement( name = "title")
  public void setTitle(String title) {
    this.title = title;
  }

  public String getLink() {
    return link;
  }

  @XmlElement( name = "link")
  public void setLink(String link) {
    this.link = link;
  }

  @Override
  public String toString() {
    return "Image{" +
        "url='" + url + '\'' +
        ", title='" + title + '\'' +
        ", link='" + link + '\'' +
        '}';
  }
}
 ````
 - Step 3 : Make a package.
 
   Explanation: You must have a package like this if you want to specify the namespace. 
 
````Java
@XmlSchema(
    elementFormDefault = XmlNsForm.QUALIFIED,
    xmlns={
        @XmlNs(prefix="xsd", namespaceURI="http://www.w3.org/2001/XMLSchema"),
        @XmlNs(prefix="xsi", namespaceURI="http://www.w3.org/2001/XMLSchema-instance")
    }
)

package edu.missouriwestern.agrant4.nestedDemo;

import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;

//https://stackoverflow.com/questions/25819934/jaxb-unmarshalling-with-namespace
````
- Step 4: Unmarshall in the main.
```Java
public static void main( String[] args ) {
        try {
            //This is an example of unmarshalling a nested XML
            File nestedXML = new File("KSTJ.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(CurrentObservation.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            CurrentObservation currentObservation = (CurrentObservation) jaxbUnmarshaller.unmarshal(nestedXML);
            System.out.println(currentObservation);
        } catch (JAXBException e) {
            e.printStackTrace();
            System.exit(1);
        } //End of catch.
    } //End of main.
````

- Output in console:
````Java
CurrentObservation{ version='1.0', credit='NOAA's National Weather Service', creditUrl='https://weather.gov/', image=Image{url='https://weather.gov/images/xml_logo.gif', title='NOAA's National Weather Service', link='https://www.weather.gov'}, suggestedPickup='15 minutes after the hour', suggestedPickupPeriod=60, location='St. Joseph, Rosecrans Memorial Airport, MO', stationID='KSTJ', latitude=39.76806, longitude=-94.90917, observationTime='Last Updated on Feb 27 2022, 5:53 am CST', observationTimeRFC822='Sun, 27 Feb 2022 05:53:00 -0600', weather='Fair', temperatureString='13.0 F (-10.6 C)', tempF=13.0, tempC=-10.6, relativeHumidity=77, windString='Calm', windDir='North', windDegrees=0, windMPH=0.0, windKT=0, pressureString='1029.2 mb', pressureMB=1029.2, pressureIn=30.36, dewpointString='7.0 F (-13.9 C)', dewPointF=7.0, dewPointC=-13.9, visibilityMi=9.0, iconURLBase='https://forecast.weather.gov/images/wtf/small/', twoDayHistoryUrl='https://www.weather.gov/data/obhistory/KSTJ.html', iconUrlName='nskc.png', obUrl='https://www.weather.gov/data/METAR/KSTJ.1.txt', disclaimerUrl='https://www.weather.gov/disclaimer.html', copyrightUrl='https://www.weather.gov/disclaimer.html', privacyPolicyUrl='https://www.weather.gov/notice.html'}

````
 
#### Marshalling (Java Object to XML)
  - Using the same classes above...
  ````Java
  public static void main( String[] args ) {
        try {
            //This is an example of marshalling a nested XML
            jaxbContext = JAXBContext.newInstance(CurrentObservation.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
            jaxbMarshaller.setProperty( Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "http://www.weather.gov/view/current_observation.xsd");
            jaxbMarshaller.marshal( currentObservation, new File ("newObservations.xml"));
            jaxbMarshaller.marshal( currentObservation, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
            System.exit(1);
        }  //End of catch.
    } //End of main.
 ````
  - Output to file can be found -> ['newObservations.xml' output](https://github.com/abg5043/JAXBTutorial/blob/master/newObservations.xml)

<br/>

## Example 3: Array Expressed as XML (complex)
  - We will be loading the XML from this [collection of states url](https://civilserviceusa.github.io/us-states/data/states.xml). The url contains a collection of states in the form of nested XML.
#### Unmarshalling (XML to Java Object)
  - **Step 1:** We will need to create a limited-type POJO for each individual state. 
  ````Java
  /**
 * This class represents a single state object.
 */

public class State {

    /* --- DATA --- */
    //These data fields directly correspond to the XML tags found in the above url.
    private String state,slug,code,nickname,website,
            admission_date,admission_number,capital_city,
            capital_url,population,population_rank,constitution_url,
            state_flag_url,state_seal_url,map_image_url,
            landscape_background_url, skyline_background_url,
            twitter_url, facebook_url;

    /* --- TO STRING --- */
    //I would suggest making a toString so that you can easily read & print the object.
    ...

    /* --- ALL GETTERS & SETTERS --- */
    ...
 
} //End of State class.
  ````
  - **Step 2:**  We will also need a class that represents the collection of States. This class will contain the @XMLAnnotations. Because ArrayList is a part of the collection framework, and does not have any JAXB annotations, we need to have this seperate class to represent the set of objects.
   ````Java
import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "states")
@XmlAccessorType(XmlAccessType.FIELD)

public class States {

    @XmlElement(name = "state")
    private List<State> states = null;

   /* --- GETTER FOR LIST --- */
    public List<State> getStates() {
        return states;
    } //End of getStates

    /* --- SETTER FOR LIST --- */
    public void setStates(List<State> states) {
        this.states = states;
    } //End of setStates.

} //End of States class.
  ````
  - **Step 3:**  Now let's get to unmarshalling! First let us create a function that will take in the address, load and unmarshall the content from the url, and give us an ArrayList of the State Objects. 
  ````Java
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
            //For each state inside the States List, sts.getStates(), print out its corresponding data and add to ArrayList.
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
  ````
  - **Step 4:** Setting the address in main and calling our newly created function.
   ````Java
    public static void main(String[] args) {
        //Putting the web address into a String.
        String address = "https://civilserviceusa.github.io/us-states/data/states.xml";
        //Loading from the website and printing the ArrayList of State objects we created.
        loadToObject(address);
     } //End of main.
  ````
  - Output in console (Note: the above code will print all State objects added to the ArrayList, which is all 50, I will only be showing one of the printed state objects printed in the console).
  ````Java
  //Remember that the way it is printed into the console will be determined by your toString().
 State{state='Alabama', slug='alabama', code='AL', nickname='Yellowhammer State', website='http://www.alabama.gov/', admission_date='1819-12-14', admission_number='22', capital_city='Montgomery', capital_url='http://www.montgomeryal.gov/', population='4833722', population_rank='23', constitution_url='http://alisondb.legislature.state.al.us/alison/default.aspx', state_flag_url='https://cdn.civil.services/us-states/flags/alabama-large.png', state_seal_url='https://cdn.civil.services/us-states/seals/alabama-large.png', map_image_url='https://cdn.civil.services/us-states/maps/alabama-large.png', landscape_background_url='https://cdn.civil.services/us-states/backgrounds/1280x720/landscape/alabama.jpg', skyline_background_url='https://cdn.civil.services/us-states/backgrounds/1280x720/skyline/alabama.jpg', twitter_url='https://twitter.com/alabamagov', facebook_url='https://www.facebook.com/alabamagov%27%7D}
  ````
  <br/>
  
#### Marshalling (Java Object to XML)
  - We will be loading the Java Objects, which will be our State Objects, into a local .xml file (I call my file 'toXML.xml'). 
  - **Step 1:** Creating a method that takes in a set of States.
  ````Java
  public static void loadToXML(States states) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(States.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            //Setting the XML format, to make it easy on the eye. 
            jaxbMarshaller.setProperty(JAXB_FORMATTED_OUTPUT, true);
            //jaxbMarshaller.marshal(states, System.out); <- This prints to console
            //Notice that we marshal using the states, which is a collection of states. 
            jaxbMarshaller.marshal(states, new File("toXML.xml")); // <- this prints to the toXML.xml file
        } catch (JAXBException e) {
            e.printStackTrace();
            System.exit(1);
        } //End of catch.
    } //End of loadToXML.
  ````
  - **Step 2:** Call the function in main.
  ````Java
 public static void main(String[] args) {
        //Putting the web address into a String.
        String address = "https://civilserviceusa.github.io/us-states/data/states.xml";
        //I did not want to type (manually set) all the data, so ...
        //I store the ArrayList returned from Unmarshalling in this ArrayList of State objects.
        ArrayList<State> stList = loadToObject(address);
        //Then I create a new set of states....
        States sts = new States();
        //and set the collection of states to the State Objects list (which is the ArrayList of State Objects).
        sts.setStates(stList); //Rmember we ArrayList does not work with XML annotations it is important that you 
        //use the ArrayList and set the List in the States class. If you try to use the ArrayList you will get an error.
        loadToXML(sts);
    } //End of main method.
  ````
  - Output to file can be found -> ['toXML.xml' output](https://github.com/abg5043/JAXBTutorial/blob/master/toXML.xml)

<br/>

## Our Team!
- Aaron Grant -> coder 
- Christin Wilson -> coder
- Melissa Bayer -> writer
- Will Malita -> librarian 
