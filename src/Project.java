public class Project {
	private String title;
	private String description;
	
	private List<Task> tasks;
	private List<Task> depend;
	private int id;

	public Project(int id) {
		this.id = id;
		title = "";
		description = "";
		tasks = new List<Task>();
		depend = new List<Task>();
	}

	public Project() {
		this.id = 0;
		title = "";
		description = "";
		tasks = new List<Task>();
		depend = new List<Task>();
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
		depend = new List<Task>();
	}

	public int getID() {
		return id;
	}

	public void setID(int ID) {
		id = ID;
	}

	public boolean tasksFull() {
		return tasks.full();
	}

	public void setDependency(List<Task> depend) {
		this.depend = depend;
	}

	public boolean depend(Queue<String> qu) {
		List<Task> list = new List<Task>();
		
		int iteration = 0;
		
		while (qu.length() != iteration) {
			String dependency = qu.serve();
			
			String[] token = dependency.split(">");

			Task Ti = TaskOf(Integer.parseInt(token[0]));
			Task Tj = TaskOf(Integer.parseInt(token[1]));

			if (Ti == null || Tj == null || Ti.getID() == Tj.getID())
				return false;

			if (!Tj.getStatus().equals("Done")
					&& !Ti.getStatus().equals("Future"))
				return false;
			
			
			if (!list.empty()) {
				list.toLast();
				if (list.retrieve().getID() == Tj.getID()) {
					list.insert(Ti);
					iteration = 0;
				} else {
					list.findfirst();
					if (list.retrieve().getID() == Ti.getID()) {
						Task tmp = list.retrieve();
						list.update(Tj);
						list.insert(tmp);
						iteration = 0;
					} else {
						qu.enqueue(dependency);
						iteration++;
					}
				}
			} else {
				list.insert(Tj);
				list.insert(Ti);
			}
		}
		
		if (qu.length() != 0)
			return false;
		setDependency(list);
		return true;
	}

	public Task TaskOf(int id) {
		if (!tasks.empty()) {
			tasks.findfirst();
			while (!tasks.last()) {
				if (tasks.retrieve().getID() == id)
					return tasks.takeNode().data;
				tasks.findnext();
			}

		}
		if (tasks.retrieve().getID() == id)
			return tasks.takeNode().data;
		else
			return null;
	}

	public String getDependincies() {
		
		if (!depend.empty()) {
			String result = "";

			depend.findfirst();
			while (!depend.last()) {
				Task curr = depend.retrieve();
				depend.findnext();
				Task next = depend.retrieve();
				if (!result.equals(""))
					result = result + "-";
				result = result + next.getID() + ">" + curr.getID();
			}
			return result;
		} else {
			return "None";
		}
	}

	public String status() {
		
		if (!depend.empty()) {
			depend.findfirst();
			switch (depend.retrieve().getStatus()) {
			case "Future":
				return "Future";
			case "InProgress":
				return "InProgress";
			case "Done":
				while (!depend.endList()) {
					if (depend.retrieve().getStatus().equals("InProgress"))
						return "InProgress";
					depend.findnext();
				}
				return "Done";
			}
		}
		return "Fail";
	}

}
