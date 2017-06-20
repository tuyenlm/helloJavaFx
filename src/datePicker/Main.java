package datePicker;

import java.util.Date;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

public class Main extends Application {
	TableView<BirthdayEvent> table;
	private TextField nameInput;
	private TextField priceInput;
	private TextField quantityInput;

	public static void main(String[] args) {
		launch(args);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(new Group());

		stage.setTitle("DatePicker TableCell Sample");

		final ObservableList<BirthdayEvent> dataList = FXCollections.observableArrayList(
				new BirthdayEvent(1, "Jacob", Double.parseDouble("45.50"), 10, new Date()),
				new BirthdayEvent(2, "Isabella", 45.50, 10, new Date()),
				new BirthdayEvent(3, "Ethan", 12.4, 120, new Date()),
				new BirthdayEvent(4, "Emma", 67.26, 15, new Date()),
				new BirthdayEvent(5, "Michael", 80.26, 12, new Date()));

		table = new TableView<>();
		table.setEditable(true);

		// Id column
		TableColumn<BirthdayEvent, Double> idColumn = new TableColumn<>("Id");
		idColumn.setMinWidth(100);
		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		idColumn.setVisible(false);

		TableColumn<BirthdayEvent, String> nameColumn = new TableColumn<BirthdayEvent, String>("Name");
		nameColumn.setPrefWidth(90);
		nameColumn.setEditable(true);
		nameColumn.setCellValueFactory(new PropertyValueFactory<BirthdayEvent, String>("name"));
		nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		nameColumn.setOnEditCommit(event -> {
			String value = event.getNewValue() != null ? event.getNewValue() : event.getOldValue();
			((BirthdayEvent) event.getTableView().getItems().get(event.getTablePosition().getRow())).setName(value);
			System.out.println("date: "
					+ table.getColumns().get(4).getCellObservableValue(event.getTablePosition().getRow()).getValue());
			System.out.println("id: "
					+ table.getColumns().get(0).getCellObservableValue(event.getTablePosition().getRow()).getValue());
			System.out.println("price: "
					+ table.getColumns().get(2).getCellObservableValue(event.getTablePosition().getRow()).getValue());
			System.out.println("quantity: "
					+ table.getColumns().get(3).getCellObservableValue(event.getTablePosition().getRow()).getValue());

			System.out.println("name: " + value);

		});

		// Price column
		TableColumn<BirthdayEvent, Double> priceColumn = new TableColumn<>("Price");
		priceColumn.setMinWidth(100);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		priceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
		priceColumn.setEditable(true);
		// Quantity column
		TableColumn<BirthdayEvent, String> quantityColumn = new TableColumn<>("Quantity");
		quantityColumn.setMinWidth(100);
		quantityColumn.setEditable(true);
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		quantityColumn.setOnEditCommit(event -> {
			String value = event.getNewValue() != null ? event.getNewValue() : event.getOldValue();
			((BirthdayEvent) event.getTableView().getItems().get(event.getTablePosition().getRow()))
					.setQuantity(Integer.parseInt(value));
			System.out.println("id: "
					+ table.getColumns().get(0).getCellObservableValue(event.getTablePosition().getRow()).getValue());
			System.out.println("name: "
					+ table.getColumns().get(1).getCellObservableValue(event.getTablePosition().getRow()).getValue());
			System.out.println("price: "
					+ table.getColumns().get(2).getCellObservableValue(event.getTablePosition().getRow()).getValue());
			System.out.println("quantity: " + value);
			System.out.println("date: "
					+ table.getColumns().get(4).getCellObservableValue(event.getTablePosition().getRow()).getValue());
			table.refresh();
		});

		TableColumn<BirthdayEvent, Date> dateColumn = new TableColumn<BirthdayEvent, Date>("Date");
		dateColumn.setEditable(true);
		dateColumn.setPrefWidth(75);
		dateColumn.setMinWidth(200);

		dateColumn.setCellValueFactory(new PropertyValueFactory<BirthdayEvent, Date>("date"));
		dateColumn.setCellFactory(p -> {
			DatePickerCell<BirthdayEvent, Date> datePick = new DatePickerCell<BirthdayEvent, Date>(dataList);
			return datePick;
		});

		table.getColumns().addAll(idColumn, nameColumn, priceColumn, quantityColumn, dateColumn);
		table.setItems(dataList);

		// Name input
		nameInput = new TextField();
		nameInput.setPromptText("Name");
		nameInput.setMinWidth(150);

		// Price input
		priceInput = new TextField();
		priceInput.setPromptText("Price");
		priceInput.setMaxWidth(90);

		validateInput(priceInput, "[0-9]{1,9}(\\.[0-9]{1,2}){0,1}");
		// Quantity input
		quantityInput = new TextField();
		quantityInput.setPromptText("Quantity");
		quantityInput.setMaxWidth(90);

		// Button
		Button addButton = new Button("Add");
		addButton.setOnAction(e -> addButtonClicker());
		addButton.focusedProperty().addListener(e -> {
			System.out.println("Click button add");
		});
		Button deleteButton = new Button("Delete");
		deleteButton.setOnAction(e -> deleteButtonClick());
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10, 10, 10, 10));
		hBox.setSpacing(10);
		hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);

		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 10, 10, 10));
		vbox.getChildren().addAll(table, hBox);

		((Group) scene.getRoot()).getChildren().addAll(vbox);

		stage.setScene(scene);
		stage.show();
	}

	private void validateInput(TextField input, String Rexg) {
		input.focusedProperty().addListener((arg0, oldValue, newValue) -> {
			if (!newValue) { // when focus lost
				if (!input.getText().matches(Rexg)) {
					// when it not matches the pattern (1.0 - 6.0)
					// set the textField empty
					input.setText("");
				}
			}
		});
	}

	private void deleteButtonClick() {
		ObservableList<BirthdayEvent> productSelected, allProduct;
		allProduct = table.getItems();
		productSelected = table.getSelectionModel().getSelectedItems();
		productSelected.forEach(allProduct::remove);
	}

	private void addButtonClicker() {
		if (nameInput.getText().trim().isEmpty()) {
			nameInput.setStyle(
					"-fx-border-color: red;-fx-border-radius: 3, 2; -fx-faint-focus-color: #ff000022; -fx-font-size: 12;");

		} else
			nameInput.setStyle(
					"-fx-border-color: #d4d4d4;-fx-border-radius: 3, 2; -fx-faint-focus-color: #ff000022; -fx-font-size: 12;");
		if (priceInput.getText().trim().isEmpty()) {
			priceInput.setStyle(
					"-fx-border-color:red;-fx-border-radius: 3, 2; -fx-faint-focus-color: #ff000022; -fx-font-size: 12;");

		} else
			nameInput.setStyle(
					"-fx-border-color: #d4d4d4;-fx-border-radius: 3, 2; -fx-faint-focus-color: #ff000022; -fx-font-size: 12;");
		if (quantityInput.getText().trim().isEmpty()) {
			quantityInput.setStyle(
					"-fx-border-color: red;-fx-border-radius: 3, 2; -fx-faint-focus-color: #ff000022; -fx-font-size: 12;");

		} else
			nameInput.setStyle(
					"-fx-border-color: #d4d4d4;-fx-border-radius: 3, 2; -fx-faint-focus-color: #ff000022; -fx-font-size: 12;");
		if (nameInput.getText().trim().isEmpty() || priceInput.getText().trim().isEmpty()
				|| quantityInput.getText().trim().isEmpty())
			return;
		BirthdayEvent product = new BirthdayEvent(1, nameInput.getText(), Double.parseDouble(priceInput.getText()),
				Integer.parseInt(quantityInput.getText()), new Date());
		// product.setName(nameInput.getText());
		// product.setPrice(Double.parseDouble(priceInput.getText()));
		// product.setQuantity(Integer.parseInt(quantityInput.getText()));
		// product.setDate(new Date());
		System.out.println(product);
		table.getItems().add(product);
		nameInput.clear();
		priceInput.clear();
		quantityInput.clear();
	}

	public ObservableList<BirthdayEvent> getProduct() {
		ObservableList<BirthdayEvent> products = FXCollections.observableArrayList();
		products.add(new BirthdayEvent(1, "Laptop", 859.00, 20, new Date()));
		products.add(new BirthdayEvent(2, "Bouncy Ball", 2.49, 198, new Date()));
		products.add(new BirthdayEvent(3, "Toilet", 99.00, 74, new Date()));
		products.add(new BirthdayEvent(41, "The Notebook DVD", 19.99, 12, new Date()));
		products.add(new BirthdayEvent(5, "Corn", 1.49, 856, new Date()));
		return products;
	}
}