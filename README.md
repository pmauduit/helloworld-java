# helloworld-java
A simple placeholder repository to be able to braindump some java code and execute it without having to browse the whole internet on how to bootstrap a maven project.

This repository is also meant to test some experimentations around Java Virtual Machine black magick.

# native lib helloworld

First go to `src/main/resources/native`, then:

```
JAVA_HOME=/usr/lib/jvm/default-java make
```

Then run

```
mvn clean compile exec:java
```

