import java.util.InputMismatchException;

public class Task {
	private int id;
	private String title;
	private String description;
	private String status;
	private int priority;
	private String date;

	public Task(int iD) {
		id = iD;
		this.title = "";
		this.description = "";
		this.status = "Future";
		this.priority = 1;
		this.date = "";
	}
	
	public Task(){
		id = 0;
		this.title = "";
		this.description = "";
		this.status = "Future";
		this.priority = 1;
		this.date = "";
	}

	public String getDescription() {
		return description.equals("") ? "None" : description;
	}

	public void setDescription(String description) {
		if (description.equals("None"))
			this.description = "";
		else
			this.description = description;
	}

	public String getTitle() {
		return title.equals("") ? "None" : title;
	}

	public void setTitle(String title) {
		if (title.equals("None"))
			this.title = "";
		else
			this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) throws InputMismatchException {
		if (status.equals("Future") || status.equals("InProgress")
				|| status.equals("Done"))
			this.status = status;
		else
			throw new InputMismatchException();
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) throws InputMismatchException {
		if (priority > 3 || priority < 1)
			throw new InputMismatchException();
		this.priority = priority;
	}

	public String getDate() {
		return date.equals("") ? "None" : date;
	}

	public void setDate(String date) throws InputMismatchException {
		try {
			if (date.equals("None"))
				this.date = "";
			else {
				String arg[] = date.split("/");

				if (arg.length == 3 && Integer.parseInt(arg[0]) > 0
						&& Integer.parseInt(arg[0]) <= 31
						&& Integer.parseInt(arg[1]) > 0
						&& Integer.parseInt(arg[1]) <= 12
						&& Integer.parseInt(arg[2]) > 0)
					this.date = date;
				else
					throw new InputMismatchException();
			}
		} catch (NumberFormatException e) {
			throw new InputMismatchException();
		}
	}

	public int getID() {
		return id;
	}
	
	public void setID(int ID){
		id = ID;
	}
}
