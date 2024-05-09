
package VENTANAS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import CLASES.*;
import GESQL.*;
import java.util.Vector;

public class GESOFERTAS extends JFrame {
 	Gestor bd = new Gestor();
	EMPRESAS emp=new EMPRESAS();
	JLabel LGestion = new JLabel();
	JButton BVer = new JButton();
	JButton BCancelar = new JButton();
	JScrollPane OFERTAS = new JScrollPane();
	JTable LOFERTAS;// = new JTable(5,4);
	Object[] data;
	Object[][] lin;
	public GESOFERTAS(Gestor con, EMPRESAS empresa) {
		bd=con;
		emp=empresa;
		try  {
			jbInit(bd, emp);
			}
		catch(Exception e) {
			e.printStackTrace();
			}
		}

	private void jbInit(Gestor bd, EMPRESAS emp) throws Exception {
		data = new Object [11];
		data[0]="cod-oferta";
		data[1]="Titulo";
		//data[2]="Descrip";
		data[2]="Lugar";
		data[3]="Contrato";
		data[4]="sueldo_minimo";
		data[5]="suel_max";
		data[6]="expe";
		//data[8]="valor";
		//data[9]="impres";
		data[7]="dia";
		data[8]="mes";
		data[9]="anyo";
		data[10]="estado";
		//data[14]="usuario";
		//System.out.println("bien");
		lin=bd.misOfertas(emp.getusuario());
		//System.out.println("mal");
		LOFERTAS=new JTable(lin,data);
		LGestion.setFont(new java.awt.Font("Serif", 0, 50));
		LGestion.setText("Sus ofertas");
		LGestion.setBounds(new Rectangle(306, 32, 329, 55));
		this.getContentPane().setLayout(null);
		BVer.setText("Ver Oferta");
		BVer.setBounds(new Rectangle(142, 364, 131, 39));
		BVer.addActionListener(new java.awt.event.ActionListener() {

								   public void actionPerformed(ActionEvent e) {
									   BVer_actionPerformed(e);
									   }
								   });
		BCancelar.setText("Cancelar");
		BCancelar.setBounds(new Rectangle(520, 362, 130, 42));
		BCancelar.addActionListener(new java.awt.event.ActionListener() {

										public void actionPerformed(ActionEvent e) {
											BCancelar_actionPerformed(e);
											}
										});
		this.getContentPane().setBackground(Color.white);
		//OFERTAS.setBounds(new Rectangle(119, 105, 214, 242));
		OFERTAS.setBounds(new Rectangle(19, 103, 950, 242));
		LOFERTAS.setToolTipText("Seleccione una oferta y presione \"Ver Oferta\"");
		this.getContentPane().add(OFERTAS, null);
    this.getContentPane().add(LGestion, null);
    this.getContentPane().add(BCancelar, null);
    this.getContentPane().add(BVer, null);
		OFERTAS.getViewport().add(LOFERTAS, null);
		this.setSize(1000,500);
		}

	void BCancelar_actionPerformed(ActionEvent e) {
		this.hide();
		GESTION_EMPRESAS E =new GESTION_EMPRESAS(bd,emp);
		E.show();
		this.dispose();
		}

	void BVer_actionPerformed(ActionEvent e) {
	   int r=LOFERTAS.getSelectedRow();
	   //System.out.println(r);
	   if (r!=-1){
	      String s=LOFERTAS.getValueAt(r,0).toString();
	      Integer cod=Integer.valueOf(-1);
	      Integer mal=Integer.valueOf(-1);
	      try{
		   cod = Integer.valueOf(s);
	      }
	      catch(Exception ef){
		   //no da error porque la columna 0 siempre tiene numeros
	      }//System.out.println(cod);
	     //llamamos a la ventana
	      if (!cod.equals(mal)){
	         OFERTA o = new OFERTA();
		 o=bd.ConsultarOfertas(cod.intValue());//sacamos la oferta con cod COD :D
		 System.out.println(o.getCODOFERTA());
	         OFERTASAC v = new OFERTASAC (bd,emp,o);
	  	 this.hide();
		 v.show();
	  	 this.dispose();

	      }
	  }//if
	   //else
	}
}
