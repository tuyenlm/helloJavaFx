package demo16;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Product {
	private final SimpleObjectProperty<Date> date;
	private final StringProperty name;
	private final IntegerProperty id;
	private final StringProperty quantity;
	private final DoubleProperty price;

	// public Product() {
	// this.setId(1);
	// this.setName("");
	// this.setPrice(20.25);
	// this.setQuantity(0);
	// this.setDate(new Date());
	// }

	public Product(int id, String name, double price, String quantity, Date date) {
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
		this.price = new SimpleDoubleProperty(price);
		this.quantity = new SimpleStringProperty(quantity);
		this.date = new SimpleObjectProperty<Date>(date);
	}

	public Date getDate() {
		return (Date) date.get();
	}

	public String getDateAsString() {
		SimpleDateFormat smp = new SimpleDateFormat("dd MMMMM yyyy");
		String strDate = (null == date || null == date.get()) ? "" : smp.format(date.get());

		return strDate;
	}

	public void setDate(Date date) {
		this.date.set(date);
	}

	public IntegerProperty getId() {
		return id;
	}

	public void setId(int id) {
		this.id.set(id);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public DoubleProperty getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price.set(price);
	}

	public StringProperty getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity.set(quantity);
	}

	public StringProperty nameProperty() {
		return name;
	}

	public DoubleProperty priceProperty() {
		return price;
	}

	public StringProperty quantityProperty() {
		return quantity;
	}

	public IntegerProperty idProperty() {
		return id;
	}

}
