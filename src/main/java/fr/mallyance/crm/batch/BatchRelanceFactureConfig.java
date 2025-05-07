package fr.mallyance.crm.batch;

import fr.mallyance.crm.domain.entities.Facture;
import fr.mallyance.crm.infrastructure.repository.FactureRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.*;//JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;

import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchRelanceFactureConfig /*extends DefaultBatchConfiguration*/ {
    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    private final FactureRepository factureRepository;

    @Autowired
    public BatchRelanceFactureConfig(JobRepository jobRepository, PlatformTransactionManager transactionManager, FactureRepository factureRepository) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
        this.factureRepository = factureRepository;
    }


    @Bean
    public Job relanceFactureJob(Step factureStep) {
        return new JobBuilder("relanceFactureJob", jobRepository)
                .start(factureStep)
                .build();
    }

    @Bean
    public Step factureStep(ItemReader<Facture> reader, ItemProcessor<Facture, Facture> processor,
                            ItemWriter<Facture> writer) {
        return new StepBuilder("relanceFactureStep", jobRepository)
                .<Facture, Facture>chunk(10, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
