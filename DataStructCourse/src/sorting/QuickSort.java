package sorting;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*int n = 10;
		int X[] = new int[n]; 
		Random gerador = new Random(); 
		for (int i = 0; i < n; i++) { 
			X[i] = gerador.nextInt(60); 
		}*/
		
		//int X[] = {58, 19, 47, 6, 14, 58, 16, 46, 48, 21};
		//int X[] = {5, 8, 3, 1, 6, 2, 4, 9, 7, 5};
		//int X[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		//int X[] = {2, 3, 1, 4, 10};
		int X[] = {58, 19, 47, 6, 14, 58, 16, 46, 48, 21};
		System.out.print(Arrays.toString(X));
		
		int i;
		
		/*Scanner entrada = new Scanner(System.in);
		
		// carregando os números do vetor
		for(i = 0; i < n; i++) {
			System.out.println("Digite o " + (i + 1) + " º número: ");
			X[i] = entrada.nextInt();
		}
		
		entrada.close();*/
		
		quickSort(X, 0, X.length - 1);
		
		// mostrando o vetor ordenado
		System.out.println("Vetor ordenado\n");

		for (i = 0; i < X.length; i++) {
			System.out.println((i + 1) + "º número: " + X[i]);
		}

	}
	
	public static void troca(int X[], int i, int j) {
		int aux;
		aux = X[i];
		X[i] = X[j];
		X[j] = aux;
	}
	
	public static int particao(int X[], int inicio, int fim) {
		int pivo, esq, dir;
		esq = inicio - 1;
		dir = fim + 1;
		pivo = X[(inicio + fim) / 2];
				
		while(esq < dir) {
			do {
				esq++;
			} while(X[esq] < pivo);
			
			do {
				dir--;
			} while(X[dir] > pivo);
			
			if(esq < dir) {
				troca(X, esq, dir);
			}
		}
			
		return dir;
	}
	
	public static void quickSort(int X[], int inicio, int fim) {
		int q;
		if (inicio < fim) {
			q = particao(X, inicio, fim);
			quickSort(X, inicio, q);
			quickSort(X, q + 1, fim);
		}
	}
}
