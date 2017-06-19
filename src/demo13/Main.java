package demo13;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	Stage window;
	private Button button;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		window = primaryStage;
		window.setTitle("Listening for Selector Changes");

		ChoiceBox<String> choiceBox = new ChoiceBox<String>();
		choiceBox.getItems().addAll("Tuyen", "Hanh", "Tham", "Lim", "Quynh");
		choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValude, newValue)->System.out.println(newValue));

		button = new Button("Ok");

		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(choiceBox, button);
		Scene scene = new Scene(layout, 300, 200);
		window.setScene(scene);
		window.show();
	}

}
