package demo16;

import java.util.Date;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

public class Main extends Application {

	Stage window;
	TableView<Product> table;
	private TextField nameInput;
	private TextField priceInput;
	private TextField quantityInput;

	public static void main(String[] args) {
		launch(args);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("thenewboston - JavaFX");

		final ObservableList<Product> dataList = FXCollections.observableArrayList(
				new Product(1, "Jacob", Double.parseDouble("45.50"), "10", new Date()),
				new Product(2, "Isabella", 45.50, "15", new Date()), new Product(3, "Ethan", 12.4, "120", new Date()),
				new Product(4, "Emma", 67.26, "15", new Date()), new Product(5, "Michael", 80.26, "12", new Date()));
		// Id column
		TableColumn<Product, Integer> idColumn = new TableColumn<Product, Integer>("Id");
		idColumn.setMinWidth(100);
		idColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
		idColumn.setVisible(false);
		// Name column
		TableColumn<Product, String> nameColumn = new TableColumn<Product, String>("Name");
		nameColumn.setMinWidth(200);
		nameColumn.setEditable(true);
		nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));

		nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		nameColumn.setOnEditCommit(event -> {
			String value = event.getNewValue() != null ? event.getNewValue() : event.getOldValue();
			((Product) event.getTableView().getItems().get(event.getTablePosition().getRow())).setName(value);
			System.out.println("id: "
					+ table.getColumns().get(0).getCellObservableValue(event.getTablePosition().getRow()).getValue());
			System.out.println("name: " + value);
			System.out.println("price: "
					+ table.getColumns().get(2).getCellObservableValue(event.getTablePosition().getRow()).getValue());
			System.out.println("quantity: "
					+ table.getColumns().get(3).getCellObservableValue(event.getTablePosition().getRow()).getValue());
			System.out.println("date: "
					+ table.getColumns().get(4).getCellObservableValue(event.getTablePosition().getRow()).getValue());

		});

		// Price column
		TableColumn<Product, Double> priceColumn = new TableColumn<Product, Double>("Price");
		priceColumn.setMinWidth(100);
		priceColumn.setEditable(true);
		priceColumn.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
		priceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
		priceColumn.setOnEditCommit(event -> {
			Double value = event.getNewValue() != null ? event.getNewValue() : event.getOldValue();
			((Product) event.getTableView().getItems().get(event.getTablePosition().getRow())).setPrice(value);
			System.out.println("id: "
					+ table.getColumns().get(0).getCellObservableValue(event.getTablePosition().getRow()).getValue());
			System.out.println("name: " + value);
			System.out.println("price: "
					+ table.getColumns().get(2).getCellObservableValue(event.getTablePosition().getRow()).getValue());
			System.out.println("quantity: "
					+ table.getColumns().get(3).getCellObservableValue(event.getTablePosition().getRow()).getValue());
			System.out.println("date: "
					+ table.getColumns().get(4).getCellObservableValue(event.getTablePosition().getRow()).getValue());

		});
		// Quantity column
		TableColumn<Product, String> quantityColumn = new TableColumn<>("Quantity");
		quantityColumn.setMinWidth(100);
		quantityColumn.setEditable(true);
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		// quantityColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		quantityColumn.setCellFactory(column -> {
			return new TableCell<Product, String>() {
				@Override
				protected void updateItem(String item, boolean empty) {
					System.out.println(item);
					super.updateItem(item, empty);

					setText(empty ? "" : getItem().toString());
					setGraphic(null);

					TableRow<Product> currentRow = getTableRow();

					if (!isEmpty()) {

						if (item.equals("a"))
							currentRow.setStyle("-fx-background-color:lightcoral");
						else
							currentRow.setStyle("-fx-background-color:lightgreen");
					}
				}
			};
		});
		quantityColumn.setOnEditCommit(event -> {
			String quantity = event.getNewValue() != null ? event.getNewValue() : event.getOldValue();
			try {
				double d = Double.valueOf(quantity);
				if (d == (int) d) {
					((Product) event.getTableView().getItems().get(event.getTablePosition().getRow()))
							.setQuantity(quantity);
					System.out.println("id: " + table.getColumns().get(0)
							.getCellObservableValue(event.getTablePosition().getRow()).getValue());
					System.out.println("quantity: " + quantity);
					System.out.println("price: " + table.getColumns().get(2)
							.getCellObservableValue(event.getTablePosition().getRow()).getValue());
					System.out.println("name: " + table.getColumns().get(1)
							.getCellObservableValue(event.getTablePosition().getRow()).getValue());
					System.out.println("date: " + table.getColumns().get(4)
							.getCellObservableValue(event.getTablePosition().getRow()).getValue());
					System.out.println("index: " + event.getTablePosition().getRow());
				} else {
					System.out.println("double" + d);
				}
			} catch (Exception e) {
				System.out.println("not number");
			}

		});

		// Calendar column
		TableColumn<Product, Date> dateColumn = new TableColumn<Product, Date>("Date");
		dateColumn.setEditable(true);
		dateColumn.setPrefWidth(75);
		dateColumn.setMinWidth(200);

		dateColumn.setCellValueFactory(new PropertyValueFactory<Product, Date>("date"));
		dateColumn.setCellFactory(p -> {
			DatePickerCell<Product, Date> datePick = new DatePickerCell<Product, Date>(dataList);
			return datePick;
		});

		// Name input
		nameInput = new TextField();
		nameInput.setPromptText("Name");
		nameInput.setMinWidth(190);

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

		table = new TableView<Product>();
		table.setItems(dataList);
		table.setEditable(true);
		// allows the individual cells to be selected
		table.getSelectionModel().cellSelectionEnabledProperty().set(true);
		table.getColumns().addAll(idColumn, nameColumn, priceColumn, quantityColumn, dateColumn);
		VBox vBox = new VBox();
		vBox.getChildren().addAll(table, hBox);

		Scene scene = new Scene(vBox);
		window.setScene(scene);
		window.show();
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
		ObservableList<Product> productSelected, allProduct;
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
		Product product = new Product(1, nameInput.getText(), Double.parseDouble(priceInput.getText()),
				quantityInput.getText(), new Date());
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

	// Get all of the products
	// public ObservableList<Product> getProduct() {
	// ObservableList<Product> products = FXCollections.observableArrayList();
	// products.add(new Product(1, "Laptop", 859.00, 20, new Date()));
	// products.add(new Product(2, "Bouncy Ball", 2.49, 198, new Date()));
	// products.add(new Product(3, "Toilet", 99.00, 74, new Date()));
	// products.add(new Product(41, "The Notebook DVD", 19.99, 12, new Date()));
	// products.add(new Product(5, "Corn", 1.49, 856, new Date()));
	// return products;
	// }

}