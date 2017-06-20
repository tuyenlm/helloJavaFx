package datePicker;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BirthdayEvent {

	private final SimpleObjectProperty<Date> date;
	private final StringProperty name;
	private final IntegerProperty id;
	private final IntegerProperty quantity;
	private final DoubleProperty price;

	public BirthdayEvent(int id, String name, Double price, int quantity, Date date) {
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
		this.price = new SimpleDoubleProperty(price);
		this.quantity = new SimpleIntegerProperty(quantity);
		this.date = new SimpleObjectProperty<Date>(date);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public StringProperty nameProperty() {
		return name;
	}
	
	public DoubleProperty priceProperty() {
		return price;
	}
	
	public IntegerProperty quantityProperty() {
		return quantity;
	}
	public IntegerProperty idProperty() {
		return id;
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

	public DoubleProperty getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price.set(price);
	}
	


	public IntegerProperty getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity.set(quantity);
	}
}