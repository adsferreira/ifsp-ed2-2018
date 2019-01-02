/**
 * 
 */
package lista1;

import java.io.IOException;
import java.util.Scanner;
import lista1.Employees;
import lista1.Sorter;

/**
 * @author adriano
 *
 */


public class EmployeeSort {
	
	private static int showMainMenu(Scanner entrada) {
		System.out.println("-----------------------------------------------------");
		System.out.println("Escolha o algoritmo de ordenação: ");
		System.out.println("1 para Bubble Sort primeira versão;");
		System.out.println("2 para Bubble Sort segunda versão;");
		System.out.println("3 para Bubble Sort terceira versão;");
		System.out.println("4 para Selection Sort;");
		System.out.println("5 para Merge Sort;");
		System.out.println("6 para Quick Sort;");
		System.out.println("0 para sair do programa.");
		
		int options = entrada.nextInt();
		
		return options;
	}
	
	private static int showFieldsToOrderOption(Scanner entrada) {
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Para ordenar por salário, digite 1.");
		System.out.println("Para ordenar por nome, digite 2.");
		
		int options = entrada.nextInt();
		
		return options;
	}
	
	private static int showSortingOrderMenu(Scanner entrada) {
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Para ordem crescente, digite 1.");
		System.out.println("Para ordem decrescente, digite 2.");
		
		int options = entrada.nextInt();
		
		return options;
	}
	
	private static void printSortedOutputs(String[] names, float[] salaries) {
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Lista de funcionários ordenada: ");
		System.out.println("-----------------------------------------------------\n");
		// imprimi os nomes e salários dos funcionários cadastrados
		for(int i = 0; i < names.length; i++) {
			System.out.println("Nome: " + names[i] + " - Salário: " + salaries[i]);
		}
		
		System.out.println("\n-----------------------------------------------------");
	}
	
	

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int options, choice_attr, choice_asc, n = 3;
		String[] names = new String[n];
		float[] salaries = new float[n];
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("-----------------------------------------------------");
		System.out.println("CADASTRO DE FUNCIONÁRIOS");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		
		// recebe do usuário o nome e salário de cada funcionário
		for(int i = 0; i < n; i++) {
			System.out.print("Entre com o nome do " + (i + 1) + " funcionário: ");
			names[i] = entrada.nextLine();
			System.out.print("Entre com o salário do funcionário " + names[i] + ": ");
			salaries[i] = entrada.nextFloat();
			entrada.nextLine();
			System.out.println("\n-----------------------------------------------------");
			
		}
		
		Employees employees = new Employees(names, salaries);
		
		options = showMainMenu(entrada);
		
		while(options != 0) {
			switch(options) {
			case 0:
				break;
			case 1:
				choice_attr = showFieldsToOrderOption(entrada);
				if(choice_attr == 1) {
					choice_asc = showSortingOrderMenu(entrada);
					Sorter.bubbleSort1(employees.getNames(), employees.getSalaries(), choice_attr, choice_asc);
					printSortedOutputs(employees.getNames(), employees.getSalaries());
					options = showMainMenu(entrada);
				} else {
					Sorter.bubbleSort1(employees.getNames(), employees.getSalaries(), choice_attr, 0);
					printSortedOutputs(employees.getNames(), employees.getSalaries());
					options = showMainMenu(entrada);
				}
				break;
			case 2:
				choice_attr = showFieldsToOrderOption(entrada);
				if(choice_attr == 1) {
					choice_asc = showSortingOrderMenu(entrada);
					Sorter.bubbleSort2(employees.getNames(), employees.getSalaries(), choice_attr, choice_asc);
					printSortedOutputs(employees.getNames(), employees.getSalaries());
					options = showMainMenu(entrada);
				} else {
					Sorter.bubbleSort2(employees.getNames(), employees.getSalaries(), choice_attr, 0);
					printSortedOutputs(employees.getNames(), employees.getSalaries());
					options = showMainMenu(entrada);
				}
				break;
			case 3:
				choice_attr = showFieldsToOrderOption(entrada);
				if(choice_attr == 1) {
					choice_asc = showSortingOrderMenu(entrada);
					Sorter.bubbleSort3(employees.getNames(), employees.getSalaries(), choice_attr, choice_asc);
					printSortedOutputs(employees.getNames(), employees.getSalaries());
					options = showMainMenu(entrada);
				} else {
					Sorter.bubbleSort3(employees.getNames(), employees.getSalaries(), choice_attr, 0);
					printSortedOutputs(employees.getNames(), employees.getSalaries());
					options = showMainMenu(entrada);
				}
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
				
			}			
		}
		
		entrada.close();
	}
}
