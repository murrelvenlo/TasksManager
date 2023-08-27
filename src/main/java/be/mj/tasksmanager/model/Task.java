package be.mj.tasksmanager.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
//    @Lob annotation to represent the description
//    as a large object (CLOB) in the database.
//    This is suitable for longer pieces of text.
    @Lob
    private String description;
    private Date creationDate;
    private Date dueDate;
    private boolean isProfessional;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @ManyToOne
    private TaskUser taskUser;

    public Task() {
    }

    public Task(Long id, String name, String description,
                Date creationDate, Date dueDate,
                boolean isProfessional, TaskStatus status,
                TaskUser taskUser) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.isProfessional = isProfessional;
        this.status = status;
        this.taskUser = taskUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isProfessional() {
        return isProfessional;
    }

    public void setProfessional(boolean professional) {
        isProfessional = professional;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskUser getTaskUser() {
        return taskUser;
    }

    public void setTaskUser(TaskUser taskUser) {
        this.taskUser = taskUser;
    }
}
