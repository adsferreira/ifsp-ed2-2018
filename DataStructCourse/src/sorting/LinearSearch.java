package sorting;
import java.util.Scanner;

public class LinearSearch {
	
	public static boolean estaOrdenado(int X[]) {
		int i, n = X.length;
		
		if (n == 0) 
			return false;
		
		if (X[0] < X[1]) {
			for (i = 1; i < n - 1; i++) {
				if (X[i] > X[i + 1])
					return false;
			}
			return true;
		}
		else {
			for (i = 0; i < n - 1; i++) {
				if (X[i] < X[i + 1])
					return false;
			}
			return true;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, np, achou = 0, pos = -1, n = 5;
		int X[] = new int[n];
		Scanner entrada = new Scanner(System.in);
		
		
		for (i = 0; i < n; i++) {
			System.out.print("Digite o " + (i + 1) + "º número do vetor: ");
			X[i] = entrada.nextInt();
		}
		
		System.out.println();
		System.out.print("Entre com o número que deseja procurar: ");
		np = entrada.nextInt();
		entrada.close();
		
		boolean estaOrdenado = estaOrdenado(X);
		
		if (estaOrdenado) {
			i = 0;
			while (i < n && achou == 0 && np <= X[i]) {
				if (np == X[i]) {
					pos = i;
					achou = 1;
				}
				i++;
			}
	
		}
		else {
			/*for (i = 0; i < n; i++) {
				if (np == X[i]) {
					pos = i;
					break;
				}
			}*/
			
			i = 0;
			while (i < n && achou == 0) {
				if (np == X[i]) {
					pos = i;
					achou = 1;
				}
				
				i++;
			}
		}
		
		if (pos == -1) {
			System.out.println("O número " + String.valueOf(np) + " não foi encontrado.");
		}
		else {
			System.out.println("O número " + String.valueOf(np) + " foi encontrado na posição " + String.valueOf(pos));
		}
	}

}
