package co.edu.uniquindio.poo.model;

public class Contacto {

    private String nombre;
    private String alias;
    private String direccion;
    private String telefono;
    private String email;



    public Contacto (String nombre, String alias, String direccion, String telefono,String email) {
        this.nombre=nombre;
        this.alias=alias;
        this.direccion=direccion;
        this.telefono=telefono;
        this.email=email;

    }



    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getAlias() {
        return alias;
    }



    public void setAlias(String alias) {
        this.alias = alias;
    }



    public String getDireccion() {
        return direccion;
    }



    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }



    public String getTelefono() {
        return telefono;
    }



    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return "Contacto [nombre=" + nombre + ", alias=" + alias + ", direccion=" + direccion + ", telefono=" + telefono
                + ", email=" + email + "]";
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
        return result;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contacto other = (Contacto) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (telefono == null) {
            if (other.telefono != null)
                return false;
        } else if (!telefono.equals(other.telefono))
            return false;
        return true;
    }



    
}
