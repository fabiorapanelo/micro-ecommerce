::Create docker image:
docker build -t catalog .
::Run the container
docker run --name catalog --link config-server:config-server --link discovery-server:discovery-server --link search-engine:search-engine -p 8081:8081 catalog