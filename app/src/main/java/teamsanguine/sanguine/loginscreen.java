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

    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.loginscreen);

            hello = (Button) findViewById(R.id.userCreate);
            hello.setOnClickListener(this);

            //Toast.makeText(getApplicationContext(), "Login Screen", Toast.LENGTH_LONG).show();
        }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.userCreate:
                startActivity(new Intent(this, Register.class));
                break;

            case R.id.forgotpassword:
                startActivity(new Intent(this, forgotpassword.class));
                break;
        }

    }

 /*   public void onLogIn(View v) {
            if (v.getId() == R.id.homeScreen) {
                EditText a = (EditText) findViewById(R.id.TFusername);
                String str = a.getText().toString();
                Intent i = new Intent(loginscreen.this, welcomescreen.class);
                i.putExtra("Username", str);
                startActivity(i);
            }
        }*/
        }