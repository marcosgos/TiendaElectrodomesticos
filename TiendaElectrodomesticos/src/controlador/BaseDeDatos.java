package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Electrodomestico;
import vista.Consola;

public class BaseDeDatos {
	
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
	 * Metodo por el que insertamos un electrodomestico en la base de datos
	 * @return del objeto electrodomestico insertado para guardar en un arrayList
	 */
	public Electrodomestico insertarElectrodomestico() {
		Consola c = new Consola();
		Electrodomestico e = new Electrodomestico();
		e = c.pideElectrodomestico();
		Connection conexion;
				
		try {
			conexion = getConexion();
			Statement consulta = conexion.createStatement();
			
			consulta.executeUpdate("insert into electrodomestico (tipo,marca,precio,consumo,vendido) values('"
					+e.getTipo()+"','"+e.getMarca()+"',"+e.getPrecio()+","+e.getConsumo()+","+e.isVendido()+")");
			conexion.close();
			System.out.println("Producto guardado correctamente");
		} catch (SQLException ex) {
			System.out.println("No se pudo insertar el electrodomestico");
			
		}
		return e;
		
	}
	
	/**
	 * Metodo por el que se consulta un electrodomestico de la base de datos
	 */
	public void consultaElectrodomesticos() {
		Consola c = new Consola();
		Connection conexion;	
		
		try {
			conexion = getConexion();
			Statement consulta = conexion.createStatement();
			ResultSet listado = consulta.executeQuery("select id_electrodomestico, tipo "
														+ "from electrodomestico");
			while(listado.next()) {
				System.out.println("Identificacion: " + listado.getString("id_electrodomestico"));
				System.out.println("Tipo: " + listado.getString("tipo"));
			}
			
			int id_electrodomestico = c.pideEntero("Elija un identificador de electrodomestico: ");
			ResultSet registro = consulta.executeQuery("select * "
														+ "from electrodomestico "
														+ "where id_electrodomestico ="
														+ id_electrodomestico);
			if(registro.next()) {
				System.out.println("Id_producto: " + registro.getString("id_electrodomestico"));
				System.out.println("Tipo: " + registro.getString("tipo"));
				System.out.println("Marca: " + registro.getString("marca"));
				System.out.println("Precio: " + registro.getString("precio"));
				System.out.println("Consumo: " + registro.getString("consumo"));
			} else {
				System.out.println("El electrodomestico con el ID "+ id_electrodomestico + " no existe");
			}
			
			conexion.close();					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
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
