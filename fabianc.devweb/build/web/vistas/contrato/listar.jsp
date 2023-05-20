<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listar Contratos</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/listarC.css" />">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
    <div class="container">
        <h1>Listar Contratos</h1>
        <form action="contrato" method="GET">
            <input type="hidden" name="accion" value="buscar">
            <label for="usuarioCc">Buscar contratos por Usuario CC:</label>
            <input type="text" name="usuarioCc">
            <button type="submit"><i class="fas fa-search"></i> Buscar</button>
        </form>
        <table>
            <tr>
                <th>ID</th>
                <th>Fecha de Firma</th>
                <th>Fecha de Inicio</th>
                <th>Fecha de Fin</th>
                <th>Empresa</th>
                <th>Empleado</th>
                <th>Funciones</th>
                <th>Monto</th>
                <th>Frecuencia de Pago</th>
                <th>Usuario CC</th>
                <th>Acciones</th>
            </tr>
            <c:forEach var="contrato" items="${contratos}">
                <tr>
                    <td>${contrato.id}</td>
                    <td>${contrato.fechaFirma}</td>
                    <td>${contrato.fechaInicio}</td>
                    <td>${contrato.fechaFin}</td>
                    <td>${contrato.empresa}</td>
                    <td>${contrato.empleado}</td>
                    <td>${contrato.funciones}</td>
                    <td>${contrato.monto}</td>
                    <td>${contrato.frecuenciaDePago}</td>
                    <td>${contrato.usuarioCc}</td>
                    <td>
                        <a class="btn btn-editar" href="contrato?accion=editar&id=${contrato.id}"><i class="fas fa-edit"></i> Editar</a>
                        <a class="btn btn-eliminar" href="contrato?accion=eliminar&id=${contrato.id}"><i class="fas fa-trash"></i> Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="<c:url value="/index.jsp" />"><i class="fas fa-arrow-left"></i> Volver a Inicio</a>
    </div>
</body>
</html>




