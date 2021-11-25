package com.kangmin.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChunkSpringBatchApplication {

    private static final Logger LOG = LoggerFactory.getLogger(ChunkSpringBatchApplication.class);

    public static void main(String[] args) {
        LOG.info(">>> AppSpringBatchApplication is starting");
        SpringApplication.run(ChunkSpringBatchApplication.class, args);
        LOG.info(">>> AppSpringBatchApplication is done");
    }

}
