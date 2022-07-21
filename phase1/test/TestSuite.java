import Entities.User.Admin;
import Entities.User.Customer;
import Entities.User.User;
import Entities.User.UserTracker;
import Gateways.UserTrackerConnector;
import UseCases.AddAdmin;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class TestSuite {

    public void setup() throws IOException {
        UserTrackerConnector dc = new UserTrackerConnector();
        dc.Load();
        User u1 = new Customer("bob", "pool", 2003, 7, 6, "bruh", false);
        Customer c1 = new Customer("Dad", "ball", 1900, 2, 3, "none", true);
        User u2 = new Admin("pablo", "mod", 2010, 3, 4, "dis");
        Admin a1 = new Admin("Who", "idk", 1111, 1, 1, "plank");

        UserTracker.addUser(u1);
        UserTracker.addUser(c1);
        UserTracker.addUser(u2);
        UserTracker.addUser(a1);

        dc.Save();
    }
    @Test(timeout = 50)
    public void testAddFirstAdmin(){
        AddAdmin.addFirstAdmin();

        assertEquals(UserTracker.getTotalUserCount(),1);
    }
    @Test(timeout = 50)
    public void testAddNewAdmin(){
        AddAdmin.NewAdmin("someone", "probably", 2111, 12, 31, "amy");
        assertEquals(UserTracker.getTotalUserCount(),1);

        UserTracker ut3 = new UserTracker("someone");
        UserTracker ut4 = new UserTracker("Administrator");
        assertTrue(ut3.userExists());
        assertFalse(ut4.userExists());
    }

}
