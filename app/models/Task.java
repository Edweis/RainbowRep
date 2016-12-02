package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.avaje.ebean.Model;

@Entity
public class Task extends Model {

	@Id
	public Long id;
	public String title;
	public boolean done = false;
	public Date dueDate;
	@ManyToOne
	public User assignedTo;
	public String folder;
	@ManyToOne
	public Project project;

	public static Model.Finder<Long, Task> find = new Model.Finder<Long, Task>(Task.class);

	public static List<Task> findTodoInvolving(String user) {
		return find.fetch("project").where().eq("done", false).eq("project.members.email", user).findList();
	}

	public static Task create(Task task, Long project, String folder) {
		task.project = Project.find.ref(project);
		task.folder = folder;
		task.save();
		return task;
	}
}