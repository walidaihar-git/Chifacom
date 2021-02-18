package serive.algeria.chifacomapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout search,rdv,account;
    TextView t1,t2,t3;
    ImageView i1,i2,i3;
    AppCompatButton partage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        t1 = findViewById(R.id.t1); t2=findViewById(R.id.t2); t3= findViewById(R.id.t3);
        i1 = findViewById(R.id.i1); i2=findViewById(R.id.i2); i3= findViewById(R.id.i3);

        partage = findViewById(R.id.partage);
        search = findViewById(R.id.search);
        rdv = findViewById(R.id.rdv);
        account = findViewById(R.id.compte);
        partage.setOnClickListener(this);
        search.setOnClickListener(this);
        rdv.setOnClickListener(this);
        account.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==search){
            t1.setTextColor(Color.WHITE);
            i1.setImageResource(R.drawable.search_w);
            search.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.blue_circle));
           Intent intent = new Intent(WelcomeActivity.this, SearchFormActivity.class);// delete this and uncomment the code obove to make first run work
            startActivity(intent);

        }
        if(v==rdv){
            t2.setTextColor(Color.WHITE);
            i2.setImageResource(R.drawable.notification_w);
            rdv.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.blue_circle));
        }
        if (v==account){
            t3.setTextColor(Color.WHITE);
            i3.setImageResource(R.drawable.profile_w);
            account.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.blue_circle));
        }

        if (v==partage){
            partage.setTextColor(Color.WHITE);
            partage.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.blue_circle));

        }

    }
}