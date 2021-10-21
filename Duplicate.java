import java.util.*;
import java.util.Scanner;


public class Duplicate {

    final static String ARRAY = "Array";
    final static String RESULT = "Rezult";
    final static String FALSE = "false";
    final static String TRUE = "true";
    final static String NO_DUB = "Дубликатов нет";
    final static String NUM = "Число ";
    final static String REPEAT =" повторяется ";
    final static String TIME = " раза";




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
        boolean flag = false;

       Collections.sort(input);

       for (int i = 0; i < input.size(); i++) {

                if(input.get(i)==input.get(i+1)) flag = true;

                if(flag ==true ) break;
         }

        return flag;

    }


    public static void main(String[] args) {

        int size = 10; // размер массива

        ArrayList<Integer> array = new
                ArrayList<Integer>(size); // массив

        Map<Integer,Integer> rezult = new HashMap<>(); // map с результатами поиска

        array = fillArray(array, size); // заполнение

        if(containsDuplicates(array)) System.out.println(RESULT+ ": "+TRUE);
        else System.out.println(RESULT+ ": "+FALSE);

    }


}

