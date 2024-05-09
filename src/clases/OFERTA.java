package CLASES;
import EXCEP.*;
import java.util.Calendar;

public class OFERTA {
	
	 private int CODOFERTA;
	 private String TITULO;
	 private String DESCRIP;
	 private String LUGAR;
	 private String CONTRATO;
	 private int SUELDOMIN;
	 private int SUELDOMAX;
	 private int EXPERIENCIA;
	 String SEVALORARA;
	 String IMPRESCINDIBLE;
	 private int DIA;
	 private int MES;
	 private int ANYO;
	 private boolean ESTADO;
	 private String USUARIOEMP;
 
 
 
	 public  OFERTA()
	 {
	 CODOFERTA =0;
	 TITULO =new String();
	 DESCRIP=new String();
	 LUGAR =new String();
	 CONTRATO=new String();
	 SUELDOMIN=0;
	 EXPERIENCIA=0;
	 SEVALORARA=new String();
	 IMPRESCINDIBLE=new String();
	 DIA=0;
	 MES=0;
	 ANYO=0;
	 ESTADO=false;
	 USUARIOEMP=new String();
	 }


	/**
	 * @return
	 */
	public int getCODOFERTA() {
		return CODOFERTA;
	}

	/**
	 * @return
	 */
	public String getCONTRATO() {
		return CONTRATO;
	}

	/**
	 * @return
	 */
	public String getDESCRIP() {
		return DESCRIP;
	}

	/**
	 * @return
	 */
	public boolean isESTADO() {
		return ESTADO;
	}

	/**
	 * @return
	 */
	public int getEXPERIENCIA() {
		return EXPERIENCIA;
	}

	/**
	 * @return
	 */
	public int getDIA() {
		return DIA;
	}

	public int getMES() {
		return MES;
	}


	public int getANYO() {
		return ANYO;
	}

	/**
	 * @return
	 */
	public String getIMPRESCINDIBLE() {
		return IMPRESCINDIBLE;
	}

	/**
	 * @return
	 */
	public String getLUGAR() {
		return LUGAR;
	}

	/**
	 * @return
	 */
	public String getSEVALORARA() {
		return SEVALORARA;
	}

	/**
	 * @return
	 */
	public int getSUELDOMAX() {
		return SUELDOMAX;
	}

	/**
	 * @return
	 */
	public int getSUELDOMIN() {
		return SUELDOMIN;
	}

	/**
	 * @return
	 */
	public String getTITULO() {
		return TITULO;
	}

	/**
	 * @return
	 */
	public String getUSUARIOEMP() {
		return USUARIOEMP;
	}

	/**
	 * @param string
	 */
	public void setCODOFERTA(int num) {
		CODOFERTA = num;
	}

	/**
	 * @param string
	 */
	public void setCONTRATO(String string) {
		CONTRATO = string;
	}

	/**
	 * @param string
	 */
	public void setDESCRIP(String string) {
		DESCRIP = string;
	}

	/**
	 * @param b
	 */
	public void setESTADO(boolean b) {
		ESTADO = b;
	}

	/**
	 * @param b
	 */
	public void setEXPERIENCIA(int b) {
		EXPERIENCIA = b;
	}

	/**
	 * @param i
	 */
	public void setDIA(int d) {
		DIA = d;
	}

	public void setMES(int m) {
		MES = m;
	}

	public void setANYO(int a) {
		ANYO = a;
	}

	/**
	 * @param string
	 */
	public void setIMPRESCINDIBLE(String string) {
		IMPRESCINDIBLE = string;
	}

	/**
	 * @param string
	 */
	public void setLUGAR(String string) {
		LUGAR = string;
	}

	/**
	 * @param string
	 */
	public void setSEVALORARA(String string) {
		SEVALORARA = string;
	}

	/**
	 * @param i
	 */
	public void setSUELDOMAX(int i) {
		SUELDOMAX = i;
	}

	/**
	 * @param i
	 */
	public void setSUELDOMIN(int i) {
		SUELDOMIN = i;
	}

	/**
	 * @param string
	 */
	public void setTITULO(String string) {
		TITULO = string;
	}

	/**
	 * @param string
	 */
	public void setUSUARIOEMP(String string) {
		USUARIOEMP = string;
	}

public void mes (int i) throws FECHAException { 
   if (i<1 | i>12)
       throw new FECHAException(2);
}

public void dia (int i) throws FECHAException { 
   if (i<1 | i>31)
       throw new FECHAException(1);
}


public void anyo (int i) throws FECHAException { 
   Calendar fecha = Calendar.getInstance();
   int j = fecha.get(fecha.YEAR);
   if (i<j-50 | i>j-16) //queremos gente de edad entre 16 y 50 años
       throw new FECHAException(3);
}

public void vacio (String nom, String s) throws VACIOException{
   int i=s.length();
   if (i==0)
	   throw new VACIOException(nom);
}
//-------------------------------------------------------------------------------

public int nums(String nom,String s) throws NUMSException {
	try{
	   int j = Integer.parseInt(s);
	   return j;
    }
	catch(NumberFormatException e){
	   throw new NUMSException(nom);
    }
}

public void mayor(int may,int min) throws MAYORException{
	if (may<min)
		throw new MAYORException();
}

}
