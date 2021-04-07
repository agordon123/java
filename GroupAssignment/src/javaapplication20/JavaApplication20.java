/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication20;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author leoba
 */
public class JavaApplication20 extends Application{
    
    
    private Circle circle1;
    
    private Circle[] points = {new Circle(300,50,10), new Circle(300,450,10),new Circle(100,250,10)};

    private Line[] lines = {new Line(300,50,300,450), new Line(300,450,100,250), new Line(100,250,300,50)};
    
    private Text[] angles = {new Text(), new Text(), new Text()};
    
    private Group root;
    
    
    @Override
    public void start(Stage stage){
        
        // Initialize the root group
        root = new Group();
        
        // Design big circle
        circle1 = new Circle(300,250,200);
        circle1.setStroke(Color.BLACK);
        circle1.setFill(Color.WHITE);
        circle1.setStrokeWidth(3);
        
        //Some designs for the lines
        lines[0].setStrokeWidth(2);
        lines[1].setStrokeWidth(2);
        lines[2].setStrokeWidth(2);
            
        for(int i=0; i<3;i++){
            points[i].setStroke(Color.BLACK);
            points[i].setFill(Color.RED);
        }
        
        root.getChildren().addAll(circle1,lines[0], lines[1], lines[2],points[0], points[1], points[2], 
                angles[0], angles[1], angles[2]);
        
        //Print Angles
        setAngles();
        
        // Mouse Event for points[0]
        points[0].setOnMouseDragged(event->{
            if(points[0].contains(event.getX(), event.getY())){
                
                // Limit Drag of Points
                limitDrag(event, points[0]);
                
                //Update lines
                lines[0].setStartX(points[0].getCenterX());
                lines[0].setStartY(points[0].getCenterY());
                lines[0].setEndX(points[1].getCenterX());
                lines[0].setEndY(points[1].getCenterY());
                
                lines[1].setStartX(points[0].getCenterX());
                lines[1].setStartY(points[0].getCenterY());
                lines[1].setEndX(points[2].getCenterX());
                lines[1].setEndY(points[2].getCenterY());    
               
                lines[2].setStartX(points[1].getCenterX());
                lines[2].setStartY(points[1].getCenterY());
                lines[2].setEndX(points[2].getCenterX());
                lines[2].setEndY(points[2].getCenterY()); 

                // Compute Angles
                setAngles();
                 
            }}); 
        
        // MouseEvent for Points[1]
        points[1].setOnMouseDragged(event2->{
            if(points[1].contains(event2.getX(), event2.getY())){
               
                // Limit Drag of Points
                limitDrag(event2, points[1]);

                //Update lines
                lines[0].setStartX(points[0].getCenterX());
                lines[0].setStartY(points[0].getCenterY());
                lines[0].setEndX(points[1].getCenterX());
                lines[0].setEndY(points[1].getCenterY());
                
                lines[1].setStartX(points[0].getCenterX());
                lines[1].setStartY(points[0].getCenterY());
                lines[1].setEndX(points[2].getCenterX());
                lines[1].setEndY(points[2].getCenterY());    
               
                lines[2].setStartX(points[1].getCenterX());
                lines[2].setStartY(points[1].getCenterY());
                lines[2].setEndX(points[2].getCenterX());
                lines[2].setEndY(points[2].getCenterY());
                
                // Compute Angles
                setAngles();                
            }});

        //MouseEvent for points[2]
        points[2].setOnMouseDragged(event3->{
            if(points[2].contains(event3.getX(), event3.getY())){

                // Limit Drag of Points
                limitDrag(event3, points[2]);

                //Update lines
                lines[0].setStartX(points[0].getCenterX());
                lines[0].setStartY(points[0].getCenterY());
                lines[0].setEndX(points[1].getCenterX());
                lines[0].setEndY(points[1].getCenterY());
                
                lines[1].setStartX(points[0].getCenterX());
                lines[1].setStartY(points[0].getCenterY());
                lines[1].setEndX(points[2].getCenterX());
                lines[1].setEndY(points[2].getCenterY());    
               
                lines[2].setStartX(points[1].getCenterX());
                lines[2].setStartY(points[1].getCenterY());
                lines[2].setEndX(points[2].getCenterX());
                lines[2].setEndY(points[2].getCenterY());  

                // Compute Angles
                setAngles();                
            }});    
            
        // This set the scene and displays it
        Scene scene = new Scene( root, 600, 500, Color.WHITE);
       
        
        stage.setTitle("Week9_Lab");
        stage.setScene(scene);
        stage.show();
        
    }
    
    private void setAngles(){
    
        double x1 = points[0].getCenterX();
        double y1 = points[0].getCenterY();
        
        double x2 = points[1].getCenterX();
        double y2 = points[1].getCenterY();
        
        double x3 = points[2].getCenterX();
        double y3 = points[2].getCenterY();
        
        //Distance from points[0] to points[1] ( lines[0])
        double distance1 = FindDistance( x1, y1, x2, y2);
        
        // Distance from points[1] to points[2] ( lines[1])
        double distance2 = FindDistance( x2, y2, x3, y3);
        
        // Distance from points[2] to points[0] ( lines[2])
        double distance3 = FindDistance( x3, y3, x1, y1);
        
        // Angle A
        double[] Angle = new double[3];
        Angle[0] = Math.acos(((distance1 * distance1) - (distance2 * distance2) - (distance3 * distance3)) 
                / ( -2 * distance2 * distance3));
        
        // Angle B
        Angle[1] = Math.acos(((distance2 * distance2) - (distance1 * distance1) - (distance3 * distance3)) 
                / ( -2 * distance1 * distance3));

        // Angle C
        Angle[2] = Math.acos(((distance3 * distance3) - (distance2 * distance2) - (distance1 * distance1)) 
                / ( -2 * distance1 * distance2));
        
        // Convert to Degrees
        double[] degree = new double[3];
        degree[0] = Math.toDegrees(Angle[0]);
        degree[1] = Math.toDegrees(Angle[1]);
        degree[2] = Math.toDegrees(Angle[2]);
        
        double radius = circle1.getRadius();
        
        // Set the coordinates of the Angle text
        angles[0].setX(points[0].getCenterX());
        angles[0].setY(points[0].getCenterY());
        angles[1].setX(points[1].getCenterX());
        angles[1].setY(points[1].getCenterY());
        angles[2].setX(points[2].getCenterX());
        angles[2].setY(points[2].getCenterY());
        
        // Convert degree to string and print 
        for(int i=0; i<3;i++){
            // "/u00B0" java code for degrees symbol
            angles[i].setText( String.format("%.0f", degree[i]).concat("\u00B0"));
        }
    }
    
    public double FindDistance( double x1, double y1, double x2, double y2){
        
        double distance=0;
        
        distance = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
                
        return distance;
    }
    
    public void limitDrag( MouseEvent event, Circle point){
        
        // Found this code online that limits the drag according to the size of the circle
        // in this case circle1.
        // SOURCE: https://stackoverflow.com/questions/42584829/javafx-mouse-move-on-a-circle-path
        
        Point2D Center = new Point2D(circle1.getCenterX(), circle1.getCenterY());
        Point2D mouse = new Point2D(event.getX(), event.getY());
        Point2D centerToMouse = mouse.subtract(Center);
        Point2D centerToNewPoint = centerToMouse.normalize().multiply(circle1.getRadius());
        Point2D newPoint = centerToNewPoint.add(Center);
        point.setCenterX(newPoint.getX());
        point.setCenterY(newPoint.getY());
        
    }
    
    
    public static void main(String[] args) {
      launch(args);
    }
    
}
