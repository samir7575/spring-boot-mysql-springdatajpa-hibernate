#!/bin/sh

export JAVA_HOME=/apps/WebSphere85/LibertyCore/java/java_1.8_64/
export PATH=$JAVA_HOME/bin:$PATH
export LOG_PATH=@LOG_PATH@


# Renseignement de la chaîne par défaut si configurée
[ "$chaine" = "" ] && chaine="@chaine.default@"
# Si $chaine n'est pas renseignée/correcte avant de lancer ce script on le demande interactivement
while [ "`echo \"$chaine\" | grep -P '^(chaine)?\d$'`" = "" ]
do
    read -p "Quelle chaine [1|4] ? " chaine
done
# Accepte à la fois chaine=1 et chaine=chaine1
export chaine=chaine`echo $chaine | sed s/chaine//g`

# Création de la clé pour le SSL si inexistante
# Désactivé : les paramètres server.ssl.* doivent être configurés manuellement dans le fichier application.properties après installation
#[ -f $chaine.p12 ] || keytool -genkey -alias apicj -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore $chaine.p12 -validity 365 -dname "cn=`hostname`" -storepass canalnet -keypass canalnet

# Lancement en tâche de fond
OPTIONS=
#OPTIONS="$OPTIONS -Djavax.net.debug=ssl"
#OPTIONS="$OPTIONS -Djavax.net.debug=all"
#OPTIONS="$OPTIONS -Dserver.ssl.trust-store=$JAVA_HOME/jre/lib/security/jssecacerts -Dserver.ssl.trust-store-type=pkcs12 -Dserver.ssl.trust-store-password=changeit"
#OPTIONS="$OPTIONS -Djavax.net.ssl.keyStore=$JAVA_HOME/jre/lib/security/jssecacerts -Djavax.net.ssl.keyStoreType=pkcs12 -Djavax.net.ssl.keyStorePassword=changeit"
#OPTIONS="$OPTIONS -Djavax.net.ssl.trustStore=$JAVA_HOME/jre/lib/security/jssecacerts -Djavax.net.ssl.trustStoreType=pkcs12 -Djavax.net.ssl.trustStorePassword=changeit"
mkdir -p $LOG_PATH
nohup java $* $OPTIONS "-DLOG_PATH=$LOG_PATH" -Dspring.profiles.active=$chaine -Dloader.path=.,oidc-services-apicj-conf-@project.version@-@env@.jar -jar oidc-services-apicj-@project.version@.jar >$LOG_PATH/apicj-$chaine.out 2>$LOG_PATH/apicj-$chaine.err &
echo $! > $chaine.pid

# Affichage de la trace pour suivre le démarrage - Ctrl+C pour quitter
while [ ! -f $LOG_PATH/apicj-$chaine.log ]; do sleep 1; done
tail -f $LOG_PATH/apicj-$chaine.log
