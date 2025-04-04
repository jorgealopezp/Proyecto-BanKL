package co.edu.konradlorenz.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    protected String nombres;
    protected String apellidos;
    protected String id;
    protected String direccion;
    protected int telefono;
    protected String email;
    protected List<Cuenta> cuentas;

    public Cliente() {
    }

    public Cliente(String nombres, String apellidos, String id, String direccion, int telefono, String email) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.id = id;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.cuentas = new ArrayList<>();
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Cuenta> getCuenta() {
        return cuentas;
    }

    public void setCuenta(List<Cuenta> cuenta) {
        this.cuentas = cuenta;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombres=" + nombres + ", apellidos=" + apellidos + ", id=" + id + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + ", cuentas=" + cuentas + '}';
    }

}
