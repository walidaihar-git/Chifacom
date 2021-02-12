package serive.algeria.chifacom.doctor;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import serive.algeria.chifacom.R;


public class ControlPageFragment extends Fragment implements View.OnClickListener {

 EditText day,month,year;
 TextView dayT , monthT,yearT;
 TextView fulldate;
    ImageView imageView ;
    ImageView prevDay, nextDay,prevMonth,nextMonth,prevYear,nextYear;
    TextView language;

    LinearLayout actionNav;

    Calendar c = null;

    public ControlPageFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ControlPageFragment newInstance(String param1, String param2) {
        ControlPageFragment fragment = new ControlPageFragment();
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
        View view=  inflater.inflate(R.layout.fragment_control_page, container, false);
        ((AppCompatActivity) getContext()).getSupportActionBar().show();

        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#ffffff"));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setBackgroundDrawable(colorDrawable);

        language = getActivity().findViewById(R.id.language);
        language.setVisibility(View.INVISIBLE);

        prevDay = view.findViewById(R.id.prevDay);
        prevMonth = view.findViewById(R.id.prevMonth);
        prevYear = view.findViewById(R.id.prevYear);

        nextDay = view.findViewById(R.id.nextDay);
        nextMonth = view.findViewById(R.id.nextMonth);
        nextYear = view.findViewById(R.id.nextYear);

        prevDay.setOnClickListener(this);
        prevMonth.setOnClickListener(this);
        prevYear.setOnClickListener(this);
        nextDay.setOnClickListener(this);
        nextMonth.setOnClickListener(this);
        nextYear.setOnClickListener(this);

        day = view.findViewById(R.id.dayEditText);
        month = view.findViewById(R.id.monthEditText);
        year = view.findViewById(R.id.yearEditText);

        dayT = view.findViewById(R.id.dayText);
        monthT = view.findViewById(R.id.monthText);
        yearT = view.findViewById(R.id.yearText);

        fulldate = view.findViewById(R.id.fullDate);

        actionNav = view.findViewById(R.id.actionNav);
        actionNav.setOnClickListener(this);

         c = Calendar.getInstance();
        String monthname=(String)android.text.format.DateFormat.format("MMMM", new Date());
        int currentyear = c.get(Calendar.YEAR);
        int currentmonth = c.get(Calendar.MONTH);
        int currentday = c.get(Calendar.DAY_OF_MONTH);

        day.setHint(""+currentday);
        dayT.setText(String.valueOf(currentday));
        month.setHint(""+(currentmonth+1));
        monthT.setText(monthname);
        year.setHint(""+currentyear);
        yearT.setText(String.valueOf(currentyear));

        String full = currentday+ "-" + ( currentmonth+1) + "-"+ currentyear;

        fulldate.setText(full);


       getActivity().findViewById(R.id.chipNavigationBar).setVisibility(View.VISIBLE);

       imageView = view.findViewById(R.id.timeline);
       imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Fragment fragment = new TimeLineFragment();
               FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
               FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
               fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
               fragmentTransaction.replace(R.id.container, fragment);
               fragmentTransaction.addToBackStack(null);

               fragmentTransaction.commit();
           }
       });


       return view;
    }

    @Override
    public void onClick(View v) {

        if (v == actionNav) {
            Fragment fragment = new DoctorActionsFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();
        }


        if (v == prevDay) {
           c.add(Calendar.DAY_OF_MONTH, -1); //Goes to previous day ;
            day.setText(String.valueOf(c.get(Calendar.DAY_OF_MONTH)));
        }

            if ( v== prevMonth ) {
                c.add(Calendar.MONTH, -1); //Goes to previous month ;
            }

                    if (v == prevYear) {
                        c.add(Calendar.YEAR, -1); //Goes to previous year ;
                    }

                    if (v == nextDay) {
                        c.add(Calendar.DAY_OF_MONTH, 1); //Goes to next day ;
                        day.setText(String.valueOf(c.get(Calendar.DAY_OF_MONTH)));
                    }

                    if (v == nextMonth) {
                        c.add(Calendar.MONTH, 1); //Goes to next month ;
                    }

                    if (v == nextYear) {
                        c.add(Calendar.YEAR, 1); //Goes to next year ;
                    }
                }

            }
