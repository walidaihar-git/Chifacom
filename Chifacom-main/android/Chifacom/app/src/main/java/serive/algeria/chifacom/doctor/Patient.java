package serive.algeria.chifacom.doctor;

public class Patient {
    private int index;
    private String fullname, age, phone, des;


    public Patient() {
    }

    public Patient(int index, String fullname, String age, String phone, String des) {
        this.index = index;
        this.fullname = fullname;
        this.age = age;
        this.phone = phone;
        this.des = des;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
