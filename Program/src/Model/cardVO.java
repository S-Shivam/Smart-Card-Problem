
public class cardVO {

	private final int cardNo;
	private double balance;

	public cardVO(int cardNo, double balance) {
		this.cardNo = cardNo;
		this.balance = balance;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public int getCardNo() {
		return cardNo;
	}

}