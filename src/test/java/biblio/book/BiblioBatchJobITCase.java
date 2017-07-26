package biblio.book;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by heroinedor on 12/07/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context-test.xml", "classpath:jobs/biblioBatchJob.xml"})
public class BiblioBatchJobITCase {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    public void testJob() throws Exception {
        //TODO add 2 jobParameters to the jobLaunch method :
        // -  key : "fileName", value "file:C:/temp/books/lorem-ipsum.txt" => to set the file to load in DB
        // -  key : "random", value : a random number between 0 and 1000000 => a random parameter to let the job be restarted as much as wanted
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();

        Assert.assertEquals("COMPLETED", jobExecution.getExitStatus().getExitCode());
    }
}