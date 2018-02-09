

import java.sql.Time;
import java.util.Date;
   

public class Information {
	private String senderNumber = "3145360171";
	private String targetNumber;
	private String messageSent;
	private String timeStamp;
	private String sendTime;
        private String year;
        private String month;
        private String day;
        private String hour;
        private String minute;
	public Information()
	{
	
	}
        
        public Information(String year, String month, String day, String hour, String minute)
        {
            this.year = year;
            this.month = month;
            this.day = day;
            this.hour = hour;
            this.minute = minute;  
        }
	
	public void setSenderNumber(String number)
	{
		senderNumber = number;
	}

	public String getSenderNumber()
	{
		return senderNumber;
	}
	
	public void setTargetNumber(String number)
	{
		targetNumber = number;
	}
	
	public String getTargetNumber()
	{
		return targetNumber;
	}
	
	public void setMessage(String message)
	{
		messageSent = message;
	}
	
	public String getMessage()
	{
		return messageSent;
	}
	
	public void setTimeStamp(String year, String month, String day, String hour, String minute)
	{
		timeStamp = String.format(year + "/" + month + "/" + day + "/" +
                                            hour + "/" + minute);
	}
	
	public String getTimeStamp()
	{
		return timeStamp;
	}
	
	public void setSendTime(String year, String month, String day, String hour, String minute)
	{
		sendTime = String.format(year + "/" + month + "/" + day + "/" +
                                            hour + "/" + minute);
	}
	
	public String getSendTime() 
	{
		return sendTime;
	}
	
	public String parseMe()
	{
		return (this.senderNumber + ":" + targetNumber + ":" + messageSent + ":" 
							  + getTimeStamp() + ":" + getSendTime());
	}
}

    

