import java.util.*;
import java.util.Scanner;


public class Duplicates {

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

    static Map<Integer,Integer> Search(ArrayList <Integer> array, int size) {  //поиск дубликатов

        Map<Integer,Integer> result = new HashMap<>();

        Integer number = 0; // найденное число
        int count = 1;      // количество раз


        for (int i = 0; i < size; i++) {

            count = 1;
            number = array.get(i);

            for (int j = i + 1; j < size; j++) {
                    if (number == array.get(j))  count++;
            }

            if (count > 1) {
                boolean flag = false; // будем считать , что этого числа еще не было

                for(Map.Entry<Integer, Integer> entry: result.entrySet()) {
                    Integer key = entry.getKey();
                    if (number==key) flag=true;  //было
                }
                if (flag == false) {
                    result.put(number,count);
                }
            }
        }
        return result;
    }

    static void PrintRezult(Map<Integer,Integer> rezult){
        if(rezult.size()==0){
            System.out.println(RESULT+ ": " +FALSE);
            System.out.println(NO_DUB);
        }
        else{
            System.out.println(RESULT+": "+true);

            for(Map.Entry<Integer, Integer> entry: rezult.entrySet()) {
                // get key
                Integer key = entry.getKey();
                // get value
                Integer value = entry.getValue();

                System.out.println(NUM+key+REPEAT+value +TIME);
            }


        }

    }

    public static void main(String[] args) {

        int size = 10; // размер массива

       ArrayList<Integer> array = new
                ArrayList<Integer>(size); // массив

        Map<Integer,Integer> rezult = new HashMap<>(); // map с результатами поиска

        array = fillArray(array, size); // заполнение

        rezult = Search(array,size); // поиск

        PrintRezult(rezult); // вывод

    }


}
