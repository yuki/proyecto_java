package excep;

import javax.swing.JOptionPane;

public class MAYORException extends Exception {
    String u = "";

    public void getError() {
        JOptionPane j = new JOptionPane();
        j.showMessageDialog(null, "La cantidad de 'sueldo maximo' debe\n debe ser MAYOR que 'sueldo minimo'",
                "Error inserccion de datos", JOptionPane.ERROR_MESSAGE);
    }

}