package net.sgoliver.android.navigationdrawer.codingExercises;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by User on 10/25/2016.
 */

public class ReversePhrase {

    public static void main(String...args){
        System.out.println("Type a phrase: ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
//        reverseSplit(input);
        reverseChars(input);
    }

    public static void reverseSplit(String input){
        String []arrsplit = input.split(" ");

        System.out.println("Phrase : " + input);
        System.out.print("Reverse: " );
        for(int i = arrsplit.length -1; i >= 0; i --){
            System.out.print(arrsplit[i] + " ");
        }
    }

    public static void reverseChars(String input){
        char[] arrChars = input.toCharArray();

        String word = "";
        ArrayList <String>arrList = new ArrayList();

        for(int i = 0; i < arrChars.length; i ++){
            if(arrChars[i] != ' '){
                word += arrChars[i];
            }else{
                arrList.add(word);
                word = "";
            }
        }

        arrList.add(word);

        for(int i = arrList.size() -1; i >=0; i --){
            System.out.print(arrList.get(i) + " ");
        }
    }
}
