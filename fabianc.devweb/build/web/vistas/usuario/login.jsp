<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Iniciar Sesi�n</title>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
    <div class="container">
        <h1><i class="fas fa-sign-in-alt"></i> Iniciar Sesi�n</h1>
        <form action="usuario" method="post">
            <input type="hidden" name="accion" value="login">
            <div class="input-group">
                <label for="cc"><i class="fas fa-id-card"></i> C�dula:</label>
                <input type="text" id="cc" name="cc" required>
            </div>
            <div class="input-group">
                <label for="pass"><i class="fas fa-lock"></i> Contrase�a:</label>
                <input type="password" id="pass" name="pass" required>
            </div>
            <button type="submit"><i class="fas fa-sign-in-alt"></i> Iniciar Sesi�n</button>
        </form>
        <p class="error-message">
            <c:if test="${not empty error}">${error}</c:if>
        </p>
        <p class="register-link">�No tienes una cuenta? <a href="usuario?accion=registrar"><i class="fas fa-user-plus"></i> Reg�strate aqu�</a></p>
        <div class="home-link">
            <a href="index.jsp"><i class="fas fa-home"></i> Ir a Inicio</a>
        </div>
    </div>
</body>
</html>


