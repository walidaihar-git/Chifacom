package serive.algeria.chifacomapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import java.util.ArrayList;

import serive.algeria.chifacomapp.doctors.DoctorAdapter;
import serive.algeria.chifacomapp.doctors.DoctorItem;

public class SearchFormActivity extends AppCompatActivity {

    AppCompatButton search ;
    LinearLayout layout1 ,layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_form);

        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);

        search = findViewById(R.id.searchBtn);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_top);
                Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_right);
                layout1.startAnimation(animation);
                layout1.setVisibility(View.GONE);
                layout2.setVisibility(View.VISIBLE);
                //layout 2
                doctorList();
                layout2.startAnimation(animation2);
            }
        });



    }
    public void doctorList(){
         RecyclerView recyclerView;
         RecyclerView.Adapter adapter;
         RecyclerView.LayoutManager manager;
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