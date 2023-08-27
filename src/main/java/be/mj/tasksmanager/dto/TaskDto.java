package be.mj.tasksmanager.dto;

import be.mj.tasksmanager.model.TaskStatus;
import be.mj.tasksmanager.model.TaskUser;

import java.util.Date;

public class TaskDto
{
    private Long id;
    private String name;
    private String description;
    private Date creationDate;
    private Date dueDate;
    private boolean isProfessional;
    private TaskStatus status;


    public TaskDto() {
    }

    public TaskDto(Long id, String name, String description,
                Date creationDate, Date dueDate,
                boolean isProfessional, TaskStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.isProfessional = isProfessional;
        this.status = status;
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
}
