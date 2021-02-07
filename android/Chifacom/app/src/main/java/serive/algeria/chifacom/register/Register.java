package serive.algeria.chifacom.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import serive.algeria.chifacom.R;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

    }
}