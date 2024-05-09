
package VENTANAS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Vector;
import CLASES.*;
import GESQL.*;

public class OFERTASENCONTRADAS extends JFrame {
  Gestor bd = new Gestor();
  CANDIDATOS can = new CANDIDATOS();
  //Vector v = new Vector();
  JScrollPane jScrollPane1 = new JScrollPane();
  JLabel TITULO = new JLabel();
  JButton BBUSCAR = new JButton();
  JButton BSOLICITAR = new JButton();
  JTable TOFERTAS; //= new JTable();
  Object[] data;
  Object[][] lin;


  public OFERTASENCONTRADAS(Gestor con, CANDIDATOS candidato, Object[][] v)
  {
   try  {
      bd=con;
      can = candidato;
      lin=v;
      jbInit(bd, can, lin);
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit(Gestor bd, CANDIDATOS cand, Object[][] v) throws Exception {
	  data = new Object[15];
	  data[0]="codigo";
	  data[1]="titulo";
	  data[2]="descr";
	  data[3]="lugar";
	  data[4]="contrato";
	  data[5]="sue-min";
	  data[6]="sue-max";
	  data[7]="experiencia";
	  data[8]="valorara";
	  data[9]="impres";
	  data[10]="dia";
	  data[11]="mes";
	  data[12]="anyo";
	  data[13]="estado";
	  data[14]="user";
	  lin= v;
	TOFERTAS = new  JTable(lin,data);
   this.setSize(725,500);
    this.getContentPane().setLayout(null);
    jScrollPane1.setBounds(new Rectangle(25, 112, 654, 265));
    TITULO.setFont(new java.awt.Font("Serif", 0, 50));
    TITULO.setText("Ofertas encontradas");
    TITULO.setBounds(new Rectangle(57, 26, 471, 56));
    BBUSCAR.setToolTipText("Buscar otra oferta");
    BBUSCAR.setText("Buscar otra oferta");
    BBUSCAR.setBounds(new Rectangle(86, 420, 192, 40));
    BBUSCAR.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        BBUSCAR_actionPerformed(e);
      }
    });
    BSOLICITAR.setToolTipText("Enviar solicitud para esta oferta");
    BSOLICITAR.setText("Enviar solicitud");
    BSOLICITAR.setBounds(new Rectangle(391, 419, 196, 39));
    BSOLICITAR.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        BSOLICITAR_actionPerformed(e);
      }
    });
    this.getContentPane().setBackground(Color.white);
    this.getContentPane().setLayout(null);
    this.getContentPane().add(TITULO, null);
    this.getContentPane().add(jScrollPane1, null);
    this.getContentPane().add(BBUSCAR, null);
    this.getContentPane().add(BSOLICITAR, null);
    jScrollPane1.getViewport().add(TOFERTAS, null);
  }

  void BBUSCAR_actionPerformed(ActionEvent e) {
	BUSQUEDAOFERTAS bus = new BUSQUEDAOFERTAS (bd,can);
	this.setVisible(false);
	bus.setVisible(true);
	this.dispose();
  }

  void BSOLICITAR_actionPerformed(ActionEvent e) {
 	SOLICITUD sol = new SOLICITUD();
	Calendar cal = Calendar.getInstance();
	sol.setdia(cal.get(cal.DAY_OF_MONTH));
	sol.setmes(cal.get(cal.MONTH+1));
	sol.setanyo(cal.get(cal.YEAR));
	int n = TOFERTAS.getSelectedRow();
	if (n!=-1){
	  String s = TOFERTAS.getValueAt(n,0).toString();
	  //System.out.println (s);
	  Integer cod = Integer.valueOf(0);
	  int doc=-1;
	  try{
		doc = cod.parseInt(s);
	  }
	  catch (Exception es){
	  //no lanzara error
	  }
	  //System.out.println(doc);
	  sol.setcoferta(doc);
	  sol.setuser(can.getusuario());
	  //HAY QUE CAMBIARLO
	  //sol.setcodigo(1);
	 // bd.insertarSolicitud(sol);
	  //GESTION_CANDIDATOS ges = new GESTION_CANDIDATOS(bd,can);
    INS_COD ins = new INS_COD(bd,can,sol);
	  this.setVisible(false);
	  ins.setVisible(true);
	  this.dispose();
	}
  }

  /*public static void main (String[] args){
	  Gestor con = new Gestor();
     OFERTASENCONTRADAS o = new OFERTASENCONTRADAS(con);
     o.setVisible(true);
  }*/
}
