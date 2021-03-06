package edu.missouriwestern.agrant4.simpleDemo;


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
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public String getXhint() {
    return xhint;
  }

  public void setXhint(String xhint) {
    this.xhint = xhint;
  }

  @Override
  public String toString() {
    return "Password{" +
        "xhint='" + xhint + '\'' +
        ", pass='" + pass + '\'' +
        '}';
  }
}
