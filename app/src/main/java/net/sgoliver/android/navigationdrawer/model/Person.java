package net.sgoliver.android.navigationdrawer.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by User on 10/16/2016.
 */

public class Person implements Parcelable{
    public String name;
    public String lastName;
    public int age;

    public Person(){}

    public Person(Parcel in) {
        name = in.readString();
        lastName = in.readString();
        age = in.readInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(lastName);
        dest.writeInt(age);
    }
}
