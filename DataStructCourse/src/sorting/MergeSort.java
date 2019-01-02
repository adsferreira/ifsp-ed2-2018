package sorting;
import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8;
		int X[] = {8, 7, 6, 5, 4, 3, 2, 1};
		int i;
					
		/*Scanner entrada = new Scanner(System.in);
		
		// carregando os números do vetor
		for(i = 0; i < n; i++) {
			System.out.println("Digite o " + (i + 1) + " º número: ");
			X[i] = entrada.nextInt();
		}
		
		entrada.close();*/
		
		merge(X, 0, n - 1);
		
		// mostrando o vetor ordenado
		System.out.println("Vetor ordenado\n");
				
		for(i = 0; i < n; i++) {
			System.out.println((i + 1) + "º número: " + X[i]);
		}

	}
	
	public static void merge(int X[], int inicio, int fim) {
		int meio;
		
		if (inicio < fim) {
			meio = (inicio + fim) / 2;
			merge(X, inicio, meio);
			merge(X, meio + 1, fim);
			intercala(X, inicio, fim, meio);
		}
	}
	
	public static void intercala(int X[], int inicio, int fim, int meio) {
		int posLivre, inicioVetor1, inicioVetor2, i;
		int aux[] = new int[X.length];
		inicioVetor1 = inicio;
		inicioVetor2 = meio + 1;
		posLivre = inicio;
		
		while(inicioVetor1 <= meio && inicioVetor2 <= fim) {
			if(X[inicioVetor1] <= X[inicioVetor2]) {
				aux[posLivre] = X[inicioVetor1];
				inicioVetor1 = inicioVetor1 + 1;
			}
			else {
				aux[posLivre] = X[inicioVetor2];
				inicioVetor2 = inicioVetor2 + 1;
			}
			posLivre = posLivre + 1;
		}
		
		// percorre os elementos faltantes do lado esquerdo, caso existam
		for(i = inicioVetor1; i <= meio; i++) {
			aux[posLivre] = X[i];
			posLivre = posLivre + 1;
		}
		
		// percorre os elementos faltantes do lado direita, caso existam
		for(i = inicioVetor2; i <= fim; i++) {
			aux[posLivre] = X[i];
			posLivre = posLivre + 1;
		} 
		
		// copia os elementos ordenados do vetor aux para o vetor X original
		for(i = inicio; i <= fim; i++) {
			X[i] = aux[i];
		}
	}

}
