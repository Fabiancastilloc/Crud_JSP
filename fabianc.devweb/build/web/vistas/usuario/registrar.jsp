<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Usuario</title>
    <link rel="stylesheet" href="css/registrarU.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
    <div class="container">
        <div class="formulario">
            <h1>Registrar Usuario</h1>

            <!-- Mostrar el mensaje de éxito -->
            <c:if test="${not empty mensaje}">
                <div class="mensaje mensaje-exito">${mensaje}</div>
            </c:if>

            <!-- Mostrar el mensaje de error -->
            <c:if test="${not empty error}">
                <div class="mensaje">${error}</div>
            </c:if>

            <form action="usuario" method="post">
                <input type="hidden" name="accion" value="registrar">
                <label for="cc"><i class="fas fa-id-card"></i> Cédula:</label>
                <input type="text" id="cc" name="cc" required>
                <label for="pass"><i class="fas fa-lock"></i> Contraseña:</label>
                <input type="password" id="pass" name="pass" required>
                <label for="nombre"><i class="fas fa-user"></i> Nombre:</label>
                <input type="text" id="nombre" name="nombre" required>
                <label for="apellido"><i class="fas fa-user"></i> Apellido:</label>
                <input type="text" id="apellido" name="apellido" required>
                <label for="genero"><i class="fas fa-venus-mars"></i> Género:</label>
                <select id="genero" name="genero">
                    <option value="M">Masculino</option>
                    <option value="F">Femenino</option>
                </select>
                <label for="email"><i class="fas fa-envelope"></i> Email:</label>
                <input type="email" id="email" name="email" required>
                <button type="submit"><i class="fas fa-user-plus"></i> Registrar</button>
            </form>

            <div class="enlaces">
                <a href="index.jsp"><i class="fas fa-home"></i> Ir a Inicio</a>
                <a href="usuario?accion=login"><i class="fas fa-sign-in-alt"></i> Ir a Login</a>
            </div>
        </div>
    </div>
</body>
</html>


