import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class ListFileTest {

	@Test
	public void test() {
		String listFileName = "listTest.bin";
		assertFalse(new File(listFileName).exists());
		ListFile.initialize(listFileName);
		assertTrue(new File(listFileName).exists());
		
		ListFile lf = new ListFile("listTest.bin");
		
		Entry eTest = new Entry("Test", 62,-1);
		long num = lf.newEntry(eTest);
		Entry e = lf.get(num);
		assertEquals(eTest, e);
		
		Entry eTest2 = new Entry("Testie", 100, -1);
		long num2 = lf.newEntry(eTest2);
		Entry e2 = lf.get(num2);
		assertFalse(e.equals(e2));
		assertEquals(eTest2, e2);
		
		eTest.setLink(num2);
		assertFalse(eTest.getLink() == -1);
		assertTrue(eTest.getLink() == num2);
		
		assertEquals(eTest2, lf.get(num2));
		
		Entry eTest3 = new Entry("ThirdTest", 7, -1);
		lf.putEntry(num2, eTest3);
		assertFalse(eTest2.equals(lf.get(num2)));
		assertEquals(eTest3, lf.get(num2));
		
		eTest3.setValue(42);
		assertEquals(42, eTest3.getValue());
		
		lf.close();
		 ListFile lf2 = new ListFile("listTest.bin");
		 Entry CloseTest = new Entry("Testforclose" ,600, -1);
		long closeNum =  lf2.newEntry(CloseTest);
		assertFalse(closeNum == 0);
		lf2.close();
		
		ListFile.delete(listFileName);
		assertFalse(new File(listFileName).exists());
		
		
	}

}
