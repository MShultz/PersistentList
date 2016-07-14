
public class ListFile {
	public ListFile(String listFileName) {

	}

	public static void initialize(String listFileName) {

	}

	public long newEntry(Entry entry) {
		return -1;
	}

	public Entry get(long offset) {
		return new Entry("Invalid", -1, -1);
	}

	public void putEntry(long offset, Entry entry) {

	}

	public void close() {

	}

	public static void delete(String listFileName) {

	}

}
