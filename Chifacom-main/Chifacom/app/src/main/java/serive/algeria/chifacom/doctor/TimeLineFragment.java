package serive.algeria.chifacom.doctor;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import serive.algeria.chifacom.R;
import serive.algeria.chifacom.register.ThirdStepFragment;


public class TimeLineFragment extends Fragment {


    private ListView listView ;
    private List<Patient> list ;
    private Patient patient ;
    private AdapterPatient adapterPatient;
    TextView language;


    public TimeLineFragment() {
        // Required empty public constructor
    }

    public static TimeLineFragment newInstance() {
        TimeLineFragment fragment = new TimeLineFragment();

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
        View view= inflater.inflate(R.layout.fragment_time_line, container, false);
        ((AppCompatActivity) getContext()).getSupportActionBar().show();

        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#ffffff"));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setBackgroundDrawable(colorDrawable);

        language = getActivity().findViewById(R.id.language);
        language.setVisibility(View.INVISIBLE);

        listView = view.findViewById(R.id.list_view);
        setPatient();



        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),position+"", Toast.LENGTH_SHORT).show();

            }
        });*/
        return view;
    }



    private void setPatient() {
        patient = new Patient();

        list = new ArrayList<Patient>();
        adapterPatient = new AdapterPatient(getActivity(),R.layout.item_patient_timeline,list);

        list.add(new Patient(1,"Younes Akram","22","06977974132","Gripe ..."));
        list.add(new Patient(2,"Younes Abdelmoula","20","06777912332","حالة مستعجلة للجلد"));
        list.add(new Patient(3,"Yahia Bilal","24","07998974132","استشارة فقط"));
        list.add(new Patient(4,"Abdou","22","05667974132","زكام"));
        list.add(new Patient(1,"Younes Akram","22","06977974132","Gripe ..."));
        list.add(new Patient(1,"Younes Akram","22","06977974132","Gripe ..."));
        list.add(new Patient(1,"Younes Akram","22","06977974132","Gripe ..."));
        list.add(new Patient(1,"Younes Akram","22","06977974132","Gripe ..."));
        list.add(new Patient(1,"Younes Akram","22","06977974132","Gripe ..."));
        list.add(new Patient(1,"Younes Akram","22","06977974132","Gripe ..."));
        list.add(new Patient(1,"Younes Akram","22","06977974132","Gripe ..."));
        list.add(new Patient(1,"Younes Akram","22","06977974132","Gripe ..."));



        listView.setAdapter(adapterPatient);
    }
}