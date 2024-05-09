package EXCEP;
import javax.swing.JOptionPane;


public class  NUMSException extends Exception{
String u =  "";
    public  NUMSException(String user){
	u=user;
    }
	public void getError(){
		JOptionPane j = new JOptionPane();
		j.showMessageDialog(null,"El campo '"+u+"' solo acepta numeros\n Introduzca SOLO numeros","Error inserccion de datos",JOptionPane.ERROR_MESSAGE);
	}
	
}