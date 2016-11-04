package net.sgoliver.android.navigationdrawer.factory;

/**
 * Created by User on 11/2/2016.
 */

public class ShapeFactory {
    public ShapeFactory() {
    }

    public Shape getInstance(String type){
        if(type != null){
            switch (type){
                case "circle":
                    return new Circle();
                case "triangle":
                    return new Triangle();
            }
        }
        return null;
    }

}
