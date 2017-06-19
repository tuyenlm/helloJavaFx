package demo9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
	Stage window;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		window = primaryStage;
		window.setTitle("GridPane");

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(0);
		grid.setHgap(10);

		// Name label
		Label nameLabel = new Label("Username");
		GridPane.setConstraints(nameLabel, 0, 0);

		// Name Input
		TextField nameInput = new TextField("Bucky");
		GridPane.setConstraints(nameInput, 1, 0);

		// Password label
		Label passLabel = new Label("Password");
		GridPane.setConstraints(passLabel, 0, 1);

		// Password input
		TextField passInput = new TextField();
		passInput.setPromptText("password");
		GridPane.setConstraints(passInput, 1, 1);

		Button loginButton = new Button("Log in");
		GridPane.setConstraints(loginButton, 1, 2);

		grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);

		Scene scene = new Scene(grid,400,300);
		window.setScene(scene);
		window.show();
	}

}
