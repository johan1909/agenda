package co.edu.uniquindio.poo.model;

import java.util.Arrays;

public class Grupo {


    private String nombre;
    private Contacto [] listaContactos;
    private int numeroContactos;
    private Categoria categoria;


    public enum Categoria {
        OFICINA,
        FIESTA,
        AMIGOS,
        FAMILIA;
    }


    public Grupo (String nombre,  int numeroContactos, Categoria categoria){
        
        this.nombre = nombre;
        this.numeroContactos= 5;
        this.listaContactos= new Contacto[numeroContactos];
        this.categoria = categoria;

    }


    /**
     * 
     * @return the nombre
     */

    public String getNombre() {
        return nombre;
    }


    /**
     * 
     * @param nombre the nombre to set
     */


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    /**
     * 
     * @return the listaContactos
     */

    public Contacto[] getListaContactos() {
        return listaContactos;
    }


    /**
     * 
     * @param listaContactos the listaContactos to set
     */

    public void setListaContactos(Contacto[] listaContactos) {
        this.listaContactos = listaContactos;
    }


    /**
     * 
     * @return the numeroContactos
     */

    public int getNumeroContactos() {
        return numeroContactos;
    }


    /**
     * 
     * @param numeroContactos the numeroContactos to set
     */

    public void setNumeroContactos(int numeroContactos) {
        this.numeroContactos = numeroContactos;
    }


    /**
     * 
     * @return the categoria
     */

    public Categoria getCategoria() {
        return categoria;
    }


    /**
     * 
     * @param categoria the categoria to set
     */

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


    @Override
    public String toString() {
        return "Grupo [nombre=" + nombre + ", listaContactos=" + Arrays.toString(listaContactos) + ", numeroContactos="
                + numeroContactos + ", categoria=" + categoria + "]";
    }



    /**
     * Este metodo registra un nuevo contacto si en el grupo solo si hay cupo y si no existe
     * @param nuevoContacto
     * @return
     */


    public String registarContacto (Contacto nuevoContacto){
        String mensaje = "";
        int posDisponible = 0;
        Contacto contactoEncontrado = null;

        posDisponible = buscarPosicionDisponible();
        if(posDisponible == -1){
            mensaje = "No hay cupo para un nuevo contacto";
        }else{
            contactoEncontrado = buscarContacto(nuevoContacto.getTelefono());
            if(contactoEncontrado != null){
                mensaje = "Contacto existente";
            }else{
                listaContactos[posDisponible] = nuevoContacto;
                mensaje = "El contacto se agrego correctamente ";
            }
        }
        return mensaje;
    }


    private Contacto buscarContacto(String telefono) {
        Contacto contactoEncontrado = null;
        for (Contacto contactoAux : listaContactos) {
            if(contactoAux.getTelefono().equals(telefono)){
                return contactoAux;
            }
        }
        return contactoEncontrado;
     }


    private int buscarPosicionDisponible (){
        int posDisponible = -1;
        for (int i = 0; i < listaContactos.length; i++) {
            Contacto contacto = listaContactos [i];
            if (contacto == null){
                posDisponible = i;
                return posDisponible;
            }
        }

        return posDisponible;
    }


    

    /**
     * Este metodo elimina un contacto existente mediante el telefono
     * @param nombre
     * @param telefono
     * @return
     */

    public String eliminarContacto( String telefono){
        String mensaje = "Contacto inexistente";

        for (int i = 0; i < listaContactos.length; i++) {
            Contacto contactoAux = listaContactos[i];
            if(contactoAux.getTelefono().equals(telefono)){
                listaContactos [i] = null;
                mensaje = "El contacto se eliminó correctamente";
                return mensaje;
            }
        }
        return mensaje;
    }



    /**
     * Este metodo actualiza la informacion de un contacto existente
     * @param nombre
     * @param alias
     * @param direccion
     * @param telefono
     * @param email
     * @return
     */

    public String actualizarContacto(String nombre,String alias,String direccion, String telefono, String email){

        String mensaje = "Contacto no encontrado";
        Contacto contactoEncontrado = buscarContacto(telefono);
        if(contactoEncontrado != null){
            contactoEncontrado.setNombre(nombre);
            contactoEncontrado.setAlias(alias);
            contactoEncontrado.setDireccion(direccion);
            contactoEncontrado.setTelefono(telefono);
            contactoEncontrado.setEmail(email);
            mensaje = "El contacto se actualizó correctamente";
        }
        return mensaje;
     }




}
