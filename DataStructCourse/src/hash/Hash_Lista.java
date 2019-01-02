package hash;

import java.util.Scanner;

public class Hash_Lista {
	public static class hash {
		int chave;
		hash prox;
	}

	static int tam = 8;
	static hash tabela[] = new hash[tam];
	static Scanner entrada = new Scanner(System.in);

	public static void inserir(int pos, int n) {
		hash novo = new hash();
		novo.chave = n;
		novo.prox = tabela[pos];
		tabela[pos] = novo;
	}

	static int funcao_hashing(int num) {
		return num % tam;
	}

	static void mostrar_hash() {
		hash aux;

		for (int i = 0; i < tam; i++) {
			aux = tabela[i];

			while (aux != null) {
				System.out.println("Entrada " + i + ": " + aux.chave);
				aux = aux.prox;
			}
		}
	}

	static void excluir_hash(int num) {
		int pos = funcao_hashing(num);
		hash aux;

		if (tabela[pos] != null) {
			if (tabela[pos].chave == num)
				tabela[pos] = tabela[pos].prox;
			else {
				aux = tabela[pos].prox;
				hash ant = tabela[pos];

				while (aux != null && aux.chave != num) {
					ant = aux;
					aux = aux.prox;
				}
				if (aux != null)
					ant.prox = aux.prox;
				else
					System.out.println("Número não encontrado.");
			}
		} else
			System.out.println("Número não encontrado.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int op, pos;
		int num;

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
					pos = funcao_hashing(num);
					inserir(pos, num);
					break;
				case 2:
					mostrar_hash();
					break;
				case 3:
					System.out.println("Digite um número:");
					num = entrada.nextInt();
					excluir_hash(num);
					break;
				}

			}

		} while (op != 4);
	}

}
