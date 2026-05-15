package vista;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controlador.BaseDeDatos;
import modelo.Electrodomestico;

public class Consola {
	/**
	 * Método para pedir al usuario un texto
	 * @param mensaje (le pasamos la pregunta)
	 * @return del texto que ha introducido el usuario
	 */
	public String pideCadena(String mensaje) {
		Scanner leer = new Scanner(System.in);
        System.out.print(mensaje);
        return leer.nextLine();
    }
	/**
	 * Método para pedir al usuario un numero entero
	 * @param mensaje (le pasamos la pregunta)
	 * @return del número introducido por el usuario
	 */
    public int pideEntero(String mensaje) {
    	Scanner leer = new Scanner(System.in);
        int numero = 0;
        boolean letra;
        do {
            System.out.print(mensaje);
        	letra = true;
	        try{
		        numero = leer.nextInt();
		        leer.nextLine();
		        letra = false;
	        }catch (InputMismatchException e) {
				System.out.println("\n\t¡Has introducido un carácter!\n");
				leer.next();
			}
        }while(letra);
        return numero;
    }
    /**
     * Método para pedir verdadero o falso al usuario
     * @param mensaje (le pasamos la pregunta)
     * @return del true o false introducido 
     */
    public boolean pideBooleano(String mensaje) {
    	Scanner leer = new Scanner(System.in);
        System.out.print(mensaje + " (true/false): ");
        boolean valor = leer.nextBoolean();
        leer.nextLine();
        return valor;
    }
    
    /**
     * Menú principal de la aplicación, se repetirá hasta que el usuario seleccione una opción registrada.
     * @return el número asociado a la opción deseada por el usuario.
     */
    public int menuPrincipal() {
    	int opcion;
    	do {
	    	System.out.println("\n\tMenu Electrodomestico\n");
	    	System.out.println("Opción 1. Crear un electrodoméstico");
	    	System.out.println("Opción 2. Modificar un electrodoéstico");
	    	System.out.println("Opción 3. Borrar un electrodoméstico");
	    	System.out.println("Opción 4. Consultar un electrodoméstico");
	    	System.out.println("Opción 5. Consultar la media de los precios");
	    	System.out.println("Opción 6. Consultar los electrodomésticos con menos de 15% de consumo");
	    	System.out.println("Opción 0. Salir ");
	    	opcion = pideEntero("Voy a elegir la opción: ");
	    	if(opcion<0 || opcion>6) {
	    		System.out.println("\n\tOpción fuera de rango");
	    	}
    	}while(opcion<0 || opcion>6);

		return opcion;
    }
    
    
    /**
     * Método parqa pedir objeto electrodoméstico al usuario con todas sus especificaciones
     * @return del objeto relleno de información por el usuario
     */
    public Electrodomestico pideElectrodomestico(){
    	Electrodomestico e = new Electrodomestico();
        
        e.setTipo(pideCadena("Introduce el tipo de electrodomestico: "));
        e.setMarca(pideCadena("Introduce la marca del electrodomestico: "));
        e.setPrecio(pideEntero("Introduce el precio del electrodomestico: "));
        e.setConsumo(pideEntero("Introduce el consumo del electrodomestico: "));
        e.setVendido(pideBooleano("¿Está vendido el electrodoméstico?: "));
        
        
        return e;

    }
    /**
     * Método para consultar electrodoméstico que consuma menos del 15%
     */
    public void consultarMenor15() {

        BaseDeDatos bd = new BaseDeDatos();

        ArrayList<Electrodomestico> lista = bd.consultarMenor15();

        if(lista != null) {
            for(Electrodomestico e : lista) {
                System.out.println();
                System.out.println("Identificador: " + e.getId());
                System.out.println("Tipo: " + e.getTipo());
                System.out.println("Marca: " + e.getMarca());
                System.out.println("Consumo: " + e.getConsumo());
            }
        } else {
            System.out.println("\n\tNo hay ningún electrodoméstico con esas características\n");
        }
    }
}