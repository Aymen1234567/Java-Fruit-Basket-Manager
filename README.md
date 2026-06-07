# Java Fruit Basket Manager
# Projet universitaire dans le cadre du cours Génie Logiciel 
Application Java avec interface Swing permettant de gérer un panier de fruits. Fonctionnalités complètes : authentification, ajout/suppression de fruits, boycott par origine, création personnalisée et modification de capacité.

## Fonctionnalités

- Authentification (connexion et création de compte)
- Panier avec capacité modifiable
- Fruits personnalisables (type, prix, origine)
- Boycott d'une origine (exclusion automatique)
- Suppression ciblée d'un fruit
- Architecture MVC claire
- Interface graphique complète (Swing)

## Technologies

- Java
- Swing pour l'interface
- Pattern MVC
- Gestion d'exceptions personnalisées

## Compilation & Lancement (Maven)
      mvn clean compile
      mvn exec:java  
Ou avec commandes classiques :
```bash
  javac -d . src/**/*.java
  java fr.ufrsciencestech.panier.View.VueConnexion

