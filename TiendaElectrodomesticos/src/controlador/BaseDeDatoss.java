package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Electrodomestico;
import vista.Consola;

public class BaseDeDatoss {
	
	/**
	 * Método para la creación de la conexión a la base de datos.
	 * @return
	 * @throws SQLException
	 */
	private Connection getConexion() throws SQLException {
		String url = "jdbc:mysql://localhost/bd_electrodomesticos";
	    //String url = "jdbc:mysql://192.168.1.3:3306/bd_electrodomesticos?useSSL=false";
		String usuario = "root";
	    //String usuario = "marcos";
		String constraseña = "";
	    //String constraseña = "123456";

	    return DriverManager.getConnection(url, usuario, constraseña);
	}
	
	/**
	 * Método en el que se modifica un producto de la base de datos.
	 */
	public void modificarElectrodomestico() {
		Connection conexion;
		Consola c = new Consola();
		
		try {
			conexion = getConexion();
			
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select id_Electrodomestico, tipo from electrodomestico ");
			
			System.out.println("\nID -- Tipo");
			while(registro.next()) {
				System.out.println(registro.getString("id_Electrodomestico")+"  -- "+ registro.getString("tipo"));
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int idElectrodomestico = c.pideEntero("Introduzca el ID del electrodomestico a modificar: ");
		Electrodomestico e = c.pideElectrodomestico();
		
		try {
			conexion = getConexion();
			Statement consulta = conexion.createStatement();
			int valor = consulta.executeUpdate("UPDATE electrodomestico SET tipo='" + e.getTipo() + "', marca='" + e.getMarca() + "', precio=" + e.getPrecio() + ", consumo=" + e.getConsumo() + " WHERE id_electrodomestico=" + idElectrodomestico);
			
			if(valor==1) {
				System.out.println("\t\nArtículo modificado correctamente\n");
			}else {
				System.out.println("\t\nNo existe un Electrodomestico con dicho identificador\n");
			}
			conexion.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Método en el que se borra un producto de la base de datos.
	 */
	public void borrarElectrodomestico() {
		Connection conexion;
		Consola c = new Consola();
		
		try {
			conexion = getConexion();
			
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select id_Electrodomestico, tipo from electrodomestico ");
			
			System.out.println("\nID -- Tipo");
			while(registro.next()) {
				System.out.println(registro.getString("id_Electrodomestico")+"  -- "+ registro.getString("tipo"));
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int idElectrodomestico = c.pideEntero("Introduzca el ID del electrodomestico a borrar: ");
		
		try {
			conexion = getConexion();
			Statement consulta = conexion.createStatement();
			System.out.println("¿Está seguro de que quiere eliminarlo?");
		    System.out.println("1. Sí, estoy seguro.");
		    System.out.println("2. No");
		    int opcion = c.pideEntero("Elija una opción: ");

		    if(opcion == 1) {
		        int valor = consulta.executeUpdate("DELETE FROM electrodomestico WHERE id_electrodomestico=" + idElectrodomestico);
		        if(valor == 1) {
		            System.out.println("\nArtículo eliminado correctamente\n");
		        } else {
		            System.out.println("\nNo existe un Electrodoméstico con dicho identificador\n");
		        }
		    } else {
		        System.out.println("\nOperación cancelada\n");
		    }
		    conexion.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}	
}
