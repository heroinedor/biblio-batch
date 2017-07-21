CREATE DATABASE IF NOT EXISTS `books`;
USE `books`;

DROP TABLE IF EXISTS `word`;
DROP TABLE IF EXISTS `sentence`;
DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `idbook` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `content` blob,
  PRIMARY KEY (`idbook`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='contient l''ensemble des livres';

CREATE TABLE `sentence` (
  `idsentence` int(11) NOT NULL AUTO_INCREMENT,
  `sentence` varchar(500) DEFAULT NULL,
  `book_idbook` int(11) NOT NULL,
  PRIMARY KEY (`idsentence`),
  KEY `fk_sentence_book_idx` (`book_idbook`),
  CONSTRAINT `fk_sentence_book` FOREIGN KEY (`book_idbook`) REFERENCES `book` (`idbook`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=461 DEFAULT CHARSET=utf8 COMMENT='Contient l''ensemble des phrases des livres';

CREATE TABLE `word` (
  `idindex` int(11) NOT NULL,
  `word` varchar(100) DEFAULT NULL,
  `occurence` int(11) DEFAULT NULL,
  PRIMARY KEY (`idindex`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='contient l''ensemble des mots avec le nombre d''occurence par mot';

CREATE USER 'book'@'localhost' IDENTIFIED BY 'book';
GRANT ALL PRIVILEGES ON `book`.* TO 'book'@'localhost';