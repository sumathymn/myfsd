/**
 * 
 */
package com.fsd.taskmanager.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.taskmanager.models.Task;
import com.fsd.taskmanager.repositories.TaskRepository;

/**
 * @author n0233177
 *
 */
@Service
public class TaskManagerService {
	@Autowired
	TaskRepository taskRepository;

	

	public Iterable<Task> getAllTask() {
		return taskRepository.findAll();
	}

	public Task saveTask(Task task) {
		task.setCompleted(false);
		taskRepository.save(task);

		return task;
	}

	public Optional<Task> getTaskById(@PathVariable String id) {
		return taskRepository.findById(id);
	}

	public Task updateTask(String id, Task task) {
		Task myTask = taskRepository.findById(id).orElse(null);
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

		taskRepository.save(myTask);
		return myTask;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/tasksEndDate/{id}")
	public Task updateTaskEndDate(@PathVariable String id, @RequestBody Task task) {
		Task myTask = taskRepository.findById(id).orElse(null);
		
		myTask.setCompleted(true);
		taskRepository.save(myTask);
		return myTask;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/tasks/{id}")
	public String delete(@PathVariable String id) {
		Task task = taskRepository.findById(id).orElse(null);
		taskRepository.delete(task);

		return "";
	}

}
