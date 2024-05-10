package excep;

import javax.swing.JOptionPane;

public class NOExisteUsuarioException extends Exception {
    String u;

    public NOExisteUsuarioException(String user) {
        u = user;
    }

    public void getError() {
        JOptionPane j = new JOptionPane();
        j.showMessageDialog(null, "No existe el usuario '" + u + "' \n con el password indicado", "Error de usuario",
                JOptionPane.ERROR_MESSAGE);
    }

}