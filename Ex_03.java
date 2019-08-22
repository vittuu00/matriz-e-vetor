import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex_03 {
	
	static Scanner entrada;

	public static void main(String[] args) throws IOException {
		
		entrada = new Scanner(System.in);
		
		int n;
		
		System.out.print("Quantos alunos são? ");
		n = entrada.nextInt();
		
		int ctd= 0;
		float media[] = new float[n];
		String nomes[] = new String[n] ;
		float notas[] = new float[n*2];
		String melhorAlunoNota = null, melhorAlunoMedia = null, piorAlunoNota = null, piorAlunoMedia = null, abaixoMG = null, acimaMG = null; // MG é media geral
		float melhorNota = 0, melhorMedia = 0, menorNota = 0, menorMedia = 0, mediaGeral = 0;
		
		for(int k = 0; k < n; k++) {
			System.out.print("\nDigite o nome do "+(k+1)+" º aluno: ");
				nomes[k] = entrada.next();
 			for(int j = 0; j < 2; j++) {
				System.out.print("\nE sua "+ (j+1)+"º nota: " );
					notas[ctd] = entrada.nextFloat();
					
					media[k] += notas[ctd]; 
					mediaGeral += notas[ctd];
					
				if (k == 0 && j == 0) {
					menorNota = notas[ctd];
					piorAlunoNota = nomes[k];
					
				}else if (notas[ctd] < menorNota) {
					menorNota = notas[ctd];
					piorAlunoNota = nomes[k];
				}
				
				if (melhorNota < notas[ctd]) {
					melhorNota = notas[ctd];
					melhorAlunoNota = nomes[k];
				}
			ctd++;
			}
		}	
		mediaGeral = mediaGeral / (n*2);
		
		ctd = 0;
		
		FileWriter arq = new FileWriter("Alunos.txt");
	    PrintWriter gravarArq = new PrintWriter(arq);
		
		
		for(int k = 0; k < n; k++) {
			media[k] = media[k] / 2;
			gravarArq.printf("\nO nome do "+(k+1)+"º aluno: "+ nomes[k]+"\nSua média é: "+ (media[k]));
			
			
			
			if (mediaGeral < media[k])
				acimaMG = nomes[k];
			else
				abaixoMG = nomes[k];
			
			
			if (k == 0) {
				menorMedia = media[k];
				piorAlunoMedia = nomes[k];
				
			}else if (media[k] < menorMedia) {
				menorMedia = media[k];
				piorAlunoMedia = nomes[k];
			}
			
			if (melhorMedia < media[k]) {
				melhorMedia = media[k];
				melhorAlunoMedia = nomes[k];
			}
			
 			for(int j = 0; j < 2; j++) {
 				gravarArq.printf("\nSua "+ (j+1)+"º nota: "+ notas[ctd]);	
				
				ctd++;
	}
}
		
		gravarArq.printf("\nA maior nota foi: "+melhorNota+" do aluno "+melhorAlunoNota+"\nA menor nota foi: "+menorNota+" do aluno "+piorAlunoNota);
		gravarArq.printf("\nA maior média foi: "+melhorMedia+" do aluno "+melhorAlunoMedia+"\nA menor média foi: "+menorMedia+" do aluno "+piorAlunoMedia);
		gravarArq.printf("\nA média geral da turma é: "+ mediaGeral);
		gravarArq.printf("\nO nome do aluno acima da Media Geral da Turma: "+acimaMG);
		gravarArq.printf("\nO nome do aluno abaixo da Media Geral da Turma: "+abaixoMG);
		
		arq.close();
		entrada.close();
		
		System.out.println("\nArquivo gerado com sucesso!");
	}
}
