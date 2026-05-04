package vista;

import java.util.InputMismatchException;
import java.util.Scanner;

import controlador.BaseDeDatos;
import modelo.Electrodomestico;

public class Consola {
	
	public String pideCadena(String mensaje) {
		Scanner leer = new Scanner(System.in);
        System.out.print(mensaje);
        return leer.nextLine();
    }
	
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
	    	System.out.println("Opción 1. Crear un Electrodomestico ");
	    	System.out.println("Opción 2. Modificar un Electrodomestico ");
	    	System.out.println("Opción 3. Borrar un Electrodomestico ");
	    	System.out.println("Opción 4. Consultar un Electrodomestico ");
	    	System.out.println("Opción 0. Salir ");
	    	opcion = pideEntero("Voy a elegir la opción ");
	    	if(opcion<0 || opcion>4) {
	    		System.out.println("\n\tOpción fuera de rango");
	    	}
    	}while(opcion<0 || opcion>4);

		return opcion;
    }
    
    
    
    public Electrodomestico pideElectrodomestico(){
    	Electrodomestico e = new Electrodomestico();
        
        e.setTipo(pideCadena("Introduce el tipo de electrodomestico: "));
        e.setMarca(pideCadena("Introduce la marca del electrodomestico: "));
        e.setPrecio(pideEntero("Introduce el precio del electrodomestico: "));
        e.setConsumo(pideEntero("Introduce el consumo del electrodomestico: "));
        e.setVendido(pideBooleano("¿Está vendido el electrodoméstico?: "));
        
        
        return e;

    }
}