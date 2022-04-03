package funciones;


import java.time.LocalDate;
import java.time.LocalTime;

import java.time.format.TextStyle;
import java.util.Locale;

//Para importar los métodos estaticos a otra clase es:
//import static funciones.Funciones.*;

public class Funciones {
	
	/***************************************************************************************************/
	//Metodos que se encuentran áca:
	// public static boolean esBisiesto(int anio)
	// public static boolean esFechaValida(LocalDate fecha)
	// public static String  traerFechaCorta(LocalDate fecha)
	// public static String  traerHoraCorta(LocalTime hora)
	// public static boolean esDiaHabil(LocalDate fecha)
	// public static String  traerDiaDeLaSemana(LocalDate fecha)
	// public static String  traerMesEnLetras(LocalDate fecha)
	// public static String  traerFechaLarga(LocalDate fecha)
	// public static int 	 traerCantDiasDeUnMes(int mes, int anio)
	// public static double  aproximar2Decimal (double valor)
	// public static boolean esNumero(char caracter)
	// public static boolean esCadenaNros (String cadena)
	// public static boolean esLetra (char caracter)
	// public static boolean esCadenaLetras (String cadena)
	//
	/***************************************************************************************************/
	
	//Metodos
	/***************************************************************************************************/
	
	public static boolean esBisiesto(int anio) {	
		//Serán bisiestos los años divisibles por 4, exceptuando los que son divisibles por 100 y no divisibles por 400.
		// Ejemplos: son bisiestos 1996, 2004, 2000, 1600; No son bisiestos 1700, 1800, 1900, 2100
		
		boolean bisiesto = true;
		
		//Si no es divisible por 4, no es año bisiesto
		if(anio%4 != 0) bisiesto = false;
		
		//Si es divisible por 100 y pero no por 400, no es bisiesto
		if(anio%100 == 0 && anio %400 != 0) bisiesto = false;
		
		return  bisiesto;
	}
	
	/***************************************************************************************************/
	
	public static boolean esFechaValida(LocalDate fecha) {  //En el caso de ser bisiesto es válido el día 29/02

		boolean valido = false;
		
		if(fecha.getDayOfMonth()>=1 && fecha.getDayOfMonth()<=31) {
			if(fecha.getMonthValue()==1 || fecha.getMonthValue()==3|| fecha.getMonthValue()==5 || fecha.getMonthValue()==7 ||
			   fecha.getMonthValue()==8 || fecha.getMonthValue()==10 || fecha.getMonthValue()==12) {
				valido = true;
			}
		}
		
		if(fecha.getDayOfMonth()>=1 && fecha.getDayOfMonth()<=30) {
			if(fecha.getMonthValue()==4 || fecha.getMonthValue()==6 || fecha.getMonthValue()== 9 || fecha.getMonthValue()==11) {
				valido = true;
			}
		}
		
		if(fecha.getMonthValue()==2) {
			if(fecha.getDayOfMonth()>=1 && fecha.getDayOfMonth()<=28) valido = true;
			if(fecha.getDayOfMonth()>=1 && fecha.getDayOfMonth()<=29 && esBisiesto(fecha.getYear()) ) valido = true;
		}
		
		return valido;
	}
	
	/***************************************************************************************************/
	
	public static String traerFechaCorta(LocalDate fecha) { //Retorna “dd/mm/aaaa”
		return (fecha.getDayOfMonth() + "/" + fecha.getMonthValue() + "/" + fecha.getYear() );		
	}
	
	/***************************************************************************************************/
	
	public static String traerHoraCorta(LocalTime hora) {  //Retorna “hh:mm”
		return (hora.getHour() + ":" + hora.getMinute());
	}
	
	/***************************************************************************************************/
	
	public static boolean esDiaHabil(LocalDate fecha) {  //Consideramos hábil de lunes a viernes
		  return fecha.getDayOfWeek().getValue() >= 1 && fecha.getDayOfWeek().getValue() <= 5;
	}
	
	/***************************************************************************************************/
	
	public static String traerDiaDeLaSemana(LocalDate fecha) {
		return fecha.getDayOfWeek().getDisplayName(TextStyle.SHORT,Locale.ENGLISH);
	}	
	
	/***************************************************************************************************/
	
	public static String traerMesEnLetras(LocalDate fecha) {
		return fecha.getMonth().getDisplayName(TextStyle.SHORT,Locale.ENGLISH);
	}
	
	/***************************************************************************************************/
	
	public static  String traerFechaLarga(LocalDate fecha) {  //Ejemplo: “Sábado 20 de Agosto del 2016”
		return (traerDiaDeLaSemana(fecha) + " " + fecha.getDayOfMonth() + " de " + 
				traerMesEnLetras(fecha) + " del " + fecha.getYear() );
	}
	
	/***************************************************************************************************/
	
	public static int traerCantDiasDeUnMes(int mes, int anio) {	
		return LocalDate.of(anio, mes, 1).getMonth().length(esBisiesto(anio) );
	}
	
	/***************************************************************************************************/
	
	public static double aproximar2Decimal (double valor) {
		//Si el tercer decimal es mayor o igual 5, suma 1 al segundo decimal
		//EJ: Si el numero es 5,821 tiene que devolver 5,82
		//EJ: Si el numero es 7,988 tiene que devolver 7,99

		return Math.round(valor*100.0)/100.0;
	}

	/***************************************************************************************************/
	public static boolean esNumero(char caracter) {
		return Character.isDigit(caracter);
	}

	/***************************************************************************************************/
	public static boolean esCadenaNros (String cadena) {

		boolean resultado;

		try {
			Integer.parseInt(cadena);	//Se intenta convertir los caracteres a numeros
			resultado = true;
		} catch (NumberFormatException excepcion) { //Si no se puede es porque es una cadena de caracteres
			resultado = false;						
		}

		return resultado;
	}

	/***************************************************************************************************/

	public static boolean esLetra(char caracter) {
		return Character.isLetter(caracter);
	}

	/***************************************************************************************************/

	public static boolean esCadenaLetras (String cadena) {

		boolean resultado;

		try {
			Integer.parseInt(cadena);	//Se intenta convertir los caracteres a numeros
			resultado = false;
		} catch (NumberFormatException excepcion) { //Si no se puede es porque es la cadena de caracteres
			resultado = true;						//tiene solo caracteres
		}

		return resultado;
	}
	
}
