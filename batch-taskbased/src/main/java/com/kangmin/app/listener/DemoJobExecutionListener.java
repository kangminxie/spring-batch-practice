package com.kangmin.app.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class DemoJobExecutionListener implements JobExecutionListener {

    private static final Logger LOG = LoggerFactory.getLogger(DemoJobExecutionListener.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {
        LOG.info(">>> [Job] DemoJobExecutionListener.beforeJob");
        LOG.info(">>> [Job] DemoJobExecutionListener.JobName: " + jobExecution.getJobInstance().getJobName());
        LOG.info(">>> [Job] DemoJobExecutionListener.ExecutionContext: " + jobExecution.getExecutionContext());
        jobExecution.getExecutionContext().put("demoKey", "demoValue2021");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        LOG.info(">>> [Job] DemoJobExecutionListener.afterJob");
    }
}
