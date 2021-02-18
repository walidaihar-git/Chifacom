package serive.algeria.chifacomapp.doctors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import serive.algeria.chifacomapp.R;

public class DoctorAdapter  extends RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder> {
    private ArrayList<DoctorItem> mdoctorItems;

    public static class DoctorViewHolder extends  RecyclerView.ViewHolder {
         public ImageView imageView;
         public TextView fullname,speciality;

        public DoctorViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.doctorPicture);
            fullname = itemView.findViewById(R.id.doctorFullname);
            speciality = itemView.findViewById(R.id.doctorSpeciality);

        }
    }

    public DoctorAdapter (ArrayList<DoctorItem> doctorItems){
mdoctorItems = doctorItems;
    }

    @NonNull
    @Override
    public DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_item,parent,false);
        return new DoctorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorViewHolder holder, int position) {

        DoctorItem  currentItem = mdoctorItems.get(position);
        holder.imageView.setImageResource(currentItem.getDoctorImg());
        holder.fullname.setText(currentItem.getFullname());
        holder.speciality.setText(currentItem.getSpeciality());
    }

    @Override
    public int getItemCount() {
        return mdoctorItems.size();
    }
}
