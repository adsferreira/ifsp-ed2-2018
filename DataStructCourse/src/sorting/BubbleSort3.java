package sorting;
import java.util.Scanner;

public class BubbleSort3 {

	private static void trocaPosicao(int X[], int i, int j) {
		int aux = X[i];
		X[i] = X[j];
		X[j] = aux;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 10;
		int X[] = new int[n];
		int i, j, troca;
		
		Scanner entrada = new Scanner(System.in);
		
		for(i = 0; i < n; i++) {
			System.out.println("Digite o " + (i + 1) + "º número:");
			X[i] = entrada.nextInt();
		}
		
		entrada.close();
		
		i = 0;
		troca = 1;
		
		while(i < n && troca == 1) {
			troca = 0;
			
			for(j = 0; j < n - 1; j++) {
				if(X[j] > X[j + 1]) {
					trocaPosicao(X, j, j + 1);
					troca = 1;
				}
			}
			
			i += 1;
		}
		
		// mostrando o vetor ordenado
		System.out.println("Vetor ordenado\n");
						
		for(i = 0; i < n; i++) {
			System.out.println((i + 1) + "º número: " + X[i]);
		}
	}

}
