package serive.algeria.chifacom.doctor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import serive.algeria.chifacom.R;


public class ControlPageFragment extends Fragment {

    private String mParam1;
    private String mParam2;
    ImageView imageView ;

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
}