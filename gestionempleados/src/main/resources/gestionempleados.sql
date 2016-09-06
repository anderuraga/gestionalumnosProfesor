-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-07-2016 a las 13:21:25
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestionempleados`
--
CREATE DATABASE IF NOT EXISTS `gestionempleados` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `gestionempleados`;

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `deleteDepartamento`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteDepartamento` (IN `codDepartamento` INT)  NO SQL
DELETE FROM departamento 
WHERE codDepartamento = codigo$$

DROP PROCEDURE IF EXISTS `deleteEmpleado`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteEmpleado` (IN `codEmpleado` INT(11))  NO SQL
DELETE FROM empleado 
WHERE codEmpleado = codigo$$

DROP PROCEDURE IF EXISTS `getAllDepartamento`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllDepartamento` ()  NO SQL
SELECT codigo, nombre, descripcion
FROM departamento$$

DROP PROCEDURE IF EXISTS `getAllEmpleado`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllEmpleado` ()  NO SQL
SELECT codigo, nombre, apellidos, dni, fechaNacimiento, fechaContratacion, numeroSS, cuentaCorriente, direccion, localidad, codigoPostal, codigoDepartamento
FROM empleado$$

DROP PROCEDURE IF EXISTS `insertDepartamento`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertDepartamento` (IN `nombre` VARCHAR(100), IN `descripcion` VARCHAR(250), OUT `codDepartamento` INT(11))  NO SQL
BEGIN
INSERT INTO departamento (nombre, descripcion)
VALUES(UPPER(nombre), UPPER(descripcion));

SET codDepartamento = LAST_INSERT_ID();

END$$

DROP PROCEDURE IF EXISTS `insertEmpleado`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertEmpleado` (IN `nombre` VARCHAR(100), IN `apellidos` VARCHAR(150), IN `dni` VARCHAR(9), IN `fechaNacimiento` DATE, IN `fechaContratacion` DATE, IN `numeroSS` INT(11), IN `cuentaCorriente` VARCHAR(24), IN `direccion` VARCHAR(100), IN `localidad` VARCHAR(50), IN `codigoPostal` VARCHAR(5), OUT `codEmpleado` INT(11), IN `codigoDepartamento` INT(11))  NO SQL
BEGIN
INSERT INTO empleado (nombre, apellidos, dni, fechaNacimiento, fechaContratacion, numeroSS, cuentaCorriente, direccion, localidad, codigoPostal, codigoDepartamento)
VALUES(UPPER(nombre), UPPER(apellidos), UPPER(dni), fechaNacimiento, fechaContratacion, numeroSS, UPPER(cuentaCorriente), UPPER(direccion), UPPER(localidad), codigoPostal, codigoDepartamento);

SET codEmpleado = LAST_INSERT_ID();

END$$

DROP PROCEDURE IF EXISTS `updateDepartamento`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateDepartamento` (IN `nombre` VARCHAR(100), IN `descripcion` INT(250), IN `codDepartamento` INT)  NO SQL
BEGIN
UPDATE `departamento` 
SET `nombre`= UPPER(nombre),
`descripcion`= UPPER(descripcion)
WHERE codigo = codDepartamento;
END$$

DROP PROCEDURE IF EXISTS `updateEmpleado`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateEmpleado` (IN `nombre` VARCHAR(100), IN `apellidos` VARCHAR(150), IN `dni` VARCHAR(9), IN `fechaNacimiento` DATE, IN `fechaContratacion` DATE, IN `numeroSS` INT(11), IN `direccion` VARCHAR(100), IN `localidad` VARCHAR(50), IN `codigoPostal` INT(5), IN `cuentaCorriente` VARCHAR(24), IN `codigoEmpleado` INT, IN `codigoDepartamento` INT)  NO SQL
BEGIN
UPDATE `empleado` 
SET `nombre`= UPPER(nombre),
`apellidos`= UPPER(apellidos),
`dni`=UPPER(dni),
`fechaNacimiento`=fechaNacimiento,
`fechaContratacion`=fechaContratacion,
`numeroSS`=numeroSS,
`cuentaCorriente`=UPPER(cuentaCorriente),
`direccion`=UPPER(direccion),
`localidad`=UPPER(localidad),
`codigoPostal`=codigoPostal,
`codigoDepartamento`=codigoDepartamento
WHERE codigo = codigoEmpleado;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--
-- Creación: 27-07-2016 a las 08:31:35
--

DROP TABLE IF EXISTS `departamento`;
CREATE TABLE IF NOT EXISTS `departamento` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- RELACIONES PARA LA TABLA `departamento`:
--

--
-- Truncar tablas antes de insertar `departamento`
--

TRUNCATE TABLE `departamento`;
--
-- Volcado de datos para la tabla `departamento`
--

INSERT INTO `departamento` (`codigo`, `nombre`, `descripcion`) VALUES
(2, 'PROGRAMACION', 'DEPARTAMENTO DE PROGRAMACION DE LOS PROYECTOS ASIGNADOS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--
-- Creación: 27-07-2016 a las 10:04:43
--

DROP TABLE IF EXISTS `empleado`;
CREATE TABLE IF NOT EXISTS `empleado` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `codigoDepartamento` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(150) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `fechaContratacion` date NOT NULL,
  `numeroSS` int(11) NOT NULL,
  `cuentaCorriente` varchar(24) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `localidad` varchar(50) NOT NULL,
  `codigoPostal` int(5) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `numeroSS` (`numeroSS`),
  UNIQUE KEY `dni` (`dni`),
  KEY `codigoDepartamento` (`codigoDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- RELACIONES PARA LA TABLA `empleado`:
--   `codigoDepartamento`
--       `departamento` -> `codigo`
--

--
-- Truncar tablas antes de insertar `empleado`
--

TRUNCATE TABLE `empleado`;
--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`codigo`, `codigoDepartamento`, `nombre`, `apellidos`, `dni`, `fechaNacimiento`, `fechaContratacion`, `numeroSS`, `cuentaCorriente`, `direccion`, `localidad`, `codigoPostal`) VALUES
(5, 2, 'BORJA', 'GARDUÑO SANTAMARIA', '16068603K', '1990-06-24', '2016-07-27', 1, '2', 'CALLE ALDAPA, N11, 2M', 'LEIOA', 48940);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `fk_empleado_departamento` FOREIGN KEY (`codigoDepartamento`) REFERENCES `departamento` (`codigo`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
