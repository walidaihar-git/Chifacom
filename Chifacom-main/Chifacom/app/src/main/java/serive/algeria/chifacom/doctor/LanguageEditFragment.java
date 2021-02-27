package serive.algeria.chifacom.doctor;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import serive.algeria.chifacom.R;
import serive.algeria.chifacom.controle.Language;
import serive.algeria.chifacom.register.SecondStepFragment;


public class LanguageEditFragment extends Fragment {

    private Language language;
    private RadioGroup radio_group;
    private RadioButton arab,francais;

    public LanguageEditFragment() {
        // Required empty public constructor
    }


    public static LanguageEditFragment newInstance() {
        LanguageEditFragment fragment = new LanguageEditFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        language = new Language(getContext());
        language.setLocate(language.getLocale(),getContext());
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_language_edit, container, false);

        radio_group = (RadioGroup) view.findViewById(R.id.radio_group);
        arab = view.findViewById(R.id.arab);
        francais = view.findViewById(R.id.francais);

        if (language.getLocale().equals("ar")){
            arab.setChecked(true);

        }else if (language.getLocale().equals("fr")){
            francais.setChecked(true);
        }

        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.arab){
                    language.setLocate("ar",getContext());
                    restartFragment();
                }else if(checkedId == R.id.francais){
                    language.setLocate("fr",getContext());
                    restartFragment();
                }
            }
        });


        return  view;
    }

    private void restartFragment() {
        /*
        FragmentTransaction tr = getFragmentManager().beginTransaction();
        tr.replace(R.id.container, LanguageEditFragment.newInstance());
        tr.commit();
        */
        /*
        Fragment frg = null;
        frg = getActivity().getSupportFragmentManager().findFragmentById(R.id.container);
        final FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.detach(frg);
        ft.attach(frg);
        ft.commit();
        */

        final Handler handler  = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent i = getActivity().getPackageManager().getLaunchIntentForPackage(getActivity().getPackageName());
                startActivity(i);
                System.exit(0);
            }
        };
        handler.postDelayed(runnable, 3000);

    }

}