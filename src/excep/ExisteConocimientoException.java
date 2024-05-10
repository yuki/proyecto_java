package excep;

import javax.swing.JOptionPane;

public class ExisteConocimientoException extends Exception {
    int u = 0;

    public ExisteConocimientoException(int con) {
        u = con;
    }

    public void getError() {
        JOptionPane j = new JOptionPane();
        j.showMessageDialog(null, "El conocimiento con codigo " + u + " \n ya existe, introduzca otro codigo",
                "Error codigo conocimiento", JOptionPane.ERROR_MESSAGE);
    }

}