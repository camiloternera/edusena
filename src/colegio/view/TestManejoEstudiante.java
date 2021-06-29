package colegio.view;

import java.util.*;
import colegio.model.Estudiantes;
import colegio.model.EstudiantesDAO;
    

public class TestManejoEstudiante {

    public static void main(String[] args) {

        EstudiantesDAO estudiantesDao = new EstudiantesDAO();

        /**
         * Insertando un nuevo objeto de tipo estudiantes;
         * Osea insertando un nuevo registro en la base de datos.
         */
        Estudiantes estudiantesAdd = new Estudiantes(1193038435, "Camilo Andres", "Ternera Duque", "Rosaira Duque", "Calle 40 #24-86", 3042047, "Informatica");
        estudiantesDao.insertar(estudiantesAdd);

        /**
         * Actualizar un objeto estudiantes ya existente;
         * Osea editar los campos de un registro de la tabla estudiantes.
         */
        Estudiantes estudiantesEdit = new Estudiantes(1193038435, "Carlos Daniel", "Ternera Duque", "Rosaira Duque", "Calle 40 #24-86", 3042047, "Artistica");
        estudiantesDao.actualizar(estudiantesEdit);

        /**
         * Eliminar un objeto estudiantes ya existente;
         * Osea eliminar un registro de la tabla estudiantes.
         */
        Estudiantes estudiantesDelete = new Estudiantes(1193038435);
        estudiantesDao.eliminar(estudiantesDelete);

        /**
         * Listar el objeto tipo estudiantes;
         * Osea ver en pantalla la tabla de la base de datos.
         */
        List<Estudiantes> estudiantes = estudiantesDao.seleccionar();
        estudiantes.forEach(estudiante -> {
            System.out.println("Estudiante = " + estudiante);
        });
    }
}