import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.net.URLEncoder;

public class MontcoRailSchedule extends Application {

   private static String getApiUrl (String station) throws Exception   {
      return "http://www3.septa.org/api/NextToArrive/index.php?req1=" + URLEncoder.encode(station, "UTF-8") + "&req2=Penllyn&req3=1";
   }
   
   private static SeptaInfo[] retrieveDataFromApi(String url) throws Exception   {
      URL suburbanURL = new URL(url);
      HttpURLConnection conn = (HttpURLConnection) suburbanURL.openConnection();
      conn.setRequestMethod("GET");
      conn.connect();   
      
      BufferedReader reader1 = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      return gson.fromJson(reader1, SeptaInfo[].class);
   }
   @Override
    public void start(Stage primaryStage) {
        // Create a label for the header
      Label headerLabel = new Label("Montco Rail Schedule");
      headerLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
   
        // Create a choice box for the starting station
      ChoiceBox<String> startingStationBox = new ChoiceBox<>();
      startingStationBox.getItems().addAll("Suburban Station", "Doylestown");
//       startingStationBox.setValue("Suburban");
        
        // Create a VBox to hold the destinations
      VBox destinationsBox = new VBox();
      Label destinationsLabel = new Label("Destination: Penllyn Station");
      destinationsBox.getChildren().add(destinationsLabel);
   
   // Create labels to display the departure and arrival ETA
      Label departureLabel = new Label();
      Label arrivalLabel = new Label();
      destinationsBox.getChildren().addAll(departureLabel, arrivalLabel);
   
   // Listen for changes to the starting station choice box
      startingStationBox.setOnAction(
         event -> {
            String selectedStation = startingStationBox.getValue();
         // Retrieve the data from the API
         // and update the destinations VBox
         // with the results
         
         // Assume the API response is a JSON object with departure and arrival ETA
         // You would need to modify this based on the actual API response
         try   {
            System.out.println(getApiUrl(selectedStation));
            SeptaInfo[] apiResponse = retrieveDataFromApi(getApiUrl(selectedStation));
            String departureTime = apiResponse[0].getDepartureTime();
            String arrivalTime = apiResponse[0].getArrivalTime();
         
         // Update the departure and arrival labels
            departureLabel.setText("Departure ETA: " + departureTime);
            arrivalLabel.setText("Arrival ETA: " + arrivalTime);
            }
            catch (Exception e)  {
               System.out.println(e);
            }
     });
   
   // Set the spacing and alignment for the destinations VBox
      destinationsBox.setSpacing(10);
      destinationsBox.setAlignment(Pos.CENTER);
        
   
        // Create an HBox to hold the header label and the starting station choice box
      HBox headerBox = new HBox(headerLabel, new Label("Starting Station: "), startingStationBox);
      headerBox.setAlignment(Pos.CENTER);
      headerBox.setSpacing(100);
   
        // Create a BorderPane and set the header to the HBox
      BorderPane root = new BorderPane();
      root.setTop(headerBox);
      root.setCenter(destinationsBox);
   
        // Create a scene with the BorderPane as the root node
      Scene scene = new Scene(root, 800, 600);
   
      primaryStage.setTitle("Montco Rail Schedule");
      primaryStage.setScene(scene);
      primaryStage.show();
   }
   public static void main(String[] args) {
      launch(args);
   }
}
