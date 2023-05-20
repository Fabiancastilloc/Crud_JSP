<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página de Inicio</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
    <div class="container">
        <h1>Bienvenido al CRUD Contratos</h1>
        <%-- Verificar si el usuario ha iniciado sesión --%>
        <% if (session.getAttribute("usuario") == null) { %>
            <ul class="options-list">
                <li><a class="button" href="usuario?accion=registrar"><i class="fas fa-user-plus"></i> Registro de Usuario</a></li>
                <li><a class="button" href="usuario?accion=login"><i class="fas fa-sign-in-alt"></i> Iniciar Sesión</a></li>
            </ul>
            <div class="additional-content">
            <h3>Agrega contratos a tu empresa</h3>
            <p>Utiliza nuestra plataforma para agregar y gestionar contratos para tu empresa. Nuestro sistema te permite:</p>
            <ul>
                <li>Registrar nuevos contratos con toda la información necesaria.</li>
                <li>Visualizar y buscar contratos existentes en la lista de contratos.</li>
                <li>Realizar ediciones y actualizaciones en los contratos existentes.</li>
                <li>Eliminar contratos que ya no sean necesarios.</li>
            </ul>
            <p>Con nuestra plataforma de gestión de contratos, podrás mantener un control efectivo y organizado de los contratos de tu empresa.</p>
            <p>¡Regístrate ahora y comienza a agregar contratos!</p>
        <% } else { %>
            <ul class="options-list">
                <li><a class="button" href="usuario?accion=listar"><i class="fas fa-users"></i> Listado de Usuarios</a></li>
                <li><a class="button" href="contrato?accion=registrar"><i class="fas fa-file-alt"></i> Registrar Contrato</a></li>
                <li><a class="button" href="contrato?accion=listar"><i class="fas fa-list"></i> Lista de Contratos</a></li>
                <%-- Agregar más opciones para usuarios autenticados aquí --%>
                <li><a class="button" href="usuario?accion=cerrarSesion"><i class="fas fa-sign-out-alt"></i> Cerrar Sesión</a></li>
            </ul>
            <div class="additional-content">
                <h2>Contenido adicional para usuarios autenticados:</h2>
                <h3>Bienvenido(a) </h3>
                <p>Ahora que has iniciado sesión, tienes acceso a funciones adicionales en nuestra plataforma de gestión de contratos. Aquí puedes encontrar opciones para administrar usuarios y contratos, así como realizar otras acciones específicas según tus permisos.</p>
                <p>Explora las diferentes opciones en el menú y comienza a aprovechar al máximo nuestra plataforma.</p>
            </div>
        <% } %>
        <div class="image-collage">
            <img src="imagenes/1.jpg" alt="Descripción de la imagen 1">
            <img src="imagenes/2.jpg" alt="Descripción de la imagen 2">
            <img src="imagenes/3.jpg" alt="Descripción de la imagen 3">
        </div>
    </div>
</body>
</html>







