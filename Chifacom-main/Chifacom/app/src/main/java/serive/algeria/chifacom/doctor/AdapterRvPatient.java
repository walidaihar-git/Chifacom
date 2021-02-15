package serive.algeria.chifacom.doctor;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import serive.algeria.chifacom.R;

public class AdapterRvPatient extends RecyclerView.Adapter<AdapterRvPatient.PatientViewHolder> {
    private ArrayList<Patient> arrayList ;
    private Context context;

    public AdapterRvPatient(Context context, ArrayList<Patient> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public PatientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PatientViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_patient,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PatientViewHolder holder, int position) {
        holder.index.setText(arrayList.get(position).getIndex()+"");
        holder.fullname.setText(arrayList.get(position).getFullname()+"");
        holder.showCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_patient_information);
                dialog.setCancelable(true);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                TextView name, age, phone, des;
                name = dialog.findViewById(R.id.name);
                age = dialog.findViewById(R.id.age);
                phone = dialog.findViewById(R.id.phone);
                des = dialog.findViewById(R.id.description);
                name.setText(arrayList.get(position).getFullname() + "");
                age.setText(arrayList.get(position).getAge() + "");
                phone.setText(arrayList.get(position).getPhone() + "");
                des.setText(arrayList.get(position).getDes() + "");

                dialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class PatientViewHolder extends RecyclerView.ViewHolder {
        TextView index,fullname ;
        AppCompatButton showCard ;
        public PatientViewHolder(@NonNull View itemView) {
            super(itemView);
            index = itemView.findViewById(R.id.index);
            fullname = itemView.findViewById(R.id.patient_fullName);
            showCard = itemView.findViewById(R.id.show_card);
        }
    }
}
