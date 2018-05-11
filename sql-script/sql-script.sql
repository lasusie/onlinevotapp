-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`COUNTRY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`COUNTRY` (
  `idCountry` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCountry`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`AREA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`AREA` (
  `idArea` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `COUNTRY_idCountry` INT NOT NULL,
  PRIMARY KEY (`idArea`),
  INDEX `fk_AREA_COUNTRY1_idx` (`COUNTRY_idCountry` ASC),
  CONSTRAINT `fk_AREA_COUNTRY1`
    FOREIGN KEY (`COUNTRY_idCountry`)
    REFERENCES `mydb`.`COUNTRY` (`idCountry`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DEPARTMENT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DEPARTMENT` (
  `idDepto` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `AREA_idArea` INT NOT NULL,
  PRIMARY KEY (`idDepto`),
  INDEX `fk_DEPARTMENT_AREA1_idx` (`AREA_idArea` ASC),
  CONSTRAINT `fk_DEPARTMENT_AREA1`
    FOREIGN KEY (`AREA_idArea`)
    REFERENCES `mydb`.`AREA` (`idArea`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`USER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`USER` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surnames` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `docID` VARCHAR(45) NOT NULL,
  `DEPARTMENT_idDepto` INT NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(70) NOT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE INDEX `docID_UNIQUE` (`docID` ASC),
  INDEX `fk_USER_DEPARTMENT1_idx` (`DEPARTMENT_idDepto` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  CONSTRAINT `fk_USER_DEPARTMENT1`
    FOREIGN KEY (`DEPARTMENT_idDepto`)
    REFERENCES `mydb`.`DEPARTMENT` (`idDepto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`COMMITTEE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`COMMITTEE` (
  `idComm` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idComm`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`CANDIDATE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`CANDIDATE` (
  `idCandidate` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `DEPARTMENT_idDepto` INT NOT NULL,
  `COMMITTEE_idComm` INT NOT NULL,
  PRIMARY KEY (`idCandidate`),
  INDEX `fk_CANDIDATE_DEPARTMENT_idx` (`DEPARTMENT_idDepto` ASC),
  INDEX `fk_CANDIDATE_COMMITTEE1_idx` (`COMMITTEE_idComm` ASC),
  CONSTRAINT `fk_CANDIDATE_DEPARTMENT`
    FOREIGN KEY (`DEPARTMENT_idDepto`)
    REFERENCES `mydb`.`DEPARTMENT` (`idDepto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CANDIDATE_COMMITTEE1`
    FOREIGN KEY (`COMMITTEE_idComm`)
    REFERENCES `mydb`.`COMMITTEE` (`idComm`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`VOTE_POOL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`VOTE_POOL` (
  `idVotePool` INT NOT NULL AUTO_INCREMENT,
  `VoteDate` DATETIME NOT NULL,
  `CANDIDATE_idCandidate` INT NULL,
  `COMMITTEE_idComm` INT NULL,
  `USER_idUser` INT NOT NULL,
  PRIMARY KEY (`idVotePool`, `USER_idUser`),
  INDEX `fk_VOTE_POOL_CANDIDATE1_idx` (`CANDIDATE_idCandidate` ASC),
  INDEX `fk_VOTE_POOL_COMMITTEE1_idx` (`COMMITTEE_idComm` ASC),
  INDEX `fk_VOTE_POOL_USER1_idx` (`USER_idUser` ASC),
  CONSTRAINT `fk_VOTE_POOL_CANDIDATE1`
    FOREIGN KEY (`CANDIDATE_idCandidate`)
    REFERENCES `mydb`.`CANDIDATE` (`idCandidate`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_VOTE_POOL_COMMITTEE1`
    FOREIGN KEY (`COMMITTEE_idComm`)
    REFERENCES `mydb`.`COMMITTEE` (`idComm`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_VOTE_POOL_USER1`
    FOREIGN KEY (`USER_idUser`)
    REFERENCES `mydb`.`USER` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`AUDIT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`AUDIT` (
  `idAudit` INT NOT NULL,
  `loginDate` DATETIME NOT NULL,
  `USER_idUser` INT NOT NULL,
  PRIMARY KEY (`idAudit`),
  INDEX `fk_AUDIT_USER1_idx` (`USER_idUser` ASC),
  CONSTRAINT `fk_AUDIT_USER1`
    FOREIGN KEY (`USER_idUser`)
    REFERENCES `mydb`.`USER` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
