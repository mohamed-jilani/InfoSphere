# NewsApp

**NewsApp** est une application Android qui permet aux utilisateurs de consulter les dernières actualités provenant de différentes sources. L'application utilise une API de news pour afficher les articles et permet de visualiser les détails d'un article dans une page dédiée.

## Fonctionnalités

- **Page d'accueil** : Affiche une liste d'articles avec un logo et un titre.
- **Filtrage des articles** : Permet de filtrer les articles par catégorie.
- **Détail des articles** : En cliquant sur un article, l'utilisateur accède à la page de détails avec une vue Web de l'article.
- **Partage** : Les utilisateurs peuvent partager un article via un bouton dans la barre d'outils.
- **Onboarding** : Page d'introduction avec le logo de l'application.

## Prérequis

Avant de pouvoir exécuter le projet, assurez-vous que vous avez les éléments suivants installés sur votre machine :

- [Android Studio](https://developer.android.com/studio) pour l'édition et l'exécution du projet.
- Un appareil Android ou un émulateur pour tester l'application.

## Installation

1. Clonez ce repository sur votre machine locale :
   ```bash
   git clone https://github.com/ton-nom-de-compte/newsapp.git
2. Ouvrez le projet dans Android Studio.

3. Ajoutez votre clé API dans le code. Vous pouvez obtenir une clé API gratuitement sur News API.
   Ajoutez la clé API dans le fichier NewsApiService.java ou une autre classe de votre choix.
   Synchronisez le projet pour télécharger toutes les dépendances.
   
5. Lancez l'application sur un émulateur ou un appareil réel.

Structure du projet
Voici la structure de base du projet :
NewsApp/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── newsapp/
│   │   │   │           ├── MainActivity.java       # Page d'accueil avec la RecyclerView
│   │   │   │           ├── DetailActivity.java     # Page de détails de l'article
│   │   │   │           ├── NewsApiService.java     # Service pour gérer l'API News
│   │   │   │           └── NewsAdapter.java        # Adapter pour la RecyclerView
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml           # Layout de la page d'accueil
│   │   │   │   │   ├── activity_detail.xml         # Layout de la page de détails
│   │   │   │   │   ├── onboarding_page.xml         # Layout de la page d'onboarding
│   │   │   │   ├── drawable/
│   │   │   │   │   └── logo.png                    # Logo de l'application
│   │   │   │   ├── values/
│   │   │   │   │   ├── colors.xml                  # Définition des couleurs
│   │   │   │   │   ├── strings.xml                 # Chaînes de caractères
│   │   │   │   │   └── themes.xml                  # Thèmes de l'application
│   │   │   │   ├── mipmap/
│   │   │   │   │   └── ic_launcher.png             # Icône de l'application
│   │   │   └── AndroidManifest.xml                 # Configuration de l'application
├── build.gradle
└── README.md

Utilisation
Page d'accueil : Affiche une liste d'articles récupérés via l'API News. L'utilisateur peut cliquer sur un article pour voir ses détails.
Filtrage des articles : Vous pouvez ajouter un bouton pour filtrer les articles par catégorie de news, ce qui permet de limiter l'affichage aux articles qui vous intéressent.
Partage d'articles : Un bouton dans la barre d'outils vous permet de partager l'article en cours.
Onboarding : Une page d'introduction qui permet à l'utilisateur de découvrir l'application avant de commencer à l'utiliser.
Contributions
Les contributions sont les bienvenues ! Si vous souhaitez améliorer l'application, voici comment vous pouvez contribuer :

Forkez le projet.
Créez une branche pour votre fonctionnalité (git checkout -b feature/ma-nouvelle-fonctionnalité).
Commitez vos changements (git commit -am 'Ajout de ma fonctionnalité').
Poussez vos modifications (git push origin feature/ma-nouvelle-fonctionnalité).
Créez une pull request.
License
Ce projet est sous licence MIT - voir le fichier LICENSE pour plus de détails.