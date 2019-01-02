package trees;

import java.util.Scanner;

public class Arvore_Binaria_NRecursiva3 {
	// definindo a classe que representa
	// cada nó da árvore binária
	private static class No {
		public int num;
		public No dir, esq;
	}
	
	// definindo a classe que representa
	// cada nó da árvore binária na pilha
	private static class Pilha {
		public No num;
		public Pilha prox;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		// a árvore está vazia; logo
		// o objeto raiz tem o valor null
		No raiz = null;
		// objeto auxiliar 1
		No aux;
		// objeto auxiliar 2
		No aux1;
		// o objeto novo também é auxiliar
		No novo;
		// o objeto anterior é também auxiliar
		No anterior;
		// o objeto topo representa o topo da pilha
		Pilha topo;
		// o objeto aux_pilha é um objeto auxiliar da pilha
		Pilha aux_pilha;
		// apresentando o menu de opções
		int op, achou, numero;
		
		do {
			System.out.println("\nMENU DE OPÇÔES\n");
			System.out.println("1 - Inserir na árvore");
			System.out.println("2 - Consultar um no árvore");
			System.out.println("3 - Consultar toda a árvore em ordem");
			System.out.println("4 - Excluir um nó da árvore");
			System.out.println("5 - Sair");
			System.out.println("Digite sua opção: ");
			op = entrada.nextInt();
			
			if (op < 1 || op > 5)
				System.out.println("Opção inválida!");
			// insere nó
			if (op == 1) {
				System.out.println("Digite o número a ser inserido na árvore: ");
				novo = new No();
				novo.num = entrada.nextInt();
				novo.dir = null;
				novo.esq = null;
				
				if (raiz == null)
					raiz = novo;
				else {
					aux = raiz;
					achou = 0;
					
					// encontrando posicao de inserção
					while (achou == 0) {
						if (novo.num < aux.num) {
							if (aux.esq == null) {
								aux.esq = novo;
								achou = 1;
							}
							else
								aux = aux.esq;
						}
						else if (novo.num >= aux.num) {
							if (aux.dir == null) {
									aux.dir = novo;
									achou = 1;
								}
								else
									aux = aux.dir;
							}
						}
					}
				
				System.out.println("Número " + novo.num + " inserido na árvore");
			}
			// consulta nó
			if (op == 2) {
				if (raiz == null) {
					// a árvore está vazia
					System.out.println("Árvore vazia!");
				}
				else {
					// a árvore contém elementos
					System.out.println("Digite o elemento a ser consultado");
					numero = entrada.nextInt();
					achou = 0;
					aux = raiz;
					
					while (aux != null && achou == 0) {
						if (aux.num == numero) {
							System.out.println("Número encontrado na árvore!");
							achou = 1;
						}
						else if (numero < aux.num)
							aux = aux.esq;
						else
							aux = aux.dir;
					}
					
					if (achou == 0)
						System.out.println("Número não encontrado na árvore!");
				}
			}
			
			if (op == 3) {
				if (raiz == null)
					System.out.println("Árvore vazia!");
			
				else {
					// a árvore contém elementos
					// e estes serão mostrados em ordem
					System.out.println("Listando todos os elementos da árvore em ordem");
					aux = raiz;
					// a pilha, uma estrutura auxiliar, está vazia
					topo = null;
					
					do {
						// caminha na árvore pelo
						// ramo da esquerda até null
						// colocando cada elemento
						// visitado em uma Pilha
						while (aux != null) {
							aux_pilha = new Pilha();
							aux_pilha.num = aux;
							aux_pilha.prox = topo;
							topo = aux_pilha;
							aux = aux.esq;
						}
						
						if (topo != null) {
							aux_pilha = topo;
							System.out.print(aux_pilha.num.num + " ");
							aux = topo.num.dir;
							topo = topo.prox;
						}
					} while (topo != null || aux != null);
				}
			}
				
			if (op == 4) {
				if (raiz == null)
					System.out.println("Árvore vazia!!");
				else {
					System.out.println("Digite o número que deseja excluir");
					numero = entrada.nextInt();
					aux = raiz;
					achou = 0;
					
					// busca o nó que possui o número escolhido 
					// para ser excluído da árvore
					// caso encontre, atribui ao objeto aux
					while (achou == 0 && aux != null) {
						if (aux.num == numero)
							achou = 1;
						else if (aux.num > numero) 
							// o número está à esquerda da árvore
							aux = aux.esq;
						else
							// o número está à direita da árvore
							aux = aux.dir;
					}
					
					// se nenhum nó possui número que se deseja excluir
					// imprimi mensagem de não encontrado
					if (achou == 0)
						System.out.println("Número não encontrado");
					else {
						if (aux != raiz) {
							// o número foi encontrado,
							// será excluído e não é a raiz
							// é necessário encontrar o anterior
							// para acertar os ponteiros
							// anterior = elemento que aponta
							// para o número a ser excluído
							anterior = raiz;
							// encontrando o anterior
							while (anterior.dir != aux && anterior.esq != aux) {
								if (anterior.num > numero)
									// o número está à esquerda da árvore
									anterior = anterior.esq;
								else
									// o número está à direita da árvore
									anterior = anterior.dir;
							}
							
							if (aux.dir == null && aux.esq == null) {
								// um número folha será excluído
								if (anterior.dir == aux)
									anterior.dir = null;
								else
									anterior.esq = null;
							}
							else {
								// um número não folha
								// será excluído
								if (aux.dir != null && aux.esq == null) {
									// um número que possui filhos
									// apenas para a direita
									if (anterior.esq == aux)
										anterior.esq = aux.dir;
									else
										anterior.dir = aux.dir;
								}
								else if (aux.esq != null && aux.dir == null) {
									// um número que possui filhos
									// apenas para a esquerda
									if (anterior.esq == aux)
										anterior.esq = aux.esq;
									else
										anterior.dir = aux.esq;
								}
								else if (aux.esq != null && aux.dir != null) {
									// um numero que possui filhos
									// para a esquerda e para a direita
									if (anterior.dir == aux) {
										anterior.dir = aux.dir;
										aux1 = aux.esq;
									}
									else {
										anterior.esq = aux.esq;
										aux1 = aux.dir;
									}
									// recolocando o pedaço da árvore
									aux = anterior;
									
									while (aux != null) {
										if (aux.num < aux1.num) {
											if (aux.dir == null) {
												aux.dir = aux1;
												aux = null;
											}
											else
												aux = aux.dir;
										}
										else if (aux.num > aux1.num) {
											if (aux.esq == null) {
												aux.esq = aux1;
												aux = null;
											}
											else
												aux = aux.esq;
										}
									}		
								}
							}
						}
						else {
							if (aux.dir == null && aux.esq == null) {
								// a raiz não tem filhos e será excluída
								raiz = null;
							}
							else {
								if (aux.dir != null && aux.esq == null) {
									// a raiz será excluída
									// e possui filhos
									// apenas à direita
									raiz = aux.dir;
								}
								else if (aux.esq != null && aux.dir == null) {
									// a raiz será excluída
									// e possui filhos apenas à esquerda
									raiz = aux.esq;
								}
								else if (aux.esq != null && aux.dir != null) {
									// a raiz será excluida
									// e possui filhos para a direita
									// e para a esquerda
									raiz = aux.dir;
									aux1 = aux.esq;
									aux = raiz;
									
									while (aux != null) {
										if (aux.num < aux1.num) {
											if (aux.dir == null) {
												aux.dir = aux1;
												aux = null;
											}
											else 
												aux = aux.dir;
										}
										else if (aux.num > aux1.num) {
											if (aux.esq == null) {
												aux.esq = aux1;
												aux = null;
											}
											else aux = aux.esq;
										}
									}
								}
							}
						}
						System.out.println("Número " + numero + " excluído da árvore!");
					}
				}
			}
			
		} while (op != 5);
	}

}
