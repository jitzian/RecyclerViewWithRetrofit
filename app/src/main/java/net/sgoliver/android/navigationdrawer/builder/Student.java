package net.sgoliver.android.navigationdrawer.builder;

/**
 * Created by User on 10/28/2016.
 */

public class Student {

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

        public Student build(){
            return new Student(this);
        }
    }

    public Student(Builder builder){
        name = builder.name;
        lastName = builder.lastName;
    }

    public static void main(String...args){
        Student student = new Student.Builder()
                .name("Bruce")
                .lastName("Wayne")
                .build();

        System.out.println(student.name + " " + student.lastName);
    }

}
