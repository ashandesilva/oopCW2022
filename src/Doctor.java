public class Doctor extends Person{
    private int medicalLicenseNo;
    private String special;

    public Doctor(String name,String surname,String dob,int mobileNo,int medicalLicenseNo, String special) {
        this.setName(name);
        this.setSurname(surname);
        this.setDob(dob);
        this.setMobileNo(mobileNo);
        this.medicalLicenseNo = medicalLicenseNo;
        this.special = special;
    }

    public int getMedicalLicenseNo() {
        return medicalLicenseNo;
    }

    public void setMedicalLicenseNo(int medicalLicenseNo) {
        this.medicalLicenseNo = medicalLicenseNo;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }
}
