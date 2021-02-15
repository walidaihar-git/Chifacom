package serive.algeria.chifacom.forgetPass;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import serive.algeria.chifacom.R;


public class SendCodeFragment extends Fragment implements View.OnClickListener, TextWatcher {

    AppCompatButton recover;
    EditText c1,c2,c3,c4,c5,c6;

    public SendCodeFragment()  {
        // Required empty public constructor
    }


    public static SendCodeFragment newInstance() {
        SendCodeFragment fragment = new SendCodeFragment();

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
        View view= inflater.inflate(R.layout.fragment_send_code, container, false);

        c1 = view.findViewById(R.id.c1);
        c2 = view.findViewById(R.id.c2);
        c3 = view.findViewById(R.id.c3);
        c4 = view.findViewById(R.id.c4);
        c5 = view.findViewById(R.id.c5);
        c6 = view.findViewById(R.id.c6);

        c1.addTextChangedListener(this);
        c2.addTextChangedListener(this);
        c3.addTextChangedListener(this);
        c4.addTextChangedListener(this);
        c5.addTextChangedListener(this);


         recover = view.findViewById(R.id.recoverCode);
         recover.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v== recover){
           Fragment fragment = new NewPassFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
            fragmentTransaction.replace(R.id.fragment_containerPass, fragment);
            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (c1.getText().toString().trim().length() == 1)
        {
            c2.requestFocus();

        }
        if (c2.getText().toString().trim().length() == 1)
        {
            c2.clearFocus();
            c3.requestFocus();
        }

        if (c3.getText().toString().trim().length() == 1)
        {
            c3.clearFocus();
            c4.requestFocus();
        }
        if (c4.getText().toString().trim().length() == 1)
        {
            c4.clearFocus();
            c5.requestFocus();
        }
        if (c5.getText().toString().trim().length() == 1)
        {
            c5.clearFocus();
            c6.requestFocus();
        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}