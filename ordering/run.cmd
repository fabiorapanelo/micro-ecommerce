::Create docker image:
docker build -t ordering .
::Run the container
docker run --name ordering --link config-server:config-server --link discovery-server:discovery-server -p 8082:8082 ordering