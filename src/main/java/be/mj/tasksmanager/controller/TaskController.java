package be.mj.tasksmanager.controller;

import be.mj.tasksmanager.dto.TaskDto;
import be.mj.tasksmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task/api")
public class TaskController
{
    @Autowired
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/add")
//    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<String> createTask(@RequestBody TaskDto taskDto)
    {
        taskService.createTask(taskDto);
        return ResponseEntity.ok("Task created successfully");
    }
}
