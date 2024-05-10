package ventanas;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import clases.*;
import excep.*;
import gesql.*;

public class ELEGIRSOL extends JFrame {
    Gestor bd = new Gestor();
    EMPRESAS emp = new EMPRESAS();
    JLabel LRECIBIDO = new JLabel();
    // JLabel LSus = new JLabel();
    JButton BVer = new JButton();
    JButton BCancelar = new JButton();
    JButton MIRAR = new JButton();
    JScrollPane jScrollPane1 = new JScrollPane();
    JScrollPane jScrollPane2 = new JScrollPane();
    /*
     * JTable TABLA1;// = new JTable();
     * Object[] data1;
     * Object[][] lin1;
     */
    JTable TABLA2;// = new JTable();
    Object[] data2;
    Object[][] lin2;
    int codoferta;

    public ELEGIRSOL(Gestor con, EMPRESAS empresa, int cod) {
        try {
            bd = con;
            emp = empresa;
            codoferta = cod;
            jbInit(bd, emp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit(Gestor bd, EMPRESAS emp) throws Exception {
        /*
         * data1 = new Object[2];
         * data1[0]="cod. oferta";
         * data1[1]="titulo";
         */
        data2 = new Object[4];
        data2[0] = "Usuario";
        data2[1] = "Dia";
        data2[2] = "Mes";
        data2[3] = "Anyo";
        lin2 = bd.sacarSolicitudes(codoferta);
        // lin2[0][0]="ieeeeeeeee";
        // lin2[1][0]="djlfs";
        // lin2[2][0]="lsjdalf";*/
        TABLA2 = new JTable(lin2, data2);
        // lin1 = bd.ConsultarCodOferta(emp.getusuario());
        // TABLA1 = new JTable (lin1,data1);
        LRECIBIDO.setFont(new java.awt.Font("Serif", 0, 50));
        LRECIBIDO.setText("Elija solicitud");
        LRECIBIDO.setBounds(new Rectangle(137, 72, 436, 87));
        this.getContentPane().setLayout(null);
        // LSus.setText("Sus ofertas publicadas");
        // LSus.setBounds(new Rectangle(51, 163, 137, 28));
        BVer.setToolTipText("Vea el curriculum del candidato selecionado");
        BVer.setText("Ver candidato");
        BVer.setBounds(new Rectangle(67, 388, 154, 47));
        BVer.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent e) {
                BVer_actionPerformed(e);
            }
        });
        BCancelar.setText("Cancelar");
        BCancelar.setBounds(new Rectangle(392, 388, 154, 49));
        BCancelar.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent e) {
                BCancelar_actionPerformed(e);
            }
        });
        this.getContentPane().setBackground(Color.white);
        // RAR.setText("----->");
        // RAR.setBounds(new Rectangle(234, 274, 131, 42));
        // MIRAR.addActionListener(new java.awt.event.ActionListener() {

        // public void actionPerformed(ActionEvent e) {
        // MIRAR_actionPerformed(e);
        // }
        // });
        // jScrollPane1.setBounds(new Rectangle(44, 208, 170, 142));
        jScrollPane2.setBounds(new Rectangle(118, 193, 306, 176));
        // this.getContentPane().add(LSus, null);
        this.getContentPane().add(BVer, null);
        this.getContentPane().add(BCancelar, null);
        // this.getContentPane().add(MIRAR, null);
        // this.getContentPane().add(jScrollPane1, null);
        // jScrollPane1.getViewport().add(TABLA1, null);
        this.getContentPane().add(jScrollPane2, null);
        this.getContentPane().add(LRECIBIDO, null);
        jScrollPane2.getViewport().add(TABLA2, null);
        this.setSize(625, 497);
    }

    void BCancelar_actionPerformed(ActionEvent e) {
        this.setVisible(false);
        GESTION_EMPRESAS E = new GESTION_EMPRESAS(bd, emp);
        E.setVisible(true);
        this.dispose();
    }

    /*
     * void MIRAR_actionPerformed(ActionEvent e) {
     * int n = TABLA1.getSelectedRow();
     * if (n!=-1){
     * String i = TABLA1.getValueAt(n,0).toString();
     * Integer k = new Integer (i);
     * //System.out.println(k);
     * //this.data2=new Object[1];
     * //this.data2[0]="cod. solicitud";
     * //lin2 = new Object[1][1];
     * Object[][] m=new Object[1][1];
     * m[0][0]="lajds";
     * TABLA2.removeAll();
     * TABLA2 = new JTable (m,data2);
     * //lin2[0][0]="zokete";
     * //TABLA2 = new JTable(lin1,data1);
     * /*lin2 = bd.OfertasASolicitudes(k.intValue());
     * System.out.println(lin2[1][0].toString());
     * //lin2= new Object[0][1];
     * System.out.println (k.intValue());
     * TABLA2 = new JTable (lin2,data2);
     * 
     * }
     * //if (n!=1){
     * //}
     * else System.out.println("BIEN");
     * 
     * 
     * }
     */
    void BVer_actionPerformed(ActionEvent e) {
        int n = TABLA2.getSelectedRow();
        if (n != -1) {
            String user = TABLA2.getValueAt(n, 0).toString();
            System.out.println(user);
            CANDIDATOS c = new CANDIDATOS();
            c = bd.ConsultarCandidato(user);
            SACARCAND sa = new SACARCAND(bd, emp, c);
            this.setVisible(false);
            sa.setVisible(true);
            this.dispose();
        } else {
            JOptionPane j = new JOptionPane();
            j.showMessageDialog(null,
                    "Debe seleccionar una de las solicitudes que le han sido enviadas\nPinche sobre una solicitud en la tabla",
                    "Error, seleccione solicitud", JOptionPane.ERROR_MESSAGE);
        }
    }
}
