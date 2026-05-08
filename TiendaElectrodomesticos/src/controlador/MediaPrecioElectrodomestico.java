package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MediaPrecioElectrodomestico{
    public void mostrarMediaPrecios() { 
    	BaseDeDatos basededatos = new BaseDeDatos();
    	Connection conexion;
        try {
            conexion = basededatos.getConexion();
            String sql = "SELECT AVG(precio) AS Media_Precios FROM electrodomestico";
            Statement frase = conexion.createStatement();
            ResultSet res = frase.executeQuery(sql);

            if (res.next()) {
                double media = res.getDouble("Media_Precios");
                System.out.println("La media de precios es: " + media);
            }

            res.close();
            frase.close();
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}