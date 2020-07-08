package org.oth.springbatch;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestJobController {
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Autowired
    private BankTransactionItemAnalyticsProcessor bankTransactionItemAnalyticsProcessor;

    @GetMapping("/startJob")
    public BatchStatus loadFile() throws Exception {
        Map<String, JobParameter> jobParameter = new HashMap<>();
        jobParameter.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters = new JobParameters(jobParameter);
        JobExecution jobExecution = jobLauncher.run(job, jobParameters);
        while (jobExecution.isRunning()) {
            System.out.println(".......");
        }
        return jobExecution.getStatus();
    }

    @GetMapping("/analytics")
    public Map<String, Double> analytics() {
        Map<String, Double> result = new HashMap<>();
        result.put("TotalCredit", bankTransactionItemAnalyticsProcessor.getTotalCredit());
        result.put("TotalDebit", bankTransactionItemAnalyticsProcessor.getTotalDebit());
        return result;
    }
}
