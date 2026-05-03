package controlador;

import vista.Consola;

public class Principal {

	public static void main(String[] args) {
		Consola c = new Consola();
    	BaseDeDatos ba = new BaseDeDatos();

		int opcion = c.menuPrincipal();
		
		switch (opcion) {
		case 1: {
			//ba.insertarElectrodomestico();
			break;
		}
		case 2:{
			ba.modificarElectrodomestico();
			break;
		}
		case 3:{
			ba.borrarElectrodomestico();
			break;
		}
		case 4:{
			//ba.;
			break;
		}
		case 0:{
			System.out.println("\n\tHas salido");
			break;
		}
		default:
			System.out.println("\n\tOpcion fuera de rango\n");
		}
	}

}