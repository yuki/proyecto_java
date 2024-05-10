package clases;

public class CUENTA_SOLICITUDES {
    private int o_cod;
    private int cont;

    public CUENTA_SOLICITUDES() {
        this.o_cod = 0;
        this.cont = 0;
    }

    public void setocod(int c) {
        this.o_cod = c;
    }

    public void setcont(int k) {
        this.cont = k;
    }

    public int getocod() {
        return this.o_cod;
    }

    public int getcont() {
        return this.cont;
    }
}
