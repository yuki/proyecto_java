

package VENTANAS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import CLASES.*;
import GESQL.*;


public class CONSULTASOLICITUDES extends JFrame {
  Gestor bd = new Gestor();
  CANDIDATOS can=new CANDIDATOS();
  JLabel LTITULO = new JLabel();
  JButton BELIMINAR = new JButton();
  JButton BCANCELAR = new JButton();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTable LISTOFERTAS;
  Object[] data;
  Object[][] lin;

  public CONSULTASOLICITUDES(Gestor con, CANDIDATOS candidato) {
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
    data = new Object[8];
    data[0]="Estado";
    data[1]="Cod s";
    data[2]="Titulo";
    data[3]="Cod of";
    data[4]="Empresa";
    data[5]="Dia";
    data[6]="Mes";
    data[7]="Año";
    lin = bd.misSolicitudes(can.getusuario());
    LISTOFERTAS = new JTable(lin,data);
    LTITULO.setFont(new java.awt.Font("Serif", 0, 40));
    LTITULO.setText("Consulta de solicitudes");
    LTITULO.setBounds(new Rectangle(85, 19, 473, 90));
    this.getContentPane().setLayout(null);
    BELIMINAR.setToolTipText("Elimine la solicitud seleccionada");
    BELIMINAR.setText("ELIMINAR SOLICITUD");
    BELIMINAR.setBounds(new Rectangle(154, 403, 172, 40));
    BELIMINAR.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        BELIMINAR_actionPerformed(e);
      }
    });
    BCANCELAR.setText("VOLVER");
    BCANCELAR.setBounds(new Rectangle(448, 402, 175, 39));
    BCANCELAR.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        BCANCELAR_actionPerformed(e);
      }
    });
    this.getContentPane().setBackground(Color.white);
    jScrollPane1.setBounds(new Rectangle(13, 127, 745, 185));
    this.getContentPane().add(BELIMINAR, null);
    this.getContentPane().add(BCANCELAR, null);
    this.getContentPane().add(LTITULO, null);
    this.getContentPane().add(jScrollPane1, null);
    jScrollPane1.getViewport().add(LISTOFERTAS, null);
     this.setSize(800,500);
  }


  void BCANCELAR_actionPerformed(ActionEvent e) {
    this.hide();
    GESTION_CANDIDATOS C= new  GESTION_CANDIDATOS(bd,can);
    C.show();
    this.dispose();
  }


  void BELIMINAR_actionPerformed(ActionEvent e) {
//	JOptionPane j = new JOptionPane();
//	j.showConfirmDialog(null,"¿Está seguro de que quiere eliminar la solicitud?","Alerta",JOptionPane.YES_NO_OPTION);
	int l = LISTOFERTAS.getSelectedRow();
	int cod = ((Integer)LISTOFERTAS.getValueAt(l,1)).intValue();
	bd.borrarSolicitud(cod);
	GESTION_CANDIDATOS C=new GESTION_CANDIDATOS(bd,can);
	C.show();
	this.hide();
	this.dispose();
  }
}
