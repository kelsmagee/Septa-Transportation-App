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
   
   public SeptaInfo(String departureTime, String arrivalTime, String delay, String trainNumber)
   {
   this.departureTime = departureTime;
   this.arrivalTime = arrivalTime;
   this.delay = delay;
   this.trainNumber = trainNumber;
   this.trainLine = trainLine;
   }

}