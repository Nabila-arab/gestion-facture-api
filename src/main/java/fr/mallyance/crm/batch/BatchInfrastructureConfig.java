package fr.mallyance.crm.batch;

/*import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchInfrastructureConfig {
*/
    /*@Bean
    public JobRepository jobRepository(DataSource dataSource, PlatformTransactionManager transactionManager) {
        return JobRepository.builder()
                .dataSource(dataSource)
                .transactionManager(transactionManager)
                .build();
    }

    @Bean
    public JobLauncher jobLauncher(JobRepository jobRepository) {
        // Utilisation de JobLauncher avec le nouveau builder
        return JobLauncher.builder()
                .jobRepository(jobRepository)
                .synchronizeOnJob(false) // Ne pas synchroniser les jobs (optionnel, selon votre besoin)
                .build();
    }*/

    /*@Bean
    public BatchConfigurer batchConfigurer(DataSource batchDataSource, PlatformTransactionManager transactionManager) {
        return new DefaultBatchConfigurer(batchDataSource) {
            @Override
            public PlatformTransactionManager getTransactionManager() {
                return transactionManager;
            }
        };
    }*/
//}

