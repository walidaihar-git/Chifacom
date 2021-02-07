package serive.algeria.chifacom.doctor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

import serive.algeria.chifacom.IonBackPressed;
import serive.algeria.chifacom.R;
import serive.algeria.chifacom.register.SixthStepFragment;


public class workFragment extends Fragment {

    private ListView listView ;
    private List<Patient> list ;
    private Patient patient ;
    private AdapterPatient adapterPatient;


    public workFragment() {
        // Required empty public constructor
    }

    public static workFragment newInstance() {
        workFragment fragment = new workFragment();

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
        View view= inflater.inflate(R.layout.fragment_rooms, container, false);
        listView = view.findViewById(R.id.list_view);
        setPatient();



        return view;
    }

    private void setPatient() {
        patient = new Patient();

        list = new ArrayList<Patient>();
        adapterPatient = new AdapterPatient(getActivity(),R.layout.item_patient,list);
        for (int i =0 ;i<6;i++){
           // list.add(new Patient(i+1,"Younes"));
        }
        listView.setAdapter(adapterPatient);
    }


}