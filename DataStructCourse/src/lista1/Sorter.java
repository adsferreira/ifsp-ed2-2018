package lista1;

public class Sorter {

	public static void bubbleSort1(String[] names, float[] salaries, int attr_to_sort, int asc) {
		int n = names.length;
				
		// perform sorting using salaries
		if (attr_to_sort == 1) {
			if (asc == 1) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n - 1; j++) {
						if (salaries[j] > salaries[j + 1]) {
							swapSalaries(salaries, j, j + 1);
							swapNames(names, j, j + 1);
						}
					}	
				}
				
			} else {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n - 1; j++) {
						if (salaries[j] < salaries[j + 1]) {
							swapSalaries(salaries, j, j + 1);
							swapNames(names, j, j + 1);
						}
					}	
				}
			}
		}
		else {
			int comp;
			for (int i = 0; i < n; i++) {
					for (int j = 0; j < n - 1; j++) {
						comp = names[j].compareTo(names[j + 1]);
						if (comp > 0) {
							swapNames(names, j, j + 1);
							swapSalaries(salaries, j, j + 1);
						}
					}
			}
		}
	}
	
	public static void bubbleSort2(String[] names, float[] salaries, int attr_to_sort, int asc) {
		int n = names.length;
		
		// perform sorting using salaries
		if (attr_to_sort == 1) {
			if (asc == 1) {
				for(int i = 1; i < n; i++) {
					for(int j = (n - 1); j >= i; j--) { 
						if (salaries[j] < salaries[j - 1]) {
							swapSalaries(salaries, j, j - 1);
							swapNames(names, j, j - 1);
						}
					}
				}
			} else {
				for(int i = 1; i < n; i++) {
					for(int j = (n - 1); j >= i; j--) { 
						if (salaries[j] > salaries[j - 1]) {
							swapSalaries(salaries, j, j - 1);
							swapNames(names, j, j - 1);
						}
					}
				}
			}
		} else {
			int comp;
			for(int i = 1; i < n; i++) {
				for(int j = (n - 1); j >= i; j--) { 
					comp = names[j].compareTo(names[j - 1]);
					if (comp < 0) {
						swapNames(names, j, j - 1);
						swapSalaries(salaries, j, j - 1);
					}
				}
			}
		}
	}
	
	public static void bubbleSort3(String[] names, float[] salaries, int attr_to_sort, int asc) {
		int n = names.length;
		int i = 0;
		int troca = 1;
		
		if (attr_to_sort == 1) {
			if (asc == 1) {
				while(i < n && troca == 1) {
					troca = 0;
					
					for(int j = 0; j < n - 1; j++) {
						if(salaries[j] > salaries[j + 1]) {
							swapSalaries(salaries, j, j + 1);
							swapNames(names, j, j + 1);
						}
					}
					
					i += 1;
				}
			} else {
				while(i < n && troca == 1) {
					troca = 0;
					
					for(int j = 0; j < n - 1; j++) {
						if(salaries[j] < salaries[j + 1]) {
							swapSalaries(salaries, j, j + 1);
							swapNames(names, j, j + 1);
						}
					}
					
					i += 1;
				}
			}
		} else {
			int comp;
			while(i < n && troca == 1) {
				troca = 0;				
				for(int j = 0; j < n - 1; j++) {
					comp = names[j].compareTo(names[j + 1]);
					if (comp > 0) {
						swapNames(names, j, j + 1);
						swapSalaries(salaries, j, j + 1);
					}
				}
			}
		}
	}
	
	private static void swapNames(String names[], int pos1, int pos2) {
		String aux;
		aux = names[pos1];
		names[pos1] = names[pos2];
		names[pos2] = aux;
	}
	
	private static void swapSalaries(float salaries[], int pos1, int pos2) {
		float aux;
		aux = salaries[pos1];
		salaries[pos1] = salaries[pos2];
		salaries[pos2] = aux;
	}
}
