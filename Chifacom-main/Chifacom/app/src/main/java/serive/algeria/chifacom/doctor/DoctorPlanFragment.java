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
import android.widget.ImageView;
import android.widget.TextView;

import serive.algeria.chifacom.IonBackPressed;
import serive.algeria.chifacom.R;


public class DoctorPlanFragment extends Fragment implements View.OnClickListener, IonBackPressed {

ImageView calender;
ImageView patient_info ;
TextView language;

    public DoctorPlanFragment() {
        // Required empty public constructor
    }


    public static DoctorPlanFragment newInstance(String param1, String param2) {
        DoctorPlanFragment fragment = new DoctorPlanFragment();
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
        View view =  inflater.inflate(R.layout.fragment_doctor_plan, container, false);
        ((AppCompatActivity) getContext()).getSupportActionBar().show();

        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#0071BC"));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setBackgroundDrawable(colorDrawable);

        language = getActivity().findViewById(R.id.language);
        language.setVisibility(View.INVISIBLE);

        getActivity().findViewById(R.id.chipNavigationBar).setVisibility(View.GONE);
        calender = view.findViewById(R.id.calender);
        patient_info = view.findViewById(R.id.patient_info);


        language = getActivity().findViewById(R.id.language);
        language.setVisibility(View.INVISIBLE);

        calender.setOnClickListener(this);
        patient_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new PatientInfoList();

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
            }
        });


        return  view;
    }

    @Override
    public void onClick(View v) {
        if (v == calender){
            Fragment fragment = new ControlPageFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();
        }
    }

    @Override
    public boolean onBackPressed() {
        language = getActivity().findViewById(R.id.language);
        language.setVisibility(View.VISIBLE);

        return true;
    }
}