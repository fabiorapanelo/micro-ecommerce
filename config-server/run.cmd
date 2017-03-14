::Create docker image:
docker build -t config-server .
::Run the container
docker run --name config-server -p 8888:8888 config-server