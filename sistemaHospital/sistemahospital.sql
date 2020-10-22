-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 16-Abr-2020 às 15:17
-- Versão do servidor: 10.1.36-MariaDB
-- versão do PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sistemahospital`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `consulta`
--

CREATE TABLE `consulta` (
  `id_consulta` bigint(20) NOT NULL,
  `dt_consulta` varchar(255) DEFAULT NULL,
  `especialista` varchar(255) DEFAULT NULL,
  `horario` varchar(255) DEFAULT NULL,
  `sintomas` varchar(255) DEFAULT NULL,
  `paciente_id_paciente` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `consulta`
--

INSERT INTO `consulta` (`id_consulta`, `dt_consulta`, `especialista`, `horario`, `sintomas`, `paciente_id_paciente`) VALUES
(1, '22/03/2020', 'Clínico Geral', '14:18', 'Gripe Forte', 8),
(33, '24/03/2020', 'Clínico Geral', '13:31', 'Resfriado', 10),
(34, '24/03/2020', 'Clínico Geral', '13:31', 'Gripe', 27);

-- --------------------------------------------------------

--
-- Estrutura da tabela `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(37),
(37);

-- --------------------------------------------------------

--
-- Estrutura da tabela `paciente`
--

CREATE TABLE `paciente` (
  `id_paciente` bigint(20) NOT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `idade` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `telefone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `paciente`
--

INSERT INTO `paciente` (`id_paciente`, `cpf`, `endereco`, `idade`, `nome`, `sexo`, `telefone`) VALUES
(8, '000.000.000-00', 'Rua A', '18', 'Mariazinha', 'Feminino', 40028922),
(10, '000.000.000-01', 'Rua B', '34', 'Xico', 'Masculino', 40028922),
(27, '000.000.000-03', 'Rua W', '10', 'Ricardo', 'Masculino', 40028922);

-- --------------------------------------------------------

--
-- Estrutura da tabela `paciente_consultas`
--

CREATE TABLE `paciente_consultas` (
  `paciente_id_paciente` bigint(20) NOT NULL,
  `consultas_id_consulta` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `paciente_consultas`
--

INSERT INTO `paciente_consultas` (`paciente_id_paciente`, `consultas_id_consulta`) VALUES
(10, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `role`
--

INSERT INTO `role` (`id`, `nome`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USUARIO'),
(3, 'ROLE_AVALIADOR');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL,
  `login` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `matricula` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `login`, `nome`, `senha`, `email`, `matricula`) VALUES
(1, 'nicole', 'Nicole', '$2y$12$6YcmioH3pSOqKFntf3ZlGuTAUoA.GeE9.dF3j3kpjm.6QzqNfeEzy', '', ''),
(2, 'yaritzza', 'Yaritzza', '$2y$12$6YcmioH3pSOqKFntf3ZlGuTAUoA.GeE9.dF3j3kpjm.6QzqNfeEzy', '', ''),
(3, 'lopim', 'Lopim', '$2y$12$6YcmioH3pSOqKFntf3ZlGuTAUoA.GeE9.dF3j3kpjm.6QzqNfeEzy', '', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario_roles`
--

CREATE TABLE `usuario_roles` (
  `usuario_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `usuario_roles`
--

INSERT INTO `usuario_roles` (`usuario_id`, `roles_id`) VALUES
(1, 1),
(2, 1),
(3, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `consulta`
--
ALTER TABLE `consulta`
  ADD PRIMARY KEY (`id_consulta`),
  ADD KEY `FKk2741b5is7nhkptkht0c3sgim` (`paciente_id_paciente`);

--
-- Indexes for table `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`id_paciente`);

--
-- Indexes for table `paciente_consultas`
--
ALTER TABLE `paciente_consultas`
  ADD UNIQUE KEY `UK_r0wapvp8q9siiq0h8fqnyrrbs` (`consultas_id_consulta`),
  ADD KEY `FK3sd5xkvaqn58kcbny3sjf6m67` (`paciente_id_paciente`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuario_roles`
--
ALTER TABLE `usuario_roles`
  ADD KEY `FKr5p0u8r15jjo6u7xr1928hsld` (`roles_id`),
  ADD KEY `FKqblnumndby0ftm4c7sg6uso6p` (`usuario_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `consulta`
--
ALTER TABLE `consulta`
  ADD CONSTRAINT `FKk2741b5is7nhkptkht0c3sgim` FOREIGN KEY (`paciente_id_paciente`) REFERENCES `paciente` (`id_paciente`);

--
-- Limitadores para a tabela `paciente_consultas`
--
ALTER TABLE `paciente_consultas`
  ADD CONSTRAINT `FK3sd5xkvaqn58kcbny3sjf6m67` FOREIGN KEY (`paciente_id_paciente`) REFERENCES `paciente` (`id_paciente`),
  ADD CONSTRAINT `FK7q6b8muou89nrbbaqweybnqu6` FOREIGN KEY (`consultas_id_consulta`) REFERENCES `consulta` (`id_consulta`);

--
-- Limitadores para a tabela `usuario_roles`
--
ALTER TABLE `usuario_roles`
  ADD CONSTRAINT `FKqblnumndby0ftm4c7sg6uso6p` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `FKr5p0u8r15jjo6u7xr1928hsld` FOREIGN KEY (`roles_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
