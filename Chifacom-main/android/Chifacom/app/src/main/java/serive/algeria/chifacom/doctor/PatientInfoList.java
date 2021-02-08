package serive.algeria.chifacom.doctor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import serive.algeria.chifacom.R;


public class PatientInfoList extends Fragment {
    private TextView calenderTv ;
    private AppCompatButton today ;
    private ImageView previous, next ;

    private ListView listView ;
    private List<Patient> list ;
    private Patient patient ;
    private AdapterPatient adapterPatient;

    private RecyclerView recyclerView;
    private ArrayList<Patient> arrayList;
    private AdapterRvPatient adapterRvPatient;
    RecyclerView.LayoutManager layoutManager;

int day,month ;
    public PatientInfoList() {
        // Required empty public constructor
    }

    public static PatientInfoList newInstance() {
        PatientInfoList fragment = new PatientInfoList();

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
        View view= inflater.inflate(R.layout.fragment_patient_info_list, container, false);
        getActivity().findViewById(R.id.chipNavigationBar).setVisibility(View.VISIBLE);

        recyclerView = view.findViewById(R.id.patients_rv);

        //setPatient();
        setPatient2();

        calenderTv = view.findViewById(R.id.calendar);
        today = view.findViewById(R.id.today);
        previous = view.findViewById(R.id.previous);
        next = view.findViewById(R.id.next);

        Calendar calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH)+1;
        setCalenderTv(day,month);
        today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day = calendar.get(Calendar.DAY_OF_MONTH);
                month = calendar.get(Calendar.MONTH)+1;
                setCalenderTv(day,month);


            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (day+1>30){day=1;month=month+1;}

                else{day = day+1;}

                setCalenderTv(day, month);
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (day-1<1){
                    if (month!=1){day=1;month=month-1;}
                    else {day=1;month=12;}
                }

                else{day = day-1;}

                setCalenderTv(day, month);
            }
        });


        return view;
    }

    private void setPatient2() {
        arrayList = new ArrayList<>();

        arrayList.add(new Patient(1,"Younes Akram","22","06977974132","Gripe ..."));
        arrayList.add(new Patient(2,"Younes Abdelmoula","20","06777912332","حالة مستعجلة للجلد"));
        arrayList.add(new Patient(3,"Yahia Bilal","24","07998974132","استشارة فقط"));
        arrayList.add(new Patient(4,"Abdou","22","05667974132","زكام"));
        arrayList.add(new Patient(5,"Younes Akram","22","06977974132","Gripe ..."));
        arrayList.add(new Patient(6,"Younes Abdelmoula","20","06777912332","حالة مستعجلة للجلد"));
        arrayList.add(new Patient(7,"Yahia Bilal","24","07998974132","استشارة فقط"));
        arrayList.add(new Patient(8,"Abdou","22","05667974132","زكام"));

        adapterRvPatient = new AdapterRvPatient(requireContext(),arrayList);
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterRvPatient);
    }


    private void setCalenderTv(int day, int month) {
        calenderTv.setText(day +"/"+month);
    }

    /*private void setPatient() {
        patient = new Patient();

        list = new ArrayList<Patient>();
        adapterPatient = new AdapterPatient(getActivity(),R.layout.item_patient,list);
        list.add(new Patient(1,"Younes Akram","22","06977974132","Gripe ..."));
        list.add(new Patient(2,"Younes Abdelmoula","20","06777912332","حالة مستعجلة للجلد"));
        list.add(new Patient(3,"Yahia Bilal","24","07998974132","استشارة فقط"));
        list.add(new Patient(4,"Abdou","22","05667974132","زكام"));
        list.add(new Patient(5,"Younes Akram","22","06977974132","Gripe ..."));
        list.add(new Patient(6,"Younes Akram","22","06977974132","Gripe ..."));
        list.add(new Patient(7,"Younes Akram","22","06977974132","Gripe ..."));
        list.add(new Patient(8,"Younes Akram","22","06977974132","Gripe ..."));
        list.add(new Patient(9,"Younes Akram","22","06977974132","Gripe ..."));
        list.add(new Patient(10,"Younes Akram","22","06977974132","Gripe ..."));
        list.add(new Patient(11,"Younes Akram","22","06977974132","Gripe ..."));
        list.add(new Patient(12,"Younes Akram","22","06977974132","Gripe ..."));

        listView.setAdapter(adapterPatient);
    }*/
}