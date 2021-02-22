
package printticket;

import java.util.Scanner; //
public class PrintTicket {
/*
    Coded by Adam Gordon - method will take in persons
    name and age, and determine the price of their ticket.
    After it determines the ticket price, it will print out
    the name age and price
    */
    public static void printTicket(int age, String userName){
        double ticketPrice; // declare price variable
        if(age <= 13){ // instructions to price kids 13 and under
        ticketPrice = 9.99;
        System.out.println("Name: " +userName + " Age: "+age + " Price: " + ticketPrice); // prints ticket
        }
        if(age >13 && age < 65){ // instructions to price at regular rate
            ticketPrice = 19.99;
            System.out.println("Name: " +userName + " Age: "+age + " Price: " + ticketPrice); // prints ticket
        }
        if(age >= 65){ // instructions to price senior citizens
            ticketPrice = 12.99;
            System.out.println("Name: " +userName + " Age: "+age + " Price: " + ticketPrice); // prints ticket
        }
    }
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in); // declare input identifier and following variables
        int age; 
        String userName;
        
        System.out.println("What is your name?"); // asks for name input
        userName = scnr.next(); // takes name input
        System.out.println("what is your age?"); // asks for age input
        age = scnr.nextInt(); // takes age input
        
        printTicket(age,userName); // calls method to print ticket with age and name arguments fulfilled
              
    }
    
}
