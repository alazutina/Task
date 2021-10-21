import java.util.*;
import java.util.Scanner;


public class IndexReturn {

    final static String ARRAY = "Array";
    final static String NUMBER = "Number";
    final static String RESULT = "Rezult";

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


    static int[] Search(ArrayList <Integer> array, Integer num, int size){
        int [] result = new int [2];
        boolean flag = false;
        for( int i = 0; i<size;i++){
            for(int j = i+1;j<size;j++){
                if((array.get(i)+array.get(j))==num) {
                    result[0]=i;
                    result[1]=j;
                    flag=true;
                                        }
                if(flag==true) break;
            }
            if(flag==true) break;
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

        int rezult [] = Search(array,num,size);  // поиск

        System.out.println(RESULT+ " = [ "+ rezult[0]+", " +rezult[1]+" ]");  //резултьтат поиска

    }
}
