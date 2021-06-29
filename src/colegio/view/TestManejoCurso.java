package colegio.view;

import java.util.*;
import colegio.model.Cursos;
import colegio.model.CursosDAO;
    
public class TestManejoCurso {

    public static void main(String[] args) {

        CursosDAO cursosDao = new CursosDAO();

        /**
         * Insertando un nuevo objeto de tipo cursos;
         * Osea insertando un nuevo registro en la base de datos.
         */
        Cursos cursosAdd = new Cursos("Informatica", 40, 5, 3);
        cursosDao.insertar(cursosAdd);

        /**
         * Actualizar un objeto cursos ya existente;
         * Osea editar los campos de un registro de la tabla cursos.
         */
        Cursos cursosEdit = new Cursos("Artistica", 40, 5, 3);
        cursosDao.actualizar(cursosEdit);

        /**
         * Eliminar un objeto cursos ya existente;
         * Osea eliminar un registro de la tabla cursos.
         */
        Cursos cursosDelete = new Cursos(1);
        cursosDao.eliminar(cursosDelete);

        /**
         * Listar el objeto tipo cursos;
         * Osea ver en pantalla la tabla de la base de datos.
         */
        List<Cursos> cursos = cursosDao.seleccionar();
        cursos.forEach(curso -> {
            System.out.println("Curso = " + curso);
        });
    }
}