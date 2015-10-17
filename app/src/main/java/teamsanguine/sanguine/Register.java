package teamsanguine.sanguine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity implements View.OnClickListener {

    Button signup;
    EditText etrepeatpass, etpassword, etusername, etphone, etemail, etname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etname = (EditText) findViewById(R.id.etname);
        etemail = (EditText) findViewById(R.id.etemail);
        etphone = (EditText) findViewById(R.id.etphone);
        etusername = (EditText) findViewById(R.id.etusername);
        etname = (EditText) findViewById(R.id.etname);
        etpassword = (EditText) findViewById(R.id.etpassword);
        etrepeatpass = (EditText) findViewById(R.id.etrepeatpass);
        signup = (Button) findViewById(R.id.signup);

        signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signup:

                String name = etname.getText().toString();
                String username = etusername.getText().toString();
                String email = etemail.getText().toString();
                String password = etpassword.getText().toString();
                int phone = Integer.parseInt(etphone.getText().toString());

                User user = new User(name, username, password, email, phone);

                //Validation validation = new Validation();

                String repeatpassword = etrepeatpass.getText().toString();
                //validation.passwordMatch(user, repeatpassword);

                registerUser(user);
                break;
        }
    }

    private void registerUser(User user){
        ServerRequests serverRequests = new ServerRequests(this);
        serverRequests.storeUserDataInBackground(user, new GetUserCallback() {
            @Override
            public void done(User returnedUser) {
                startActivity(new Intent(Register.this, MainActivity.class));
            }
        });
    }
}
