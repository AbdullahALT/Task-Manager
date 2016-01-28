public class Group {
	private String title;
	private String description;
	/* all search operation occurs on TaskManager static attributes.
	 * and all the operation of group's tasks and project's tasks 
	 * go through all the tasks, so there is no point of changing the structure of group's tasks
	 * and project's task's
	 */
	private List<Task> tasks;
	private int id;

	public Group(int iD) {
		this.id = iD;
		tasks = new List<Task>();
		this.title = "";
		this.description = "";
	}
	
	public Group() {
		this.id = 0;
		tasks = new List<Task>();
		this.title = "";
		this.description = "";
	}

	public void addTask(Task task) throws Exception {
		if (!tasks.empty()) {
			tasks.findfirst();
			while (!tasks.last()) {
				if (task.getID() == tasks.retrieve().getID())
					throw new Exception();
				tasks.findnext();
			}
			if (task.getID() == tasks.retrieve().getID())
				throw new Exception();
		}
		tasks.insert(task);
	}

	public String getTitle() {
		return title.equals("") ? "None" : title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description.equals("") ? "None" : description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTasks() {
		if (!tasks.empty()) {
			String result = "";

			tasks.findfirst();
			while (!tasks.last()) {
				result = result + tasks.retrieve().getID() + "-";
				tasks.findnext();
			}
			result = result + tasks.retrieve().getID();

			return result;
		} else {
			return "None";
		}
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public int getID() {
		return id;
	}

	public boolean tasksFull() {
		return tasks.full();
	}

	public List<Task> Tasks() {
		return tasks;
	}
	
	public void setID(int ID){
		id = ID;
	}

}
