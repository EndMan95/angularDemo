FROM openjdk:8
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN javac /src/main/java/angular/demoDemoApplicationTests.java
CMD ["java", "/src/main/java/angular/DemoApplicationTests"]