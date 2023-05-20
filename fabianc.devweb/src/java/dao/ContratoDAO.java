package dao;

import modelo.Contrato;
import modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContratoDAO {
    private final Connection connection;

    public ContratoDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean registrarContrato(Contrato contrato) {
        String query = "INSERT INTO contratos (fechaFirma, fechaInicio, fechaFin, empresa, empleado, funciones, monto, " +
                "frecuenciaDePago, usuariocc) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, contrato.getFechaFirma());
            statement.setString(2, contrato.getFechaInicio());
            statement.setString(3, contrato.getFechaFin());
            statement.setString(4, contrato.getEmpresa());
            statement.setString(5, contrato.getEmpleado());
            statement.setString(6, contrato.getFunciones());
            statement.setDouble(7, contrato.getMonto());
            statement.setString(8, contrato.getFrecuenciaDePago());
            statement.setInt(9, contrato.getUsuarioCc());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean actualizarContrato(Contrato contrato) {
        String query = "UPDATE contratos SET fechaFirma = ?, fechaInicio = ?, fechaFin = ?, empresa = ?, " +
                "empleado = ?, funciones = ?, monto = ?, frecuenciaDePago = ?, usuariocc = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, contrato.getFechaFirma());
            statement.setString(2, contrato.getFechaInicio());
            statement.setString(3, contrato.getFechaFin());
            statement.setString(4, contrato.getEmpresa());
            statement.setString(5, contrato.getEmpleado());
            statement.setString(6, contrato.getFunciones());
            statement.setDouble(7, contrato.getMonto());
            statement.setString(8, contrato.getFrecuenciaDePago());
            statement.setInt(9, contrato.getUsuarioCc());
            statement.setInt(10, contrato.getId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminarContrato(int id) {
        String query = "DELETE FROM contratos WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Contrato> listarContratos() {
        String query = "SELECT * FROM contratos";
        List<Contrato> contratos = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fechaFirma = resultSet.getString("fechaFirma");
                String fechaInicio = resultSet.getString("fechaInicio");
                String fechaFin = resultSet.getString("fechaFin");
                String empresa = resultSet.getString("empresa");
                String empleado = resultSet.getString("empleado");
                String funciones = resultSet.getString("funciones");
                double monto = resultSet.getDouble("monto");
                String frecuenciaDePago = resultSet.getString("frecuenciaDePago");
                int usuarioCc = resultSet.getInt("usuariocc");

                Contrato contrato = new Contrato(id, fechaFirma, fechaInicio, fechaFin, empresa, empleado,
                        funciones, monto, frecuenciaDePago, usuarioCc);
                contratos.add(contrato);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return contratos;
    }

    public Contrato obtenerContratoPorId(int id) {
        String query = "SELECT * FROM contratos WHERE id = ?";
        Contrato contrato = null;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String fechaFirma = resultSet.getString("fechaFirma");
                    String fechaInicio = resultSet.getString("fechaInicio");
                    String fechaFin = resultSet.getString("fechaFin");
                    String empresa = resultSet.getString("empresa");
                    String empleado = resultSet.getString("empleado");
                    String funciones = resultSet.getString("funciones");
                    double monto = resultSet.getDouble("monto");
                    String frecuenciaDePago = resultSet.getString("frecuenciaDePago");
                    int usuarioCc = resultSet.getInt("usuariocc");

                    contrato = new Contrato(id, fechaFirma, fechaInicio, fechaFin, empresa, empleado,
                            funciones, monto, frecuenciaDePago, usuarioCc);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return contrato;
    }

    public List<Usuario> listarUsuarios() {
        String query = "SELECT * FROM usuarios";
        List<Usuario> usuarios = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int cc = resultSet.getInt("cc");
                String pass = resultSet.getString("pass");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String genero = resultSet.getString("genero");
                String email = resultSet.getString("email");

                Usuario usuario = new Usuario(cc, pass, nombre, apellido, genero, email);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return usuarios;
    }
    
    public List<Contrato> obtenerContratos(int usuarioCc) {
    String query = "SELECT * FROM contratos WHERE usuariocc = ?";
    List<Contrato> contratos = new ArrayList<>();

    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, usuarioCc);

        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fechaFirma = resultSet.getString("fechaFirma");
                String fechaInicio = resultSet.getString("fechaInicio");
                String fechaFin = resultSet.getString("fechaFin");
                String empresa = resultSet.getString("empresa");
                String empleado = resultSet.getString("empleado");
                String funciones = resultSet.getString("funciones");
                double monto = resultSet.getDouble("monto");
                String frecuenciaDePago = resultSet.getString("frecuenciaDePago");

                Contrato contrato = new Contrato(id, fechaFirma, fechaInicio, fechaFin, empresa, empleado,
                        funciones, monto, frecuenciaDePago, usuarioCc);
                contratos.add(contrato);
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return contratos;
}

}


