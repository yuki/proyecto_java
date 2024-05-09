package CLASES;

import EXCEP.*;

public class CONOCIMIENTO {
	
	private int CODCONOC;
	private String NOMBRE;
	
	public CONOCIMIENTO()
	{
	CODCONOC=0;
	NOMBRE=new String("");
	}

	public int getCODCONOC() {
		return CODCONOC;
	}

	public String getNOMBRE() {
		return NOMBRE;
	}

	public void setCODCONOC(int i) {
		CODCONOC = i;
	}

	public void setNOMBRE(String string) {
		NOMBRE = string;
	}
	
public int nums(String nom,String s) throws NUMSException {
	try{
	   int j = Integer.parseInt(s);
	   return j;
    }
	catch(NumberFormatException e){
	   throw new NUMSException(nom);
    }
}

public void vacio (String nom, String s) throws VACIOException{
   int i=s.length();
   if (i==0)
	   throw new VACIOException(nom);
}

}
