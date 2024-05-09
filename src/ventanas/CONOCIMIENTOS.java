

package VENTANAS;
import CLASES.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import CLASES.*;
import EXCEP.*;
import GESQL.*;

public class CONOCIMIENTOS extends JFrame {
	Gestor bd = new Gestor();
	EMPRESAS emp=new EMPRESAS();
  JLabel LCONOCIMIENTOS = new JLabel();
  JLabel LCODIGO = new JLabel();
  JTextField TCODIGO = new JTextField();
  JLabel LNOMCON = new JLabel();
  JTextField TCONOCIMIENTO = new JTextField();
  JButton BCANCELAR = new JButton();
  JButton BACEPTAR = new JButton();

  public CONOCIMIENTOS(Gestor con, EMPRESAS empresa) {
    try  {
		bd=con;
		emp=empresa;
      jbInit(bd, emp);
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit(Gestor bd, EMPRESAS emp) throws Exception {
    LCONOCIMIENTOS.setFont(new java.awt.Font("Serif", 0, 28));
    LCONOCIMIENTOS.setText("Conocimientos");
    LCONOCIMIENTOS.setBounds(new Rectangle(71, 6, 179, 48));
    this.getContentPane().setLayout(null);
    LCODIGO.setText("Codigo");
    LCODIGO.setBounds(new Rectangle(32, 83, 53, 25));
    TCODIGO.setBounds(new Rectangle(103, 83, 141, 28));
    LNOMCON.setText("Conocimiento");
    LNOMCON.setBounds(new Rectangle(11, 145, 88, 29));
    TCONOCIMIENTO.setBounds(new Rectangle(101, 142, 203, 24));
    BCANCELAR.setText("Cancelar");
    BCANCELAR.setBounds(new Rectangle(185, 204, 94, 34));
    BCANCELAR.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        BCANCELAR_actionPerformed(e);
      }
    });
    BACEPTAR.setText("Aceptar");
    BACEPTAR.setBounds(new Rectangle(48, 205, 90, 34));
    BACEPTAR.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        BACEPTAR_actionPerformed(e);
      }
    });
    this.getContentPane().setBackground(Color.white);
    this.getContentPane().add(LCONOCIMIENTOS, null);
    this.getContentPane().add(LCODIGO, null);
    this.getContentPane().add(TCODIGO, null);
    this.getContentPane().add(LNOMCON, null);
    this.getContentPane().add(TCONOCIMIENTO, null);
    this.getContentPane().add(BACEPTAR, null);
    this.getContentPane().add(BCANCELAR, null);
            this.setSize(330,275);

  }

  void BACEPTAR_actionPerformed(ActionEvent e) {
	CONOCIMIENTO con = new CONOCIMIENTO();
	//System.out.println(con.getNOMBRE()+con.getCODCONOC());
	boolean letr = false;
	try{
	   con.vacio("Codigo",TCODIGO.getText());
	   int i=con.nums("Codigo",TCODIGO.getText());
	   con.setCODCONOC(i);
	   con.vacio("Conocimiento",TCONOCIMIENTO.getText());
	   con.setNOMBRE(TCONOCIMIENTO.getText());
	   bd.consultarConocimiento(i);
	   letr=true;
		
	}
	catch(VACIOException h){ //Para los vacio
	     h.getError();
	}
	catch(NUMSException f){ //Para las excepciones de numeros
	    f.getError();
	}
	catch (ExisteConocimientoException es){//Por si existe el usuario
	   es.getError();
    }
	if (letr){
	   this.dispose();
	   this.hide();
	   bd.InsertarConocimiento(con);
       this.hide();
	   OFERTAS o=new OFERTAS(bd,emp);
	   o.show();
	   this.dispose();
	 }
  }

  void BCANCELAR_actionPerformed(ActionEvent e) {
         this.hide();
    OFERTAS j=new OFERTAS(bd,emp);
    j.show();
    this.dispose();
	this.hide();
  }
}                                                                
