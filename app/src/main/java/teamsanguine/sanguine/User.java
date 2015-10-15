package teamsanguine.sanguine;

/**
 * Created by Deepan on 10/15/2015.
 */
public class User {
    String name, username, password, email;
    int phone, type;

    public User(String name, String username, String password, String email, int phone){
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this. phone = phone;
        this.type = 1;
    }
}

