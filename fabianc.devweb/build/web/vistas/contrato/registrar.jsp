<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Contrato</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/registrarC.css" />">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
    <div class="container">
        <h1>Registrar Contrato</h1>
        <form action="contrato" method="POST">
            <input type="hidden" name="accion" value="registrar">
            <div class="form-group">
                <label for="fechaFirma">Fecha de Firma:</label>
                <input type="date" id="fechaFirma" name="fechaFirma" required>
            </div>

            <div class="form-group">
                <label for="fechaInicio">Fecha de Inicio:</label>
                <input type="date" id="fechaInicio" name="fechaInicio" required>
            </div>

            <div class="form-group">
                <label for="fechaFin">Fecha de Fin:</label>
                <input type="date" id="fechaFin" name="fechaFin" required>
            </div>

            <div class="form-group">
                <label for="empresa">Empresa:</label>
                <input type="text" id="empresa" name="empresa" required>
            </div>

            <div class="form-group">
                <label for="empleado">Empleado:</label>
                <input type="text" id="empleado" name="empleado" required>
            </div>

            <div class="form-group">
                <label for="funciones">Funciones:</label>
                <textarea id="funciones" name="funciones" required></textarea>
            </div>

            <div class="form-group">
                <label for="monto">Monto:</label>
                <input type="text" id="monto" name="monto" required>
            </div>

            <div class="form-group">
                <label for="frecuenciaDePago">Frecuencia de Pago:</label>
                <input type="text" id="frecuenciaDePago" name="frecuenciaDePago" required>
            </div>

            <div class="form-group">
                <label for="usuarioCc">Usuario CC:</label>
                <select id="usuarioCc" name="usuarioCc" required>
                    <c:forEach var="usuario" items="${usuarios}">
                        <option value="${usuario.cc}">${usuario.nombre} ${usuario.apellido}</option>
                    </c:forEach>
                </select>
            </div>

            <input type="submit" value="Registrar" class="btn btn-registrar">
        </form>

        <div class="button-container">
            <a href="<c:url value="/index.jsp" />" class="btn btn-inicio"><i class="fas fa-home"></i> Volver a Inicio</a>
        </div>
    </div>
</body>
</html>







