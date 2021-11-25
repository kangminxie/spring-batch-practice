package com.kangmin.app.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class DemoStepExecutionListener implements StepExecutionListener {

    private static final Logger LOG = LoggerFactory.getLogger(DemoStepExecutionListener.class);

    @Override
    public void beforeStep(StepExecution stepExecution) {
        LOG.info(">>> [Step] DemoStepExecutionListener.beforeStep");
        LOG.info(">>> [Step] DemoStepExecutionListener's ExecutionContext: " + stepExecution.getJobExecution().getExecutionContext());
        LOG.info(">>> [Step] DemoStepExecutionListener's JobParameters: " + stepExecution.getJobExecution().getJobParameters());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        LOG.info(">>> [Step] DemoStepExecutionListener.afterStep");
        return null;
    }
}
