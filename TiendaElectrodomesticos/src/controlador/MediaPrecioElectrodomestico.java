package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MediaPrecioElectrodomestico{
    public void mostrarMediaPrecios() { 
        try {
            Connection conexion = BaseDeDatos.conectar();
            String sql = "SELECT AVG(precio) AS media_precios FROM electrodomesticos";
            Statement frase = conexion.createStatement();
            ResultSet res = frase.executeQuery(sql);

            if (res.next()) {
                double media = res.getDouble("media_precios");
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