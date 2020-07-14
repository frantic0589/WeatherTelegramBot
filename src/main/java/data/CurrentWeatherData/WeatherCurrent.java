
package data;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class WeatherCurrent {

    @SerializedName("base")
    private String mBase;
    @SerializedName("clouds")
    private Clouds mClouds;
    @SerializedName("cod")
    private Long mCod;
    @SerializedName("coord")
    private Coord mCoord;
    @SerializedName("dt")
    private Long mDt;
    @SerializedName("id")
    private Long mId;
    @SerializedName("main")
    private Main mMain;
    @SerializedName("name")
    private String mName;
    @SerializedName("sys")
    private Sys mSys;
    @SerializedName("timezone")
    private Long mTimezone;
    @SerializedName("visibility")
    private Long mVisibility;
    @SerializedName("weather")
    private List<Weather> mWeather;
    @SerializedName("wind")
    private Wind mWind;

    public String getBase() {
        return mBase;
    }

    public Clouds getClouds() {
        return mClouds;
    }

    public Long getCod() {
        return mCod;
    }

    public Coord getCoord() {
        return mCoord;
    }

    public Long getDt() {
        return mDt;
    }

    public Long getId() {
        return mId;
    }

    public Main getMain() {
        return mMain;
    }

    public String getName() {
        return mName;
    }

    public Sys getSys() {
        return mSys;
    }

    public Long getTimezone() {
        return mTimezone;
    }

    public Long getVisibility() {
        return mVisibility;
    }

    public List<Weather> getWeather() {
        return mWeather;
    }

    public Wind getWind() {
        return mWind;
    }

    public static class Builder {

        private String mBase;
        private Clouds mClouds;
        private Long mCod;
        private Coord mCoord;
        private Long mDt;
        private Long mId;
        private Main mMain;
        private String mName;
        private Sys mSys;
        private Long mTimezone;
        private Long mVisibility;
        private List<Weather> mWeather;
        private Wind mWind;

        public WeatherCurrent.Builder withBase(String base) {
            mBase = base;
            return this;
        }

        public WeatherCurrent.Builder withClouds(Clouds clouds) {
            mClouds = clouds;
            return this;
        }

        public WeatherCurrent.Builder withCod(Long cod) {
            mCod = cod;
            return this;
        }

        public WeatherCurrent.Builder withCoord(Coord coord) {
            mCoord = coord;
            return this;
        }

        public WeatherCurrent.Builder withDt(Long dt) {
            mDt = dt;
            return this;
        }

        public WeatherCurrent.Builder withId(Long id) {
            mId = id;
            return this;
        }

        public WeatherCurrent.Builder withMain(Main main) {
            mMain = main;
            return this;
        }

        public WeatherCurrent.Builder withName(String name) {
            mName = name;
            return this;
        }

        public WeatherCurrent.Builder withSys(Sys sys) {
            mSys = sys;
            return this;
        }

        public WeatherCurrent.Builder withTimezone(Long timezone) {
            mTimezone = timezone;
            return this;
        }

        public WeatherCurrent.Builder withVisibility(Long visibility) {
            mVisibility = visibility;
            return this;
        }

        public WeatherCurrent.Builder withWeather(List<Weather> weather) {
            mWeather = weather;
            return this;
        }

        public WeatherCurrent.Builder withWind(Wind wind) {
            mWind = wind;
            return this;
        }

        public WeatherCurrent build() {
            WeatherCurrent weatherCurrent = new WeatherCurrent();
            weatherCurrent.mBase = mBase;
            weatherCurrent.mClouds = mClouds;
            weatherCurrent.mCod = mCod;
            weatherCurrent.mCoord = mCoord;
            weatherCurrent.mDt = mDt;
            weatherCurrent.mId = mId;
            weatherCurrent.mMain = mMain;
            weatherCurrent.mName = mName;
            weatherCurrent.mSys = mSys;
            weatherCurrent.mTimezone = mTimezone;
            weatherCurrent.mVisibility = mVisibility;
            weatherCurrent.mWeather = mWeather;
            weatherCurrent.mWind = mWind;
            return weatherCurrent;
        }

    }

}
