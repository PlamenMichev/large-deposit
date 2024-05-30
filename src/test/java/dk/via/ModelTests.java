package dk.via;

import dk.via.largedeposit.client.Client;
import dk.via.largedeposit.client.ClientImplementation;
import dk.via.largedeposit.model.Model;
import dk.via.largedeposit.model.ModelManager;
import dk.via.largedeposit.model.User;
import dk.via.largedeposit.model.enums.UserRole;
import dk.via.largedeposit.proxy.RoleAccessorProxy;
import dk.via.largedeposit.server.Server;
import dk.via.largedeposit.server.ServerImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ModelTests {

    @Mock
    private Server serverMock;

    private Model model;

    @BeforeEach
    void setUp() throws RemoteException {
        // Initialize mocks created above
        // This is done automatically by the @ExtendWith(MockitoExtension.class) annotation
        var client = new ClientImplementation(serverMock);
        model = new ModelManager(client);
    }

    @Test
    public void registerShouldCreateNewUser() throws RemoteException {
        // Arrange
        var firstName = "John";
        var lastName = "Doe";
        var dateOfBirth = 123456789;
        var address = "Test Street 1";
        var postalCode = "1234";
        var city = "Test City";
        var phone = "12345678";
        var email = "test@test.dk";
        var password = "password";
        var cpr = "1234561234";
        var mockUser = new User(1, cpr, firstName, lastName, UserRole.CUSTOMER, address, postalCode, city, phone, email, password, false, dateOfBirth, System.currentTimeMillis());
        when(serverMock.register(firstName, lastName, dateOfBirth, address, postalCode, city, phone, email, password, cpr)).thenReturn(mockUser);

        // Act
        model.register(firstName, lastName, dateOfBirth, address, postalCode, city, phone, email, password, cpr);

        // Assert
        verify(serverMock).register(firstName, lastName, dateOfBirth, address, postalCode, city, phone, email, password, cpr);
    }

    @Test
     public void loginShouldLogUser() throws RemoteException {
        // Arrange
        var email = "test@test.test";
        var password = "password";

        var mockUser = new User(1," ", " ", " ", UserRole.CUSTOMER, " ", " ", " ", " ", " ", " ", false, 0, 0);
        when(serverMock.login(email, password)).thenReturn(mockUser);

        // Act
        model.login(email, password);

        // Assert
        verify(serverMock).login(email, password);
    }

    @Test
    public void getUsersShouldReturnUsers() throws RemoteException {
        // Arrange
        var mockUser = new User(1," ", " ", " ", UserRole.CUSTOMER, " ", " ", " ", " ", " ", " ", false, 0, 0);
        when(serverMock.getUsers()).thenReturn(new ArrayList<>(List.of(mockUser)));

        // Act
        var users = model.getUsers();

        // Assert
        verify(serverMock).getUsers();
        assertEquals(1, users.size());
    }

    @Test
    public void toggleUserActiveStatusShouldToggleUserActiveStatus() throws RemoteException {
        // Arrange
        var id = 1;

        // Act
        model.toggleUserActiveStatus(id);

        // Assert
        verify(serverMock).toggleUserActiveStatus(id);
    }

   // Test the proxy
    @Test
    public void userCannotLoginTwice() throws RemoteException {

        var proxy = new RoleAccessorProxy(model);
        // Arrange
        var email = "test@test.com";
        var password = "password";
        var mockUser = new User(1," ", " ", " ", UserRole.CUSTOMER, " ", " ", " ", " ", " ", " ", false, 0, 0);
        when(serverMock.login(email, password)).thenReturn(mockUser);

        // Act
        proxy.login(email, password);

        // Assert
        verify(serverMock).login(email, password);
        assertThrows(IllegalStateException.class, () -> proxy.login(email, password));
    }

    @Test
    public void customerCannotAccessUserList() throws RemoteException {
        var proxy = new RoleAccessorProxy(model);
        // Arrange
        var email = "test@test.st";
        var password = "password";
        var mockUser = new User(1," ", " ", " ", UserRole.CUSTOMER, " ", " ", " ", " ", " ", " ", false, 0, 0);
        when(serverMock.login(email, password)).thenReturn(mockUser);

        // Act
        proxy.login(email, password);

        // Assert
        verify(serverMock).login(email, password);
        assertThrows(IllegalArgumentException.class, proxy::getUsers);
    }
}
