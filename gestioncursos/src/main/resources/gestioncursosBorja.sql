-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-07-2016 a las 13:28:16
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestioncursos`
--
CREATE DATABASE IF NOT EXISTS `gestioncursos` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `gestioncursos`;

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `deleteAlumno`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteAlumno` (IN `codigo` INT)  NO SQL
DELETE FROM alumno 
WHERE codAlumno = codigo$$

DROP PROCEDURE IF EXISTS `deleteCurso`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteCurso` (IN `codigo` INT)  BEGIN
DELETE FROM curso WHERE codCurso = codigo;
END$$

DROP PROCEDURE IF EXISTS `deleteModulo`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteModulo` (IN `codigo` INT)  BEGIN
DELETE FROM modulo WHERE codModulo = codigo;
END$$

DROP PROCEDURE IF EXISTS `getAllAlumno`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllAlumno` ()  NO SQL
SELECT codAlumno, a.nombre as 'nAlumno', apellidos, email, telefono, dni_nie, fNacimiento, a.codGenero, g.nombre as 'nGenero' 
FROM alumno a
INNER JOIN genero g ON g.codGenero = a.codGenero$$

DROP PROCEDURE IF EXISTS `getAllCurso`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllCurso` ()  BEGIN
SELECT `codCurso`, `nombre` AS 'nCurso', `codPatrocinador`, `codTipoCurso` FROM `curso`;
END$$

DROP PROCEDURE IF EXISTS `getAllModulo`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllModulo` ()  BEGIN
SELECT `codModulo`, `nombre`, `uFormativa`, `duracion` FROM modulo;
END$$

DROP PROCEDURE IF EXISTS `getAlumnoById`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAlumnoById` (IN `codAlumno` INT)  NO SQL
SELECT codAlumno, a.nombre AS 'nAlumno', apellidos, dni_nie, fNacimiento, email, telefono, a.codGenero, g.nombre AS 'nGenero' FROM alumno a INNER JOIN genero g ON g.codGenero = a.codGenero WHERE a.codAlumno = codAlumno$$

DROP PROCEDURE IF EXISTS `getCursoById`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCursoById` (IN `codigo` INT)  NO SQL
SELECT codCurso, nombre AS 'nCurso' , codPatrocinador, codTipoCurso FROM curso WHERE codCurso = codigo$$

DROP PROCEDURE IF EXISTS `getModuloById`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getModuloById` (IN `codigo` INT)  BEGIN
SELECT `codModulo`, `nombre`, `uFormativa`, `duracion` FROM modulo WHERE codModulo = codigo;
END$$

DROP PROCEDURE IF EXISTS `insertAlumno`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertAlumno` (IN `nombre` VARCHAR(150), IN `apellidos` VARCHAR(250), IN `dni_nie` VARCHAR(9), IN `fNacimiento` DATE, IN `email` VARCHAR(100), IN `telefono` VARCHAR(13), IN `codGenero` INT, OUT `codAlumno` INT)  NO SQL
BEGIN
INSERT INTO alumno (nombre, apellidos, dni_nie, fNacimiento, email, telefono, codGenero) VALUES(UPPER(nombre), UPPER(apellidos),UPPER(dni_nie),fNacimiento,UPPER(email),UPPER(telefono),codGenero);

SET codAlumno = LAST_INSERT_ID();

END$$

DROP PROCEDURE IF EXISTS `insertCurso`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertCurso` (IN `nombre` VARCHAR(150), IN `codTipoCurso` INT, IN `codPatrocinador` VARCHAR(50), OUT `codCurso` INT)  BEGIN
INSERT INTO curso(`nombre`, `codPatrocinador`, `codTipoCurso`) VALUES (UPPER(nombre), UPPER(codPatrocinador), codTipoCurso);
SET codCurso = LAST_INSERT_ID();
END$$

DROP PROCEDURE IF EXISTS `insertModulo`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertModulo` (IN `nombre` VARCHAR(150), IN `uFormativa` VARCHAR(50), IN `duracion` INT, OUT `codModulo` INT)  BEGIN
INSERT INTO modulo(`nombre`, `uFormativa`, `duracion`) VALUES (UPPER(nombre),UPPER(uFormativa),duracion);
SET codModulo = LAST_INSERT_ID();
END$$

DROP PROCEDURE IF EXISTS `updateAlumno`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateAlumno` (IN `cAlumno` INT, IN `nombre` VARCHAR(150), IN `apellidos` VARCHAR(250), IN `dni_nie` VARCHAR(9), IN `fNacimiento` DATE, IN `email` VARCHAR(100), IN `telefono` VARCHAR(13), IN `codGenero` INT)  NO SQL
BEGIN
UPDATE `alumno` SET `nombre`=UPPER(nombre),
`apellidos`= UPPER(apellidos),
`dni_nie`=UPPER(dni_nie),
`fNacimiento`=fNacimiento,
`email`=UPPER(email),
`telefono`=UPPER(telefono),
`codGenero`=codGenero 
WHERE codAlumno = cAlumno;
END$$

DROP PROCEDURE IF EXISTS `updateCurso`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateCurso` (IN `codigo` INT, IN `nombre` VARCHAR(150), IN `codPatrocinador` VARCHAR(50), IN `codTipo` INT)  BEGIN
UPDATE curso SET `nombre`=UPPER(nombre),`codPatrocinador`=UPPER(codPatrocinador),`codTipoCurso`=codTipo WHERE codCurso = codigo;
END$$

DROP PROCEDURE IF EXISTS `updateModulo`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateModulo` (IN `nombre` VARCHAR(150), IN `uFormativa` VARCHAR(50), IN `duracion` INT, IN `codigo` INT)  BEGIN
UPDATE modulo SET `nombre`=UPPER(nombre),`uFormativa`=UPPER(uFormativa),`duracion`=duracion WHERE codModulo = codigo;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--
-- Creación: 21-07-2016 a las 09:01:16
--

DROP TABLE IF EXISTS `alumno`;
CREATE TABLE `alumno` (
  `codAlumno` int(11) NOT NULL COMMENT 'Indice del alumno',
  `nombre` varchar(150) NOT NULL COMMENT 'Nombre del alumno',
  `apellidos` varchar(250) NOT NULL COMMENT 'Apellidos del alumno',
  `dni_nie` varchar(9) NOT NULL COMMENT 'Documento de identificacion del alumno',
  `fNacimiento` date NOT NULL COMMENT 'Fecha de nacimiento del alumno',
  `email` varchar(100) NOT NULL,
  `telefono` varchar(13) NOT NULL,
  `codGenero` int(11) NOT NULL COMMENT 'Codigo de genero'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Truncar tablas antes de insertar `alumno`
--

TRUNCATE TABLE `alumno`;
--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`codAlumno`, `nombre`, `apellidos`, `dni_nie`, `fNacimiento`, `email`, `telefono`, `codGenero`) VALUES
(11, 'BORJA', 'GARDUÑO SANTAMARIA', '16068603K', '2016-07-21', 'BORJA.GARDUNO@HOTMAIL.COM', '622719088', 1),
(12, 'JOSU', 'ROJAS MENDEZ', '87654321X', '2016-07-21', 'JOSU@HOTMAIL.COM', '655888777', 1),
(13, 'CLAUDIA', 'ROJAS MENDEZ', '44445555Z', '2016-07-21', 'CLAUDIA@HOTMAIL.COM', '655888777', 3),
(14, 'RUBEN', 'FONSECA SANTAMARIA', '12345678Z', '2016-07-22', 'RUBEN@HOTMAIL.COM', '655888777', 1),
(15, 'Alumno', 'Sin apuntar', '00000000Z', '1900-01-01', 'xxx@xxxxxx.xxx', '+34XXXXXXXXX', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calificacion`
--
-- Creación: 21-07-2016 a las 09:01:17
--

DROP TABLE IF EXISTS `calificacion`;
CREATE TABLE `calificacion` (
  `codAlumno` int(11) NOT NULL,
  `codCurso` int(11) NOT NULL,
  `codModulo` int(11) NOT NULL,
  `nota` int(11) NOT NULL,
  `fExamen` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Truncar tablas antes de insertar `calificacion`
--

TRUNCATE TABLE `calificacion`;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--
-- Creación: 21-07-2016 a las 09:01:18
--

DROP TABLE IF EXISTS `curso`;
CREATE TABLE `curso` (
  `codCurso` int(11) NOT NULL COMMENT 'Codigo de curso',
  `nombre` varchar(150) NOT NULL COMMENT 'Nombre del curso',
  `codPatrocinador` varchar(50) NOT NULL COMMENT 'Referencia del curso',
  `codTipoCurso` int(11) NOT NULL COMMENT 'Codigo del tipo de curso'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Truncar tablas antes de insertar `curso`
--

TRUNCATE TABLE `curso`;
--
-- Volcado de datos para la tabla `curso`
--

INSERT INTO `curso` (`codCurso`, `nombre`, `codPatrocinador`, `codTipoCurso`) VALUES
(4, 'DESARROLLO DE APLICACIONES CON TECNOLOGÍAS WEB JAVA / ASP.NET', '101', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso_emision`
--
-- Creación: 22-07-2016 a las 09:29:04
--

DROP TABLE IF EXISTS `curso_emision`;
CREATE TABLE `curso_emision` (
  `codigo` int(11) NOT NULL COMMENT 'Codigo de alumno',
  `codCurso` int(11) NOT NULL COMMENT 'Codigo de curso',
  `referencia` varchar(50) NOT NULL,
  `fInicio` date NOT NULL COMMENT 'Fecha de inicio',
  `fFin` date DEFAULT NULL COMMENT 'Fecha fin'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Truncar tablas antes de insertar `curso_emision`
--

TRUNCATE TABLE `curso_emision`;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--
-- Creación: 21-07-2016 a las 09:01:19
--

DROP TABLE IF EXISTS `genero`;
CREATE TABLE `genero` (
  `codGenero` int(11) NOT NULL COMMENT 'Codigo de genero',
  `nombre` varchar(50) NOT NULL COMMENT 'Nombre de genero'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Truncar tablas antes de insertar `genero`
--

TRUNCATE TABLE `genero`;
--
-- Volcado de datos para la tabla `genero`
--

INSERT INTO `genero` (`codGenero`, `nombre`) VALUES
(1, 'Masculino'),
(2, 'Femenino'),
(3, 'Otro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modulo`
--
-- Creación: 21-07-2016 a las 09:01:20
--

DROP TABLE IF EXISTS `modulo`;
CREATE TABLE `modulo` (
  `codModulo` int(11) NOT NULL COMMENT 'Codigo de modulo',
  `nombre` varchar(150) NOT NULL COMMENT 'Nombre del modulo',
  `uFormativa` varchar(50) NOT NULL COMMENT 'Unidad formativa del modulo',
  `duracion` int(11) NOT NULL COMMENT 'Duracion del modulo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Truncar tablas antes de insertar `modulo`
--

TRUNCATE TABLE `modulo`;
--
-- Volcado de datos para la tabla `modulo`
--

INSERT INTO `modulo` (`codModulo`, `nombre`, `uFormativa`, `duracion`) VALUES
(1, 'DESARROLLO DE APLICACIONES WEB JAVA / C SHARP', '101', 20),
(2, 'BASES DE DATOS', '102', 45),
(5, 'INGLES TECNICO', '104', 20),
(8, 'Modulo sin especificar', 'No asignada', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipocurso`
--
-- Creación: 21-07-2016 a las 09:01:21
--

DROP TABLE IF EXISTS `tipocurso`;
CREATE TABLE `tipocurso` (
  `codTipoCurso` int(11) NOT NULL COMMENT 'Codigo del tipo de curso',
  `nombre` varchar(50) NOT NULL COMMENT 'Nombre del tipo de curso'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Truncar tablas antes de insertar `tipocurso`
--

TRUNCATE TABLE `tipocurso`;
--
-- Volcado de datos para la tabla `tipocurso`
--

INSERT INTO `tipocurso` (`codTipoCurso`, `nombre`) VALUES
(1, 'Lanbide'),
(2, 'Hobetuz'),
(3, 'Fundacion Tripartita');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`codAlumno`),
  ADD UNIQUE KEY `dni-nie` (`dni_nie`),
  ADD KEY `codGenero` (`codGenero`);

--
-- Indices de la tabla `calificacion`
--
ALTER TABLE `calificacion`
  ADD PRIMARY KEY (`codAlumno`,`codCurso`,`codModulo`),
  ADD KEY `fk_calificacion_curso` (`codCurso`),
  ADD KEY `fk_calificacion_modulo` (`codModulo`);

--
-- Indices de la tabla `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`codCurso`),
  ADD KEY `codTipoCurso` (`codTipoCurso`);

--
-- Indices de la tabla `curso_emision`
--
ALTER TABLE `curso_emision`
  ADD PRIMARY KEY (`codigo`) USING BTREE,
  ADD UNIQUE KEY `referencia` (`referencia`),
  ADD KEY `fk_cursoAlumno_curso` (`codCurso`);

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`codGenero`);

--
-- Indices de la tabla `modulo`
--
ALTER TABLE `modulo`
  ADD PRIMARY KEY (`codModulo`);

--
-- Indices de la tabla `tipocurso`
--
ALTER TABLE `tipocurso`
  ADD PRIMARY KEY (`codTipoCurso`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `codAlumno` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Indice del alumno', AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT de la tabla `curso`
--
ALTER TABLE `curso`
  MODIFY `codCurso` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Codigo de curso', AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `genero`
--
ALTER TABLE `genero`
  MODIFY `codGenero` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Codigo de genero', AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `modulo`
--
ALTER TABLE `modulo`
  MODIFY `codModulo` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Codigo de modulo', AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `tipocurso`
--
ALTER TABLE `tipocurso`
  MODIFY `codTipoCurso` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Codigo del tipo de curso', AUTO_INCREMENT=4;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD CONSTRAINT `fk_alumno_genero` FOREIGN KEY (`codGenero`) REFERENCES `genero` (`codGenero`);

--
-- Filtros para la tabla `calificacion`
--
ALTER TABLE `calificacion`
  ADD CONSTRAINT `fk_calificacion_alumno` FOREIGN KEY (`codAlumno`) REFERENCES `alumno` (`codAlumno`),
  ADD CONSTRAINT `fk_calificacion_curso` FOREIGN KEY (`codCurso`) REFERENCES `curso` (`codCurso`),
  ADD CONSTRAINT `fk_calificacion_modulo` FOREIGN KEY (`codModulo`) REFERENCES `modulo` (`codModulo`);

--
-- Filtros para la tabla `curso`
--
ALTER TABLE `curso`
  ADD CONSTRAINT `fk_curso_tipocurso` FOREIGN KEY (`codTipoCurso`) REFERENCES `tipocurso` (`codTipoCurso`);

--
-- Filtros para la tabla `curso_emision`
--
ALTER TABLE `curso_emision`
  ADD CONSTRAINT `fk_cursoAlumno_alumno` FOREIGN KEY (`codigo`) REFERENCES `alumno` (`codAlumno`),
  ADD CONSTRAINT `fk_cursoAlumno_curso` FOREIGN KEY (`codCurso`) REFERENCES `curso` (`codCurso`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
