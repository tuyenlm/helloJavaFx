package department;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

public class DepartmentsController {
	@FXML private DatePicker datePicker;
	  public void initDeparments() {
		    datePicker.setOnAction(new EventHandler<ActionEvent>() {
		      @Override public void handle(ActionEvent event) {

		      }
		    });
		  }
}
