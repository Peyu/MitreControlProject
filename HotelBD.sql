SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `basereserva` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `basereserva` ;

-- -----------------------------------------------------
-- Table `basereserva`.`hotel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basereserva`.`hotel` (
  `habitacion` INT(4) NOT NULL,
  PRIMARY KEY (`habitacion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basereserva`.`empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basereserva`.`empresa` (
  `idempresa` INT NULL AUTO_INCREMENT,
  `razon_social` VARCHAR(100) NULL,
  `idtel_emp` INT NULL,
  `domicilio` VARCHAR(255) NULL,
  `resp_inscripto` TINYINT(1) NULL,
  `cuil_emp` VARCHAR(13) NOT NULL,
  UNIQUE INDEX `cuil_emp_UNIQUE` (`cuil_emp` ASC),
  UNIQUE INDEX `idempresa_UNIQUE` (`idempresa` ASC),
  PRIMARY KEY (`idempresa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basereserva`.`huesped`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basereserva`.`huesped` (
  `idhuesped` INT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(40) NOT NULL,
  `idempresa` INT NULL,
  `idtelefono` INT NULL,
  `mail` VARCHAR(35) NULL,
  `observaciones` VARCHAR(100) NULL,
  `vehiculo` VARCHAR(8) NULL,
  `idreserva` INT NULL,
  PRIMARY KEY (`idhuesped`),
  UNIQUE INDEX `idreserva_UNIQUE` (`idreserva` ASC),
  INDEX `fk_huesped_1_idx` (`idhuesped` ASC, `idempresa` ASC),
  CONSTRAINT `fk_huesped_1`
    FOREIGN KEY (`idhuesped` , `idempresa`)
    REFERENCES `basereserva`.`empresa` (`idempresa` , `idempresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basereserva`.`reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basereserva`.`reserva` (
  `idreserva` INT NOT NULL AUTO_INCREMENT COMMENT '	',
  `fecha_reserva` TIMESTAMP NULL,
  `fecha_ingreso` DATETIME NULL,
  `fecha_salida` DATETIME NULL,
  `estado` VARCHAR(20) NULL,
  `Oservaciones` VARCHAR(255) NULL,
  `idhuesped` INT NULL,
  `proveedor` VARCHAR(45) NULL,
  `importe_pagado` DECIMAL NULL,
  `numero_hab` INT(4) NOT NULL,
  PRIMARY KEY (`idreserva`),
  UNIQUE INDEX `idreserva_UNIQUE` (`idreserva` ASC),
  INDEX `fk_reserva_1_idx` (`idhuesped` ASC),
  CONSTRAINT `fk_reserva_1`
    FOREIGN KEY (`idhuesped`)
    REFERENCES `basereserva`.`huesped` (`idhuesped`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basereserva`.`habitacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basereserva`.`habitacion` (
  `numero_hab` INT(4) NOT NULL,
  `descripcion` VARCHAR(255) NULL,
  `estado` VARCHAR(15) NOT NULL,
  `tipo` VARCHAR(20) NOT NULL,
  `capacidad` INT(1) NOT NULL,
  `precio` DECIMAL NOT NULL,
  CONSTRAINT `fk_habitacion_2`
    FOREIGN KEY (`numero_hab`)
    REFERENCES `basereserva`.`hotel` (`habitacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_habitacion_1`
    FOREIGN KEY (`numero_hab`)
    REFERENCES `basereserva`.`reserva` (`idreserva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basereserva`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basereserva`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `rol` INT(2) NULL COMMENT '	',
  `password` VARCHAR(8) NULL,
  `tipo` VARCHAR(45) NULL,
  PRIMARY KEY (`idusuario`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basereserva`.`telefono`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basereserva`.`telefono` (
  `idtelefono` INT NOT NULL AUTO_INCREMENT,
  `idhuesped` INT NOT NULL,
  `numero` INT(12) NULL,
  PRIMARY KEY (`idtelefono`, `idhuesped`),
  UNIQUE INDEX `idtelefono_UNIQUE` (`idtelefono` ASC),
  CONSTRAINT `fk_telefono_1`
    FOREIGN KEY (`idtelefono` , `idhuesped`)
    REFERENCES `basereserva`.`huesped` (`idhuesped` , `idhuesped`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basereserva`.`caja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basereserva`.`caja` (
  `fecha_caja` DATETIME NOT NULL,
  `turno` VARCHAR(1) NOT NULL COMMENT 'M = mañana\nT = tarde\nN = noche',
  `saldo_inicial` DECIMAL NULL COMMENT '	',
  `ss_catering` DECIMAL NULL,
  `transporte` DECIMAL NULL,
  PRIMARY KEY (`fecha_caja`, `turno`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basereserva`.`factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basereserva`.`factura` (
  `nro_factura` INT NOT NULL,
  `tipo_factura` VARCHAR(1) NOT NULL COMMENT 'Nro factura +tipo= pk\nEj: Factura B 1234',
  `fecha_caja` DATETIME NOT NULL,
  `turno` VARCHAR(1) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `nro_habitacion` INT(4) NULL COMMENT 'puede no tener\nnro hab si es un\nconsumo restaurant',
  PRIMARY KEY (`nro_factura`, `tipo_factura`),
  INDEX `fk_factura_1_idx` (`fecha_caja` ASC, `turno` ASC),
  CONSTRAINT `fk_factura_1`
    FOREIGN KEY (`fecha_caja` , `turno`)
    REFERENCES `basereserva`.`caja` (`fecha_caja` , `turno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basereserva`.`Alojamiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basereserva`.`Alojamiento` (
  `monto` DECIMAL NULL,
  `nro_factura` INT NOT NULL,
  `tipo_factura` VARCHAR(1) NOT NULL,
  INDEX `fk_Alojamiento_1_idx` (`nro_factura` ASC, `tipo_factura` ASC),
  PRIMARY KEY (`nro_factura`, `tipo_factura`),
  CONSTRAINT `fk_Alojamiento_1`
    FOREIGN KEY (`nro_factura` , `tipo_factura`)
    REFERENCES `basereserva`.`factura` (`nro_factura` , `tipo_factura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basereserva`.`parking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basereserva`.`parking` (
  `monto` DECIMAL NULL,
  `nro_factura` INT NULL,
  `tipo_factura` VARCHAR(1) NULL,
  PRIMARY KEY (`nro_factura`, `tipo_factura`),
  CONSTRAINT `fk_parking_1`
    FOREIGN KEY (`nro_factura` , `tipo_factura`)
    REFERENCES `basereserva`.`factura` (`nro_factura` , `tipo_factura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basereserva`.`room_service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basereserva`.`room_service` (
  `nro_factura` INT NULL,
  `tipo_factura` VARCHAR(1) NULL,
  `monto` DECIMAL NULL,
  PRIMARY KEY (`nro_factura`, `tipo_factura`),
  CONSTRAINT `fk_room_service_1`
    FOREIGN KEY (`nro_factura` , `tipo_factura`)
    REFERENCES `basereserva`.`factura` (`nro_factura` , `tipo_factura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basereserva`.`tintoreria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basereserva`.`tintoreria` (
  `nro_factura` INT NULL,
  `tipo_factura` VARCHAR(1) NULL,
  `monto` DECIMAL NULL,
  PRIMARY KEY (`nro_factura`, `tipo_factura`),
  CONSTRAINT `fk_tintoreria_1`
    FOREIGN KEY (`nro_factura` , `tipo_factura`)
    REFERENCES `basereserva`.`factura` (`nro_factura` , `tipo_factura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basereserva`.`spa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basereserva`.`spa` (
  `nro_factura` INT NULL,
  `tipo_factura` VARCHAR(1) NULL,
  `monto` DECIMAL NULL,
  PRIMARY KEY (`nro_factura`, `tipo_factura`),
  CONSTRAINT `fk_spa_1`
    FOREIGN KEY (`nro_factura` , `tipo_factura`)
    REFERENCES `basereserva`.`factura` (`nro_factura` , `tipo_factura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basereserva`.`telefonia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basereserva`.`telefonia` (
  `nro_factura` INT NULL,
  `tipo_factura` VARCHAR(1) NULL,
  `monto` DECIMAL NULL,
  PRIMARY KEY (`nro_factura`, `tipo_factura`),
  CONSTRAINT `fk_telefonia_1`
    FOREIGN KEY (`nro_factura` , `tipo_factura`)
    REFERENCES `basereserva`.`factura` (`nro_factura` , `tipo_factura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basereserva`.`anticipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basereserva`.`anticipo` (
  `monto` DECIMAL NULL,
  `apellido` VARCHAR(45) NULL,
  `nro_habitacion` VARCHAR(45) NOT NULL,
  `fecha_caja` DATETIME NOT NULL,
  `turno` VARCHAR(1) NOT NULL,
  `id_anticipo` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_anticipo`),
  INDEX `fk_anticipo_1_idx` (`fecha_caja` ASC, `turno` ASC),
  CONSTRAINT `fk_anticipo_1`
    FOREIGN KEY (`fecha_caja` , `turno`)
    REFERENCES `basereserva`.`caja` (`fecha_caja` , `turno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basereserva`.`otro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basereserva`.`otro` (
  `fecha_caja` DATETIME NOT NULL,
  `turno` VARCHAR(1) NOT NULL,
  `apellido` VARCHAR(45) NULL,
  `nro_habitacion` VARCHAR(45) NULL,
  `monto` DECIMAL NULL,
  `descripcion` VARCHAR(45) NULL,
  `id_otro` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_otro`),
  CONSTRAINT `fk_otro_1`
    FOREIGN KEY (`fecha_caja` , `turno`)
    REFERENCES `basereserva`.`caja` (`fecha_caja` , `turno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basereserva`.`tel_emp`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basereserva`.`tel_emp` (
  `idtel_emp` INT NOT NULL AUTO_INCREMENT,
  `numero` INT(12) NULL,
  UNIQUE INDEX `numero_UNIQUE` (`numero` ASC),
  PRIMARY KEY (`idtel_emp`),
  CONSTRAINT `fk_tel_emp_1`
    FOREIGN KEY (`idtel_emp`)
    REFERENCES `basereserva`.`empresa` (`idempresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
