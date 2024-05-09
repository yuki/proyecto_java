
package VENTANAS;

import GESQL.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import EXCEP.*;
import CLASES.*;


public class ventanainicial extends JFrame {
	Gestor bd = new Gestor();
	JLabel TITULO = new JLabel();
	JLabel LEMPRESA = new JLabel();
	JLabel LCandidatos = new JLabel();
	JToggleButton BEmpresa = new JToggleButton();
	JButton BCandidato = new JButton();
	JLabel LNuevo = new JLabel();
	JLabel Lnombre = new JLabel();
	JTextField TNombre = new JTextField();
	JLabel Lcontraseña = new JLabel();
	JPasswordField TContraseña = new JPasswordField();
	JButton BAceptar = new JButton();
	JButton BSALIR = new JButton();

	public ventanainicial(Gestor con) {
		try  {
			bd=con;
			jbInit(bd);
			}
		catch(Exception e) {
			e.printStackTrace();
			}
		}

	private void jbInit(Gestor bd) throws Exception {
		TITULO.setFont(new java.awt.Font("Serif", 0, 50));
		TITULO.setForeground(SystemColor.controlText);
		TITULO.setHorizontalAlignment(SwingConstants.CENTER);
		TITULO.setHorizontalTextPosition(SwingConstants.CENTER);
		TITULO.setText("GESTION DE EMPLEO");
		TITULO.setBounds(new Rectangle(8, 46, 550, 47));
		this.getContentPane().setLayout(null);
		LEMPRESA.setText(" Empresa no regidtrada:");
		LEMPRESA.setBounds(new Rectangle(18, 130, 212, 19));
		LCandidatos.setHorizontalAlignment(SwingConstants.RIGHT);
		LCandidatos.setHorizontalTextPosition(SwingConstants.CENTER);
		LCandidatos.setText("Si eres un candidato no regidtrado:");
		LCandidatos.setBounds(new Rectangle(313, 129, 236, 22));
		BEmpresa.setToolTipText("Registrate como una nueva empresa");
		BEmpresa.setText("EMPRESAS");
		BEmpresa.setBounds(new Rectangle(20, 167, 174, 35));
		BEmpresa.addActionListener(new java.awt.event.ActionListener() {

									   public void actionPerformed(ActionEvent e) {
										   BEmpresa_actionPerformed(e);
										   }
									   });
		BCandidato.setToolTipText("Registrate como un nuevo candidato");
		BCandidato.setText("CANDIDATO");
		BCandidato.setBounds(new Rectangle(374, 168, 172, 37));
		BCandidato.addActionListener(new java.awt.event.ActionListener() {

										 public void actionPerformed(ActionEvent e) {
											 BCandidato_actionPerformed(e);
											 }
										 });
		LNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		LNuevo.setText("Si ya formas parte:");
		LNuevo.setBounds(new Rectangle(173, 242, 283, 24));
		Lnombre.setHorizontalAlignment(SwingConstants.CENTER);
		Lnombre.setText("Usuario:");
		Lnombre.setBounds(new Rectangle(110, 280, 100, 20));
		TNombre.setBounds(new Rectangle(226, 279, 196, 23));
		Lcontraseña.setText("Password:");
		Lcontraseña.setBounds(new Rectangle(134, 313, 75, 20));
		TContraseña.setBounds(new Rectangle(226, 313, 194, 22));
		BAceptar.setToolTipText("Introduce tu nombre y tu clave para entrar DIMITRI.CON");
		BAceptar.setText("ACEPTAR");
		BAceptar.setBounds(new Rectangle(462, 284, 113, 42));
		BAceptar.addActionListener(new java.awt.event.ActionListener() {

									   public void actionPerformed(ActionEvent e) {
										   BAceptar_actionPerformed(e);
										   }
									   });
		this.getContentPane().setBackground(SystemColor.window);
		BSALIR.setToolTipText("Salir del programa");
		BSALIR.setText("SALIR");
		BSALIR.setBounds(new Rectangle(13, 289, 102, 42));
		BSALIR.addActionListener(new java.awt.event.ActionListener() {

									 public void actionPerformed(ActionEvent e) {
										 BSALIR_actionPerformed(e);
										 }
									 });
		this.getContentPane().add(TITULO, null);
		this.getContentPane().add(LCandidatos, null);
		this.getContentPane().add(BEmpresa, null);
		this.getContentPane().add(BCandidato, null);
		this.getContentPane().add(LEMPRESA, null);
		this.getContentPane().add(BAceptar, null);
		this.getContentPane().add(TNombre, null);
		this.getContentPane().add(Lnombre, null);
		this.getContentPane().add(TContraseña, null);
		this.getContentPane().add(BSALIR, null);
		this.getContentPane().add(LNuevo, null);
		this.getContentPane().add(Lcontraseña, null);
		this.setSize(600,500);
		}

	void BEmpresa_actionPerformed(ActionEvent e) {
		this.setVisible(false);
		EMPRESA E=new EMPRESA(bd);
		E.setVisible(true);
		this.dispose();
		}

	void BCandidato_actionPerformed(ActionEvent e) {
		this.setVisible(false);
		CANDIDATO C=new  CANDIDATO(bd);
		C.setVisible(true);
		this.dispose();
		}

	void BAceptar_actionPerformed(ActionEvent e) {
		boolean b=false;
		String pass = new String (TContraseña.getPassword());
		b = bd.ExisteE(TNombre.getText(),pass);
		if (b){
			try{
				EMPRESAS emp = new EMPRESAS();
				emp=bd.ExisteEmpresa(TNombre.getText(),pass);
				if (emp.gettelefono()!=0) {//si el telefono fuese 0, significa que no se ha metido numero, con lo que no hay empresa
					this.setVisible(false);
					GESTION_EMPRESAS E=new GESTION_EMPRESAS(bd,emp);
					E.setVisible(true);
					this.dispose();
					}
				}
			catch(NOExisteUsuarioException es){
				es.getError();
				}
			}
		else {
			try {
				CANDIDATOS can = new CANDIDATOS();
				can = bd.ExisteCandidato(TNombre.getText(),pass);
				if (can.gettelefono()!=0){
					this.setVisible(false);
					GESTION_CANDIDATOS C=new GESTION_CANDIDATOS(bd,can);
					C.setVisible(true);
					this.dispose();
					}
				}
			catch(NOExisteUsuarioException es){
				es.getError();
				}
			}
		}


	void BSALIR_actionPerformed(ActionEvent e) {
		this.bd.CortarConexionBD();
		System.exit(0);
		}

	public static void main(String[] args)
		{
	 	Gestor con = new Gestor();
		con.CargarDriver();
		con.ConexionBD();
		ventanainicial v = new ventanainicial(con);
		v.setVisible(true);
		}
	}
