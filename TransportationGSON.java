import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class TransportationGSON  {
   // API
   private static final String SuburbanAPI_URL = "http://www3.septa.org/api/NextToArrive/index.php?req1=Suburban%20Station&req2=Penllyn&req3=1";
   private static final String DoylestownAPI_URL = "http://www3.septa.org/api/NextToArrive/index.php?req1=Doylestown&req2=Penllyn&req3=1";
  
   public static void main(String[] args) throws Exception {
// Suburban to Penllyn
      URL suburbanURL = new URL(SuburbanAPI_URL);
      HttpURLConnection conn = (HttpURLConnection) suburbanURL.openConnection();
      conn.setRequestMethod("GET");
      conn.connect();

      BufferedReader reader1 = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         Gson gson = new GsonBuilder().setPrettyPrinting().create();
         SeptaInfo[] responseJson = gson.fromJson(reader1, SeptaInfo[].class);
         System.out.println("Suburban Station to Penllyn Station Train: ");
         System.out.println("Train Number: " + responseJson[0].trainNumber);
         System.out.println("Septa Line: " + responseJson[0].trainLine);
         System.out.println("Departure Time: " + responseJson[0].departureTime);
         System.out.println("Arrival Time: " + responseJson[0].arrivalTime);
         System.out.println("Train Delay: " + responseJson[0].delay);
// Doylestown to Penllyn
      URL url2 = new URL(DoylestownAPI_URL);
      HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
         
      BufferedReader reader2 = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
         SeptaInfo[] responseJson2 = gson2.fromJson(reader2, SeptaInfo[].class);
         System.out.println("\nDoylestown Station to Penllyn Station Train: ");
         System.out.println("Train Number: " + responseJson[0].trainNumber);
         System.out.println("Septa Line: " + responseJson[0].trainLine);
         System.out.println("Departure Time: " + responseJson[0].departureTime);
         System.out.println("Arrival Time: " + responseJson[0].arrivalTime);
         System.out.println("Train Delay: " + responseJson[0].delay);

       String line2;
       StringBuilder responseBuilder2 = new StringBuilder();
         while ((line2 = reader1.readLine()) != null) {
             responseBuilder2.append(line2);
         }
         reader1.close();
         System.out.println(responseBuilder2.toString());
    }
}
  
 