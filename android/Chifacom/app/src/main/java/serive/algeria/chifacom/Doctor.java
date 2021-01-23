package serive.algeria.chifacom;

public class Doctor {
    private int id;
    private String first_name, last_name;
    private String speciality;

    public Doctor(int id, String first_name, String last_name, String speciality) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.speciality = speciality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
