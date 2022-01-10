package day13.addressbook.data;

import java.util.Random;

public class ContactDetails {
    private String name;
    private String email;
    private String phone;
    private String id;

    public ContactDetails(){
        this.id = this.generateId(8);
}

public ContactDetails(String name, String email, String phone){
        this.id = this.generateId(8);
        this.name = name;
        this.email = email;
        this.phone = phone;
}
    
    
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private synchronized String generateId(int numchars){
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < numchars){
                sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, numchars);
}

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", phone='" + getPhone() + "'" +
            "}";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
