package EXCEP;

import javax.swing.JOptionPane;

public class  FECHAException extends Exception{
int i=0;
    public FECHAException(int cual){
	i=cual;
    }
	public void getError(){
		JOptionPane j = new JOptionPane();
		switch (i){
			case 1:	j.showMessageDialog(null,"El campo 'dia' debe estar entre 1 y 31","Error en FECHA",JOptionPane.ERROR_MESSAGE);
					break;
			case 2:	j.showMessageDialog(null,"El campo 'mes' debe estar entre 1 y 12","Error en FECHA",JOptionPane.ERROR_MESSAGE);
					break;
			case 3:	j.showMessageDialog(null,"Debe tener entre 16 y 50 años e introducir\n el año en formato '19xx'","Error en FECHA",JOptionPane.ERROR_MESSAGE);
					break;
		}
	}
	
}