CREATE SCHEMA `emr` ;
USE `emr`;

CREATE TABLE `emr`.`doctors` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `date_updated` DATETIME NOT NULL DEFAULT NOW(),
  `updated_by` VARCHAR(50) NOT NULL,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `gender` VARCHAR(10) NOT NULL,
  `specialization` VARCHAR(50) NOT NULL,
  `license_number` VARCHAR(45) NULL,
  `address` VARCHAR(100) NULL,
  `contact_number` VARCHAR(45) NULL,
  `email_address` VARCHAR(100) NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `is_active` TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

CREATE TABLE `emr`.`clinics` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `date_updated` DATETIME NOT NULL DEFAULT NOW(),
  `updated_by` VARCHAR(50) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `address` VARCHAR(100) NULL,
  `start_time` VARCHAR(45) NULL,
  `end_time` VARCHAR(45) NULL,
  `days_of_week` VARCHAR(45) NOT NULL,
  `doctor_id` BIGINT(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

CREATE TABLE `emr`.`staffs` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `date_updated` DATETIME NOT NULL DEFAULT NOW(),
  `updated_by` VARCHAR(50) NOT NULL,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `gender` VARCHAR(10) NOT NULL,
  `address` VARCHAR(100) NULL,
  `contact_number` VARCHAR(45) NULL,
  `email_address` VARCHAR(100) NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `is_active` TINYINT(1) NOT NULL DEFAULT 1,
  `doctor_id` BIGINT(10) NOT NULL,
  `clinic_id` BIGINT(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

CREATE TABLE `emr`.`patients` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `date_updated` DATETIME NOT NULL DEFAULT NOW(),
  `updated_by` VARCHAR(50) NOT NULL,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `gender` VARCHAR(10) NOT NULL,
  `address` VARCHAR(100) NULL,
  `contact_number` VARCHAR(45) NULL,
  `email_address` VARCHAR(100) NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `is_active` TINYINT(1) NOT NULL DEFAULT 1,
  `doctor_id` BIGINT(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

CREATE TABLE `emr`.`appointments` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `date_updated` DATETIME NOT NULL DEFAULT NOW(),
  `updated_by` VARCHAR(50) NOT NULL,
  `patient_name` VARCHAR(100) NOT NULL,
  `queue_number` INT NOT NULL,
  `doctor_id` BIGINT(10) NOT NULL,
  `clinic_id` BIGINT(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

CREATE TABLE `emr`.`account_settings` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `date_updated` DATETIME NOT NULL DEFAULT NOW(),
  `updated_by` VARCHAR(50) NOT NULL,
  `staff_enabled` TINYINT(1) NOT NULL DEFAULT 1,
  `subs_start_date` DATETIME NOT NULL DEFAULT NOW(),
  `subs_end_date` DATETIME NOT NULL,
  `doctor_id` BIGINT(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

CREATE TABLE `emr`.`medical_records` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `date_updated` DATETIME NOT NULL DEFAULT NOW(),
  `updated_by` VARCHAR(50) NOT NULL,
  `height` VARCHAR(45) NULL,
  `weight` VARCHAR(45) NULL,
  `blood_pressure` VARCHAR(45) NULL,
  `date_taken` DATETIME NULL,
  `symptoms` VARCHAR(100) NULL,
  `diagnosis` VARCHAR(100) NULL,
  `remarks` VARCHAR(100) NULL,
  `prescription` VARCHAR(100) NULL,
  `followup_date` DATETIME NULL,
  `patient_id` BIGINT NOT NULL,
  `doctor_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));
  
CREATE TABLE `emr`.`users` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `date_updated` DATETIME NOT NULL DEFAULT NOW(),
  `updated_by` VARCHAR(50) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `user_type` VARCHAR(50) NOT NULL,
  `is_active` TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

CREATE TABLE `emr`.`user_roles` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `date_updated` DATETIME NOT NULL DEFAULT NOW(),
  `updated_by` VARCHAR(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `role` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));
