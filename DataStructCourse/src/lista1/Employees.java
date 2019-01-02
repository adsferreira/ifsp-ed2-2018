package lista1;

public class Employees {
	private float[] salaries;
	private String[] names;
	
	public Employees(int nrEmployees) {
		names = new String[nrEmployees];
		salaries = new float[nrEmployees];
	}
	
	public Employees(String[] names, float[] salaries) {
		this.names = names;
		this.salaries = salaries;
	}
	
	public float[] getSalaries() {
		return salaries;
	}
	
	public void setSalaries(float[] salaries) {
		this.salaries = salaries;
	}
	
	public String[] getNames() {
		return names;
	}
	
	public void setNames(String[] names) {
		this.names = names;
	}
}
