import org.junit.FixMethodOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Map;

/**
 * Created by Sonam on 11/22/15.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Testing {

    private static final String id = "12";
    private static final String firstName = "Sonam";
    private static final String middleName = null;
    private static final String lastName = "Rudraraju";
    private static final String age = "25";
    private static final String gender = "F";
    private static final String phone = "4088318694";
    private static final String zip = null;
    private static final String newFirstName = "SonamNew";
    private static final String newLastName = "RudrarajuNew";
    private static final String newZip= "95050";
    private User user;

    @Before
    public void setUp(){
        user = new User(id,firstName,middleName,lastName,age,gender,phone,zip);
    }

    @Test
    public void testCreateUser() {
        String status = UserService.createUser(id, user);
        assertEquals("User successfully created", status);
        Map<String,User> testUserInfo = UserService.users;
        int numberOfUsers = testUserInfo.size();
        assertEquals(1,numberOfUsers);
        assertNull(user.getMiddleName());
        assertNull(user.getZip());
        assertEquals(gender,user.getGender());
    }

    @Test
    public void testUpdateUser(){
        String status = UserService.updateUser(id,newFirstName,middleName,newLastName,age,gender,phone,newZip);
        assertEquals("User successfully updated", status);
        User user = UserService.users.get(id);
        assertEquals(newFirstName,user.getFirstName());
        assertEquals(newLastName,user.getLastName());
        assertNotNull(user.getZip());
        assertEquals(newZip,user.getZip());
        assertNull(user.getMiddleName());
    }
}
