package serive.algeria.chifacom.register;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import serive.algeria.chifacom.IonBackPressed;
import serive.algeria.chifacom.R;


public class SixthStepFragment extends Fragment implements View.OnClickListener, IonBackPressed {

    AppCompatButton nextStep ;
    private Bundle bundle;
    private TextView textView,back;

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
        getActivity().findViewById(R.id.bottomSteps).setVisibility(View.INVISIBLE);
        bundle = this.getArguments();

        textView = view.findViewById(R.id.labelscan);
//        textView.setText(bundle.getString("fname","")+", "+bundle.getString("birthplace",""));

        back = view.findViewById(R.id.back);
        back.setOnClickListener(this);

        nextStep = view.findViewById(R.id.nextStep6);
        nextStep.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v==nextStep){
            Fragment fragment = new SeventhStepFragment();
            fragment.setArguments(bundle);
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left)
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();

            getActivity().findViewById(R.id.step5).setBackgroundColor(getResources().getColor(R.color.blueBack));

        }
        if (v == back){
            Fragment fragment = new FifthStepFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            getActivity().findViewById(R.id.step4).setBackgroundColor(getResources().getColor(R.color.darkGray));
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
            getActivity().findViewById(R.id.step4).setBackgroundColor(getResources().getColor(R.color.darkGray));
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            return true;
        } else {
            return false;
        }
    }
}