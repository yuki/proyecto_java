package clases;

public class SOLICITUD {
    private int codigo;
    private int coferta;
    private String user;
    private int dia;
    private int mes;
    private int anyo;

    public SOLICITUD() {
        codigo = 0;
        coferta = 0;
        user = "";
        dia = 0;
        mes = 0;
        anyo = 0;
    }

    public int getcodigo() {
        return codigo;
    }

    public int getcoferta() {
        return coferta;
    }

    public String getuser() {
        return user;
    }

    public int getdia() {
        return dia;
    }

    public int getmes() {
        return mes;
    }

    public int getanyo() {
        return anyo;
    }

    public void setcodigo(int c) {
        codigo = c;
    }

    public void setcoferta(int c) {
        coferta = c;
    }

    public void setuser(String s) {
        user = s;
    }

    public void setdia(int d) {
        dia = d;
    }

    public void setmes(int m) {
        mes = m;
    }

    public void setanyo(int a) {
        anyo = a;
    }
}
