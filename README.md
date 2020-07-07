# Quiz_App
Ce projet est une application ANDROID 'Code de la route', qui permet à l"utilisateur de passer des quizs pour se preparer à passer l'exam.
Cette application contient 7 layout, le premier layout c'est celui de la connexion, une fois que l'utilisateur entre ces données, une requette se lance pour vérifier l'éxistence,
c'est pour cela j'ai utiliser FireBaseAuthentification qui se connecte avec Firebase au niveau de la base de données.
Si l'utilisateur n'a pas de compte il n'a que que clicker sur la label pour se rendre au niveu de la 2em activity qui permet de s'inscrire au niveau de la base de donnée, dans ce cas
j'ai utiliser FireBaseAuthentification pour utiliser la fonction de création d'un nouveau utilisateur et aussi Fisebase realtime pour stocker les informations d'utilisateur au niveau
de la base de données.
Aprés la connexion ou l'inscription, on se dirige vers une le menu où l'utilisateur peut choisir son niveau, et juste aprés l'application navigue vers des quiz du niveau que l'utilisateur
à choisi.
et à la fin une activity s'affiche pour montrer le score de l'utilisateur
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Base de donnée utilisé : FIREBASE
Intelligence artificielle : L'application peut savoir le vrai niveau de l'utilisateur. Par example si l'utilisateur choisit au debut le niveau Debutant et répond à 100% des questions
l'application lui suggére automatiquement de passer au niveau amateur.
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Note: L'application contient pas toutes les interfaces quiz, mais l'idée du projet est claire.
