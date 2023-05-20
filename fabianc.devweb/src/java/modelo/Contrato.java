package modelo;

public class Contrato {
    private int id;
    private String fechaFirma;
    private String fechaInicio;
    private String fechaFin;
    private String empresa;
    private String empleado;
    private String funciones;
    private double monto;
    private String frecuenciaDePago;
    private int usuarioCc;

    public Contrato() {
    }

    public Contrato(int id, String fechaFirma, String fechaInicio, String fechaFin, String empresa, String empleado,
                    String funciones, double monto, String frecuenciaDePago, int usuarioCc) {
        this.id = id;
        this.fechaFirma = fechaFirma;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.empresa = empresa;
        this.empleado = empleado;
        this.funciones = funciones;
        this.monto = monto;
        this.frecuenciaDePago = frecuenciaDePago;
        this.usuarioCc = usuarioCc;
    }

    public Contrato(String fechaFirma, String fechaInicio, String fechaFin, String empresa, String empleado, String funciones, double monto, String frecuenciaPago, int usuariocc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Contrato(int id, String fechaFirma, String fechaInicio, String fechaFin, String empresa, String empleado, String funciones, double monto, String frecuenciaPago) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaFirma() {
        return fechaFirma;
    }

    public void setFechaFirma(String fechaFirma) {
        this.fechaFirma = fechaFirma;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getFunciones() {
        return funciones;
    }

    public void setFunciones(String funciones) {
        this.funciones = funciones;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFrecuenciaDePago() {
        return frecuenciaDePago;
    }

    public void setFrecuenciaDePago(String frecuenciaDePago) {
        this.frecuenciaDePago = frecuenciaDePago;
    }

    public int getUsuarioCc() {
        return usuarioCc;
    }

    public void setUsuarioCc(int usuarioCc) {
        this.usuarioCc = usuarioCc;
    }

    public String getFrecuenciaPago() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getUsuariocc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
