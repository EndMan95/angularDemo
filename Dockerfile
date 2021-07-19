FROM openjdk:8
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN javac demo/src/main/java/angular/demoDemoApplicationTests.java
CMD ["java", "demo/src/main/java/angular/DemoApplicationTests"]