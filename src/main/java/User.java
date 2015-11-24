/**
 * Created by Sonam on 11/21/15.
 */
public class User {
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String age;
    private String gender;
    private String phone;
    private String zip;

    public User(String id, String firstName, String middleName, String lastName, String age, String gender, String phone, String zip){
        this.id= id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.zip = zip;
    }

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setMiddleName(String middleName){
        this.middleName = middleName;
    }
    public String getMiddleName(){
        return middleName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setAge(String age){
        this.age = age;
    }
    public String getAge(){
        return age;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return gender;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return phone;
    }
    public void setZip(String zip){
        this.zip = zip;
    }
    public String getZip(){
        return zip;
    }
}
