FROM ubuntu:20.04
RUN apt-get update -y
RUN apt-get install openjdk-8-jdk-headless -y
RUN apt-get install git -y

# Install crius--artifact
RUN git clone https://github.com/publishAE/Crius.git

