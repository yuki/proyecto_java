

package VENTANAS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import CLASES.*;
import GESQL.*;

public class GESTION_EMPRESAS extends JFrame {
	Gestor bd = new Gestor();
	EMPRESAS emp=new EMPRESAS();
	JLabel LGESTIONEMPRESA = new JLabel();
	JButton BPUBLICAR = new JButton();
	JButton BCONSULTAR = new JButton();
	JButton BANALIZAR = new JButton();
	JButton BCANCEL = new JButton();

	public GESTION_EMPRESAS(Gestor con, EMPRESAS empresa) {
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
		LGESTIONEMPRESA.setFont(new java.awt.Font("Serif", 0, 40));
		LGESTIONEMPRESA.setText("Gestion de Empresa");
		LGESTIONEMPRESA.setBounds(new Rectangle(65, 29, 419, 49));
		this.getContentPane().setLayout(null);
		BPUBLICAR.setToolTipText("Publique sus ofertas");
		BPUBLICAR.setText("Publicar Ofertas");
		BPUBLICAR.setBounds(new Rectangle(33, 130, 198, 35));
		BPUBLICAR.addActionListener(new java.awt.event.ActionListener() {

										public void actionPerformed(ActionEvent e) {
											BPUBLICAR_actionPerformed(e);
											}
										});
		BCONSULTAR.setToolTipText("Consulte sus ofertas");
		BCONSULTAR.setText("Consultar las ofertas");
		BCONSULTAR.setBounds(new Rectangle(291, 129, 225, 35));
		BCONSULTAR.addActionListener(new java.awt.event.ActionListener() {

										 public void actionPerformed(ActionEvent e) {
											 BCONSULTAR_actionPerformed(e);
											 }
										 });
		BANALIZAR.setToolTipText("Analice las solicitudes recibidas");
		BANALIZAR.setText("Analizar Solicitudes recibidas");
		BANALIZAR.setBounds(new Rectangle(150, 258, 256, 35));
		BANALIZAR.addActionListener(new java.awt.event.ActionListener() {

										public void actionPerformed(ActionEvent e) {
											BANALIZAR_actionPerformed(e);
											}
										});
		BCANCEL.setText("CANCELAR");
		BCANCEL.setBounds(new Rectangle(180, 383, 180, 34));
		BCANCEL.addActionListener(new java.awt.event.ActionListener()
									  {
									  public void actionPerformed(ActionEvent e) {
										  BCANCEL_actionPerformed(e);
										  }
									  });
		this.getContentPane().setBackground(Color.white);
		this.getContentPane().add(BPUBLICAR, null);
		this.getContentPane().add(LGESTIONEMPRESA, null);
		this.getContentPane().add(BCONSULTAR, null);
		this.getContentPane().add(BCANCEL, null);
    this.getContentPane().add(BANALIZAR, null);
		this.setSize(565,485);
		}

	void BCANCEL_actionPerformed(ActionEvent e) {
		this.setVisible(false);
		ventanainicial v=new ventanainicial(bd);
		v.setVisible(true);
		this.dispose();
		}

	void BPUBLICAR_actionPerformed(ActionEvent e) {
		this.setVisible(false);
		OFERTAS O =new OFERTAS(bd,emp);
		O.setVisible(true);
		this.dispose();
		}

	void BCONSULTAR_actionPerformed(ActionEvent e) {
		this.setVisible(false);
		GESOFERTAS O = new GESOFERTAS(bd, emp);
		O.setVisible(true);
		this.dispose();
		}

	void BANALIZAR_actionPerformed(ActionEvent e) {
		this.setVisible(false);
		OFERECIBIDAS O=new OFERECIBIDAS(bd,emp);
		O.setVisible(true);
		this.dispose();

		}

	void BBUSCAR_actionPerformed(ActionEvent e) {
		this.setVisible(false);
		BUSCANDIDATOS C= new BUSCANDIDATOS(bd,emp);
		C.setVisible(true);
		this.dispose();
		}

	}
