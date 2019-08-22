import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Ex_05 {

	static Scanner entrada;
	
	public static void main(String[] args) throws IOException {
		
		entrada = new Scanner(System.in);
		
		Random gerador = new Random();
		
		FileWriter arq = new FileWriter("Loteria.txt");
	    PrintWriter gravarArq = new PrintWriter(arq);
		
		int CARTELAS;
		int loteria[] = new int [6];
		int acertos[] = new int [6];
		
		for (int k=0; k<6;k++) {
			loteria[k] = gerador.nextInt(60) + 1; 
		
		}
		System.out.println("Quantas cartelas da loteria você quer?");
		CARTELAS = entrada.nextInt();
		
		int cartela[][] = new int [CARTELAS][6];
		
		
		for (int k=0; k<CARTELAS; k++) {
			for (int j=0; j<6; j++) {
				cartela[k][j] = gerador.nextInt(60) + 1; 
				 System.out.println(cartela[k][j]);
				if (cartela[k][j] == loteria[j]) {
					acertos[j]++;
				}
					
				
				
			}
		}
			
		System.out.println("Números sorteados:");
		
		for (int j=0; j<6; j++) {
			System.out.println(loteria[j]+": "+acertos[j]+" acertos!" );
			}
			
		

		
		
	}
	
}
