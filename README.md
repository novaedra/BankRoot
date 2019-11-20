# Bankroot - Projet Java


Bankroot est une application web développé en JAVA qui doit permettre à une banque de trouver dans une base de données, les clients et prospects les plus susceptibles de répondre positivement à une offre produit. 

## Installation
Cloner le projet (temporaire, tant que la branche master n'est pas à jour)

```
git clone https://github.com/novaedra/BankRoot.git
cd BankRoot
git checkout develop
```

Puis installer le JRE java 1.8

https://codenotfound.com/java-download-install-jdk-8-windows.html

## Sur IntelliJ :

Importer le projet 

une fois le projet importer : 
clique droit sur public -> add framework support : **Maven** (qui va se charger d'importer les dépendances)

Une fois Maven activée
File -> Project Structure -> Artifacts

Cliquer sur + pour ajouter un artefact de type Web Application Exploded puis from modules "public"

Une fois l'artefact créé :

cliquer sur edit configurations puis + pour ajouter et sélectionner Tomcat Server : local

Enfin, démarrer le serveur en cliquant sur l'icône play à droite de la configuration

