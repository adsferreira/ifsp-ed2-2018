package sorting;
import java.util.Scanner;

public class BubbleSort2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 5;
		int X[] = new int[n];
		int aux, i, j;
		
		Scanner entrada = new Scanner(System.in);
		
		for(i = 0; i < n; i++) {
			// System.out.println("Digite o " + (i + 1) + "º número:");
			System.out.print("");
			X[i] = entrada.nextInt();
		} 
	
		entrada.close();
		
		// bubble sort
		for(i = 1; i < n; i++) {
			for(j = (n - 1); j >= i; j--) { 
				if (X[j] < X[j - 1]) {
					aux = X[j];
					X[j] = X[j - 1];
					X[j - 1] = aux;
				}
			}
		}
		
		// mostrando o vetor ordenado
		System.out.println("Vetor ordenado\n");
				
		for(i = 0; i < n; i++) {
			System.out.println((i + 1) + "º número: " + X[i]);
		}
	}

}
