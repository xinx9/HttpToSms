/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Brad
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.sql.Time;
import java.util.Scanner;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main extends Application {

    private static final DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    //private static final DateTimeFormatter dtformat = new DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    /**
     * @param args the command line arguments
     */
   
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Timed Messaging");
        primaryStage.setScene( new Scene( new TextInterface(), 600, 200));
        primaryStage.setResizable(false);
        primaryStage.show();
        
        
        
        
        
        
        
        
        
    /*Scanner kb = new Scanner(System.in);   
    Information info = new Information();
    Time time = new Time(0, 0, 0);
    Date date = new Date();
    Calendar calendar = Calendar.getInstance();
    */
	/*System.out.println("Enter your email address: ");
        info.setSenderEmail(kb.nextLine());
        
        System.out.println("Enter recipients email: ");
        info.setTargetEmail(kb.nextLine());
        
        System.out.println();
        System.out.println("Message: ");
        info.setMessage(kb.nextLine());
        
        info.setTimeStamp(format.format(calendar.getTime()));
        
        System.out.println("Send text (yyyy/MM/dd HH:mm:ss) ");
        info.setSendTime(kb.nextLine());
        
        System.out.println("Message being sent:");
        System.out.println(info.getMessage());
        System.out.println();
        System.out.println("Message will be sent to " + info.getTargetEmail() + " at time: ");
        System.out.println("\t\t" + info.getSendTime());
        */
        
        
    }
     public static void main(String[] args) {
        Application.launch(args);
    }
    
}
