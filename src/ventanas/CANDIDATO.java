
package VENTANAS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import CLASES.*;
import EXCEP.*;
import GESQL.*;

public class CANDIDATO extends JFrame {
  Gestor bd = new Gestor();
  JLabel Tcandidato = new JLabel();
  JLabel LUsuario = new JLabel();
  JTextField IUsuario = new JTextField();
  JLabel LClave = new JLabel();
  JPasswordField IClave = new JPasswordField();
  JLabel LNombre = new JLabel();
  JTextField INombre = new JTextField();
  JLabel LApell = new JLabel();
  JTextField IApel1 = new JTextField();
  JLabel Ldireccion = new JLabel();
  JTextField IDireccion = new JTextField();
  JLabel LTelefono = new JLabel();
  JTextField ITelefono = new JTextField();
  JLabel LEmail = new JLabel();
  JTextField IEmail = new JTextField();
  JLabel LFecha = new JLabel();
  JTextField IDia = new JTextField();
  JTextField IMes = new JTextField();
  JLabel dia = new JLabel();
  JLabel mes = new JLabel();
  JLabel LAño = new JLabel();
  JTextField año = new JTextField();
  JLabel LEstudios = new JLabel();
  JLabel LOtros = new JLabel();
  JLabel VidaLab = new JLabel();
  JButton BAceptar = new JButton();
  JButton BCANCEL = new JButton();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextField TESTUDIOS = new JTextField();
  JScrollPane jScrollPane2 = new JScrollPane();
  JTextField TOTROS = new JTextField();
  JScrollPane jScrollPane3 = new JScrollPane();
  JTextField BVIDA = new JTextField();
  JCheckBox CARNET = new JCheckBox();
  JCheckBox COCHE = new JCheckBox();
  JCheckBox DISPV = new JCheckBox();
  JLabel LExperiencia = new JLabel();
  JTextField Experiencia = new JTextField();
  JLabel jLabel1 = new JLabel();
  JScrollPane jScrollPane4 = new JScrollPane();
  
  JTable LISTA1 ;//= new JTable(c,data);

  Object[] data;
  Object[][] lin;
  Object[][] dos;

  public CANDIDATO(Gestor con) {
    try  {
	  bd = con;
      jbInit(bd);
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit(Gestor bd) throws Exception {
  data = new Object[2];
  data[0]="cod";
  data[1]="nombre";
  lin = bd.sacarConocimientos();
  LISTA1 = new JTable(lin,data);
    Tcandidato.setFont(new java.awt.Font("Serif", 0, 40));
    Tcandidato.setHorizontalAlignment(SwingConstants.CENTER);
    Tcandidato.setText("DATOS DEL CANDIDATO");
    Tcandidato.setBounds(new Rectangle(77, 0, 531, 88));
    this.getContentPane().setLayout(null);
    LUsuario.setText("Usuario:");
    LUsuario.setBounds(new Rectangle(20, 97, 73, 25));
    IUsuario.setBounds(new Rectangle(114, 96, 98, 23));
    LClave.setText("Clave:");
    LClave.setBounds(new Rectangle(21, 133, 63, 25));
    IClave.setDisabledTextColor(Color.white);
    IClave.setBounds(new Rectangle(113, 135, 98, 24));
    LNombre.setText("Nombre:");
    LNombre.setBounds(new Rectangle(20, 176, 56, 23));
    INombre.setBounds(new Rectangle(112, 177, 97, 25));
    LApell.setText("Apellidos:");
    LApell.setBounds(new Rectangle(316, 178, 59, 19));
    IApel1.setBounds(new Rectangle(383, 176, 215, 24));
    Ldireccion.setText("Direccion:");
    Ldireccion.setBounds(new Rectangle(319, 98, 72, 19));
    IDireccion.setBounds(new Rectangle(384, 94, 227, 26));
    LTelefono.setText("Telefono:");
    LTelefono.setBounds(new Rectangle(319, 138, 63, 22));
    ITelefono.setBounds(new Rectangle(383, 136, 126, 23));
    LEmail.setText("E-mail:");
    LEmail.setBounds(new Rectangle(18, 225, 67, 22));
    IEmail.setBounds(new Rectangle(111, 225, 97, 24));
    LFecha.setText("Fecha de nacimiento:");
    LFecha.setBounds(new Rectangle(289, 217, 154, 23));
    IDia.setBounds(new Rectangle(446, 218, 27, 19));
    IMes.setBounds(new Rectangle(503, 217, 28, 21));
    dia.setText("Dia:");
    dia.setBounds(new Rectangle(422, 216, 34, 20));
    mes.setText("Mes:");
    mes.setBounds(new Rectangle(476, 217, 32, 20));
    LAño.setText("Año:");
    LAño.setBounds(new Rectangle(536, 218, 28, 20));
    año.setBounds(new Rectangle(563, 216, 30, 23));
    LEstudios.setText("Estudios:");
    LEstudios.setBounds(new Rectangle(277, 335, 93, 19));
    LOtros.setText("Otros conocimientos:");
    LOtros.setBounds(new Rectangle(234, 255, 119, 20));
    VidaLab.setText("Vida laboral:");
    VidaLab.setBounds(new Rectangle(274, 291, 99, 21));
    BAceptar.setText("ACEPTAR");
    BAceptar.setBounds(new Rectangle(149, 521, 153, 32));
    BAceptar.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        BAceptar_actionPerformed(e);
      }
    });
    BCANCEL.setText("CANCELAR");
    BCANCEL.setBounds(new Rectangle(387, 521, 148, 34));
    BCANCEL.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        BCANCEL_actionPerformed(e);
      }
    });
    jScrollPane1.setBounds(new Rectangle(379, 329, 250, 26));
    jScrollPane2.setBounds(new Rectangle(381, 256, 241, 23));
    jScrollPane3.setBounds(new Rectangle(380, 289, 243, 27));
    CARNET.setBackground(Color.white);
    CARNET.setText("Carnet");
    CARNET.setBounds(new Rectangle(17, 295, 129, 24));
    COCHE.setBackground(Color.white);
    COCHE.setText("Coche Propio");
    COCHE.setBounds(new Rectangle(18, 327, 118, 24));
    DISPV.setBackground(Color.white);
    DISPV.setText("Disponiblidad viajar");
    DISPV.setBounds(new Rectangle(18, 364, 147, 19));
    this.getContentPane().setBackground(Color.white);
    LExperiencia.setToolTipText("Introduzca enumero de años de experiencia");
    LExperiencia.setText("Experiencia:");
    LExperiencia.setBounds(new Rectangle(16, 263, 77, 27));
    Experiencia.setBounds(new Rectangle(113, 263, 48, 24));
    jLabel1.setText("Conocimientos");
    jLabel1.setBounds(new Rectangle(110, 417, 111, 31));
    jScrollPane4.setBounds(new Rectangle(237, 385, 182, 87));
    this.getContentPane().add(LUsuario, null);
    this.getContentPane().add(LClave, null);
    this.getContentPane().add(LNombre, null);
    this.getContentPane().add(IUsuario, null);
    this.getContentPane().add(IClave, null);
    this.getContentPane().add(LEmail, null);
    this.getContentPane().add(IEmail, null);
    this.getContentPane().add(INombre, null);
    this.getContentPane().add(LApell, null);
    this.getContentPane().add(Ldireccion, null);
    this.getContentPane().add(IDireccion, null);
    this.getContentPane().add(LTelefono, null);
    this.getContentPane().add(Tcandidato, null);
    this.getContentPane().add(ITelefono, null);
    this.getContentPane().add(IApel1, null);
    this.getContentPane().add(LAño, null);
    this.getContentPane().add(dia, null);
    this.getContentPane().add(IDia, null);
    this.getContentPane().add(mes, null);
    this.getContentPane().add(IMes, null);
    this.getContentPane().add(año, null);
    this.getContentPane().add(LFecha, null);
    this.getContentPane().add(jScrollPane2, null);
    this.getContentPane().add(LOtros, null);
    this.getContentPane().add(jScrollPane3, null);
    this.getContentPane().add(VidaLab, null);
    this.getContentPane().add(jScrollPane1, null);
    this.getContentPane().add(LEstudios, null);
    this.getContentPane().add(LExperiencia, null);
    this.getContentPane().add(Experiencia, null);
    this.getContentPane().add(DISPV, null);
    this.getContentPane().add(CARNET, null);
    this.getContentPane().add(COCHE, null);
    this.getContentPane().add(BAceptar, null);
    this.getContentPane().add(BCANCEL, null);
    this.getContentPane().add(jScrollPane4, null);
    this.getContentPane().add(jLabel1, null);
    jScrollPane4.getViewport().add(LISTA1, null);
    jScrollPane1.getViewport().add(TESTUDIOS, null);
    jScrollPane3.getViewport().add(BVIDA, null);
    jScrollPane2.getViewport().add(TOTROS, null);
    this.setSize(650,590);
  }

  void Carnet_itemStateChanged(ItemEvent e) {

  }

  void BCANCEL_actionPerformed(ActionEvent e) {
    this.hide();
    //GESTION_CANDIDATOS C=new GESTION_CANDIDATOS();
	ventanainicial v= new ventanainicial(bd);
    v.show();
    this.dispose();
  }

  void BAceptar_actionPerformed(ActionEvent e) {
       //creamos un objeto CANDIDATO e introducimos los datos
      CANDIDATOS c=new CANDIDATOS();
	  boolean letr = false;
      boolean user = false;
	  try{
	     c.vacio ("Usuario",IUsuario.getText());
		 c.setusuario(IUsuario.getText());
		 String pass = new String(IClave.getPassword());
		 c.vacio ("Clave",pass);
		 c.setclave(pass);
		 c.vacio("Nombre",INombre.getText());
		 c.setnombre(INombre.getText());
		 c.vacio("Apellidos",IApel1.getText());
		 c.setapellidos(IApel1.getText());
		 c.vacio("Direccion",IDireccion.getText());
		 c.setdireccion(IDireccion.getText());
		 c.setemail(IEmail.getText());
		 c.vacio("Telefono",ITelefono.getText());
		 int i = c.nums("Telefono",ITelefono.getText());
		 c.settelefono(i);
		 c.vacio("Dia",IDia.getText());
		 i=c.nums("Dia",IDia.getText());
		 c.dia(i);
		 c.setdia(i);
		 c.vacio("Mes",IMes.getText());
		 i=c.nums("Mes",IMes.getText());
		 c.mes(i);
		 c.setmes(i);
     
                 
		 c.vacio("Año",año.getText());
		 i=c.nums("Año",año.getText());
		 c.anyo(i);
		 c.setanyo(i);
		 c.setcoche(COCHE.isSelected());
 		 c.setdispviajar(DISPV.isSelected());
		 //c.setexperiencia(EXPER.isSelected());
		 c.vacio("Experiencia",Experiencia.getText());
		 i=c.nums("Experiencia",Experiencia.getText());
		 c.setexperiencia(i);
		 c.setcarnet(CARNET.isSelected());
		 c.setestudios(TESTUDIOS.getText());
		 c.setotrosconoz(TOTROS.getText());
         	 c.setvidalabor(BVIDA.getText());
		 bd.ConsultarUsuario(c.getusuario(),"candidatos","c");
		 bd.ConsultarUsuario(c.getusuario(),"empresa","e");
		 letr = true;
      }
	  catch(VACIOException h){ //Para los vacio
	     h.getError();
	  }
	  catch(NUMSException f){ //Para las excepciones de numeros
	     f.getError();
	  }
	  catch(FECHAException g){ //Para la fecha mal introducida
	     g.getError();
      }
	catch (ExisteUsuarioException es){//Por si existe el usuario
	   es.getError();
    }
    if (letr){
	   this.dispose();
	   this.hide();
	   user = bd.InsertarCandidato(c);
           int n[];
          n=LISTA1.getSelectedRows();
       for (int j=0;j<n.length;j++){
         String s = LISTA1.getValueAt(n[j], 0).toString();//saca el codigo

         Integer cod = new Integer (-1);
         try{
            cod = new Integer (s);
         }
         catch (Exception ex){
            //no puede dar error porque en la BD son int's
         }
	      Integer ma =new Integer(-1);
	      bd.insertaCandCono(c.getusuario(),cod.intValue());
       }//for
	if (user){
            this.hide();
			GESTION_CANDIDATOS C=new GESTION_CANDIDATOS(bd,c);
            C.show();
			this.dispose();
	}
	else{
		    this.hide();
			ventanainicial v=new ventanainicial(bd);
			v.show();
			this.dispose();
	}
    }//if
  }

  void BMENOS_actionPerformed(ActionEvent e) {

  }

  void BMAS_actionPerformed(ActionEvent e) {
    //int i= LISTA1.getSelectedRow();
	////LISTA2
  }
}
