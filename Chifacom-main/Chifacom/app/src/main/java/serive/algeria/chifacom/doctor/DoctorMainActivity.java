package serive.algeria.chifacom.doctor;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.resources.TextAppearance;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import serive.algeria.chifacom.R;

public class DoctorMainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {
    private ChipNavigationBar chipNavigationBar;
    private Fragment fragment = null ;
    View decorView;

    NavigationView navigationView ; // added -------------------------------

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_main);
// added -------------------------------
        navigationView = findViewById(R.id.nav_view);

        MenuItem menuItem = navigationView.getMenu().findItem(R.id.compte);
        MenuItem menuItem2 = navigationView.getMenu().findItem(R.id.paramaters);
        MenuItem menuItem3 = navigationView.getMenu().findItem(R.id.logout);
        SpannableString s = new SpannableString(menuItem.getTitle());
        SpannableString s2 = new SpannableString(menuItem2.getTitle());
        SpannableString s3 = new SpannableString(menuItem3.getTitle());
        s.setSpan(new TextAppearanceSpan(this, R.style.TitleAppearance), 0, s.length(), 0);
        s2.setSpan(new TextAppearanceSpan(this, R.style.TitleAppearance), 0, s2.length(), 0);
        s3.setSpan(new TextAppearanceSpan(this, R.style.LogoutAppearance), 0, s3.length(), 0);
        menuItem.setTitle(s);
        menuItem2.setTitle(s2);
        menuItem3.setTitle(s3);

        //MENU NAVIGATIONS
        //profile
        MenuItem profile = navigationView.getMenu().findItem(R.id.profile);
        profile.setOnMenuItemClickListener(this::onMenuItemClick);

        //Languages
        MenuItem language = navigationView.getMenu().findItem(R.id.language);
        language.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                drawerLayout.closeDrawer(navigationView);
                Fragment fragment = new LanguageEditFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                return true;
            }
        });

        // about us
        MenuItem about = navigationView.getMenu().findItem(R.id.about);
        about.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                drawerLayout.closeDrawer(navigationView);
                Fragment fragment = new AboutUsFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                return true;
            }
        });
        //Account and security
        MenuItem security = navigationView.getMenu().findItem(R.id.security);
        security.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                drawerLayout.closeDrawer(navigationView);
                Fragment fragment = new AccountSecurityFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                return true;
            }
        });

// added  end -------------------------------
        //actionbar
        Toolbar toolbar = findViewById(R.id.toolbar);
//        toolbar.setCollapseIcon(R.drawable.profile_icon_2);
//        toolbar.setNavigationIcon(R.drawable.profile_icon_2);

//        toolbar.setBackgroundColor(Color.TRANSPARENT);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);

        ColorDrawable colorDrawable
                = new ColorDrawable(Color.TRANSPARENT);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setTitle("");
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.profile_icon_2_small);
        //hide status bar
        decorView = getWindow().getDecorView();

        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                decorView.setSystemUiVisibility(hideSystemBars());
            }
        });

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
                        fragment = new DoctorPlanFragment();
                        break;
                }

                if (fragment!=null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                }
            }
        });
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

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        drawerLayout.closeDrawer(navigationView);
        Fragment fragment = new DoctorProfileFragment();
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
         fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
          fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


        return true;
    }
}