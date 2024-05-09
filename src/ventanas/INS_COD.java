

package VENTANAS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import CLASES.*;
import GESQL.*;


public class INS_COD extends JFrame {
   Gestor bd = new Gestor();
   CANDIDATOS can=new CANDIDATOS();
   SOLICITUD sol=new SOLICITUD();
  JLabel linser = new JLabel();
  JTextField TSOLICI = new JTextField();
  JButton BINSERTAR = new JButton();
  JButton BVOL = new JButton();

  public INS_COD(Gestor con,CANDIDATOS candidato,SOLICITUD solicitud) {
    try  {
     bd=con;
	  can=candidato;
    sol=solicitud;
      jbInit(bd,can);
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit(Gestor bd, CANDIDATOS can) throws Exception {
    linser.setFont(new java.awt.Font("Dialog", 1, 15));
    linser.setToolTipText("Introducca el codigo de la solicitud que quiera insertar");
    linser.setText("Introducir codigo solicitud:");
    linser.setBounds(new Rectangle(45, 57, 226, 45));
    this.getContentPane().setLayout(null);
    TSOLICI.setBounds(new Rectangle(296, 60, 149, 34));
    this.getContentPane().setBackground(Color.white);
    BINSERTAR.setToolTipText("Iserta a la solicitud el codigo introducido");
    BINSERTAR.setText("INSERTAR");
    BINSERTAR.setBounds(new Rectangle(56, 184, 186, 40));
    BINSERTAR.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        BINSERTAR_actionPerformed(e);
      }
    });
    BVOL.setToolTipText("Volver a gestion de candidatos");
    BVOL.setText("VOLVER");
    BVOL.setBounds(new Rectangle(305, 185, 191, 39));
    BVOL.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        BVOL_actionPerformed(e);
      }
    });
    this.getContentPane().add(TSOLICI, null);
    this.getContentPane().add(linser, null);
    this.getContentPane().add(BINSERTAR, null);
    this.getContentPane().add(BVOL, null);
    this.setSize(530,275);
  }

  void BVOL_actionPerformed(ActionEvent e) {
    this.hide();
    this.dispose();
    GESTION_CANDIDATOS c =new GESTION_CANDIDATOS(bd,can);
    c.show();
  }

  void BINSERTAR_actionPerformed(ActionEvent e) {
      //int cod = Integer.parseInt(TSOLICI.getText()).intValue();
      String g = TSOLICI.getText();
      int cod = Integer.parseInt(g);
      sol.setcodigo(cod);
      bd.insertarSolicitud(sol);
      this.hide();
      this.dispose();
      GESTION_CANDIDATOS c =new GESTION_CANDIDATOS(bd,can);
      c.show();
  }
}
