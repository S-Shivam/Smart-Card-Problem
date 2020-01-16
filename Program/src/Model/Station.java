
public class Station {

	private final String name;
	private final int index;

	private Station(Form form) {
		name = form.name;
		index = form.index;
	}

	public static class Form {

		private String name;
		private int index;

		public Form usingName(String name) {
			this.name = name;
			return this;
		}

		public Form usingIndex(int index) {
			this.index = index;
			return this;
		}

		public Station construct() {
			return new Station(this);
		}
	}

	public String getName() {
		return name;
	}

	public int getIndex() {
		return index;
	}
}