package controlador;

import dao.ConexionBD;
import dao.ContratoDAO;
import modelo.Contrato;
import modelo.Usuario;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorContrato", urlPatterns = {"/contrato"})
public class ControladorContrato extends HttpServlet {

    private final ContratoDAO contratoDAO;

    public ControladorContrato() {
        super();
        contratoDAO = new ContratoDAO(ConexionBD.getConnection());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "registrar":
                    mostrarFormularioRegistro(request, response);
                    break;
                case "listar":
                    listarContratos(request, response);
                    break;
                case "editar":
                    mostrarFormularioEdicion(request, response);
                    break;
                case "eliminar":
                    eliminarContrato(request, response);
                    break;
                case "buscar":
                    buscarContratos(request, response);
                    break;
                default:
                    mostrarError(request, response, "Acción inválida");
            }
        } else {
            mostrarError(request, response, "Acción no especificada");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "registrar":
                    registrarContrato(request, response);
                    break;
                case "editar":
                    editarContrato(request, response);
                    break;
                case "eliminar":
                    eliminarContrato(request, response);
                    break;
                default:
                    mostrarError(request, response, "Acción inválida");
            }
        } else {
            mostrarError(request, response, "Acción no especificada");
        }
    }

    private void mostrarFormularioRegistro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Usuario> usuarios = contratoDAO.listarUsuarios();
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("vistas/contrato/registrar.jsp").forward(request, response);
    }

    private void mostrarFormularioEdicion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Contrato contrato = contratoDAO.obtenerContratoPorId(id);
        List<Usuario> usuarios = contratoDAO.listarUsuarios();
        request.setAttribute("contrato", contrato);
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("vistas/contrato/editar.jsp").forward(request, response);
    }

    private void registrarContrato(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fechaFirma = request.getParameter("fechaFirma");
        String fechaInicio = request.getParameter("fechaInicio");
        String fechaFin = request.getParameter("fechaFin");
        String empresa = request.getParameter("empresa");
        String empleado = request.getParameter("empleado");
        String funciones = request.getParameter("funciones");
        double monto = Double.parseDouble(request.getParameter("monto"));
        String frecuenciaDePago = request.getParameter("frecuenciaDePago");
        int usuarioCc = Integer.parseInt(request.getParameter("usuarioCc"));

        Contrato contrato = new Contrato(0, fechaFirma, fechaInicio, fechaFin, empresa, empleado, funciones,
                monto, frecuenciaDePago, usuarioCc);

        boolean registrado = contratoDAO.registrarContrato(contrato);

        if (registrado) {
            request.setAttribute("mensaje", "Contrato registrado exitosamente");
        } else {
            request.setAttribute("error", "Error al registrar el contrato");
        }

        listarContratos(request, response);
    }

    private void editarContrato(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String fechaFirma = request.getParameter("fechaFirma");
        String fechaInicio = request.getParameter("fechaInicio");
        String fechaFin = request.getParameter("fechaFin");
        String empresa = request.getParameter("empresa");
        String empleado = request.getParameter("empleado");
        String funciones = request.getParameter("funciones");
        double monto = Double.parseDouble(request.getParameter("monto"));
        String frecuenciaDePago = request.getParameter("frecuenciaDePago");
        int usuarioCc = Integer.parseInt(request.getParameter("usuarioCc"));

        Contrato contrato = new Contrato(id, fechaFirma, fechaInicio, fechaFin, empresa, empleado, funciones,
                monto, frecuenciaDePago, usuarioCc);

        boolean actualizado = contratoDAO.actualizarContrato(contrato);

        if (actualizado) {
            request.setAttribute("mensaje", "Contrato actualizado exitosamente");
        } else {
            request.setAttribute("error", "Error al actualizar el contrato");
        }

        listarContratos(request, response);
    }

    private void eliminarContrato(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        boolean eliminado = contratoDAO.eliminarContrato(id);

        if (eliminado) {
            request.setAttribute("mensaje", "Contrato eliminado exitosamente");
        } else {
            request.setAttribute("error", "Error al eliminar el contrato");
        }

        listarContratos(request, response);
    }

    private void listarContratos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Contrato> contratos = contratoDAO.listarContratos();
        request.setAttribute("contratos", contratos);
        request.getRequestDispatcher("vistas/contrato/listar.jsp").forward(request, response);
    }

    private void mostrarError(HttpServletRequest request, HttpServletResponse response, String mensaje)
            throws ServletException, IOException {
        request.setAttribute("error", mensaje);
        request.getRequestDispatcher("error.jsp").forward(request, response);
    }
    
    private void buscarContratos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int usuarioCc = Integer.parseInt(request.getParameter("usuarioCc"));
        List<Contrato> contratos = contratoDAO.obtenerContratos(usuarioCc);
        request.setAttribute("contratos", contratos);
        request.getRequestDispatcher("vistas/contrato/listar.jsp").forward(request, response);
    }
}
