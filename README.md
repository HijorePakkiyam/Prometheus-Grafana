🔧 Spring Boot + Prometheus + Grafana Integration Guide
This guide explains how to integrate Prometheus with a Spring Boot application and visualize metrics using Grafana. It also includes how to publish the project to GitHub.

📁 Project Setup
Create a Spring Boot project with the following dependencies:

spring-boot-starter-web

spring-boot-starter-actuator

micrometer-registry-prometheus

Enable Prometheus Metrics Endpoint in application.properties:


management.endpoints.web.exposure.include=*
management.endpoint.prometheus.enabled=true
management.metrics.export.prometheus.enabled=true
Run your Spring Boot app:


./mvnw spring-boot:run
App will run on http://localhost:8080

Prometheus metrics available at: http://localhost:8080/actuator/prometheus

📊 Set Up Prometheus
Download Prometheus from: https://prometheus.io/download/

Create or edit prometheus.yml:


global:
  scrape_interval: 15s
  evaluation_interval: 15s

scrape_configs:
  - job_name: "prometheus"
    static_configs:
      - targets: ["localhost:9090"]

  - job_name: "spring-boot-app"
    metrics_path: "/actuator/prometheus"
    scrape_interval: 2s
    static_configs:
      - targets: ["localhost:8080"]
        labels:
          application: "My Spring Boot Prometheus Grafana Application"
Run Prometheus:


./prometheus --config.file=prometheus.yml
Access Prometheus: http://localhost:9090

📈 Set Up Grafana
Download Grafana from: https://grafana.com/grafana/download

Start Grafana:


./bin/grafana-server
Access Grafana: http://localhost:3000

Default login: admin / admin

Add Prometheus as a Data Source:

Go to ⚙️ Configuration > Data Sources

Click Add data source

Choose Prometheus

URL: http://localhost:9090

Click Save & Test

Create a Dashboard:

Click + Create > Dashboard > Add New Panel

Select metrics like:

http_server_requests_seconds_count

jvm_memory_used_bytes

Click Apply and save the dashboard

✅ Outcome
Spring Boot exposes metrics at /actuator/prometheus

Prometheus scrapes and stores metrics from Spring Boot

Grafana visualizes metrics using Prometheus as a data source
