import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		System.out.println("\t\tMy Task Manager");
		TaskManager tm = new TaskManager();
		System.out.println(tm
				.load("C:/Users/⁄»œ«··Â/Desktop/pro/test/test01.txt"));
		Scanner scan = new Scanner(System.in);
		System.out.println("Tasks [" + TaskManager.TASKS.empty() + "]");
		System.out.println("Groups [" + TaskManager.GROUPS.empty() + "]");
		System.out.println("Projects [" + TaskManager.PROJECTS.empty() + "]");
		do {
			System.out
					.print("Enter Q for Query, L for Load: ");
			switch (scan.nextLine()) {
			case "Q":
			case "q":
					System.out.print("Cmmand: ");
					String s = scan.nextLine();
					System.out.println(tm.query(s));
				break;
			case "L":
			case "l":
				System.out.print("Path: ");
				System.out.println(tm.load(scan.nextLine()));
				break;
			}
		} while (true);

	}

}
