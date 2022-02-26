package edu.missouriwestern.agrant4;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType( propOrder = {"host", "port", "xhint", "user", "password"})
@XmlRootElement( name = "credentials" )
public class CredentialsTest {

  String host;

  @XmlElement( name = "host")
  public void setHost(String host) {
    this.host = host;
  }

  public String getHost() {
    return host;
  }

  String port;

  @XmlElement( name = "port")
  public void setPort(String port) {
    this.port = port;
  }

  public String getPort() {
    return port;
  }

  String xhint;

  @XmlAttribute( name = "xhint" )
  public void setXhint(String xhint) {
    this.xhint = xhint;
  }

  public String getXhint() {
    return xhint;
  }

  String user;

  @XmlElement( name = "user")
  public void setUser(String user) {
    this.user = user;
  }

  public String getUser() {
    return user;
  }

  String password;

  @XmlElement( name = "password")
  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

}
