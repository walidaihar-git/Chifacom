package serive.algeria.chifacom.register;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import serive.algeria.chifacom.R;


public class ForthStepFragment extends Fragment {



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


        return view;
    }
}