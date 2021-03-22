package nz.ac.op.cs.FinalAssignment.Dev.Vora.resources;


import nz.ac.op.cs.FinalAssignment.Dev.Vora.models.Task;

import nz.ac.op.cs.FinalAssignment.Dev.Vora.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public List<Task> getTasks(){
        return taskService.getAllTasks();
    }
    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable Integer id){
        return taskService.getTask(id);
    }

    @PostMapping("/tasks")
    public void addTask(@RequestBody Task task){
        taskService.addTask(task);

    }
    @PutMapping("/tasks")
    public void updateQuizUser(@RequestBody Task task){
        taskService.updateTask(task);
    }
    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Integer id){
        taskService.deleteTask(id);
    }
}
