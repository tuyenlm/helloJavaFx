package demo15;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	Stage window;
	private Button button;
	private ListView<String> listView;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		window = primaryStage;
		button = new Button("Ok");
		button.setOnAction(e -> {
			buttonClicker();
		});
		listView = new ListView<>();
		listView.getItems().addAll("Super man", "Hero", "Batman", "Titanic", "Spider Man","VietNam","NewYork");
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		VBox layout = new VBox();
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(listView, button);

		Scene scene = new Scene(layout, 200, 200);
		window.setScene(scene);
		window.show();
	}

	private void buttonClicker() {
		String message = "";
		ObservableList<String> movies;
		movies = listView.getSelectionModel().getSelectedItems();
		for (String m : movies) {
			message += m + "\n";
		}
		System.out.println(message);

	}

}
