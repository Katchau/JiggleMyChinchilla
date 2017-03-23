import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	//TODO list por ordem de importancia
	//TODO calcular risco para todas as apostas e fazer um outcome e dar a probabilidade
	//TODO ir armazenando valores para alterar probabilidades para ser mais realisticio
	//TODO fazer interface gráfica com um pénis gigante
	
	public static void main(String[] args) {
		System.out.println("Please introduce your bets on the following order: bet-betType");
		Scanner scani = new Scanner(System.in);
		String answer = scani.nextLine();
		ArrayList<String> bets = new ArrayList<String>();
		do{
			bets.add(answer);
			System.out.println("To finish your bets write 'end'");
			answer = scani.nextLine();
		}while(!answer.equals("end"));
		scani.close();
		try{
			Roullete r = new Roullete(bets,1);
			System.out.println(r.calcTotalBet());
			System.out.println(r.worthWithBestOutcome());
		}
		catch(IOException e){
			System.out.println("Error inputing bets!");
		}
	}

}
