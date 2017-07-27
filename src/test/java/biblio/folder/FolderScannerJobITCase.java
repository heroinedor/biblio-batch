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
        //TODO add an e2e test that uses jobLauncherFolder to launch the job with 2 jobParameters
        // -  key : "input.folder.name", value "file:C:\\temp\\books" => to set the folder to scan
        // -  key : "random", value : a random number between 0 and 1000000 => a random parameter to let the job be restarted as much as wanted

        JobParameters jobParameters = null;

        JobExecution jobExecution = jobLauncherFolder.launchJob();

        Assert.assertEquals("COMPLETED", jobExecution.getExitStatus().getExitCode());
    }
}