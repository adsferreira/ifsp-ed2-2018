package prova2;

import java.util.Scanner;

import hash.HashAbertoQuadratica.hash;

public class HashAbertoQuadratica {
	public static class hash {
		int chave;
		String tipo;
		String descricao;
		char livre; // L = livre, O = ocupado, R = removido
	}

	static int tam = 37;
	static hash tabela[] = new hash[tam];

	public static void inserir(int n, String tipo, String descricao) {
		int pos = funcao_hashing(n);
		int k = 1;
		while (k <= tam && tabela[pos].livre != 'L' && tabela[pos].livre != 'R') {
			pos = (pos + k) % tam;
			k++;
		}

		if (k <= tam) {
			tabela[pos].chave = n;
			tabela[pos].tipo = tipo;
			tabela[pos].descricao = descricao;
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

		while (k <= tam && tabela[pos].livre != 'L' && tabela[pos].chave != n) {
			pos = (pos + k) % tam;
			k++;
		}

		if (tabela[pos].chave == n && tabela[pos].livre != 'R')
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
				System.out.println("Entrada " + i + ": " + tabela[i].tipo + " " + tabela[i].descricao);
		}
	}
	
	static void consultarProdutoPorTipo(int chave) {
		int temProduto = -1;
		for (int i = 0; i < tam; i++) {
			if (tabela[i].chave == chave && tabela[i].livre == 'O') {
				System.out.println("Entrada " + i + ": " + tabela[i].tipo + " " + tabela[i].descricao);
				temProduto = 1;
			}
		}
		
		if (temProduto == -1) System.out.println("Não há produtos cadastrados deste tipo.\n");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int op, chave;
		String tipo, descricao;
		Scanner entrada = new Scanner(System.in);

		// inicializando a tabela
		for (int i = 0; i < tam; i++) {
			tabela[i] = new hash();
			tabela[i].livre = 'L';
		}

		do {
			System.out.println("MENU");
			System.out.println("1 - Inserir Produto:");
			System.out.println("2 - Consultar todos produtos cadastrados de um tipo");
			System.out.println("3 - Contar quantos produtos estão cadastrados em cada tipo");
			System.out.println("4 - Sair");
			op = entrada.nextInt();

			if (op < 1 || op > 4)
				System.out.println("Opção inválida!");
			else {
				switch (op) {
				case 1:
					entrada.nextLine();
					System.out.println("Digite um o tipo do produto: ");
					tipo = entrada.nextLine();
					System.out.println("Digite a descrição do produto: ");
					descricao = entrada.nextLine();
					chave = (int) tipo.charAt(0);
					inserir(chave, tipo, descricao);
					System.out.println("\n");
					break;
				case 2:
					entrada.nextLine();
					System.out.println("Digite o tipo dos produtos a serem consultados: ");
					tipo = entrada.nextLine();
					chave = (int) tipo.charAt(0);
					consultarProdutoPorTipo(chave);
					System.out.println("\n");
					break;
				case 3:
					mostrar_hash();
					break;
				}

			}

		} while (op != 4);

		entrada.close();
	}

}
