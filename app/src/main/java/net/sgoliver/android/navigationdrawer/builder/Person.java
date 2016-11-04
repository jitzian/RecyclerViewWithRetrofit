package net.sgoliver.android.navigationdrawer.builder;

/**
 * Created by User on 10/28/2016.
 */

public class Person {
    private String name;
    private String lastName;

    public static class Builder{
        private String name;
        private String lastName;

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Person build(){
            return new Person(this);
        }

    }

    public Person(Builder builder){
        name = builder.name;
        lastName = builder.lastName;
    }

    public static void main(String...args){
        Person person = new Person.Builder()
                .name("Jona")
                .lastName("Sandoval")
                .build();

        System.out.println(person.name + " " + person.lastName);
    }

}
