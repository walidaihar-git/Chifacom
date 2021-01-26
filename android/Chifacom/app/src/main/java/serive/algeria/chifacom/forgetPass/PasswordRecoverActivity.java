package serive.algeria.chifacom.forgetPass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import serive.algeria.chifacom.R;
import serive.algeria.chifacom.register.FirstStepFragment;

public class PasswordRecoverActivity extends AppCompatActivity {
   // private FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_recover);

        //FrameLayout fragmentContainer =  findViewById(R.id.fragment_containerPass);

        SendCodeFragment fragment = SendCodeFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.setCustomAnimations(R.anim.slide_out_right, R.anim.slide_in_right, R.anim.slide_out_right, R.anim.slide_in_right);
        transaction.addToBackStack(null);
        transaction.add(R.id.fragment_containerPass, fragment, "BLANK_FRAGMENT").commit();
    }

}