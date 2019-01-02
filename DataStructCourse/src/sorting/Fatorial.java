package sorting;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Fatorial {
	
	public static int fatorial(int num) {
		/**
		 * Este é o caso base, se o número passado por parametro for 0 ou 1, ele
		 * retorna o resultado 1 e finaliza o método.
		 */
		if (num <= 1) {

			return 1;

		} else {

			/**
			 * chama o método fatorial novamente, mas dessa vez enviando como
			 * parametro (n - 1).
			 */

			return fatorial(num - 1) * num;

		}
	}

	public static void main(String[] args) {
		
		int n = 10;
		int X[] = new int[n]; 
		Random gerador = new Random(); 
		for (int i = 0; i < n; i++) { 
			X[i] = gerador.nextInt(); 
		}
		
		System.out.print(Arrays.toString(X));
		// TODO Auto-generated method stub

		//Declara uma variável para guardar o número que o usuário digitar
        int numero;

        //Instancia um objeto da classe Scanner para realizar a leitura do teclado (System.in)
        Scanner entrada = new Scanner(System.in);

        //Imprime na saída
        System.out.println("Digite o número que você pretende obter o fatorial.");
        
        /**Aqui a variável 'numero' irá receber a entrada que o usuário digitar.
         * A minha instancia de Scanner, no caso 'entrada', utilizará o método nextInt()
         * para ler o que vier do teclado como sendo um int.
         */
        numero = entrada.nextInt();
        entrada.close();
        //imprime o resultado do fatorial
        System.out.println("O fatorial de " + numero + " é " + fatorial(numero) + ".");
	}

}
