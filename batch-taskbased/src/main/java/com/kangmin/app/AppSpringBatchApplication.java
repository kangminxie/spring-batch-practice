package com.kangmin.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppSpringBatchApplication {

    private static final Logger LOG = LoggerFactory.getLogger(AppSpringBatchApplication.class);

    public static void main(String[] args) {
        LOG.info(">>> AppSpringBatchApplication is starting");
        SpringApplication.run(AppSpringBatchApplication.class, args);
        LOG.info(">>> AppSpringBatchApplication is done");
    }

}
