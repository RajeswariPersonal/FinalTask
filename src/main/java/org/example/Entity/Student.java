package org.example.Entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    @JoinTable(name = "student_teacher",
    joinColumns = @JoinColumn(name = "studentId"),
    inverseJoinColumns =  @JoinColumn(name="teacherId"))
    private Set<Teacher> teacher = new HashSet<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Address> addresses = new HashSet<>();

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public int getId() {
        return id;
    }

    public Set<Teacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(Set<Teacher> teacher) {
        this.teacher = teacher;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    private String studentName;
}
