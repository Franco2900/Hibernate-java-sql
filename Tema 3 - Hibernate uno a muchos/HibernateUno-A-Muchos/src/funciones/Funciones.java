package funciones;


import java.time.LocalDate;
import java.time.LocalTime;

import java.time.format.TextStyle;
import java.util.Locale;

public class Funciones {
	
	//atributos
	private LocalDate fecha;
	private LocalTime hora;
	
	
	//constructor
	public Funciones (LocalDate fecha, LocalTime hora) {
		this.fecha = fecha;
		this.hora = hora;
	}

	
	//Getters y Setters
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	
	//Metodos
	public boolean esBisiesto(int anio) {	
		//Serán bisiestos los años divisibles por 4, exceptuando los que son divisibles por 100 y no
		//divisibles por 400. Ejemplos: son bisiestos 1996, 2004, 2000, 1600; No son bisiestos 1700,
		//1800, 1900, 2100
		int auxAnio = anio;
		
		int resto1 = auxAnio % 4;  //Vemos si el año es divisible por 4
		if(resto1 != 0) {
			return false;			//Si no es divisible por 4, no es año bisiesto
		}
		
		int resto2 = auxAnio % 100; //Vemos si es divisible por 100
		int resto3 = auxAnio % 400; //Vemos si es divisible por 400
			
		if(resto2 == 0 && resto3 == 0) {
			return true;			//Si es divisible por 100 y por 400 es bisiesto 
		}
		else {return false;}
		
	}
	
	public boolean esFechaValida(LocalDate fecha) {  //En el caso de ser bisiesto es válido el día 29/02
		
		int diaDelMes = fecha.getDayOfMonth();
		int mesDelAnio = fecha.getMonthValue();
		
		if(diaDelMes>=1 && diaDelMes<=31) {
			
			if(mesDelAnio>=1 && mesDelAnio<=12) {
				return true;
			}else {return false;}
			
		}else {return false;}
		
	}
	
	public static String traerFechaCorta(LocalDate fecha) { //Retorna “dd/mm/aaaa”
		
		int diaDelMes = fecha.getDayOfMonth();
		int mesDelAnio = fecha.getMonthValue();
		int anio = fecha.getYear();
		
		return (diaDelMes + "/" + mesDelAnio + "/" + anio);
		
	}
	
	public String traerHoraCorta(LocalTime hora) {  //Retorna “hh:mm”
		
		int horaCorta = hora.getHour();
		int minutoCorto = hora.getMinute();
		
		return (horaCorta + ":" + minutoCorto);
	}
	
	
	public boolean esDiaHabil(LocalDate fecha) {  //Consideramos hábil de lunes a viernes
		  int dia = fecha.getDayOfWeek().getValue();
		  
		  if(dia >=1 && dia <= 5) {
			  return true;
		  }else{return false;}
		
	}
	
	public String traerDiaDeLaSemana(LocalDate fecha) {
		String dia = fecha.getDayOfWeek().getDisplayName(TextStyle.SHORT,Locale.ENGLISH);
		return dia;
	}	
	
	
	public String traerMesEnLetras(LocalDate fecha) {
		String mes = fecha.getMonth().getDisplayName(TextStyle.SHORT,Locale.ENGLISH);
		return mes;
	}
	
	public String traerFechaLarga(LocalDate fecha) {  //Ejemplo: “Sábado 20 de Agosto del 2016”
		
		String dia = fecha.getDayOfWeek().getDisplayName(TextStyle.SHORT,Locale.ENGLISH);
		int diaDelMes = fecha.getDayOfMonth();
		String mes = fecha.getMonth().getDisplayName(TextStyle.SHORT,Locale.ENGLISH);
		int anio = fecha.getYear();
		
		return (dia + " " + diaDelMes + " de " + mes + " del " + anio);
		
	}
	
	public int traerCantDiasDeUnMes(int mes, int anio) {
		LocalDate fecha = LocalDate.of(anio, mes, 1);
		int cantDias = fecha.getMonth().length(false);
		
		return cantDias;
	}
	

	//Metodos
		public double aproximar2Decimal (double valor) {
		//Si el tercer decimal es mayor o igual 5, suma 1 al segundo decimal
		//EJ: Si el numero es 5,821 tiene que devolver 5,82
		//EJ: Si el numero es 7,988 tiene que devolver 7,99
			
			double auxValor = valor * 1000;  //Se multiplica por 1000 para quitarle la coma al numero 
			
			double cuartoDigito = auxValor%10;
			if(cuartoDigito >= 5) {
				double sumar =  0.01 - (cuartoDigito/1000);
				valor = valor + sumar;
			}else {
				valor = valor - (cuartoDigito/1000);
			}
			
			return valor;
		}
		
		/***************************************************************************************************/
		public boolean esNumero(char c) {
			
			boolean resultado;
			
			if(Character.isDigit(c) ) {
				resultado = true;
			}else {
				resultado = false;
			}
			
			return resultado;
		}
		
		/***************************************************************************************************/
		public boolean esCadenaNros (String cadena) {
			
			boolean resultado;

	        try {
	            Integer.parseInt(cadena);	//Se intenta convertir los caracteres a numeros
	            resultado = true;
	        } catch (NumberFormatException excepcion) { //Si no se puede es porque es la cadena de caracteres
	            resultado = false;						//tiene solo caracteres
	        }

	        return resultado;
		}
		
		/***************************************************************************************************/

		public boolean esLetra(char c) {
			
			boolean resultado;
			
			if(Character.isDigit(c) ) {
				resultado = true;
			}else {
				resultado = false;
			}
			
			return resultado;
		}
		
		/***************************************************************************************************/

		public boolean esCadenaLetras (String cadena) {
			
			boolean resultado;

	        try {
	            Integer.parseInt(cadena);	//Se intenta convertir los caracteres a numeros
	            resultado = true;
	        } catch (NumberFormatException excepcion) { //Si no se puede es porque es la cadena de caracteres
	            resultado = false;						//tiene solo caracteres
	        }

	        return resultado;
		}
	
}
