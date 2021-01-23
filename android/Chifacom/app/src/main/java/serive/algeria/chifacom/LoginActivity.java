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

public class LoginActivity extends AppCompatActivity {
    private  long backPressedTime;
    AppCompatButton register ;
    EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        //get information from view
        email= findViewById(R.id.email);
        password=findViewById(R.id.password);

        register = findViewById(R.id.registerNav);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
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
}