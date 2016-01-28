import java.io.IOException;

public class TaskManager {
	public static BST<Group> GROUPS;
	public static BST<Task> TASKS;
	public static BST<Project> PROJECTS;
	public static Task CURRENT_TASK;
	public static Group CURRENT_GROUP;
	public static Project CURRENT_PROJECT;

	public TaskManager() {
		GROUPS = new BST<Group>();
		TASKS = new BST<Task>();
		PROJECTS = new BST<Project>();
		CURRENT_TASK = null;
		CURRENT_GROUP = null;
		CURRENT_PROJECT = null;
	}

	public String query(String command) {

		try {

			String[] switcher = command.split(" ", 2);
			switch (switcher[0]) {
			
			case "AT":
				return Query.atid(switcher[1]);
			case "AG":
				return Query.agid(switcher[1]);
			case "AP":
				return Query.apid(switcher[1]);
			case "RT":
				return Query.rtid(switcher[1]);
			case "RG":
				return Query.rgid(switcher[1]);
			case "RP":
				return Query.rpid(switcher[1]);
			case "PY":
				return CURRENT_PROJECT.status();
			case "OT":
				return Query.otid(switcher[1]);
			case "CT":
				if (CURRENT_TASK == null)
					return "Fail";
				CURRENT_TASK = null;
				return "Success";
			case "OG":
				return Query.ogid(switcher[1]);
			case "CG":
				if (CURRENT_GROUP == null)
					return "Fail";
				CURRENT_GROUP = null;
				return "Success";
			case "OP":
				return Query.opid(switcher[1]);
			case "CP":
				if (CURRENT_PROJECT == null)
					return "Fail";
				CURRENT_PROJECT = null;
				return "Success";
			case "PS":
				if (CURRENT_PROJECT == null)
					return "Fail";
				return CURRENT_PROJECT.status();
			case "NT":
				 return Query.ntid(switcher[1]);
			case "NG":
				 return Query.ngid(switcher[1]);
			case "NP":
				 return Query.npid(switcher[1]);
			case "GE":
				return Query.gexx(switcher[1]);
			case "SE":

				String[] str = switcher[1].split(" ", 2);

				return Query.sexx(str[0], str[1]);
			default:
				return "Fail";
			}
		} catch (Exception e) {
			return "Fail";
		}

	}

	public boolean load(String fileName) {
		try {
			
			ReadFile file = new ReadFile(fileName);
			String[] line = file.openFile();
			 
			BST<Group> groups = new BST<Group>();
			BST<Task> tasks = new BST<Task>();
			BST<Project> projects = new BST<Project>();

			for (int i = 0; i < line.length; i++) {
				switch (line[i]) {
				case "ST":
					i = Query.taskReader(line, i, tasks);

					break;
				case "SG":
					i = Query.jump(line, i, "EG");
					break;
				case "SP":
					i = Query.jump(line, i, "EP");
					break;
				default:
					if (!line[i].equals(""))
						return false;
				}
				if (i == -1) {
					return false;
				}
			}
			for (int i = 0; i < line.length; i++) {
				switch (line[i]) {
				case "ST":
					i = Query.jump(line, i, "ET");
					break;
				case "SG":
					i = Query.groupReader(line, i, groups, tasks);
					break;
				case "SP":
					i = Query.projectReader(line, i, projects, tasks);
					break;
				default:
					if (!line[i].equals(""))
						return false;
				}
				if (i == -1) {
					return false;
				}
			}
			PROJECTS = projects;
			GROUPS = groups;
			TASKS = tasks;
			
			CURRENT_GROUP = null;
			CURRENT_PROJECT = null;
			CURRENT_TASK = null;
			return true;
		} catch (IOException e) {
			return false;
		} catch (Exception e) {
			return false;
		}

	}
}