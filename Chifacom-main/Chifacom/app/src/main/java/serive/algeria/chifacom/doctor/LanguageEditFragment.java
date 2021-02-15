package serive.algeria.chifacom.doctor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import serive.algeria.chifacom.R;


public class LanguageEditFragment extends Fragment {



    public LanguageEditFragment() {
        // Required empty public constructor
    }


    public static LanguageEditFragment newInstance(String param1, String param2) {
        LanguageEditFragment fragment = new LanguageEditFragment();
        Bundle args = new Bundle();

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
        View view =  inflater.inflate(R.layout.fragment_language_edit, container, false);





        return  view;
    }
}