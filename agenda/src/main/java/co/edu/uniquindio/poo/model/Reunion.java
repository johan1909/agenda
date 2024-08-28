package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class Reunion {


    private String descripcion;
    private LocalDate fecha;
    private LocalTime hora;
    private int numeroContactosAsistentes;
    private Contacto [] listaContactosAsistentes;




    public Reunion(String descripcion, LocalDate fecha, LocalTime hora, int numeroContactosAsistentes ){
        this.descripcion=descripcion;
        this.fecha=fecha;
        this.hora=hora;
        this.numeroContactosAsistentes=numeroContactosAsistentes;
        this.listaContactosAsistentes=new Contacto[numeroContactosAsistentes];

    }


    /**
     * 
     * @return the descripcion
     */

    public String getDescripcion() {
        return descripcion;
    }


    /**
     * 
     * @param descripcion the descripcion to set
     */

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * 
     * @return the fecha
     */


    public LocalDate getFecha() {
        return fecha;
    }


    /**
     * 
     * @param fecha the fecha to set
     */

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }


    /**
     * 
     * @return the hora
     */

    public LocalTime getHora() {
        return hora;
    }


    /**
     * 
     * @param hora the hora to set
     */

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }


    /**
     * 
     * @return the numeroContactosAsistentes
     */

    public int getNumeroContactosAsistentes() {
        return numeroContactosAsistentes;
    }


    /**
     * 
     * @param numeroContactosAsistentes the numeroContactosAsistente to set
     */

    public void setNumeroContactosAsistentes(int numeroContactosAsistentes) {
        this.numeroContactosAsistentes = numeroContactosAsistentes;
    }


    /**
     * 
     * @return the istaContactosAsistentes
     */

    public Contacto[] getListaContactosAsistentes() {
        return listaContactosAsistentes;
    }


    /**
     * 
     * @param listaContactosAsistentes the istaContactosAsistentes to set
     */

    public void setListaContactosAsistentes(Contacto[] listaContactosAsistentes) {
        this.listaContactosAsistentes = listaContactosAsistentes;
    }




    @Override
    public String toString() {
        return "Reunion [descripcion=" + descripcion + ", fecha=" + fecha + ", hora=" + hora
                + ", numeroContactosAsistentes=" + numeroContactosAsistentes + ", listaContactosAsistentes="
                + Arrays.toString(listaContactosAsistentes) + "]";
    }


    /**
     * Este metodo registra un nuevo contacto solo si hay cupo y no esta registrado en el grupo
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
                listaContactosAsistentes[posDisponible] = nuevoContacto;
                mensaje = "El contacto se agrego correctamente ";
            }
        }
        return mensaje;
    }


    private Contacto buscarContacto(String telefono) {
        Contacto contactoEncontrado = null;
        for (Contacto contactoAux : listaContactosAsistentes) {
            if(contactoAux.getTelefono().equals(telefono)){
                return contactoAux;
            }
        }
        return contactoEncontrado;
     }


    private int buscarPosicionDisponible (){
        int posDisponible = -1;
        for (int i = 0; i < listaContactosAsistentes.length; i++) {
            Contacto contacto = listaContactosAsistentes [i];
            if (contacto == null){
                posDisponible = i;
                return posDisponible;
            }
        }

        return posDisponible;
    }


    
    /**
     * Este metodo elimina un contacto existente mediante el telefono
     * @param telefono
     * @return
     */

    public String eliminarContacto( String telefono){
        String mensaje = "Contacto inexistente";

        for (int i = 0; i < listaContactosAsistentes.length; i++) {
            Contacto contactoAux = listaContactosAsistentes[i];
            if(contactoAux.getTelefono().equals(telefono)){
                listaContactosAsistentes [i] = null;
                mensaje = "El contacto se eliminó correctamente";
                return mensaje;
            }
        }
        return mensaje;
    }


    


}
