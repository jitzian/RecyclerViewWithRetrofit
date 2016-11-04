package net.sgoliver.android.navigationdrawer.factory;

/**
 * Created by User on 11/2/2016.
 */

public class TestFactory {

    public static void main(String...args){
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getInstance("circle");
        Shape shape2 = shapeFactory.getInstance("triangle");

        shape1.draw();
        shape2.draw();
    }
}
