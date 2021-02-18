package serive.algeria.chifacomapp.doctors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import serive.algeria.chifacomapp.R;

public class DoctorsList extends AppCompatActivity {

   private RecyclerView recyclerView;
   private RecyclerView.Adapter adapter;
   private RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_list);

        ArrayList<DoctorItem> doctorItems = new ArrayList<>();

        for (int i = 0 ; i<10 ;i++){
            doctorItems.add(new DoctorItem(R.drawable.profile,"firstname lastname","Generaliste"));
        }

        recyclerView = findViewById(R.id.doctorList);
        recyclerView.setHasFixedSize(true);
        manager= new LinearLayoutManager(this);
        adapter= new DoctorAdapter(doctorItems);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }
}