public class Consultation {
    private String name ;
    private String surname;
    private String dob;
    private int mobileNo;
    private double cost;
    private String bookingDate ;
    private String ConsultantName ;

    public Consultation(String name, String surname, String dob, int mobileNo, double cost, String bookingDate, String consultantName) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.mobileNo = mobileNo;
        this.cost = cost;
        this.bookingDate = bookingDate;
        ConsultantName = consultantName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getConsultantName() {
        return ConsultantName;
    }

    public void setConsultantName(String consultantName) {
        ConsultantName = consultantName;
    }
}
