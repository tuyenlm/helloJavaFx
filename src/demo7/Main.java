package demo7;

import demo6.ConfirmBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
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
		window.setTitle("Closing the Program Properly");

		window.setOnCloseRequest(e->{
			e.consume();
			closeProgram();
		});
		
		button = new Button("Close program");
		button.setOnAction(e -> closeProgram());
		StackPane layout = new StackPane();
		layout.getChildren().add(button);

		Scene scene = new Scene(layout, 500, 350);
		window.setScene(scene);
		window.show();
	}

	private void closeProgram() {
		// TODO Auto-generated method stub
		Boolean anwser = ConfirmBox.display("Title", "Sure you want to exit");
		System.out.println(anwser);
		if (anwser) {
			window.close();
		}
	}

}
