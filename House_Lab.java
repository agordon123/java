/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package house_lab;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;

public class House_Lab extends Application{
    //method created to draw 10 stairs from the floor level of the house to the grasss
    public static void drawStairs(Group group){
        int size = 10;
        int i;
        int step = 20;
            Rectangle[] stairs = new Rectangle[size];
            for(i = 0; i <size; i++){
               stairs[i] = new Rectangle(275 - (i*step), (680 + (i*step)), 350 + (i*40) , (step) );
                stairs[i].setFill(Color.GREY);
                stairs[i].setStroke(Color.BLACK);
                group.getChildren().add(stairs[i]);
            }
          
    }
    // method to draw 2 pillars at a time taking in the coordinates and using a Rectangle Array
    public static void draw2Pillars(Group group,double x,double y){
        int size = 2;
        int length = 65;
        int width = 430;
        Rectangle[] pillars = new Rectangle[size];
        for (int i = 0; i < size; i++) {
            pillars[i] = new Rectangle(x+(i*175),y,length,width);
            pillars[i].setFill(Color.WHITE);
            pillars[i].setStroke(Color.BLACK);
            group.getChildren().add(pillars[i]);
        }}
    // method to draw the 2 side doors taking in the coordinates using a Rectangle Array
    public static void draw2Doors(Group group,double c, double d){    
        int size = 2;
    Rectangle[] sideDoors = new Rectangle[size];
    int length = 80;
    int width = 200;
        for (int i = 0; i < size; i++) {
            sideDoors[i] = new Rectangle(c + (i*450),d,length,width);
            sideDoors[i].setFill(Color.WHITE);
            sideDoors[i].setStroke(Color.BLACK);
            group.getChildren().add(sideDoors[i]);
        }
    }
    //method to draw 2 windows at a time, taking in both the coordinates and length and width - if statement
    //so the middle door size would be different at the starting point for middle door;
    public static void drawWindows(Group group, double e, double f,double length, double width){
    int size = 2;
    Rectangle[] windows = new Rectangle[size];
        for (int i = 0; i < size; i++) {
            if ( e != 400){
            windows[i] = new Rectangle(e+(i*40),f,length,width);
            windows[i].setFill(Color.BLACK);
            group.getChildren().add(windows[i]);
        }
            else{
            windows[i] = new Rectangle(e+(i*70),f,length,width);
            windows[i].setFill(Color.BLACK);
            group.getChildren().add(windows[i]); 
            }
        }
    }
    public static void main(String[] args) {
       launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception{
    
    
    stage.setTitle("Java in Da House");
// initiate group, scene/background fill
    Group gp1 = new Group();
    Scene scene = new Scene(gp1, 900,900);
    scene.setFill(Color.DODGERBLUE);
    
    // make grass
    Rectangle grass = new Rectangle(0,450,900,450);
    grass.setFill(Color.GREEN);
    grass.setStroke(Color.BLACK);
    gp1.getChildren().add(grass);
    
       // draw house outline
    Rectangle house = new Rectangle(100,200,700,650);
    house.setFill(Color.FIREBRICK);
    house.setStroke(Color.BLACK);
    gp1.getChildren().add(house);
    
      // draw the little stairtop area rectangle
    Rectangle stairTop = new Rectangle(100,680,700,15);
    stairTop.setFill(Color.WHITE);
    stairTop.setStroke(Color.BLACK);
    gp1.getChildren().add(stairTop);
    
    // use method to draw stairs with a foor loop of a Rectangular Array
    drawStairs(gp1);
    
  
    
    // create and draw roof using polygon object
    Polygon roof = new Polygon();
    roof.getPoints().addAll(new Double[]{
    80.0,200.0,
    820.0,200.0,
    450.0,50.0});
    roof.setFill(Color.WHITE);
    roof.setStroke(Color.BLACK);
    gp1.getChildren().add(roof);
    
    
        //add details to the house starting with the underhang
    Rectangle underhang = new Rectangle(100,200,700,30);
    underhang.setFill(Color.DARKGREY);
    underhang.setStroke(Color.BLACK);
    gp1.getChildren().add(underhang);
    
    //draw pillars with created method, initializing starting points twice for each group
    double x = 105,y= 230;
    draw2Pillars(gp1,x,y);
    // moving start point
    x = 555;
    draw2Pillars(gp1,x,y);
    
    //draw stairs using created method
    drawStairs(gp1);
    
    
    // draw pillar bases (I was having trouble writing a method at first but I could have done it that way also
    Rectangle pillarBase1 = new Rectangle(100,660,75,20);
    Rectangle pillarBase2 = new Rectangle(275,660,75,20);
    Rectangle pillarBase3 = new Rectangle(550,660,75,20);
    Rectangle pillarBase4 = new Rectangle(725,660,75,20);
    pillarBase1.setFill(Color.WHITE);
    pillarBase2.setFill(Color.WHITE);
    pillarBase3.setFill(Color.WHITE);
    pillarBase4.setFill(Color.WHITE);
    pillarBase1.setStroke(Color.BLACK);
    pillarBase2.setStroke(Color.BLACK);
    pillarBase3.setStroke(Color.BLACK);
    pillarBase4.setStroke(Color.BLACK);
    gp1.getChildren().add(pillarBase1);
    gp1.getChildren().add(pillarBase2);
    gp1.getChildren().add(pillarBase3);
    gp1.getChildren().add(pillarBase4);
    
    // draw pillar caps - same deal as the bases
    Rectangle pillarCap1 = new Rectangle(100,230,75,20);
    pillarCap1.setFill(Color.WHITE);
    pillarCap1.setStroke(Color.BLACK);
    Rectangle pillarCap2 = new Rectangle(275,230,75,20);
    pillarCap2.setFill(Color.WHITE);
    pillarCap2.setStroke(Color.BLACK);
    Rectangle pillarCap3 = new Rectangle(550,230,75,20);
    pillarCap3.setFill(Color.WHITE);
    pillarCap3.setStroke(Color.BLACK);
    Rectangle pillarCap4 = new Rectangle(725,230,75,20);
    pillarCap4.setFill(Color.WHITE);
    pillarCap4.setStroke(Color.BLACK);
    gp1.getChildren().add(pillarCap1);
    gp1.getChildren().add(pillarCap2);
    gp1.getChildren().add(pillarCap3);
    gp1.getChildren().add(pillarCap4);
    
    //draw front door
    Rectangle frontDoor = new Rectangle(375,450,150,230);
    frontDoor.setFill(Color.WHITE);
    frontDoor.setStroke(Color.BLACK);
    gp1.getChildren().add(frontDoor);
    
    //draw side doors using method
    double length = 20;
    double width = 20;
    double c = 185;
    double d = 480;
    draw2Doors(gp1,c,d);
   
    // fill in window panes on doors 1 by one using e and f as starting points
    double e = 195;
    double f = 500;
    drawWindows(gp1,e,f,length,width);
    f = 540;
    drawWindows(gp1,e,f,length,width);
    f = 580;
    drawWindows(gp1,e,f,length,width);
    f = 620;
    drawWindows(gp1,e,f,length,width);
    //change coordinates and dimensions for main door windows
   e = 400;
   f = 500;
   length = 30;
   drawWindows(gp1,e,f,length,width);
   f = 540;
   drawWindows(gp1,e,f,length,width);
   f = 580;
   drawWindows(gp1,e,f,length,width);
   f = 620;
   drawWindows(gp1,e,f,length,width);
   
   // draw windows on last door
   e = 645;
   f = 500;
   length = 20;
   width = 20;
   drawWindows(gp1,e,f,length,width);
   f = 540;
   drawWindows(gp1,e,f,length,width);
   f = 580;
   drawWindows(gp1,e,f,length,width);
   f = 620;
   drawWindows(gp1,e,f,length,width);
   
   // draw top grey window
   Rectangle topWindow = new Rectangle(400,350,100,50);
   topWindow.setFill(Color.GREY);
   topWindow.setStroke(Color.BLACK);
   gp1.getChildren().add(topWindow);
    
   // showing off my beautiful hard worked on JAVA FX Mansion 
   stage.setScene(scene);
   stage.show();
}

}
