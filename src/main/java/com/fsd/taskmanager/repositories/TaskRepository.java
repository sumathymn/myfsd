/**
 * 
 */
package com.fsd.taskmanager.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.fsd.taskmanager.models.Task;

/**
 * @author n0233177
 *
 */
public interface TaskRepository extends CrudRepository<Task, String> {

	@Override
	Iterable<Task> findAll();
	
	@Override
	Optional<Task> findById(String id);

	@Override
	void delete(Task deleted);
	

}
