# Eclipse Starter for Jakarta EE
This is a sample application generated by the Eclipse Foundation starter for Jakarta EE.

You can run the application by executing the following command from the directory where this file resides. Please ensure you have installed a [Java SE implementation](https://adoptium.net) appropriate for your Jakarta EE version and runtime choice (this sample assumes Java SE 17). Note, the [Maven Wrapper](https://maven.apache.org/wrapper/) is already included in the project, so a Maven install is not actually needed. You may first need to execute `chmod +x mvnw`.

```
./mvnw clean package wildfly:dev
```

Once the runtime starts, you can access the project at [http://localhost:8080/jakarta-aufgabe-backend](http://localhost:8080/jakarta-aufgabe-backend).

------------------------------
hinweis: müsst den path zu einer kompatiblen java version (am besten 17) als JAVA_HOME umgebungsvariable speichern in z.b. dem format "C:\Program Files\Java\jdk-17.0.1"