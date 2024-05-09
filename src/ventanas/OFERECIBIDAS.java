

package VENTANAS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import CLASES.*;
import GESQL.*;

public class OFERECIBIDAS extends JFrame {
  Gestor bd = new Gestor();
  EMPRESAS emp=new EMPRESAS();
  JLabel LRECIBIDO = new JLabel();
  //JLabel LCANDIDATOS = new JLabel();
  //JButton BVer = new JButton();
  JButton BCancelar = new JButton();
  JButton MIRAR = new JButton();
  JScrollPane jScrollPane1 = new JScrollPane();
  //JScrollPane jScrollPane2 = new JScrollPane();
  JTable TABLA1;// = new JTable();
  Object[] data1;
  Object[][] lin1;

  public OFERECIBIDAS(Gestor con, EMPRESAS empresa) {
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
	  data1 = new Object[2];
	  data1[0]="cod. oferta";
	 data1[1]="titulo";
	  lin1 = bd.ConsultarCodOferta(emp.getusuario());
	  TABLA1 = new JTable (lin1,data1);
    LRECIBIDO.setFont(new java.awt.Font("Serif", 0, 40));
    LRECIBIDO.setText("Sus ofertas");
    LRECIBIDO.setBounds(new Rectangle(193, 31, 436, 87));
    this.getContentPane().setLayout(null);
    //LCANDIDATOS.setText("Solicitudes");
    //LCANDIDATOS.setBounds(new Rectangle(390, 165, 154, 27));
    //BVer.setToolTipText("Vea el curriculum del candidato selecionado");
    //BVer.setText("Ver candidato");
    //BVer.setBounds(new Rectangle(67, 388, 154, 47));
    //BVer.addActionListener(new java.awt.event.ActionListener() {

      //public void actionPerformed(ActionEvent e) {
       // BVer_actionPerformed(e);
     // }
   // });
    BCancelar.setText("Cancelar");
    BCancelar.setBounds(new Rectangle(376, 435, 154, 49));
    BCancelar.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        BCancelar_actionPerformed(e);
      }
    });
    this.getContentPane().setBackground(Color.white);
    MIRAR.setText("Ver Solicitudes");
    MIRAR.setBounds(new Rectangle(72, 437, 154, 47));
    MIRAR.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        MIRAR_actionPerformed(e);
      }
    });
    jScrollPane1.setBounds(new Rectangle(163, 220, 273, 142));
    //jScrollPane2.setBounds(new Rectangle(386, 216, 159, 132));
    //this.getContentPane().add(BVer, null);
    this.getContentPane().add(jScrollPane1, null);
    this.getContentPane().add(MIRAR, null);
    this.getContentPane().add(BCancelar, null);
    this.getContentPane().add(LRECIBIDO, null);
    jScrollPane1.getViewport().add(TABLA1, null);
    //this.getContentPane().add(jScrollPane2, null);
   // jScrollPane2.getViewport().add(TABLA2, null);
    //this.getContentPane().add(LCANDIDATOS, null);
      this.setSize(625,497);
  }

  void BCancelar_actionPerformed(ActionEvent e) {
    this.hide();
    GESTION_EMPRESAS E=new GESTION_EMPRESAS(bd,emp);
    E.show();
    this.dispose();
  }

  void MIRAR_actionPerformed(ActionEvent e) {
	int n = TABLA1.getSelectedRow();
	if (n!=-1){
		String i = TABLA1.getValueAt(n,0).toString();
		Integer k = Integer.valueOf(i);//tenemos el codigo de la oferta
		ELEGIRSOL el = new ELEGIRSOL(bd,emp,k.intValue());
		this.hide();
		el.show();
		this.dispose();
	}
	else{
	    JOptionPane j = new JOptionPane();
            j.showMessageDialog(null,"Debe seleccionar una de sus ofertas publicadas\nPinche sobre una oferta en la tabla","Error, seleccione oferta",JOptionPane.ERROR_MESSAGE);
	}
	
  }
  void BVer_actionPerformed(ActionEvent e) {

  }
} 
