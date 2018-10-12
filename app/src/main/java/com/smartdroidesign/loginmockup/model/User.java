package com.smartdroidesign.loginmockup.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String firstName;
    private String lastName;
    private String gender;
    private String age;
    private String password;

    public User(String firstName, String lastName, String gender, String age, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.password = password;
    }

    protected User(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        gender = in.readString();
        age = in.readString();
        password = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(gender);
        dest.writeString(age);
    }
}
