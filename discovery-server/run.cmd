::Create docker image:
docker build -t discovery-server .
::Run the container
docker run --name discovery-server --link config-server:config-server -p 8761:8761 discovery-server