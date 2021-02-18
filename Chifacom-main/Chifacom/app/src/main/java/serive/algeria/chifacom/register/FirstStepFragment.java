package serive.algeria.chifacom.register;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import serive.algeria.chifacom.IonBackPressed;
import serive.algeria.chifacom.LoginActivity;
import serive.algeria.chifacom.R;
import serive.algeria.chifacom.RegisterActivity;

public class FirstStepFragment extends Fragment implements View.OnClickListener,IonBackPressed {

   LinearLayout doctorNav,cabinetNav;
   AppCompatButton nextstep;
   ImageView back;


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

        nextstep = view.findViewById(R.id.nextstep);
        nextstep.setOnClickListener(this);

        doctorNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doctorNav.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.language_2));
                nextstep.setEnabled(true);

            }
        });
        cabinetNav.setOnClickListener(this);

        back = view.findViewById(R.id.backtologin);
        back.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {

        if (v==nextstep){
            // replace the choice fragment by Doctor fragment
            // here you can send other parameters for user permissions
            nextstep.setTextColor(Color.WHITE);
            nextstep.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.bg_signin_btn));

                Fragment fragment = new SecondStepFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
                getActivity().findViewById(R.id.step2).setBackgroundColor(getResources().getColor(R.color.blueBack));
                TextView txt = getActivity().findViewById(R.id.step);
                txt.setText("Etap 2/7 :");
                TextView txt2 = getActivity().findViewById(R.id.stepLabel);
                txt2.setText("Nom et Prenom");
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();


        }
        if (v==cabinetNav){
            // do the same thing ,
            // you can send other parameters related to Cabinet

        }
        if (v== back){
            Intent intent = new Intent(getContext(), LoginActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public boolean onBackPressed() {
        if (true) {

            return true;
        } else {
            return false;
        }
    }


}