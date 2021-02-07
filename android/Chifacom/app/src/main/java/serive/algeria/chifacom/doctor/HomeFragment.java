package serive.algeria.chifacom.doctor;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import serive.algeria.chifacom.R;


public class HomeFragment extends Fragment implements View.OnClickListener {

    TextView room,profile;

    LinearLayout profileNav,workNav;


    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home_fragment, container, false);

//        room = view.findViewById(R.id.roomNav);
//        profile = view.findViewById(R.id.profileNav);

        profileNav = view.findViewById(R.id.goToProfile);
        workNav = view.findViewById(R.id.startWork);

        profileNav.setOnClickListener(this);
        workNav.setOnClickListener(this);


//        room.setOnClickListener(this);
//        profile.setOnClickListener(this);


        return view ;
    }

    @Override
    public void onClick(View v) {

        if (v == workNav ){
            Fragment fragment = new DoctorPlanFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }
        if (v == profileNav){
            Fragment fragment = new DoctorProfileFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right);
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();

        }
    }
}