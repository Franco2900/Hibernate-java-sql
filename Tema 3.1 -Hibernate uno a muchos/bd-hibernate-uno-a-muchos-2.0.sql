-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bd-hibernate-uno-a-muchos-2.0
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bd-hibernate-uno-a-muchos-2.0
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bd-hibernate-uno-a-muchos-2.0` DEFAULT CHARACTER SET latin1 ;
USE `bd-hibernate-uno-a-muchos-2.0` ;

-- -----------------------------------------------------
-- Table `bd-hibernate-uno-a-muchos-2.0`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-uno-a-muchos-2.0`.`cliente` (
  `idCliente` INT(11) NOT NULL AUTO_INCREMENT,
  `apellido` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `dni` INT(11) NOT NULL,
  `fechaDeNacimiento` DATE NULL DEFAULT NULL,
  `baja` BIT(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd-hibernate-uno-a-muchos-2.0`.`prestamo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-uno-a-muchos-2.0`.`prestamo` (
  `idPrestamo` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `monto` DOUBLE NOT NULL,
  `interes` DOUBLE NOT NULL,
  `cantCuotas` INT(11) NOT NULL,
  `idCliente` INT(11) NOT NULL,
  PRIMARY KEY (`idPrestamo`),
  INDEX `fkCliente_idx` (`idCliente` ASC) VISIBLE,
  CONSTRAINT `fkCliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `bd-hibernate-uno-a-muchos-2.0`.`cliente` (`idCliente`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd-hibernate-uno-a-muchos-2.0`.`Cuota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-uno-a-muchos-2.0`.`Cuota` (
  `nroCuota` INT NOT NULL AUTO_INCREMENT,
  `fechaVencimiento` DATE NOT NULL,
  `saldoPendiente` DOUBLE NOT NULL,
  `amortizacion` DOUBLE NOT NULL,
  `interesCuota` DOUBLE NOT NULL,
  `cuota` DOUBLE NOT NULL,
  `deuda` DOUBLE NOT NULL,
  `cancelada` BIT(1) NOT NULL,
  `fechaDePago` DATE NOT NULL,
  `punitorios` DOUBLE NOT NULL,
  `idPrestamo` INT(11) NOT NULL,
  PRIMARY KEY (`nroCuota`),
  INDEX `fk_Cuota_prestamo1_idx` (`idPrestamo` ASC) VISIBLE,
  CONSTRAINT `fk_Cuota_prestamo1`
    FOREIGN KEY (`idPrestamo`)
    REFERENCES `bd-hibernate-uno-a-muchos-2.0`.`prestamo` (`idPrestamo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
