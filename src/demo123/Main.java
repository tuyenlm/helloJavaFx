package demo123;

import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.application.Application;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent> {
	Button button;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Title of the Windows");
		button = new Button();
		button.setText("Click me");
		
//		button.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent event) {
//				// TODO Auto-generated method stub
//				System.out.println("Inner Class");
//			}
//			
//		});
		//Lambda Expressions using
		button.setOnAction(e -> {
			 System.out.println("Inner Class");
		});
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		
		Scene scene = new Scene(layout,300,350);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
}
