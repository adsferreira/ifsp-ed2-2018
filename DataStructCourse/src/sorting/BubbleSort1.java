package sorting;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10000;
		//int X[] = new int[n];
		int aux, i, j;
		
		int comp = 0;
		int nr_troca = 0;
		
		int X[] = new int[n]; 
		Random gerador = new Random(); 
		for (i = 0; i < n; i++) { 
			X[i] = gerador.nextInt(10000); 
		}
		
	/*	Scanner entrada = new Scanner(System.in);
		
		// carregando os números do vetor
		for(i = 0; i < n; i++) {
			System.out.println("Digite o " + (i + 1) + " º número: ");
			X[i] = entrada.nextInt();
		}
		
		entrada.close();*/
		
		for (i = 0; i < n; i++) {
			for (j = 0; j < n - 1; j++) {
				
				if (X[j] > X[j + 1]) {
					aux = X[j];
					X[j] = X[j + 1];
					X[j + 1] = aux;
					
				}
			}	
		}
		
		
		long tempoInicial = System.currentTimeMillis();
		
		for (i = 0; i < n; i++) {
			for (j = 0; j < n - 1; j++) {
				comp++;
				if (X[j] < X[j + 1]) {
					aux = X[j];
					X[j] = X[j + 1];
					X[j + 1] = aux;
					nr_troca++;
				}
			}	
		}
		
		long tempoGasto = System.currentTimeMillis() - tempoInicial;
		
		// mostrando o vetor ordenado
		/*System.out.println("Vetor ordenado\n");
		
		for(i = 0; i < n; i++) {
			System.out.println((i + 1) + "º número: " + X[i]);
		}*/
		System.out.println("número de comparações: " + comp);
		System.out.println("número de trocas: " + nr_troca);
		System.out.println("tempo de execução: " + tempoGasto);
	}
}