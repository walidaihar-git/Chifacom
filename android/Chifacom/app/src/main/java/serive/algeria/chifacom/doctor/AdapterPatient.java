package serive.algeria.chifacom.doctor;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.gson.Gson;

import java.util.List;

import serive.algeria.chifacom.R;


public class AdapterPatient extends ArrayAdapter  {
    Activity activity;
    int resource;
    List<Patient> list;
    Patient patient;


    public AdapterPatient(Activity activity, int resource, List<Patient> list) {
        super(activity, resource,list);
        this.activity = activity;
        this.resource = resource;
        this.list = list;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = activity.getLayoutInflater();

        View view = layoutInflater.inflate(resource,null);

        patient = new Patient();
        patient = list.get(position);


        TextView index = view.findViewById(R.id.index);
        index.setText(patient.getIndex()+"");
        TextView fullname = view.findViewById(R.id.patient_fullName);
        fullname.setText(patient.getFullname()+"");


        return view;
    }


}