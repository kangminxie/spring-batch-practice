package com.kangmin.app.config;

import com.kangmin.app.listener.DemoJobExecutionListener;
import com.kangmin.app.listener.DemoStepExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class JobAndTaskConfig {

    private static final Logger LOG = LoggerFactory.getLogger(JobAndTaskConfig.class);

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public JobAndTaskConfig(
        final JobBuilderFactory jobBuilderFactory,
        final StepBuilderFactory stepBuilderFactory
    ) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Job demoJob() {
        return jobBuilderFactory.get("demoJob")
            .listener(new DemoJobExecutionListener())
            .start(demoStep1())
            .build();
    }

    @Bean
    public Step demoStep1() {
        return stepBuilderFactory.get("demoStep1")
            .listener(new DemoStepExecutionListener())
            .tasklet(demoTasklet1())
            .build();
    }

    private Tasklet demoTasklet1() {
        return (new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                LOG.info(">>> demoTasklet is executed");
                return RepeatStatus.FINISHED;
            }
        });
    }
}
