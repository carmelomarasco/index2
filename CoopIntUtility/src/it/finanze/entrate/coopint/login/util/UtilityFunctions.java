package it.finanze.entrate.coopint.login.util;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.http.HttpSession;

public class UtilityFunctions { 
	
		
	/**
	 * restituisce il segno dell'importo specificato
	 * @param str = la stringa da controllare
	 * @param val = valore in caso di null o ""
	 * @return effettua l'operazione di NVL ovvero IMPOSTA str=val nel caso str sia null o ""
	 */	
	public static String inizial(String str, String val){
		return (str==null || str.equals(""))?val:str;
	}
	
//	public static Utente getUtente(HttpSession session){
//		return (Utente) session.getAttribute(CostantiUtil.UTENTE);
//	}
	
	/**
	 * Restituisce il codice uffico di lunghezza 3 (Entrate) o con prefisso D_ (Dogane)
	 * @param uffici[] = lista dei codici ufficio restituita dalle API sicurezza
	 * 
	 */
	public static String getCodiceUfficoEntrateODogane(String[] uffici){
		for (int i=0; i < uffici.length; i++)			
			if (uffici[i].length()==3 || uffici[i].contains("D_"))
				return uffici[i];		
		return null;
	}


	/*
	 * In base all'ID passato il link viene stampato in grassetto o meno.
	 */	
		public static String getStyleFont(HttpSession ses, String id)throws Exception{
			String bold = "";
			if ( ses.getAttribute("pageId")!= null && ( (String)ses.getAttribute("pageId") ).equals(id)  )
					bold = "font-weight: bold";	
			return bold;
		}

	/**
	 *	restituisce la stringa importo formattata con il punto di separazione per le migliaia 
	 */	
		public static String formattaStringa(String importo) 
		{
			return formatoImporto( getSegnoImporto(importo), getImportoUnsign(importo) );
		}
		
	/**
	 *	restituisce la stringa importo con il punto di separazione per le migliaia 
	 */	
		public static String formatoImporto(String segno, String importo) {
			// 	formatoImporto("-","1000000") = -1.000.000
				
				String format = "0";
			
				if (importo == null) return format;			
				format = importo;
				
				String decimali = "";
				int indPunto = format.indexOf(".");
				if(indPunto>0)			
				{
					decimali = "," + format.substring(indPunto+1);
					decimali = decimali.equals(",00")?"":decimali;
					format = format.substring(0,indPunto);
				}
					
				String separazione = "";
				int i = 0;
				for (i = format.length()-1; i >= 3; i -= 3) {
					separazione = "." + format.substring(i-2,i+1) + separazione;
				}
			
				format = format.substring(0,i+1) + separazione;
			
				if (segno == null) segno = "";
				if (!format.equalsIgnoreCase("0"))	format = ( segno.equals("-") ) ? "-"+ format: ""+format; 
				
				
				return format+decimali;
		}

	/**
	 * restituisce il segno dell'importo specificato
	 * @param importo
	 * @return
	 */	
		public static String getSegnoImporto(String importo){
			String segno = "+";
			if ( importo.substring(0,1).equals("-") ) segno = "-";
			return segno;	
		}
		
		
		
		/**
		 * restituisce il segno dell'importo specificato
		 * @param importo1
		 * @param importo2
		 * @return la somma algebrica in formato String.
		 * 			 Effettua tutti i controlli nel caso gli importi o i segni siano "" (stringa vuota)
		 * 			Questa funzione viene chiamata nel caso gli importi in formato String siano
		 * 			 gi� provvisti di segno.
		 */	
		public static String cicsSommaAlgebrica(String importo1, String importo2){
			return cicsSommaAlgebrica("", importo1, "", importo2 );
		}
		
		/**
		 * restituisce il segno dell'importo specificato
		 * @param segno1
		 * @param importo1
		 * @param segno2
		 * @param importo2
		 * @return la somma algebrica in formato String. Effettua tutti i controlli nel caso gli importi o i segni siano "" (stringa vuota)
		 */	
		public static String cicsSommaAlgebrica(String segno1, String importo1,String segno2, String importo2){
			BigDecimal val1 = new BigDecimal(0.0);
			BigDecimal val2 = new BigDecimal(0.0);		
				
			importo1  = nvl(importo1,"0");
			importo1 = importo1.startsWith("+")?importo1.substring(1):importo1;
			importo1 = rimuoviPunti(importo1);
				
			importo2  = nvl(importo2,"0");
			importo2 = importo2.startsWith("+")?importo2.substring(1):importo2;
			importo2 = rimuoviPunti(importo2);
				
			segno1 =  nvl(segno1,"");
			segno2 =  nvl(segno2,"");
				
			val1 = new BigDecimal(segno1+importo1);
				
			val2= new BigDecimal(segno2+importo2);
			
			val1 = val1.add(val2);
				
			return val1.toString();	
		}
		
		/**
		 * restituisce il segno dell'importo specificato
		 * @param str = la stringa da controllare
		 * @param val = valore in caso di null o ""
		 * @return effettua l'operazione di NVL ovvero IMPOSTA str=val nel caso str sia null o ""
		 */	
		public static String nvl(String str, String val){
			return (str==null || str.equals(""))?val:str;
		}
		
		/**
		 *	elimina gli zeri superflui alla sx di un numero
		 * @param str = la stringa da modificare
		 * @return la stringa modificata
		 */	
		public static String tagliaZeri(String str){
			if(str != null && str.length()>1)
			{
				while(str.charAt(0) == '0' && str.length()>1)
					str = str.substring(1);
			}
			return str;
		}

		
		/**
		 * @param array, inizio e fine
		 * @return Dato un array restituisce una sua porzione compresa tra le righe inizio e fine(comprese)
		 * se l'indice di fine � maggiore della size si ferma all'ultimo elemento dell'array
		 */
		@SuppressWarnings("unchecked")
		public static ArrayList arraySubList(ArrayList array, int inizio, int fine)
		{
			ArrayList result = new ArrayList();
			if(array!=null)
			{
				for(int i = inizio; i<=fine && i<array.size(); i++)
				{
					result.add(array.get(i));
				}
			}
			return result;
		}

		
		

		
	/**
	 * restituisce il valore dell'importo senza segno
	 * @param importo
	 * @return
	 */	
		public static String getImportoUnsign(String importo){
			String imp = importo;
			if ( importo.substring(0,1).equals("-") ) imp = importo.substring(1);
			return imp;
		}
		
		
	/***
	 * Reimposta il formato di un trimestre
	 * @return
	 */	
		
		public static String codifTrimestre(byte trimId){
			
			switch(trimId){
				case 0: return "Tutti i trimestri";
				case 1: return "I Trimestre";
				case 2: return "II Trimestre";
				case 3: return "III Trimestre";
				case 4: return "IV Trimestre";
				default:  return "Nessuna selezione";
			}
		}

		
		
	/**
	 * Divide la stringa in base ad un carattere delimitatore
	 * @param s
	 * @param delim
	 * @return
	 */
		@SuppressWarnings("unchecked")
		public static Vector splitString(String s, String delim)throws Exception{
			StringTokenizer st = new StringTokenizer(s,delim);
			Vector list = new Vector();
			while ( st.hasMoreTokens() ){
				String el = st.nextToken();
				list.add(el.trim()); 
			}
			return list;
		}
		
	 	public static String getSecolo(String anno){
	 		if ( anno!=null && !anno.equals("") && (anno.substring(0,1).equals("0")||anno.substring(0,1).equals("1")) ) return "20"+anno;
	 		else return "19"+anno;
	 	
	 	}
	 	
				
		/**
		 * La funzione ritorna una stringa senza i punti
		 * @param stringa
		 * @author Arianna Milazzo
		 * @return stringa
		 */	
		public static String rimuoviPunti(String s)
		{	
			StringBuffer ret = new StringBuffer();
			if ( s.indexOf(".") != -1 ){
				int len = s.length();
				for (int i = 0; i < len; i++)
					if(s.charAt(i) != '.')
						ret.append(s.charAt(i));
			}else{
				ret.append(s);
			}
			return ret.toString();
		}
		
		/**
		 * La funzione restituisce una pIva troncata
		 * Se example contiene pi� di una parola (es. per la Repubblica Ceca: 99999999 o 999999999 o 9999999999)la pIva rimane cos� com'�;
		 * Se example contiene solo una parola (es. per la Danimarca: 99999999) la pIva sar� troncata a sx in modo da 
		 * raggiungere la lunghezza della stringa example
		 * @param pIva
		 * @param example
		 * @return pIvaTroncata
		 */	
		public static String troncaPIva(String pIva, String example)
		{	
			String pIvaTroncata = pIva;
			if(example!=null && !"".equals(example) && pIva!=null && !"".equals(pIva))
			{
				pIva = pIva.trim();
				boolean singola = example.indexOf(" ")==-1?true:false;
				if(singola)
				{
					int length = example.length();
					int inizio = pIva.length() - length ;
					if(inizio>=0)
						pIvaTroncata = pIva.substring(inizio);
				}
			}
			return pIvaTroncata;
		}
		
		/**
		 * 
		 * @param m
		 * @return il trimestre relativo ad un certo mese
		 */

			public static String getTrimestreDaMese(String m){
				if ( m == null || m.equals("") )
					return "-1";
			
				else{
					byte mese = Byte.parseByte(m);
					switch(mese){
						case 1:
						case 2:
						case 3: return "1";
						case 4:
						case 5:
						case 6: return "2";
						case 7:
						case 8:
						case 9: return "3";
						case 10:
						case 11:
						case 12: return "4";
						default: return "-1";
					}
				}
			}
		

			/**
			 * Controlla che nel parametro campo ci siano solo caratteri numerici.
			 * @return boolean
			 * @param campo java.lang.String
			 */
			public static boolean checkIfNumerico(String campo) {
				
				if(campo.contains("/")){
					campo = campo.replace("/", "");
				}else if(campo.contains("-")){
					campo = campo.replace("-", "");
				}else if(campo.contains(" ")){
					campo = campo.replace(" ", "");
				}
				
				if (campo.length() == 0) {
					return false;
				}
				
				char sChar[] = new char[campo.length()];
				sChar = campo.toCharArray();
				for (int j = 0; j < campo.length(); j++) {
					switch(sChar[j]) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							break;
						default:
							return false;
					}
				}	
				
				return true;
			}

}
