-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-07-2016 a las 13:24:58
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 5.6.23

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
DROP PROCEDURE IF EXISTS `getALLEmpleado`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getALLEmpleado` ()  NO SQL
SELECT codigo_empleado, nombre, apellidos FROM empleados$$

DROP PROCEDURE IF EXISTS `getIDEmpleado`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getIDEmpleado` (IN `id` INT)  NO SQL
SELECT codigo_empleado, e.nombre AS 'nEmpleado', apellidos, dni, fechaNacimiento, fechaContratacion, numeroSeguridadSocial, CuentaCorriente, direccion, localidad, codigoPostal, d.nombre AS 'nDepartamento' FROM empleados e INNER JOIN departamentos d ON d.codigo_dpto = e.codigo_dpto WHERE e.codigo_empleado = id$$

DROP PROCEDURE IF EXISTS `updateEmpleado`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateEmpleado` (IN `nombre` VARCHAR(150), IN `codigo` INT(15))  NO SQL
UPDATE `empleados` SET `fechaNacimiento`=LOWER(fechaNacimiento),`fechaContratacion`=LOWER(fechaContratacion),`nombre`=LOWER(nombre),`apellidos`=LOWER(apellidos),`numeroSeguridadSocial`=LOWER(numeroSeguridadSocial),`CuentaCorriente`=LOWER(CuentaCorriente),`direccion`=LOWER(direccion),`localidad`=LOWER(localidad),`codigoPostal`=LOWER(codigoPostal),`dni`=LOWER(dni),`codigo_dpto`= LOWER(codigo_dpto) WHERE `codigo_empleado` = codigo$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamentos`
--

DROP TABLE IF EXISTS `departamentos`;
CREATE TABLE IF NOT EXISTS `departamentos` (
  `codigo_dpto` int(11) NOT NULL COMMENT 'Codigo del departamento',
  `nombre` varchar(150) NOT NULL COMMENT 'Nombre del departamento',
  `descripcion` varchar(200) NOT NULL COMMENT 'Descipcion del departamento',
  PRIMARY KEY (`codigo_dpto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Truncar tablas antes de insertar `departamentos`
--

TRUNCATE TABLE `departamentos`;
--
-- Volcado de datos para la tabla `departamentos`
--

INSERT INTO `departamentos` (`codigo_dpto`, `nombre`, `descripcion`) VALUES
(1, 'Informatica', 'Departamento de informatica'),
(2, 'Administracion', 'Departamento Administracion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

DROP TABLE IF EXISTS `empleados`;
CREATE TABLE IF NOT EXISTS `empleados` (
  `codigo_empleado` int(11) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `fechaContratacion` date NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `apellidos` varchar(150) NOT NULL,
  `numeroSeguridadSocial` varchar(12) NOT NULL,
  `CuentaCorriente` varchar(20) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `localidad` varchar(150) NOT NULL,
  `codigoPostal` int(5) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `codigo_dpto` int(11) NOT NULL,
  PRIMARY KEY (`codigo_empleado`),
  KEY `codigo_dpto` (`codigo_dpto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Truncar tablas antes de insertar `empleados`
--

TRUNCATE TABLE `empleados`;
--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`codigo_empleado`, `fechaNacimiento`, `fechaContratacion`, `nombre`, `apellidos`, `numeroSeguridadSocial`, `CuentaCorriente`, `direccion`, `localidad`, `codigoPostal`, `dni`, `codigo_dpto`) VALUES
(1, '2016-07-10', '2016-07-13', 'julen', 'rodriguez costa', '123456789123', '12345678912345678912', 'bizkai', 'galdakao', 48960, '45622967y', 1),
(2, '2016-07-01', '2016-07-09', 'empleado', 'numero 2', '123123123123', '12345678912345678913', 'kalea', 'usansolo', 48962, '78955632t', 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`codigo_dpto`) REFERENCES `departamentos` (`codigo_dpto`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
