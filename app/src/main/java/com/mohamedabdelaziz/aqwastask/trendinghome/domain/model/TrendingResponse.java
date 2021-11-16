package com.mohamedabdelaziz.aqwastask.trendinghome.domain.model;

import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "trend_table")
public class TrendingResponse  implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("languageColor")
    @Expose
    private String languageColor;
    @SerializedName("stars")
    @Expose
    private Integer stars;
    @SerializedName("forks")
    @Expose
    private Integer forks;
    @SerializedName("currentPeriodStars")
    @Expose
    private Integer currentPeriodStars;
    @SerializedName("builtBy")
    @Expose
    private List<BuiltBy> builtBy = null;
    public final static Creator<TrendingResponse> CREATOR = new Creator<TrendingResponse>() {

        public TrendingResponse createFromParcel(android.os.Parcel in) {
            return new TrendingResponse(in);
        }

        public TrendingResponse[] newArray(int size) {
            return (new TrendingResponse[size]);
        }
    };

    public TrendingResponse(android.os.Parcel in) {
        this.author = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.avatar = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.language = ((String) in.readValue((String.class.getClassLoader())));
        this.languageColor = ((String) in.readValue((String.class.getClassLoader())));
        this.stars = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.forks = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.currentPeriodStars = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.builtBy, ( BuiltBy.class.getClassLoader()));
    }

    public TrendingResponse() {
    }

    public TrendingResponse(int id, String author, String name, String avatar, String url, String description, String language, String languageColor, Integer stars, Integer forks, Integer currentPeriodStars, List<BuiltBy> builtBy) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.avatar = avatar;
        this.url = url;
        this.description = description;
        this.language = language;
        this.languageColor = languageColor;
        this.stars = stars;
        this.forks = forks;
        this.currentPeriodStars = currentPeriodStars;
        this.builtBy = builtBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguageColor() {
        return languageColor;
    }

    public void setLanguageColor(String languageColor) {
        this.languageColor = languageColor;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Integer getForks() {
        return forks;
    }

    public void setForks(Integer forks) {
        this.forks = forks;
    }

    public Integer getCurrentPeriodStars() {
        return currentPeriodStars;
    }

    public void setCurrentPeriodStars(Integer currentPeriodStars) {
        this.currentPeriodStars = currentPeriodStars;
    }

    public List<BuiltBy> getBuiltBy() {
        return builtBy;
    }

    public void setBuiltBy(List<BuiltBy> builtBy) {
        this.builtBy = builtBy;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(author);
        dest.writeValue(name);
        dest.writeValue(avatar);
        dest.writeValue(url);
        dest.writeValue(description);
        dest.writeValue(language);
        dest.writeValue(languageColor);
        dest.writeValue(stars);
        dest.writeValue(forks);
        dest.writeValue(currentPeriodStars);
        dest.writeList(builtBy);
    }

    public int describeContents() {
        return 0;
    }

}
