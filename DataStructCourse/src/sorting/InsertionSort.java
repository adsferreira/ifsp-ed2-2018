package sorting;
import java.util.Random;
import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, j, eleito, n = 10000;
		int troca = 0;
		//int X[] = new int[n];
		
		//Scanner entrada = new Scanner(System.in);
		
		int X[] = new int[n]; 
		Random gerador = new Random(); 
		for (i = 0; i < n; i++) { 
			X[i] = gerador.nextInt(10000); 
		}
		
		/*for (i = 0; i < n; i++) {
			System.out.println("Digite o " + (i + 1) + "º número");
			X[i] = entrada.nextInt();
		}
		
		entrada.close();*/
		
		for (i = 1; i < n; i++) {
			eleito = X[i];
			j = i - 1;
			while (j >= 0 && X[j] > eleito) {
				X[j + 1] = X[j];
				j = j - 1;
				
			}
			X[j + 1] = eleito;
			//troca++;
		}
		
		for (i = 1; i < n; i++) {
			eleito = X[i];
			j = i - 1;
			while (j >= 0 && X[j] > eleito) {
				X[j + 1] = X[j];
				j = j - 1;
				//troca++;
			}
			X[j + 1] = eleito;
			troca++;
		}
		
		System.out.println("Quantidade de trocas: " + troca);
		// print the sorted array
		/*for (i = 0; i < n; i++) {
			System.out.print(Integer.toString(X[i]) + " ");
		}*/
	}
}