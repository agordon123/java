
package javaapplication2;

import java.util.Random; //importing random number generator
import java.util.Scanner; //importing input/output class

public class JavaApplication2 {


    public static void main(String[] args) {
        // code using a for loop to print out odd numbers between 0-100
        for(int i=0; i <100 ; i++){// initializing for loop
            if (i % 2 != 0){ // if no remainder
                System.out.println("i = "+ i); //print i = # and go to a new line
            }
        }
    }
    
}
