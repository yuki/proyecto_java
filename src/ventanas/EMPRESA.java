
package VENTANAS;

import CLASES.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import GESQL.*;
import EXCEP.*;

public class EMPRESA extends JFrame {
  Gestor bd = new Gestor(); 
  JLabel EMPRESA = new JLabel();
  JLabel LNOMBRE = new JLabel();
  JTextField TNOMBRE = new JTextField();
  JLabel LCLAVE = new JLabel();
  JLabel LUSUARIO = new JLabel();
  JTextField TUSUARIO = new JTextField();
  JLabel LCIF = new JLabel();
  JTextField TCIF = new JTextField();
  JLabel LDIRECCION = new JLabel();
  JTextField TDIRECCION = new JTextField();
  JLabel LTELEFONO = new JLabel();
  JTextField TTELEFONO = new JTextField();
  JLabel LMAIL = new JLabel();
  JTextField TMAIL = new JTextField();
  JLabel LPERSONA = new JLabel();
  JTextField TPERSONA = new JTextField();
  JLabel LDESCRIPCION = new JLabel();
  JPasswordField PCLAVE = new JPasswordField();
  JButton BACEPTAR = new JButton();
  JButton BCANCELAR = new JButton();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea TDESCRIPCION = new JTextArea();

  public EMPRESA(Gestor con) {
    try  {
	  bd = con;
      jbInit(bd);
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit(Gestor bd) throws Exception {
    EMPRESA.setFont(new java.awt.Font("Serif", 0, 50));
    EMPRESA.setHorizontalAlignment(SwingConstants.CENTER);
    EMPRESA.setHorizontalTextPosition(SwingConstants.CENTER);
    EMPRESA.setText("DATOS EMPRESA");
    EMPRESA.setBounds(new Rectangle(75, 4, 423, 60));
    this.getContentPane().setLayout(null);
    LNOMBRE.setText("Nombre Empresa");
    LNOMBRE.setBounds(new Rectangle(15, 103, 112, 31));
    TNOMBRE.setBounds(new Rectangle(134, 102, 177, 26));
    LCLAVE.setText("Clave");
    LCLAVE.setBounds(new Rectangle(18, 155, 43, 22));
    LUSUARIO.setText("Nombre Usuario");
    LUSUARIO.setBounds(new Rectangle(19, 205, 101, 24));
    TUSUARIO.setBounds(new Rectangle(138, 198, 175, 27));
    LCIF.setText("CIF");
    LCIF.setBounds(new Rectangle(24, 246, 29, 25));
    TCIF.setBounds(new Rectangle(136, 244, 89, 24));
    LDIRECCION.setText("Direccion");
    LDIRECCION.setBounds(new Rectangle(23, 292, 63, 28));
    TDIRECCION.setBounds(new Rectangle(139, 298, 172, 24));
    LTELEFONO.setBackground(Color.white);
    LTELEFONO.setOpaque(true);
    LTELEFONO.setText("Telefono");
    LTELEFONO.setBounds(new Rectangle(339, 102, 64, 25));
    TTELEFONO.setBounds(new Rectangle(419, 100, 131, 26));
    LMAIL.setText("E-Mail");
    LMAIL.setBounds(new Rectangle(347, 150, 51, 20));
    TMAIL.setBounds(new Rectangle(416, 149, 136, 26));
    LPERSONA.setText("Persona de Contacto");
    LPERSONA.setBounds(new Rectangle(340, 193, 124, 32));
    TPERSONA.setBounds(new Rectangle(464, 195, 88, 28));
    LDESCRIPCION.setText("Descripcion");
    LDESCRIPCION.setBounds(new Rectangle(413, 235, 80, 26));
    PCLAVE.setBounds(new Rectangle(133, 153, 181, 28));
    BACEPTAR.setToolTipText("Presione para introducir sus datos en nuestra base de datos");
    BACEPTAR.setText("Aceptar");
    BACEPTAR.setBounds(new Rectangle(111, 395, 136, 28));
    BACEPTAR.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        BACEPTAR_actionPerformed(e);
      }
    });
    BCANCELAR.setText("Cancelar");
    BCANCELAR.setBounds(new Rectangle(299, 395, 136, 29));
    BCANCELAR.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        BCANCELAR_actionPerformed(e);
      }
    });
    jScrollPane1.setBounds(new Rectangle(374, 270, 230, 99));
    this.getContentPane().setBackground(Color.white);
    this.getContentPane().add(BCANCELAR, null);
    this.getContentPane().add(LNOMBRE, null);
    this.getContentPane().add(LCLAVE, null);
    this.getContentPane().add(LUSUARIO, null);
    this.getContentPane().add(LDIRECCION, null);
    this.getContentPane().add(LCIF, null);
    this.getContentPane().add(TCIF, null);
    this.getContentPane().add(TDIRECCION, null);
    this.getContentPane().add(TUSUARIO, null);
    this.getContentPane().add(TNOMBRE, null);
    this.getContentPane().add(LTELEFONO, null);
    this.getContentPane().add(TTELEFONO, null);
    this.getContentPane().add(LMAIL, null);
    this.getContentPane().add(TMAIL, null);
    this.getContentPane().add(LPERSONA, null);
    this.getContentPane().add(TPERSONA, null);
    this.getContentPane().add(PCLAVE, null);
    this.getContentPane().add(LDESCRIPCION, null);
    this.getContentPane().add(BACEPTAR, null);
    this.getContentPane().add(EMPRESA, null);
    this.getContentPane().add(jScrollPane1, null);
    jScrollPane1.getViewport().add(TDESCRIPCION, null);
            this.setSize(625,470);
  }

  void BACEPTAR_actionPerformed(ActionEvent e) {
    //Creamos un objeto de tipo empresas e introducimos los datos
    EMPRESAS emp=new EMPRESAS();
	boolean letr = false;
    boolean user = false;
	try{
	   emp.vacio("Nombre", TNOMBRE.getText());
       	   emp.setnombre(TNOMBRE.getText());
	   String pass = new String (PCLAVE.getPassword());
           emp.vacio("Clave",pass);
	   emp.setclave(pass);
	   emp.vacio("Usuario",TUSUARIO.getText());
           emp.setusuario(TUSUARIO.getText());
	   emp.vacio("CIF",TCIF.getText());
	   int i=emp.nums("CIF",TCIF.getText());
	   emp.setcif(i);
	   emp.vacio("Telefono",TTELEFONO.getText());
	   i = emp.nums("Telefono",TTELEFONO.getText());
	   emp.settelefono(i);
	   emp.vacio("Direccion",TDIRECCION.getText());
           emp.setdir(TDIRECCION.getText());
	   emp.setemail(TMAIL.getText());              
           emp.setcontacto(TPERSONA.getText());
           emp.setdesc(TDESCRIPCION.getText());
	   bd.ConsultarUsuario(emp.getusuario(),"empresa","e");
	   bd.ConsultarUsuario(emp.getusuario(),"candidatos","c");
	   letr = true;
    }
	catch(VACIOException es){ //Para los vacio
	   es.getError();
	   //TRATAR ERROR
	}
	catch(NUMSException es){ //Para las excepciones de numeros
	   es.getError();
	   //TRatar error, hay que meter solo numeros.
	}
	catch (ExisteUsuarioException es){
	   es.getError();
    }
	if (letr){
        this.dispose();
        this.setVisible(false);
		user = bd.InsertarEmpresa(emp);
		if (user){
            this.setVisible(false);
			GESTION_EMPRESAS E=new GESTION_EMPRESAS(bd,emp);
            E.setVisible(true);
			this.dispose();
	    }
		else{
		    this.setVisible(false);
			ventanainicial v=new ventanainicial(bd);
			v.setVisible(true);
			this.dispose();
	    }
	}
  }

  void BCANCELAR_actionPerformed(ActionEvent e) {
    this.setVisible(false);
    ventanainicial v=new ventanainicial(bd);
    v.setVisible(true);
    this.dispose();
  }
}
