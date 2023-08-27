package be.mj.tasksmanager.service;

import be.mj.tasksmanager.model.Task;

import java.util.List;

public interface TaskService
{
    Task createTask(Task task);
    List<Task> getAllTasks();
    Task updateTask(Long id, Task updatedTask);
    void deleteTask(Long id);
}
