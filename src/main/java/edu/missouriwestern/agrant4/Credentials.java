package edu.missouriwestern.agrant4;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Credentials {

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
