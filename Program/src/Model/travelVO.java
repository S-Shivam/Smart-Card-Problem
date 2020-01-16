
public class travelVO {

	private final cardVO card;
	private final Station fromStation;
	private Station toStation;
	private double fare;
	private boolean isCompleted;

	public travelVO(cardVO card, Station fromStation) {
		this.card = card;
		this.fromStation = fromStation;
	}

	public Station getToStation() {
		return toStation;
	}

	public void setToStation(Station toStation) {
		this.toStation = toStation;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
		this.isCompleted = true;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public cardVO getCard() {
		return card;
	}

	public Station getFromStation() {
		return fromStation;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Card = ");
		sb.append(card.getCardNo());
		sb.append("used to travel from ");
		sb.append(fromStation.getName());
		sb.append(" to station ");
		sb.append(toStation.getName());
		
		return sb.toString();
	}

}