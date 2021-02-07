package serive.algeria.chifacom.forgetPass;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import serive.algeria.chifacom.LoginActivity;
import serive.algeria.chifacom.R;

public class AllSetFragment extends Fragment implements View.OnClickListener {

Button loginNav;

    public AllSetFragment() {
        // Required empty public constructor
    }

    public static AllSetFragment newInstance() {
        AllSetFragment fragment = new AllSetFragment();

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
       View view= inflater.inflate(R.layout.fragment_all_set, container, false);

       loginNav = view.findViewById(R.id.loginNav);
       loginNav.setOnClickListener(this);


    return view;
    }

    @Override
    public void onClick(View v) {
        if (v== loginNav){
            Intent intent = new Intent(getContext(), LoginActivity.class);
            startActivity(intent);
        }
    }
}