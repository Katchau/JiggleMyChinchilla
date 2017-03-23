import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Roullete {
	private ArrayList<RoulleteProtocol> bets;
	private final Pattern BETYPE = Pattern.compile("(?<=-).*");
	private final Pattern BETV = Pattern.compile(".*(?=-)");
	
	public Roullete(ArrayList<String> betList,int nZeros) throws IOException{
		bets = new ArrayList<RoulleteProtocol>();
		for(String bet : betList){
			Matcher m = BETYPE.matcher(bet);
			if(!m.find()) throw new IOException();
			String type = m.group();
			m = BETV.matcher(bet);
			if(!m.find()) throw new IOException();
			Double betv = Double.parseDouble(m.group());
			bets.add(new RoulleteProtocol(betv,type,nZeros));
		}
	}
	
	public double calcTotalBet(){
		double total = 0;
		
		for(RoulleteProtocol bet : bets){
			total += bet.getBetMoney();
		}
		
		return total;
	}
	
	public double worthWithBestOutcome(){
		double total = 0;
		double highestBid = 0;
		
		for(RoulleteProtocol bet : bets){
			total += bet.getBetMoney();
			highestBid = (bet.getMoney() < highestBid) ? highestBid : bet.getMoney();
		}

		return highestBid-total;
	}
	
	public double realisticWin(){
		double total = 0;
		
		for(RoulleteProtocol bet : bets){
			total += bet.getBetMoney();
		}
		
		return total;
	}
}
