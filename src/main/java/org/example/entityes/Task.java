package org.example.entityes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "task_name")
    private String taskName;
    private LocalDate deadline;
    private String task;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private Lesson lesson;

    public Task(String taskName, LocalDate deadline, String task) {
        this.taskName = taskName;
        this.deadline = deadline;
        this.task = task;
    }

    @Override
    public String toString() {
        return "Task: " +
                "id: " + id +
                " taskName: " + taskName +
                " deadline: " + deadline +
                " task: " + task;
    }
}
