package serive.algeria.chifacomapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class FirstRunActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton fr,ar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_run);

        fr = findViewById(R.id.fr);
        ar = findViewById(R.id.ar);
        fr.setOnClickListener(this);
        ar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        if (v==fr){
            fr.setTextColor(Color.WHITE);
            fr.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.blue_circle));
        }
        if (v==ar){
            ar.setTextColor(Color.WHITE);
            ar.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.blue_circle));
        }
        Intent intent = new Intent(FirstRunActivity.this, WelcomeActivity.class);
        startActivity(intent);

    }
}