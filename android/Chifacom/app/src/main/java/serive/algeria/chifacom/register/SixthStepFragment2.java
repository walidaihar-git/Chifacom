package serive.algeria.chifacom.register;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import serive.algeria.chifacom.IonBackPressed;
import serive.algeria.chifacom.R;


public class SixthStepFragment extends Fragment implements View.OnClickListener, IonBackPressed {

    AppCompatButton nextStep ;


    public SixthStepFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static SixthStepFragment newInstance() {
        SixthStepFragment fragment = new SixthStepFragment();
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
        View view =  inflater.inflate(R.layout.fragment_sixth_step, container, false);
        nextStep = view.findViewById(R.id.nextStep6);
        nextStep.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v==nextStep){
            Fragment fragment = new SeventhStepFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
            getActivity().findViewById(R.id.step7).setBackgroundColor(getResources().getColor(R.color.blueBack));
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public boolean onBackPressed() {
        if (true) {
            //action not popBackStack
            Fragment fragment = new FifthStepFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            getActivity().findViewById(R.id.step6).setBackgroundColor(getResources().getColor(R.color.darkGray));
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            return true;
        } else {
            return false;
        }
    }
}