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


public class FifthStepFragment extends Fragment implements IonBackPressed, View.OnClickListener {

    AppCompatButton nextStep ;
    private Bundle bundle ;
    private TextView textView,back ;

    public FifthStepFragment() {
        // Required empty public constructor
    }


    public static FifthStepFragment newInstance() {
        FifthStepFragment fragment = new FifthStepFragment();

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
        View view =  inflater.inflate(R.layout.fragment_fifth_step, container, false);
        getActivity().findViewById(R.id.bottomSteps).setVisibility(View.INVISIBLE);
        bundle = this.getArguments();

        textView = view.findViewById(R.id.labelMap);
        //textView.setText(bundle.getString("fname","")+", "+bundle.getString("birthplace",""));

        back = view.findViewById(R.id.back);
        back.setOnClickListener(this);

        nextStep = view.findViewById(R.id.nextStep5);
        nextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new SixthStepFragment();

                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left)
                        .replace(R.id.fragment_container, fragment)
                        .addToBackStack(null)
                        .commit();
                getActivity().findViewById(R.id.step4).setBackgroundColor(getResources().getColor(R.color.blueBack));



            }
        });

        return view;
    }

    @Override
    public boolean onBackPressed() {

        if (true) {
            //action not popBackStack
            Fragment fragment = new SecurityStepFragment();

            fragment.setArguments(bundle);

            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left)
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            getActivity().findViewById(R.id.step3).setBackgroundColor(getResources().getColor(R.color.darkGray));

            return true;
        } else {
            return false;
        }
    }


    @Override
    public void onClick(View v) {

        if (v == back){
            Fragment fragment = new SecurityStepFragment();

            fragment.setArguments(bundle);

            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left)
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            getActivity().findViewById(R.id.step3).setBackgroundColor(getResources().getColor(R.color.darkGray));
        }
    }
}