

public class UseMeIfEveryThingFails {
    public String originator;
    public String recipient;
    public String message;
    public String timeToSend;
    public String currentTime;
    public String timeDifference;
    
    UseMeIfEveryThingFails(){   
    }
    UseMeIfEveryThingFails(String originator,String recipient, String message,
            String timeToSend, String currentTime, String timeDifference){
        this.originator = originator;
        this.recipient = recipient;
        this.message = message;
        this.timeToSend = timeToSend;
        this.currentTime = currentTime;
        this.timeDifference = timeDifference;
    }
    
    public void output(){
        System.out.println(
          "At: "
        + this.currentTime
        + " User: "
        + this.originator
        + " sent: " 
        + this.message
        + " to: "
        + this.recipient
        + " at: "
        + this.timeToSend
        + " the Current Time Difference is: "
        + this.timeDifference);
        
    }
}
