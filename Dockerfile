FROM openjdk:8
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN javac DemoApplicationTests.java
CMD ["java", "DemoApplicationTests"]