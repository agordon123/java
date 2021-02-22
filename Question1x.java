/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question1x;

 import  java.util.Scanner; 

     public class Question1x {
    
  
    public static void main(String[] args) { 

      Scanner input =  new Scanner(System.in);

     // compute the circumference of a shape 
      System.out.println( "I can compute the circumference of one of the followings: Rect, Square, or Triangle "); 
      System.out.print( "Enter a shape: " ); 
      String shape = input.nextLine().trim(); 
    
     int circum =  0 ; 
     int side1, side2, side3; 
     if(shape.equals("Triangle")){ //instructions to compute perimeter of a triangle
        System.out.println("What is the length of side 1");
        side1 = input.nextInt();
        System.out.println("What is the length of side 2");
        side2 = input.nextInt();
        System.out.println("What is the length of side 3");
        side3 = input.nextInt();
        circum = side1+side2 +side3;
        System.out.println("The circumference is : " + circum);
    }
      if(shape.equals("Rect")){ // instructions to compute perimeter of a rect
        System.out.println("What is the length??");
        side1 = input.nextInt();
        System.out.println("What is the width?");
        side2 = input.nextInt(); 
        circum = (side1*2)+(side2*2) ;
        System.out.println("The circumference is : " + circum);
    }
       if(shape.equals("Square")){ // instructions to computer perimeter of a square
        System.out.println("Enter a side");
        side1 = input.nextInt();
        circum = side1*4 ;
        System.out.println("The circumference is : " + circum);
       }
      input.close(); 
      } 
     }
    