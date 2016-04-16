/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarma;

/**
 *
 * @author AUX_SISTEMAS
 */
public class Tarea {
    private String mensajeTarea;
    private String hora;
    private String repeticion;

    public Tarea() {
    }

    public Tarea(String mensajeTarea, String hora) {
        this.mensajeTarea = mensajeTarea;
        this.hora = hora;
    }

    /**
     * @return the mensajeTarea
     */
    public String getMensajeTarea() {
        return mensajeTarea;
    }

    /**
     * @param mensajeTarea the mensajeTarea to set
     */
    public void setMensajeTarea(String mensajeTarea) {
        this.mensajeTarea = mensajeTarea;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the repeticion
     */
    public String getRepeticion() {
        return repeticion;
    }

    /**
     * @param repeticion the repeticion to set
     */
    public void setRepeticion(String repeticion) {
        this.repeticion = repeticion;
    }
}
