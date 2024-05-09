package CLASES;

import EXCEP.*;
import java.util.Calendar;

public class CANDIDATOS {
private String USUARIO;
private String CLAVE;
private String NOMBRE;
private String APELL;
private String DIREC;
private int TEL;
private String EMAIL;
private int DIA;
private int MES;
private int ANYO;
private boolean CARNET;
private boolean COCHE;
private boolean DISPVIAJ;
private int EXPERIENCIA;
private String ESTUDIOS;
private String OTROSC;
private String VIDALABOR;


public CANDIDATOS ()//CONSTRUCTOR
{
 USUARIO=new String("");	
 CLAVE=new String("");
 NOMBRE=new String("");
 APELL=new String("");
 DIREC=new String ("");
 TEL=0;
 EMAIL=new String("");
 DIA=0;
 MES=0;
 ANYO=0;
 CARNET=false;
 COCHE=false;
 DISPVIAJ=false;
 EXPERIENCIA=0;
 ESTUDIOS=new String("");
 OTROSC=new String("");
 VIDALABOR=new String("");
}


//*******************************METODOS SET Y GET*****************************************************************


//---------------------------------------------------------------
public String   getusuario()
{
return USUARIO;
}
//---------------------------------------------------------------
public void setusuario(String u)
{
USUARIO=u;
}
//--------------------------------------------------------------
public String getclave()
{
return CLAVE;
}
//----------------------------------------------------------------
public void setclave(String cl)
{
CLAVE=cl;
}
//----------------------------------------------------------------
public String getnombre()
{
return NOMBRE;
}
//----------------------------------------------------------------
public  void setnombre(String n)
{
NOMBRE=n;
}
//-----------------------------------------------------------------
public String getapellidos()
{
return APELL;
}
//----------------------------------------------------------------
public  void setapellidos(String a)
{
APELL=a;
}
//---------------------------------------------------------------
public String getdireccion()
{
return DIREC;
}
//---------------------------------------------------------------
public  void setdireccion(String d)
{
DIREC=d;
}
//---------------------------------------------------------------
public int gettelefono()
{
return TEL;
}
//---------------------------------------------------------------
public   void settelefono(int t)
{
TEL=t;
}
//-----------------------------------------------------------------

public String getemail()
{
return EMAIL;
}	
//-----------------------------------------------------------------
public  void setemail(String e)
{
EMAIL=e;
}
//-------------------------------------------------------
public int getdia()
{
return DIA;
}
//-----------------------------------------------------------------
public  void setdia(int d)
{
DIA=d;
}
//-------------------------------------------------------
public int getmes()
{
return MES;
}
//-----------------------------------------------------------------
public  void setmes(int m)
{
MES=m;
}
//-------------------------------------------------------
public int getanyo()
{
return ANYO;
}
//-----------------------------------------------------------------
public  void setanyo(int a)
{
ANYO=a;
}
//-----------------------------------------------------------------
public boolean getcarnet()
{
return CARNET;  
}
//------------------------------------------------------------------
public  void setcarnet(boolean c)
{
CARNET=c;
}
//-----------------------------------------------------------------
public boolean getcoche()
{
return COCHE;
}
//------------------------------------------------------------------
public  void setcoche(boolean co)
{
COCHE=co;
}
//-----------------------------------------------------------------
public boolean getdispviajar()
{
return DISPVIAJ;
}
//---------------------------------------------------------------
public  void setdispviajar(boolean v)
{
DISPVIAJ=v;
}
//-------------------------------------------------------------------
public int getexperiencia()
{
return EXPERIENCIA;
}
//-----------------------------------------------------------------
public  void setexperiencia(int e)
{
EXPERIENCIA=e;
}
//---------------------------------------------------------------
public String getestudios()
{
return ESTUDIOS;
}
//-----------------------------------------------------------------
public  void setestudios(String es)
{
ESTUDIOS=es;
}
//----------------------------------------------------------------
public String getotrosconoz()
{
return OTROSC;
}
//-----------------------------------------------------------------
public  void setotrosconoz(String o)
{
OTROSC=o;
}
//-----------------------------------------------------------------
public  String getvidalabor()
{
return VIDALABOR;
}
//----------------------------------------------------------------
public  void setvidalabor(String vi)
{
VIDALABOR=vi;
}
//----------------------------------------------------------------
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
//******************************************************************************************************************
}
