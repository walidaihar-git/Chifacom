package serive.algeria.chifacom.forgetPass;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import serive.algeria.chifacom.R;

public class NewPassFragment extends Fragment implements View.OnClickListener {
 AppCompatButton setNewPass;


    public NewPassFragment() {
        // Required empty public constructor
    }


    public static NewPassFragment newInstance(String param1, String param2) {
        NewPassFragment fragment = new NewPassFragment();

        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_new_pass, container, false);


        setNewPass = view.findViewById(R.id.setNewPass);
        setNewPass.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        if (v==setNewPass){
            Fragment fragment = new AllSetFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
            fragmentTransaction.replace(R.id.fragment_containerPass, fragment);
            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();
        }
    }
}