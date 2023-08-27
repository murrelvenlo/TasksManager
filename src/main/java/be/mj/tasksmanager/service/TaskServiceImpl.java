package be.mj.tasksmanager.service;

import be.mj.tasksmanager.dto.TaskDto;
import be.mj.tasksmanager.exception.TaskAlreadyExistsException;
import be.mj.tasksmanager.model.Task;
import be.mj.tasksmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService
{
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void createTask(TaskDto taskDto) {
        if (taskExists(taskDto.getId()))
        {
            throw new TaskAlreadyExistsException("Task with ID " + taskDto.getId() + " already exists.");
        }

        Task task = new Task();
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setCreationDate(taskDto.getCreationDate());
        task.setDueDate(taskDto.getDueDate());

        // Set isProfessional attribute based on TaskDto's isProfessional value
        task.setProfessional(taskDto.isProfessional());

        // Set status attribute based on TaskDto's status value
        task.setStatus(taskDto.getStatus());

        taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Long taskId, Task updatedTask) {
        return null;
    }

    @Override
    public void deleteTask(Long taskId) {

    }

    @Override
    public boolean taskExists(Long taskId) {
        return taskRepository.existsById(taskId);
    }
}
