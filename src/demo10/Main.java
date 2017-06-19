package demo10;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	Stage window;
	private Button btnOk;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		window = primaryStage;
		window.setTitle("Extract and Validate Input");

		TextField txtNumber = new TextField();
		btnOk = new Button("Ok");
		btnOk.setOnAction(e -> {
			isInt(txtNumber);
		});

		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(txtNumber, btnOk);
		Scene scene = new Scene(layout, 400, 300);

		window.setScene(scene);
		window.show();

	}

	private boolean isInt(TextField txtNumber) {
		try {
			int age = Integer.parseInt(txtNumber.getText());
			System.out.println(age);
			return true;
		} catch (Exception e) {
			System.out.println("Error: " + txtNumber.getText() +" is not number");
			return false;
		}
		
	}

}
