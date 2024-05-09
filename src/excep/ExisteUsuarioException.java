package EXCEP;
import javax.swing.JOptionPane;


public class  ExisteUsuarioException extends Exception{
String u = "";
    public  ExisteUsuarioException(String user){
	u=user;
    }
	public void getError(){
		JOptionPane j = new JOptionPane();
		j.showMessageDialog(null,"El usuario '"+u+"' \n ya existe, introduzca otro nombre de usuario","Error nombre de usuario",JOptionPane.ERROR_MESSAGE);
	}
	
}