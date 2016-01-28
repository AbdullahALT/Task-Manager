import java.util.InputMismatchException;

public class Query {
	public static String atid(String ID) {
		try {
			int id = Integer.parseInt(ID);
			Task task = new Task(id);
			return TaskManager.TASKS.insert(id, task) ? "Success" : "Fail";
		} catch (NumberFormatException e) {
			return "Fail";
		}

	}

	public static String agid(String ID) {
		try {
			int id = Integer.parseInt(ID);
			Group task = new Group(id);
			return TaskManager.GROUPS.insert(id, task) ? "Success" : "Fail";
		} catch (NumberFormatException e) {
			return "Fail";
		}
	}

	public static String rtid(String ID) {
		try {
			int id = Integer.parseInt(ID);
			return TaskManager.TASKS.remove_key(id) ? "Success" : "Fail";

		} catch (NumberFormatException e) {
			return "Fail";
		}
	}

	public static String rgid(String ID) {
		try {
			int id = Integer.parseInt(ID);
			return TaskManager.GROUPS.remove_key(id) ? "Success" : "Fail";

		} catch (NumberFormatException e) {
			return "Fail";
		}
	}

	public static String otid(String ID) {
		try {
			if (TaskManager.CURRENT_TASK == null) {
				int id = Integer.parseInt(ID);
				if (TaskManager.TASKS.findkey(id)) {
					TaskManager.CURRENT_TASK = TaskManager.TASKS.retrieve();
					return "Success";
				} else
					return "Fail";
			}
			return "Fail";
		} catch (NumberFormatException e) {
			return "Fail";
		}
	}

	public static String ogid(String ID) {
		try {
			if (TaskManager.CURRENT_GROUP == null) {
				int id = Integer.parseInt(ID);
				if (TaskManager.GROUPS.findkey(id)) {
					TaskManager.CURRENT_GROUP = TaskManager.GROUPS.retrieve();
					return "Success";
				} else
					return "Fail";
			}
			return "Fail";
		} catch (NumberFormatException e) {
			return "Fail";
		}
	}

	public static String apid(String ID) {

		try {
			int id = Integer.parseInt(ID);
			Project task = new Project(id);
			return TaskManager.PROJECTS.insert(id, task) ? "Success" : "Fail";
		} catch (NumberFormatException e) {
			return "Fail";
		}

	}

	public static String rpid(String ID) {
		try {
			int id = Integer.parseInt(ID);
			return TaskManager.PROJECTS.remove_key(id) ? "Success" : "Fail";

		} catch (NumberFormatException e) {
			return "Fail";
		}
	}

	public static String opid(String ID) {
		try {
			if (TaskManager.CURRENT_PROJECT == null) {
				int id = Integer.parseInt(ID);
				if (TaskManager.PROJECTS.findkey(id)) {
					TaskManager.CURRENT_PROJECT = TaskManager.PROJECTS
							.retrieve();
					return "Success";
				} else
					return "Fail";
			}
			return "Fail";
		} catch (NumberFormatException e) {
			return "Fail";
		}
	}
	
	public static String ntid(String ID){
		int id = Integer.parseInt(ID);
		return Integer.toString(count(TaskManager.TASKS.root, id));
	}
	
	public static String ngid(String ID){
		int id = Integer.parseInt(ID);
		return Integer.toString(count(TaskManager.GROUPS.root, id));
	}
	
	public static String npid(String ID){
		int id = Integer.parseInt(ID);
		return Integer.toString(count(TaskManager.PROJECTS.root, id));
	}
		
	private static<T> int count(BSTNode<T> node, int ID){
		
		if(node == null)
			return 0;
		if(node.key == ID)
			return 1;
		if(node.key > ID)
			return count(node.right , ID) + 1;
		else
			return count(node.left, ID) + 1;
	}

	public static String gexx(String xx) {
		try {
			switch (xx) {
			case "TI":
				return "" + TaskManager.CURRENT_TASK.getID();
			case "TT":
				return TaskManager.CURRENT_TASK.getTitle();
			case "TD":
				return TaskManager.CURRENT_TASK.getDescription();
			case "TS":
				return TaskManager.CURRENT_TASK.getStatus();
			case "TP":
				return "" + TaskManager.CURRENT_TASK.getPriority();
			case "TU":
				return TaskManager.CURRENT_TASK.getDate();

			case "GI":
				return "" + TaskManager.CURRENT_GROUP.getID();
			case "GT":
				return TaskManager.CURRENT_GROUP.getTitle();
			case "GD":
				return TaskManager.CURRENT_GROUP.getDescription();
			case "GE":
				return TaskManager.CURRENT_GROUP.getTasks();
			case "PI":
				return "" + TaskManager.CURRENT_PROJECT.getID();
			case "PT":
				return TaskManager.CURRENT_PROJECT.getTitle();
			case "PD":
				return TaskManager.CURRENT_PROJECT.getDescription();
			case "PP":
				return TaskManager.CURRENT_PROJECT.getTasks();
			case "PY":
				return TaskManager.CURRENT_PROJECT.getDependincies();
			default:
				return "Fail";

			}
		} catch (NumberFormatException e) {
			return "Fail";
		} catch (NullPointerException e) {
			return "Fail";
		}
	}

	public static String sexx(String xx, String val) {
		try {
			switch (xx) {
			case "TT":
				TaskManager.CURRENT_TASK.setTitle(val);
				break;
			case "TD":
				TaskManager.CURRENT_TASK.setDescription(val);
				break;
			case "TS":
				if (val.equals("None"))
					return "Fail";
				TaskManager.CURRENT_TASK.setStatus(val);
				break;
			case "TP":
				TaskManager.CURRENT_TASK.setPriority(val.equals("None") ? 1
						: Integer.parseInt(val));
				break;
			case "TU":
				TaskManager.CURRENT_TASK.setDate(val);
				break;
			case "GT":
				TaskManager.CURRENT_GROUP.setTitle(val);
				break;
			case "GD":
				TaskManager.CURRENT_GROUP.setDescription(val);
				break;
			case "GE":
				if (val.equals("None"))
					TaskManager.CURRENT_GROUP.setTasks(new List<Task>());
				else {
					String[] str = val.split("-");
					List<Task> tmp = new List<Task>();

					for (int i = 0; i < str.length; i++) {
						Task node = search(Integer.parseInt(str[i]),
								TaskManager.TASKS);
						if (node == null)
							return "Fail";
						tmp.insert(node);
					}

					if (tmp.length() == 0)
						return "Fail";
					else
						TaskManager.CURRENT_GROUP.setTasks(tmp);
				}
				break;
			case "PT":
				TaskManager.CURRENT_PROJECT.setTitle(val);
				break;
			case "PD":
				TaskManager.CURRENT_PROJECT.setDescription(val);
				break;
			case "PP":
				if (val.equals("None"))
					TaskManager.CURRENT_PROJECT.setTasks(new List<Task>());
				else {
					String[] str = val.split("-");
					List<Task> tmp = new List<Task>();

					for (int i = 0; i < str.length; i++) {
						Task node = search(Integer.parseInt(str[i]),
								TaskManager.TASKS);
						if (node == null)
							return "Fail";
						tmp.insert(node);
					}
					if (tmp.length() == 0)
						return "Fail";
					else
						TaskManager.CURRENT_PROJECT.setTasks(tmp);
				}
				break;
			case "PY":
				if (val.equals("None"))
					TaskManager.CURRENT_PROJECT.setDependency(new List<Task>());
				else {
					String[] str = val.split("-");
					Queue<String> qu = new Queue<String>();
					for (int i = 0; i < str.length; i++)
						qu.enqueue(str[i]);
					if (!TaskManager.CURRENT_PROJECT.depend(qu))
						return "Fail";
				}
				break;
			default:
				return "Fail";

			}
			return "Success";
		} catch (NumberFormatException e) {
			return "Fail";
		} catch (InputMismatchException e) {
			return "Fail";
		} catch (NullPointerException e) {
			return "Fail";
		} catch (StringIndexOutOfBoundsException e) {
			return "Fail";
		}
	}

	public static int taskReader(String[] file, int currentLine, BST<Task> tasks) {
		try {
			Task task = new Task();
			boolean require1 = false, require2 = false;
			int line = currentLine + 1;
			while (!file[line].equals("ET")) {

				if (!(file[line].indexOf("-") == -1)) {
					String[] switcher = file[line].split(" - ");
					switch (switcher[0]) {
					case "TI":
						require2 = true;
						task.setID(Integer.parseInt(switcher[1]));
						break;
					case "TT":
						task.setTitle(switcher[1]);
						break;
					case "TD":
						task.setDescription(switcher[1]);
						break;
					case "TS":
						require1 = true;
						task.setStatus(switcher[1]);
						break;
					case "TP":
						task.setPriority(Integer.parseInt(switcher[1]));
						break;
					case "TU":
						task.setDate(switcher[1]);
						break;
					default:
						if (!switcher[1].equals(""))
							return -1;
					}
				}
				line++;
			}
			if (!require1 || !require2)
				return -1;
			tasks.insert(task.getID(), task);
			return line;
		} catch (NullPointerException e) {
			return -1;
		} catch (NumberFormatException e) {
			return -1;
		} catch (InputMismatchException e) {
			return -1;
		}
	}

	public static int groupReader(String[] file, int currentLine,
			BST<Group> goups, BST<Task> tasks) {
		try {
			Group group = new Group();
			boolean require = false;
			int line = currentLine + 1;

			while (!file[line].equals("EG")) {

				if (!(file[line].indexOf("-") == -1)) {
					String[] switcher = file[line].split(" - ");
					switch (switcher[0]) {
					case "GI":
						require = true;
						group.setID(Integer.parseInt(switcher[1]));
						break;
					case "GT":
						group.setTitle(switcher[1]);
						break;
					case "GD":
						group.setDescription(switcher[1]);
						break;
					case "GE":
						// The Task should be already exist
						Task target = search(Integer.parseInt(switcher[1]),
								tasks);
						if (target == null)
							return -1;
						group.addTask(target);
						break;
					default:
						if (!switcher[0].equals("")) {
							return -1;
						}
					}
				}
				line++;
			}
			if (!require)
				return -1;
			goups.insert(group.getID(), group);
			return line;
		} catch (NullPointerException e) {
			return -1;
		} catch (NumberFormatException e) {
			return -1;
		} catch (Exception e) {
			return -1;
		}
	}

	public static int projectReader(String[] file, int currentLine,
			BST<Project> projects, BST<Task> tasks) {
		try {
			Project project = new Project();
			boolean require = false;
			Queue<String> dependency = new Queue<String>();
			int line = currentLine + 1;

			while (!file[line].equals("EP")) {

				if (!(file[line].indexOf("-") == -1)) {
					String[] switcher = file[line].split(" - ");
					switch (switcher[0]) {
					case "PI":
						require = true;
						project.setID(Integer.parseInt(switcher[1]));
						break;
					case "PT":
						project.setTitle(switcher[1]);
						break;
					case "PD":
						project.setDescription(switcher[1]);
						break;
					case "PP":
						int id = Integer.parseInt(switcher[1]);
						Task target = search(id, tasks);
						if (target == null)
							return -1;
						project.addTask(target);
						break;
					case "PY":
						
						dependency.enqueue(switcher[1]);
						break;
					default:
						if (!switcher[0].equals("")) {

							return -1;
						}
					}
				}
				line++;
			}
			if (!require)
				return -1;
			if (project.depend(dependency)) {
				projects.insert(project.getID(), project);
				return line;
			} else
				return -1;

		} catch (NullPointerException e) {
			return -1;
		} catch (NumberFormatException e) {
			return -1;
		} catch (Exception e) {
			return -1;
		}
	}

	public static int jump(String[] file, int currentLine, String endTag) {
		int line = currentLine + 1;
		while (!file[line].equals(endTag)) {
			line++;
		}
		return line;
	}

	private static Task search(int id, BST<Task> tasks) {
		if (tasks.findkey(id))
			return tasks.retrieve();
		else
			return null;
	}

}
