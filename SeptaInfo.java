import com.google.gson.annotations.SerializedName;

public class SeptaInfo  {
   @SerializedName("orig_departure_time")
   public String departureTime;
   @SerializedName("orig_arrival_time")
   public String arrivalTime;
   @SerializedName("orig_delay")
   public String delay;
   @SerializedName("orig_train")
   public String trainNumber;
   @SerializedName("orig_line")
   public String trainLine;
   
   public SeptaInfo()   {  }
   
   public SeptaInfo(String departureTime, String arrivalTime, String delay, String trainNumber) {
      this.departureTime = departureTime;
      this.arrivalTime = arrivalTime;
      this.delay = delay;
      this.trainNumber = trainNumber;
      this.trainLine = trainLine;
   }
   public void setDepartureTime(String departureTime) {
      this.departureTime = departureTime;
   }
   public void setArrivalTime(String arrivalTime)   {
      this.arrivalTime = arrivalTime;
   }
   public void setDelay(String delay)   {
      this.delay = delay;
   }
   public void settrainNumber(String trainNumber)  {
      this.trainNumber = trainNumber;
   }
   public String getDepartureTime() {
      return this.departureTime;
   }   
   public String getArrivalTime()   {
      return this.arrivalTime;
   }
   public String getDelay()   {
      return this.delay;
   }
   public String getTrainNumber()   {
      return this.trainNumber;
   }
   
   public String toString()   {
      return "Montco Rail Schedule: " + "\nTrain Number: " + this.trainNumber + "\nDeparture: " + 
             this.departureTime + "\nArrival: " + this.arrivalTime + "\nDelay: " + this.delay;
    
   }
}