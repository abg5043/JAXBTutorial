package edu.missouriwestern.agrant4.simpleDemo;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Credentials_Option2 {

  @XmlElement
  protected String host;

  @XmlElement
  protected String port;

  @XmlAttribute
  protected String xhint;

  @XmlElement
  protected String user;

  @XmlElement
  protected String password;

}
