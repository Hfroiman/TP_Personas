import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;
import java.io.File;

public class Archivo {

	private String ruta;
	
	public Archivo(String ruta) {
		this.ruta= ruta;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
	public boolean existearchivo() {
		File archivo= new File(ruta);
		if(archivo.exists()) {
			System.out.println("Archivo encontrado");
			return true;
		}
		return false;
	}
	public boolean existearchivo(String ruta) {
		java.io.File archivo= new java.io.File(ruta);
		if(archivo.exists()) {
			System.out.println("Archivo encontrado");
			return true;
		}
		return false;
	}
	
	public boolean crearArchivo(String nombre) {
		FileWriter escritura;
		try {
			escritura = new FileWriter(nombre);
			escritura.write("");
			System.out.println("Archivo creado");
			escritura.close();
			return true;
		}catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void leerxletra() {
		FileReader entrada;
		try {
			entrada=new FileReader(this.ruta);
			int c= entrada.read();
			while(c!=-1){
				char letra = (char)c;				
				System.out.println(letra);
				c=entrada.read();
			}
			entrada.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void LeerRenglon (){
		FileReader entrada;
		try {
			entrada = new FileReader(ruta);
			BufferedReader miBuffer = new BufferedReader(entrada);
			String linea="";
			TreeSet<Persona> lista = new TreeSet<Persona>();
			while(linea!= null) {
				Persona obj= new Persona();
				String[] separador = linea.split("-");
				for (int x=0; x<separador.length; x++) {
					if (x==0) {
						obj.setNombre(separador[x]);
					}
					if (x==1) {
						obj.setApellido(separador[x]);
					}
					if(x==2) {
						obj.setDNI(obj.DNIOK(separador[x]));														
					}
				}
				if (obj.getDNI()!=999) {					
					lista.add(obj);
				}
				linea= miBuffer.readLine();
			}
			Persona.setLista(lista);;
			miBuffer.close();
			entrada.close();
		}
		catch (DNIinvalido e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("No se encontro archivo.");
		}
	}
	public void EscribirXlinea(String ruta,Persona obj) {
		try {
			FileWriter entrada = new FileWriter(ruta, true);
			BufferedWriter miBuffer= new BufferedWriter(entrada);
			miBuffer.write(obj.toString()+"\n");
			LeerRenglon();
			miBuffer.close();
			entrada.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
