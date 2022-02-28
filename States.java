import jakarta.xml.bind.annotation.*;
import java.util.List;

/**
 * This class represents the collection/set of States.
 * The ArrayList class is part of collection framework,
 * and it does not have any JAXB annotations. Therefore, we
 * need to have this class to represent the set of those
 * objects.
 */

@XmlRootElement(name = "states")
@XmlAccessorType(XmlAccessType.FIELD)

public class States {

    @XmlElement(name = "state")
    private List<State> states = null;

   /* --- GETTER FOR LIST --- */
    public List<State> getStates() {
        return states;
    } //End of getStates

    /* --- SETTER FOR LIST --- */
    public void setStates(List<State> states) {
        this.states = states;
    } //End of setStates.

} //End of States class.
