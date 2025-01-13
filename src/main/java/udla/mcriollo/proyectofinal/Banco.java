package udla.mcriollo.proyectofinal;
import java.sql.*;

public class Banco {

    private String url;
    private String usr;
    private String ps;

    public Banco(String url, String usr, String ps) {
        this.url = url;
        this.usr = usr;
        this.ps = ps;
    }

    public void registrarCuenta(String numeroCuenta, String nombre, String cedula, String direccion) {
        String insertSQL = "INSERT INTO cuentas (numero_cuenta, nombre, cedula, direccion) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(url, usr, ps);
             PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            pstmt.setString(1, numeroCuenta);
            pstmt.setString(2, nombre);
            pstmt.setString(3, cedula);
            pstmt.setString(4, direccion);
            pstmt.executeUpdate();
            System.out.println("Cuenta registrada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al registrar la cuenta: " + e.getMessage());
        }
    }

    public void listarCuentas() {
        String selectSQL = "SELECT * FROM cuentas";
        try (Connection connection = DriverManager.getConnection(url, usr, ps);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {
            while (rs.next()) {
                System.out.println("Cuenta: " + rs.getString("numero_cuenta") + ", Cliente: " + rs.getString("nombre") +
                        ", Cédula: " + rs.getString("cedula") + ", Dirección: " + rs.getString("direccion"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar cuentas: " + e.getMessage());
        }
    }

    public void eliminarCuenta(String numeroCuenta) {
        String deleteSQL = "DELETE FROM cuentas WHERE numero_cuenta = ?";
        try (Connection connection = DriverManager.getConnection(url, usr, ps);
             PreparedStatement pstmt = connection.prepareStatement(deleteSQL)) {
            pstmt.setString(1, numeroCuenta);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cuenta eliminada correctamente.");
            } else {
                System.out.println("No se encontró una cuenta con ese número.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar la cuenta: " + e.getMessage());
        }
    }

    public void buscarCuenta(String numeroCuenta) {
        String searchSQL = "SELECT * FROM cuentas WHERE numero_cuenta = ?";
        try (Connection connection = DriverManager.getConnection(url, usr, ps);
             PreparedStatement pstmt = connection.prepareStatement(searchSQL)) {
            pstmt.setString(1, numeroCuenta);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Cuenta: " + rs.getString("numero_cuenta") + ", Cliente: " + rs.getString("nombre") +
                            ", Cédula: " + rs.getString("cedula") + ", Dirección: " + rs.getString("direccion"));
                } else {
                    System.out.println("No se encontró una cuenta con ese número.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar la cuenta: " + e.getMessage());
        }
    }
}
