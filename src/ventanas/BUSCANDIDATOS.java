
package VENTANAS;

import java.awt.*;
import javax.swing.*;
import java.util.Vector;
import java.awt.event.*;
import CLASES.*;
import GESQL.*;

public class BUSCANDIDATOS extends JFrame {
  Gestor bd = new Gestor();
  EMPRESAS emp=new EMPRESAS();
  JLabel LBUSQUEDA = new JLabel();
  JButton BVer = new JButton();
  JButton BCancelar = new JButton();
  JRadioButton RCARNET = new JRadioButton();
  JRadioButton RCOCHE = new JRadioButton();
  JRadioButton RVIAJAR = new JRadioButton();
  JLabel LCONOCIMIENTOS = new JLabel();
  JScrollPane SCONOCE = new JScrollPane();
  JList LCONOCE = new JList();
  JRadioButton RAND = new JRadioButton();
  JRadioButton LEXPERIENCIA = new JRadioButton();

  public BUSCANDIDATOS(Gestor con, EMPRESAS empresa) {
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
    LBUSQUEDA.setFont(new java.awt.Font("Serif", 0, 50));
    LBUSQUEDA.setHorizontalAlignment(SwingConstants.CENTER);
    LBUSQUEDA.setHorizontalTextPosition(SwingConstants.CENTER);
    LBUSQUEDA.setText("Busqueda de Candidatos");
    LBUSQUEDA.setBounds(new Rectangle(32, 19, 542, 55));
    this.getContentPane().setLayout(null);
    BVer.setText("Ver Oferta");
    BVer.setBounds(new Rectangle(91, 408, 131, 39));
    BCancelar.setText("Cancelar");
    BCancelar.setBounds(new Rectangle(323, 406, 130, 42));
    BCancelar.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        BCancelar_actionPerformed(e);
      }
    });
    this.getContentPane().setBackground(Color.white);
    RCARNET.setBackground(Color.white);
    RCARNET.setText("Debe tener carnet de conducir");
    RCARNET.setBounds(new Rectangle(32, 195, 198, 24));
    RCOCHE.setBackground(Color.white);
    RCOCHE.setText("Debe tener coche propio");
    RCOCHE.setBounds(new Rectangle(32, 224, 184, 21));
    RVIAJAR.setBackground(Color.white);
    RVIAJAR.setText("Debe poder viajar");
    RVIAJAR.setBounds(new Rectangle(32, 249, 202, 21));
    LCONOCIMIENTOS.setText("Conocimientos");
    LCONOCIMIENTOS.setBounds(new Rectangle(352, 170, 106, 24));
    SCONOCE.setBounds(new Rectangle(325, 198, 237, 130));
    RAND.setBackground(Color.white);
    RAND.setText("Busqueda anidada (AND)");
    RAND.setBounds(new Rectangle(204, 355, 208, 30));
    LEXPERIENCIA.setBackground(Color.white);
    LEXPERIENCIA.setText("Experiencia");
    LEXPERIENCIA.setBounds(new Rectangle(31, 160, 173, 38));
    this.getContentPane().add(LCONOCIMIENTOS, null);
    this.getContentPane().add(RCARNET, null);
    this.getContentPane().add(RCOCHE, null);
    this.getContentPane().add(RVIAJAR, null);
    this.getContentPane().add(SCONOCE, null);
    SCONOCE.getViewport().add(LCONOCE, null);
    this.getContentPane().add(LBUSQUEDA, null);
    this.getContentPane().add(BCancelar, null);
    this.getContentPane().add(BVer, null);
    this.getContentPane().add(RAND, null);
    this.getContentPane().add(LEXPERIENCIA, null);
    Vector d=new Vector();
    d.add((Object)"askdhf");
    LCONOCE.setListData(d);
     this.setSize(600,490);
  }

  void BCancelar_actionPerformed(ActionEvent e) {
    this.hide();
    GESTION_EMPRESAS E=new GESTION_EMPRESAS(bd,emp);
    E.show();
    this.dispose();

  }

  public static void main (String[] args){
	Gestor s=new Gestor();
	EMPRESAS e=new EMPRESAS();
	BUSCANDIDATOS b= new BUSCANDIDATOS(s,e);
	b.show();
  }
}
