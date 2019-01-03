#!/bin/sh

export LOG_PATH=@LOG_PATH@

# Renseignement de la chaîne par défaut si configurée
[ "$chaine" = "" ] && chaine="@chaine.default@"
# Si $chaine n'est pas renseignée/correcte avant de lancer ce script on le demande interactivement
while [ "`echo \"$chaine\" | grep -P '^(chaine)?\d$'`" = "" ]
do
    read -p "Quelle chaine [1|4] ? " chaine
done
# Accepte à la fois chaine=1 et chaine=chaine1
chaine=chaine`echo $chaine | sed s/chaine//g`

# -15 = SIGTERM (mais la version nommée ne fonctionne pas toujours ?) = Ctrl+C
kill -15 `cat $chaine.pid` && rm -f $chaine.pid

# Affichage de la trace pour suivre le démarrage - Ctrl+C pour quitter
while [ ! -f $LOG_PATH/apicj-$chaine.log ]; do sleep 1; done
tail -f $LOG_PATH/apicj-$chaine.log
