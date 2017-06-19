package demo6;

import javafx.stage.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ConfirmBox {
	private static Label label;
	private static boolean anwser;

	public static boolean display(String title, String message) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);

		label = new Label();
		label.setText(message);

		// Create two buttons
		Button yesButton = new Button("Yes");
		Button noButton = new Button("No");

		yesButton.setOnAction(e -> {
			anwser = true;
			window.close();
		});

		noButton.setOnAction(e -> {
			anwser = false;
			window.close();
		});
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label,yesButton,noButton);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		return anwser;

	}
}
