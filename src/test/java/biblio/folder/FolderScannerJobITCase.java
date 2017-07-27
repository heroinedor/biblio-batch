package biblio.folder;

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

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by heroinedor on 12/07/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context-test.xml", "classpath:jobs/folderScannerJob.xml"})
public class FolderScannerJobITCase {

    @Autowired
    private JobLauncherTestUtils jobLauncherFolder;

    @Test
    public void testJob() throws Exception {

        JobParameters jobParameters =
                new JobParametersBuilder()
                        .addString("input.folder.name", "file:C:\\temp\\books")
                        .addLong("random", ThreadLocalRandom.current().nextLong(1000000L)).toJobParameters();

        JobExecution jobExecution = jobLauncherFolder.launchJob(jobParameters);

        Assert.assertEquals("COMPLETED", jobExecution.getExitStatus().getExitCode());
    }
}