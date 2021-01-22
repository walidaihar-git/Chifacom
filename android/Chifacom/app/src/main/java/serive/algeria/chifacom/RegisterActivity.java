package serive.algeria.chifacom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import serive.algeria.chifacom.register.FirstStepFragment;

public class RegisterActivity extends AppCompatActivity {
    private FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        FrameLayout fragmentContainer =  findViewById(R.id.fragment_container);

       FirstStepFragment fragment = FirstStepFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.setCustomAnimations(R.anim.slide_out_right, R.anim.slide_in_right, R.anim.slide_out_right, R.anim.slide_in_right);
        transaction.addToBackStack(null);
        transaction.add(R.id.fragment_container, fragment, "BLANK_FRAGMENT").commit();

        steps();
    }

    private void steps() {

            findViewById(R.id.step1).setBackgroundColor(getResources().getColor(R.color.blueBack));

    }


    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (!(fragment instanceof IonBackPressed) || !((IonBackPressed) fragment).onBackPressed()) {
            super.onBackPressed();
        }
    }
}