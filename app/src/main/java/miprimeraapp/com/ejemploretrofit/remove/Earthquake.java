package miprimeraapp.com.ejemploretrofit.remove;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Earthquake {

    @SerializedName("datetime")
    @Expose
    private String datetime;
    @SerializedName("depth")
    @Expose
    private Double depth;
    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("src")
    @Expose
    private String src;
    @SerializedName("eqid")
    @Expose
    private String eqid;
    @SerializedName("magnitude")
    @Expose
    private Double magnitude;
    @SerializedName("lat")
    @Expose
    private Double lat;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Earthquake withDatetime(String datetime) {
        this.datetime = datetime;
        return this;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public Earthquake withDepth(Double depth) {
        this.depth = depth;
        return this;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Earthquake withLng(Double lng) {
        this.lng = lng;
        return this;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Earthquake withSrc(String src) {
        this.src = src;
        return this;
    }

    public String getEqid() {
        return eqid;
    }

    public void setEqid(String eqid) {
        this.eqid = eqid;
    }

    public Earthquake withEqid(String eqid) {
        this.eqid = eqid;
        return this;
    }

    public Double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Double magnitude) {
        this.magnitude = magnitude;
    }

    public Earthquake withMagnitude(Double magnitude) {
        this.magnitude = magnitude;
        return this;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Earthquake withLat(Double lat) {
        this.lat = lat;
        return this;
    }

}




