package be.mj.tasksmanager.service;

import be.mj.tasksmanager.dto.TaskDto;
import be.mj.tasksmanager.model.Task;

import java.util.List;

public interface TaskService
{
    Task addTask(Task task);
    void createTask(TaskDto taskDto);

    List<Task> getAllTasks();
    Task updateTask(Long taskId, Task updatedTask);
    void deleteTask(Long taskId);
    boolean taskExists(Long taskId);
}
