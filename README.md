# Rick and Morty Explorer

## À propos du projet

Cette application Android développée avec Jetpack Compose permet d'explorer les personnages de la série animée "Rick and Morty" en utilisant l'API publique [Rick and Morty API](https://rickandmortyapi.com/). Le projet a été réalisé dans le cadre du cours de développement Android à l'EPSI en 2024-2025.

### Auteurs
- [Kevin Ferraretto](https://kevin-ferraretto.fr/)
- Gabriel K ([@GabYan876](https://kevin-ferraretto.fr/))

## Fonctionnalités

- ✅ Affichage d'une liste de personnages avec leur nom et image
- ✅ Consultation des détails d'un personnage (statut, espèce, genre, origine, etc.)
- ✅ Interface utilisateur moderne avec Material Design 3
- ✅ Gestion des erreurs de connexion
- ✅ Navigation entre les écrans avec gestion de la toolbar
- ✅ Chargement asynchrone des images avec Coil

## Architecture

L'application suit l'architecture MVVM (Model-View-ViewModel) et utilise les technologies suivantes :

- **UI** : Jetpack Compose
- **Navigation** : Compose Navigation
- **Réseau** : Retrofit pour les appels API
- **Chargement d'images** : Coil
- **Gestion des données** : ViewModel et LiveData

## Mise en place du projet

### Prérequis
- Android Studio Flamingo (2023.2.1) ou plus récent
- JDK 17 ou plus récent
- SDK Android 34 (ou le niveau d'API ciblé dans le projet)

### Installation
1. Clonez le dépôt :
   ```bash
   git clone https://github.com/Kevin-Ferraretto-Cours/2024-kotlin-RickAndMorty.git
   ```
2. Ouvrez le projet dans Android Studio
3. Synchronisez le projet avec les fichiers Gradle
4. Exécutez l'application sur un émulateur ou un appareil physique

## API utilisée

L'application utilise l'API publique Rick and Morty disponible à l'adresse suivante :
[https://rickandmortyapi.com/](https://rickandmortyapi.com/)

Les principaux endpoints utilisés sont :
- **GET /api/character** - Liste des personnages
- **GET /api/character/{id}** - Détails d'un personnage spécifique


## Fonctionnalités bonus implémentées

- ⭐ Gestion de la pagination pour charger plus de personnages lors du défilement

## Licence

Ce projet est sous licence MIT. Voir le fichier [LICENSE](LICENSE) pour plus de détails.
