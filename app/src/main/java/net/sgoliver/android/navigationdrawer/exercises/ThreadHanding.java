package net.sgoliver.android.navigationdrawer.exercises;

import java.util.Objects;

/**
 * Created by User on 11/2/2016.
 */

public class ThreadHanding {

    public static void main(String...args) throws InterruptedException {
        T1 t1 = new T1();
        t1.start();

        T2 t2 = new T2();
        t2.start();

        T3 t3 = new T3();
        t3.start();

    }

    static class T1 extends Thread{
        @Override
        public void run() {
            super.run();
            synchronized (this){
                for(int i = 0; i <3; i ++){
                    System.out.print("1, ");
                }
            }
        }
    }

    static class T2 extends Thread{
        @Override
        public void run() {
            super.run();
            synchronized (this){
                for(int i = 0; i <3; i ++){
                    System.out.print("2, ");
                }
            }
        }
    }

    static class T3 extends Thread{
        @Override
        public void run() {
            super.run();
            synchronized (this){
                for(int i = 0; i <3; i ++){
                    System.out.print("3, ");
                }
            }
        }
    }

}
