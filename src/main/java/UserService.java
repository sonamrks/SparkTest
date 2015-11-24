/**
 * Created by Sonam on 11/21/15.
 */
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UserService {
    static Map<String,User> users = new HashMap<String,User>();

    public static void main(String[] args) {
        staticFileLocation("/public");

        post("/createUser", (req, res) -> {
            String id = req.queryParams("id");
            String firstName = req.queryParams("firstName");
            String middleName = req.queryParams("middleName");
            String lastName = req.queryParams("lastName");
            String age = req.queryParams("age");
            String gender = req.queryParams("gender");
            String phone = req.queryParams("phone");
            String zip = req.queryParams("zip");
            User user = new User(id, firstName, middleName, lastName, age, gender, phone, zip);
            String message = createUser(id, user);
            return message;
        });

        get("/getAllUsers",(req, res) -> {
            Gson gson = new Gson();
            String json = "Null";
            if(!users.isEmpty()) {
                json = gson.toJson(users);
            }
            return json;
        });

        put("/updateUser",(req, res) -> {
            String id = req.queryParams("id");
            if (users.containsKey(id)) {
                String firstName = req.queryParams("firstName");
                String middleName = req.queryParams("middleName");
                String lastName = req.queryParams("lastName");
                String age = req.queryParams("age");
                String gender = req.queryParams("gender");
                String phone = req.queryParams("phone");
                String zip = req.queryParams("zip");
                String message = updateUser(id, firstName, middleName, lastName, age, gender, phone, zip);
                return message;
            }
            else{
                return "User doesn't exist";
            }
        });

        delete("/deleteUSer", (req,res)-> {
           String id = req.queryParams("id");
            if(users.containsKey(id)) {
                return deleteUser(id);
            }
            else {
                return "User doesn't exist to delete";
            }
        });
    }

    public static String createUser(String id, User user){
        if(users.containsKey(id)){
            return "User already exists";
        }
        else{
            users.put(id,user);
            System.out.println("id: " + id + " User added");
            return "User successfully created";
        }
    }

    public static String updateUser(String id, String firstName, String middleName, String lastName, String age, String gender, String phone, String zip) {
        User user = users.get(id);
        if (firstName != null && !firstName.isEmpty()) {
            user.setFirstName(firstName);
        }
        if (middleName != null && !middleName.isEmpty()) {
            user.setMiddleName(middleName);
        }
        if (lastName != null && !lastName.isEmpty()) {
            user.setLastName(lastName);
        }
        if (age != null && !lastName.isEmpty()) {
            user.setAge(age);
        }
        if (gender != null && !gender.isEmpty()) {
            user.setGender(gender);
        }
        if (phone != null && !phone.isEmpty()) {
            user.setPhone(phone);
        }
        if (zip != null && !zip.isEmpty()) {
            user.setZip(zip);
        }
        users.put(id, user);
        return "User successfully updated";
    }

    public static String deleteUser(String id){
        users.remove(id);
        return "User successfully deleted";
    }

}

