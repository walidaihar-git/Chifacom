package serive.algeria.chifacom.doctor;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import serive.algeria.chifacom.R;

public class DoctorProfileFragment extends Fragment implements View.OnClickListener{

    View decorView;
    Toolbar toolbar;

    AppCompatButton editProfile;

    TextView fullname, cabinetName ,specialityName1,specialityName2,serviceName,deplomeName,workWithName,subsribeWithName,
             phoneNumber1,phoneNumber2,phoneNumber3,phoneNumber4,phoneFix,
            faxNumber,emailValue,facebook,youtube,instagram,descriptionbox,localisationLabel;

    LinearLayout cabinetList,serviceList,deplomeList,workWithList,subscribeWithList,fax,social,description;



    public DoctorProfileFragment() {
        // Required empty public constructor
    }

    public static DoctorProfileFragment newInstance(String param1, String param2) {
        DoctorProfileFragment fragment = new DoctorProfileFragment();
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
        View view =  inflater.inflate(R.layout.fragment_doctor_profile, container, false);
        ((AppCompatActivity) getContext()).getSupportActionBar().hide();

        //get views

        editProfile = view.findViewById(R.id.editProfile);
        editProfile.setOnClickListener(this);

        //1---- texts
        fullname = view.findViewById(R.id.fullname); //  always
        cabinetName = view.findViewById(R.id.cabinetName);
        specialityName1 = view.findViewById(R.id.specialityName1);  // always
        specialityName2 = view.findViewById(R.id.specialityName2);  // ,,
        serviceName = view.findViewById(R.id.serviceName);
        deplomeName = view.findViewById(R.id.deplomeName);
        workWithName = view.findViewById(R.id.workWithName);
        subsribeWithName = view.findViewById(R.id.subscribeWithName);
        phoneNumber1 = view.findViewById(R.id.phoneNumber1); //always
        phoneNumber2 = view.findViewById(R.id.phoneNumber2); // ,,
        phoneNumber3 = view.findViewById(R.id.phoneNumber3); // ,,
        phoneNumber4 = view.findViewById(R.id.phoneNumbe4);  // ,,
        phoneFix = view.findViewById(R.id.phoneFix);
        faxNumber = view.findViewById(R.id.faxNumber);
        emailValue = view.findViewById(R.id.emailValue); // always
        facebook = view.findViewById(R.id.facebook);
        youtube = view.findViewById(R.id.youtube);
        instagram = view.findViewById(R.id.instagram);
        descriptionbox = view.findViewById(R.id.descriptionBox);
        localisationLabel = view.findViewById(R.id.localisationLabel); //always

        //2---- layouts
        cabinetList = view.findViewById(R.id.cabinetList);
        serviceList = view.findViewById(R.id.serviceList);
        deplomeList = view.findViewById(R.id.deplomeList);
        workWithList = view.findViewById(R.id.workWithList);
        subscribeWithList = view.findViewById(R.id.subscribeWithList);
        fax = view.findViewById(R.id.fax);
        social = view.findViewById(R.id.social);
        description = view.findViewById(R.id.description);

      checkInputs();







        return  view ;
    }

    private  void checkInputs(){
        if (cabinetName.getText() == ""){
            cabinetList.setVisibility(View.GONE);
        }
        if (serviceName.getText() == ""){
            serviceList.setVisibility(View.GONE);
        }
        if (deplomeName.getText() == ""){
            deplomeList.setVisibility(View.GONE);
        }
        if (workWithName.getText() == ""){
            workWithList.setVisibility(View.GONE);
        }
        if (subsribeWithName.getText() == ""){
            subscribeWithList.setVisibility(View.GONE);
        }
        if (faxNumber.getText() == ""){
            fax.setVisibility(View.GONE);
        }
        if (facebook.getText() == "" && youtube.getText() == "" && instagram.getText() == ""){
            social.setVisibility(View.GONE);
        }
        if (descriptionbox.getText() == ""){
            description.setVisibility(View.GONE);
        }

        if (phoneNumber2.getText() == ""){
            phoneNumber2.setVisibility(View.GONE);
        }
        if (phoneNumber3.getText() == ""){
            phoneNumber3.setVisibility(View.GONE);
        }
        if (phoneNumber4.getText() == ""){
            phoneNumber4.setVisibility(View.GONE);
        }
        if (phoneFix.getText() == ""){
            phoneFix.setVisibility(View.GONE);
        }
        if (facebook.getText() == ""){
            facebook.setVisibility(View.GONE);
        }
        if (youtube.getText() == ""){
            youtube.setVisibility(View.GONE);
        }
        if (instagram.getText() == ""){
            instagram.setVisibility(View.GONE);
        }

    }

    @Override
    public void onClick(View v) {
        if (v == editProfile){
            Fragment fragment = new ProfileEditFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}