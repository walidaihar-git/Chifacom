package serive.algeria.chifacom.register;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import serive.algeria.chifacom.IonBackPressed;
import serive.algeria.chifacom.MapsActivity;
import serive.algeria.chifacom.R;


public class ThirdStepFragment extends Fragment implements View.OnClickListener, IonBackPressed {

AppCompatButton nextStep ;
AppCompatButton btnMap;
EditText address ;

    public ThirdStepFragment() {
        // Required empty public constructor
    }

    public static ThirdStepFragment newInstance() {
        ThirdStepFragment fragment = new ThirdStepFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_third_step, container, false);



        //get views
        address = view.findViewById(R.id.address);

        nextStep = view.findViewById(R.id.nextStep3);
        nextStep.setOnClickListener(this);

        btnMap=view.findViewById(R.id.mapFragment);
        btnMap.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v==nextStep){
            Fragment fragment = new ForthStepFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
            getActivity().findViewById(R.id.step4).setBackgroundColor(getResources().getColor(R.color.blueBack));
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        if (v==btnMap){

        }
    }

    @Override
    public boolean onBackPressed() {
        if (true) {
            //action not popBackStack
            Fragment fragment = new SecondStepFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            getActivity().findViewById(R.id.step3).setBackgroundColor(getResources().getColor(R.color.darkGray));
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            return true;
        } else {
            return false;
        }
    }
}