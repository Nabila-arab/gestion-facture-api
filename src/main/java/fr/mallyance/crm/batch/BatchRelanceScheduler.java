package fr.mallyance.crm.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchRelanceScheduler {

    private final JobLauncher jobLauncher;
    private final Job factureJob;

    @Autowired
    public BatchRelanceScheduler(JobLauncher jobLauncher, Job factureJob) {
        this.jobLauncher = jobLauncher;
        this.factureJob = factureJob;
    }

    //@Scheduled(cron = "0 0 0 * * ?") // Planification à minuit chaque jour
    @Scheduled(cron = "0 */5 * * * ?") // Exécution toutes les 5 minutes
    public void runFactureJob() {
        try {
            JobParameters parameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();

            jobLauncher.run(factureJob, parameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
