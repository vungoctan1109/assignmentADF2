package entity;

import annotation.Table;
import util.DateTimeUtil;

import java.util.Calendar;
import java.util.Date;

@Table(name = "employees")
public class Employee {
    private String name;
    private String address;
    private String email;
    private String username;
    private String password;
    private Date createdAt;
    private Date updatedAt;
    private int status;

    public Employee() {
        this.createdAt = Calendar.getInstance().getTime();
        this.updatedAt = Calendar.getInstance().getTime();
    }

    public Employee(String name, String address, String email, String username, String password, int status) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.username = username;
        this.password = password;
        this.createdAt = Calendar.getInstance().getTime();
        this.updatedAt = Calendar.getInstance().getTime();
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreatedAtString() {
        return DateTimeUtil.formatDateToString(this.createdAt);
    }


    public String getUpdatedAtString() {
        return DateTimeUtil.formatDateToString(this.updatedAt);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", status=" + status +
                '}';
    }

    public String showInfo() {
        return "Your information\n" +
                "---------------------------------\n" +
                "Name: " + name + "\n" +
                "Address: " + address + "\n" +
                "Email: " + email;
    }
}
