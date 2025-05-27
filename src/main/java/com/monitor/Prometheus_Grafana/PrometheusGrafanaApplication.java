package com.monitor.Prometheus_Grafana;


import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@RestController
@EnableScheduling
@SpringBootApplication
public class PrometheusGrafanaApplication {

	final static org.slf4j.Logger logger = LoggerFactory.getLogger(PrometheusGrafanaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PrometheusGrafanaApplication.class, args);
	}

	@GetMapping("/hello")
	public ResponseEntity getMethodName() {
		logger.info("Request recieved from client......");
		return ResponseEntity.ok().body("success");
	}
	



}
