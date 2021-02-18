package serive.algeria.chifacomapp.doctors;

public class DoctorItem {
    private int doctorImg;
    private String fullname;
    private String speciality;


    public DoctorItem(int doctorImg1,String fullname1,String speciality1){

        doctorImg = doctorImg1;
        fullname = fullname1;
        speciality = speciality1;
    }


    public int getDoctorImg() {
        return doctorImg;
    }

    public String getFullname() {
        return fullname;
    }

    public String getSpeciality() {
        return speciality;
    }
}
