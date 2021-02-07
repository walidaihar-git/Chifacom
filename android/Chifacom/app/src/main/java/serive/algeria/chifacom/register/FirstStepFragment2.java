package serive.algeria.chifacom.register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import serive.algeria.chifacom.IonBackPressed;
import serive.algeria.chifacom.LoginActivity;
import serive.algeria.chifacom.R;
import serive.algeria.chifacom.RegisterActivity;

public class FirstStepFragment extends Fragment implements View.OnClickListener, IonBackPressed {

   LinearLayout doctorNav,cabinetNav;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }
    public static FirstStepFragment newInstance(){
        FirstStepFragment fragment = new FirstStepFragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first_step, container, false);

        doctorNav = view.findViewById(R.id.doctorNav);
        cabinetNav = view.findViewById(R.id.cabinetNav);

        doctorNav.setOnClickListener(this);
        cabinetNav.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {

        if (v==doctorNav){
            // replace the choice fragment by Doctor fragment
            // here you can send other parameters for user permissions

            Fragment fragment = new SecondStepFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
            getActivity().findViewById(R.id.step2).setBackgroundColor(getResources().getColor(R.color.blueBack));
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();


        }
        if (v==cabinetNav){
            // do the same thing ,
            // you can send other parameters related to Cabinet

        }

    }

    @Override
    public boolean onBackPressed() {
        if (true) {
            //action not popBackStack
            Intent intent = new Intent(getContext(), LoginActivity.class);
            startActivity(intent);
            return true;
        } else {
            return false;
        }
    }


}