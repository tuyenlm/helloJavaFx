package demo11;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
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
		window.setTitle("CheckBox");

		CheckBox box1 = new CheckBox("Tuyen");
		CheckBox box2 = new CheckBox("Hanh");
		Button ok = new Button("OK");
		ok.setOnAction(e -> {
			handleOptions(box1, box2);
		});
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(box1, box2, ok);

		Scene scene = new Scene(layout, 300, 200);

		window.setScene(scene);
		window.show();
	}

	

	private void handleOptions(CheckBox box1, CheckBox box2) {
		String messege = "Order: \n";
		if (box1.isSelected()) {
			messege += box1.getText() + "\n";
		}

		if (box2.isSelected()) {
			messege += box2.getText() + "\n";
		}
		System.out.println(messege);
	}

}
