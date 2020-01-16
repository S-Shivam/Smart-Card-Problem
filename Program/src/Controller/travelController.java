
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class travelController {

	private List<cardVO> cardList;
	private List<Station> stationList;
	private List<travelVO> travelList;
	private Map<cardVO,travelVO> travelMap;
	private Days day;
	private fareCalcService service; 

	public travelController() {
		cardList = new ArrayList<>();
		stationList = new ArrayList<>();
		travelList = new ArrayList<>();
		travelMap = new HashMap<>();
		service = fareCalcService.getfareCalcService();
	}

	public travelController(Days day) {
		this();
		this.day = day;
	}

	public String swipeIn(cardVO card, Station fromStation) {
		if (card.getBalance() < 50) {
			return "Card Balance is less than Rs. 50";
		}
		travelVO travel = new travelVO(card, fromStation);
		travelList.add(travel);
		travelMap.put(card, travel);
		return "Welcome to Metro";
	}
	
	public String swipeOut(cardVO card, Station toStation) {
		
		travelVO travel = travelMap.get(card);
		fareVO result = new fareVO.Form().usingCard(card).usingFromStation(travel.getFromStation()).usingToStation(toStation).usingDay(day).construct();
		double fare = service.calculateFare(result);
		if (result.getCard().getBalance() < fare) {
			return "Card Balance: Rs. "+ result.getCard().getBalance() " is less than the fare: Rs. " + fare;
		}
		travel.setFare(fare);
		card.setBalance(card.getBalance() - fare);
		travelMap.remove(card);
		return travel.toString() + ". Fare is Rs. " + travel.getFare() + " and balance on card is Rs. " + card.getBalance();
	}

	
	public void addCard(cardVO card) {
		this.cardList.add(card);
	}

	public void addStation(Station station) {
		this.stationList.add(station);
	}

	public void addTravel(travelVO travel) {
		this.travelList.add(travel);
	}

	public List<cardVO> getCardList() {
		return cardList;
	}

	public void setCardList(List<cardVO> cardList) {
		this.cardList = cardList;
	}

	public List<Station> getStationList() {
		return stationList;
	}

	public void setStationList(List<Station> stationList) {
		this.stationList = stationList;
	}

	public List<travelVO> getTravelList() {
		return travelList;
	}

	public void setTravelList(List<travelVO> travelList) {
		this.travelList = travelList;
	}

	public Days getDay() {
		return day;
	}

	public void setDay(Days day) {
		this.day = day;
	}

}