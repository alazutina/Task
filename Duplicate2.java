import java.util.*;
import java.util.Scanner;


public class Duplicate2 {

    final static String ARRAY = "Array";
    final static String RESULT = "Rezult";
    final static String FALSE = "false";
    final static String TRUE = "true";


    static ArrayList<Integer> fillArray(ArrayList<Integer> array, int size){ // заполнение массива значениями
        Random r = new Random();
        System.out.print(ARRAY + " = [ ");
        for (int i = 0; i < size; i++) {

            if(i>0)System.out.print(", ");
            array.add(r.nextInt(30));
            System.out.print(array.get(i));
        }
        System.out.println(" ] ");
        return array;
    }
    static public boolean containsDuplicates(List<Integer> input){

        Set <Integer>set = new HashSet<Integer>() ;
        for ( Integer a: input ) {

            if(!set.add(a)) return true;

        }

        return  false;

    }


    public static void main(String[] args) {

        int size = 10; // размер массива

        ArrayList<Integer> array = new
                ArrayList<Integer>(size); // массив

        array = fillArray(array, size); // заполнение

        if(containsDuplicates(array)) System.out.println(RESULT+ ": "+TRUE);
        else System.out.println(RESULT+ ": "+FALSE);

    }


}

