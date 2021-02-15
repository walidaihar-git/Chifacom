package serive.algeria.chifacom.doctor;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import serive.algeria.chifacom.R;


public class HomeFragment extends Fragment implements View.OnClickListener {

    TextView label1;
    ImageView labelImg;

    LinearLayout calenderNav;


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
        ((AppCompatActivity) getContext()).getSupportActionBar().show();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#ffffff"));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setBackgroundDrawable(colorDrawable);
//        room = view.findViewById(R.id.roomNav);
//        profile = view.findViewById(R.id.profileNav);

        calenderNav = view.findViewById(R.id.calenderNav);
        label1 = view.findViewById(R.id.label1);
        labelImg= view.findViewById(R.id.calenderImg);

        calenderNav.setOnClickListener(this);


//        room.setOnClickListener(this);
//        profile.setOnClickListener(this);


        return view ;
    }

    @Override
    public void onClick(View v) {


        if (v == calenderNav){
            label1.setTextColor(Color.WHITE);
            labelImg.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.calendar_white));
            calenderNav.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.language_2));


            Fragment fragment = new TimeLineFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right);
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();


        }
    }
}