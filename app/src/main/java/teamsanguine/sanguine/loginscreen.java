package teamsanguine.sanguine;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class loginscreen extends AppCompatActivity implements View.OnClickListener {

    Button hello;
    TextView forgetpassword;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginscreen);

        hello = (Button) findViewById(R.id.userCreate);
        hello.setOnClickListener(this);

        forgetpassword = (TextView) findViewById(R.id.forgotpassword);
        forgetpassword.setOnClickListener(this);
        //Toast.makeText(getApplicationContext(), "Login Screen", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.userCreate:
                startActivity(new Intent(this, Register.class));
                break;

            case R.id.forgotpassword:
                startActivity(new Intent(this, ForgotPassword.class));
                break;
        }

    }

}