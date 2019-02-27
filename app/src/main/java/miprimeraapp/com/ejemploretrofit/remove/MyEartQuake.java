package miprimeraapp.com.ejemploretrofit.remove;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyEartQuake {

    @SerializedName("earthquakes")
    @Expose
    private List<Earthquake> earthquakes = null;

    public List<Earthquake> getEarthquakes() {
        return earthquakes;
    }

    public void setEarthquakes(List<Earthquake> earthquakes) {
        this.earthquakes = earthquakes;
    }

    public MyEartQuake withEarthquakes(List<Earthquake> earthquakes) {
        this.earthquakes = earthquakes;
        return this;

    }

}
