
package data.CurrentWeatherData;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Sys {

    @SerializedName("country")
    private String mCountry;
    @SerializedName("id")
    private Long mId;
    @SerializedName("message")
    private Double mMessage;
    @SerializedName("sunrise")
    private Long mSunrise;
    @SerializedName("sunset")
    private Long mSunset;
    @SerializedName("type")
    private Long mType;

    public String getCountry() {
        return mCountry;
    }

    public Long getId() {
        return mId;
    }

    public Double getMessage() {
        return mMessage;
    }

    public Long getSunrise() {
        return mSunrise;
    }

    public Long getSunset() {
        return mSunset;
    }

    public Long getType() {
        return mType;
    }

    public static class Builder {

        private String mCountry;
        private Long mId;
        private Double mMessage;
        private Long mSunrise;
        private Long mSunset;
        private Long mType;

        public Sys.Builder withCountry(String country) {
            mCountry = country;
            return this;
        }

        public Sys.Builder withId(Long id) {
            mId = id;
            return this;
        }

        public Sys.Builder withMessage(Double message) {
            mMessage = message;
            return this;
        }

        public Sys.Builder withSunrise(Long sunrise) {
            mSunrise = sunrise;
            return this;
        }

        public Sys.Builder withSunset(Long sunset) {
            mSunset = sunset;
            return this;
        }

        public Sys.Builder withType(Long type) {
            mType = type;
            return this;
        }

        public Sys build() {
            Sys sys = new Sys();
            sys.mCountry = mCountry;
            sys.mId = mId;
            sys.mMessage = mMessage;
            sys.mSunrise = mSunrise;
            sys.mSunset = mSunset;
            sys.mType = mType;
            return sys;
        }

    }

}
