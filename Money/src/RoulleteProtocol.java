
public class RoulleteProtocol {
	private final int NUMBERS = 36;
	private double bet;
	private double odd;
	private double realOdd;
	private double loss;
	private double zeros;
	private double money;
	private String type;
	
	public double getRealOdd() {
		return realOdd;
	}

	public double getLostMoney() {
		return loss;
	}

	public double getBetMoney(){
		return bet;
	}
	
	public double getOdd() {
		return odd;
	}

	public double getMoney() {
		return money;
	}

	private boolean isColor(){
		odd = 0.5;
		realOdd = (NUMBERS*0.5)/(NUMBERS + zeros);
		return type.matches("(red|black)");
	}
	
	private boolean isParity(){
		odd = 0.5;
		realOdd = (NUMBERS*0.5)/(NUMBERS + zeros);
		return type.matches("(odd|even)");
	}
		
	private boolean isPart(){
		odd = (NUMBERS*0.3)/NUMBERS;
		realOdd = (NUMBERS*0.3)/(NUMBERS + zeros);
		return type.matches("(1st|2nd|3rd)");
	}
	
	private boolean isHalf(){
		odd = 0.5;
		realOdd = (NUMBERS*0.5)/(NUMBERS + zeros);
		return type.matches("half");
	}
	
	private boolean isNumber(){
		try{
			odd = (double)Integer.parseInt(type)/(NUMBERS);
			realOdd = (double)Integer.parseInt(type)/(NUMBERS + zeros);
		}
		catch (Exception e){
			odd = 1000;
			return false;
		}
		return (type.matches("[0-9]"));
	}
	
	private void doMaths(){
		money = bet / odd;
		loss = (bet / realOdd) - money;
	}
	
	public void getMoneys(){
		if(isColor()){
			doMaths();
		}
		else if(isHalf())
			doMaths();
		else if(isNumber())
			doMaths();
		else if(isPart())
			doMaths();
		else if(isParity())
			doMaths();
		else if(isColor())
			doMaths();
		else {
			money = 0;
			loss = 0;
		}
	}
	
	public RoulleteProtocol(double bet, String type, int numZeros){
		zeros = numZeros;
		this.bet = bet;
		this.type = type.replace(" ", "");
		getMoneys();
	}
}
