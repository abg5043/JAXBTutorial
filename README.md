
# JAXBTutorial
## What is JAXB?
JAXB stands for Java Architecture XML Binding. It is a tool that is used by Java developers to map Java to XML representations. Today, JAXB  is also  known as Jakarta XML binding.<br/><br/>

## The two main features/operations of JAXB are: 
- **````Marshalling```` -> converting a Java Object into XML** 
- **```` Unmarshalling```` -> converting XML to a Java Object** 
<br/><br/>  
## Removal of JAXB from the Java JDK:
JAXB became a part of the JDK in Java 6. In Java 11 (2018), JAXB was removed from the JDK. 
- JAXB is still a part of the JDK in Java 6,7, and 8.
- JAXB is still a part of Java 9 and 10 but it has been disabled or not included in the module path. 
- In Java 11 it is completely removed.

Versions exist:  JAXB 1.0 &  JAXB 2.0, Jakarta 3.0<br/><br/>

## Since it has been removed:
JAXB (Jakarta XML Binding) can still be utilized. To do so, you will need to use the following dependency. Using older versions of the dependencies require different import statements. 

```Java

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
<br/>

## Simple XML File (simple)
#### Marshalling (Java Object to XML)
  - POJO code
  - Main code

  ```Java
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

## Example 3: Array Expressed as XML (complex)
#### Unmarshalling (XML to Java Object)
  - We will be unmarshalling from this [url](https://civilserviceusa.github.io/us-states/data/states.xml) that shows a collection of states in the form of XML.
  - Step 1: We will need to create a limited-type POJO for each individual state. 
  ````Java
  /**
 * This class represents a single state object.
 */

public class State {

    /* --- DATA --- */
    private String state,slug,code,nickname,website,
            admission_date,admission_number,capital_city,
            capital_url,population,population_rank,constitution_url,
            state_flag_url,state_seal_url,map_image_url,
            landscape_background_url, skyline_background_url,
            twitter_url, facebook_url;

    /* --- TO STRING --- */
    @Override
    public String toString() {
        return "State{" +
                "state='" + state + '\'' +
                ", slug='" + slug + '\'' +
                ", code='" + code + '\'' +
                ", nickname='" + nickname + '\'' +
                ", website='" + website + '\'' +
                ", admission_date='" + admission_date + '\'' +
                ", admission_number='" + admission_number + '\'' +
                ", capital_city='" + capital_city + '\'' +
                ", capital_url='" + capital_url + '\'' +
                ", population='" + population + '\'' +
                ", population_rank='" + population_rank + '\'' +
                ", constitution_url='" + constitution_url + '\'' +
                ", state_flag_url='" + state_flag_url + '\'' +
                ", state_seal_url='" + state_seal_url + '\'' +
                ", map_image_url='" + map_image_url + '\'' +
                ", landscape_background_url='" + landscape_background_url + '\'' +
                ", skyline_background_url='" + skyline_background_url + '\'' +
                ", twitter_url='" + twitter_url + '\'' +
                ", facebook_url='" + facebook_url + '\'' +
                '}';
    } //End of toString.

    /* --- GETTERS & SETTERS --- */
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getSlug() {
        return slug;
    }
    public void setSlug(String slug) {
        this.slug = slug;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public String getAdmission_date() {
        return admission_date;
    }
    public void setAdmission_date(String admission_date) {
        this.admission_date = admission_date;
    }
    public String getAdmission_number() {
        return admission_number;
    }
    public void setAdmission_number(String admission_number) {
        this.admission_number = admission_number;
    }
    public String getCapital_city() {
        return capital_city;
    }
    public void setCapital_city(String capital_city) {
        this.capital_city = capital_city;
    }
    public String getCapital_url() {
        return capital_url;
    }
    public void setCapital_url(String capital_url) {
        this.capital_url = capital_url;
    }
    public String getPopulation() {
        return population;
    }
    public void setPopulation(String population) {
        this.population = population;
    }
    public String getPopulation_rank() {
        return population_rank;
    }
    public void setPopulation_rank(String population_rank) {
        this.population_rank = population_rank;
    }
    public String getConstitution_url() {
        return constitution_url;
    }
    public void setConstitution_url(String constitution_url) {
        this.constitution_url = constitution_url;
    }
    public String getState_flag_url() {
        return state_flag_url;
    }
    public void setState_flag_url(String state_flag_url) {
        this.state_flag_url = state_flag_url;
    }
    public String getState_seal_url() {
        return state_seal_url;
    }
    public void setState_seal_url(String state_seal_url) {
        this.state_seal_url = state_seal_url;
    }
    public String getMap_image_url() {
        return map_image_url;
    }
    public void setMap_image_url(String map_image_url) {
        this.map_image_url = map_image_url;
    }
    public String getLandscape_background_url() {
        return landscape_background_url;
    }
    public void setLandscape_background_url(String landscape_background_url) {
        this.landscape_background_url = landscape_background_url;
    }
    public String getSkyline_background_url() {
        return skyline_background_url;
    }
    public void setSkyline_background_url(String skyline_background_url) {
        this.skyline_background_url = skyline_background_url;
    }
    public String getTwitter_url() {
        return twitter_url;
    }
    public void setTwitter_url(String twitter_url) {
        this.twitter_url = twitter_url;
    }
    public String getFacebook_url() {
        return facebook_url;
    }
    public void setFacebook_url(String facebook_url) {
        this.facebook_url = facebook_url;
    }
} //End of State class.
  ````
  - Main code
  - Output in file
#### Marshalling (Java Object to XML)
  - POJO code
  - Main code
  - Output in file
