import java.util.Iterator;

public class Principal {

	public static void main(String[] args) throws DNIinvalido{
		String rutaarchivo = "C:\\Users\\hfroi\\OneDrive\\Documentos\\UTN\\LABORATORIO 4\\TP3_java\\src\\Personas (1).txt";
		Archivo nuevo = new Archivo(rutaarchivo);
		nuevo.existearchivo();
		nuevo.LeerRenglon();
		String nombrearchivo="Resultado.txt";
		nuevo.crearArchivo(nombrearchivo);
		nuevo.existearchivo(nombrearchivo);
		Iterator<Persona> it= Persona.lista.iterator();
		while(it.hasNext()) {
			Persona p=(Persona)it.next();
			nuevo.EscribirXlinea(nombrearchivo, p);
			System.out.println(p.toString());
		}
	}
}
