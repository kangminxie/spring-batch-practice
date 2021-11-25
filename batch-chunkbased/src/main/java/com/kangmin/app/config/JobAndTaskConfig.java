package com.kangmin.app.config;

import com.kangmin.app.listener.DemoJobExecutionListener;
import com.kangmin.app.listener.DemoStepExecutionListener;
import com.kangmin.app.processor.InMemItemProcessor;
import com.kangmin.app.reader.InMemReader;
import com.kangmin.app.writer.ConsoleItemWriter;
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
    public Job twoStepsJob() {
        return jobBuilderFactory.get("twoStepsJob")
            .listener(new DemoJobExecutionListener())
            .start(taskletStep())
            .next(chunkStep())
            .build();
    }

    @Bean
    public Step taskletStep() {
        return stepBuilderFactory.get("taskletStep-1")
            .listener(new DemoStepExecutionListener())
            .tasklet(demoTasklet1())
            .build();
    }

    @Bean
    public Step chunkStep() {
        return stepBuilderFactory.get("chunkStep-2")
            .<Integer, Integer>chunk(3)
            .reader(new InMemReader())
            .processor(new InMemItemProcessor())
            .writer(new ConsoleItemWriter())
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
