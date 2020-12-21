-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 13-12-2020 a las 22:50:48
-- Versión del servidor: 8.0.18
-- Versión de PHP: 7.3.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdpanaderia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `rut` varchar(15) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `nombre` varchar(30) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `apellido` varchar(30) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `fono` varchar(20) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `direccion` varchar(50) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`rut`, `nombre`, `apellido`, `fono`, `direccion`) VALUES
('14.421.123-3', 'Eric', 'Rodrigez', '+56 9 4313 3333', 'Arlegui 852, Viña del Mar'),
('20.174.520-9', 'Nicolas', 'Parra', '+56 9 8498 3577', 'Dresden 17, Villa Berlin, Valparaiso'),
('21.007.423-6', 'Tito', 'Bacoa', '+56 9 3123 4122', 'Av. Siempre Viva 123, Springfield');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `numero` int(11) NOT NULL,
  `rutCliente` varchar(15) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `descripcion` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `estado` varchar(15) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`numero`, `rutCliente`, `descripcion`, `estado`) VALUES
(111, '20.174.520-9', 'oasomomas\nasomaosma', 'Cancelado'),
(421, '14.421.123-3', 'qqqqqqqqqqqqqqqqqq sssssssssss\nasssss sadamsom  asmosmd\n\nasasmasmoamsoams osmdoamsdaosd', 'Listo'),
(555, '14.421.123-3', 'omascomsamommocmoaoasc\nasmoasmsaasmoasmos\nasoasomasomsoas\nomomaasaaaaaaaaaaa', 'Pendiente'),
(1243, '20.174.520-9', 'sadadadsadasdas', 'Listo'),
(2144, '21.007.423-6', '---- uwu ----', 'Pendiente'),
(2911, '21.007.423-6', 'osamosamo momasmosaoasm\n\noamsoamsa aomsodmosdmoasmdaso asmdo\nsomadoasmdoamso samdoamdsaomdoasmosm', 'Cancelado'),
(33312, '20.174.520-9', 'MODIFICADO', 'Pendiente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `codigo` varchar(8) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `tipo` varchar(20) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `precio` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `stockCritico` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`codigo`, `nombre`, `tipo`, `precio`, `stock`, `stockCritico`) VALUES
('12345678', 'Baguette', 'Pan', 900, 30, 10),
('661wsqq', 'Brazo de Reina', 'Pastel', 7000, 25, 5),
('87654321', 'Torta de Merengue', 'Pastel', 10000, 15, 5),
('asmoaa11', 'Tartaleta de Frutilla', 'Pastel', 7200, 20, 4),
('insa12nn', 'Marraqueta', 'Pan', 1300, 100, 30),
('OM12msQQ', 'Pan de centeno', 'Pan', 2000, 15, 10),
('on12ee41', 'Hallulla', 'Pan', 900, 95, 32),
('PA1wsaMM', 'Pie de Limón', 'Pastel', 6000, 23, 4),
('PMVO1444', 'Pan de molde', 'Pan', 1700, 45, 12);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`rut`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `fk_rutCliente` (`rutCliente`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`codigo`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `fk_rutCliente` FOREIGN KEY (`rutCliente`) REFERENCES `clientes` (`rut`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
