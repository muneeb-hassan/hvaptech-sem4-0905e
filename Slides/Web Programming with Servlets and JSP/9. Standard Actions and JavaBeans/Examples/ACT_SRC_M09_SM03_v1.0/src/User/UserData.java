/*
 * UserData.java
 *
 * This program demonstrates the user name, mail id and age.
 * It assign the values and return when required.
 * 
 */

package user;
/*
* @ author vincent
*/
public class UserData {
    String username;
    String email;
    int age;

    public void setUsername( String value )
    {
        username = value;
    }

    public void setEmail( String value )
    {
        email = value;
    }

    public void setAge( int value )
    {
        age = value;
    }
// The getUsername returns the username
    public String getUsername() { return username; }
// The getEmail returns the email
    public String getEmail() { return email; }
// The getAge returns the age
    public int getAge() { return age; }
}
