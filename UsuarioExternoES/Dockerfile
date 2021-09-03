FROM openjdk:11
RUN mkdir -p /usr/src/usuarioexternoes
COPY /target/UsuarioExternoES-1.0.0.jar /usr/src/usuarioexternoes
WORKDIR /usr/src/usuarioexternoes
EXPOSE 8082
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Duser.timezone=EC", "-jar", "/target/UsuarioExternoES--1.0.0.jar"]
