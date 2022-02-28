package edu.missouriwestern.agrant4.nestedDemo;

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
