package clases;

import excep.*;

public class EMPRESAS {
    private String USUARIO;
    private String CLAVE;
    private String NOM;
    private int CIF;
    private String DIR;
    private int TELEF;
    private String EMAIL;
    private String DESC;
    private String CONTACT;

    public EMPRESAS() {
        USUARIO = new String();
        CLAVE = new String();
        NOM = new String();
        CIF = 0;
        DIR = new String();
        TELEF = 0;
        EMAIL = new String();
        DESC = new String();
        CONTACT = new String();

    }

    public EMPRESAS(String u, String cl, String n, int c, String d, int t, String e, String de, String co)// CONSTRUCTOR
    {
        USUARIO = new String(u);
        CLAVE = new String(cl);
        NOM = new String(n);
        CIF = c;
        DIR = new String(d);
        TELEF = t;
        EMAIL = new String(e);
        DESC = new String(de);
        CONTACT = new String(co);
    }

    // ***************************************METODOS SET Y
    // GET********************************

    // ------------------------------------------------------------------------------
    public String getusuario() {
        return USUARIO;
    }
    // ------------------------------------------------------------------------------

    public void setusuario(String u) {
        USUARIO = u;
    }

    // ------------------------------------------------------------------------------
    public String getclave() {
        return CLAVE;
    }

    // -----------------------------------------------------------------------------
    public void setclave(String c) {
        CLAVE = c;
    }

    // ------------------------------------------------------------------------------
    public String getnombre() {
        return NOM;
    }

    // ------------------------------------------------------------------------------
    public void setnombre(String n) {
        NOM = n;
    }

    // -----------------------------------------------------------------------------
    public int getcif() {
        return CIF;
    }

    // -----------------------------------------------------------------------------
    public void setcif(int c) {
        CIF = c;
    }

    // -----------------------------------------------------------------------------
    public String getdir() {
        return DIR;
    }

    // -----------------------------------------------------------------------------
    public void setdir(String d) {
        DIR = d;
    }

    // ----------------------------------------------------------------------------
    public int gettelefono() {
        return TELEF;
    }

    // ----------------------------------------------------------------------------
    public void settelefono(int t) {
        TELEF = t;
    }

    // ----------------------------------------------------------------------------
    public String getemail() {
        return EMAIL;
    }

    // ----------------------------------------------------------------------------
    public void setemail(String e) {
        EMAIL = e;
    }

    // ----------------------------------------------------------------------------
    public String getdesc() {
        return DESC;
    }

    // ----------------------------------------------------------------------------
    public void setdesc(String d) {
        DESC = d;
    }

    // ----------------------------------------------------------------------------
    public String getcontacto() {
        return CONTACT;
    }

    // ---------------------------------------------------------------------------
    public void setcontacto(String c) {
        CONTACT = c;
    }
    // ------------------------------------------------------------------------------

    public void vacio(String nom, String s) throws VACIOException {
        int i = s.length();
        if (i == 0)
            throw new VACIOException(nom);
    }
    // -------------------------------------------------------------------------------

    public int nums(String nom, String s) throws NUMSException {
        try {
            int j = Integer.parseInt(s);
            return j;
        } catch (NumberFormatException e) {
            throw new NUMSException(nom);
        }
    }
    // ***********************************************************************************
}
