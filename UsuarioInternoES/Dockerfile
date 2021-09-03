FROM openjdk:11
RUN mkdir -p /usr/src/usuariointernoes
COPY /target/UsuarioInternoES-1.0.0.jar /usr/src/usuariointernoes
WORKDIR /usr/src/usuariointernoes
EXPOSE 8083
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Duser.timezone=EC", "-jar", "/target/UsuarioInternoES--1.0.0.jar"]
