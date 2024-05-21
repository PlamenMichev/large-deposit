package dk.via.largedeposit.viewmodel;

import dk.via.largedeposit.model.Model;
import javafx.beans.property.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class RegisterViewModel implements PropertyChangeListener {

    private StringProperty firstName;
    private StringProperty lastName;
    private Property<LocalDate> dob;
    private StringProperty address;
    private StringProperty postalCode;
    private StringProperty city;
    private StringProperty phone;
    private StringProperty email;
    private StringProperty password;
    private StringProperty cpr;

    private final Model model;

    public RegisterViewModel(Model model) {
        this.model = model;
        this.model.addPropertyChangeListener(this);
        this.firstName = new SimpleStringProperty("");
        this.lastName = new SimpleStringProperty("");
        this.dob = new SimpleObjectProperty<>(LocalDate.now());
        this.address = new SimpleStringProperty("");
        this.postalCode = new SimpleStringProperty("");
        this.city = new SimpleStringProperty("");
        this.phone = new SimpleStringProperty("");
        this.email = new SimpleStringProperty("");
        this.password = new SimpleStringProperty("");
        this.cpr = new SimpleStringProperty("");
    }

    public void bindProperties(StringProperty firstName, StringProperty lastName, ObjectProperty<LocalDate> dob, StringProperty address, StringProperty postalCode, StringProperty city, StringProperty phone, StringProperty email, StringProperty password, StringProperty cpr) {
        firstName.bindBidirectional(this.firstName);
        lastName.bindBidirectional(this.lastName);
        dob.bindBidirectional(this.dob);
        address.bindBidirectional(this.address);
        postalCode.bindBidirectional(this.postalCode);
        city.bindBidirectional(this.city);
        phone.bindBidirectional(this.phone);
        email.bindBidirectional(this.email);
        password.bindBidirectional(this.password);
        cpr.bindBidirectional(this.cpr);
    }

    public void register() {
        this.model.register(firstName.getValue(), lastName.getValue(), dob.getValue().getLong(ChronoField.EPOCH_DAY), address.getValue(), postalCode.getValue(), city.getValue(), phone.getValue(), email.getValue(), password.getValue(), cpr.getValue());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Property changed: " + evt.getPropertyName());
    }
}
