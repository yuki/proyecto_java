

package VENTANAS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;import CLASES.*;
import GESQL.*;


public class GESTION_CANDIDATOS extends JFrame {
  Gestor bd = new Gestor();
  CANDIDATOS can=new CANDIDATOS();
  JLabel TGestionCandidat = new JLabel();
  JButton LBuscarOfertas = new JButton();
  JButton BConsulta = new JButton();
  JButton BActualizacion = new JButton();
  JButton BCANCEL = new JButton();
  JButton BCONOCIMIENTOS = new JButton();

  public GESTION_CANDIDATOS(Gestor con,CANDIDATOS candidato) {
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
    TGestionCandidat.setFont(new java.awt.Font("Serif", 0, 40));
    TGestionCandidat.setHorizontalAlignment(SwingConstants.CENTER);
    TGestionCandidat.setText("Gestion de candidatos");
    TGestionCandidat.setBounds(new Rectangle(18, 14, 504, 58));
    this.getContentPane().setLayout(null);
    LBuscarOfertas.setToolTipText("Busque ofertas de empleo");
    LBuscarOfertas.setText("Buscar ofertas de empleo");
    LBuscarOfertas.setBounds(new Rectangle(18, 109, 230, 49));
    LBuscarOfertas.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        LBuscarOfertas_actionPerformed(e);
      }
    });
    BConsulta.setToolTipText("Consulte sus solicitudes enviadas");
    BConsulta.setText("Consulta tus solicitudes");
    BConsulta.setBounds(new Rectangle(300, 110, 232, 48));
    BConsulta.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        BConsulta_actionPerformed(e);
      }
    });
    BActualizacion.setToolTipText("Modifique los datos de su curriculum");
    BActualizacion.setText("Actualiza tu curriculum");
    BActualizacion.setBounds(new Rectangle(19, 227, 231, 47));
    BActualizacion.addActionListener(new java.awt.event.ActionListener()

     {

      public void actionPerformed(ActionEvent e) {
        BActualizacion_actionPerformed(e);
      }
    });
    BCANCEL.setText("VOLVER");
    BCANCEL.setBounds(new Rectangle(177, 336, 188, 52));
    BCANCEL.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        BCANCEL_actionPerformed(e);
      }
    });
    this.getContentPane().setBackground(Color.white);
    BCONOCIMIENTOS.setText("Conoc. mas demandados");
    BCONOCIMIENTOS.setBounds(new Rectangle(303, 227, 232, 49));
    BCONOCIMIENTOS.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        BCONOCIMIENTOS_actionPerformed(e);
      }
    });
    this.getContentPane().add(TGestionCandidat, null);
    this.getContentPane().add(LBuscarOfertas, null);
    this.getContentPane().add(BActualizacion, null);
    this.getContentPane().add(BCANCEL, null);
    this.getContentPane().add(BConsulta, null);
    this.getContentPane().add(BCONOCIMIENTOS, null);
     this.setSize(560,420);

  }

  void BCANCEL_actionPerformed(ActionEvent e) {
    this.setVisible(false);
    ventanainicial v=new ventanainicial(bd);
    v.setVisible(true);
    this.dispose();
  }

  void BActualizacion_actionPerformed(ActionEvent e) {
    this.setVisible(false);
    CANDIDATOAC C=new CANDIDATOAC(bd,can);
    C.setVisible(true);
    this.dispose();
  }

  void LBuscarOfertas_actionPerformed(ActionEvent e) {
    this.setVisible(false);
    BUSQUEDAOFERTAS O=new BUSQUEDAOFERTAS(bd,can);
    O.setVisible(true);
    this.dispose();
  }

  void BConsulta_actionPerformed(ActionEvent e) {
    this.setVisible(false);
    CONSULTASOLICITUDES S=new CONSULTASOLICITUDES(bd,can);
    S.setVisible(true);
    this.dispose();
  }

  void BCONOCIMIENTOS_actionPerformed(ActionEvent e) {
      DEMANDACONOC d = new DEMANDACONOC(bd,can);
      d.setVisible(true);
      this.setVisible(false);
      this.dispose();
  }
}
