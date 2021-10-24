import edu.princeton.cs.algs4.In;

import java.util.*;
import java.util.Scanner;


public class IndexReturn1 {

    final static String ARRAY = "Array";
    final static String NUMBER = "Number";
    final static String RESULT = "Rezult";
    final static String NO = "Нет такой пары";

    static ArrayList<Integer> fillArray(ArrayList<Integer> array, int size){
        Random r = new Random();
        System.out.print(ARRAY + " = [ ");
        for (int i = 0; i < size; i++) {
            boolean flag = false;

            if(i>0)System.out.print(", ");
            do {
                flag = false;
                int next = r.nextInt(20);
                for (int j = 0; j < i; j++) {
                    if (next == array.get(j)) flag = true;
                }
                if (flag == false) {
                    array.add(next);
                    System.out.print(array.get(i));//+", ");
                }
            } while (flag ==true);
        }
        System.out.println(" ] ");
        return array;
    }


    static int[] returnsIndexesOfSearch(ArrayList <Integer> array, Integer num, int size){
        int [] result = new int [2];

        ArrayList<Integer> notSorted = new ArrayList<>(); // храню неотсортированныый array


        int i = 0;
        for ( Integer d : array ) {notSorted.add(array.get(i)); i++;}

        Collections.sort(array);

         int indFirst =0;
         int indLast = size-1;

         while (!(indFirst==indLast)){ // пока индексы не встретятся

             Integer sum = array.get(indFirst)+array.get(indLast); // текущая сумма по индексам

             if(num.equals(sum)) {  // совпали сумма и исковое число
                 if(notSorted.indexOf(array.get(indFirst))<notSorted.indexOf(array.get(indLast))) {
                     result[0]=notSorted.indexOf(array.get(indFirst));

                     result[1]=notSorted.indexOf(array.get(indLast));}

                 else {
                     result[1]=notSorted.indexOf(array.get(indFirst));

                     result[0]=notSorted.indexOf(array.get(indLast));
                 }

                 return result;
             }

             if(num.compareTo(sum)>0)  { indFirst++; }   // сумма меньше
             if(num.compareTo(sum)<0)  { indLast--; }    // сумма больше

         }
        return result;
    }

    public static void main(String[] args) {

        int size = 10; // размер массива

        Integer num = 0; // Number

        ArrayList<Integer> array = new
                ArrayList<Integer>(size); // массив

        array = fillArray(array,size);  // заполнение массива

        System.out.print(NUMBER+" = ");

        try{
            num= (new Scanner(System.in).nextInt());  // ввод Number
        }catch (Exception e ){
            //
        }

        int rezult [] = returnsIndexesOfSearch(array,num,size);  // поиск

        if(rezult[0]==rezult[1])System.out.println(NO);
        else         System.out.println(RESULT+ " = [ "+ rezult[0]+", " +rezult[1]+" ]");  //резултьтат поиска

    }
}

