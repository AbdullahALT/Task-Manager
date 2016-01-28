import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TaskManagerTest {

	protected TaskManager manager;

	@Before
	public void setUp() throws Exception {
		manager = new TaskManager();
	}

	@Test
	public void testLoad_0() {
		assertEquals(
				true,
				manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-0.txt"));
	}

	@Test
	public void testLoad_1() {
		assertEquals(
				true,
				manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-1.txt"));
	}

	@Test
	public void testLoad_2() {
		assertEquals(
				false,
				manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-2.txt"));
	}

	@Test
	public void testLoad_3() {
		assertEquals(
				true,
				manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt"));

	}

	@Test
	public void testQuery_0() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-1.txt");
		assertEquals("Success", manager.query("AT 1021"));
	}

	@Test
	public void testQuery_1() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-1.txt");
		assertEquals("Success", manager.query("RT 1542"));
	}

	@Test
	public void testQuery_2() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-1.txt");
		assertEquals("Success", manager.query("AG 1001"));
	}

	@Test
	public void testQuery_3() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-1.txt");
		assertEquals("Success", manager.query("RG 1426"));
	}

	@Test
	public void testQuery_4() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-1.txt");
		assertEquals("Fail", manager.query("AT 1542"));
	}

	@Test
	public void testQuery_5() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-1.txt");
		assertEquals("Fail", manager.query("RT 1042"));
	}

	@Test
	public void testQuery_6() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-1.txt");
		assertEquals("Fail", manager.query("AG 1426"));
	}

	@Test
	public void testQuery_7() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-1.txt");
		assertEquals("Fail", manager.query("RG 1001"));
	}

	@Test
	public void testQuery_8() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		assertEquals("Success", manager.query("OT 1541"));
	}

	@Test
	public void testQuery_9() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		assertEquals("Success", manager.query("OG 1425"));
	}

	@Test
	public void testQuery_10() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		assertEquals("Fail", manager.query("OT 1741"));
	}

	@Test
	public void testQuery_11() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		assertEquals("Fail", manager.query("OG 1951"));
	}

	@Test
	public void testQuery_12() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		assertEquals("Fail", manager.query("CT"));
	}

	@Test
	public void testQuery_13() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		assertEquals("Fail", manager.query("CG"));
	}

	@Test
	public void testQuery_14() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		manager.query("OT 1142");
		assertEquals("Success", manager.query("CT"));
	}

	@Test
	public void testQuery_15() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		manager.query("OG 1426");
		assertEquals("Success", manager.query("CG"));
	}

	@Test
	public void testQuery_16() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		manager.query("OT 1142");
		assertEquals("Buy book", manager.query("GE TT"));
	}

	@Test
	public void testQuery_17() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		manager.query("OG 1426");
		assertEquals("Group of tasks", manager.query("GE GT"));
	}

	@Test
	public void testQuery_18() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		manager.query("OT 1142");
		assertEquals("Done", manager.query("GE TS"));
	}

	@Test
	public void testQuery_19() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		manager.query("OG 1426");
		assertEquals("1142-1242-1342", manager.query("GE GE"));
	}

	@Test
	public void testQuery_20() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		manager.query("OT 1546");
		manager.query("GE TD");
		manager.query("GE TS");
		manager.query("GE TT");
		assertEquals("Success", manager.query("CT"));
	}

	@Test
	public void testQuery_21() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		manager.query("OG 1425");
		manager.query("GE GD");
		manager.query("GE GE");
		manager.query("GE GT");
		assertEquals("Success", manager.query("CG"));
	}

	@Test
	public void testQuery_22() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		manager.query("OT 1546");
		assertEquals("Success", manager.query("SE TT New Title"));
	}

	@Test
	public void testQuery_23() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		manager.query("OT 1546");
		assertEquals("Success",
				manager.query("SE TD New description goes here"));
	}

	@Test
	public void testQuery_24() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		manager.query("OT 1546");
		assertEquals("Success", manager.query("SE TS Future"));
	}

	@Test
	public void testQuery_25() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		manager.query("OT 1546");
		assertEquals("Success", manager.query("SE TU 22/06/2015"));
	}

	@Test
	public void testQuery_26() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		manager.query("OT 1546");
		manager.query("SE TT New Title");
		assertEquals("New Title", manager.query("GE TT"));
	}

	@Test
	public void testQuery_27() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		manager.query("OT 1546");
		manager.query("SE TD New description goes here");
		assertEquals("New description goes here", manager.query("GE TD"));
	}

	@Test
	public void testQuery_28() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		manager.query("OT 1546");
		manager.query("SE TS Future");
		assertEquals("Future", manager.query("GE TS"));
	}

	@Test
	public void testQuery_29() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		manager.query("OT 1546");
		manager.query("SE TU 15/03/2015");
		assertEquals("15/03/2015", manager.query("GE TU"));
	}

	@Test
	public void testQuery_30() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		manager.query("OG 1425");
		assertEquals("Success", manager.query("SE GT New Group Title"));
	}

	@Test
	public void testQuery_31() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		manager.query("OG 1426");
		assertEquals("Success",
				manager.query("SE GD New group description goes here"));
	}

	@Test
	public void testQuery_33() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		manager.query("OG 1426");
		assertEquals("Success", manager.query("SE GE 1543-1544-1545"));
	}

	@Test
	public void testQuery_34() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		manager.query("OG 1425");
		manager.query("SE GT New Group Title");
		assertEquals("New Group Title", manager.query("GE GT"));
	}

	@Test
	public void testQuery_35() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		manager.query("OG 1426");
		manager.query("SE GD New group description goes here");
		assertEquals("New group description goes here", manager.query("GE GD"));
	}

	@Test
	public void testQuery_36() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		manager.query("OG 1426");
		manager.query("SE GE 1543-1544-1545");
		assertEquals("1543-1544-1545", manager.query("GE GE"));
	}

	@Test
	public void testQuery_37() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		manager.query("OG 1426");
		assertEquals("Fail", manager.query("SE GI 1847"));
	}

	@Test
	public void testQuery_38() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		manager.query("OT 1242");
		assertEquals("Fail", manager.query("SE TI 1601"));
	}

	@Test
	public void testQuery_39() {
		manager.load("C:/Users/ÚÈÏÇááå/Downloads/Phase-0-TestFiles/desc-3.txt");
		manager.query("OT 1242");
		assertEquals("Fail", manager.query("SE TP 9"));
	}

	@Test
	public void testLoadProject_0() {
		assertEquals(false,
				manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro0.txt"));
	}

	@Test
	public void testLoadProject_1() {
		assertEquals(false,
				manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro1.txt"));
	}

	@Test
	public void testLoadProject_2() {
		assertEquals(false,
				manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro2.txt"));
	}

	@Test
	public void testLoadProject_3() {
		assertEquals(true,
				manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro3.txt"));
	}

	@Test
	public void testLoadProject_4() {
		assertEquals(false,
				manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro4.txt"));
	}

	@Test
	public void testLoadProject_5() {
		assertEquals(false,
				manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro5.txt"));
	}

	@Test
	public void testLoadProject_6() {
		assertEquals(true,
				manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro6.txt"));
	}

	@Test
	public void testLoadProject_7() {
		assertEquals(false,
				manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro7.txt"));
	}

	@Test
	public void testLoadProject_8() {
		assertEquals(false,
				manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro8.txt"));
	}

	@Test
	public void testLoadProject_9() {
		assertEquals(false,
				manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro9.txt"));
	}

	@Test
	public void testLoadProject_10() {
		assertEquals(true,
				manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro10.txt"));
	}

	@Test
	public void testLoadProject_11() {
		assertEquals(true,
				manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro11.txt"));
	}

	@Test
	public void testLoadProject_12() {
		assertEquals(true,
				manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro12.txt"));
	}

	@Test
	public void testLoadProject_13() {
		assertEquals(true,
				manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro13.txt"));
	}

	@Test
	public void testLoadProject_14() {
		assertEquals(false,
				manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro14.txt"));
	}

	@Test
	public void testQueryProject_1() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro10.txt");
		assertEquals("Fail", manager.query("AT 1002"));
	}

	@Test
	public void testQueryProject_2() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro10.txt");
		assertEquals("Success", manager.query("AT 1003"));
	}

	@Test
	public void testQueryProject_3() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro10.txt");
		assertEquals("Fail", manager.query("RP 2222"));
	}

	@Test
	public void testQueryProject_4() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro10.txt");
		assertEquals("Success", manager.query("RP 2223"));
	}

	@Test
	public void testQueryProject_5() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro10.txt");
		assertEquals("Fail", manager.query("OP 1111"));
	}

	@Test
	public void testQueryProject_6() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro10.txt");
		manager.query("OP 2223");
		assertEquals("Fail", manager.query("OP 2224"));
	}

	@Test
	public void testQueryProject_7() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro10.txt");
		manager.query("OP 2224");
		manager.query("CP");
		assertEquals("Success", manager.query("OP 2223"));
	}

	@Test
	public void testQueryProject80() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro10.txt");
		assertEquals("Success", manager.query("OP 2224"));
	}

	@Test
	public void testQueryProject_90() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro11.txt");
		manager.query("OP 2001");
		assertEquals("InProgress", manager.query("PS"));
	}

	@Test
	public void testQueryProject_10() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro12.txt");
		manager.query("OP 2001");
		assertEquals("Future", manager.query("PS"));
	}

	@Test
	public void testQueryProject_110() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro13.txt");
		manager.query("OP 2001");
		assertEquals("Done", manager.query("PS"));
	}

	@Test
	public void testQueryProject_120() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro11.txt");
		assertEquals("Fail", manager.query("PS"));
	}

	@Test
	public void testQueryProject() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro11.txt");
		assertEquals("Fail", manager.query("CP"));
	}

	@Test
	public void testQueryProject_140() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro11.txt");
		manager.query("OP 2001");
		assertEquals("Success", manager.query("CP"));
	}

	@Test
	public void testGetProject_2() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro10.txt");
		manager.query("OP 2224");
		assertEquals("hi", manager.query("GE PT"));
	}

	@Test
	public void testGetProject_3() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro10.txt");
		manager.query("OP 2224");
		assertEquals("I HAVE ONE DEP", manager.query("GE PD"));
	}

	@Test
	public void testGetProject_4() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro10.txt");
		manager.query("OP 2224");
		assertEquals("1001-1002", manager.query("GE PP"));
	}

	@Test
	public void testGetProject_5() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro10.txt");
		manager.query("OP 2224");
		assertEquals("1002>1001", manager.query("GE PY"));
	}

	@Test
	public void testGetProject_6() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro11.txt");
		manager.query("OP 2001");
		assertEquals("1005>1006-1004>1005-1003>1004-1002>1003-1001>1002",
				manager.query("GE PY"));
	}

	@Test
	public void testGetProject_1() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro10.txt");
		manager.query("OP 2223");
		assertEquals("None", manager.query("GE PT"));
	}

	@Test
	public void testGetProject_7() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro10.txt");
		assertEquals("Fail", manager.query("GE PI"));
	}

	@Test
	public void testSetProject_1() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro10.txt");
		manager.query("OP 2223");
		assertEquals("Fail", manager.query("SE PI None"));
	}

	@Test
	public void testSetProject_2() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro10.txt");
		manager.query("OP 2223");
		assertEquals("Success", manager.query("SE PT None"));
	}

	@Test
	public void testSetProject_4() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro10.txt");
		manager.query("OP 2223");
		assertEquals("Success", manager.query("SE PD None"));
	}

	@Test
	public void testSetProject_PP1() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro10.txt");
		manager.query("OP 2223");
		manager.query("SE PP None");
		assertEquals("None", manager.query("GE PP"));
	}
	
	@Test
	public void testSetProject_PP2() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro10.txt");
		manager.query("OP 2223");
		manager.query("SE PP None");
		assertEquals("None", manager.query("GE PP"));
		assertEquals("None", manager.query("GE PY"));
	}


	@Test
	public void testSetProject_6() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro10.txt");
		manager.query("OP 2223");
		assertEquals("Success", manager.query("SE PY None"));
	}

	@Test
	public void testSetProject_7() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro10.txt");
		manager.query("OP 2223");
		manager.query("SE PI None");
		assertEquals("2223", manager.query("GE PI"));

	}

	@Test
	public void testSetProject_8() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro10.txt");
		manager.query("OP 2224");
		manager.query("SE PT None");
		assertEquals("None", manager.query("GE PT"));

	}

	@Test
	public void testSetProject_9() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro10.txt");
		manager.query("OP 2223");
		 manager.query("SE PD None");
			assertEquals("None", manager.query("GE PD"));

	}

	@Test
	public void testSetProject_10() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro10.txt");
		manager.query("OP 2223");
		manager.query("SE PY None");
		assertEquals("None", manager.query("GE PY"));

	}
	

	@Test
	public void testSetProject_11() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro11.txt");
		manager.query("OP 2001");
		assertEquals("Success", manager.query("SE PP 1007-1008-1003-1002"));
	}


	@Test
	public void testSetProject_12() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro11.txt");
		manager.query("OP 2001");
		assertEquals("Fail", manager.query("SE PP 1010-1008-1003-1002"));
	}
	

	@Test
	public void testSetProject_13() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro11.txt");
		manager.query("OP 2001");
		manager.query("SE PP 1008-1008-1003-1002");
		assertEquals("1008-1008-1003-1002", manager.query("GE PP"));
	}
	

	@Test
	public void testSetProject_14() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro12.txt");
		manager.query("OP 2001");
		assertEquals("Success", manager.query("SE PY 1006>1005-1005>1004-1004>1003-1003>1002-1002>1001"));
	}
	

	@Test
	public void testSetProject_15() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro12.txt");
		manager.query("OP 2001");
		manager.query("SE PY 1006>1005-1005>1004-1004>1003-1003>1002-1002>1001");
		assertEquals("1002>1001-1003>1002-1004>1003-1005>1004-1006>1005", manager.query("GE PY"));
	}
	

	@Test
	public void testSetProject_16() {
		manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/pro11.txt");
		manager.query("OP 2001");
		assertEquals("Fail", manager.query("SE PY 1006>1003"));
	}
	
	@Test
	public void loadTest_11(){
		assertEquals(false, manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/test11.txt"));
	}
	
	@Test
	public void loadTest_12(){
		assertEquals(false, manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/test12.txt"));
	}
	
	@Test
	public void loadTest_13(){
		assertEquals(false, manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/test13.txt"));
	}
	
	@Test
	public void loadTest_14(){
		assertEquals(false, manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/test14.txt"));
	}
	
	@Test
	public void loadTest_15(){
		assertEquals(false, manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/test15.txt"));
	}
	
	@Test
	public void loadTest_16(){
		assertEquals(false, manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/test16.txt"));
	}
	
	@Test
	public void loadTest_17(){
		assertEquals(false, manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/test17.txt"));
	}
	
	@Test
	public void loadTest_18(){
		assertEquals(false, manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/test18.txt"));
	}
	
	@Test
	public void loadTest_19(){
		assertEquals(false, manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/test19.txt"));
	}
	
	@Test
	public void loadTest_20(){
		assertEquals(false, manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/test20.txt"));
	}
	
	@Test
	public void loadTest_1(){
		assertEquals(true, manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/test/test01.txt"));
	}
	
	@Test
	public void loadTest_2(){
		assertEquals(true, manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/test/test02.txt"));
	}
	
	@Test
	public void loadTest_3(){
		assertEquals(true, manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/test/test03.txt"));
	}
	
	@Test
	public void loadTest_4(){
		assertEquals(true, manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/test/test04.txt"));
	}
	
	@Test
	public void loadTest_5(){
		assertEquals(true, manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/test/test05.txt"));
	}
	
	@Test
	public void loadTest_6(){
		assertEquals(true, manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/test/test06.txt"));
	}
	
	@Test
	public void loadTest_7(){
		assertEquals(true, manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/test/test07.txt"));
	}
	
	@Test
	public void loadTest_8(){
		assertEquals(true, manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/test/test08.txt"));
	}
	
	@Test
	public void loadTest_9(){
		assertEquals(true, manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/test/test09.txt"));
	}
	
	@Test
	public void loadTest_10(){
		assertEquals(true, manager.load("C:/Users/ÚÈÏÇááå/Desktop/pro/test/test10.txt"));
	}
	

	@Test
	public void loadTest_011(){
		assertEquals(false, manager.load("C:/Users/ÚÈÏÇááå/Desktop/Phase-1-TestFiles/test11.txt"));
	}
	
	@Test
	public void loadTest_012(){
		assertEquals(false, manager.load("C:/Users/ÚÈÏÇááå/Desktop/Phase-1-TestFiles/test12.txt"));
	}
	
	@Test
	public void loadTest_013(){
		assertEquals(false, manager.load("C:/Users/ÚÈÏÇááå/Desktop/Phase-1-TestFiles/test13.txt"));
	}
	
	@Test
	public void loadTest_014(){
		assertEquals(false, manager.load("C:/Users/ÚÈÏÇááå/Desktop/Phase-1-TestFiles/test14.txt"));
	}
	
	@Test
	public void loadTest_015(){
		assertEquals(false, manager.load("C:/Users/ÚÈÏÇááå/Desktop/Phase-1-TestFiles/test15.txt"));
	}
	
	@Test
	public void loadTest_016(){
		assertEquals(false, manager.load("C:/Users/ÚÈÏÇááå/Desktop/Phase-1-TestFiles/test16.txt"));
	}
	
	@Test
	public void loadTest_017(){
		assertEquals(false, manager.load("C:/Users/ÚÈÏÇááå/Desktop/Phase-1-TestFiles/test17.txt"));
	}
	
	@Test
	public void loadTest_018(){
		assertEquals(false, manager.load("C:/Users/ÚÈÏÇááå/Desktop/Phase-1-TestFiles/test18.txt"));
	}
	
	@Test
	public void loadTest_019(){
		assertEquals(false, manager.load("C:/Users/ÚÈÏÇááå/Desktop/Phase-1-TestFiles/test19.txt"));
	}
	
	@Test
	public void loadTest_020(){
		assertEquals(false, manager.load("C:/Users/ÚÈÏÇááå/Desktop/Phase-1-TestFiles/test20.txt"));
	}
	
	@Test
	public void loadTest_01(){
		assertEquals(true, manager.load("C:/Users/ÚÈÏÇááå/Desktop/Phase-1-TestFiles/test01.txt"));
	}
	
	@Test
	public void loadTest_02(){
		assertEquals(true, manager.load("C:/Users/ÚÈÏÇááå/Desktop/Phase-1-TestFiles/test02.txt"));
	}
	
	@Test
	public void loadTest_03(){
		assertEquals(true, manager.load("C:/Users/ÚÈÏÇááå/Desktop/Phase-1-TestFiles/test03.txt"));
	}
	
	@Test
	public void loadTest_04(){
		assertEquals(true, manager.load("C:/Users/ÚÈÏÇááå/Desktop/Phase-1-TestFiles/test04.txt"));
	}
	
	@Test
	public void loadTest_05(){
		assertEquals(true, manager.load("C:/Users/ÚÈÏÇááå/Desktop/Phase-1-TestFiles/test05.txt"));
	}
	
	@Test
	public void loadTest_06(){
		assertEquals(true, manager.load("C:/Users/ÚÈÏÇááå/Desktop/Phase-1-TestFiles/test06.txt"));
	}
	
	@Test
	public void loadTest_07(){
		assertEquals(true, manager.load("C:/Users/ÚÈÏÇááå/Desktop/Phase-1-TestFiles/test07.txt"));
	}
	
	@Test
	public void loadTest_08(){
		assertEquals(true, manager.load("C:/Users/ÚÈÏÇááå/Desktop/Phase-1-TestFiles/test08.txt"));
	}
	
	@Test
	public void loadTest_09(){
		assertEquals(true, manager.load("C:/Users/ÚÈÏÇááå/Desktop/Phase-1-TestFiles/test09.txt"));
	}
	
	@Test
	public void loadTest_010(){
		assertEquals(true, manager.load("C:/Users/ÚÈÏÇááå/Desktop/Phase-1-TestFiles/test10.txt"));
	}
	
	
	
	
	
	

	



}
