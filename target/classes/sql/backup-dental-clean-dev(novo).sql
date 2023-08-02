-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.6.12-MariaDB-0ubuntu0.22.04.1 - Ubuntu 22.04
-- OS do Servidor:               debian-linux-gnu
-- HeidiSQL Versão:              12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Copiando dados para a tabela dentalclean_dev.dentista: 13 rows
/*!40000 ALTER TABLE `dentista` DISABLE KEYS */;
REPLACE INTO `dentista` (`id`, `cro`, `bairro`, `cidade`, `cpf`, `data_nascimento`, `email`, `especialidade`, `estado`, `nao_deletado`, `nome_completo`, `numero`, `rua`, `telefone_celular`, `telefone_residencial`) VALUES
	(1, '9878', 'Colinas Ducattas', 'São Gerônimo', '654,897,955-85', '1980-06-18', 'rogerio.p@mail.com', 'Cirurgia', 'SP', b'1', 'Rogério Mattos', 230, 'Alfeneiros', '(11) 9 4568-4005', '(11) 3548-7471'),
	(2, '1897', 'Bairro Petrópolis', 'Cidade São Bento', '568.665.201-05', '1970-08-21', 'b.z@email.com', 'Prótese Dentária', 'SP', b'1', 'Bernardo Zancuzo', 1048, 'Miguel Salazar', '(11) 96658-0015', '(11) 35497-0005'),
	(3, '8467', 'Nova Cascaca', 'Cidade Monte Verde', '945.467.015.49', '1992-05-17', 'f.souza@email.com', 'Cirurgia', 'RO', b'1', 'Fernando Souza', 1648, 'Cicero Meirelles', '(11) 96479-7988', '(11) 2895-4677'),
	(4, '5648', 'Nova Alvorada', 'São Paulo', '56499862547', '1988-05-14', 'bento.santos@mail.com', 'Clínico', 'SP', b'1', 'Bento dos Santos', 456, '15 de Julho', '(11)9 7458-2215', '(11)3365-8841'),
	(5, '7425', 'Cidade Verde', 'São Sebastião', '686.201.478-40', '1977-06-25', 'eduardo.p@mail.com', 'Odontologia Estética', 'SP', b'1', 'Eduardo Costa Pereira', 1580, 'Avenida das Estrelas Cadentes', '(11) 96789-0123', '(11) 7890-1234'),
	(6, '1445', 'Parque dos Sonhos', 'Santos', '012.320.478-44', '1979-12-08', 'camila.almeida33@mail.com', 'Periodontia', 'SP', b'1', 'Camila Almeida Rodrigues', 2000, 'Travessa das Violetas Silvestres', '(11) 96789-0123', '(11) 6789-0123'),
	(7, '3000', 'Residencial Primavera', 'São Paulo', '510.659.887-74', '1980-02-29', 'felp.rocha@mail.com', 'Endodontia', 'SP', b'1', 'Felipe Rocha', 800, 'Praça das Miragens Douradas', '(11) 95678-9012', '(11) 5678-9012'),
	(8, '6655', 'Nova Esperança', 'São Paulo', '610.658.448-77', '1981-07-17', 'isabela.costa@mail.com', 'Odontopediatria', 'SP', b'1', 'Isabela Costa', 300, 'Rua das Esmeraldas Luminescentes', '(11) 94567-8901', '(11) 4567-8901'),
	(9, '9858', 'Bosque Encantado', 'São Paulo', '741.021.858-10', '1983-11-03', 'dr.rodrigo_s@mail.com', 'Cirurgia Bucomaxilofacial', 'SP', b'1', 'Rodrigo Santos', 25, 'Rua das Magnólias Encantadas', '(11) 93456-7890', '(11) 3456-7890'),
	(10, '4514', 'Vila Serenidade', 'São Paulo', '421.021.320-44', '1984-09-22', 'sofi35@mail.com', 'Ortodontia', 'SP', b'1', 'Sofia Oliveira', 1010, 'Avenida dos Quatro Ventos', '(11) 92345-6789', '(11) 2345-6789'),
	(11, '5648', 'Jardim das Flores', 'São Paulo', '894.847.669-52', '1986-05-10', 'lucas.m2020@mail.com', 'Ortodontia', 'SP', b'1', 'Lucas Mendes', 50, 'Rua das Flores', '(11) 91234-5678', '(11) 2234-5678'),
	(12, '8541', 'Bairro das Estrelas', 'São Paulo', '505.141.025-88', '1976-08-14', 'gabriela.lima@mail.com', 'Dentística', 'SP', b'1', 'Gabriela Santos Lima', 62, 'Rua do Bosque', '(11) 98901-2345', '(11) 8901-2345'),
	(13, '9800', 'Nova Fonta', 'Cidade Monte Verde Guari', '854.598.788-44', '1982-05-17', 'b.souza@email.com', 'Ortodontia', 'SP', b'1', 'Bruno Souza', 18, 'Alfarat Shaquin', '(11) 92687-1690', '(11) 3548-1880');
/*!40000 ALTER TABLE `dentista` ENABLE KEYS */;

-- Copiando dados para a tabela dentalclean_dev.paciente: 12 rows
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
REPLACE INTO `paciente` (`id`, `bairro`, `cidade`, `convenio`, `data_nascimento`, `email`, `estado`, `genero`, `nao_deletado`, `nome_completo`, `numero`, `numero_carteirinha`, `rua`) VALUES
	(1, 'Vila do Tijolo', 'São Paulo', 'Amil Dental', '1988-05-22', 'bruno.inco@mail.com', 'SP', 'Masculino', b'1', 'Bruno Fernandes dos Santos', 40, 1, 'Jucelino Bill'),
	(2, 'Vila do Tijolo', 'São Paulo', 'Amil Dental', '1988-05-22', 'bruno.inco@mail.com', 'SP', 'Masculino', b'1', 'Cascavel dos Santos', 40, 13548, 'Jucelino Bill'),
	(3, 'Vila do Tijolo', 'São Paulo', 'Prodent', '1977-03-13', 'i_mattos.inco@mail.com', 'SP', 'Masculino', b'1', 'Irieo Mattos dos Santos', 40, 568900, 'Prudente de Moraes'),
	(4, 'Jardim das Rosas', 'São Paulo ', 'Amil Dental', '2008-06-12', 'luquinhas.12@mail.com', 'SP', 'Masculino', b'1', 'Lucas Mendes de Almeida', 123, 45816795, 'Rua das Acácias'),
	(5, 'Vila Esperança', 'São Paulo ', 'Bradesco Dental', '2007-09-25', 'pedro.salva@mail.com', 'SP', 'Masculino', b'1', 'Pedro Silva de Oliveira', 456, 65482301, 'Avenida dos Ipês'),
	(6, 'Parque dos Sonhos', 'São Paulo', 'SulAmérica Odonto', '2006-11-03', 'costa.2020@mail.com', 'SP', 'Masculino', b'1', 'Gabriel Costa dos Santos', 789, 94563201, 'Travessa das Margaridas'),
	(7, 'Vila Sereno', 'São Paulo', 'Interodonto', '2005-12-18', 'joao.pereira@mail.com', 'SP', 'Masculino', b'1', 'João Pereira da Silva', 321, 48924056, 'Praça das Oliveiras'),
	(8, 'Jardim das Flores', 'São Paulo ', 'Prodent', '2004-03-09', 'aninha18@mail.com', 'SP', 'Feminino', b'1', 'Ana Santos de Almeida', 987, 40125498, 'Rua dos Jasmins'),
	(9, 'Nova Esperança', 'São Paulo ', 'Bradesco Dental', '2003-05-22', 'mari_santos@mail.com', 'SP', 'Feminino', b'1', 'Maria Oliveira da Costa', 654, 48610456, 'Alameda dos Lírios'),
	(10, 'Parque das Águas', 'São Paulo ', 'Prodent', '2002-08-14', 'sofi2020@mail.com', 'SP', 'Feminino', b'1', 'Sofia Lima Pereira dos Santos', 147, 45924967, 'Avenida das Violetas'),
	(11, 'Vila Primavera', 'São Paulo', 'Dental Uni', '2001-10-27', 'isabela_lima88@mail.com', 'SP', 'Feminino', b'1', 'Isabella Costa Silva de Lima', 753, 51564897, 'Rua das Orquídeas'),
	(12, 'Vila Tupinamba', 'São Paulo', 'Prodent', '1987-03-13', 'benedito.inco@mail.com', 'SP', 'Masculino', b'1', 'Benedito Clǘis', 400, 654874, 'Das Pombas');
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;

-- Copiando dados para a tabela dentalclean_dev.usuario: 4 rows
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
REPLACE INTO `usuario` (`id`, `email`, `nao_deletado`, `senha`, `usuario`) VALUES
	(1, 'admin@mail.com', b'1', 'admin', 'Administrador'),
	(2, 'brunus@mail.com', b'1', 'bru123', 'bruno'),
	(3, 'carlinhos@mail.com', b'1', 'car_01010', 'carlos'),
	(4, 'monica@mail.com', b'0', 'momo2', 'monicaoDB');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
