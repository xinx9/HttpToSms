


import java.net.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class sendToGateway {
    public String recipient = "+3145360171";
    public String username = "admin";
    public String password = "abc123";
    public String message;
    public String originator;
    
    sendToGateway(){}
    
    sendToGateway(String parser){
        initiateData(parser);
    }
    
    public void talkToGateway(){
        try {
            

            String requestUrl = "http://127.0.0.1:9505/api?action=sendmessage&"
                    + "username=" + URLEncoder.encode(username, "UTF-8")
                    + "&password=" + URLEncoder.encode(password, "UTF-8")
                    + "&recipient=" + URLEncoder.encode(recipient, "UTF-8")
                    + "&messagetype=SMS:TEXT"
                    + "&messagedata=" + URLEncoder.encode(message, "UTF-8")
                    + "&originator=+" + URLEncoder.encode(originator, "UTF-8")
                    + "&serviceprovider=GSMModem1"
                    + "&responseformat=html";

            URL url = new URL(requestUrl);
            
            HttpURLConnection uc = (HttpURLConnection) url.openConnection();

            System.out.println(uc.getResponseMessage());

            uc.disconnect();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }

    }
    
    
    
    // senderNumber : targetNumber : messageSent : timeStamp : sendTime
    // timeStamp and sendTime == "YYYY/MM/DD/hh/mm"
    public void initiateData(String parseMe){
        String[] parsed = parseInfo(parseMe);
        
        this.originator = parsed[1];
        this.message = parsed[2];
        
        String[] timeStampParsed = parseIt(parsed[3]);
        
        String[] sendTimeParsed = parseIt(parsed[4]);
        
        timeStampParsed[1] = monthToInt(timeStampParsed[1]);
        
        sendTimeParsed[1] = monthToInt(sendTimeParsed[1]);
        
        int[] intTimeStamp = new int[timeStampParsed.length];
        int[] intSendTime = new int[sendTimeParsed.length];
        
        for (int i = 0; i < timeStampParsed.length; i++) {
            intTimeStamp[i] = Integer.parseInt(timeStampParsed[i]);
        }
        for (int i = 0; i < sendTimeParsed.length; i++) {
            intSendTime[i] = Integer.parseInt(sendTimeParsed[i]);
        }
        
        timedMessage(intTimeStamp, intSendTime);
        
    }
    
    public void timedMessage(int[] timeStamp, int[] sendTime){
        while(compareTime(timeStamp, sendTime)){
            incrementTime(timeStamp);
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException ex) {
                ex.toString();
            }
        }
        talkToGateway();
    }
    
    public boolean compareTime(int[] timeStamp, int[] sendTime){
        boolean flag = false;
        for (int i = 0; i < timeStamp.length; i++) {
            if(timeStamp[i] == sendTime[i]){
                flag = true;
            }
        }
        return flag;
    }
    //           0   1  2  3  4
    //time = " YYYY/MM/DD/hh/mm "
    public int[] incrementTime(int[] timeStamp){
        timeStamp[4] += 1;
            if(timeStamp[4] >= 60){
                timeStamp[3] += 1;
            }
            if(timeStamp[3] >= 24){
                timeStamp[2] +=1;
            }
            if(timeStamp[2] >= 31){
                timeStamp[1] +=1;
            }
            if(timeStamp[1] > 12){
                timeStamp[0] += 1;
            }
        return timeStamp;
    }
    
    public static String[] parseInfo(String x){
        String[] parsed = x.split(":");
        return parsed;
    }
    public static String[] parseIt(String x){
         String[] fullParsed = x.split("/");
        return fullParsed;
    }
    
    public static String monthToInt(String month){
        int x = 0;
        if(month.equals("January")){
            x = 1;
        }else if(month.equals("Febuary")){
            x = 2;
        }else if(month.equals("March")){
            x = 3;
        }else if(month.equals("April")){
            x = 4;
        }else if(month.equals("May")){
            x = 5;
        }else if(month.equals("June")){
            x = 6;
        }else if(month.equals("July")){
            x = 7;
        }else if(month.equals("August")){
            x = 8;
        }else if(month.equals("September")){
            x = 9;
        }else if(month.equals("October")){
            x = 10;
        }else if(month.equals("November")){
            x = 11;
        }else if(month.equals("December")){
            x = 12;
        }
        return "" + x;
    }
    
    public static String intToMonth(String month){
        int x = Integer.parseInt(month);
        String y = "";
        switch(x){
            case 1:
                y = "January";
                break;
            case 2:
                y = "febuary";
                break;
            case 3:
                y = "march";
                break;
            case 4:
                y = "april";
                break;
            case 5:
                y = "may";
                break;
            case 6:
                y = "june";
                break;
            case 7:
                y = "july";
                break;
            case 8:
                y = "august";
                break;
            case 9:
                y = "september";
                break;
            case 10:
                y = "october";
                break;
            case 11:
                y = "november";
                break;
            case 12:
                y = "december";
                break;
        }
        return y;
    }
    
    
}
