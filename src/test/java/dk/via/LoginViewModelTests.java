package dk.via;

import dk.via.largedeposit.model.Model;
import dk.via.largedeposit.model.User;
import dk.via.largedeposit.model.enums.UserRole;
import dk.via.largedeposit.view.ViewFactory;
import dk.via.largedeposit.viewmodel.LoginViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import javafx.beans.property.SimpleStringProperty;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LoginViewModelTests {

    @Mock
    private Model modelMock;

    private final String existingUserEmail = "test@test.dk";

    @BeforeEach
    void setUp() {
        // Initialize mocks created above
        // This is done automatically by the @ExtendWith(MockitoExtension.class) annotation
        var existingUser = new User("1234561234", "John", "Doe",
                UserRole.CUSTOMER,
                "Test Street 1", "1234", "Test City", "12345678",
                existingUserEmail, "password", true, System.currentTimeMillis(),
                System.currentTimeMillis());
        when(modelMock.login(existingUserEmail, "password")).thenReturn(existingUser);
        when(modelMock.getCurrentUser()).thenReturn(existingUser);
    }

    @Test
    public void loginCustomerShouldReturnOverviewPage() {
        // Arrange
        var loginViewModel = new LoginViewModel(modelMock);
        var emailStringProperty = new SimpleStringProperty(existingUserEmail);
        var passwordStringProperty = new SimpleStringProperty("password");
        loginViewModel.bindProperties(emailStringProperty, passwordStringProperty);

        emailStringProperty.set(existingUserEmail);
        passwordStringProperty.set("password");

        // Act
        var redirectPath = loginViewModel.login();

        // Assert
        assert redirectPath.equals(ViewFactory.OVERVIEW);
    }

    @Test
    public void loginAdminShouldReturnAdminPage() {
        // Arrange
        var existingAdmin = new User("1234561234", "John", "Doe",
                UserRole.ADMIN,
                "Test Street 1", "1234", "Test City", "12345678",
                existingUserEmail, "password", true, System.currentTimeMillis(),
                System.currentTimeMillis());
        when(modelMock.login(existingUserEmail, "password")).thenReturn(existingAdmin);
        when(modelMock.getCurrentUser()).thenReturn(existingAdmin);

        var loginViewModel = new LoginViewModel(modelMock);
        var emailStringProperty = new SimpleStringProperty(existingUserEmail);
        var passwordStringProperty = new SimpleStringProperty("password");
        loginViewModel.bindProperties(emailStringProperty, passwordStringProperty);

        emailStringProperty.set(existingUserEmail);
        passwordStringProperty.set("password");

        // Act
        var redirectPath = loginViewModel.login();

        // Assert
        assert redirectPath.equals(ViewFactory.USERS_LIST);
    }

    @Test
    public void WrongPasswordShouldReturnLoginPage() {
        when(modelMock.getCurrentUser()).thenReturn(null);
        // Arrange
        var loginViewModel = new LoginViewModel(modelMock);
        var emailStringProperty = new SimpleStringProperty(existingUserEmail);
        var passwordStringProperty = new SimpleStringProperty("password");
        loginViewModel.bindProperties(emailStringProperty, passwordStringProperty);

        emailStringProperty.set(existingUserEmail);
        passwordStringProperty.set("password");

        // Act
        var redirectPath = loginViewModel.login();

        // Assert
        assertEquals(ViewFactory.LOGIN, redirectPath);
    }
}
