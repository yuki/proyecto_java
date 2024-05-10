package ventanas;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import clases.*;
import excep.*;
import gesql.*;

public class CANDIDATOAC extends JFrame {
    Gestor bd = new Gestor();
    CANDIDATOS can = new CANDIDATOS();
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
    JButton BAceptar = new JButton();
    JButton BCANCEL = new JButton();
    JCheckBox CARNET = new JCheckBox();
    JCheckBox COCHE = new JCheckBox();
    JCheckBox DISPV = new JCheckBox();
    JLabel LExperiencia = new JLabel();
    JTextField TExperiencia = new JTextField();
    JTable LISTA1 = new JTable();
    JLabel jLabel1 = new JLabel();
    JScrollPane jScrollPane4 = new JScrollPane();
    JLabel LEstudios = new JLabel();
    JLabel LOtros = new JLabel();
    JTextField BVIDA = new JTextField();
    JLabel VidaLab = new JLabel();
    JTextField TESTUDIOS = new JTextField();
    JScrollPane jScrollPane1 = new JScrollPane();
    JScrollPane jScrollPane2 = new JScrollPane();
    JScrollPane jScrollPane3 = new JScrollPane();
    JTextField TOTROS = new JTextField();
    Object[] data;
    Object[][] lin;

    public CANDIDATOAC(Gestor con, CANDIDATOS candidato) {
        try {
            bd = con;
            can = candidato;
            jbInit(bd, can);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit(Gestor bd, CANDIDATOS can) throws Exception {
        data = new Object[2];
        data[0] = "cod";
        data[1] = "nombre";
        lin = bd.misConocimientos(can.getusuario(), "<>");// para que salgan lo que no tengo
        LISTA1 = new JTable(lin, data);
        Tcandidato.setFont(new java.awt.Font("Serif", 0, 40));
        Tcandidato.setHorizontalAlignment(SwingConstants.CENTER);
        Tcandidato.setText("DATOS DEL CANDIDATO");
        Tcandidato.setBounds(new Rectangle(44, 0, 531, 88));
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
        LApell.setBounds(new Rectangle(288, 176, 59, 19));
        IApel1.setBounds(new Rectangle(355, 174, 215, 24));
        Ldireccion.setText("Direccion:");
        Ldireccion.setBounds(new Rectangle(291, 96, 72, 19));
        IDireccion.setBounds(new Rectangle(356, 92, 227, 26));
        LTelefono.setText("Telefono:");
        LTelefono.setBounds(new Rectangle(291, 136, 63, 22));
        ITelefono.setBounds(new Rectangle(355, 134, 126, 23));
        LEmail.setText("E-mail:");
        LEmail.setBounds(new Rectangle(18, 225, 67, 22));
        IEmail.setBounds(new Rectangle(111, 225, 97, 24));
        LFecha.setText("Fecha de nacimiento:");
        LFecha.setBounds(new Rectangle(259, 224, 131, 23));
        IDia.setBounds(new Rectangle(417, 229, 27, 19));
        IMes.setBounds(new Rectangle(474, 228, 28, 21));
        dia.setText("Dia:");
        dia.setBounds(new Rectangle(393, 227, 34, 20));
        mes.setText("Mes:");
        mes.setBounds(new Rectangle(447, 228, 32, 20));
        LAño.setText("Año:");
        LAño.setBounds(new Rectangle(507, 229, 28, 20));
        año.setBounds(new Rectangle(534, 227, 30, 23));
        BAceptar.setText("ACEPTAR");
        BAceptar.setBounds(new Rectangle(120, 512, 153, 32));
        BAceptar.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent e) {
                BAceptar_actionPerformed(e);
            }
        });
        BCANCEL.setText("CANCELAR");
        BCANCEL.setBounds(new Rectangle(357, 508, 148, 34));
        BCANCEL.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent e) {
                BCANCEL_actionPerformed(e);
            }
        });
        CARNET.setBackground(Color.white);
        CARNET.setText("Carnet");
        CARNET.setBounds(new Rectangle(16, 287, 129, 24));
        COCHE.setBackground(Color.white);
        COCHE.setText("Coche Propio");
        COCHE.setBounds(new Rectangle(17, 310, 118, 24));
        DISPV.setBackground(Color.white);
        DISPV.setText("Disponiblidad viajar");
        DISPV.setBounds(new Rectangle(17, 337, 147, 19));
        this.getContentPane().setBackground(Color.white);
        LExperiencia.setToolTipText("Introducca el numero de años de experiencia");
        LExperiencia.setText("Experiencia:");
        LExperiencia.setBounds(new Rectangle(17, 252, 94, 31));
        TExperiencia.setBounds(new Rectangle(107, 257, 47, 23));
        jLabel1.setText("Conocimientos");
        jLabel1.setBounds(new Rectangle(90, 357, 111, 31));
        jLabel1.setBounds(new Rectangle(36, 415, 111, 31));
        jLabel1.setBounds(new Rectangle(100, 399, 111, 31));
        jScrollPane4.setBounds(new Rectangle(194, 336, 177, 77));
        jScrollPane4.setBounds(new Rectangle(140, 394, 177, 77));
        jScrollPane4.setBounds(new Rectangle(244, 378, 177, 77));
        LEstudios.setText("Estudios:");
        LEstudios.setBounds(new Rectangle(43, 80, 93, 19));
        LEstudios.setBounds(new Rectangle(277, 335, 93, 19));
        LEstudios.setBounds(new Rectangle(277, 335, 93, 19));
        LOtros.setText("Otros conocimientos:");
        LOtros.setBounds(new Rectangle(0, 0, 119, 20));
        LOtros.setBounds(new Rectangle(234, 255, 119, 20));
        LOtros.setBounds(new Rectangle(234, 255, 119, 20));
        VidaLab.setText("Vida laboral:");
        VidaLab.setBounds(new Rectangle(40, 36, 99, 21));
        VidaLab.setBounds(new Rectangle(274, 291, 99, 21));
        VidaLab.setBounds(new Rectangle(274, 291, 99, 21));
        jScrollPane1.setBounds(new Rectangle(145, 74, 250, 26));
        jScrollPane1.setBounds(new Rectangle(379, 329, 250, 26));
        jScrollPane1.setBounds(new Rectangle(379, 329, 250, 26));
        jScrollPane2.setBounds(new Rectangle(147, 1, 241, 23));
        jScrollPane2.setBounds(new Rectangle(381, 256, 241, 23));
        jScrollPane2.setBounds(new Rectangle(381, 256, 241, 23));
        jScrollPane3.setBounds(new Rectangle(146, 34, 243, 27));
        jScrollPane3.setBounds(new Rectangle(380, 289, 243, 27));
        jScrollPane3.setBounds(new Rectangle(380, 289, 243, 27));
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
        this.getContentPane().add(dia, null);
        this.getContentPane().add(IDia, null);
        this.getContentPane().add(mes, null);
        this.getContentPane().add(IMes, null);
        this.getContentPane().add(LAño, null);
        this.getContentPane().add(año, null);
        this.getContentPane().add(ITelefono, null);
        this.getContentPane().add(IApel1, null);
        this.getContentPane().add(DISPV, null);
        this.getContentPane().add(LExperiencia, null);
        this.getContentPane().add(TExperiencia, null);
        this.getContentPane().add(COCHE, null);
        this.getContentPane().add(CARNET, null);
        this.getContentPane().add(LEstudios, null);
        this.getContentPane().add(LOtros, null);
        this.getContentPane().add(VidaLab, null);
        this.getContentPane().add(jScrollPane1, null);
        this.getContentPane().add(jScrollPane2, null);
        this.getContentPane().add(jScrollPane3, null);
        this.getContentPane().add(LFecha, null);
        this.getContentPane().add(Tcandidato, null);
        this.getContentPane().add(BCANCEL, null);
        this.getContentPane().add(BAceptar, null);
        this.getContentPane().add(jScrollPane4, null);
        this.getContentPane().add(jLabel1, null);
        jScrollPane4.getViewport().add(LISTA1, null);
        jScrollPane3.getViewport().add(BVIDA, null);
        jScrollPane2.getViewport().add(TOTROS, null);
        jScrollPane1.getViewport().add(TESTUDIOS, null);

        // VAMOS A PONER LOS DATOS DEL CANDIDATO PARA PODER SER MODIFICADOS.
        IUsuario.setText(can.getusuario());
        IUsuario.setEnabled(false);
        IClave.setText(can.getclave());
        INombre.setText(can.getnombre());
        IApel1.setText(can.getapellidos());
        IEmail.setText(can.getemail());
        IDireccion.setText(can.getdireccion());
        Integer i = Integer.valueOf(can.gettelefono());
        ITelefono.setText(i.toString());
        i = Integer.valueOf(can.getdia());
        IDia.setText(i.toString());
        i = Integer.valueOf(can.getmes());
        IMes.setText(i.toString());
        i = Integer.valueOf(can.getanyo());
        año.setText(i.toString());
        CARNET.setSelected(can.getcarnet());
        COCHE.setSelected(can.getcoche());
        DISPV.setSelected(can.getdispviajar());
        i = Integer.valueOf(can.getexperiencia());
        TExperiencia.setText(i.toString());
        TESTUDIOS.setText(can.getestudios());
        TOTROS.setText(can.getotrosconoz());
        BVIDA.setText(can.getvidalabor());
        // YA ESTAN TODOS LOS CAMPOS CON LOS DATOS DEL CANDIDATO PARA PODER SER
        // MODIFICADOS
        this.setSize(650, 590);
    }

    void Carnet_itemStateChanged(ItemEvent e) {

    }

    void BCANCEL_actionPerformed(ActionEvent e) {
        this.setVisible(false);
        GESTION_CANDIDATOS C = new GESTION_CANDIDATOS(bd, can);
        C.setVisible(true);
        this.dispose();
    }

    void BAceptar_actionPerformed(ActionEvent e) {
        // creamos un objeto CANDIDATO e introducimos los datos
        CANDIDATOS c = new CANDIDATOS();
        boolean letr = false;
        boolean user = false;
        try {
            c.vacio("Usuario", IUsuario.getText());
            c.setusuario(IUsuario.getText());
            String pass = new String(IClave.getPassword());
            c.vacio("Clave", pass);
            c.setclave(pass);
            c.vacio("Nombre", INombre.getText());
            c.setnombre(INombre.getText());
            c.vacio("Apellidos", IApel1.getText());
            c.setapellidos(IApel1.getText());
            c.vacio("Direccion", IDireccion.getText());
            c.setdireccion(IDireccion.getText());
            c.setemail(IEmail.getText());
            c.vacio("Telefono", ITelefono.getText());
            int i = c.nums("Telefono", ITelefono.getText());
            c.settelefono(i);
            c.vacio("Dia", IDia.getText());
            i = c.nums("Dia", IDia.getText());
            c.dia(i);
            c.setdia(i);
            c.vacio("Mes", IMes.getText());
            i = c.nums("Mes", IMes.getText());
            c.mes(i);
            c.setmes(i);
            c.vacio("Año", año.getText());
            i = c.nums("Año", año.getText());
            c.anyo(i);
            c.setanyo(i);
            c.setcoche(COCHE.isSelected());
            c.setdispviajar(DISPV.isSelected());
            c.vacio("Experiencia", TExperiencia.getText());
            i = c.nums("Experiencia", TExperiencia.getText());
            c.setexperiencia(i);
            c.setcarnet(CARNET.isSelected());
            c.setestudios(TESTUDIOS.getText());
            c.setotrosconoz(TOTROS.getText());
            c.setvidalabor(BVIDA.getText());
            letr = true;
        } catch (VACIOException h) { // Para los vacio
            h.getError();
        } catch (NUMSException f) { // Para las excepciones de numeros
            f.getError();
        } catch (FECHAException g) { // Para la fecha mal introducida
            g.getError();
        }

        if (letr) {
            this.dispose();
            this.setVisible(false);
            user = bd.actualizarCandidato(c);
            int n[];
            n = LISTA1.getSelectedRows();
            for (int j = 0; j < n.length; j++) {
                String s = LISTA1.getValueAt(n[j], 0).toString();

                Integer cod = Integer.valueOf(-1);
                try {
                    cod = Integer.valueOf(s);
                } catch (Exception ex) {
                    // no puede dar error porque en la BD son int's
                }
                Integer ma = Integer.valueOf(-1);
                if (!bd.sacarUnConocimiento(c.getusuario(), cod.intValue())) // asi no mete los conoc que ya tenemos
                    bd.insertaCandCono(c.getusuario(), cod.intValue());
            } // for

            if (user) {
                this.setVisible(false);
                GESTION_CANDIDATOS C = new GESTION_CANDIDATOS(bd, c);
                C.setVisible(true);
                this.dispose();
            } else {
                this.setVisible(false);
                ventanainicial v = new ventanainicial(bd);
                v.setVisible(true);
                this.dispose();
            } // else
        } // if
    }

    void BMENOS_actionPerformed(ActionEvent e) {

    }

    void BMAS_actionPerformed(ActionEvent e) {

    }///////// funcion
}// clase
