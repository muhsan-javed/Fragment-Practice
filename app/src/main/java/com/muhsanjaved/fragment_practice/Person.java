package com.muhsanjaved.fragment_practice;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {

    private String fName;
    private String lName;
    private int age;

    public Person(String fName, String lName, int age) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.fName);
        dest.writeString(this.lName);
        dest.writeInt(this.age);
    }

    public void readFromParcel(Parcel source) {
        this.fName = source.readString();
        this.lName = source.readString();
        this.age = source.readInt();
    }

    protected Person(Parcel in) {
        this.fName = in.readString();
        this.lName = in.readString();
        this.age = in.readInt();
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
