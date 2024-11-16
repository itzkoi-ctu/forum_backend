# 1. Chọn base image, sử dụng OpenJDK 20 làm nền tảng
FROM openjdk:21-jdk-slim

# 2. Thiết lập thư mục làm việc trong container (tùy chọn)
WORKDIR /app

# 3. Copy file JAR từ thư mục 'target' trong dự án vào container
# (sau khi bạn đã build ứng dụng với Maven hoặc Gradle)
COPY target/*.jar /app/app.jar

# 4. Cấu hình để container lắng nghe trên cổng 8080 (hoặc cổng mà Spring Boot sử dụng)
EXPOSE 8386

# 5. Chạy ứng dụng Spring Boot từ file JAR
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
