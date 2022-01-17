package LinearSearch;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [] intArray = {20, 35, -15, 88, 32, 23, 56, 7};
        int toBeSearched1 = -15;
        int toBeSearched2 = 7;
        int toBeSearched3 = 30;
        System.out.println("The index of "+toBeSearched1+" is: "+linearSearch(intArray,toBeSearched1));
        System.out.println("The index of "+toBeSearched2+" is: "+linearSearch(intArray,toBeSearched2));
        System.out.println("The index of "+toBeSearched3+" is: "+linearSearch(intArray,toBeSearched3));

    }

    public static int linearSearch(int[] intArray, int value) {
        for (int i = 0; i <intArray.length ; i++) {
            if (intArray[i]==value){
                return i;
            }
        }
        return -1;
    }
}
