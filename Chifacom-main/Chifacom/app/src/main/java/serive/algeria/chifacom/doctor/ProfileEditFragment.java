package serive.algeria.chifacom.doctor;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import serive.algeria.chifacom.R;


public class ProfileEditFragment extends Fragment {
    EditText  cabinetName ,specialityName2,serviceName,deplomeName,workWithName,subsribeWithName,
            phoneNumber2,phoneNumber3,phoneNumber4,phoneFix,
            faxNumber,facebook,youtube,instagram,descriptionbox;

    TextView fullname,localisationLabel;
    AppCompatButton save;

    public ProfileEditFragment() {
        // Required empty public constructor
    }

    public static ProfileEditFragment newInstance(String param1, String param2) {
        ProfileEditFragment fragment = new ProfileEditFragment();
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
        View view = inflater.inflate(R.layout.fragment_profile_edit, container, false);

        //get views

        save = view.findViewById(R.id.saveProfile);
       // save.setOnClickListener(this);

        //1---- texts
        fullname = view.findViewById(R.id.fullname); //  textview
        cabinetName = view.findViewById(R.id.cabinetName);
      //  specialityName1 = view.findViewById(R.id.specialityName1);  // textview
        specialityName2 = view.findViewById(R.id.specialityName2);  // ,,
        serviceName = view.findViewById(R.id.serviceName);
        deplomeName = view.findViewById(R.id.deplomeName);
        workWithName = view.findViewById(R.id.workWithName);
        subsribeWithName = view.findViewById(R.id.subscribeWithName);
      //  phoneNumber1 = view.findViewById(R.id.phoneNumber1); //textview
        phoneNumber2 = view.findViewById(R.id.phoneNumber2); // ,,
        phoneNumber3 = view.findViewById(R.id.phoneNumber3); // ,,
        phoneNumber4 = view.findViewById(R.id.phoneNumbe4);  // ,,
        phoneFix = view.findViewById(R.id.phoneFix);
        faxNumber = view.findViewById(R.id.faxNumber);
       // emailValue = view.findViewById(R.id.emailValue); // textview
        facebook = view.findViewById(R.id.facebook);
        youtube = view.findViewById(R.id.youtube);
        instagram = view.findViewById(R.id.instagram);
        descriptionbox = view.findViewById(R.id.descriptionBox);


        localisationLabel = view.findViewById(R.id.localisationLabel); //textview


        return  view;
    }
}