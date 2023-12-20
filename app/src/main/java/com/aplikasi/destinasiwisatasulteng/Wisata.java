package com.aplikasi.destinasiwisatasulteng;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Wisata implements Parcelable {
    private  String name;
    private  String description;
    private  Integer photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPhoto() {
        return photo;
    }

    public void setPhoto(Integer photo) {
        this.photo = photo;
    }

    Wisata(){

    }
    public Wisata(Parcel in){
        this.name = in.readString();
        this.description = in.readString();
        this.photo = in.readInt();
    }

    public static final Creator<Wisata> CREATOR = new Creator<Wisata>() {
        @Override
        public Wisata createFromParcel(Parcel in) {
            return new Wisata(in);
        }

        @Override
        public Wisata[] newArray(int size) {
            return new Wisata[size];
        }
    };
    @Override
    public int describeContents() {return 0;}

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeInt(photo);
    }
}
