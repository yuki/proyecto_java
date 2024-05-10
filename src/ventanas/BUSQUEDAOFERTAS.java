package ventanas;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;
import clases.*;
import excep.*;
import gesql.*;

public class BUSQUEDAOFERTAS extends JFrame {
    Gestor bd = new Gestor();
    CANDIDATOS can = new CANDIDATOS();
    JLabel LTITULO = new JLabel();
    JButton BCANCEL = new JButton();
    JButton BACEP = new JButton();
    JCheckBox Ltitulo = new JCheckBox();
    JTextField Ttitulo = new JTextField();
    JCheckBox Llugar = new JCheckBox();
    JTextField TLugar = new JTextField();
    JCheckBox Ltipo = new JCheckBox();
    JCheckBox Lempresa = new JCheckBox();
    JTextField Tempresa = new JTextField();
    JCheckBox Lsueldo = new JCheckBox();
    JTextField Tsueldo = new JTextField("");
    JCheckBox Lexperiencia = new JCheckBox();
    JCheckBox Lconocimiemto = new JCheckBox();
    JTextField Texperiencia = new JTextField("");
    // JComboBox CONOCIMIENTOS = new JComboBox();
    JTable CONOCIMIENTOS;
    Object[] data;
    Object[][] lin;
    JScrollPane jScrollPane1 = new JScrollPane();
    JComboBox CONTRATO = new JComboBox();

    public BUSQUEDAOFERTAS(Gestor con, CANDIDATOS candidato) {
        try {
            bd = con;
            can = candidato;
            jbInit(bd, can);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit(Gestor con, CANDIDATOS candidato) throws Exception {
        String indc = "Indef. t.completo";
        String indp = "Indef. t.parcial";
        String temc = "Temp. t.completo";
        String temp = "Temp t.parcial";
        CONTRATO.addItem((Object) indc);
        CONTRATO.addItem((Object) indp);
        CONTRATO.addItem((Object) temc);
        CONTRATO.addItem((Object) temp);
        data = new Object[2];
        data[0] = "cod";
        data[1] = "nombre";
        lin = bd.sacarConocimientos();
        CONOCIMIENTOS = new JTable(lin, data);
        LTITULO.setFont(new java.awt.Font("Serif", 0, 30));
        LTITULO.setText("BUSQUEDA OFERTAS EMPLEO");
        LTITULO.setBounds(new Rectangle(14, 3, 461, 89));
        this.getContentPane().setLayout(null);
        BCANCEL.setText("CANCELAR");
        BCANCEL.setBounds(new Rectangle(291, 410, 124, 32));
        BCANCEL.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent e) {
                BCANCEL_actionPerformed(e);
            }
        });
        BACEP.setText("ACEPTAR");
        BACEP.setBounds(new Rectangle(98, 411, 126, 31));
        BACEP.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent e) {
                BACEP_actionPerformed(e);
            }
        });
        this.getContentPane().setBackground(Color.white);
        Ltitulo.setToolTipText("Seleccione si desea este tipo de busqueda");
        Ltitulo.setBackground(Color.white);
        Ltitulo.setText("Titulo:");
        Ltitulo.setBounds(new Rectangle(24, 110, 80, 31));
        Ltitulo.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Ltitulo_actionPerformed(e);
            }
        });
        Ttitulo.setEnabled(false);
        Ttitulo.setBounds(new Rectangle(138, 111, 120, 29));
        Llugar.setToolTipText("Seleccione si desea este tipo de busqueda");
        Llugar.setBackground(Color.white);
        Llugar.setText("Lugar");
        Llugar.setBounds(new Rectangle(22, 167, 61, 24));
        Llugar.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Llugar_actionPerformed(e);
            }
        });
        TLugar.setEnabled(false);
        TLugar.setBounds(new Rectangle(139, 160, 119, 32));
        Ltipo.setToolTipText("Seleccione si desea este tipo de busqueda");
        Ltipo.setBackground(Color.white);
        Ltipo.setText("Tipo de contrato");
        Ltipo.setBounds(new Rectangle(20, 218, 108, 27));
        Ltipo.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Ltipo_actionPerformed(e);
            }
        });
        Lempresa.setToolTipText("Seleccione si desea este tipo de busqueda");
        Lempresa.setBackground(Color.white);
        Lempresa.setText("Empresa");
        Lempresa.setBounds(new Rectangle(20, 263, 79, 25));
        Lempresa.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Lempresa_actionPerformed(e);
            }
        });
        Tempresa.setBounds(new Rectangle(143, 267, 116, 32));
        Lsueldo.setToolTipText("Seleccione si desea este tipo de busqueda");
        Lsueldo.setBackground(Color.white);
        Lsueldo.setText("Sueldo");
        Lsueldo.setBounds(new Rectangle(303, 110, 66, 25));
        Lsueldo.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Lsueldo_actionPerformed(e);
            }
        });
        Tsueldo.setBounds(new Rectangle(444, 104, 103, 28));
        Lexperiencia.setToolTipText("Seleccione si desea este tipo de busqueda");
        Lexperiencia.setBackground(Color.white);
        Lexperiencia.setText("experiencia");
        Lexperiencia.setBounds(new Rectangle(300, 162, 86, 25));
        Lexperiencia.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Lexperiencia_actionPerformed(e);
            }
        });
        Lconocimiemto.setToolTipText("Seleccione si desea este tipo de busqueda");
        Lconocimiemto.setBackground(Color.white);
        Lconocimiemto.setText("Conocimiento");
        Lconocimiemto.setBounds(new Rectangle(304, 216, 101, 25));
        Lconocimiemto.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Lconocimiemto_actionPerformed(e);
            }
        });
        Texperiencia.setBounds(new Rectangle(446, 157, 102, 29));
        jScrollPane1.setBounds(new Rectangle(422, 211, 138, 85));
        CONTRATO.setBounds(new Rectangle(130, 219, 149, 23));
        this.getContentPane().add(BCANCEL, null);
        this.getContentPane().add(BACEP, null);
        this.getContentPane().add(Ltitulo, null);
        this.getContentPane().add(Llugar, null);
        this.getContentPane().add(Ltipo, null);
        this.getContentPane().add(Lempresa, null);
        this.getContentPane().add(TLugar, null);
        this.getContentPane().add(Ttitulo, null);
        this.getContentPane().add(Tempresa, null);
        this.getContentPane().add(LTITULO, null);
        this.getContentPane().add(Texperiencia, null);
        this.getContentPane().add(Tsueldo, null);
        this.getContentPane().add(Lconocimiemto, null);
        this.getContentPane().add(Lexperiencia, null);
        this.getContentPane().add(Lsueldo, null);
        this.getContentPane().add(jScrollPane1, null);
        this.getContentPane().add(CONTRATO, null);
        jScrollPane1.getViewport().add(CONOCIMIENTOS, null);
        this.getContentPane().add(Lexperiencia, null);
        String TITULO = "Titulo";
        String LUGAR = "Lugar";
        String TIPOCONTRAT = "Tipo contrato";
        String EMPR = "Empresa";
        String SUELDO = "Sueldo";
        String EXPERIENCIA = "Experiancia";
        String CONOCIMIENTO = "Conocimiento";
        Tsueldo.setEnabled(false);
        Texperiencia.setEnabled(false);
        TLugar.setEnabled(false);
        Tempresa.setEnabled(false);
        Ttitulo.setEnabled(false);
        CONOCIMIENTOS.setEnabled(false);
        CONTRATO.setEnabled(false);
        this.setSize(565, 490);
    }

    void BCANCEL_actionPerformed(ActionEvent e) {
        this.setVisible(false);
        GESTION_CANDIDATOS C = new GESTION_CANDIDATOS(bd, can);
        C.setVisible(true);
        this.dispose();
    }

    void BENVIAR_actionPerformed(ActionEvent e) {

    }

    void BACEP_actionPerformed(ActionEvent e) {
        String titulo = "";
        String lugar = "";
        String cont = "";
        String emp = "";
        int su = -1;
        int exp = -1;
        String con = "";
        boolean bien = true;
        if (Ltitulo.isSelected())
            titulo = Ttitulo.getText();
        else
            titulo = "";
        if (Llugar.isSelected())
            lugar = TLugar.getText();
        else
            lugar = "";
        if (Ltipo.isSelected())
            cont = (String) CONTRATO.getSelectedItem();
        else
            cont = "";
        if (Lempresa.isSelected())
            emp = Tempresa.getText();
        else
            emp = "";
        if (Lsueldo.isSelected()) {
            Integer un = Integer.valueOf(-1);
            try {
                un = Integer.valueOf(Tsueldo.getText());
                su = un.intValue();
            } catch (Exception exc) {
                bien = false;
                JOptionPane jar = new JOptionPane();
                jar.showMessageDialog(null,
                        "El campo 'Sueldo' y 'Experiencia' solo acepta numeros\n Introduzca SOLO numeros",
                        "Error inserccion de datos", JOptionPane.ERROR_MESSAGE);
            }

        } else
            su = -1;
        if (Lexperiencia.isSelected()) {
            Integer dos = Integer.valueOf(-1);
            try {
                dos = Integer.valueOf(Texperiencia.getText());
                exp = dos.intValue();
            } catch (Exception exc) {
                bien = false;
                JOptionPane jar = new JOptionPane();
                jar.showMessageDialog(null,
                        "El campo 'Sueldo' y 'Experiencia' solo acepta numeros\n Introduzca SOLO numeros",
                        "Error inserccion de datos", JOptionPane.ERROR_MESSAGE);
            }
        } else
            exp = -1;
        if (Lconocimiemto.isSelected()) {
            // con=(String)CONOCIMIENTOS.getSelectedItem();
            int n = CONOCIMIENTOS.getSelectedRow();
            con = CONOCIMIENTOS.getValueAt(n, 1).toString();
        } else
            con = "";
        Object[][] v = bd.BusquedaOfertas(titulo, lugar, cont, emp, su, exp, con);
        OFERTASENCONTRADAS ofert = new OFERTASENCONTRADAS(bd, can, v);
        this.setVisible(false);
        ofert.setVisible(true);
        this.dispose();
    }// fin boton aceptar

    void Ltitulo_actionPerformed(ActionEvent e) {
        if (Ltitulo.isSelected())
            Ttitulo.setEnabled(true);
        else {
            Ttitulo.setEnabled(false);
            Ttitulo.setText("");
        }
    }

    void Llugar_actionPerformed(ActionEvent e) {
        if (Llugar.isSelected())
            TLugar.setEnabled(true);
        else {
            TLugar.setEnabled(false);
            TLugar.setText("");
        }
    }

    void Ltipo_actionPerformed(ActionEvent e) {
        if (Ltipo.isSelected())
            CONTRATO.setEnabled(true);
        else {
            CONTRATO.setEnabled(false);
            // CONTRATO.setText("");
        }
    }

    void Lempresa_actionPerformed(ActionEvent e) {
        if (Lempresa.isSelected())
            Tempresa.setEnabled(true);
        else {
            Tempresa.setEnabled(false);
            Tempresa.setText("");
        }
    }

    void Lsueldo_actionPerformed(ActionEvent e) {
        if (Lsueldo.isSelected())
            Tsueldo.setEnabled(true);
        else {
            Tsueldo.setEnabled(false);
            Tsueldo.setText("");
        }
    }

    void Lexperiencia_actionPerformed(ActionEvent e) {
        if (Lexperiencia.isSelected())
            Texperiencia.setEnabled(true);
        else {
            Texperiencia.setEnabled(false);
            Texperiencia.setText("");
        }
    }

    void Lconocimiemto_actionPerformed(ActionEvent e) {
        if (Lconocimiemto.isSelected())
            CONOCIMIENTOS.setEnabled(true);
        else {
            CONOCIMIENTOS.setEnabled(false);
            // CONOCIMIENTOS.setText("");
        }
    }

}
