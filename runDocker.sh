#docker run -p 8080:8080 taxiserver
docker run -ti --entrypoint /bin/sh taxiserver
docker exec -ti taxiserver /bin/sh