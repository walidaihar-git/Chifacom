package serive.algeria.chifacom.register;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import serive.algeria.chifacom.R;


public class SecondStepFragment extends Fragment implements View.OnClickListener {
    AppCompatButton next ;
    EditText firstname,lastname,speciality,birthdate,phone,email;


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

    //get informations from view
        firstname = view.findViewById(R.id.fname);
        lastname = view.findViewById(R.id.lname);
        speciality = view.findViewById(R.id.speciality);
        birthdate = view.findViewById(R.id.birthdate);
        phone = view.findViewById(R.id.phone);
        email = view.findViewById(R.id.emailE);


    next = view.findViewById(R.id.nextStep);
    next.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v== next){
            Fragment fragment = new ThirdStepFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}