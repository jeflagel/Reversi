CREATE TABLE CASE (
  id int primary key AUTO_INCREMENT,
  etat int,
  position_x int,
  position_y int,
  id_othellier int
);

CREATE TABLE JOUEUR (
  id int,
  nom varchar(30),
  prenom varchar(30),
  token varchar(30),
  score int
);

CREATE TABLE PARTIE (
  id int primary key AUTO_INCREMENT,
  id_joueur1 int,
  id_joueur2 int,
  tour int,
  num_tour int,
  timeout int
);