
public class fareVO {

	private final Card card;
	private final Station fromStation;
	private final Station toStation;
	private final Days day;

	private fareVO(Form form) {
		this.card = form.card;
		this.fromStation = form.fromStation;
		this.toStation = form.toStation;
		this.day = form.day;
	}

	public static class Form {

		private Card card;
		private Station fromStation;
		private Station toStation;
		private Days day;

		public Form usingCard(Card card) {
			this.card = card;
			return this;
		}

		public Form usingFromStation(Station fromStation) {
			this.fromStation = fromStation;
			return this;
		}

		public Form usingToStation(Station toStation) {
			this.toStation = toStation;
			return this;
		}

		public Form usingDay(Days day) {
			this.day = day;
			return this;
		}

		public fareVO construct() {
			return new fareVO(this);
		}
	}

	public Card getCard() {
		return card;
	}

	public Station getFromStation() {
		return fromStation;
	}

	public Station getToStation() {
		return toStation;
	}

	public Days getDay() {
		return day;
	}

}