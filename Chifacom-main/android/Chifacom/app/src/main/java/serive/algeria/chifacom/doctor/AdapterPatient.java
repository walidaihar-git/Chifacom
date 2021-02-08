package serive.algeria.chifacom.doctor;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import java.util.List;

import serive.algeria.chifacom.R;


public class AdapterPatient extends ArrayAdapter implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
    Activity activity;
    int resource;
    List<Patient> list;
    Patient patient;


    public AdapterPatient(Activity activity, int resource, List<Patient> list) {
        super(activity, resource, list);
        this.activity = activity;
        this.resource = resource;
        this.list = list;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = activity.getLayoutInflater();

        View view = layoutInflater.inflate(resource, null);

        patient = new Patient();
        patient = list.get(position);


        TextView index = view.findViewById(R.id.index);
        index.setText(patient.getIndex() + "");
        TextView fullname = view.findViewById(R.id.patient_fullName);
        fullname.setText(patient.getFullname() + "");

        AppCompatButton showCard = view.findViewById(R.id.show_card);
        showCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                patientInformationDialog(patient);
            }
        });

        ImageButton patient_menu = view.findViewById(R.id.menuPatient);
        patient_menu.setOnClickListener(this);

        return view;
    }

    private void patientInformationDialog(Patient patient) {

    }


    @Override
    public void onClick(View v) {
        PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
        popupMenu.inflate(R.menu.item_patient_menu);

        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:

                Toast.makeText(activity, "edit" + patient.getFullname(), Toast.LENGTH_SHORT).show();
                return true;

            default:
                return false;
        }
    }
}