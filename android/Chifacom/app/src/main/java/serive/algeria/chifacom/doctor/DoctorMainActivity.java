package serive.algeria.chifacom.doctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import serive.algeria.chifacom.R;

public class DoctorMainActivity extends AppCompatActivity {
    private ChipNavigationBar chipNavigationBar;
    private Fragment fragment = null ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_main);
        chipNavigationBar= findViewById(R.id.chipNavigationBar);

        chipNavigationBar.setItemSelected(R.id.home,true);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i){
                    case R.id.home :
                        fragment = new HomeFragment();
                        break;
                    case R.id.room :
                        fragment = new workFragment();
                        break;
                }

                if (fragment!=null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                }
            }
        });
    }
}