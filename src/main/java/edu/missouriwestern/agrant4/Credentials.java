package edu.missouriwestern.agrant4;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType( propOrder = {"host", "port", "xhint", "user", "password"})
@XmlRootElement( name = "credentials" )
public class Credentials {

  //Create fields for every xml attribute and element
  String host;
  String port;
  String xhint;
  String user;
  String password;

  public Credentials(String host, String port, String xhint, String user, String password) {
    this.host = host;
    this.port = port;
    this.xhint = xhint;
    this.user = user;
    this.password = password;
  }

  //To make JAXB work, we need a no-arg constructor
  //TEST CHANGE
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


  //XML attributes seem to only allow for attributes at the class level
  @XmlAttribute( name = "xhint" )
  public void setXhint(String xhint) {
    this.xhint = xhint;
  }

  public String getXhint() {
    return xhint;
  }

  @XmlElement( name = "user")
  public void setUser(String user) {
    this.user = user;
  }

  public String getUser() {
    return user;
  }


  @XmlElement( name = "password")
  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public String toString() {
    return "Credentials {" +
        "xhint=" + xhint + ", " +
        "user=" + user + ", " +
        "password=" + password + ", " +
        "host=" + host + ", " +
        "port=" + port + ", " +
        " }";
  }
}
