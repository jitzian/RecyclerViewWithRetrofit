package net.sgoliver.android.navigationdrawer.codingExercises;

/**
 * Created by User on 10/25/2016.
 */

public class SyncThreads {

    public static void main(String...args){
        ThreadDemo t1 = new ThreadDemo(1, "t1");
        ThreadDemo t2 = new ThreadDemo(2, "t2");
        ThreadDemo t3 = new ThreadDemo(3, "t3");

        for(int i = 0; i < 4; i ++){
            t1.start();
            t2.start();
            t3.start();
        }
    }

    public static class ThreadDemo extends Thread{
        Thread t;
        String threadName;
        int number;

        ThreadDemo(int number, String threadName){
            this.number = number;
            this.threadName = threadName;
        }


        @Override
        public void run() {
            super.run();
            synchronized (threadName){
            }
        }

        @Override
        public void start() {
            if(t == null){
                t = new Thread(this, threadName);
            }
            System.out.print(number + ", ");
        }
    }

}
