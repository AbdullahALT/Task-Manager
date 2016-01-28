public class TestRun {
	public static void main(String[] args) {
		TaskManager manager = new TaskManager();
		long start, end, time = 0;

		// Change the test run file for each test (run01.txt-run05.txt)
		boolean success = manager.load("C:/Users/abo_tam/Desktop/Phase-2-TestRun/run02.txt");

		// DO NOT change anything after this line
		if(success) {
			start = System.nanoTime();
			manager.query("OT 500000");
			manager.query("CT");
			end = System.nanoTime();
			time += end - start;

			start = System.nanoTime();
			manager.query("OT 500001");
			manager.query("CT");
			end = System.nanoTime();
			time += end - start;

			start = System.nanoTime();
			manager.query("OT 500002");
			manager.query("CT");
			end = System.nanoTime();
			time += end - start;

			start = System.nanoTime();
			manager.query("OT 500003");
			manager.query("CT");
			end = System.nanoTime();
			time += end - start;

			time = time / 4;

			System.out.println("Average execution time (nanoseconds): " + time + "ns");
		}
		else {
			System.out.println("Error loading the file. There is a problem with your implementation");
		}
	}
}
