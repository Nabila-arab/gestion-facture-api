package fr.mallyance.crm;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

@SpringBootApplication
public class ApiCrmApplication {

    public static void main(String[] args) {

        //SpringApplication.run(ApiCrmApplication.class, args);


        ConfigurableApplicationContext context = SpringApplication.run(ApiCrmApplication.class, args);

        // Récupération du JobLauncher et du Job
        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        Job job = context.getBean("relanceFactureJob", Job.class);

        try {
            // Exécution du Job
            JobExecution execution = jobLauncher.run(job, new JobParametersBuilder()
                    .addDate("startTime", new Date()) // Ajoute un paramètre pour éviter les collisions
                    .toJobParameters());
            System.out.println("Job Status: " + execution.getStatus());
        } catch (Exception e) {
            System.err.println("Job failed: " + e.getMessage());
        }
    }

}
