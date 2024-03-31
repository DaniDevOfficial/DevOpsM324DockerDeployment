# Docker Images Auf Github und DockerHub pushen

![Main Image](./ReadMeAssets/David.png)
## 1. Einleitung 
Die ist eine kleine Aufgabe, welche wir im Modul M325 erhalten haben. Die Aufgabe bestand darin, ein einfaches React Projekt auf Dockerhub und Github automatisch mit einer GitHub acction zu pushen. Das React Projekt dahinter selbst spielt nicht wirklich eine Rolle.



## 2. Dockerfile

Zuerst muss das React Projekt gebaut werden, um in einem Docker Image zu speichern. Dies wird mit dem Folgendem Dockerfile erreicht:

```dockerfile
FROM node:20-alpine AS build
ENV NODE_ENV development

WORKDIR /app
COPY . .

RUN npm ci
RUN npm run build

FROM nginx:1.21-alpine as prod

COPY --from=build /app/build /usr/share/nginx/html

EXPOSE 80

```
## 3 Remote Push

### 3.1 Auf Docker Hub


Ich habe damit begonnen zu versuchen das Docker Image zuerst auf Docker Hub zu pushen. Dafür musste ich zuerst auf Github selbst im Repository für `secrets.DOCKER_HUB_USERNAME` und `secrets.DOCKER_HUB_PASSWORD` meine Respektiven daten angeben, sodass ich meine Secrets nicht Hardcoden muss. Falls sie selbst das ausprobieren wollen, müssen sie auf Github selbst unter den Repository settings in den Enviroment Variables und darin in den Actions diese beiden Env Secrets angeben und abspeichern. Der folgende Teil vom .yml file ist für das pushen auf Dockerhub nötig:

```yml
jobs:
  publish-docker-image:
    runs-on: ubuntu-latest
    steps:
      - name: Checkout
        uses: actions/checkout@v2

      - name: Login to DockerHub
        uses: docker/login-action@v1
        with:
          username: ${{ secrets.DOCKER_HUB_USERNAME }}
          password: ${{ secrets.DOCKER_HUB_PASSWORD }}

      - name: Publish Docker image to Docker Hub
        uses: docker/build-push-action@v2
        with:
          context: .
          push: true
          tags: ${{ secrets.DOCKER_HUB_USERNAME }}/ref-card-02:${{ github.sha }}
```

Das Resultat auf Dockerhub sollte ungefähr so auf Dockerhub aussehen:

![Dockerhub](./ReadMeAssets/dockerhub.png)

Hier ist das ganze auf [DockerHub](https://hub.docker.com/repository/docker/danithaboss/ref-card-02/general)

### 3.2 Auf Github Packages

Um das Image auf Github selbst zu pushen benötigt man etwas mehr als nur die Login Daten. In meinem yml file wird der username direkt vom Repository genommen, sodass man nicht extra etwas hinzufügen muss. Jedoch wird ein Github acces Token als `secrets.GITHUBTOKEN` gespeichert. Um diesen Zu erhalten muss man auf den eigenen Profileinstellungen einen neuen Token erstellen und zwar mit `write:packages` Rechten, sodass ein Pacakge auch erstellt werden kann. 
`        run: docker tag ${{ secrets.DOCKER_HUB_USERNAME }}/ref-card-02:${{ github.sha }} ghcr.io/danidevofficial/ref-card-02:${{ github.sha }}
`

Hier müsste für personalisierung die Namen etc abgeändert werden. 

Das ganze yml file für GitHub solte ungefär so aussehen:

```yml
      - name: Login to GitHub Container Registry
        uses: docker/login-action@v1
        with:
          registry: ghcr.io
          username: ${{ github.actor }}
          password: ${{ secrets.GITHUBTOKEN }}

      - name: Tag Docker image for GitHub Container Registry
        run: docker tag ${{ secrets.DOCKER_HUB_USERNAME }}/ref-card-02:${{ github.sha }} ghcr.io/danidevofficial/ref-card-02:${{ github.sha }}

      - name: Push Docker image to GitHub Container Registry
        run: docker push ghcr.io/danidevofficial/ref-card-02:${{ github.sha }}
```

Auf Github sollte das unter dem eigenem Account in denn Packages ungefär so aussehen:

![GitHub Image](./ReadMeAssets/Github.png)

[Oder selbst anschauen](https://github.com/users/DaniDevOfficial/packages/container/ref-card-02)