::Create docker image:
docker build -t gateway .
::Run the container
docker run --name gateway --link config-server:config-server --link discovery-server:discovery-server --link ordering:ordering -p 80:80 gateway