package exequiel.ussdwizardhelper.data;

/**
 * Created by egonzalez on 08/03/18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("uid")
    @Expose
    private String uid;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}