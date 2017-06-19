package demo8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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
		window.setTitle("Embedding Layouts");

		button = new Button("Click me");
		button.setOnAction(e -> {

		});
		// Top
		HBox topMenu = new HBox();
		Button buttonA = new Button("File");
		Button buttonB = new Button("Edit");
		Button buttonC = new Button("View");
		topMenu.getChildren().addAll(buttonA, buttonB, buttonC);

		// Bottom
		HBox bottomMenu = new HBox();
		Button buttonH = new Button("File");
		Button buttonK = new Button("Edit");
		Button buttonL = new Button("View");
		bottomMenu.getChildren().addAll(buttonH, buttonK, buttonL);

		// Left
		VBox leftMenu = new VBox();
		Button buttonD = new Button("File");
		Button buttonE = new Button("Edit");
		Button buttonF = new Button("View");
		leftMenu.getChildren().addAll(buttonD, buttonE, buttonF);

		// Right
		VBox rightMenu = new VBox();
		Button buttonQ = new Button("File");
		Button buttonY = new Button("Edit");
		Button buttonZ = new Button("View");
		rightMenu.getChildren().addAll(buttonQ, buttonY, buttonZ);

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(topMenu);
		borderPane.setLeft(leftMenu);
		borderPane.setBottom(bottomMenu);
		borderPane.setRight(rightMenu);

		StackPane layout = new StackPane();
		layout.getChildren().add(borderPane);
		Scene scene = new Scene(layout, 500, 300);
		window.setScene(scene);
		window.show();

	}

}
