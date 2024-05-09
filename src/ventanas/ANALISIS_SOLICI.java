
package VENTANAS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import CLASES.*;
import EXCEP.*;
import GESQL.*;

public class ANALISIS_SOLICI extends JFrame {
 	Gestor bd = new Gestor();
	EMPRESAS emp=new EMPRESAS();

  JLabel LTIT = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTable TSOLICITUDES;//= new JTable();
  JButton BVOLVER = new JButton();
  Object[] data;
  Object[][] lin;

  public ANALISIS_SOLICI(Gestor con, EMPRESAS empresa) {
    try  {
		 	bd=con;
			emp=empresa;
			jbInit(bd,emp);
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit(Gestor bd, EMPRESAS emp) throws Exception {
    data = new Object[2];
  data[0]="Cod. Oferta";
  data[1]="nº candidatos";
  lin=bd.SacarSolicitud(emp.getusuario());
    LTIT.setFont(new java.awt.Font("Serif", 0, 40));
    LTIT.setText("ANALISIS DE SOLICITUDES");
    LTIT.setBounds(new Rectangle(21, 26, 526, 68));
    this.getContentPane().setBackground(Color.white);
    this.getContentPane().setLayout(null);
    jScrollPane1.getViewport().setBackground(Color.white);
    jScrollPane1.setBounds(new Rectangle(93, 117, 345, 182));
    BVOLVER.setText("VOLVER");
    BVOLVER.setBounds(new Rectangle(233, 350, 170, 34));
    BVOLVER.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        BVOLVER_actionPerformed(e);
      }
    });
    this.getContentPane().add(LTIT, null);
    this.getContentPane().add(jScrollPane1, null);
    this.getContentPane().add(BVOLVER, null);
    jScrollPane1.getViewport().add(TSOLICITUDES, null);
    this.setSize(540,400);
  }
 /* public static void main(String args[])
  {
  ANALISIS_SOLICI V=new ANALISIS_SOLICI();
  V.show();	
  	
  }*/

  void BVOLVER_actionPerformed(ActionEvent e) {
     GESTION_EMPRESAS g = new GESTION_EMPRESAS(bd,emp);
     g.show();
     this.hide();
     this.dispose();
  }
}
