package logica;

import gui.EditorCRUD;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import objetos.Ciclo;
import objetos.Curso;
import objetos.Especialidad;
import objetos.FamiliaProfesional;
import objetos.Modulo;
import objetos.ModuloCurso;
import objetos.Profesor;


public class LogicaTablas {

    //lista de modelos y lista de tablas
    private static ArrayList<DefaultTableModel> listaModelos;
    private static ArrayList<JTable> listaTablas;

    //crea las listas
    public static void crearListaTablas(EditorCRUD app) {
        listaTablas = new ArrayList();
        listaTablas.add(app.getTablaTurnos());
        listaTablas.add(app.getTablaCursos());
        listaTablas.add(app.getTablaCiclos());
        listaTablas.add(app.getTablaFamiliasProfesionales());
        listaTablas.add(app.getTablaModulos());
        listaTablas.add(app.getTablaEspecialidades());
        listaTablas.add(app.getTablaProfesores());
        listaTablas.add(app.getTablaModulosCursos());

    }

    //actualizacion
    public static void actualizarTablasBaseDeDatos() throws SQLException {

        //SE BORRAN LAS TABLAS
        for (DefaultTableModel dtm : listaModelos) {
            dtm.setRowCount(0);
        }

        //TABLA TURNOS
        for (objetos.Turno turno : crud.TurnosCRUD.leerTodos()) {
            listaModelos.get(0).addRow(turno.toArrayStrings());
        }

        //TABLA CURSOS
        for (objetos.Curso curso : crud.CursosCRUD.leerTodos()) {
            listaModelos.get(1).addRow(curso.toArrayStrings());
        }

        //TABLA CICLOS
        for (objetos.Ciclo ciclo : crud.CiclosCRUD.leerTodos()) {
            listaModelos.get(2).addRow(ciclo.toArrayStrings());
        }

        //TABLA FAMILIAS PROFESIONALES
        for (objetos.FamiliaProfesional familia : crud.FamiliasProfesionalesCRUD.leerTodos()) {
            listaModelos.get(3).addRow(familia.toArrayStrings());
        }

        //TABLA MODULOS
        for (objetos.Modulo modulo : crud.ModulosCRUD.leerTodos()) {
            listaModelos.get(4).addRow(modulo.toArrayStrings());
        }

        //TABLA ESPECIALIDADES
        for (objetos.Especialidad especialidad : crud.EspecialidadesCRUD.leerTodos()) {
            listaModelos.get(5).addRow(especialidad.toArrayStrings());
        }

        //TABLA PROFESORES
        for (objetos.Profesor profesor : crud.ProfesoresCRUD.leerTodos()) {
            listaModelos.get(6).addRow(profesor.toArrayStrings());
        }

        //TABLA MODULOS-CURSOS
        for (objetos.ModuloCurso moduloCurso : crud.ModulosCursosCRUD.leerTodos()) {
            listaModelos.get(7).addRow(moduloCurso.toArrayStrings());
        }
/*
        //TABLA MODULOS-PROFESORES
        for (objetos.Asignacion asignacion : crud.AsignacionesCRUD.leerTodos()) {
            listaModelos.get(8).addRow(asignacion.toArrayStrings());
        }
*/
    }
    
    static gui.EditorCRUD app;

    public static void prepararActualizacionesDeTablas(gui.EditorCRUD app) {

        listaModelos = new ArrayList();
        LogicaTablas.app = app;

        listaModelos.add((DefaultTableModel) app.getTablaTurnos().getModel());
        listaModelos.add((DefaultTableModel) app.getTablaCursos().getModel());
        listaModelos.add((DefaultTableModel) app.getTablaCiclos().getModel());
        listaModelos.add((DefaultTableModel) app.getTablaFamiliasProfesionales().getModel());
        listaModelos.add((DefaultTableModel) app.getTablaModulos().getModel());
        listaModelos.add((DefaultTableModel) app.getTablaEspecialidades().getModel());
        listaModelos.add((DefaultTableModel) app.getTablaProfesores().getModel());
        listaModelos.add((DefaultTableModel) app.getTablaModulosCursos().getModel());

    }

    public static void switchCrearRegistro(JTabbedPane panel) throws SQLException {

        switch (panel.getSelectedIndex()) {
            case 0:
                System.out.println("Turnos");
                new gui.dialogosCRUD.creacion.crearTurno(null, true).setVisible(true);
                break;
            case 1:
                System.out.println("Cursos");
                new gui.dialogosCRUD.creacion.crearCurso(null, true).setVisible(true);
                break;
            case 2:
                System.out.println("Ciclos");
                new gui.dialogosCRUD.creacion.crearCiclo(null, true).setVisible(true);
                break;
            case 3:
                System.out.println("Familias profesionales");
                new gui.dialogosCRUD.creacion.crearFamiliaProfesional(null, true).setVisible(true);
                break;
            case 4:
                System.out.println("Módulos");
                new gui.dialogosCRUD.creacion.crearModulo(null, true).setVisible(true);
                break;
            case 5:
                System.out.println("Especialidades");
                new gui.dialogosCRUD.creacion.crearEspecialidad(null, true).setVisible(true);
                break;
            case 6:
                System.out.println("Profesores");
                new gui.dialogosCRUD.creacion.crearProfesor(null, true).setVisible(true);
                break;
            case 7:
                System.out.println("Módulos-Cursos");
                new gui.dialogosCRUD.creacion.crearModuloCurso(null, true).setVisible(true);
                break;
        }

    }

    public static void switchActualizarRegistro(JTabbedPane panel) throws SQLException {

        boolean resultado = false;
        
        switch (panel.getSelectedIndex()) {
            case 0:
                System.out.println("Act. Turnos");
                break;
            case 1:
                System.out.println("Act. Cursos");
                new gui.dialogosCRUD.edicion.editarCurso(null, true, new Curso(listaModelos.get(1).getValueAt(app.getTablaCursos().getSelectedRow(), 0).toString(), Integer.parseInt(listaModelos.get(1).getValueAt(app.getTablaCursos().getSelectedRow(), 1).toString()), Integer.parseInt(listaModelos.get(1).getValueAt(app.getTablaCursos().getSelectedRow(), 2).toString()), Integer.parseInt(listaModelos.get(1).getValueAt(app.getTablaCursos().getSelectedRow(), 3).toString()))).setVisible(true);
                break;
            case 2:
                System.out.println("Act. Ciclos");
                new gui.dialogosCRUD.edicion.editarCiclo(null, true, new Ciclo(Integer.parseInt(listaModelos.get(2).getValueAt(app.getTablaCiclos().getSelectedRow(), 0).toString()), listaModelos.get(2).getValueAt(app.getTablaCiclos().getSelectedRow(), 1).toString(), Integer.parseInt(listaModelos.get(2).getValueAt(app.getTablaCiclos().getSelectedRow(), 2).toString()), listaModelos.get(2).getValueAt(app.getTablaCiclos().getSelectedRow(), 3).toString())).setVisible(true);
                break;
            case 3:
                System.out.println("Act. Familias profesionales");
                System.out.println(Integer.parseInt(listaModelos.get(3).getValueAt(app.getTablaFamiliasProfesionales().getSelectedRow(), 0).toString()));
                new gui.dialogosCRUD.edicion.editarFamiliaProfesional(null, true, new FamiliaProfesional(Integer.parseInt(listaModelos.get(3).getValueAt(app.getTablaFamiliasProfesionales().getSelectedRow(), 0).toString()), listaModelos.get(3).getValueAt(app.getTablaFamiliasProfesionales().getSelectedRow(), 1).toString())).setVisible(true);
                
                break;
            case 4:
                System.out.println("Act. Módulos");
                Modulo mod = new Modulo();
                mod.setCodigo(listaModelos.get(4).getValueAt(app.getTablaModulos().getSelectedRow(), 0).toString());
                mod.setDescripcion(listaModelos.get(4).getValueAt(app.getTablaModulos().getSelectedRow(), 1).toString());
                mod.setHorasReales(Integer.parseInt(listaModelos.get(4).getValueAt(app.getTablaModulos().getSelectedRow(), 2).toString()));
                mod.setHorasPonderadas(Integer.parseInt(listaModelos.get(4).getValueAt(app.getTablaModulos().getSelectedRow(), 3).toString()));
                mod.setIdEspecialidad(Integer.parseInt(listaModelos.get(4).getValueAt(app.getTablaModulos().getSelectedRow(), 4).toString()));
                System.out.println(mod.getIdEspecialidad());
                new gui.dialogosCRUD.edicion.editarModulo(null, true, mod).setVisible(true);
                break;
            case 5:
                System.out.println("Act. Especialidades");
                new gui.dialogosCRUD.edicion.editarEspecialidad(
                        null,
                        true,
                        new Especialidad(
                                Integer.parseInt(listaModelos.get(5).getValueAt(app.getTablaEspecialidades().getSelectedRow(), 0).toString()),
                                listaModelos.get(5).getValueAt(app.getTablaEspecialidades().getSelectedRow(), 1).toString())).setVisible(true);
                
                break;
            case 6:
                System.out.println("Act. Profesores");
                Profesor prof = new Profesor();
                
                System.out.println(prof.toString());
                prof.setIdProfesor(Integer.parseInt(listaModelos.get(6).getValueAt(app.getTablaProfesores().getSelectedRow(), 0).toString()));
                System.out.println(prof.toString());
                prof.setNombre(listaModelos.get(6).getValueAt(app.getTablaProfesores().getSelectedRow(), 1).toString());
                prof.setApellido(listaModelos.get(6).getValueAt(app.getTablaProfesores().getSelectedRow(), 2).toString());
                prof.setNumeroOrden(Integer.parseInt(listaModelos.get(6).getValueAt(app.getTablaProfesores().getSelectedRow(), 3).toString()));
                prof.setIdEspecialidad(Integer.parseInt(listaModelos.get(6).getValueAt(app.getTablaProfesores().getSelectedRow(), 4).toString()));
                prof.setHorasContratadas(Integer.parseInt(listaModelos.get(6).getValueAt(app.getTablaProfesores().getSelectedRow(), 5).toString()));
                System.out.println(prof.getIdEspecialidad());
                new gui.dialogosCRUD.edicion.editarProfesor(null, true, prof).setVisible(true);
                break;
            case 7:
                System.out.println("Act. Módulos-Cursos");
                ModuloCurso modcur = new ModuloCurso();
                modcur.setIdModuloCurso(Integer.parseInt(listaModelos.get(7).getValueAt(app.getTablaModulosCursos().getSelectedRow(), 0).toString()));
                modcur.setCodigoModulo(listaModelos.get(7).getValueAt(app.getTablaModulosCursos().getSelectedRow(), 1).toString());
                modcur.setCodigoCurso(listaModelos.get(7).getValueAt(app.getTablaModulosCursos().getSelectedRow(), 2).toString());
                new gui.dialogosCRUD.edicion.editarModuloCurso(null, true, modcur).setVisible(true);
                break;
        }

    }

    public static boolean switchEliminarRegistro(JTabbedPane panel) throws SQLException {
        boolean resultado = false;
        try {
            switch (panel.getSelectedIndex()) {
                case 0 -> resultado = crud.TurnosCRUD.eliminar(listaModelos.get(0).getValueAt(listaTablas.get(0).getSelectedRow(), 0).toString());
                case 1 -> resultado = crud.CursosCRUD.eliminar(listaModelos.get(1).getValueAt(listaTablas.get(1).getSelectedRow(), 0).toString());
                case 2 -> resultado = crud.CiclosCRUD.eliminar(listaModelos.get(2).getValueAt(listaTablas.get(2).getSelectedRow(), 0).toString());
                case 3 -> resultado = crud.FamiliasProfesionalesCRUD.eliminar(listaModelos.get(3).getValueAt(listaTablas.get(3).getSelectedRow(), 0).toString());
                case 4 -> resultado = crud.ModulosCRUD.eliminar(listaModelos.get(4).getValueAt(listaTablas.get(4).getSelectedRow(), 0).toString());
                case 5 -> resultado = crud.EspecialidadesCRUD.eliminar(listaModelos.get(5).getValueAt(listaTablas.get(5).getSelectedRow(), 0).toString());
                case 6 -> resultado = crud.ProfesoresCRUD.eliminar(listaModelos.get(6).getValueAt(listaTablas.get(6).getSelectedRow(), 0).toString());
                case 7 -> resultado = crud.ModulosCursosCRUD.eliminar(listaModelos.get(7).getValueAt(listaTablas.get(7).getSelectedRow(), 0).toString());
            }
            actualizarTablasBaseDeDatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return resultado;
    }

    public static ArrayList<DefaultTableModel> getListaModelos() {
        return listaModelos;
    }

    public static ArrayList<JTable> getListaTablas() {
        return listaTablas;
    }

}
