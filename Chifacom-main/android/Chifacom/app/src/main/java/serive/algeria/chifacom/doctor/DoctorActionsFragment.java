package serive.algeria.chifacom.doctor;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import serive.algeria.chifacom.R;


public class DoctorActionsFragment extends Fragment {

    TextView language;
    LinearLayout calenderNav;
    public DoctorActionsFragment() {
        // Required empty public constructor
    }


    public static DoctorActionsFragment newInstance(String param1, String param2) {
        DoctorActionsFragment fragment = new DoctorActionsFragment();
        Bundle args = new Bundle();

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
        View view= inflater.inflate(R.layout.fragment_doctor_actions, container, false);
        ((AppCompatActivity) getContext()).getSupportActionBar().show();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#ffffff"));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setBackgroundDrawable(colorDrawable);

        language = getActivity().findViewById(R.id.language);
        language.setVisibility(View.INVISIBLE);

        calenderNav = view.findViewById(R.id.calenderNav);
        calenderNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ControlPageFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right);
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
            }
        });
        return view;
    }
}