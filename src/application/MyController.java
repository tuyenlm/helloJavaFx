package application;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
 
public class MyController implements Initializable {
 
   @FXML
   private Button btnButton;
  
   @FXML
   private TextField txtMyText;
  
   @Override
   public void initialize(URL location, ResourceBundle resources) {
 
       // TODO (don't really need to do anything here).
       // TODO (Thực sự cũng không cần thiết viết gì ở đây).
      
   }
 
   // When user click on myButton
   // this method will be called.
   // Khi người dùng nhấn vào Button myButton
   // phương thức này sẽ được gọi
   public void showDateTime(ActionEvent event) {
       System.out.println("Button Clicked!");
      
       Date now= new Date();
      
       DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
      
         // Dữ liệu Model
        String dateTimeString = df.format(now);
  
        // Hiển thị lên VIEW.
        txtMyText.setText(dateTimeString);
      
   }
  
}