package lista1;

public class MinFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int X[] = {58, 19, 47, 6, 14, 58, 16, 46, 48, 21};
		int menor = calculaMenor(X, X.length);
		System.out.println("O menor valor do vetor X é: " + menor);
	}
	
	private static int calculaMenor(int X[], int n) {
		int i, menor;
		
		menor = X[0];
		
		for(i = 0; i < n; i++) {
			
			if (X[i] < menor)
				menor = X[i]; 
		}
		
		return menor;
	}

}
