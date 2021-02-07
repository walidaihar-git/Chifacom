package serive.algeria.chifacom.register;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import serive.algeria.chifacom.IonBackPressed;
import serive.algeria.chifacom.R;


public class SecurityStepFragment extends Fragment  implements View.OnClickListener, IonBackPressed {
    private Bundle bundle;
    EditText username , password ;
    AppCompatButton nextStep ;
    View back;

    public SecurityStepFragment() {
        // Required empty public constructor
    }


    public static SecurityStepFragment newInstance(String param1, String param2) {
        SecurityStepFragment fragment = new SecurityStepFragment();


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
        View view= inflater.inflate(R.layout.fragment_security_step, container, false);
        getActivity().findViewById(R.id.bottomSteps).setVisibility(View.VISIBLE);
        bundle=this.getArguments();
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);

        back = getActivity().findViewById(R.id.back2);
        back.setOnClickListener(this);

        nextStep = view.findViewById(R.id.nextStepSecurity);
        nextStep.setOnClickListener(this);

        return  view;
    }

    @Override
    public void onClick(View v) {
   if (v == nextStep ){
       bundle=this.getArguments();
       Fragment fragment = new FifthStepFragment();
       if (bundle != null) {
           bundle.putString("username", username.getText().toString().trim());
           bundle.putString("password", password.getText().toString().trim());
       }

       fragment.setArguments(bundle);

       getFragmentManager().beginTransaction()
               .setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left)
               .replace(R.id.fragment_container, fragment)
               .addToBackStack(null)
               .commit();
       getActivity().findViewById(R.id.step3).setBackgroundColor(getResources().getColor(R.color.blueBack));
   }

        if (v == back){
            Fragment fragment = new ForthStepFragment();

            fragment.setArguments(bundle);

            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left)
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            getActivity().findViewById(R.id.s4).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_gray));

        }
    }


    @Override
    public boolean onBackPressed() {
        if (true) {
            //action not popBackStack
            Fragment fragment = new ForthStepFragment();

            fragment.setArguments(bundle);

            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left)
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            getActivity().findViewById(R.id.s4).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_gray));

            return true;
        } else {
            return false;
        }
    }
}