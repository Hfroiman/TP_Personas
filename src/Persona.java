import java.util.TreeSet;

public class Persona implements Comparable<Persona>{

	private String Nombre;
	private String Apellido;
	private int DNI;
	public static TreeSet<Persona> lista;
	
	public Persona(String nombre, String Apellido, int dni) {
		this.Nombre = nombre;
		this.Apellido = Apellido;
		this.DNI = dni;
	}
	public Persona() {
		this.Nombre = "";
		this.Apellido = "";
		this.DNI =999;
	}
	
	public static TreeSet<Persona> getLista() {
		return lista;
	}
	public static void setLista(TreeSet<Persona> lista) {
		Persona.lista = lista;
	}
	@Override
	public String toString() {
		return Nombre + ", "+ Apellido +", "+ DNI;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		this.Apellido = apellido;
	}
	public int getDNI() {
		return DNI;
	}
	public void setDNI(int dNI) {
		this.DNI = dNI;
	}
	
	public int DNIOK(String dni) throws DNIinvalido{
		if(isNumeric(dni)) {
			return Integer.parseInt(dni);
		}
		throw new DNIinvalido();
		
	}
	private static boolean isNumeric(String n) {
	    try {  
	        Double.parseDouble(n);  
	        return true;
	      } catch(NumberFormatException e){  
	        return false;  
	      } 
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Apellido == null) ? 0 : Apellido.hashCode());
		result = prime * result + DNI;
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (Apellido == null) {
			if (other.Apellido != null)
				return false;
		} else if (!Apellido.equals(other.Apellido))
			return false;
		if (DNI != other.DNI)
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		return true;
	}
	@Override
	public int compareTo(Persona obj) {
		return this.Apellido.compareTo(obj.getApellido());
	}
}
