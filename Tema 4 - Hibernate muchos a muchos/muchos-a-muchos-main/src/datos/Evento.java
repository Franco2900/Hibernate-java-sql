package datos;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Evento {
private long idEvento;
private String evento;
private LocalDate fecha;
private Set<Cliente> clientes = new HashSet<Cliente>();

public Evento(){}
public Evento(String evento, LocalDate fecha) {
super();
this.evento = evento;
this.fecha = fecha;
}
public long getIdEvento() {
return idEvento;
}
protected void setIdEvento(long idEvento) {
this.idEvento = idEvento;
}
public String getEvento() {
return evento;
}
public void setEvento(String evento) {
this.evento = evento;
}
public LocalDate getFecha() {
return fecha;
}
public void setFecha(LocalDate fecha) {
this.fecha = fecha;
}
public Set<Cliente> getClientes() {
return clientes;
}
public void setClientes(Set<Cliente> clientes) {
this.clientes = clientes;
}
public boolean equals(Evento evento){
	return false;
}
public boolean agregar(Cliente cliente){
	return false;
}
public boolean eliminar(Cliente cliente){
	return false;
}
public String toString(){
return idEvento+" "+evento+" "+Funciones.traerFechaCorta(fecha)+"";//+Funciones.traerHora(fecha);
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (idEvento ^ (idEvento >>> 32));
	return result;
}
@Override
public boolean equals(Object obj) {
	
	return ((Evento)obj).getIdEvento() == this.getIdEvento();
}








}