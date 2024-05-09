
package VENTANAS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import CLASES.*;
import GESQL.*;

public class DEMANDACONOC extends JFrame {
  Gestor bd = new Gestor();
  CANDIDATOS can=new CANDIDATOS();
  JLabel JDEMANDA = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTable CONOCIMIENTOS;// = new JTable();
  JButton JVOLVER = new JButton();
  Object[] data;
  Object[][] lin;

  public DEMANDACONOC(Gestor con,CANDIDATOS candidato) {
    try  {
	  bd=con;
	  can=candidato;
      jbInit(bd,can);
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit(Gestor bd, CANDIDATOS can) throws Exception {
	  this.setSize(560,430);
  data = new Object[3];
  data[1]="Nombre";
  data[2]="nº veces";
  data[0]="Cod";
  lin=bd.ContarConocimientos();
  CONOCIMIENTOS = new JTable(lin,data);
    JDEMANDA.setText("DEMANDA DE CONOCIMIENTOS");
    JDEMANDA.setFont(new java.awt.Font("Dialog", 0, 25));
    JDEMANDA.setBounds(new Rectangle(80, 31, 391, 55));
    this.getContentPane().setBackground(Color.white);
    this.getContentPane().setLayout(null);
    jScrollPane1.setBounds(new Rectangle(40, 93, 473, 203));
    JVOLVER.setText("Volver");
    JVOLVER.setBounds(new Rectangle(181, 354, 166, 48));
    JVOLVER.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        JVOLVER_actionPerformed(e);
      }
    });
    this.getContentPane().add(jScrollPane1, null);
    this.getContentPane().add(JVOLVER, null);
    this.getContentPane().add(JDEMANDA, null);
    jScrollPane1.getViewport().add(CONOCIMIENTOS, null);
  }

  void JVOLVER_actionPerformed(ActionEvent e) {
    this.setVisible(false);
    this.dispose();
    GESTION_CANDIDATOS g = new GESTION_CANDIDATOS(bd,can);
    g.setVisible(true);
  }
}
