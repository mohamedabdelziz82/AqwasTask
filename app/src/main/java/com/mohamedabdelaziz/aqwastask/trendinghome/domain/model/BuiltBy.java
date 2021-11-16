package com.mohamedabdelaziz.aqwastask.trendinghome.domain.model;

import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BuiltBy implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("username")
    @Expose
    private String username;
    public final static Creator<BuiltBy> CREATOR = new Creator<BuiltBy>() {
        public BuiltBy createFromParcel(android.os.Parcel in) {
            return new BuiltBy(in);
        }

        public BuiltBy[] newArray(int size) {
            return (new BuiltBy[size]);
        }

    };

    protected BuiltBy(android.os.Parcel in) {
        this.href = ((String) in.readValue((String.class.getClassLoader())));
        this.avatar = ((String) in.readValue((String.class.getClassLoader())));
        this.username = ((String) in.readValue((String.class.getClassLoader())));
    }


    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(href);
        dest.writeValue(avatar);
        dest.writeValue(username);
    }

    public int describeContents() {
        return 0;
    }


}