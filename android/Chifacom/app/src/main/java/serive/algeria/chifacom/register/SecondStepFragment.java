package serive.algeria.chifacom.register;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

import serive.algeria.chifacom.IonBackPressed;
import serive.algeria.chifacom.R;


public class SecondStepFragment extends Fragment implements View.OnClickListener, IonBackPressed {
    AppCompatButton next ;
    EditText firstname,lastname,speciality,phone,email;
    private AppCompatButton birthdate;
    private DatePickerDialog.OnDateSetListener onDateSetListener;
    String birthday = "";
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



    next = view.findViewById(R.id.nextStep2);
    next.setOnClickListener(this);
    birthdate.setOnClickListener(this);
        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1 ;
                birthday = year+"-"+month+"-"+dayOfMonth;
                birthdate.setText(birthdate.getText().toString()+" "+birthdate);
            }
        };
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v== next){
            Fragment fragment = new ThirdStepFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
            getActivity().findViewById(R.id.step3).setBackgroundColor(getResources().getColor(R.color.blueBack));
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

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

        if (v == birthdate){
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(
                    getContext(),
                    android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                    onDateSetListener,
                    year,month,day);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
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