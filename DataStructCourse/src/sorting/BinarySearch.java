package sorting;
import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, np, inicio, meio, fim;
		int achou = 0;
		int pos = -1;
		int n = 5;
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
		
		inicio = 0;
		fim = n;
		meio = (inicio + fim) / 2;
		while (inicio <= fim && achou == 0) {
			if (np == X[meio]) {
				pos = meio;
				achou = 1;
			}
			else {
				if (np < X[meio]) {
					fim = meio - 1;
				}
				else {
					inicio = meio + 1;
				}
				meio = (inicio + fim) / 2;
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
