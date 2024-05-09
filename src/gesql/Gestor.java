package GESQL;

import CLASES.*;
import EXCEP.*;
import javax.swing.*;
import java.util.Vector;
import java.sql.*;
import EXCEP.*;


public class Gestor
{

String driver = "org.postgresql.Driver";
String url = "jdbc:postgresql://localhost:5432/test1";
String user = "bases";
String passw = "";
Connection db;
Statement st;
ResultSet rs;

public void CargarDriver () {
   try {
      Class.forName (this.driver);
   }
   catch (ClassNotFoundException e) {
       JOptionPane j = new JOptionPane();
	   j.showMessageDialog(null,"No se ha podido encontrar el driver para hacer la conexion a la Base de Datos\n El programa terminará ahora","ERROR en driver",j.ERROR_MESSAGE); 
	   System.exit(0);
   }
}


public void ConexionBD () {
     try{
	   this.db = DriverManager.getConnection(this.url, this.user, this.passw);
     } 
     catch (SQLException e){ 
	    JOptionPane j = new JOptionPane();
	    j.showMessageDialog(null,"No se ha podido acceder a la Base de Datos\n El programa terminará ahora.","ERROR en conexion",j.ERROR_MESSAGE); 
		System.exit(0);
	 }
}


public void CortarConexionBD () {
      try {
         this.db.close();
      }
      catch (SQLException e){ 
	      JOptionPane j = new JOptionPane();
	      j.showMessageDialog(null,"NO se ha podido cortar la conexion","ERROR en conexion",j.ERROR_MESSAGE); 
	  }
}

public void consultarBD(String consulta){
   try{
      this.st = db.createStatement();
      this.rs = this.st.executeQuery(consulta);
   }
   catch (SQLException e){ 
	  //JOptionPane j = new JOptionPane();
	  //j.showMessageDialog(null,"NO se ha podido realizar la consulta","ERROR en consulta",j.ERROR_MESSAGE); 
   }
}

public void cerrarConsulta (){
      try{
         this.rs.close();
         this.st.close();
      }
      catch (SQLException e){ 
	     JOptionPane j = new JOptionPane();
	     j.showMessageDialog(null,"NO se ha podido cerrar la consulta","ERROR en consulta",j.ERROR_MESSAGE); 
	  }
}


public boolean insertarBD (String s){
   try{
      this.st = db.createStatement();
      this.st.executeUpdate(s);
	  return true;
   }
   catch (SQLException e){ 
	  JOptionPane j = new JOptionPane();
	   j.showMessageDialog(null,"NO se han podido insertar los datos","ERROR en inserccion",j.ERROR_MESSAGE);
	   return false;
   }
}

public void cerrarInsertar (){
      try{
         //this.rs.close();
         this.st.close();
      }
      catch (SQLException e){ 
	     JOptionPane j = new JOptionPane();
	     j.showMessageDialog(null,"NO se ha podido cerrar la inserccion","ERROR en insertar",j.ERROR_MESSAGE); 
	  }
}


public CANDIDATOS ExisteCandidato (String user, String pass) throws NOExisteUsuarioException{
    this.consultarBD("SELECT * FROM candidatos WHERE c_user='"+user+"' AND c_clave='"+pass+"';");
	 try{
        // if (this.rs.next()){
		this.rs.next();
		    //ESTO SE PODRIA PONER EN UNA FUNCION
			CANDIDATOS c = new CANDIDATOS();
			 c.setusuario(rs.getString(1));
             c.setclave(rs.getString(2));
             c.setnombre(rs.getString(3));
             c.setapellidos(rs.getString(4));
             c.setdireccion(rs.getString(5));
             c.settelefono(rs.getInt(6));
             c.setemail(rs.getString(7));
             c.setdia(rs.getInt(8));
			 c.setmes(rs.getInt(9));
			 c.setanyo(rs.getInt(10));
             c.setcarnet(rs.getBoolean(11));
             c.setcoche(rs.getBoolean(12));
             c.setdispviajar(rs.getBoolean(13));
             c.setestudios(rs.getString(14));
             c.setotrosconoz(rs.getString(15));
             c.setexperiencia(rs.getInt(16));
             c.setvidalabor(rs.getString(17));
		    this.cerrarConsulta();
		    return c;
     }
     catch(SQLException e){
	    this.cerrarConsulta();
	    //no hay usuarios con ese nombre y password, por lo que lanzamos la exception
		throw new NOExisteUsuarioException(user);
     }
}

public boolean ExisteE (String user, String pass) {
    this.consultarBD("SELECT * FROM empresa WHERE e_user='"+user+"' AND e_clave='"+pass+"';");
	try{
	   if (this.rs.next())
	      return true;
	   else return false;//throw new NOExisteUsuarioException(user);
    }
     catch(SQLException e){
	    this.cerrarConsulta();
	    //no hay usuarios con ese nombre y password, por lo que NO lanzamos la exception
     }	
	 return false;
}

public EMPRESAS ExisteEmpresa (String user, String pass) throws NOExisteUsuarioException{
    this.consultarBD("SELECT * FROM empresa WHERE e_user='"+user+"' AND e_clave='"+pass+"';");
	 try{
		 this.rs.next();
		    EMPRESAS e = new EMPRESAS (rs.getString(1),rs.getString(2),rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9));
		    this.cerrarConsulta();
		    return e;
         }
     catch(SQLException er){
	    //this.cerrarConsulta();
	    //no hay usuarios con ese nombre y password, por lo que lanzamos la exception
		throw new NOExisteUsuarioException(user);
     }
}


public void ConsultarUsuario (String emp, String que,String c) throws ExisteUsuarioException{
    this.consultarBD("SELECT * FROM "+que+" WHERE "+c+"_user='"+emp+"';");
	 try{
         if (this.rs.next()){
		    this.cerrarConsulta();
			throw new ExisteUsuarioException(emp);
         }
     }
     catch(SQLException e){
	    this.cerrarConsulta();
	    //no hay usuarios con ese nombre por lo que no necesitamos usar la exception que nos lanza	  
     }
   this.cerrarConsulta();
}

public boolean InsertarCandidato (CANDIDATOS c){
   String s = new String ("INSERT INTO candidatos VALUES ('"+c.getusuario()+"','"+c.getclave()+"','"+c.getnombre()+"','"+c.getapellidos()+"','"+c.getdireccion()+"',"+c.gettelefono()+",'"+c.getemail()+"',"+c.getdia()+","+c.getmes()+","+c.getanyo()+",'"+c.getcarnet()+"','"+c.getcoche()+"','"+c.getdispviajar()+"','"+c.getestudios()+"','"+c.getotrosconoz()+"','"+c.getexperiencia()+"','"+c.getvidalabor()+"');");
   boolean bien = insertarBD(s);
   cerrarInsertar();
   if (bien) 
      return true;
   else return false;
}


public boolean actualizarCandidato (CANDIDATOS c){
   String s = new String ("UPDATE candidatos SET c_clave='"+c.getclave()+"',c_name='"+c.getnombre()+"',c_apel='"+c.getapellidos()+"',c_direccion='"+c.getdireccion()+"',c_telefono="+c.gettelefono()+",c_email='"+c.getemail()+"',dia="+c.getdia()+",mes="+c.getmes()+",anyo="+c.getanyo()+",carnet='"+c.getcarnet()+"',coche='"+c.getcoche()+"',viajar='"+c.getdispviajar()+"',estudios='"+c.getestudios()+"',otros='"+c.getotrosconoz()+"',experiencia='"+c.getexperiencia()+"',vida_labo='"+c.getvidalabor()+"' WHERE c_user='"+c.getusuario()+"'");
   boolean bien = insertarBD(s);
   cerrarInsertar();
   if (bien) 
      return true;
   else return false;
}

public boolean InsertarEmpresa (EMPRESAS emp){
   String s = new String ("INSERT INTO empresa VALUES ('"+emp.getusuario()+"','"+emp.getclave()+"','"+emp.getnombre()+"',"+emp.getcif()+",'"+emp.getdir()+"',"+emp.gettelefono()+",'"+emp.getemail()+"','"+emp.getdesc()+"','"+emp.getcontacto()+"');");
   boolean bien = insertarBD(s);
   cerrarInsertar();
   if (bien) 
      return true;
   else return false;
}


public void consultarConocimiento (int i) throws ExisteConocimientoException{
    this.consultarBD("SELECT * FROM conocimientos WHERE c_cod="+i+";");
	 try{
         if (this.rs.next()){
	    this.cerrarConsulta();
   	    throw new ExisteConocimientoException(i);
         }
     }
     catch(SQLException e){
	    this.cerrarConsulta();
	    //no hay conocimiento, por lo que no lanzamos la exception
     }
   this.cerrarConsulta();
}

public boolean sacarUnConocimiento(String can, int cod){
	String s = new String ("SELECT * FROM cand_conoz where c_user='"+can+"' AND c_cod="+cod+";");
	consultarBD(s);
	try{
		if (rs.next())
			return false;
		else return true;
	}
	catch (SQLException es){
	//no lanzamos el error porque no lo necesitamos
	}
	return false;
}

public void insertaCandCono (String can, int con){
	String s = new String("INSERT INTO cand_conoc VALUES ('"+can+"',"+con+");");
	boolean bien=insertarBD(s);
	cerrarInsertar();
}


public void InsertarConocimiento (CONOCIMIENTO con){
   String s = new String ("INSERT INTO conocimientos VALUES ("+con.getCODCONOC()+",'"+con.getNOMBRE()+"');");
   boolean bien = insertarBD(s);
   cerrarInsertar();
}


public Object[][] misConocimientos(String user, String como){
	String s =new String("SELECT c.c_cod, c.c_nombre FROM conocimientos c, cand_conoc ca WHERE ca.c_user= '"+user+"' AND c.c_cod"+como+"ca.c_cod ;");
	consultarBD(s);
	Object[][] can;
	try{
	    int i=0;
	    while(rs.next())
		i++;
	    cerrarConsulta();
	    can= new Object[i][2];
	    i=0;
	    consultarBD(s);
	    while (rs.next()){
		  can[i][0]=new Integer(rs.getInt(1));
		  can[i][1]=rs.getString(2);
		  i++;
	    }
	    cerrarConsulta();
	    return can;
	}
	catch (SQLException ex){
	//si da error es que el usuario no tiene conocimientos
	}
	can = new Object[0][2];//vacio
	return can;
}


public Object[][]  sacarConocimientos (){
	String s = new String ("SELECT * FROM conocimientos;");
	consultarBD(s);
	Object[][] con;
	try{
		int i=0;
		while (this.rs.next())
			i++;
		con = new Object [i][2];
		cerrarConsulta();
		consultarBD(s);
		i=0;
		while (this.rs.next()){
			Integer j =new Integer(rs.getInt(1));
			con[i][0]=j;
			con[i][1]=rs.getString(2);
			i++;
		}
		cerrarConsulta();
		return con;
	}
	catch(SQLException e){
		//si llega aqui es porque no hay ningun conocimiento.
	}
	cerrarConsulta();
	con = new Object[0][2];
	return con;
}

public void InsertarOferta (OFERTA o) {
      String s = new String ("INSERT INTO ofertas VALUES ("+o.getCODOFERTA()+",'"+o.getTITULO()+"','"+o.getDESCRIP()+"','"+o.getLUGAR()+"','"+o.getCONTRATO()+"',"+o.getSUELDOMIN()+","+o.getSUELDOMAX()+",'"+o.getEXPERIENCIA()+"','"+o.getSEVALORARA()+"','"+o.getIMPRESCINDIBLE()+"',"+o.getDIA()+","+o.getMES()+","+o.getANYO()+",'"+o.isESTADO()+"','"+o.getUSUARIOEMP()+"');");
	  boolean bd=insertarBD(s);
	  cerrarInsertar();
}

public void ActualizarOferta ( String user, int oferta, boolean estado){
   String t = new String ("UPDATE ofertas SET estado = '"+estado+"' WHERE e_user = '"+user+"' AND o_cod = "+oferta+";");
   boolean bd=insertarBD(t);
   cerrarInsertar();
}

public void InsertarOfertaConoc (int oferta,int conoc){
	String s = new String ("INSERT INTO oferta_conoc VALUES ("+oferta+","+conoc+");");
	boolean b = insertarBD(s);
	cerrarInsertar();
}



public Object[][] misOfertas (String userEmpresa){

     String s = new String ("SELECT * FROM ofertas where e_user='"+userEmpresa+"' ORDER BY o_cod;");
     consultarBD(s);
      Object[][] v;
        try{
               int i = 0;
               while (this.rs.next())
                     i++;
              v = new Object[i][11];
              cerrarConsulta();
              consultarBD(s);
              i = 0;
	     while (rs.next()){
		     Integer k = new Integer (rs.getInt(1));
                        v[i][0] = k;//codofer
                        v[i][1] = rs.getString(2);//titulo
                        //v[i][2] = rs.getString(3);//descr
                        v[i][2] = rs.getString(4);//lugar
                        v[i][3] = rs.getString(5);//contrato
                        k = new Integer (rs.getInt(6));//sueldomin
                        v[i][4] = k;
                        k = new Integer (rs.getInt(7));//sueldomax
                        v[i][5] = k;
                        k = new Integer (rs.getInt(8));//experiencia
                        v[i][6] = k;
			//v[i][8] = rs.getString(9);//sevalora
                        //v[i][9] = rs.getString(10);//imprescin
                        k = new Integer (rs.getInt(11));//dia
                        v[i][7] = k;
                        k = new Integer (rs.getInt(12));//mes
                        v[i][8] = k;
                        k = new Integer (rs.getInt(13));//anyo
                        v[i][9] = k;
			boolean b =rs.getBoolean(14);//estado
			if (b)
                            v[i][10] = "true";
			else v[i][10]="false";
                        //v[i][14] = rs.getString(15);//usuario emp
                        i++;
		}//while
	       cerrarConsulta();
	       return v;
	}//try
	catch(SQLException e){
		 //si llega aqui es porque no tengo ninguna oferta creada.
 	}
	cerrarConsulta();
	v=new Object[0][15];
	return v;
}
                        


public Object[][] BusquedaOfertas (String titulo, String lugar, String contrato, String empresa, int sueldo, int exp, String conoc)
{
	Object[][] v;// = new Vector();
	String s = "SELECT * FROM ofertas WHERE estado='true' AND ";
	boolean pasado = false; 
	if (titulo!=""){
		s=s+" titulo LIKE '%"+titulo+"%' ";
		pasado = true;
	}
	if (lugar!=""){
		if (pasado)
			s=s+" AND ";
		else {
			pasado = true;
		}
		s = s + " lugar LIKE '%"+lugar+"%' ";
	}
	if (contrato!=""){
		if (pasado)
			s=s+" AND ";
		else {
			pasado = true;
		}
		s = s + " contrat LIKE '%"+contrato+"%' ";
	}
	if (empresa!=""){
		if (pasado)
			s=s+" AND ";
		else {
			pasado = true;
		}
		s = s + " e_user LIKE '%"+empresa+"%' ";
	}
	if (sueldo!=-1){
		if (pasado)
			s=s+" AND ";
		else {
			pasado = true;
		}
		s = s + " sue_max > "+sueldo+" ";
	}
	if (exp!=-1){
		if (pasado)
			s=s+" AND ";
		else {
			pasado = true;
		}
		s = s + " experiencia <= "+exp+" ";
	}
	if (conoc!=""){
		if (pasado)
			s=s+" AND ";
		else {
			pasado = true;
		}
		s = s + " o_cod IN (SELECT o_cod FROM oferta_conoc WHERE c_cod = (SELECT c_cod FROM conocimientos WHERE c_nombre = '"+conoc+"'))";
	}
	if (pasado){
		s = s + " ORDER BY o_cod ;";
		consultarBD(s);
		try{
			int i=0;
			while (this.rs.next())
			   i++;
			v = new Object[i][15];
			consultarBD(s);
			i=0;
			while(this.rs.next()){
				Integer k=new Integer (rs.getInt(1));
				v[i][0]=k;//cod
				v[i][1]=rs.getString("titulo");//titulo
				v[i][2]=rs.getString(3);//descr
				v[i][3]=rs.getString(4);//lugar
				v[i][4]=rs.getString(5);//con
				k=new Integer(rs.getInt(6));//suelmax
				v[i][5]=k;
				k=new Integer(rs.getInt(7));//suelmin
				v[i][6]=k;
				k=new Integer(rs.getInt(8));//exp
				v[i][7]=k;
				v[i][8]=rs.getString(9);//valorara
				v[i][9]=rs.getString(10);//impres
				k=new Integer(rs.getInt(11));//dia
				v[i][10]=k;
				k=new Integer(rs.getInt(12));//mes
				v[i][11]=k;
				k=new Integer(rs.getInt(13));//anyo
				v[i][12]=k;
				boolean b= rs.getBoolean(14);//estado
				if (b)
				    v[i][13]="true";
				else v[i][13]="false";
				v[i][14]=rs.getString(15);//usuario
				i++;
			}
		return v;
		}
		catch(SQLException e){
		}
	}
   v=new Object[0][15];
   return v;
}

public void insertarSolicitud(SOLICITUD s){
   String consulta = new String ("INSERT INTO solicitudes VALUES ("+s.getcodigo()+","+s.getcoferta()+",'"+s.getuser()+"',"+s.getdia()+","+s.getmes()+","+s.getanyo()+");");
   boolean bien = insertarBD(consulta);
   cerrarInsertar();
}


//Se llama desde ELEGIRSOL
public Object[][] sacarSolicitudes(int codigosol){
	Object[][] v;
	String s = new String ("SELECT * FROM solicitudes where o_cod = "+codigosol+";");
	try{
	    consultarBD(s);
	    int i = 0;
	    while (rs.next())
		 i++;
	    v = new Object[i][4];
	    cerrarConsulta();
	    consultarBD(s);
	    i=0;
	    while (rs.next()){
		  v[i][0]=rs.getString(3);//user candidato
		  v[i][1]=new Integer (rs.getInt(4));//dia
		  v[i][2]=new Integer (rs.getInt(5));//mes
		  v[i][3]=new Integer (rs.getInt(6));//anyo
		 i++;
	    }
	    return v;
	}
	catch (Exception ex){
		//si da error es que no hay ningun 
	}
	v = new Object[0][4];
	return v;
}

public void borrarSolicitud (int cod){
   String consulta = new String ("DELETE FROM solicitudes WHERE s_cod="+cod+";");
   boolean bien = insertarBD(consulta);
   cerrarInsertar();
}



public Object[][] misSolicitudes(String user)
{	 //si lo llama un candidato 
	String s = new String ("SELECT  o.estado, s.s_cod, o.titulo, s.o_cod, o.e_user, s.dia, s.mes, s.anyo FROM solicitudes s, ofertas o WHERE s.c_user = '"+user+"' AND o.o_cod=s.o_cod  ORDER BY s.s_cod;");
	consultarBD(s);
	Object[][] v;
	try
	{
		int i = 0;
		while (this.rs.next())
			i++;
		v = new Object[i][8];
		cerrarConsulta();
		consultarBD(s);
		i = 0;
		
		while (this.rs.next()) {
			boolean b = rs.getBoolean(1);
			String k; //= new String(k);
			if (b) k = "true";
			else k = "false";	
			v[i][0] = k;
			Integer o = new Integer(rs.getInt(2));
			v[i][1] = o;
			v[i][2] = rs.getString(3);
			o = new Integer(rs.getInt(4));
			v[i][3] = o;
			v[i][4] = rs.getString(5);
			o = new Integer(rs.getInt(6));
			v[i][5] = o;
			o = new Integer(rs.getInt(7));
			v[i][6] = o;
			o = new Integer(rs.getInt(8));
			v[i][7] = o;
			i++;
		}//while
	this.cerrarConsulta();
	return v;
	}
	catch(SQLException se) {
        }
   this.cerrarConsulta();
   v=new Object[0][8];
   return v;
			
}

public Object[][] ContarConocimientos () {
	Object[][] v; //= new Vector(5);
	String s = new String ("SELECT * from conocimientos;");
	this.consultarBD(s);
	try
	{
		int MAX;
		int i=0;
		while (this.rs.next())
			i++;
		MAX=i;
		v=new Object[i][3];
		i=0;
		consultarBD(s);
		while (this.rs.next()) {
			v[i][1]=rs.getString(2);
			Integer j = new Integer(rs.getInt(1));
			v[i][0]=j;
			i++;
		}
	  this.cerrarConsulta();
	  int k =0;
	  for (int h=0;h<MAX;h++){
	    String l = v[h][0].toString();
	    Integer m = new Integer (l);
	    k = m.intValue(); 
	    s = new String ("select count(*) from oferta_conoc where c_cod="+k+" ;");
	    this.consultarBD(s);
	    try{
		while(rs.next()){
			Integer ala = new Integer (rs.getInt(1));
			v[h][2] = ala;
		}
	    }
	    catch (Exception mal){
	    }
	  }//for
	  this.cerrarConsulta();
	  return v;		
	}
	catch(SQLException se) {
   	}
   this.cerrarConsulta();
   v=new Object[0][2];
   return v;
}


public Object[][] ConocimientosDeEmpresa (int coferta){
  Object[][] v;
  try{
	  String s = new String ("SELECT c.c_cod, c.c_nombre FROM conocimientos c, oferta_conoc of WHERE c.c_cod = of.c_cod AND of.o_cod ="+coferta+" ORDER BY c.c_cod");
	  consultarBD(s);
	  int i=0;
	  while (rs.next())
		  i++;
	  v = new Object[i][2];
	  i=0;
	  cerrarConsulta();
	  consultarBD(s);
	  while (rs.next()){
		  Integer j =new Integer (rs.getInt(1));
		  v[i][0]=j;
		  v[i][1]=rs.getString(2);
		  i++;
	  }
	  return v;
  }
  catch(Exception ex){
	  //si hay excepcion no la lanzamos porque no nos interesa
  }
  v=new Object[0][2];
  return v;
}


public Object[][] SacarSolicitud (String e_user)
{//ANALISIS DE SOLICITUDES
	/*recibe el usuario empresa y devuelve el codigo ofertas
	 *con el numero de solicitudes por codigo*/

	Object[][] v ;//= new Vector(5);

	try
	{
		consultarBD ("SELECT o_cod, COUNT (s_cod) FROM empresa e, ofertas o, solicitudes s WHERE e.e_user = o.e_user AND o.o_cod = s.o_cod ORDER BY s_cod;");
		int i=0;
		while (this.rs.next())
			i++;
		v = new Object[i][2];
		i=0;
		while (this.rs.next()) {
			Integer j = new Integer (rs.getInt(1));
			v[i][0]=j;
			j=new Integer(rs.getInt(2));
			v[i][1]=j;
			i++;
		}
	cerrarConsulta();
	return v;
	}

	catch(SQLException se) {
   }
   v = new Object[0][2];
   return v;

}




public OFERTA ConsultarOfertas (int s) {
   OFERTA o = new OFERTA();
   try{
      consultarBD("SELECT * FROM ofertas WHERE o_cod = "+s+";");
      while (rs.next()){
	o.setCODOFERTA(this.rs.getInt(1));
        o.setTITULO (this.rs.getString (2));
        o.setDESCRIP(this.rs.getString (3));
        o.setLUGAR (this.rs.getString(4));
        o.setCONTRATO (this.rs.getString(5));
        o.setSUELDOMIN (this.rs.getInt(6));
        o.setSUELDOMAX (this.rs.getInt(7));
        o.setEXPERIENCIA (this.rs.getInt(8));
        o.setSEVALORARA(this.rs.getString(9));
        o.setIMPRESCINDIBLE(this.rs.getString(10));
        o.setDIA (this.rs.getInt(11));
        o.setMES (this.rs.getInt(12));
        o.setANYO (this.rs.getInt(13));
        o.setESTADO (this.rs.getBoolean(14));
        o.setUSUARIOEMP (this.rs.getString(15));
	  cerrarConsulta();
	  return o;//devolvemos la oferta
      }//while
   }
   catch(SQLException se) {
   }
   return o;
}

public Object[][] OfertasASolicitudes (int o_cod) {
	Object[][] v;
      try {
          String s= new String ("SELECT s_cod FROM solicitudes WHERE o_cod = (SELECT o_cod FROM ofertas WHERE o_cod = "+o_cod+");"); 
	  consultarBD(s);
	  int i=0;
           while (this.rs.next()) 
		   i++;
	  v = new Object[i][1];
	  cerrarConsulta();
	  consultarBD(s);
	  i=0;
	  while(this.rs.next()){
              Integer j = new Integer (rs.getInt(1));
              v[i][0]=j;
	      i++;
          }
       cerrarConsulta();
       return v;
      }//try
      catch(Exception se) {
      }
      v =new Object[0][1];
     return v;
}



public Object[][] ConsultarCodOferta (String e) {
   try{ 
       String s =new String ("SELECT o_cod, titulo from ofertas WHERE e_user = '"+e+"' ORDER BY o_cod;");
      consultarBD(s);
      int i=0;
      while (rs.next())
	i++;
     Object[][] v = new Object[i][2];
     i=0;
     consultarBD(s);
      while (rs.next()){
         Integer k = new Integer(rs.getInt (1));
	 v[i][0]=k;
	 v[i][1]=rs.getString(2);
	 i++;
      }
	  cerrarConsulta();
	  return v;
   }
   catch(SQLException se) {
   }
   Object[][] v =new Object[0][1];
   return v;
}



public CANDIDATOS ConsultarCandidato (String user) {
   CANDIDATOS c = new CANDIDATOS();
   try{ 
      consultarBD("SELECT * FROM candidatos WHERE c_user ='"+user+"';");
      while (rs.next()) {
         
         //igual con no sacarlo en las ventanas ya vale....
        
         c.setusuario(rs.getString(1));
         c.setclave(rs.getString(2));
         c.setnombre(rs.getString(3));
         c.setapellidos(rs.getString(4));
         c.setdireccion(rs.getString(5));
         c.settelefono(rs.getInt(6));
         c.setemail(rs.getString(7));
         c.setdia(rs.getInt(8));
         c.setmes(rs.getInt(9));
         c.setanyo(rs.getInt(10));
         c.setcarnet(rs.getBoolean(11));
         c.setcoche(rs.getBoolean(12));
         c.setdispviajar(rs.getBoolean(13));
         c.setestudios(rs.getString(14));
         c.setotrosconoz(rs.getString(15));
         c.setexperiencia(rs.getInt(16));
         c.setvidalabor(rs.getString(17));
      }
	  cerrarConsulta();
	  return c;
   }
   catch(SQLException se) {
   }
   return c;
}

}
