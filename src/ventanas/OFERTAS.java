
package VENTANAS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Vector;
import CLASES.*;
import EXCEP.*;
import GESQL.*;

public class OFERTAS extends JFrame {
	Gestor bd = new Gestor();
	EMPRESAS emp=new EMPRESAS();
	JLabel LGES_OFERTAS = new JLabel();
	JLabel LCODIGO = new JLabel();
	JTextField TCODIGO = new JTextField();
	JLabel LTITULO = new JLabel();
	JTextField TTITULO = new JTextField();
	JLabel LCONOCIMIENTOS = new JLabel();
	JComboBox CContrato = new JComboBox();
	JLabel LCONTRATO = new JLabel();
	JLabel LSUELDOMAX = new JLabel();
	JTextField TSUELDOMAX = new JTextField();
	JLabel LSUELDOMIN = new JLabel();
	JTextField TSUELDOMIN = new JTextField();
	JLabel LIMPRESCINDIBLE = new JLabel();
	JLabel LVALORARA = new JLabel();
	JCheckBox CESTADO = new JCheckBox();
	JButton BACPETAR = new JButton();
	JButton BCANCELAR = new JButton();
	JScrollPane jScrollPane1 = new JScrollPane();
	JScrollPane jScrollPane2 = new JScrollPane();
	JScrollPane jScrollPane3 = new JScrollPane();
	JTextArea TVALORARA = new JTextArea();
	JLabel LDESCRIP = new JLabel();
	JScrollPane jScrollPane4 = new JScrollPane();
	JTextArea TDESCRIPCION = new JTextArea();
	JLabel LLUGAR = new JLabel();
	JTextField TLUGAR = new JTextField();
	JButton ICONOC = new JButton();
    JLabel LExperiencia = new JLabel();
    JTextField Experiencia = new JTextField();
    JTable CONOCIMIENTOS;
    Object[] data;
    Object[][] lin;
  JTextArea TIMPRESCINDIBLE = new JTextArea();
// = new JTable();

	public OFERTAS(Gestor con, EMPRESAS empresa) {
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
	       data = new Object[2];
	       data[0]="cod";
	       data[1]="nombre";
	       lin = bd.sacarConocimientos();
	       CONOCIMIENTOS = new JTable(lin,data);
		LGES_OFERTAS.setFont(new java.awt.Font("Serif", 0, 50));
		LGES_OFERTAS.setText("Nueva Oferta");
		LGES_OFERTAS.setBounds(new Rectangle(164, 15, 356, 52));
		this.getContentPane().setLayout(null);
		LCODIGO.setText("Codigo");
		LCODIGO.setBounds(new Rectangle(19, 83, 60, 30));
		TCODIGO.setBounds(new Rectangle(86, 83, 78, 29));
		LTITULO.setText("Titulo");
		LTITULO.setBounds(new Rectangle(21, 127, 54, 25));
		TTITULO.setBounds(new Rectangle(86, 125, 150, 29));
		LCONOCIMIENTOS.setText("Conocimientos");
		LCONOCIMIENTOS.setBounds(new Rectangle(331, 135, 95, 22));
		CContrato.setToolTipText("Elija un tipo de contrato");
		CContrato.setBounds(new Rectangle(91, 165, 147, 25));
		String indc="Indef. t.completo";
		String indp="Indef. t.parcial";
		String temc="Temp. t.completo";
		String temp="Temp. t.parcial";
		CContrato.addItem((Object)indc);
		CContrato.addItem((Object)indp);
		CContrato.addItem((Object)temc);
		CContrato.addItem((Object)temp);
		CContrato.addActionListener(new java.awt.event.ActionListener() {

										public void actionPerformed(ActionEvent e) {
											CContrato_actionPerformed(e);
											}
										});
		LCONTRATO.setToolTipText("");
		LCONTRATO.setText("Contrato");
		LCONTRATO.setBounds(new Rectangle(18, 169, 72, 19));
		LSUELDOMAX.setText("Sueldo maximo");
		LSUELDOMAX.setBounds(new Rectangle(20, 217, 96, 21));
		TSUELDOMAX.setBounds(new Rectangle(125, 209, 136, 27));
		LSUELDOMIN.setText("Sueldo minimo");
		LSUELDOMIN.setBounds(new Rectangle(19, 266, 96, 24));
		TSUELDOMIN.setBounds(new Rectangle(125, 262, 137, 28));
		LIMPRESCINDIBLE.setText("Imprescindible");
		LIMPRESCINDIBLE.setBounds(new Rectangle(337, 237, 108, 28));
		LVALORARA.setText("Se valorara");
		LVALORARA.setBounds(new Rectangle(342, 337, 82, 27));
		CESTADO.setToolTipText("Active esta casilla si quiere desactivar la casilla");
		CESTADO.setBackground(Color.white);
		CESTADO.setText("Active para desactivar la oferta");
		CESTADO.setBounds(new Rectangle(20, 439, 213, 31));
		BACPETAR.setToolTipText("Añade tu oferta");
		BACPETAR.setText("Aceptar");
		BACPETAR.setBounds(new Rectangle(172, 505, 112, 35));
		BACPETAR.addActionListener(new java.awt.event.ActionListener() {

									   public void actionPerformed(ActionEvent e) {
										   BACPETAR_actionPerformed(e);
										   }
									   });
		BCANCELAR.setText("Cancelar");
		BCANCELAR.setBounds(new Rectangle(333, 505, 113, 34));
		BCANCELAR.addActionListener(new java.awt.event.ActionListener() {

										public void actionPerformed(ActionEvent e) {
											BCANCELAR_actionPerformed(e);
											}
										});
		this.getContentPane().setBackground(Color.white);
		jScrollPane1.setBounds(new Rectangle(443, 124, 169, 76));
		jScrollPane2.setBounds(new Rectangle(448, 232, 167, 71));
		jScrollPane3.getViewport().setBackground(Color.white);
    jScrollPane3.setBounds(new Rectangle(442, 320, 169, 72));
		TVALORARA.setToolTipText("Introducca las aptitudes que se valoraran");
		LDESCRIP.setText("Descripcion");
		LDESCRIP.setBounds(new Rectangle(339, 415, 87, 36));
		jScrollPane4.setBounds(new Rectangle(444, 418, 144, 70));
		LLUGAR.setText("Lugar");
		LLUGAR.setBounds(new Rectangle(14, 313, 117, 29));
		TLUGAR.setBounds(new Rectangle(89, 313, 184, 30));
		ICONOC.setBackground(Color.lightGray);
		ICONOC.setToolTipText("Introducca un nuevo conocimiento");
		ICONOC.setText("Nuevo conocimiento");
		ICONOC.setBounds(new Rectangle(419, 76, 213, 30));
		ICONOC.addActionListener(new java.awt.event.ActionListener() {

									 public void actionPerformed(ActionEvent e) {
										 ICONOC_actionPerformed(e);
										 }
									 });
		LExperiencia.setToolTipText("Introducir años de experiencia");
    LExperiencia.setText("Experiencia:");
    LExperiencia.setBounds(new Rectangle(16, 378, 97, 28));
    Experiencia.setBounds(new Rectangle(107, 378, 65, 31));
    this.getContentPane().add(LGES_OFERTAS, null);
		this.getContentPane().add(BACPETAR, null);
		this.getContentPane().add(BCANCELAR, null);
		this.getContentPane().add(LVALORARA, null);
		this.getContentPane().add(LIMPRESCINDIBLE, null);
		this.getContentPane().add(LCONOCIMIENTOS, null);
		this.getContentPane().add(jScrollPane3, null);
    jScrollPane3.getViewport().add(TVALORARA, null);
		this.getContentPane().add(LDESCRIP, null);
		this.getContentPane().add(jScrollPane4, null);
    this.getContentPane().add(TCODIGO, null);
    this.getContentPane().add(LLUGAR, null);
    this.getContentPane().add(TLUGAR, null);
    this.getContentPane().add(LSUELDOMIN, null);
    this.getContentPane().add(LSUELDOMAX, null);
    this.getContentPane().add(TSUELDOMAX, null);
    this.getContentPane().add(TSUELDOMIN, null);
    this.getContentPane().add(CContrato, null);
    this.getContentPane().add(TTITULO, null);
    this.getContentPane().add(LTITULO, null);
    this.getContentPane().add(LCODIGO, null);
    this.getContentPane().add(LExperiencia, null);
    this.getContentPane().add(Experiencia, null);
    this.getContentPane().add(CESTADO, null);
    this.getContentPane().add(LCONTRATO, null);
    this.getContentPane().add(ICONOC, null);
    this.getContentPane().add(jScrollPane2, null);
    jScrollPane2.getViewport().add(TIMPRESCINDIBLE, null);
    this.getContentPane().add(jScrollPane1, null);
    jScrollPane1.getViewport().add(CONOCIMIENTOS, null);
		jScrollPane4.getViewport().add(TDESCRIPCION, null);
		this.setSize(645,595);
		}
		
	void BCANCELAR_actionPerformed(ActionEvent e) {
		this.hide();
		GESTION_EMPRESAS E =new GESTION_EMPRESAS(bd,emp);
		E.show();
		this.dispose();
		}
		
	void CContrato_actionPerformed(ActionEvent e) {
	
		}
		
	void BACPETAR_actionPerformed(ActionEvent e) {
		OFERTA o=new OFERTA();
		boolean letr = false;
		try{
		  o.vacio("Codigo",TCODIGO.getText());
		  int i = o.nums("Codigo",TCODIGO.getText());
		  o.setCODOFERTA(i);
		  o.vacio("Titulo",TTITULO.getText());
		  o.setTITULO(TTITULO.getText());
		  o.setCONTRATO((String)CContrato.getSelectedItem());
		  o.vacio("Sueldo Maximo",TSUELDOMAX.getText());
		  i=o.nums("Sueldo Maximo",TSUELDOMAX.getText());
		  o.vacio("Sueldo Minimo",TSUELDOMIN.getText());
		  int j=o.nums("Sueldo Minimo",TSUELDOMIN.getText());
		  o.mayor(i,j);
		  o.setSUELDOMAX(i);
		  o.setSUELDOMIN(j);
		  Calendar fecha = Calendar.getInstance();
		  o.setDIA(fecha.get(fecha.DAY_OF_MONTH)+1);
		  o.setANYO(fecha.get(fecha.YEAR));
		  //mirar esto en la API por si acaso.
		  o.setMES(fecha.get(fecha.MONTH));
		  o.vacio("Lugar",TLUGAR.getText());
		  o.setLUGAR(TLUGAR.getText());
		  o.vacio("Experiencia",Experiencia.getText());
		  j=o.nums("Experiencia",Experiencia.getText());
		  o.setEXPERIENCIA(j);
		  // MIRAR CONOCIMIENTOS0  
		  o.setIMPRESCINDIBLE(TIMPRESCINDIBLE.getText());
		  o.setSEVALORARA(TVALORARA.getText());
		  o.vacio("Descripcion",TDESCRIPCION.getText());
		  o.setDESCRIP(TDESCRIPCION.getText());
		  //System.out.println(CContrato.getSelectedItem());
		  //System.out.println(o.isEXPERIENCIA());
		  o.setUSUARIOEMP(emp.getusuario());
		  //o.setUSUARIOEMP(TUSUARIO.getText());
		  o.setESTADO(CESTADO.isSelected());
		  letr=true;
		}
	  catch(VACIOException h){ //Para los vacio
	     h.getError();
	  }
	  catch(NUMSException f){ //Para las excepciones de numeros
	     f.getError();
	  }
	  catch(MAYORException g){ //Para los sueldos mal introducidos
	     g.getError();
      }
	  if (letr){
	    this.dispose();
	    this.hide();
	    bd.InsertarOferta(o);
		int n[];
		n=CONOCIMIENTOS.getSelectedRows();
		for (int j=0;j<n.length;j++){
			System.out.println (CONOCIMIENTOS.getValueAt(n[j],0));
		    String s = CONOCIMIENTOS.getValueAt(n[j], 0).toString();
		    Integer cod = new Integer (-1);
		  try{
		    cod = new Integer (s);
		  }
                  catch (Exception ex){
			//si da error no se insertara en la BD
		  }
		  Integer ma =new Integer(-1);
		  System.out.println("bien");
		  bd.InsertarOfertaConoc(o.getCODOFERTA(),cod.intValue());
	        } 		
        this.hide();
		GESTION_EMPRESAS E =new GESTION_EMPRESAS(bd,emp);
		E.show();
	    this.dispose();
	  }
	}
	void ICONOC_actionPerformed(ActionEvent e) {
		this.hide();
		CONOCIMIENTOS c=new CONOCIMIENTOS(bd,emp);
		c.show();
		this.dispose();
		
		}
	}
