package edu.missouriwestern.agrant4.simpleDemo;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "credentials" )
public class Credentials {

  //Create fields for every xml attribute and element
  private String host;
  private String port;
  private String user;
  private Password password;

  public Credentials(String host, String port, String user, Password password) {
    this.host = host;
    this.port = port;
    this.user = user;
    this.password = password;
  }

  //To make JAXB work, we need a no-arg constructor
  public Credentials() {};

  //always put XML annotations for elements above the setter for each field.
  @XmlElement( name = "host")
  public void setHost(String host) {
    this.host = host;
  }

  public String getHost() {
    return host;
  }

  @XmlElement( name = "port")
  public void setPort(String port) {
    this.port = port;
  }
  public String getPort() {
    return port;
  }

  @XmlElement( name = "user")
  public void setUser(String user) {
    this.user = user;
  }

  public String getUser() {
    return user;
  }

  //Any element with annotations need to be objects with their own annotations
  @XmlElement(name = "password")
  public void setPassword(Password password) {
    this.password = password;
  }

  public Password getPassword() {
    return password;
  }

  @Override
  public String toString() {
    return "Credentials {" +
        "user=" + user + ", " +
        "password=" + password + ", " +
        "host=" + host + ", " +
        "port=" + port + ", " +
        " }";
  }
}
