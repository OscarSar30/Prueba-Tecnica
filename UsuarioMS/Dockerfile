FROM openjdk:11
RUN mkdir -p /usr/src/usuarioms
COPY /target/UsuarioMS-1.0.0.jar /usr/src/usuarioms
WORKDIR /usr/src/usuarioms
EXPOSE 8081
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Duser.timezone=EC", "-jar", "/target/UsuarioMS--1.0.0.jar"]
