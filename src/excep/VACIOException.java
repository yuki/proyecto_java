package EXCEP;
import javax.swing.JOptionPane;


public class  VACIOException extends Exception{
String u;
    public  VACIOException(String nom){
	u=nom;
    }
	public void getError(){
		JOptionPane j = new JOptionPane();
		j.showMessageDialog(null,"El campo '"+u+"' no puede estar vacio\n Introduzca datos en '"+u+"'","Error inserccion de datos",JOptionPane.ERROR_MESSAGE);
	}
	
}