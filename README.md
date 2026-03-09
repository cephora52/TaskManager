Task Manager API

  Description du projet

Cette application est une API REST de gestion de tâches nommé Task Manager développée avec Spring Boot.  
Elle permet aux utilisateurs de créer, gérer, modifier et supprimer leurs tâches.

Le projet inclut également la mise en place d’un pipeline CI/CD complet intégrant :

- Intégration continue
- Tests automatisés
- Analyse qualité avec SonarCloud
- Scan de sécurité 
- Conteneurisation avec Docker
- Déploiement automatique


 QUESTION 1 — Conception architecturale et modélisation

 1. Besoins fonctionnel

Acteurs

- Utilisateur
- Administrateur

 Principales fonctionnalités

- Creation de compte
- L'authentifiction
- Creation des tâches
- Modification des tâches
- Suppression des tâches
- Consultation des tâches

 Contraintes techniques

- Architecture Spring Boot
- Sécurité avec JWT
- Conteneurisation avec Docker
- Pipeline CI/CD
- Gestion centralisee des exceptions

  2. Modelisation des donnees

 Tables principales
  - Users
  - Tasks

 Relations 1 a plusieurs

  3. Structure REST de l'API

 Routes principales :

 POST/auth/login
 GET/users
 GEST/tasks
 POST/users
 POST/tasks
 PUT/users
 PUT/tasks
 DELETE/users
 DELETE/tasks

Methodes HTTP : 

- POST : creer une taches
- GET : récuperer une tache
- PUT : modifier une tache
- DELETE : supprimer une tache 

Code de reponses :
  200 : succes
  201 : ressource créee
  400: requete invalide
  401: Utilisateur non authentifie
  403 : acces non autorise 
  500: erreur du serveur 

Gestion des erreurs : 
  Nous gérons les erreurs avec les execptions 

Versionning:

 le versionning est géré avec /api/v1/tasksmanager

  4. Architecture applicative Spring boot

Separation des responsabiltés:

 Controller : Gere les requetes HTTP
 Service : Pour la logique metier
 Repository : Pour l'acces a la base de données 
 DTO : Assure le transfert des données
 Mapper : Conversion des DTO en entity et inversement

Principe SOLID:

 le projet respecte le principe solid a cause de la séparation des responsabiltés
 
Clean code :  

 les bonnes pratiques appliquees sont :
 - le code structuré
 - la separation des responsabilite
 -  les methodes courtes
 -  Abscence de duplication


QUESTION 3 : CONCEPTION DU PIPELINE 

Srategie de branche adoptee

 Nous avons adopte une strategie simplie basee sur git ou main est notre branche principale contenant l'application.
 Le developpement sont realises et poussees sur cette branche

Declencheurs du pipeline 

  Le pipeline est declenché automatiquement lorsqu'on fait un push sur la branche principale 

Les differentes etapes du pipeline sont :
  - Build : compile l'application
  - Lint : Analyse le code pour verifier le respect des conventions
  - Test : Execute les test pour verifier que les fonctionnalite de l'application marchent 
  - Analyse SonauQube: analyse la qualite du code en detectant les bugs, les vulnerabilite et les duplications
  - Scan de securite: Verifie les dependances du projet
  - Build Docker: Cree une image docker de l'application pour faciliter le deploiement
  - Deploiement : Lance l'application dans un conteneur Docker

QUESTION 6 : OPTIMISATION ET CLEAN CODE 

STRUCTURATION

 Comment le pipeline respecte les principes de modularite  
 
   Le projet est structure en plusieurs couches afin de respecter le principe de separation des responsabilites 
   chaque couche possede un role precis :
   - Controller : Gere les requetes HTTP
   - Service : Pour la logique metier
   - Repository : Pour l'acces a la base de données
   - DTO : Assure le transfert des données
   - Mapper : Conversion des DTO en entity et inversement
     
 Les ameliorations apportees au code initial
    Utilisation des dto pour eviter d'exposer directement les entites
    Separation claire entre controller, service et repository
    Authentification securise avec JWT
    Mise en place des tests unitaires 

OPTIMISATION DU PIPELINE

GUIDE CLAIRE 

Execution du pipeline  : le pipeline est execute automatique lorsqu'on effectue un push sur la branche principale 

Comment corriger un echec :
  - Consulter les logs dans github actions
  - Identifier l'etape qui a echoue
  - Corrige l'erreur dans le code
  - effectuer un nouveau commit et push

Comment corriger les vulnerabilites detectee:

  - Analyser le probleme signale par sonarqube
  - Corriger
  - relancer le pipeline 
