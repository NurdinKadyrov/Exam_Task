package org.example.entityes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "lesson_name")
    private String lessonName;
    @Column(name = "video_link")
    private String videoLink;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "lesson")
    private List<Task> taskList = new ArrayList<>();

    public Lesson(String lessonName, String videoLink) {
        this.lessonName = lessonName;
        this.videoLink = videoLink;
    }

    public void addTask(Task task) {
        this.taskList.add(task);
    }

    @Override
    public String toString() {
        return "Lesson: " +
                "id: " + id +
                " lessonName: " + lessonName +
                " videoLink: " + videoLink;
    }
}
