/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Brad
 */

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javafx.geometry.Insets;
//import smstimedmessaging.sendToGateway;


public class TextInterface extends GridPane
{
 private Label firstLabel;
 private Label secondLabel;
 private Label thirdLabel;
 private TextField toText;
 private TextArea messageText;
 private TextField sendText;
 private Button enterButton;
 
  private ComboBox year;
  private ComboBox month;
  private ComboBox day;
  private ComboBox hour;
  private ComboBox minute;
 
 private String[] ayear = {"2017", "2018", "2019", "2020", "2021"};
 private String[] amonth = {"January", "February", "March", "April", "May", "June", "July",
                           "August", "September", "October", "November", "December"};
 private String[] aday = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
                         "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", 
                         "24", "25", "26", "27", "28", "29", "30", "31"};
private String[] ahour = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",    
                            "15", "16", "17", "18", "19", "20", "21", "22", "23"}; 
private String[] aminute;
static GridPane grid = new GridPane();
public ArrayList<Information> arrayList;
 public TextInterface()
 {
    int count = 0;
    //Populate array for minute values
    aminute = new String[59];
    for(int i = 1; i < 60; i++)
    {
        if(count < 59)
        {aminute[count] = Integer.toString(i);
        count++;
        }
    }
    //aminute[aminute.length - 1] = " ";
    drawUI();
    customizeUI();
    registerEvents();
}

private void drawUI()
{
    //Initialize Labels
    firstLabel = new Label("To: ");
    secondLabel = new Label("Message: ");
    thirdLabel = new Label("Send Time: ");
    
    //Place labels in grid
    this.add(firstLabel, 0, 0);
    this.add(secondLabel, 0, 2);
    this.add(this.thirdLabel, 0, 4);

    //Initialize TextFields
    toText = new TextField();
    messageText = new TextArea();
    sendText = new TextField();
    
// define width limits
messageText.setMinWidth(50);
messageText.setPrefWidth(50);
messageText.setMaxWidth(200);
messageText.setPrefHeight(15);
messageText.setWrapText(true);

// add listner
messageText.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        messageText.setPrefHeight(messageText.getText().length() * 1); // why 7? Totally trial number.
    }
  }
);
    //Combo Boxes holding date and time values
    year = new ComboBox();
    month = new ComboBox();
    day = new ComboBox();
    hour = new ComboBox();
    minute = new ComboBox();
    
    //Populate Combo boxes
    year.getItems().addAll(ayear);
    month.getItems().addAll(amonth);
    day.getItems().addAll(aday);
    hour.getItems().addAll(ahour);
    minute.getItems().addAll(aminute);
    
    //Set combo box text
    year.setPromptText("Year");
    month.setPromptText("Month");
    day.setPromptText("Day");
    hour.setPromptText("Hour");
    minute.setPromptText("Minute");
    
    //Place text boxes and combo boxes in grid
    this.add(toText, 1, 0);
    this.add(messageText, 1, 2);
    grid.add(year, 1, 4);
    grid.add(month, 2, 4);
    grid.add(day, 3, 4);
    grid.add(hour, 4, 4);
    grid.add(minute, 5, 4);
    this.add(grid, 1, 4);

    //Enter Button
    enterButton = new Button("Enter");
    grid.add(enterButton, 3, 7);
    
}

private void customizeUI()
{
    this.setHgap(5);
    this.setVgap(10);
    grid.setHgap(5);
}

private void registerEvents()
{
    enterButton.setOnAction( e -> enterInfo());
}

private void enterInfo(){
 
    //Obtain values from combo boxes
    String y = (String)year.getValue();
    String mon = (String)month.getValue();
    String d = (String)day.getValue();
    String h = (String)hour.getValue();
    String mins = (String)minute.getValue();
    
    Information info= new Information(y, mon, d, h, mins);
    
     //Set recipient email and message being set in class Info
    info.setTargetNumber(toText.getText());
    info.setMessage(messageText.getText());
    
    //Set send time in Info Class
    info.setSendTime(y, mon, d, h, mins);
    
    //Get current time stamp
    Date date = new Date();
    String timeYear = Integer.toString(date.getYear());
    String timeMonth = Integer.toString(date.getMonth());
    String timeDay = Integer.toString(date.getDay());
    String timeHour = Integer.toString(date.getHours());
    String timeMin = Integer.toString(date.getMinutes());
    
    info.setTimeStamp(timeYear, timeMonth, timeDay, timeHour, timeMin);
    sendToGateway stg = new sendToGateway(info.parseMe());
    //Clear TextFields
    toText.setText(" ");
    messageText.setText(" ");
    sendText.setText(" ");
    
    //Clear Items
    year.getItems().clear();
    month.getItems().clear();
    day.getItems().clear();
    hour.getItems().clear();
    minute.getItems().clear();
 
    //Reset Labels
    year.setPromptText("Year");
    month.setPromptText("Month");
    day.setPromptText("Day");
    hour.setPromptText("Hour");
    minute.setPromptText("Minute");
    
    arrayList.add(info);
     
}
}
