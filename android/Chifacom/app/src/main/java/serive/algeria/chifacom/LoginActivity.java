package serive.algeria.chifacom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import serive.algeria.chifacom.forgetPass.ForgetPassActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private  long backPressedTime;
    AppCompatButton register ,forgetPass;
    EditText email,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        //get information from view
        email= findViewById(R.id.email);
        password=findViewById(R.id.password);

        register = findViewById(R.id.registerNav);
        forgetPass = findViewById(R.id.forgetPass);

        register.setOnClickListener(this);
        forgetPass.setOnClickListener(this);
    }
    private TextView.OnEditorActionListener actionListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            switch (actionId){
                case EditorInfo.IME_ACTION_GO:
                    Toast.makeText(LoginActivity.this, "Login !..", Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    };
    @Override
    public void onBackPressed() {
        finishAffinity();
        System.exit(0);
    }

    public void login(View view) {
        startActivity(new Intent(this.getApplicationContext(), MapsActivity.class));
    }

    @Override
    public void onClick(View v) {

        if (v==register) {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);

        }
        if (v == forgetPass){
            Intent intent = new Intent(LoginActivity.this, ForgetPassActivity.class);
            startActivity(intent);
        }
    }
}