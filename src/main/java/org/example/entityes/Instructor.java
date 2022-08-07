package org.example.entityes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructors")
@Setter
@Getter
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "phone_number", unique = true, length = 55)
    private int phoneNumber;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable
    private List<Course> courseList = new ArrayList<>();

    public Instructor(String firstName, String lastName, String email, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void addCourse(Course course) {
        this.courseList.add(course);
    }

    @Override
    public String toString() {
        return "Instructor: " +
                "id: " + id +
                " firstName: " + firstName +
                " lastName: " + lastName +
                " email: " + email +
                " phoneNumber: " + phoneNumber;
    }
}
