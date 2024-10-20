package sql;


public class Sentencias {

    //SENTENCIAS SQL DE CICLOS
    private static final String INSERTAR_CICLO = "INSERT INTO ciclos (nombre, idfamiliaprofesional, tipo) values (?, ?, ?)";
    private static final String SELECCIONAR_CICLO = "SELECT * FROM ciclos WHERE idciclo = ?";
    private static final String SELECCIONAR_CICLOS = "SELECT * FROM ciclos";
    private static final String ACTUALIZAR_CICLO = "UPDATE ciclos SET nombre = ?, idfamiliaprofesional = ?, tipo = ? WHERE idciclo = ?";
    private static final String BORRAR_CICLO = "DELETE FROM ciclos WHERE idciclo = ?";
    private static final String BUSCAR_PK_REPETIDA_CICLO = "SELECT idciclo FROM ciclos WHERE idciclo = ?";
    private static final String CONTAR_CICLOS = "SELECT COUNT(idciclo) FROM ciclos";
    private static final String CONTAR_G_MEDIOS = "SELECT COUNT(idciclo) FROM ciclos WHERE tipo = \"Grado medio\"";
    private static final String CONTAR_G_SUPERIORES = "SELECT COUNT(idciclo) FROM ciclos WHERE tipo = \"Grado superior\"";
    private static final String CONTAR_C_ESPECIALIZACION = "SELECT COUNT(idciclo) FROM ciclos WHERE tipo = \"Curso de especialización\"";
    private static final String CICLOS_CONCATENADOS = "SELECT CONCAT(idciclo, '. ', nombre) as ciclo FROM ciclos";

    //SENTENCIAS SQL DE CURSOS
    private static final String INSERTAR_CURSO = "INSERT INTO cursos (codigo, idturno, idciclo, nivel) values (?, ?, ?, ?)";
    private static final String SELECCIONAR_CURSO = "SELECT * FROM cursos WHERE codigo = ?";
    private static final String SELECCIONAR_CURSOS = "SELECT * FROM cursos";
    private static final String ACTUALIZAR_CURSO = "UPDATE cursos SET codigo = ?, idturno = ?, idciclo = ?, nivel = ? WHERE codigo = ?";
    private static final String BORRAR_CURSO = "DELETE FROM cursos WHERE codigo = ?";
    private static final String BUSCAR_PK_REPETIDA_CURSO = "SELECT codigo FROM cursos WHERE codigo = ?";
    private static final String CONTAR_CURSOS = "SELECT COUNT(codigo) FROM cursos";

    //SENTENCIAS SQL DE ESPECIALIDADES
    private static final String INSERTAR_ESPECIALIDAD = "INSERT INTO especialidades (descripcion) values (?)";
    private static final String SELECCIONAR_ESPECIALIDAD = "SELECT * FROM especialidades WHERE idespecialidad = ?";
    private static final String SELECCIONAR_ESPECIALIDADES = "SELECT * FROM especialidades";
    private static final String ACTUALIZAR_ESPECIALIDAD = "UPDATE especialidades SET descripcion = ? WHERE idespecialidad = ?";
    private static final String BORRAR_ESPECIALIDAD = "DELETE FROM especialidades WHERE idespecialidad = ?";
    private static final String BUSCAR_PK_REPETIDA_ESPECIALIDAD = "SELECT idespecialidad FROM especialidades WHERE idespecialidad = ?";
    private static final String ESPECIALIDADES_CONCATENADAS = "SELECT CONCAT(idespecialidad, '. ', descripcion) as espes FROM especialidades";

    //SENTENCIAS SQL DE FAMILIAS PROFESIONALES
    private static final String INSERTAR_FAMILIA_PROFESIONAL = "INSERT INTO familiasprofesionales (descripcion) values (?)";
    private static final String SELECCIONAR_FAMILIA_PROFESIONAL = "SELECT * FROM familiasprofesionales WHERE idfamiliaprofesional = ?";
    private static final String SELECCIONAR_FAMILIAS_PROFESIONALES = "SELECT * FROM familiasprofesionales";
    private static final String ACTUALIZAR_FAMILIA_PROFESIONAL = "UPDATE familiasprofesionales SET descripcion = ? WHERE idfamiliaprofesional = ?";
    private static final String BORRAR_FAMILIA_PROFESIONAL = "DELETE FROM familiasprofesionales WHERE idfamiliaprofesional = ?";
    private static final String BUSCAR_PK_REPETIDA_FAMILIA_PROFESIONAL = "SELECT idfamiliaprofesional FROM familiasprofesionales WHERE idfamiliaprofesional = ?";
    private static final String FAMILIAS_CONCATENADAS = "SELECT CONCAT(idfamiliaprofesional, '. ', descripcion) as familia FROM familiasprofesionales";

    //SENTENCIAS SQL DE MODULOS
    private static final String INSERTAR_MODULO = "INSERT INTO modulos (codigo, descripcion, horasreales, horasponderadas, idespecialidad) values (?, ?, ?, ?, ?)";
    private static final String SELECCIONAR_MODULO = "SELECT * FROM modulos WHERE codigo = ?";
    private static final String SELECCIONAR_MODULOS = "SELECT * FROM modulos";
    private static final String ACTUALIZAR_MODULO = "UPDATE modulos SET codigo = ?, descripcion = ?, horasreales = ?, horasponderadas = ?, idespecialidad = ? WHERE codigo = ?";
    private static final String BORRAR_MODULO = "DELETE FROM modulos WHERE codigo = ?";
    private static final String BUSCAR_PK_REPETIDA_MODULO = "SELECT codigo FROM modulos WHERE codigo = ?";
    private static final String CONTAR_MODULOS = "SELECT COUNT(codigo) FROM modulos";

    //SENTENCIAS SQL DE MODULO-CURSO
    private static final String INSERTAR_MODULOCURSO = "INSERT INTO modulos_cursos (codigomodulo, codigocurso) values (?, ?)";
    private static final String SELECCIONAR_MODULOCURSO = "SELECT * FROM modulos_cursos WHERE idmodulo_curso = ?";
    private static final String SELECCIONAR_MODULOSCURSOS = "SELECT * FROM modulos_cursos";
    private static final String ACTUALIZAR_MODULOCURSO = "UPDATE modulos_cursos SET idmodulo_curso = ?, codigomodulo = ?, codigocurso = ? WHERE idmodulo_curso = ?";
    private static final String BORRAR_MODULOCURSO = "DELETE FROM modulos_cursos WHERE idmodulo_curso = ?";
    private static final String BUSCAR_PK_REPETIDA_MODULOCURSO = "SELECT idmodulo_curso FROM modulos_cursos WHERE idmodulo_curso = ?";

    //SENTENCIAS SQL DE PROFESORES
    private static final String INSERTAR_PROFESOR = "INSERT INTO profesores (nombre, apellido, numerodeorden, idespecialidad, horascontratadas) values (?, ?, ?, ?, ?)";
    private static final String SELECCIONAR_PROFESOR = "SELECT * FROM profesores WHERE idprofesor = ?";
    private static final String SELECCIONAR_PROFESORES = "SELECT * FROM profesores";
    private static final String ACTUALIZAR_PROFESOR = "UPDATE profesores SET nombre = ?, apellido = ?, numerodeorden = ?, idespecialidad = ?, horascontratadas = ? WHERE idprofesor = ?";
    private static final String BORRAR_PROFESOR = "DELETE FROM profesores WHERE idprofesor = ?";
    private static final String BUSCAR_PK_REPETIDA_PROFESOR = "SELECT idprofesor FROM profesores WHERE idprofesor = ?";
    private static final String CONTAR_PROFESORES = "SELECT COUNT(idprofesor) FROM profesores";
    private static final String SIGUIENTE_NUMERO_ORDEN = "SELECT numerodeorden FROM profesores ORDER BY numerodeorden DESC LIMIT 1";

    //SENTENCIAS SQL DE AISGNACIONES
    private static final String INSERTAR_ASIGNACION = "INSERT INTO asignaciones (idprofesor, id_modulocurso) values (?, ?)";
    private static final String SELECCIONAR_PROFESORMODULO = "SELECT * FROM profesores_modulos WHERE idprofesores_modulos = ?";
    private static final String SELECCIONAR_PROFESORESMODULOS = "SELECT * FROM profesores_modulos";
    private static final String ACTUALIZAR_PROFESORMODULO = "UPDATE profesores_modulos SET idprofesores_modulos = ?, idprofesor = ?, codigomodulo = ? WHERE idprofesores_modulos = ?";
    private static final String BORRAR_PROFESORMODULO = "DELETE FROM profesores_modulos WHERE idprofesores_modulos = ?";
    private static final String BORRAR_ASIGNACIONES = "DELETE FROM asignaciones WHERE idprofesor = ?";
    private static final String BUSCAR_PK_REPETIDA_PROFESORMODULO = "SELECT idprofesores_modulos FROM profesores_modulos WHERE idprofesores_modulos = ?";

    //SENTENCIAS SQL DE TURNOS
    private static final String INSERTAR_TURNO = "INSERT INTO turnos (descripcion) values (?)";
    private static final String SELECCIONAR_TURNO = "SELECT * FROM turnos WHERE idturno = ?";
    private static final String SELECCIONAR_TURNOS = "SELECT * FROM turnos";
    private static final String ACTUALIZAR_TURNO = "UPDATE turnos SET idturno = ?, descripcion = ? WHERE idturno = ?";
    private static final String BORRAR_TURNO = "DELETE FROM turnos WHERE idturno = ?";
    private static final String BUSCAR_PK_REPETIDA_TURNO = "SELECT idturno FROM turnos WHERE idturno = ?";

    public static String getINSERTAR_ASIGNACION() {
        return INSERTAR_ASIGNACION;
    }

    
    
    //SENTENCIAS SQL ESPECIALES
    private static final String ORDENAR_PROFESORES = "SELECT p.nombre, p.apellido, "
            + "e.descripcion, p.horascontratadas, p.numerodeorden, p.idprofesor FROM `profesores` "
            + "AS p INNER JOIN especialidades as e ON p.idespecialidad = e.idespecialidad "
            + "LEFT JOIN asignaciones AS a ON a.idprofesor = p.idprofesor "
            + "WHERE a.idprofesor IS NULL ORDER BY numerodeorden ASC LIMIT 1";

    private static final String CONSEGUIR_MODULOS_ESPECIALIDAD = "SELECT "
            + "mo.codigo, "
            + "mo.descripcion, "
            + "mo.horasreales, "
            + "mo.horasponderadas "
            + "FROM modulos AS mo "
            + "JOIN especialidades AS es ON mo.idespecialidad = es.idespecialidad "
            + "WHERE es.descripcion = ?";

    private static final String CALCULAR_PORCENTAJE_PROFESORES_ASIGNADOS = "SELECT COUNT(DISTINCT profesores.idprofesor) as total_profesores,"
            + " COUNT(DISTINCT asignaciones.idprofesor) as profesores_asignados,"
            + " (COUNT(DISTINCT asignaciones.idprofesor) / COUNT(DISTINCT profesores.idprofesor)) * 100 as porcentaje"
            + " FROM profesores"
            + " LEFT JOIN asignaciones ON profesores.idprofesor = asignaciones.idprofesor";

    private static final String CALCULAR_PORCENTAJE_MODULOS_ASIGNADOS = "SELECT (COUNT(DISTINCT asignaciones.id_asignacion) / COUNT(DISTINCT modulos_cursos.idmodulo_curso)) * 100 as porcentaje "
            + "FROM modulos_cursos "
            + "LEFT JOIN asignaciones ON modulos_cursos.idmodulo_curso = asignaciones.id_modulocurso";

    private static final String CALCULAR_HORAS_TOTALES = "SELECT SUM(modulos.horasreales) FROM modulos "
            + "JOIN modulos_cursos ON modulos.codigo = modulos_cursos.codigomodulo "
            + "JOIN asignaciones ON modulos_cursos.idmodulo_curso = asignaciones.id_modulocurso";

    private static final String CALCULAR_MEDIA_HORAS = "SELECT SUM(modulos.horasreales) / COUNT(DISTINCT asignaciones.idprofesor) "
            + "FROM asignaciones\n"
            + "JOIN profesores ON asignaciones.idprofesor = profesores.idprofesor\n"
            + "JOIN modulos_cursos ON asignaciones.id_modulocurso = modulos_cursos.idmodulo_curso\n"
            + "JOIN modulos ON modulos_cursos.codigomodulo = modulos.codigo;";

    private static final String PROFESORES_ASIGNADOS = "SELECT DISTINCT profesores.nombre, profesores.apellido\n"
            + "FROM asignaciones\n"
            + "JOIN profesores ON asignaciones.idprofesor = profesores.idprofesor";

    private static final String CONSEGUIR_ASIGNACIONES_POR_PROFESOR
            = """
              SELECT modulos.codigo, modulos.descripcion, modulos.horasreales, 
              modulos.horasponderadas, modulos_cursos.codigocurso, cursos.nivel, 
              turnos.descripcion, ciclos.nombre, ciclos.tipo, especialidades.descripcion, 
              profesores.horascontratadas
              FROM profesores
              JOIN especialidades ON especialidades.idespecialidad = profesores.idespecialidad
              JOIN asignaciones ON profesores.idprofesor = asignaciones.idprofesor
              JOIN modulos_cursos ON asignaciones.id_modulocurso = modulos_cursos.idmodulo_curso
              JOIN modulos ON modulos_cursos.codigomodulo = modulos.codigo
              JOIN cursos ON cursos.codigo = modulos_cursos.codigocurso
              JOIN turnos ON turnos.idturno = cursos.idturno
              JOIN ciclos ON ciclos.idciclo = cursos.idciclo
              WHERE profesores.idprofesor = ?""";
    
    private static final String CONTAR_ASIGNACIONES_PROFESOR = 
            "SELECT COUNT(asignaciones.idprofesor) "
            + "FROM asignaciones JOIN profesores "
            + "ON asignaciones.idprofesor = profesores.idprofesor "
            + "WHERE asignaciones.idprofesor = ?";
    
    
    private static final String VER_ASIGNACIONES_DISPONIBLES_POR_PROFESOR =
            """
            SELECT modulos_cursos.idmodulo_curso, modulos_cursos.codigomodulo, cursos.codigo, modulos.descripcion, modulos.horasreales, modulos.horasponderadas, turnos.idturno, ciclos.nombre, ciclos.tipo, cursos.nivel
            FROM modulos_cursos
            LEFT JOIN asignaciones ON modulos_cursos.idmodulo_curso = asignaciones.id_modulocurso
            JOIN modulos ON modulos_cursos.codigomodulo = modulos.codigo
            JOIN especialidades ON modulos.idespecialidad = especialidades.idespecialidad
            JOIN cursos ON modulos_cursos.codigocurso = cursos.codigo
            JOIN turnos ON cursos.idturno = turnos.idturno
            JOIN ciclos ON cursos.idciclo = ciclos.idciclo
            WHERE asignaciones.id_modulocurso IS NULL AND especialidades.descripcion = ?""";

    public static String getVER_ASIGNACIONES_DISPONIBLES_POR_PROFESOR() {
        return VER_ASIGNACIONES_DISPONIBLES_POR_PROFESOR;
    }    

    public static String getCONTAR_ASIGNACIONES_PROFESOR() {
        return CONTAR_ASIGNACIONES_PROFESOR;
    } 

    public static String getFAMILIAS_CONCATENADAS() {
        return FAMILIAS_CONCATENADAS;
    }

    public static String getESPECIALIDADES_CONCATENADAS() {
        return ESPECIALIDADES_CONCATENADAS;
    }

    public static String getSIGUIENTE_NUMERO_ORDEN() {
        return SIGUIENTE_NUMERO_ORDEN;
    }

    public static String getBORRAR_ASIGNACIONES() {
        return BORRAR_ASIGNACIONES;
    }
    
    public static String getCICLOS_CONCATENADOS() {
        return CICLOS_CONCATENADOS;
    }

    public static String getPROFESORES_ASIGNADOS() {
        return PROFESORES_ASIGNADOS;
    }

    public static String getCONSEGUIR_ASIGNACIONES_POR_PROFESOR() {
        return CONSEGUIR_ASIGNACIONES_POR_PROFESOR;
    }
    
    public static String getCALCULAR_MEDIA_HORAS() {
        return CALCULAR_MEDIA_HORAS;
    }

    public static String getCONTAR_CICLOS() {
        return CONTAR_CICLOS;
    }

    public static String getCONTAR_G_MEDIOS() {
        return CONTAR_G_MEDIOS;
    }

    public static String getCONTAR_G_SUPERIORES() {
        return CONTAR_G_SUPERIORES;
    }

    public static String getCONTAR_C_ESPECIALIZACION() {
        return CONTAR_C_ESPECIALIZACION;
    }

    public static String getCONTAR_CURSOS() {
        return CONTAR_CURSOS;
    }

    public static String getCONTAR_MODULOS() {
        return CONTAR_MODULOS;
    }

    public static String getCONTAR_PROFESORES() {
        return CONTAR_PROFESORES;
    }

    public static String getCALCULAR_HORAS_TOTALES() {
        return CALCULAR_HORAS_TOTALES;
    }

    public static String getCALCULAR_PORCENTAJE_MODULOS_ASIGNADOS() {
        return CALCULAR_PORCENTAJE_MODULOS_ASIGNADOS;
    }

    public static String getCALCULAR_PORCENTAJE_PROFESORES_ASIGNADOS() {
        return CALCULAR_PORCENTAJE_PROFESORES_ASIGNADOS;
    }

    public static String getCONSEGUIR_MODULOS_ESPECIALIDAD() {
        return CONSEGUIR_MODULOS_ESPECIALIDAD;
    }

    public static String getORDENAR_PROFESORES() {
        return ORDENAR_PROFESORES;
    }

    public static String getINSERTAR_CICLO() {
        return INSERTAR_CICLO;
    }

    public static String getSELECCIONAR_CICLO() {
        return SELECCIONAR_CICLO;
    }

    public static String getSELECCIONAR_CICLOS() {
        return SELECCIONAR_CICLOS;
    }

    public static String getACTUALIZAR_CICLO() {
        return ACTUALIZAR_CICLO;
    }

    public static String getBORRAR_CICLO() {
        return BORRAR_CICLO;
    }

    public static String getBUSCAR_PK_REPETIDA_CICLO() {
        return BUSCAR_PK_REPETIDA_CICLO;
    }

    public static String getINSERTAR_CURSO() {
        return INSERTAR_CURSO;
    }

    public static String getSELECCIONAR_CURSO() {
        return SELECCIONAR_CURSO;
    }

    public static String getSELECCIONAR_CURSOS() {
        return SELECCIONAR_CURSOS;
    }

    public static String getACTUALIZAR_CURSO() {
        return ACTUALIZAR_CURSO;
    }

    public static String getBORRAR_CURSO() {
        return BORRAR_CURSO;
    }

    public static String getBUSCAR_PK_REPETIDA_CURSO() {
        return BUSCAR_PK_REPETIDA_CURSO;
    }

    public static String getINSERTAR_ESPECIALIDAD() {
        return INSERTAR_ESPECIALIDAD;
    }

    public static String getSELECCIONAR_ESPECIALIDAD() {
        return SELECCIONAR_ESPECIALIDAD;
    }

    public static String getSELECCIONAR_ESPECIALIDADES() {
        return SELECCIONAR_ESPECIALIDADES;
    }

    public static String getACTUALIZAR_ESPECIALIDAD() {
        return ACTUALIZAR_ESPECIALIDAD;
    }

    public static String getBORRAR_ESPECIALIDAD() {
        return BORRAR_ESPECIALIDAD;
    }

    public static String getBUSCAR_PK_REPETIDA_ESPECIALIDAD() {
        return BUSCAR_PK_REPETIDA_ESPECIALIDAD;
    }

    public static String getINSERTAR_FAMILIA_PROFESIONAL() {
        return INSERTAR_FAMILIA_PROFESIONAL;
    }

    public static String getSELECCIONAR_FAMILIA_PROFESIONAL() {
        return SELECCIONAR_FAMILIA_PROFESIONAL;
    }

    public static String getSELECCIONAR_FAMILIAS_PROFESIONALES() {
        return SELECCIONAR_FAMILIAS_PROFESIONALES;
    }

    public static String getACTUALIZAR_FAMILIA_PROFESIONAL() {
        return ACTUALIZAR_FAMILIA_PROFESIONAL;
    }

    public static String getBORRAR_FAMILIA_PROFESIONAL() {
        return BORRAR_FAMILIA_PROFESIONAL;
    }

    public static String getBUSCAR_PK_REPETIDA_FAMILIA_PROFESIONAL() {
        return BUSCAR_PK_REPETIDA_FAMILIA_PROFESIONAL;
    }

    public static String getINSERTAR_MODULO() {
        return INSERTAR_MODULO;
    }

    public static String getSELECCIONAR_MODULO() {
        return SELECCIONAR_MODULO;
    }

    public static String getSELECCIONAR_MODULOS() {
        return SELECCIONAR_MODULOS;
    }

    public static String getACTUALIZAR_MODULO() {
        return ACTUALIZAR_MODULO;
    }

    public static String getBORRAR_MODULO() {
        return BORRAR_MODULO;
    }

    public static String getBUSCAR_PK_REPETIDA_MODULO() {
        return BUSCAR_PK_REPETIDA_MODULO;
    }

    public static String getINSERTAR_MODULOCURSO() {
        return INSERTAR_MODULOCURSO;
    }

    public static String getSELECCIONAR_MODULOCURSO() {
        return SELECCIONAR_MODULOCURSO;
    }

    public static String getSELECCIONAR_MODULOSCURSOS() {
        return SELECCIONAR_MODULOSCURSOS;
    }

    public static String getACTUALIZAR_MODULOCURSO() {
        return ACTUALIZAR_MODULOCURSO;
    }

    public static String getBORRAR_MODULOCURSO() {
        return BORRAR_MODULOCURSO;
    }

    public static String getBUSCAR_PK_REPETIDA_MODULOCURSO() {
        return BUSCAR_PK_REPETIDA_MODULOCURSO;
    }

    public static String getINSERTAR_PROFESOR() {
        return INSERTAR_PROFESOR;
    }

    public static String getSELECCIONAR_PROFESOR() {
        return SELECCIONAR_PROFESOR;
    }

    public static String getSELECCIONAR_PROFESORES() {
        return SELECCIONAR_PROFESORES;
    }

    public static String getACTUALIZAR_PROFESOR() {
        return ACTUALIZAR_PROFESOR;
    }

    public static String getBORRAR_PROFESOR() {
        return BORRAR_PROFESOR;
    }

    public static String getBUSCAR_PK_REPETIDA_PROFESOR() {
        return BUSCAR_PK_REPETIDA_PROFESOR;
    }

    public static String getINSERTAR_PROFESORMODULO() {
        return INSERTAR_ASIGNACION;
    }

    public static String getSELECCIONAR_PROFESORMODULO() {
        return SELECCIONAR_PROFESORMODULO;
    }

    public static String getSELECCIONAR_PROFESORESMODULOS() {
        return SELECCIONAR_PROFESORESMODULOS;
    }

    public static String getACTUALIZAR_PROFESORMODULO() {
        return ACTUALIZAR_PROFESORMODULO;
    }

    public static String getBORRAR_PROFESORMODULO() {
        return BORRAR_PROFESORMODULO;
    }

    public static String getBUSCAR_PK_REPETIDA_PROFESORMODULO() {
        return BUSCAR_PK_REPETIDA_PROFESORMODULO;
    }

    public static String getINSERTAR_TURNO() {
        return INSERTAR_TURNO;
    }

    public static String getSELECCIONAR_TURNO() {
        return SELECCIONAR_TURNO;
    }

    public static String getSELECCIONAR_TURNOS() {
        return SELECCIONAR_TURNOS;
    }

    public static String getACTUALIZAR_TURNO() {
        return ACTUALIZAR_TURNO;
    }

    public static String getBORRAR_TURNO() {
        return BORRAR_TURNO;
    }

    public static String getBUSCAR_PK_REPETIDA_TURNO() {
        return BUSCAR_PK_REPETIDA_TURNO;
    }

}
