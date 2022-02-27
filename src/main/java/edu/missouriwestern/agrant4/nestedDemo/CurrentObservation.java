package edu.missouriwestern.agrant4.nestedDemo;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "current_observation")
//This annotation means that we put the annotations above the field names instead of setters
@XmlAccessorType(XmlAccessType.FIELD)
public class CurrentObservation {
  //Create fields for every xml attribute and element
  @XmlAttribute(name = "version")
  private double version;
  /*
   * You cannot unmarshal the xsi:noNamespaceSchemaLocation annotation, but you can instruct the marshaller
   * to include it as notated in the App.java file. Similarly, notice the package-info.java file that tells the marshaller
   * to include other information about namespace. You cannot, though, seem to be able to import that information
   * with the unmarshaller.
   */
  @XmlElement( name = "credit")
  private String credit;
  @XmlElement( name = "credit_URL")
  private String creditUrl;
  //For elements with nested elements, make the parent element an object
  //Each of the nested elements will be @XmlElements within that object
  @XmlElement( name = "image")
  private Image image;
  @XmlElement( name = "suggested_pickup")
  private String suggestedPickup;
  @XmlElement( name = "suggested_pickup_period")
  private int suggestedPickupPeriod;
  @XmlElement( name = "location")
  private String location;
  @XmlElement( name = "station_id")
  private String stationID;
  @XmlElement( name = "latitude")
  private double latitude;
  @XmlElement( name = "longitude")
  private double longitude;
  @XmlElement( name = "observation_time")
  private String observationTime;
  @XmlElement( name = "observation_time_rfc822")
  private String observationTimeRFC822;
  @XmlElement( name = "weather")
  private String weather;
  @XmlElement( name = "temperature_string")
  private String temperatureString;
  @XmlElement( name = "temp_f")
  private double tempF;
  @XmlElement( name = "temp_c")
  private double tempC;
  @XmlElement( name = "relative_humidity")
  private int relativeHumidity;
  @XmlElement( name = "wind_string")
  private String windString;
  @XmlElement( name = "wind_dir")
  private String windDir;
  @XmlElement( name = "wind_degrees")
  private int windDegrees;
  @XmlElement( name = "wind_mph")
  private double windMPH;
  @XmlElement( name = "wind_kt")
  private int windKT;
  @XmlElement( name = "pressure_string")
  private String pressureString;
  @XmlElement( name = "pressure_mb")
  private double pressureMB;
  @XmlElement( name = "pressure_in")
  private double pressureIn;
  @XmlElement( name = "dewpoint_string")
  private String dewpointString;
  @XmlElement( name = "dewpoint_f")
  private double dewPointF;
  @XmlElement( name = "dewpoint_c")
  private double dewPointC;
  @XmlElement( name = "visibility_mi")
  private double visibilityMi;
  @XmlElement( name = "icon_url_base")
  private String iconURLBase;
  @XmlElement( name = "two_day_history_url")
  private String twoDayHistoryUrl;
  @XmlElement( name = "icon_url_name")
  private String iconUrlName;
  @XmlElement( name = "ob_url")
  private String obUrl;
  @XmlElement( name = "disclaimer_url")
  private String disclaimerUrl;
  @XmlElement( name = "copyright_url")
  private String copyrightUrl;
  @XmlElement( name = "privacy_policy_url")
  private String privacyPolicyUrl;

  //To make JAXB work, we need a no-arg constructor
  public CurrentObservation() {
  };

  public CurrentObservation(double version, String credit, String creditUrl, Image image, String suggestedPickup, int suggestedPickupPeriod, String location, String stationID, double latitude, double longitude, String observationTime, String observationTimeRFC822, String weather, String temperatureString, double tempF, double tempC, int relativeHumidity, String windString, String windDir, int windDegrees, double windMPH, int windKT, String pressureString, double pressureMB, double pressureIn, String dewpointString, double dewPointF, double dewPointC, double visibilityMi, String iconURLBase, String twoDayHistoryUrl, String iconUrlName, String obUrl, String disclaimerUrl, String copyrightUrl, String privacyPolicyUrl) {
    this.credit = credit;
    this.creditUrl = creditUrl;
    this.image = image;
    this.suggestedPickup = suggestedPickup;
    this.suggestedPickupPeriod = suggestedPickupPeriod;
    this.location = location;
    this.stationID = stationID;
    this.latitude = latitude;
    this.longitude = longitude;
    this.observationTime = observationTime;
    this.observationTimeRFC822 = observationTimeRFC822;
    this.weather = weather;
    this.temperatureString = temperatureString;
    this.tempF = tempF;
    this.tempC = tempC;
    this.relativeHumidity = relativeHumidity;
    this.windString = windString;
    this.windDir = windDir;
    this.windDegrees = windDegrees;
    this.windMPH = windMPH;
    this.windKT = windKT;
    this.pressureString = pressureString;
    this.pressureMB = pressureMB;
    this.pressureIn = pressureIn;
    this.dewpointString = dewpointString;
    this.dewPointF = dewPointF;
    this.dewPointC = dewPointC;
    this.visibilityMi = visibilityMi;
    this.iconURLBase = iconURLBase;
    this.twoDayHistoryUrl = twoDayHistoryUrl;
    this.iconUrlName = iconUrlName;
    this.obUrl = obUrl;
    this.disclaimerUrl = disclaimerUrl;
    this.copyrightUrl = copyrightUrl;
    this.privacyPolicyUrl = privacyPolicyUrl;
    this.version = version;
  }

  public double getVersion() {
    return version;
  }

  public void setVersion(double version) {
    this.version = version;
  }

  public String getCredit() {
    return credit;
  }

  public void setCredit(String credit) {
    this.credit = credit;
  }

  public String getCreditUrl() {
    return creditUrl;
  }

  public void setCreditUrl(String creditUrl) {
    this.creditUrl = creditUrl;
  }

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
  }

  public String getSuggestedPickup() {
    return suggestedPickup;
  }

  public void setSuggestedPickup(String suggestedPickup) {
    this.suggestedPickup = suggestedPickup;
  }

  public int getSuggestedPickupPeriod() {
    return suggestedPickupPeriod;
  }

  public void setSuggestedPickupPeriod(int suggestedPickupPeriod) {
    this.suggestedPickupPeriod = suggestedPickupPeriod;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getStationID() {
    return stationID;
  }

  public void setStationID(String stationID) {
    this.stationID = stationID;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public String getObservationTime() {
    return observationTime;
  }

  public void setObservationTime(String observationTime) {
    this.observationTime = observationTime;
  }

  public String getObservationTimeRFC822() {
    return observationTimeRFC822;
  }

  public void setObservationTimeRFC822(String observationTimeRFC822) {
    this.observationTimeRFC822 = observationTimeRFC822;
  }

  public String getWeather() {
    return weather;
  }

  public void setWeather(String weather) {
    this.weather = weather;
  }

  public String getTemperatureString() {
    return temperatureString;
  }

  public void setTemperatureString(String temperatureString) {
    this.temperatureString = temperatureString;
  }

  public double getTempF() {
    return tempF;
  }

  public void setTempF(double tempF) {
    this.tempF = tempF;
  }

  public double getTempC() {
    return tempC;
  }

  public void setTempC(double tempC) {
    this.tempC = tempC;
  }

  public int getRelativeHumidity() {
    return relativeHumidity;
  }

  public void setRelativeHumidity(int relativeHumidity) {
    this.relativeHumidity = relativeHumidity;
  }

  public String getWindString() {
    return windString;
  }

  public void setWindString(String windString) {
    this.windString = windString;
  }

  public String getWindDir() {
    return windDir;
  }

  public void setWindDir(String windDir) {
    this.windDir = windDir;
  }

  public int getWindDegrees() {
    return windDegrees;
  }

  public void setWindDegrees(int windDegrees) {
    this.windDegrees = windDegrees;
  }

  public double getWindMPH() {
    return windMPH;
  }

  public void setWindMPH(double windMPH) {
    this.windMPH = windMPH;
  }

  public int getWindKT() {
    return windKT;
  }

  public void setWindKT(int windKT) {
    this.windKT = windKT;
  }

  public String getPressureString() {
    return pressureString;
  }

  public void setPressureString(String pressureString) {
    this.pressureString = pressureString;
  }

  public double getPressureMB() {
    return pressureMB;
  }

  public void setPressureMB(double pressureMB) {
    this.pressureMB = pressureMB;
  }

  public double getPressureIn() {
    return pressureIn;
  }

  public void setPressureIn(double pressureIn) {
    this.pressureIn = pressureIn;
  }

  public String getDewpointString() {
    return dewpointString;
  }

  public void setDewpointString(String dewpointString) {
    this.dewpointString = dewpointString;
  }

  public double getDewPointF() {
    return dewPointF;
  }

  public void setDewPointF(double dewPointF) {
    this.dewPointF = dewPointF;
  }

  public double getDewPointC() {
    return dewPointC;
  }

  public void setDewPointC(double dewPointC) {
    this.dewPointC = dewPointC;
  }

  public double getVisibilityMi() {
    return visibilityMi;
  }

  public void setVisibilityMi(double visibilityMi) {
    this.visibilityMi = visibilityMi;
  }

  public String getIconURLBase() {
    return iconURLBase;
  }

  public void setIconURLBase(String iconURLBase) {
    this.iconURLBase = iconURLBase;
  }

  public String getTwoDayHistoryUrl() {
    return twoDayHistoryUrl;
  }

  public void setTwoDayHistoryUrl(String twoDayHistoryUrl) {
    this.twoDayHistoryUrl = twoDayHistoryUrl;
  }

  public String getIconUrlName() {
    return iconUrlName;
  }

  public void setIconUrlName(String iconUrlName) {
    this.iconUrlName = iconUrlName;
  }

  public String getObUrl() {
    return obUrl;
  }

  public void setObUrl(String obUrl) {
    this.obUrl = obUrl;
  }

  public String getDisclaimerUrl() {
    return disclaimerUrl;
  }

  public void setDisclaimerUrl(String disclaimerUrl) {
    this.disclaimerUrl = disclaimerUrl;
  }

  public String getCopyrightUrl() {
    return copyrightUrl;
  }

  public void setCopyrightUrl(String copyrightUrl) {
    this.copyrightUrl = copyrightUrl;
  }

  public String getPrivacyPolicyUrl() {
    return privacyPolicyUrl;
  }

  public void setPrivacyPolicyUrl(String privacyPolicyUrl) {
    this.privacyPolicyUrl = privacyPolicyUrl;
  }


  @Override
  public String toString() {
    return "CurrentObservation{" +
        " version='" + version + '\'' +
        ", credit='" + credit + '\'' +
        ", creditUrl='" + creditUrl + '\'' +
        ", image=" + image +
        ", suggestedPickup='" + suggestedPickup + '\'' +
        ", suggestedPickupPeriod=" + suggestedPickupPeriod +
        ", location='" + location + '\'' +
        ", stationID='" + stationID + '\'' +
        ", latitude=" + latitude +
        ", longitude=" + longitude +
        ", observationTime='" + observationTime + '\'' +
        ", observationTimeRFC822='" + observationTimeRFC822 + '\'' +
        ", weather='" + weather + '\'' +
        ", temperatureString='" + temperatureString + '\'' +
        ", tempF=" + tempF +
        ", tempC=" + tempC +
        ", relativeHumidity=" + relativeHumidity +
        ", windString='" + windString + '\'' +
        ", windDir='" + windDir + '\'' +
        ", windDegrees=" + windDegrees +
        ", windMPH=" + windMPH +
        ", windKT=" + windKT +
        ", pressureString='" + pressureString + '\'' +
        ", pressureMB=" + pressureMB +
        ", pressureIn=" + pressureIn +
        ", dewpointString='" + dewpointString + '\'' +
        ", dewPointF=" + dewPointF +
        ", dewPointC=" + dewPointC +
        ", visibilityMi=" + visibilityMi +
        ", iconURLBase='" + iconURLBase + '\'' +
        ", twoDayHistoryUrl='" + twoDayHistoryUrl + '\'' +
        ", iconUrlName='" + iconUrlName + '\'' +
        ", obUrl='" + obUrl + '\'' +
        ", disclaimerUrl='" + disclaimerUrl + '\'' +
        ", copyrightUrl='" + copyrightUrl + '\'' +
        ", privacyPolicyUrl='" + privacyPolicyUrl + '\'' +
        '}';
  }

}
