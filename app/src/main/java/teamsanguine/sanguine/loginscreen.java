package teamsanguine.sanguine;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class loginscreen extends Activity {
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.loginscreen);

            //Toast.makeText(getApplicationContext(), "Login Screen", Toast.LENGTH_LONG).show();
        }

        public void onLogIn(View v) {
            if (v.getId() == R.id.homeScreen) {
                EditText a = (EditText) findViewById(R.id.TFusername);
                String str = a.getText().toString();
                Intent i = new Intent(loginscreen.this, welcomescreen.class);
                i.putExtra("Username", str);
                startActivity(i);
            }
        }
        }