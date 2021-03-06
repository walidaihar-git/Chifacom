package serive.algeria.chifacom.doctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import serive.algeria.chifacom.R;

public class DoctorHomeActivity extends AppCompatActivity implements View.OnClickListener {

    TextView profileNav,roomNav;
    View decorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home);

        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                decorView.setSystemUiVisibility(hideSystemBars());
            }
        });




        profileNav = findViewById(R.id.profileNav);
        roomNav = findViewById(R.id.roomNav);

        profileNav.setOnClickListener(this);
        roomNav.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {

        if (v == profileNav){
            Intent intent = new Intent(DoctorHomeActivity.this, DoctorProfileActivity.class);
            startActivity(intent);
        }

        if (v == roomNav){
            Intent intent = new Intent(DoctorHomeActivity.this, CreateRoomActivity.class);
            startActivity(intent);

        }

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }

    public int  hideSystemBars(){


        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                |View.SYSTEM_UI_FLAG_FULLSCREEN
                |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                ;
    }
}