package demo5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
	Stage window;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		Button button = new Button();
		button.setText("Click me");
		button.setOnAction(e->{
			Alert.display("Title of window", "This alert box is awesome");;
		});
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		Scene scene = new Scene(layout,200,250);
		window.setScene(scene);
		window.show();
	}

}
