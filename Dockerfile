# Étape 1: Utiliser une image de base pour télécharger le JAR depuis Nexus
FROM openjdk:17-jdk-alpine AS downloader

# Installer curl
RUN apk add --no-cache curl

# Définir l'URL du JAR dans une variable d'environnement
ENV JAR_URL=http://192.168.65.160:8081/repository/MyPrivRepo/tn/esprit/tp-foyer/5.0.0/tp-foyer-5.0.0.jar

# Télécharger le JAR depuis Nexus
RUN curl -u admin:Zakaria123456! -o /tp-foyer-5.0.0.jar $JAR_URL

# Étape 2: Construire l'image finale
FROM openjdk:17-jdk-alpine
EXPOSE 8089

# Copier le JAR téléchargé depuis l'étape downloader
COPY --from=downloader /tp-foyer-5.0.0.jar tp-foyer-5.0.0.jar

ENTRYPOINT ["java", "-jar", "/tp-foyer-5.0.0.jar"]
