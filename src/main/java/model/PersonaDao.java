package model;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class PersonaDao {
    private Connection obtenerConexion() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/tp8_proxy", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<Telefono> numeroPorId(int id) {
        String sql = "select p.nombre, t.num "
                + "from persona p, telefono t "
                + "where p.ID_num = t.num and p.ID = ?";
        try (Connection conn = obtenerConexion();
             PreparedStatement statement =
                     conn.prepareStatement(sql);) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            Set<Telefono> telefonos = new HashSet<Telefono>();
            //String nombrePersona = null;
            while (result.next()) {
                //nombrePersona = result.getString(1);
                telefonos.add(new Telefono(result.getString(2)));
            }
            return telefonos;
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Persona personaPorId(int id) {
        String sql = "select p.nombre, t.num "
                + "from persona p, telefono t "
                + "where p.ID_num = t.num and p.ID = ?";
        try (Connection conn = obtenerConexion();
             PreparedStatement statement =
                     conn.prepareStatement(sql);) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            ProxySet telefonos = new ProxySet(this, id);
            String nombrePersona = null;
            while (result.next()) {
                nombrePersona = result.getString(1);
                //telefonos.add(new Telefono(result.getString(2)));
            }
            return new Persona(id, nombrePersona, telefonos);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
