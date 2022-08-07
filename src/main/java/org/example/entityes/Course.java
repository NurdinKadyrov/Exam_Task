package org.example.entityes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "course_name")
    private String courseName;
    private String duration;
    private LocalDate creatAt;
    @Column(name = "image_link")
    private String imageLink;
    private String description;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
            , mappedBy = "courseList", fetch = FetchType.EAGER)
    private List<Instructor> instructorList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<Lesson> lessonList = new ArrayList<>();

    public Course(String courseName, String duration, LocalDate creatAt, String imageLink, String description) {
        this.courseName = courseName;
        this.duration = duration;
        this.creatAt = creatAt;
        this.imageLink = imageLink;
        this.description = description;
    }

    public void addInstructor(Instructor instructor) {
        this.instructorList.add(instructor);
    }

    public void addLesson(Lesson lesson) {
        this.lessonList.add(lesson);
    }

    @Override
    public String toString() {
        return "Course: " +
                "id: " + id +
                " courseName: " + courseName +
                " duration: " + duration +
                " creatAt: " + creatAt +
                " imageLink: " + imageLink +
                " description: " + description;
    }
}
