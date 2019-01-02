package sorting;
import java.util.*;

public class SelectionSort {

	public static void main(String[] args) {		
		// TODO Auto-generated method stub
		int i, j, n = 5;
		int menor, id_menor, eleito;
		int X[] = new int[n];
		
		Scanner entrada = new Scanner(System.in);
		
		for (i = 0; i < n; i++) {
			X[i] = entrada.nextInt();
		}
		
		entrada.close();
		
		for (i = 0; i < n - 1; i++) {
			eleito = X[i];
			menor = X[i + 1];
			id_menor = i + 1;
			
			for (j = i + 2; j < n; j++) {
				if (X[j] < menor) {
					menor = X[j];
					id_menor = j;
				}
			}
			
			if (menor < eleito) {
				X[i] = menor;
				X[id_menor] = eleito;
			}
		}
		
		System.out.println();
		for (i = 0; i < n; i++)
			System.out.println(X[i]);
	}
}