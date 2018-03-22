package exequiel.ussdwizardhelper.http.data.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by egonzalez on 21/03/18.
 */

@Root(name = "Messages.Message")
public class MenssagesMessage {
    @Element(name = "Id", required = false)
    public String id;
    @Element(name = "Type", required = false)
    public String type;
    @Element(name = "Description", required = false)
    public String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
