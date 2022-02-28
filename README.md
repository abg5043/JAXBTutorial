# JAXBTutorial
## What is JAXB?
JAXB stands for Java Architecture XML Binding. It is a tool that is used by Java developers to map Java to XML representations. Today, JAXB  is also  known as Jakarta XML binding.

## Removal of JAXB from the Java JDK:
- JAXB became a part of the JDK in Java 6. In Java 11 (2018), JAXB was removed from the JDK. 
- JAXB is still a part of the JDK in Java 6,7, and 8.
- JAXB is still a part of Java 9 and 10 but it has been disabled or not included in the module path. 
In Java 11 it is completely removed.

Versions exist:  JAXB 1.0 &  JAXB 2.0, Jakarta 3.0

## Since it has been removed:
JAXB (Jakarta XML Binding) can still be utilized. To do so, you will need to use the following dependencies. Using older versions of the dependencies require different import statements. 

```

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

```


## The two main features/operations of JAXB are:
- Marshalling  (description) dfshfdjh
- Unmarshalling (description)

## Simple XML File (simple)
#### Marshalling (Java Object to XML)
  - POJO code


  - Main code

  ```
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

/**
 * This app demonstrates how to use JAXB to turn a simple xml file into an object (unmarshall)
 * and then a java object into an xml file (marshall)
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
```
  - Output in console
#### Unmarshalling (XML to Java Object)
  - Local XML file 
  - POJO code
  - Main code

## Nested XML File (complex)
#### Marshalling (Java Object to XML)
  - POJO code
  - Main code
  - Output in console
#### Unmarshalling (XML to Java Object)
  - URL link
  - POJO code
  - Main code

## An Array Expressed as XML (complex)
#### Marshalling (Java Object to XML)
  - POJO code
  - Main code
  - Output in file
#### Unmarshalling (XML to Java Object)
  - URL link
  - POJO code
  - Main code
