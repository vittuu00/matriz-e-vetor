import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex_04 {

	static Scanner entrada;
	
	public static void main(String[] args) throws IOException {
		
		entrada = new Scanner(System.in);
		
		float ultimo = 0, primeiro = 0;
		int TAM;
		System.out.println("Quantos alunos são?");
		TAM = entrada.nextInt();
		System.out.println("Cada um tem o direto de dar 5 saltos!!");
		float saltos[][] = new float [TAM][5];
		float media[] = new float [TAM];
		float menor = 0;
		
		FileWriter arq = new FileWriter("Salto.txt");
	    PrintWriter gravarArq = new PrintWriter(arq);
		
	
		for(int k = 0; k < TAM; k++) {
 			for(int j = 0; j < 5; j++) {
 				
 				System.out.print("\nEscreva o tamanho do salto nº"+(j+1)+" do atleta nº"+(k+1)+" em metros: ");
 					saltos[k][j] = entrada.nextFloat();
 					gravarArq.printf("\nO atleta nº"+(k+1)+" saltou: "+saltos[k][j]+" metros");
 					if (j == 0) 
 						menor = saltos[k][j];
 					else if (menor > saltos[k][j])	
 						menor = saltos[k][j];
 						
 					media[k] += saltos[k][j];
 					
 					
 					
}
 			
 					media[k] -= menor;
 					media[k] = media[k] / (TAM - 1);
}
		
		for(int k = 0; k < TAM; k++) {
			gravarArq.printf("\nA média do atleta nº"+(k+1)+" foi de: "+ (media[k]));
 				
 				if (k == 0) 
						ultimo = media[k];
					else if (ultimo > media[k])	
						ultimo = media[k];
					
					if (primeiro < media[k])
						primeiro = media[k];
					
	}
		gravarArq.printf("\nA média do saltos do campeão é:"+primeiro+" \nE do último lugar é:"+ ultimo);	
		System.out.println("Arquivo gerado com sucesso!");
		
		
		arq.close();
		entrada.close();
}
}
