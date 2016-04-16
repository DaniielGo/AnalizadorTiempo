/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarma;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author AUX_SISTEMAS
 */
public class AnalisadorTareas implements Runnable {

    private LinkedList<Tarea> listaTareas;

    public AnalisadorTareas() {
        this.listaTareas = new LinkedList<>();
        agregarTareas("C:\\Windows\\Orden\\archivo.txt");
    }

    public AnalisadorTareas(LinkedList<Tarea> listaTareas, Date date) {
        this.listaTareas = listaTareas;
        agregarTareas("C:\\Windows\\Orden\\archivo.txt");

    }

    private void agregarTareas(String archivo) {
        try {
            String cadena;
            FileReader f = new FileReader(archivo);
            BufferedReader b = new BufferedReader(f);
            while ((cadena = b.readLine()) != null) {
                Tarea tarea = new Tarea(cadena.split("/")[0], cadena.split("/")[1]);
                this.listaTareas.add(tarea);
            }
            b.close();

        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }
    }

    public String consultarHora() {
        try {
            Date date = new Date();
            DateFormat hourFormat = new SimpleDateFormat("hh:mm a");
            return hourFormat.format(date);
        } catch (Exception e) {
        }
        return "";
    }

    public Boolean consultarTarea(Tarea tarea, String hora) {
        try {
            if (tarea != null && hora != null) {
                if (tarea.getHora().equalsIgnoreCase(hora)) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public void run() {
        while (true) {
            try {
                for (int i = 0; i < this.listaTareas.size(); i++) {
                    if(consultarTarea(this.listaTareas.get(i),consultarHora())){
                        
                        new Mensaje(new javax.swing.JFrame(), true).mostrarMensaje(this.listaTareas.get(i).getMensajeTarea());
                        Thread.sleep(60000);
                    }
                }
                System.out.println(consultarHora());
            } catch (Exception e) {
                System.out.println("error " + e.getMessage());
            }
        }
    }
}
