package hash;

import java.util.Scanner;

public class HashAbertoQuadratica {
	public static class hash {
		int chave;
		char livre; // L = livre, O = ocupado, R = removido
	}

	static int tam = 8;
	static hash tabela[] = new hash[tam];
	static Scanner entrada = new Scanner(System.in);

	public static void inserir(int n) {
		int pos = funcao_hashing(n);
		int k = 1;
		while (k <= tam && 
			   tabela[pos].livre != 'L' && 
			   tabela[pos].livre != 'R') {
			pos = (pos + k) % tam;
			k++;
		}

		if (k <= tam) {
			tabela[pos].chave = n;
			tabela[pos].livre = 'O';
		} else {
			System.out.println("Tabela cheia ou em loop!");
		}
	}

	public static void remover(int n) {
		int pos = buscar(n);

		if (pos < tam)
			tabela[pos].livre = 'R';
		else
			System.out.println("Elemento não está presente.");
	}

	public static int buscar(int n) {
		int pos = funcao_hashing(n);
		int k = 1;

		while (k <= tam && 
			   tabela[pos].livre != 'L' && 
			   tabela[pos].chave != n) {
			pos = (pos + k) % tam;
			k++;
		}

		if (tabela[pos].chave == n && 
			tabela[pos].livre != 'R')
			return pos;
		else
			return tam; // não encontado
	}

	static int funcao_hashing(int n) {
		return n % tam;
	}

	static void mostrar_hash() {
		for (int i = 0; i < tam; i++) {
			if (tabela[i].livre == 'O')
				System.out.println("Entrada " + i + ": " + tabela[i].chave + " " + tabela[i].livre);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int op, num, i;

		// inicializando a tabela
		for (i = 0; i < tam; i++) {
			tabela[i] = new hash();
			tabela[i].livre = 'L';
		}

		do {
			System.out.println("\nMENU DE OPÇÕES\n");
			System.out.println("1 - Inserir elemento");
			System.out.println("2 - Mostrar tabela hashing");
			System.out.println("3 - Excluir elemento");
			System.out.println("4 - Sair");
			System.out.println("Digite sua opção: ");

			op = entrada.nextInt();

			if (op < 1 || op > 4)
				System.out.println("Opção inválida!");
			else {
				switch (op) {
				case 1:
					System.out.println("Digite um número:");
					num = entrada.nextInt();
					inserir(num);
					break;
				case 2:
					mostrar_hash();
					break;
				case 3:
					System.out.println("Digite um número:");
					num = entrada.nextInt();
					remover(num);
					break;
				}

			}
			
		} while (op != 4);
	}
}