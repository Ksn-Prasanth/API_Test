package org.codeprism;

public class UserData {
    String email;
    String Location;
    String Phone;
    String nameArr[];

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String[] getNameArr() {
        return nameArr;
    }

    public void setNameArr(String[] nameArr) {
        this.nameArr = nameArr;
    }
}
