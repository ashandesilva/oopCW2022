public class Doctor extends Person{
    private String medicalLicenseNo;
    private String special;

    public Doctor(String name,String surname,String dob,String mobileNo,String medicalLicenseNo, String special) {
        this.setName(name);
        this.setSurname(surname);
        this.setDob(dob);
        this.setMobileNo(mobileNo);
        this.medicalLicenseNo = medicalLicenseNo;
        this.special = special;
    }

    public String getMedicalLicenseNo() {
        return medicalLicenseNo;
    }

    public void setMedicalLicenseNo(String medicalLicenseNo) {
        this.medicalLicenseNo = medicalLicenseNo;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }
}
