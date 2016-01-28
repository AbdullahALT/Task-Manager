public class TestRun1 {
	public static void main(String[] args) {
		TaskManager manager = new TaskManager();
		long start, end, time = 0;
		long MyTime = 0;
		// Change the test run file for each test (run01.txt-run05.txt)
		boolean success = manager
				.load("C:/Users/abo_tam/Desktop/Phase-2-TestRun/run05.txt");

		// DO NOT change anything after this line
		int max = 10000000;
		if (success) {
			for (int i = 1; i <= max; i++) {
				start = System.nanoTime();
				manager.query("OT 500000");
				end = System.nanoTime();
				time += end - start;

				start = System.nanoTime();
				manager.query("OT 500001");
				end = System.nanoTime();
				time += end - start;

				start = System.nanoTime();
				manager.query("OT 500002");
				end = System.nanoTime();
				time += end - start;

				start = System.nanoTime();
				manager.query("OT 500003");
				end = System.nanoTime();
				time += end - start;

				time = time / 4;
				MyTime += time;
			}
				
				long averageTime = MyTime / max;
			System.out.println("Average execution time (nanoseconds): " + averageTime
					+ "ns\nTotal execution time (nanoseconds): " + MyTime + "ns");
			
		} else {
			System.out
					.println("Error loading the file. There is a problem with your implementation");
		}
	}
}
