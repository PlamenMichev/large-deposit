package dk.via;

import dk.via.largedeposit.model.Model;
import dk.via.largedeposit.model.User;
import dk.via.largedeposit.model.enums.UserRole;
import dk.via.largedeposit.view.ViewFactory;
import dk.via.largedeposit.viewmodel.RegisterViewModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RegisterViewModelTests {
    @Mock
    private Model modelMock;

    private final String newUserEmail = "test@test.dk";

    private final long currentDate = 0;

    @BeforeEach
    void setUp() {
        // Initialize mocks created above
        // This is done automatically by the @ExtendWith(MockitoExtension.class) annotation
    }

    @Test
    public void registerCustomerShouldInvokeTheModelMethod() {
        var existingUser = new User("1234561234", "John", "Doe",
                UserRole.CUSTOMER,
                "Test Street 1", "1234", "Test City", "12345678",
                newUserEmail, "password", true, currentDate,
                currentDate);
        when(modelMock.register(
                "John", "Doe", currentDate, "Test Street 1", "1234", "Test City", "12345678", newUserEmail, "password", "1234561234"
        )).thenReturn(existingUser);
        when(modelMock.getCurrentUser()).thenReturn(existingUser);
        // Arrange
        var registerViewModel = new RegisterViewModel(modelMock);
        var firstNameStringProperty = new SimpleStringProperty("John");
        var lastNameStringProperty = new SimpleStringProperty("Doe");
        var dobStringProperty = new SimpleObjectProperty<LocalDate>();
        var addressStringProperty = new SimpleStringProperty("Test Street 1");
        var postalCodeStringProperty = new SimpleStringProperty("1234");
        var cityStringProperty = new SimpleStringProperty("Test City");
        var phoneStringProperty = new SimpleStringProperty("12345678");
        var emailStringProperty = new SimpleStringProperty(newUserEmail);
        var passwordStringProperty = new SimpleStringProperty("password");
        var cprStringProperty = new SimpleStringProperty("1234561234");
        registerViewModel.bindProperties(firstNameStringProperty, lastNameStringProperty, dobStringProperty, addressStringProperty, postalCodeStringProperty, cityStringProperty, phoneStringProperty, emailStringProperty, passwordStringProperty, cprStringProperty);

        firstNameStringProperty.set("John");
        lastNameStringProperty.set("Doe");
        dobStringProperty.set(LocalDate.from(Instant.ofEpochMilli(currentDate).atZone(ZoneId.systemDefault())));
        addressStringProperty.set("Test Street 1");
        postalCodeStringProperty.set("1234");
        cityStringProperty.set("Test City");
        phoneStringProperty.set("12345678");
        emailStringProperty.set(newUserEmail);
        passwordStringProperty.set("password");
        cprStringProperty.set("1234561234");

        // Act
        registerViewModel.register();

        // Assert
        assert modelMock.getCurrentUser().getEmail().equals(newUserEmail);
        verify(modelMock).register("John", "Doe", currentDate, "Test Street 1", "1234", "Test City", "12345678", newUserEmail, "password", "1234561234");
    }

    @Test
    public void registerThrowsExceptionWithInvalidData() {when(modelMock.register(
            "John", "Doe", currentDate, "Test Street 1", "1234", "Test City", "12345678", newUserEmail, "password", "1234561234"
    )).thenThrow(RuntimeException.class);
        // Arrange
        var registerViewModel = new RegisterViewModel(modelMock);
        var firstNameStringProperty = new SimpleStringProperty("John");
        var lastNameStringProperty = new SimpleStringProperty("Doe");
        var dobStringProperty = new SimpleObjectProperty<LocalDate>();
        var addressStringProperty = new SimpleStringProperty("Test Street 1");
        var postalCodeStringProperty = new SimpleStringProperty("1234");
        var cityStringProperty = new SimpleStringProperty("Test City");
        var phoneStringProperty = new SimpleStringProperty("12345678");
        var emailStringProperty = new SimpleStringProperty(newUserEmail);
        var passwordStringProperty = new SimpleStringProperty("password");
        var cprStringProperty = new SimpleStringProperty("1234561234");
        registerViewModel.bindProperties(firstNameStringProperty, lastNameStringProperty, dobStringProperty, addressStringProperty, postalCodeStringProperty, cityStringProperty, phoneStringProperty, emailStringProperty, passwordStringProperty, cprStringProperty);
        firstNameStringProperty.set("John");
        lastNameStringProperty.set("Doe");
        dobStringProperty.set(LocalDate.from(Instant.ofEpochMilli(currentDate).atZone(ZoneId.systemDefault())));
        addressStringProperty.set("Test Street 1");
        postalCodeStringProperty.set("1234");
        cityStringProperty.set("Test City");
        phoneStringProperty.set("12345678");
        emailStringProperty.set(newUserEmail);
        passwordStringProperty.set("password");
        cprStringProperty.set("1234561234");

        // Act and Assert
        assertThrows(RuntimeException.class, registerViewModel::register);
    }
}
