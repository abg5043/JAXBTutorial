package edu.missouriwestern.agrant4.simpleDemo;// JAKARTA 3.0.0 (using different dependencies at the same time
// creates errors)

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "credentials")
@XmlAccessorType(XmlAccessType.FIELD)
public class Credentials_Option3 {

  @XmlElement(name = "user")
  String user;

  @XmlElement(name = "password")
  String password;

  @XmlAttribute(name = "xhint")
  String xhint;

  @XmlElement(name = "host")
  String host;

  @XmlElement(name = "port")
  String port;

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
