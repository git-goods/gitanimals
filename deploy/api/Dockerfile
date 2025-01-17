FROM arm64v8/openjdk:21

ARG DB_URL
ARG DB_USERNAME
ARG DB_PASSWORD
ARG GITHUB_TOKEN
ARG REDIS_HOST
ARG REDIS_PORT
ARG INTERNAL_SECRET
ARG SLACK_TOKEN

ARG JAR_FILE=./build/libs/*.jar
COPY ${JAR_FILE} gitanimals-render.jar

ENV db_url=${DB_URL} \
  db_username=${DB_USERNAME} \
  db_password=${DB_PASSWORD} \
  github_token=${GITHUB_TOKEN} \
  redis_host=${REDIS_HOST} \
  redis_port=${REDIS_PORT} \
  internal_secret=${INTERNAL_SECRET} \
  slack_token=${SLACK_TOKEN}

ENTRYPOINT java -jar gitanimals-render.jar \
  --spring.datasource.url=${db_url} \
  --spring.datasource.username=${db_username} \
  --spring.datasource.password=${db_password} \
  --netx.host=${redis_host} \
  --netx.port=${redis_port} \
  --github.token=${github_token} \
  --internal.secret=${internal_secret} \
  --slack.token=${slack_token}
