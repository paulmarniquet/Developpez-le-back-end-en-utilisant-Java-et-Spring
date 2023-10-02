# Chatop - API

Le projet Chatop est une application web permettant aux utilisateurs de mettre en vente ou en location des biens immobiliers. Il se compose d'un frontend Angular et d'un backend développé dans ce repértoire.

## Installation et Exécution

### Frontend
1. Récupérez le code source du frontend depuis [le dépôt GitHub du projet parent](https://github.com/OpenClassrooms-Student-Center/Developpez-le-back-end-en-utilisant-Java-et-Spring).
2. Lancez un terminal et rendez-vous dans le répertoire du frontend.
3. Exécutez la commande suivante pour installer les dépendances :
   ```
   npm install
   ```
4. Démarrez le serveur de développement en exécutant :
   ```
   ng serve
   ```
   Le frontend sera accessible à l'adresse [localhost:4200](http://localhost:4200/).

### Backend
1. Exécutez la commande suivante pour installer les dépendances :
   ```
   mvn install
   ```
2. Démarrez le serveur backend avec la commande :
   ```
   mvn spring-boot:run
   ```
   Le backend sera accessible à l'adresse [localhost:9099](http://localhost:9099/).

### Swagger
Pour accéder à la documentation des routes de l'API, il faut d'abord lancer le serveur et se rendre à l'adresse suivante : [localhost:9099/swagger-ui/index.html](http://localhost:9099/swagger-ui/index.html).

## Base de données

1. Créez une nouvelle base de données MySQL.
2. Exécutez le script SQL qui se trouve dans le répertoire GitHub du projet parent : ressources/sql/script.sql.

### Configuration

1. Créez un fichier `.env` dans le répertoire du backend.
2. Ajoutez-y les informations de connexion à la base de données :
   ```
   MYSQL_USER=Utilisateur
   MYSQL_PASSWORD=MotDePasse
   MYSQL_URL=URL
   ```
   Remplacez les valeurs par vos identifiants SQL.

## Technologies utilisées

* Java 17
* Spring Boot
* MySQL
* Maven
* Swagger
* Angular

---

### Contact

Pour toute question ou commentaire, n'hésitez pas à me contacter sur mon mail : [paul.marniquet@gmail.com](mailto:paul.marniquet@email.com).

---
