# Usar una imagen base de Java
FROM eclipse-temurin:17-jdk AS build

# Configurar el directorio de trabajo
WORKDIR /app

# Copiar archivos del proyecto
COPY . .

# Construir la aplicación
RUN ./mvnw clean package -DskipTests

# Segunda etapa: Imagen final para ejecutar la app
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copiar el JAR generado desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]