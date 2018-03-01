package com.mobileia.news.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by matiascamiletti on 1/3/18.
 */

public class News implements Parcelable {

    public int id;

    public int user_id;

    public String title;

    public String caption;

    public String photo;

    public News(){}

    public News(Parcel in){
        id = in.readInt();
        user_id = in.readInt();
        title = in.readString();
        caption = in.readString();
        photo = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(user_id);
        parcel.writeString(title);
        parcel.writeString(caption);
        parcel.writeString(photo);
    }

    public static final Creator<News> CREATOR = new Creator<News>() {

        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        public News[] newArray(int size) {
            return new News[size];
        }
    };
}
