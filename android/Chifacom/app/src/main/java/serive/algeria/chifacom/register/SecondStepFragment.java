package serive.algeria.chifacom.register;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;

import java.util.Calendar;

import serive.algeria.chifacom.IonBackPressed;
import serive.algeria.chifacom.R;


public class SecondStepFragment extends Fragment implements View.OnClickListener, IonBackPressed {
    AppCompatButton next ;
    EditText firstname,lastname,firstnameAR,lastnameAR;
    Bundle bundle;
    View back;

    public SecondStepFragment() {
        // Required empty public constructor
    }

    public static SecondStepFragment newInstance(String param1, String param2) {
        SecondStepFragment fragment = new SecondStepFragment();
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

    View view= inflater.inflate(R.layout.fragment_second_step, container, false);
        getActivity().findViewById(R.id.bottomSteps).setVisibility(View.VISIBLE);

    //get informations from view
        firstname = view.findViewById(R.id.fname);
        lastname = view.findViewById(R.id.lname);
        firstnameAR = view.findViewById(R.id.fnameAR);
        lastnameAR = view.findViewById(R.id.lnameAR);

        back = getActivity().findViewById(R.id.back2);
        back.setOnClickListener(this);


    next = view.findViewById(R.id.nextStep2);
    next.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v== next){
            Fragment fragment = new ThirdStepFragment();

            bundle = new Bundle();
            bundle.putString("fname",firstname.getText().toString().trim());
            bundle.putString("lname",lastname.getText().toString().trim());
            bundle.putString("fnameAR",firstnameAR.getText().toString().trim());
            bundle.putString("lnameAR",lastnameAR.getText().toString().trim());
            fragment.setArguments(bundle);
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left)
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            getActivity().findViewById(R.id.s2).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_signin_btn));

/*
 Fragment fragment = new SecondStepFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
*/
        }
        if (v==back){
            Fragment fragment = new FirstStepFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//            fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
            getActivity().findViewById(R.id.step2).setBackgroundColor(getResources().getColor(R.color.darkGray));
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }


    }


    @Override
    public boolean onBackPressed() {
        if (true) {
            //action not popBackStack
            Fragment fragment = new FirstStepFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//            fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
            getActivity().findViewById(R.id.step2).setBackgroundColor(getResources().getColor(R.color.darkGray));
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            return true;
        } else {
            return false;
        }
    }
}