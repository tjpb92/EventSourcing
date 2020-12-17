# Formation Implémenter DDD avec CQRS / Event Sourcing

Contenu des exercices de la formation "Implémenter DDD avec CQRS / Event Sourcing" du 14 au 17 décembre 2020


## Premier jour de la formation : 14/12/2020

Ajouter ici les photos ...

## Second jour de la formation : 15/12/2020

### Agrégat de suivi des inscriptions

L'agrégat `DistributionInscription` servira à suivre les inscriptions et les désinscriptions.

On prévoira les cas suivants :

- Démarrage des inscriptions,
- Abonnement d'un distributeur,
- Désabonnement d'un distributeur.

## Troisième jour de la formation : 16/12/2020

### Projections `DistributeurCounter` et `DistributeurNameList`

On réalise deux projections pour  : 

- `DistributeurCounter` : compter les distributeurs enregistrés,
- `DistributeurNameList` : lister les distributeurs enregistrés.

#### Projection `DistributeurCounter`

- Quand le handler reçoit un événement `DistributorRegistered`, un compteur est incrémenté d'une unité,
- Quand le hanlder reçoit un événement `DistributorUnregistered`, un compteur est décrémenté d'une unité.

ATTENTION : on prendra soin d'avoir un compteur par agrégat.

#### Projection `DistributeurNameList`

- Quand le handler reçoit un événement `DistributorRegistered`, une liste reçoit le nom du distributeur concerné,
- Quand le hanlder reçoit un événement `DistributorUnregistered`, le nom du distributeur concerné est retiré d'une liste.

ATTENTION : on prendra soin d'avoir une liste par agrégat.

### Publisher / Subscriber

Le publisher doit :

- enregistrer les événements lorsqu'ils sont publiés,
- appeler les handlers adéquats pour chaque événement,
- doit afficher les projections lorsqu'une commande est invoquée.

## Quatrième jour de la formation : 17/12/2020

- Implémentation d'une réprésention de l'EventStore
- Contrôle du versionning des événements

## Références:

- [Implémenter DDD avec CQRS / Event Sourcing](https://formation.hackyourjob.com/catalogue/ddd-cqrs-eventsourcing.html)
