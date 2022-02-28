@XmlSchema(
    elementFormDefault = XmlNsForm.QUALIFIED,
    xmlns={
        @XmlNs(prefix="xsd", namespaceURI="http://www.w3.org/2001/XMLSchema"),
        @XmlNs(prefix="xsi", namespaceURI="http://www.w3.org/2001/XMLSchema-instance")
    }
)

package edu.missouriwestern.agrant4.nestedDemo;

import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;

//https://stackoverflow.com/questions/25819934/jaxb-unmarshalling-with-namespace



