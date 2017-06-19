package demo14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	Stage window;
	private ComboBox<String> comboBox;
	private Button button;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		window = primaryStage;
		window.setTitle("ComboBox");

		comboBox = new ComboBox<>();
		comboBox.getItems().addAll("Tuyen", "Hanh", "Lim", "Tham");
		comboBox.setPromptText("Who are you like ?");
		comboBox.setOnAction(e->System.out.println(comboBox.getValue()));
		comboBox.setEditable(true);
		button = new Button("Ok");
		button.setOnAction(e -> getValue());

		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(comboBox,button);
		
		Scene scene = new Scene(layout,300,200);
		window.setScene(scene);
		window.show();
		
	}

	private void getValue() {
		System.out.println(comboBox.getValue());

	}

}
