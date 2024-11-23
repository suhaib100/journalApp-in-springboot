package com.journalapp.journalApp.controller;

import com.journalapp.journalApp.model.Task;
import com.journalapp.journalApp.service.TaskService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task){
        return taskService.addTask(task);
    }


@GetMapping
    public List<Task> getTasks(){
        return taskService.findAllTasks();
    }



@GetMapping("/{taskId}")
    public Task getTask(@PathVariable String taskId){
        return taskService.getTaskByTaskId(taskId);
    }

    @GetMapping("/severity/{severity}")
    public List<Task> findTaskUsingSeverity(@PathVariable int severity){
        return taskService.getTaskBySeverity(severity);
    }


    @GetMapping("/assignee/{assignee}")
    public List<Task> getTaskByAssignee(@PathVariable String assignee){
        return  taskService.getTaskByAssignee(assignee);
    }


    @PutMapping
    public Task modifyTask(@RequestBody Task task){
        return taskService.updateTask(task);
    }

@DeleteMapping("/{taskId}")
public String deleteTask(@PathVariable String taskId){
        return taskService.deleteTask(taskId);
}
}
