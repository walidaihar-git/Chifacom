package serive.algeria.chifacom.forgetPass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import serive.algeria.chifacom.R;

public class ForgetPassActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton sendCode;
    EditText code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);

        code = findViewById(R.id.code);

        sendCode = findViewById(R.id.sendCode);
        sendCode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==sendCode){
            Intent intent = new Intent(ForgetPassActivity.this, PasswordRecoverActivity.class);
           startActivity(intent);
        }
    }
}