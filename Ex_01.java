import java.math.BigDecimal;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex_01 {

	static Scanner entrada;
	
	public static void main(String[] args) throws IOException {
		
		entrada = new Scanner(System.in);
		
		boolean ok = true;
		int n = 0;																			//double x = 123.123;
		double media = 0;																		//System.out.printf( "%.2f", x ); 
		int soma = 0, maior = 0, menor = 0;
		int QTDpar = 0, QTDimpar = 0;
		int somaDiagPrinc = 0, somaDiagSec = 0;
		
		while(ok) {
		System.out.print("Informe o tamanho da matriz!\nDigite um número primo entre 3 e 11: ");
		n = entrada.nextInt();
		
		if (n >= 3 && n <= 11) {
			if (n == 3 || n == 5 || n == 7 || n == 11)
				ok = false;
			else
				System.out.println("Número invalido!");
		}else
			System.out.println("Número invalido!");
		}
		
		int matriz[][] = new int [n][n];
		
		for(int k = 0; k < n; k++){
			for (int i = 0; i < n; i++){
				System.out.printf("Digite um número: ");
				matriz[k][i] = entrada.nextInt();
					soma += matriz[k][i];
				
					if (maior < matriz[k][i])
						maior = matriz[k][i];
					
					if ((k == 0) && (i == 0))
						menor = matriz[k][i];
					else if (menor > matriz[k][i])
						menor = matriz[k][i];
					
					if (matriz[k][i] % 2 == 0)
						QTDpar += 1;
					else
						QTDimpar += 1;
					
					if (k == i)
						somaDiagPrinc += matriz[k][i];
					
					if ((k+1) + (i+1) == n + 1)
						somaDiagSec += matriz[k][i];
		}	
		}
		
		media = soma / (n*n); //System.out.printf( "%.2f", media ); 
		
		FileWriter arq = new FileWriter("Matriz.txt");
	    PrintWriter gravarArq = new PrintWriter(arq);
		
		
	    gravarArq.printf("\nSoma dos elementos: "+ soma);
	    gravarArq.printf("\nMédia dos elementos: "+"%.2f", media);
	    gravarArq.printf("\nMaior valor: "+ maior);
	    gravarArq.printf("\nMenor valor: "+ menor);
	    gravarArq.printf("\nQuantidade de pares: "+ QTDpar);
	    gravarArq.printf("\nQuantidade de impares: "+ QTDimpar);
	    gravarArq.printf("\nSoma da diagonal principal: "+ somaDiagPrinc );
	    gravarArq.printf("\nSoma da diagonal secundária: "+ somaDiagSec+"\n");

		for(int k = 0; k < n; k++){
			for (int i = 0; i < n; i++){
			   gravarArq.printf(matriz[k][i] + " "); 
		   }
			gravarArq.printf("\n");
		}
		
		System.out.println("\nArquivo gerado com sucesso!");
		
		entrada.close();
		arq.close();
	}
}
