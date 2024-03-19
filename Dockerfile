FROM node:20-alpine AS build
ENV NODE_ENV development

WORKDIR /app
COPY . .

RUN npm ci
RUN npm run build

FROM nginx:1.21-alpine as prod

COPY --from=build /app/build /usr/share/nginx/html

EXPOSE 80

