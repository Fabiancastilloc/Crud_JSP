<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Contrato</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/editar.css" />">
</head>
<body>
    <div class="container">
        <h1>Editar Contrato</h1>
    <form action="contrato" method="POST">
        <input type="hidden" name="accion" value="editar">
            <input type="hidden" name="id" value="${contrato.id}">
            <label for="fechaFirma">Fecha de Firma:</label>
            <input type="text" id="fechaFirma" name="fechaFirma" value="${contrato.fechaFirma}" required>
            <br><br>
            <label for="fechaInicio">Fecha de Inicio:</label>
            <input type="text" id="fechaInicio" name="fechaInicio" value="${contrato.fechaInicio}" required>
            <br><br>
            <label for="fechaFin">Fecha de Fin:</label>
            <input type="text" id="fechaFin" name="fechaFin" value="${contrato.fechaFin}" required>
            <br><br>
            <label for="empresa">Empresa:</label>
            <input type="text" id="empresa" name="empresa" value="${contrato.empresa}" required>
            <br><br>
            <label for="empleado">Empleado:</label>
            <input type="text" id="empleado" name="empleado" value="${contrato.empleado}" required>
            <br><br>
            <label for="funciones">Funciones:</label>
            <textarea id="funciones" name="funciones" required>${contrato.funciones}</textarea>
            <br><br>
            <label for="monto">Monto:</label>
            <input type="text" id="monto" name="monto" value="${contrato.monto}" required>
            <br><br>
            <label for="frecuenciaDePago">Frecuencia de Pago:</label>
            <input type="text" id="frecuenciaDePago" name="frecuenciaDePago" value="${contrato.frecuenciaDePago}" required>
            <br><br>
            <label for="usuarioCc">Usuario CC:</label>
            <select id="usuarioCc" name="usuarioCc" required>
                <c:forEach var="usuario" items="${usuarios}">
                    <option value="${usuario.cc}" <c:if test="${usuario.cc eq contrato.usuarioCc}">selected</c:if>>${usuario.nombre} ${usuario.apellido}</option>
                </c:forEach>
            </select>
            <br><br>
            <input type="submit" value="Guardar Cambios">
        </form>
        <br>
               <div class="button-container">
            <a href="<c:url value="/index.jsp" />" class="btn btn-inicio"><i class="fas fa-home"></i> Volver a Inicio</a>
    </div>
</body>
</html>
