/**
 * 
 */
package com.fsd.taskmanager.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.taskmanager.models.Task;
import com.fsd.taskmanager.services.TaskManagerService;

/**
 * @author n0233177
 *
 */
@RestController
public class TaskManagerController {
	@Autowired
	TaskManagerService taskManagerService;

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "hi";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/tasks")
	public Iterable<Task> getAllTask() {
		return taskManagerService.getAllTask();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/tasks")
	public Task save(@RequestBody Task task) {
		task.setCompleted(false);
		taskManagerService.saveTask(task);

		return task;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/tasks/{id}")
	public Optional<Task> getById(@PathVariable String id) {
		return taskManagerService.getTaskById(id);
	}

	
	
	@RequestMapping(method = RequestMethod.PUT, value = "/tasks/{id}")
	public Task updateTask(@PathVariable String id, @RequestBody Task task) {
		Task myTask = taskManagerService.getTaskById(id).orElse(null);
		if (task.getTaskId() != null)
			myTask.setTaskId(task.getTaskId());
		if (task.getParentId() != null)
			myTask.setParentId(task.getParentId());
		if (task.getTaskName() != null)
			myTask.setTaskName(task.getTaskName());
		if (task.getStartDate() != null)
			myTask.setStartDate(task.getStartDate());
		if (task.getEndDate() != null)
			myTask.setEndDate(task.getEndDate());
		if (task.getPriority() != null)
			myTask.setPriority(task.getPriority());
		if (task.isCompleted())
			myTask.setCompleted(task.isCompleted());

		taskManagerService.saveTask(myTask);
		return myTask;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/tasksEndDate/{id}")
	public Task updateTaskEndDate(@PathVariable String id, @RequestBody Task task) {
		Task myTask = taskManagerService.getTaskById(id).orElse(null);
		
		myTask.setCompleted(true);
		taskManagerService.saveTask(myTask);
		return myTask;
	}

	/*@RequestMapping(method = RequestMethod.DELETE, value = "/tasks/{id}")
	public String delete(@PathVariable String id) {
		Task task = taskManagerService.getTaskById(id).orElse(null);
		taskManagerService.delete(task);

		return "";
	}*/

}
