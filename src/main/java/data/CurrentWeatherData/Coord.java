
package data.CurrentWeatherData;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Coord {

    @SerializedName("lat")
    private Double mLat;
    @SerializedName("lon")
    private Double mLon;

    public Double getLat() {
        return mLat;
    }

    public Double getLon() {
        return mLon;
    }

    public static class Builder {

        private Double mLat;
        private Double mLon;

        public Coord.Builder withLat(Double lat) {
            mLat = lat;
            return this;
        }

        public Coord.Builder withLon(Double lon) {
            mLon = lon;
            return this;
        }

        public Coord build() {
            Coord coord = new Coord();
            coord.mLat = mLat;
            coord.mLon = mLon;
            return coord;
        }

    }

}
