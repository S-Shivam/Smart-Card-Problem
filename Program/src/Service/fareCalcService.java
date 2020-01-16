
public class fareCalcService {

	private fareCalcService() {
	}

	private static fareCalcService service = new fareCalcService();

	public static fareCalcService getfareCalcService() {
		return service;
	}

	public Double calculateFare(fareVO result) {
		double fare = 0;

		if ((result.getDay() == Days.SAT) || (result.getDay() == Days.SUN)) 
			fare = 5.5;
		else
			fare = 7;

		int totStationsTravelled = Math.abs(result.getFromStation().getIndex() - result.getToStation().getIndex());
		fare = fare*totStationsTravelled;
		
		return fare;
	}
}