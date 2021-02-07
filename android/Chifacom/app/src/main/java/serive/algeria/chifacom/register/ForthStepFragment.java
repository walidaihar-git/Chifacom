package serive.algeria.chifacom.register;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import serive.algeria.chifacom.IonBackPressed;
import serive.algeria.chifacom.R;


public class ForthStepFragment extends Fragment implements View.OnClickListener, IonBackPressed {

    AppCompatButton nextStep ;
    EditText email , phone ;
    private Bundle bundle;
    View back;

    public ForthStepFragment() {
        // Required empty public constructor
    }


    public static ForthStepFragment newInstance() {
        ForthStepFragment fragment = new ForthStepFragment();

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
        View view =  inflater.inflate(R.layout.fragment_forth_step, container, false);
        bundle=this.getArguments();

        back = getActivity().findViewById(R.id.back2);
        back.setOnClickListener(this);

        email = view.findViewById(R.id.emailE);
        phone = view.findViewById(R.id.phone);

        //email.setText(bundle.getString("fname","")+", "+bundle.getString("birthplace",""));

        nextStep = view.findViewById(R.id.nextStep4);
        nextStep.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v==nextStep){
            Fragment fragment = new SecurityStepFragment();
            bundle.putString("email",email.getText().toString().trim());
            bundle.putString("phone",phone.getText().toString().trim());

            fragment.setArguments(bundle);

            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left)
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            getActivity().findViewById(R.id.s4).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_signin_btn));

        }
        if (v == back){
            Fragment fragment = new ThirdStepFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            getActivity().findViewById(R.id.s3).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_gray));
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public boolean onBackPressed() {
        if (true) {
            //action not popBackStack
            Fragment fragment = new ThirdStepFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            getActivity().findViewById(R.id.s3).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_gray));
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            return true;
        } else {
            return false;
        }
    }
}