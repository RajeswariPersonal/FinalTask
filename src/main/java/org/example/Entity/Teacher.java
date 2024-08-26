package org.example.Entity;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(mappedBy = "teacher")
     private Set<Student> student = new HashSet<>();

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Address> addresses = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Student> getStudent() {
        return student;
    }

    public void setStudent(Set<Student> student) {
        this.student = student;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    private String teacherName;

    private String teacherPhoneNumber;

    public String getTeacherPhoneNumber() {
        return teacherPhoneNumber;
    }

    public void setTeacherPhoneNumber(String teacherPhoneNumber) {
        this.teacherPhoneNumber = teacherPhoneNumber;
    }
}
