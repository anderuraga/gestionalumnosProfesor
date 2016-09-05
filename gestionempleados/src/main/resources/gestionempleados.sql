-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-07-2016 a las 12:33:51
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

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`usuario`@`%` PROCEDURE `deleteDepartamento` (IN `codDep` INT)  NO SQL
DELETE FROM departamento
where codigo = codDep$$

CREATE DEFINER=`usuario`@`%` PROCEDURE `deleteEmpleado` (IN `codEmp` INT)  NO SQL
DELETE FROM empleado 
where codigo = codEmp$$

CREATE DEFINER=`usuario`@`%` PROCEDURE `getAllEmpleado` ()  NO SQL
SELECT e.fechaNacimiento,e.fechaContratacion,e.nombre as nombreEmp, e.apellidos, e.numSS,e.cc,e.direccion,e.localidad,e.cp,e.dni, d.nombre as nombreDep
FROM empleado e
	INNER JOIN departamento d ON e.codDep=d.codigo$$

CREATE DEFINER=`usuario`@`%` PROCEDURE `insertDepartamento` (OUT `codigo` INT, IN `nombreDep` VARCHAR(100), IN `descrip` VARCHAR(300))  NO SQL
BEGIN

INSERT INTO departamento (nombre,descripcion)
VALUES(nombreDep,descrip);

SET codigo = LAST_INSERT_ID();

END$$

CREATE DEFINER=`usuario`@`%` PROCEDURE `insertEmpleado` (OUT `codigo` INT, IN `nombre` VARCHAR(100), IN `apellidos` VARCHAR(200), IN `dni` VARCHAR(9), IN `cc` VARCHAR(20), IN `cp` VARCHAR(5), IN `ss` VARCHAR(15), IN `dir` INT(200), IN `loc` INT(100), IN `fContrato` DATE, IN `fNacim` DATE, IN `codigoDep` INT)  NO SQL
BEGIN

INSERT INTO empleado (fechaNacimiento,fechaContratacion,nombre, apellidos, numSS,cc, direccion, localidad, cp, dni, codDep)
VALUES(fNacim,fContrato,nombre,apellidos,ss,cc,dir,loc,cp,dni,codigoDep);

SET codigo = LAST_INSERT_ID();

END$$

CREATE DEFINER=`usuario`@`%` PROCEDURE `updateDepartamento` (IN `codigoDep` INT, IN `nombre` VARCHAR(200), IN `descrip` VARCHAR(300))  NO SQL
UPDATE departamento d
SET 
nombre=lower(nombre),
descripcion=lower(descrip)

WHERE d.codigo=codigoDep$$

CREATE DEFINER=`usuario`@`%` PROCEDURE `updateEmpleado` (IN `codigoEmp` INT, IN `nombre` VARCHAR(150), IN `apellidos` VARCHAR(150), IN `dni` VARCHAR(9), IN `fNacimiento` DATE, IN `fContrato` DATE, IN `cp` VARCHAR(5), IN `cc` VARCHAR(20), IN `numSS` VARCHAR(15), IN `dir` VARCHAR(200), IN `loc` VARCHAR(150), IN `codigoDep` INT)  NO SQL
UPDATE empleado e
SET 
nombre=lower(nombre),
apellidos=lower(apellidos),
dni=lower(dni),
fechaNacimiento=fNacimiento,
fechaContratacion=fContrato,
cp=cp,
cc=cc,
numSS=numSS,
direccion=dir, 
localidad=loc,
codDep=codigoDep
WHERE e.codigo=codigoEmp$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

CREATE TABLE `departamento` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `departamento`
--

INSERT INTO `departamento` (`codigo`, `nombre`, `descripcion`) VALUES
(0, 'desarrollo', 'djbuidafgibf');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `codigo` int(11) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `fechaContratacion` date NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(200) NOT NULL,
  `numSS` varchar(10) NOT NULL,
  `cc` varchar(22) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `localidad` varchar(50) NOT NULL,
  `cp` varchar(5) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `codDep` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`codigo`, `fechaNacimiento`, `fechaContratacion`, `nombre`, `apellidos`, `numSS`, `cc`, `direccion`, `localidad`, `cp`, `dni`, `codDep`) VALUES
(3, '0000-00-00', '0000-00-00', 'marta', 'rivera', '1', 'a', '1', '1', '1', '16087431n', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `codDep` (`codDep`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `fk_empleado_departamento` FOREIGN KEY (`codDep`) REFERENCES `departamento` (`codigo`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
