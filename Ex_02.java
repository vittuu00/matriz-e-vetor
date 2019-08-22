import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex_02 {
	
	static Scanner entrada;

	public static void main(String[] args) throws IOException {

		entrada = new Scanner(System.in);
		
		float preco[][] = new float[5][5];
		float mediaProduto[] = new float[5];
		float somaMercado[] = new float[5];
		float maisCaro = 0, maisBarato = 0;
		
		float valorTotal = 0;
		
		
		for (int k = 0; k < 5; k++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("Qual o pre�o do produto n� "+(j+1)+" do mercado n� "+(k+1)+"? ");
				preco[k][j] = entrada.nextFloat();
				
				switch (j) {
				
				case 0:
					mediaProduto[0] += preco[k][j];
					break;
				case 1:
					mediaProduto[1] += preco[k][j];
					break;
				case 2:
					mediaProduto[2] += preco[k][j];
					break;
				case 3:
					mediaProduto[3] += preco[k][j];
					break;
				case 4:
					mediaProduto[4] += preco[k][j];
					break;
				}
				
				switch (k) {
				
				case 0:
					somaMercado[0] += preco[k][j];
					break;
				case 1:
					somaMercado[1] += preco[k][j];
					break;
				case 2:
					somaMercado[2] += preco[k][j];
					break;
				case 3:
					somaMercado[3] += preco[k][j];
					break;
				case 4:
					somaMercado[4] += preco[k][j];
					break;
					
				}
				
				valorTotal += preco[k][j];	
			}	
		}
		
		for (int x = 0; x < 5; x++) {
			
			if (x == 0)
				maisBarato = somaMercado[x];
			
			else if (maisBarato > somaMercado[x])
				maisBarato = somaMercado[x];
					
			if (maisCaro < somaMercado[x])
				maisCaro = somaMercado[x];
		}
		
		
		FileWriter arq = new FileWriter("Produtos_Mercado.txt");
	    PrintWriter gravarArq = new PrintWriter(arq);
		
		
		for (int k = 0; k < 5; k++) {
			for (int j = 0; j < 5; j++) {
				gravarArq.printf("\nO pre�o do produto n� "+(j+1)+" do mercado n� "+(k+1)+" �:"+ preco[k][j]);
	
			}
		}
		
		for (int k = 0; k < 5; k++) {
			gravarArq.printf("\nA m�dia do "+(k + 1)+"� produto �: "+ (mediaProduto[k] / 5));
			gravarArq.printf("\nA soma do "+(k + 1)+"� Mercado �: "+ (somaMercado[k]));
		}
		
		gravarArq.printf("\nO valor no mercado mais caro �: "+ maisCaro);
		gravarArq.printf("\nO valor no mercado mais barato �: "+ maisBarato);
		
		arq.close();
		 
		System.out.println("\nArquivo gravado com sucesso!");
	
		entrada.close();
	}
	//System.out.printf( "%.2f", x );
}
