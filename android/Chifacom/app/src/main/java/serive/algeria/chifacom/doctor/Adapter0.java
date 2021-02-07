package serive.algeria.chifacom.doctor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class Adapter0 extends RecyclerView.Adapter<Adapter0.ViewHolderPatient> {
    private ArrayList<Patient> list;
    private int resource;

    RecycleViewPatientClickListiner recycleViewPatientClickListiner;

    public Adapter0(int resource, ArrayList<Patient> list, RecycleViewPatientClickListiner recycleViewPatientClickListiner) {
        this.list = list;
        this.recycleViewPatientClickListiner = recycleViewPatientClickListiner;
        this.resource = resource;
    }


    @NonNull
    @Override
    public ViewHolderPatient onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, null, false);

        ViewHolderPatient viewHolderPatient = new ViewHolderPatient(view);

        return viewHolderPatient;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPatient holder, final int position) {
        Patient patient = list.get(position);

        // holder.name.setText(patient.getName());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderPatient extends RecyclerView.ViewHolder {

        private TextView name;

        public ViewHolderPatient(@NonNull final View itemView) {
            super(itemView);
            // name = itemView.findViewById(R.id.name_prod);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recycleViewPatientClickListiner.onItemClick("lala");
                }
            });
        }
    }

}

