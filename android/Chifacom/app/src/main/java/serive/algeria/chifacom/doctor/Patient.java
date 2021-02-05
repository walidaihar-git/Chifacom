package serive.algeria.chifacom.doctor;

public class Patient {
    private int index;
    private String fullname;

    public Patient() {
    }

    public Patient(int index, String fullname) {
        this.index = index;
        this.fullname = fullname;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
