package serive.algeria.chifacom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=null;
//                if (firstStart) {
//                    SharedPreferences prefs = getSharedPreferences("prefs",MODE_PRIVATE);
//                    SharedPreferences.Editor editor = prefs.edit();
//                    editor.putBoolean("firstStart",false);
//                    editor.apply();
//                     intent = new Intent(MainActivity.this, FirstRunActivity.class);
//                }else{
//                    intent = new Intent(MainActivity.this, LoginActivity.class);
//                }

                intent = new Intent(LoadingActivity.this, FirstRunActivity.class);// delete this and uncomment the code obove to make first run work
                startActivity(intent);
                finish();
            }
        },3000);
    }
}