/**
 * 
 */
package com.fsd.taskmanager.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author n0233177
 *
 */
@Document(collection = "Task")
public class Task {
	
	 	@Id
	    String id;
	 	String taskId;
	    String parentId;
	    String taskName;
	    String startDate;
	    String endDate;
	    String priority;
	    boolean isCompleted;
	    
	    public Task()
	    {
	    	
	    }
		/**
		 * @param id
		 * @param taskId
		 * @param parentId
		 * @param taskName
		 * @param startDate
		 * @param endDate
		 * @param priority
		 * @param isCompleted
		 */
		public Task(String taskId, String parentId, String taskName, String startDate, String endDate,
				String priority, boolean isCompleted) {
			
			
			this.taskId = taskId;
			this.parentId = parentId;
			this.taskName = taskName;
			this.startDate = startDate;
			this.endDate = endDate;
			this.priority = priority;
			this.isCompleted = isCompleted;
		}
		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * @return the taskId
		 */
		public String getTaskId() {
			return taskId;
		}
		/**
		 * @param taskId the taskId to set
		 */
		public void setTaskId(String taskId) {
			this.taskId = taskId;
		}
		/**
		 * @return the parentId
		 */
		public String getParentId() {
			return parentId;
		}
		/**
		 * @param parentId the parentId to set
		 */
		public void setParentId(String parentId) {
			this.parentId = parentId;
		}
		/**
		 * @return the taskName
		 */
		public String getTaskName() {
			return taskName;
		}
		/**
		 * @param taskName the taskName to set
		 */
		public void setTaskName(String taskName) {
			this.taskName = taskName;
		}
		
		
		/**
		 * @return the startDate
		 */
		public String getStartDate() {
			return startDate;
		}
		/**
		 * @param startDate the startDate to set
		 */
		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
		/**
		 * @return the endDate
		 */
		public String getEndDate() {
			return endDate;
		}
		/**
		 * @param endDate the endDate to set
		 */
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		/**
		 * @return the priority
		 */
		public String getPriority() {
			return priority;
		}
		/**
		 * @param priority the priority to set
		 */
		public void setPriority(String priority) {
			this.priority = priority;
		}
		/**
		 * @return the isCompleted
		 */
		public boolean isCompleted() {
			return isCompleted;
		}
		/**
		 * @param isCompleted the isCompleted to set
		 */
		public void setCompleted(boolean isCompleted) {
			this.isCompleted = isCompleted;
		}
		
	    
	    
	  

}
