-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-02-2023 a las 20:51:34
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

DROP DATABASE IF EXISTS asignaciondemodulos;
CREATE DATABASE asignaciondemodulos;
USE asignaciondemodulos;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `asignaciondemodulos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignaciones`
--

CREATE TABLE `asignaciones` (
  `id_asignacion` int(11) NOT NULL,
  `idprofesor` int(11) NOT NULL,
  `id_modulocurso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciclos`
--

CREATE TABLE `ciclos` (
  `idciclo` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `idfamiliaprofesional` int(11) NOT NULL,
  `tipo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ciclos`
--

INSERT INTO `ciclos` (`idciclo`, `nombre`, `idfamiliaprofesional`, `tipo`) VALUES
(1, 'Gestión Administrativa', 2, 'Grado medio'),
(2, 'Administración y Finanzas', 2, 'Grado superior'),
(3, 'Asistencia a la Dirección', 2, 'Grado superior'),
(4, 'Actividades Comerciales', 6, 'Grado medio'),
(5, 'Comercio Internacional', 6, 'Grado superior'),
(6, 'Transporte y Logística', 6, 'Grado superior'),
(7, 'Gestión de Ventas y Espacios Comerciales', 6, 'Grado superior'),
(8, 'Marketing y Publicidad', 6, 'Grado superior'),
(9, 'Instalaciones de Comunicaciones', 8, 'Grado medio'),
(10, 'Instalaciones Eléctricas y Automáticas', 8, 'Grado medio'),
(11, 'Mantenimiento Electrónico', 8, 'Grado superior'),
(12, 'Sistemas de Telecomunicaciones e Informáticos', 8, 'Grado superior'),
(13, 'Sistemas Electrotécnicos y Automatizados', 8, 'Grado superior'),
(14, 'Vídeo Disc.jockey y sonido', 13, 'Grado medio'),
(15, 'Producción de Audiovisuales y Espectáculos', 13, 'Grado superior'),
(16, 'Realización de Proyectos Audiovisuales y Espectáculos', 13, 'Grado superior'),
(17, 'Animaciones 3D, Juegos y Entornos Interactivos', 13, 'Grado superior'),
(18, 'Iluminación, Captación y Tratamiento de Imagen', 13, 'Grado superior'),
(19, 'Sistemas Microinformáticos y Redes', 16, 'Grado medio'),
(20, 'Administración de Sistemas Informáticos en Red', 16, 'Grado superior'),
(21, 'Desarrollo de aplicaciones Web', 16, 'Grado superior'),
(22, 'Desarrollo de aplicaciones Multiplataforma', 16, 'Grado superior'),
(23, 'Ciberseguridad en Entornos de las Tecnologías de la Información', 16, 'Curso de especialización');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE `cursos` (
  `codigo` varchar(255) NOT NULL,
  `idturno` int(11) NOT NULL,
  `idciclo` int(11) NOT NULL,
  `nivel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`codigo`, `idturno`, `idciclo`, `nivel`) VALUES
('1A1NMA', 1, 4, 1),
('1A2NMA', 1, 4, 2),
('1ASIRSEMI', 3, 20, 1),
('1DAMSEMI', 3, 22, 1),
('1DAWSEMI', 3, 21, 1),
('1SMRSEMI', 3, 19, 1),
('2ASIRSEMI', 3, 20, 2),
('2DAMSEMI', 3, 22, 2),
('2DAWSEMI', 3, 21, 2),
('2SMRSEMI', 3, 19, 2),
('3ASIRSEMI', 3, 20, 3),
('3DAMSEMI', 3, 22, 3),
('3DAWSEMI', 3, 21, 3),
('3SMRSEMI', 3, 19, 3),
('5A1NMA', 1, 2, 1),
('5A1NTB', 2, 2, 1),
('5A2NMA', 1, 2, 2),
('5A2NTB', 2, 2, 2),
('5B1NMA', 1, 3, 1),
('5B2NMA', 1, 3, 2),
('5C1NMA', 1, 5, 1),
('5C2NMA', 1, 5, 2),
('5D1NMA', 1, 7, 1),
('5D2NMA', 1, 7, 2),
('5E1NMA', 1, 8, 1),
('5E1NTB', 2, 8, 1),
('5E2NMA', 1, 8, 2),
('5E2NTB', 2, 8, 2),
('5F1NMA', 1, 6, 1),
('5F2NMA', 1, 6, 2),
('5G1NTA', 2, 11, 1),
('5G2NTA', 2, 11, 2),
('5H1NMA', 1, 16, 1),
('5H1NTB', 2, 16, 1),
('5H2NMA', 1, 16, 2),
('5H2NTB', 2, 16, 2),
('5I1NTA', 2, 18, 1),
('5I2NTA', 2, 18, 2),
('5J1NMA', 1, 15, 1),
('5J1NTB', 2, 15, 1),
('5J2NMA', 1, 15, 2),
('5J2NTB', 2, 15, 2),
('5K1NMA', 1, 12, 1),
('5K1NTB', 2, 12, 1),
('5K2NMA', 1, 12, 2),
('5K2NTB', 2, 12, 2),
('5L1NMA', 1, 17, 1),
('5L2NMA', 1, 17, 2),
('601NMA', 1, 13, 1),
('601NTB', 2, 13, 1),
('602NMA', 1, 13, 2),
('602NTB', 2, 13, 2),
('611NMA', 1, 14, 1),
('612NMA', 1, 14, 2),
('631NMA', 1, 9, 1),
('632NMA', 1, 9, 2),
('641NMA', 1, 10, 1),
('642NMA', 1, 10, 2),
('651NMA', 1, 21, 1),
('651NMB', 1, 21, 1),
('652NMA', 1, 21, 2),
('652NMB', 1, 21, 2),
('661NMA', 1, 19, 1),
('661NTB', 2, 19, 1),
('662NMA', 1, 19, 2),
('662NTB', 2, 19, 2),
('671NTA', 2, 22, 1),
('671NTB', 2, 22, 1),
('672NTA', 2, 22, 2),
('681NMA', 1, 20, 1),
('681NTB', 2, 20, 1),
('682NMA', 1, 20, 2),
('682NTB', 2, 20, 2),
('691NMA', 1, 1, 1),
('692NMA', 1, 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidades`
--

CREATE TABLE `especialidades` (
  `idespecialidad` int(11) NOT NULL,
  `descripcion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `especialidades`
--

INSERT INTO `especialidades` (`idespecialidad`, `descripcion`) VALUES
(211, 'Inglés'),
(308, 'Formación y orientación laboral'),
(360, 'Administración de empresas'),
(366, 'Sistemas electrónicos'),
(368, 'Informática'),
(373, 'Organización y gestión comercial'),
(468, 'Sistemas y aplicaciones informáticas'),
(469, 'Técnicas y procedimientos de imagen y sonido');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `familiasprofesionales`
--

CREATE TABLE `familiasprofesionales` (
  `idfamiliaprofesional` int(11) NOT NULL,
  `descripcion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `familiasprofesionales`
--

INSERT INTO `familiasprofesionales` (`idfamiliaprofesional`, `descripcion`) VALUES
(2, 'Administración y gestión'),
(6, 'Comercio y marketing'),
(8, 'Electricidad y electrónica'),
(13, 'Imagen y sonido'),
(16, 'Informática y comunicaciones');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modulos`
--

CREATE TABLE `modulos` (
  `codigo` varchar(255) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `horasreales` int(11) NOT NULL,
  `horasponderadas` int(11) NOT NULL,
  `idespecialidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `modulos`
--

INSERT INTO `modulos` (`codigo`, `descripcion`, `horasreales`, `horasponderadas`, `idespecialidad`) VALUES
('AAN', 'Aplicaciones informáticas para el comercio', 4, 2, 373),
('AAU', 'Animación musical en vivo', 9, 7, 469),
('AAV', 'Animación visual en vivo', 9, 7, 469),
('ADD', 'Administración de sistemas operativos', 5, 3, 468),
('ADE', 'Administración de sistemas gestores de bases de datos', 3, 1, 468),
('ADO', 'Administración y promoción de audiovisuales y espectáculos', 7, 5, 469),
('AED', 'Acceso a datos', 7, 5, 368),
('AEY', 'Atención al cliente, consumidor y usuario', 4, 2, 373),
('AIF', 'Aplicaciones ofimáticas', 8, 6, 468),
('AN2', 'Animación de elementos 2D y 3D', 8, 6, 469),
('AOT', 'Automatismos industriales', 9, 7, 366),
('APW', 'Aplicaciones web', 5, 3, 468),
('BAE', 'Bases de datos', 6, 4, 368),
('CDM', 'Control de la iluminación', 3, 1, 469),
('CEG', 'Comercio digital internacional', 3, 1, 373),
('CEP', 'Comunicación empresarial y atención al cliente', 5, 3, 360),
('CES', 'Comercialización del transporte y la logística', 6, 4, 373),
('CFD', 'Configuración de infraestructuras de sistemas de telecomunicaciones', 4, 2, 366),
('CFR', 'Configuración de instalaciones eléctricas', 7, 5, 366),
('CFU', 'Configuración de instalaciones domóticas y automáticas', 7, 5, 366),
('CIY', 'Circuito cerrado de televisión y seguridad electrónica', 7, 5, 366),
('CO2', 'Color, iluminación y acabados 2D y 3D', 5, 3, 469),
('COB', 'Contabilidad y fiscalidad', 6, 4, 360),
('CPC', 'Captación y grabación de sonido', 7, 5, 469),
('CRG', 'Circuitos electrónicos analógicos', 7, 5, 366),
('CRZ', 'Control, edición y mezcla de sonido', 9, 7, 469),
('CSN', 'Técnicas de almacén', 6, 4, 360),
('CYA', 'Comunicación y atención al cliente', 5, 3, 360),
('DAD', 'Desarrollo de interfaces', 7, 5, 468),
('DAV', 'Desarrollo de entornos interactivos multidispositivo', 8, 6, 469),
('DEW', 'Desarrollo web en entorno cliente', 7, 5, 368),
('DNA', 'Dinamización del punto de venta', 5, 3, 360),
('DOB', 'Diseño y elaboración de material de comunicación', 8, 6, 373),
('DOJ', 'Diseño, dibujo y modelado para animación', 5, 3, 469),
('DOL', 'Documentación técnica en instalaciones eléctricas', 3, 1, 366),
('DOR', 'Diseño de interfaces web', 6, 4, 368),
('DPL', 'Despliegue de aplicaciones web', 6, 4, 468),
('DRR', 'Desarrollo de redes eléctricas y centros de transformación', 4, 2, 366),
('DSW', 'Desarrollo web en entorno servidor', 8, 6, 368),
('ELE', 'Electrotecnia', 6, 4, 366),
('ELT', 'Electrónica', 3, 1, 366),
('EMR', 'Empresa e iniciativa emprendedora', 3, 1, 308),
('EOS', 'Elementos de sistemas de telecomunicaciones', 4, 2, 366),
('EPE', 'Empresa en el aula', 6, 4, 360),
('EPR', 'Empresa y administración', 3, 1, 360),
('EPT', 'Escaparatismo y diseño de espacios comerciales', 4, 2, 373),
('EQC', 'Equipos microprogramables', 7, 5, 368),
('EQM', 'Equipos microinformáticos', 4, 2, 368),
('ETD', 'Electrónica aplicada', 6, 4, 366),
('ETS', 'Entornos de desarrollo', 3, 1, 468),
('FIN', 'Financiación internacional', 7, 5, 373),
('FOL', 'Formación y orientación laboral', 3, 1, 308),
('FUW', 'Fundamentos de hardware', 3, 1, 368),
('GEF', 'Gestión financiera', 5, 3, 360),
('GEL', 'Gestión administrativa del comercio internacional', 6, 4, 373),
('GEQ', 'Gestión de un pequeño comercio', 8, 6, 373),
('GII', 'Gestión económica y financiera de la empresa', 6, 4, 360),
('GIL', 'Gestión logística y comercial', 6, 4, 360),
('GIN', 'Gestión de compras', 3, 1, 373),
('GIP', 'Gestión de productos y promociones en el punto de venta', 4, 2, 373),
('GIR', 'Gestión de proyectos de instalaciones de telecomunicaciones', 3, 1, 366),
('GIS', 'Gestión administrativa del transporte y la logística', 8, 6, 373),
('GIT', 'Gestión de proyectos de televisión y radio', 7, 5, 469),
('GIU', 'Gestión de proyectos de espectáculos y eventos', 6, 4, 469),
('GIY', 'Gestión de proyectos de cine, vídeo y multimedia', 7, 5, 469),
('GRY', 'Grabación y edición de reportajes audiovisuales', 4, 2, 469),
('GSZ', 'Gestión avanzada de la información', 7, 5, 360),
('GTB', 'Gestión de bases de datos', 5, 3, 368),
('GTH', 'Gestión de recursos humanos', 5, 3, 360),
('GTJ', 'Gestión de la documentación jurídica y empresarial', 4, 2, 360),
('GTT', 'Gestión del montaje y del mantenimiento de instalaciones eléctricas', 2, 1, 366),
('IBS', 'Instalaciones eléctricas básicas', 6, 4, 366),
('IDP', 'Implantación de sistemas operativos', 8, 6, 468),
('IMW', 'Implantación de aplicaciones web', 6, 4, 468),
('ING', 'Inglés', 5, 3, 211),
('IOB', 'instalaciones de distribución', 6, 4, 366),
('IOZ', 'Instalaciones de megafonía y sonorización', 7, 5, 469),
('IUC', 'Infraestructuras comunes de telecomunicación en viviendas y edificios', 4, 2, 366),
('IUN', 'Instalaciones de radiocomunicaciones', 7, 5, 366),
('IUU', 'Infraestructuras de redes de datos y sistemas de telefonía', 7, 5, 366),
('IUY', 'Infraestructuras y desarrollo del mantenimiento electrónico', 3, 1, 366),
('IVE', 'Investigación comercial', 4, 2, 373),
('IVO', 'Instalaciones solares fotovoltaicas', 3, 1, 366),
('IYJ', 'Instalación y montaje de equipos de sonido', 7, 5, 469),
('LND', 'Lenguaje de marcas y sistemas de gestión de información', 4, 2, 468),
('LNP', 'Lanzamiento de productos y servicios', 4, 2, 373),
('LNT', 'Lengua extranjera (Inglés)', 2, 1, 211),
('LOD', 'Logística de almacenamiento', 4, 2, 373),
('LOP', 'Logística de aprovisionamiento ', 6, 4, 373),
('LUM', 'Luminotecnia', 5, 3, 469),
('MAR', 'Marketing internacional', 8, 6, 373),
('MDP', 'Medios y soportes de comunicación', 4, 2, 373),
('MDQ', 'Mantenimiento de equipos de audio', 7, 5, 366),
('MEI', 'Medios de pago internacionales', 4, 2, 373),
('MIZ', 'Mantenimiento de equipos de voz y datos', 5, 3, 366),
('MJE', 'Montaje y mantenimiento de equipos', 7, 5, 368),
('MMN', 'Mantenimiento de equipos de radiocomunicaciones', 5, 3, 366),
('MMQ', 'Mantenimiento de equipos de electrónica industrial', 5, 3, 366),
('MMV', 'Mantenimiento de equipos de vídeo', 5, 3, 366),
('MQA', 'Máquinas eléctricas', 6, 4, 366),
('MRD', 'Marketing digital', 5, 3, 360),
('MRG', 'Marketing en la actividad comercial', 5, 3, 373),
('MSO', 'Medios técnicos audiovisuales y escénicos', 6, 4, 469),
('NEG', 'Negociación internacional', 4, 2, 373),
('NSA', 'Instalaciones domóticas', 6, 4, 366),
('NST', 'Instalaciones eléctricas interiores', 9, 7, 366),
('OAL', 'Organización del transporte de viajeros', 5, 3, 373),
('OAR', 'Organización del transporte de mercancías', 5, 3, 373),
('OEG', 'Operaciones auxiliares de gestión de tesorería', 8, 6, 360),
('OEH', 'Operaciones administrativas de recursos humanos', 7, 5, 360),
('OEV', 'Operaciones administrativas de compraventa', 5, 3, 373),
('OFA', 'Ofimática y proceso de la información', 5, 3, 360),
('OGQ', 'Organización de equipos de ventas', 4, 2, 373),
('OGV', 'Organización de eventos empresariales', 10, 8, 360),
('OME', 'Comercio electrónico', 6, 4, 373),
('PEK', 'Preparación de sesiones de vídeo disc-jockey', 6, 4, 469),
('PFG', 'Planificación de la regiduría de espectáculos y eventos', 4, 2, 469),
('PFM', 'Planificación de cámara en audiovisuales', 4, 2, 469),
('PFP', 'Planificación de proyectos audiovisuales', 8, 6, 469),
('PFR', 'Planificación de proyectos de espectáculos y eventos', 5, 3, 469),
('PFT', 'Proyectos fotográficos', 3, 1, 469),
('PFZ', 'Planificación de la realización en cine y vídeo', 4, 2, 469),
('PGL', 'Programación multimedia y dispositivos móviles', 4, 2, 468),
('PGP', 'Procesos de regiduría de espectáculos y eventos', 6, 4, 469),
('PGV', 'Programación de servicios y procesos', 4, 2, 368),
('PIZ', 'Procesos de realización en cine y vídeo', 7, 5, 469),
('PJU', 'Proyectos de juegos y entornos interactivos', 6, 4, 469),
('PLJ', 'Planificación del montaje y postproducción de audiovisuales', 6, 4, 469),
('PLZ', 'Procesos de realización en televisión', 6, 4, 469),
('PNG', 'Proceso integral de la actividad comercial', 6, 4, 373),
('PNI', 'Planificación y administración de redes', 5, 3, 368),
('PNM', 'Procesos en instalaciones de infraestructuras comunes de telecomunicaciones', 7, 5, 366),
('PNZ', 'Planificación de la realización en televisión', 5, 3, 469),
('PO3', 'Proyectos de animación audiovisual 2D y 3D', 6, 4, 469),
('POL', 'Políticas de marketing', 6, 4, 360),
('PRO', 'Programación', 7, 5, 368),
('PUM', 'Proyectos de iluminación', 6, 4, 469),
('PVN', 'Procesos de venta', 5, 3, 373),
('RAM', 'Realización del montaje y postproducción de audiovisuales', 7, 5, 469),
('RAY', 'Realización de proyectos multimedia interactivos', 7, 5, 469),
('RCB', 'Recursos humanos y responsabilidad social corporativa', 2, 1, 360),
('RDE', 'Redes locales', 7, 5, 368),
('RDT', 'Redes telemáticas', 6, 4, 366),
('REK', 'Relaciones públicas y organización de eventos de marketing', 5, 3, 373),
('REX', 'Recursos expresivos audiovisuales y\r\nescénicos', 5, 3, 469),
('ROE', 'Proyecto de comercio internacional', 2, 1, 373),
('ROT', 'Protocolo empresarial', 8, 6, 360),
('SGA', 'Segunda Lengua Extranjera (Alemán)', 5, 3, 211),
('SGF', 'Seguridad informática', 6, 4, 368),
('SGY', 'Seguridad y alta disponibilidad', 6, 4, 368),
('SIH', 'Sistemas integrados y hogar digital', 6, 4, 366),
('SMI', 'Sistemas informáticos y redes locales', 5, 3, 468),
('SML', 'Simulación empresarial', 8, 6, 360),
('SRA', 'Servicios de atención comercial', 4, 2, 373),
('SRC', 'Servicios en red', 8, 6, 368),
('SRD', 'Servicios de red e internet', 6, 4, 368),
('SSF', 'Sistemas informáticos', 5, 3, 468),
('SSG', 'Sistemas de gestión empresarial', 5, 3, 468),
('SSJ', 'Sistemas de telefonía fija y móvil', 4, 2, 366),
('SSN', 'Sistemas operativos en red', 8, 6, 468),
('SSV', 'Sistemas operativos monopuesto', 5, 3, 468),
('STC', 'Sistemas de radiocomunicaciones', 7, 5, 366),
('STF', 'Sistema de información de mercados', 4, 2, 373),
('STO', 'Sistemas de producción audiovisual\r\n', 8, 6, 366),
('STY', 'Sistemas y circuitos eléctricos', 6, 4, 366),
('TBM', 'Trabajo de campo en la investigación comercial', 4, 2, 373),
('TEB', 'Técnica contable', 4, 2, 360),
('TFF', 'Tratamiento fotográfico digital', 12, 10, 469),
('TFG', 'Toma fotográfica', 6, 4, 469),
('TFO', 'Tratamiento informático de la información', 7, 5, 360),
('TGV', 'Toma de imagen audiovisual', 9, 7, 469),
('TIQ', 'Técnicas y procesos de montaje y mantenimiento de equipos electrónicos', 6, 4, 366),
('TRO', 'Transporte internacional de mercancías', 5, 3, 373),
('TUM', 'Tratamiento de la documentación contable', 7, 5, 360),
('TVT', 'Técnicas de venta y negociación\r\n', 6, 4, 373),
('TYE', 'Técnicas y procesos en infraestructuras de telecomunicaciones', 5, 3, 366),
('TYN', 'Toma y edición digital de imagen', 7, 5, 469),
('TYP', 'Técnicas y procesos en instalaciones eléctricas', 7, 5, 366),
('TYR', 'Técnicas y procesos en instalaciones domóticas y automáticas', 7, 5, 366),
('VEA', 'Venta técnica', 6, 4, 373);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modulos_cursos`
--

CREATE TABLE `modulos_cursos` (
  `idmodulo_curso` int(11) NOT NULL,
  `codigomodulo` varchar(255) NOT NULL,
  `codigocurso` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `modulos_cursos`
--

INSERT INTO `modulos_cursos` (`idmodulo_curso`, `codigomodulo`, `codigocurso`) VALUES
(1, 'AAN', '1A1NMA'),
(2, 'DNA', '1A1NMA'),
(3, 'FOL', '1A1NMA'),
(4, 'GIN', '1A1NMA'),
(5, 'ING', '1A1NMA'),
(6, 'MRG', '1A1NMA'),
(7, 'PVN', '1A1NMA'),
(8, 'CPC', '611NMA'),
(9, 'FOL', '611NMA'),
(10, 'IYJ', '611NMA'),
(11, 'PEK', '611NMA'),
(12, 'TYN', '611NMA'),
(13, 'EQM', '631NMA'),
(14, 'ETD', '631NMA'),
(15, 'FOL', '631NMA'),
(16, 'IBS', '631NMA'),
(17, 'IUC', '631NMA'),
(18, 'IUU', '631NMA'),
(19, 'AOT', '641NMA'),
(20, 'ELE', '641NMA'),
(21, 'ELT', '641NMA'),
(22, 'FOL', '641NMA'),
(23, 'NST', '641NMA'),
(24, 'AIF', '661NMA'),
(25, 'FOL', '661NMA'),
(26, 'MJE', '661NMA'),
(27, 'RDE', '661NMA'),
(28, 'SSV', '661NMA'),
(29, 'AIF', '661NTB'),
(30, 'FOL', '661NTB'),
(31, 'MJE', '661NTB'),
(32, 'RDE', '661NTB'),
(33, 'SSV', '661NTB'),
(34, 'CEP', '691NMA'),
(35, 'EPR', '691NMA'),
(36, 'FOL', '691NMA'),
(37, 'ING', '691NMA'),
(38, 'OEV', '691NMA'),
(39, 'TEB', '691NMA'),
(40, 'TFO', '691NMA'),
(41, 'CSN', '1A2NMA'),
(42, 'GEQ', '1A2NMA'),
(43, 'OME', '1A2NMA'),
(44, 'SRA', '1A2NMA'),
(45, 'VEA', '1A2NMA'),
(46, 'AAU', '612NMA'),
(47, 'AAV', '612NMA'),
(48, 'CRZ', '612NMA'),
(49, 'EMR', '612NMA'),
(50, 'CIY', '632NMA'),
(51, 'EMR', '632NMA'),
(52, 'IOZ', '632NMA'),
(53, 'IUN', '632NMA'),
(54, 'NSA', '632NMA'),
(55, 'EMR', '642NMA'),
(56, 'IOB', '642NMA'),
(57, 'IUC', '642NMA'),
(58, 'IVO', '642NMA'),
(59, 'MQA', '642NMA'),
(60, 'NSA', '642NMA'),
(61, 'APW', '662NMA'),
(62, 'EMR', '662NMA'),
(63, 'SGF', '662NMA'),
(64, 'SRC', '662NMA'),
(65, 'SSN', '662NMA'),
(66, 'APW', '662NTB'),
(67, 'EMR', '662NTB'),
(68, 'SGF', '662NTB'),
(69, 'SRC', '662NTB'),
(70, 'SSN', '662NMA'),
(71, 'EPE', '692NMA'),
(72, 'OEG', '692NMA'),
(73, 'OEH', '692NMA'),
(74, 'TUM', '692NMA'),
(75, 'CYA', '5A1NMA'),
(76, 'FOL', '5A1NMA'),
(77, 'GTJ', '5A1NMA'),
(78, 'ING', '5A1NMA'),
(79, 'OFA', '5A1NMA'),
(80, 'PNG', '5A1NMA'),
(81, 'RCB', '5A1NMA'),
(82, 'CYA', '5A1NTB'),
(83, 'FOL', '5A1NTB'),
(84, 'GTJ', '5A1NTB'),
(85, 'ING', '5A1NTB'),
(86, 'OFA', '5A1NTB'),
(87, 'PNG', '5A1NTB'),
(88, 'RCB', '5A1NTB'),
(89, 'CYA', '5B1NMA'),
(90, 'FOL', '5B1NMA'),
(91, 'GTJ', '5B1NMA'),
(92, 'ING', '5B1NMA'),
(93, 'OFA', '5B1NMA'),
(94, 'PNG', '5B1NMA'),
(95, 'RCB', '5B1NMA'),
(96, 'FOL', '5C1NMA'),
(97, 'GEL', '5C1NMA'),
(98, 'GII', '5C1NMA'),
(99, 'ING', '5C1NMA'),
(100, 'LOD', '5C1NMA'),
(101, 'TRO', '5C1NMA'),
(102, 'FOL', '5D1NMA'),
(103, 'GII', '5D1NMA'),
(104, 'ING', '5D1NMA'),
(105, 'IVE', '5D1NMA'),
(106, 'MRD', '5D1NMA'),
(107, 'POL', '5D1NMA'),
(108, 'FOL', '5E1NMA'),
(109, 'GII', '5E1NMA'),
(110, 'ING', '5E1NMA'),
(111, 'IVE', '5E1NMA'),
(112, 'MRD', '5E1NMA'),
(113, 'POL', '5E1NMA'),
(114, 'FOL', '5E1NTB'),
(115, 'GII', '5E1NTB'),
(116, 'ING', '5E1NTB'),
(117, 'IVE', '5E1NTB'),
(118, 'MRD', '5E1NTB'),
(119, 'POL', '5E1NTB'),
(120, 'FOL', '5F1NMA'),
(121, 'GEL', '5F1NMA'),
(122, 'GII', '5F1NMA'),
(123, 'ING', '5F1NMA'),
(124, 'LOD', '5F1NMA'),
(125, 'TRO', '5F1NMA'),
(126, 'CRG', '5G1NTA'),
(127, 'EQC', '5G1NTA'),
(128, 'FOL', '5G1NTA'),
(129, 'LNT', '5G1NTA'),
(130, 'MMQ', '5G1NTA'),
(131, 'TIQ', '5G1NTA'),
(132, 'FOL', '5H1NMA'),
(133, 'LNT', '5H1NMA'),
(134, 'MSO', '5H1NMA'),
(135, 'PFG', '5H1NMA'),
(136, 'PFZ', '5H1NMA'),
(137, 'PLJ', '5H1NMA'),
(138, 'PNZ', '5H1NMA'),
(139, 'FOL', '5H1NTB'),
(140, 'LNT', '5H1NTB'),
(141, 'MSO', '5H1NTB'),
(142, 'PFG', '5H1NTB'),
(143, 'PLJ', '5H1NMA'),
(144, 'PNZ', '5H1NMA'),
(145, 'CDM', '5I1NTA'),
(146, 'FOL', '5I1NTA'),
(147, 'GRY', '5I1NTA'),
(148, 'LNT', '5I1NTA'),
(149, 'LUM', '5I1NTA'),
(150, 'PFM', '5I1NTA'),
(151, 'PFT', '5I1NTA'),
(152, 'TFG', '5I1NTA'),
(153, 'FOL', '5J1NMA'),
(154, 'LNT', '5J1NMA'),
(155, 'MSO', '5J1NMA'),
(157, 'PFP', '5J1NMA'),
(158, 'PFR', '5J1NMA'),
(159, 'REX', '5J1NMA'),
(160, 'FOL', '5J1NTB'),
(161, 'LNT', '5J1NTB'),
(162, 'MSO', '5J1NTB'),
(163, 'PFP', '5J1NTB'),
(164, 'PFR', '5J1NTB'),
(165, 'REX', '5J1NTB'),
(166, 'AN2', '5L1NMA'),
(167, 'CO2', '5L1NMA'),
(168, 'DOJ', '5L1NMA'),
(169, 'FOL', '5L1NMA'),
(170, 'LNT', '5L1NMA'),
(171, 'RAY', '5L1NMA'),
(186, 'CFD', '5K1NMA'),
(187, 'EOS', '5K1NMA'),
(188, 'FOL', '5K1NMA'),
(189, 'GIR', '5K1NMA'),
(190, 'LNT', '5K1NMA'),
(191, 'SMI', '5K1NMA'),
(192, 'SSJ', '5K1NMA'),
(193, 'TYE', '5K1NMA'),
(194, 'CFD', '5K1NTB'),
(195, 'EOS', '5K1NTB'),
(196, 'FOL', '5K1NTB'),
(197, 'GIR', '5K1NTB'),
(198, 'LNT', '5K1NTB'),
(199, 'SMI', '5K1NTB'),
(200, 'SSJ', '5K1NTB'),
(201, 'TYE', '5K1NTB'),
(202, 'BAE', '651NMA'),
(203, 'ETS', '651NMA'),
(204, 'FOL', '651NMA'),
(205, 'LND', '651NMA'),
(206, 'LNT', '651NMA'),
(207, 'PRO', '651NMA'),
(208, 'SSF', '651NMA'),
(209, 'BAE', '651NMB'),
(210, 'ETS', '651NMB'),
(211, 'FOL', '651NMB'),
(212, 'LND', '651NMB'),
(213, 'LNT', '651NMB'),
(214, 'PRO', '651NMB'),
(215, 'SSF', '651NMB'),
(216, 'BAE', '671NTA'),
(217, 'ETS', '671NTA'),
(218, 'FOL', '671NTA'),
(219, 'LND', '671NTA'),
(220, 'LNT', '671NTA'),
(221, 'PRO', '671NTA'),
(222, 'SSF', '671NTA'),
(223, 'BAE', '671NTB'),
(224, 'ETS', '671NTB'),
(225, 'FOL', '671NTB'),
(226, 'LND', '671NTB'),
(227, 'LNT', '671NTB'),
(228, 'PRO', '671NTB'),
(229, 'SSF', '671NTB'),
(230, 'FOL', '681NMA'),
(231, 'FUW', '681NMA'),
(232, 'GTB', '681NMA'),
(233, 'IDP', '681NMA'),
(234, 'LND', '681NMA'),
(235, 'LNT', '681NMA'),
(236, 'PNI', '681NMA'),
(237, 'FOL', '681NTB'),
(238, 'FUW', '681NTB'),
(239, 'GTB', '681NTB'),
(240, 'IDP', '681NTB'),
(241, 'LND', '681NTB'),
(242, 'LNT', '681NTB'),
(243, 'PNI', '681NTB'),
(244, 'DEW', '652NMA'),
(245, 'DOR', '652NMA'),
(246, 'DPL', '652NMA'),
(247, 'DSW', '652NMA'),
(248, 'EMR', '652NMA'),
(249, 'DEW', '652NMB'),
(250, 'DOR', '652NMB'),
(251, 'DPL', '652NMB'),
(252, 'DSW', '651NMB'),
(253, 'EMR', '652NMB'),
(254, 'AED', '672NTA'),
(255, 'DAD', '672NTA'),
(256, 'EMR', '672NTA'),
(257, 'PGL', '672NTA'),
(258, 'PGV', '672NTA'),
(259, 'SSG', '672NTA'),
(260, 'ADD', '682NMA'),
(261, 'ADE', '682NMA'),
(262, 'EMR', '682NMA'),
(263, 'IMW', '682NMA'),
(264, 'SGY', '682NMA'),
(265, 'SRD', '682NMA'),
(266, 'ADD', '682NTB'),
(267, 'ADE', '682NTB'),
(268, 'EMR', '682NTB'),
(269, 'IMW', '682NTB'),
(270, 'SGY', '682NTB'),
(271, 'SRD', '682NTB'),
(272, 'DOL', '601NMA'),
(273, 'FOL', '601NMA'),
(274, 'GTT', '601NMA'),
(275, 'LNT', '601NMA'),
(276, 'STY', '601NMA'),
(277, 'TYP', '601NMA'),
(278, 'TYR', '601NMA'),
(279, 'DOL', '601NTB'),
(280, 'FOL', '601NTB'),
(281, 'GTT', '601NTB'),
(282, 'LNT', '601NTB'),
(283, 'STY', '601NTB'),
(284, 'TYP', '601NTB'),
(285, 'TYR', '601NTB'),
(288, 'FUW', '1ASIRSEMI'),
(289, 'PNI', '1ASIRSEMI'),
(290, 'IDP', '1ASIRSEMI'),
(291, 'LNT', '1ASIRSEMI'),
(292, 'GTB', '2ASIRSEMI'),
(293, 'LND', '2ASIRSEMI'),
(294, 'IMW', '2ASIRSEMI'),
(295, 'ADD', '2ASIRSEMI'),
(296, 'ADE', '2ASIRSEMI'),
(297, 'FOL', '3ASIRSEMI'),
(298, 'EMR', '3ASIRSEMI'),
(299, 'SRD', '3ASIRSEMI'),
(300, 'SGY', '3ASIRSEMI'),
(301, 'SSF', '1DAMSEMI'),
(302, 'PRO', '1DAMSEMI'),
(303, 'LND', '1DAMSEMI'),
(304, 'ETS', '1DAMSEMI'),
(305, 'DAD', '2DAMSEMI'),
(306, 'BAE', '2DAMSEMI'),
(307, 'AED', '2DAMSEMI'),
(308, 'FOL', '2DAMSEMI'),
(309, 'LNT', '2DAMSEMI'),
(310, 'SSG', '3DAMSEMI'),
(311, 'PGV', '3DAMSEMI'),
(312, 'PGL', '3DAMSEMI'),
(313, 'EMR', '3DAMSEMI'),
(314, 'SSF', '1DAWSEMI'),
(315, 'PRO', '1DAWSEMI'),
(316, 'LND', '1DAWSEMI'),
(317, 'ETS', '1DAWSEMI'),
(318, 'DEW', '2DAWSEMI'),
(319, 'DOR', '2DAWSEMI'),
(320, 'FOL', '2DAWSEMI'),
(321, 'LNT', '2DAWSEMI'),
(322, 'BAE', '2DAWSEMI'),
(323, 'DSW', '3DAWSEMI'),
(324, 'DPL', '3DAWSEMI'),
(325, 'EMR', '3DAWSEMI'),
(326, 'AIF', '1SMRSEMI'),
(327, 'MJE', '1SMRSEMI'),
(328, 'SSV', '1SMRSEMI'),
(329, 'SSN', '2SMRSEMI'),
(330, 'RDE', '2SMRSEMI'),
(331, 'FOL', '2SMRSEMI'),
(332, 'EMR', '2SMRSEMI'),
(333, 'SGF', '3SMRSEMI'),
(334, 'APW', '3SMRSEMI'),
(335, 'SRC', '3SMRSEMI');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesores`
--

CREATE TABLE `profesores` (
  `idprofesor` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `numerodeorden` decimal(11,0) NOT NULL,
  `idespecialidad` int(11) NOT NULL,
  `horascontratadas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `profesores`
--

INSERT INTO `profesores` (`idprofesor`, `nombre`, `apellido`, `numerodeorden`, `idespecialidad`, `horascontratadas`) VALUES
(1, 'Alejandro', 'Navarro Castillo', '4', 368, 20),
(2, 'Wilfredo', 'Amaro Febles', '1', 368, 20),
(3, 'Fabiola', 'González de León', '3', 368, 20),
(4, 'Abel', 'González Salazar', '2', 468, 20),
(5, 'Carlos Javier', 'García Díaz', '5', 368, 20),
(6, 'Amparo', 'Rivero Quintana', '6', 468, 20),
(7, 'Victoria Eugenia', 'Castro Navarro', '7', 211, 20),
(8, 'Friedrich', 'Leu Rodríguez', '8', 368, 20),
(9, 'Alejandro', 'Correa Rodríguez', '9', 468, 20),
(10, 'Claudio', 'León del Rosario', '27', 468, 20),
(11, 'Nazario Manuel', 'Vera Maya', '11', 308, 20),
(12, 'Lorenzo Javier', 'Padrón Brito', '12', 368, 20),
(13, 'Manuel Ángel', 'Álvarez Pérez', '13', 368, 20),
(14, 'Juan Francisco', 'Sánchez González', '26', 468, 20),
(15, 'Héctor Emilio', 'López Reboso', '16', 308, 20),
(16, 'María Raquel', 'Lorenzo González', '15', 468, 20),
(17, 'Álvaro', 'Viña Manrique', '17', 360, 20),
(18, 'Jorge', 'Rivero Antuña', '18', 308, 20),
(19, 'Antonio Javier', 'Fernández Delgado', '19', 360, 20),
(20, 'Erica', 'Gómez Perdomo', '20', 360, 20),
(21, 'María Dolores', 'Sánchez Acosta', '21', 373, 20),
(22, 'Sara', 'Pérez Reverón', '22', 373, 20),
(23, 'Tomás Akira', 'Jallaguier Hirose', '23', 373, 20),
(24, 'Rosa María', 'Martín Herrera', '24', 308, 20),
(25, 'Teresa de Jesús', 'Cabrera Cabrera', '25', 308, 20),
(26, 'Paula', 'Valls Martín', '14', 373, 20),
(27, 'Pedro Alcides', 'Pérez Padilla', '10', 366, 20),
(28, 'Fátima Estrella', 'Morales Sacramento', '28', 211, 20),
(29, 'Ayoze', 'Marrero Ramos', '29', 366, 20),
(30, 'David', 'Hernández Casañas', '30', 366, 20),
(31, 'Manuel Luis', 'Piedrabuena Marrero', '31', 308, 20),
(32, 'Olivia', 'Santana Sarmiento', '32', 211, 20),
(33, 'José Manuel', 'Aldana García', '33', 469, 20),
(34, 'Demetrio', 'Darias Díaz', '34', 469, 20),
(35, 'Félix Alexis', 'Morales Rodríguez', '35', 469, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turnos`
--

CREATE TABLE `turnos` (
  `idturno` int(11) NOT NULL,
  `descripcion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `turnos`
--

INSERT INTO `turnos` (`idturno`, `descripcion`) VALUES
(1, 'Mañana'),
(2, 'Tarde'),
(3, 'Noche'),
(10, 'FALSO');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asignaciones`
--
ALTER TABLE `asignaciones`
  ADD PRIMARY KEY (`id_asignacion`),
  ADD KEY `fk_profesor` (`idprofesor`),
  ADD KEY `fk_modulo_2` (`id_modulocurso`);

--
-- Indices de la tabla `ciclos`
--
ALTER TABLE `ciclos`
  ADD PRIMARY KEY (`idciclo`),
  ADD KEY `fk_familiaprofesional` (`idfamiliaprofesional`);

--
-- Indices de la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_turno` (`idturno`),
  ADD KEY `fk_ciclo` (`idciclo`);

--
-- Indices de la tabla `especialidades`
--
ALTER TABLE `especialidades`
  ADD PRIMARY KEY (`idespecialidad`);

--
-- Indices de la tabla `familiasprofesionales`
--
ALTER TABLE `familiasprofesionales`
  ADD PRIMARY KEY (`idfamiliaprofesional`);

--
-- Indices de la tabla `modulos`
--
ALTER TABLE `modulos`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_especialidad_2` (`idespecialidad`);

--
-- Indices de la tabla `modulos_cursos`
--
ALTER TABLE `modulos_cursos`
  ADD PRIMARY KEY (`idmodulo_curso`),
  ADD KEY `fk_curso` (`codigocurso`),
  ADD KEY `fk_modulo` (`codigomodulo`);

--
-- Indices de la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`idprofesor`),
  ADD UNIQUE KEY `numerodeorden` (`numerodeorden`),
  ADD UNIQUE KEY `numerodeorden_2` (`numerodeorden`),
  ADD UNIQUE KEY `numerodeorden_3` (`numerodeorden`),
  ADD KEY `fk_especialidad` (`idespecialidad`);

--
-- Indices de la tabla `turnos`
--
ALTER TABLE `turnos`
  ADD PRIMARY KEY (`idturno`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asignaciones`
--
ALTER TABLE `asignaciones`
  MODIFY `id_asignacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- AUTO_INCREMENT de la tabla `ciclos`
--
ALTER TABLE `ciclos`
  MODIFY `idciclo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `especialidades`
--
ALTER TABLE `especialidades`
  MODIFY `idespecialidad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=472;

--
-- AUTO_INCREMENT de la tabla `familiasprofesionales`
--
ALTER TABLE `familiasprofesionales`
  MODIFY `idfamiliaprofesional` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `modulos_cursos`
--
ALTER TABLE `modulos_cursos`
  MODIFY `idmodulo_curso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=336;

--
-- AUTO_INCREMENT de la tabla `profesores`
--
ALTER TABLE `profesores`
  MODIFY `idprofesor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT de la tabla `turnos`
--
ALTER TABLE `turnos`
  MODIFY `idturno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asignaciones`
--
ALTER TABLE `asignaciones`
  ADD CONSTRAINT `fk_modulocurso` FOREIGN KEY (`id_modulocurso`) REFERENCES `modulos_cursos` (`idmodulo_curso`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_profesor` FOREIGN KEY (`idprofesor`) REFERENCES `profesores` (`idprofesor`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ciclos`
--
ALTER TABLE `ciclos`
  ADD CONSTRAINT `fk_familiaprofesional` FOREIGN KEY (`idfamiliaprofesional`) REFERENCES `familiasprofesionales` (`idfamiliaprofesional`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD CONSTRAINT `fk_ciclo` FOREIGN KEY (`idciclo`) REFERENCES `ciclos` (`idciclo`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_turno` FOREIGN KEY (`idturno`) REFERENCES `turnos` (`idturno`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `modulos`
--
ALTER TABLE `modulos`
  ADD CONSTRAINT `fk_especialidad_2` FOREIGN KEY (`idespecialidad`) REFERENCES `especialidades` (`idespecialidad`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `modulos_cursos`
--
ALTER TABLE `modulos_cursos`
  ADD CONSTRAINT `fk_curso` FOREIGN KEY (`codigocurso`) REFERENCES `cursos` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_modulo` FOREIGN KEY (`codigomodulo`) REFERENCES `modulos` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD CONSTRAINT `fk_especialidad` FOREIGN KEY (`idespecialidad`) REFERENCES `especialidades` (`idespecialidad`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
