package colegio.view;

import java.util.*;
import colegio.model.Profesores;
import colegio.model.ProfesoresDAO;
    

public class TestManejoProfesor {

    public static void main(String[] args) {

        ProfesoresDAO profesoresDao = new ProfesoresDAO();

        /**
         * Insertando un nuevo objeto de tipo profesores;
         * Osea insertando un nuevo registro en la base de datos.
         */
        Profesores profesoresAdd = new Profesores(1193038435, "Camilo Andres", "Ternera Duque", "Masculino", 3042047, "Calle 40 #24-86", "Informatica");
        profesoresDao.insertar(profesoresAdd);

        /**
         * Actualizar un objeto profesores ya existente;
         * Osea editar los campos de un registro de la tabla profesores.
         */
        Profesores profesoresEdit = new Profesores(1193038435, "Carlos Daniel", "Ternera Duque", "Masculino", 3042047, "Calle 40 #24-86",  "Artistica");
        profesoresDao.actualizar(profesoresEdit);

        /**
         * Eliminar un objeto profesores ya existente;
         * Osea eliminar un registro de la tabla profesores.
         */
        Profesores profesoresDelete = new Profesores(1193038435);
        profesoresDao.eliminar(profesoresDelete);

        /**
         * Listar el objeto tipo profesores;
         * Osea ver en pantalla la tabla de la base de datos.
         */
        List<Profesores> profesores = profesoresDao.seleccionar();
        profesores.forEach(profesor -> {
            System.out.println("Profesores = " + profesor);
        });
    }
}