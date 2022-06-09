package businesslogiclayer;

public class Reader {
    private String fullName;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String address;
    private String phone;
    private String numberAccount;
    
    public Reader() {}
    
    public Reader(String firstName, String lastName, String patronymic,
            String address, String phone, String numberAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.address = address;
        this.phone = phone;
        this.numberAccount = numberAccount;
    }
    
    public Reader(String fullName, String address, String phone, String numberAccount) {
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.numberAccount = numberAccount;
    }
    
    public String getSurnameAndInitials(String firstName, String lastName, String patronymic) {
        return firstName + " " + lastName.substring(0, 1) + "." + patronymic.substring(0, 1) + ".";
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getPatronymic() {
        return patronymic;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public String getNumberAccount() {
        return numberAccount;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }
}
