package serive.algeria.chifacom.doctor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import serive.algeria.chifacom.R;


public class AccountSecurityFragment extends Fragment {


    public AccountSecurityFragment() {
        // Required empty public constructor
    }

    public static AccountSecurityFragment newInstance(String param1, String param2) {
        AccountSecurityFragment fragment = new AccountSecurityFragment();
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
       View view =  inflater.inflate(R.layout.fragment_account_security, container, false);




       return view;
    }
}