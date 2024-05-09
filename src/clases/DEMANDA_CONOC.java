package CLASES;

public class DEMANDA_CONOC {
	private String nom_con;
	private int cont;
	
	public  DEMANDA_CONOC () {
		nom_con = "";
		cont = 0;
	}
	
	public void setnom (String n) {
		nom_con = new String (n); }
		
	public void setcont (int k) {
		cont = k; }
		
	public String getnom () {
		return this.nom_con; }
		
	public int getcont () {
		return this.cont; }
}
	
