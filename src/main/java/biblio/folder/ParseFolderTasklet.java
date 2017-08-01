package biblio.folder;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.File;

/**
 * Created by heroinedor on 05/07/2017.
 */
public class ParseFolderTasklet implements Tasklet {

    private Resource resource;

    public RepeatStatus execute(StepContribution contribution,
                                ChunkContext chunkContext) throws Exception {
        //Folder content
        File folder = resource.getFile();
        File[] files = folder.listFiles();
        String[] inputFileNameList = new String[files.length];

        for (int i = 0; i < folder.listFiles().length; i++) {
            inputFileNameList[i] = files[i].getAbsolutePath();
        }

        //Add the "idBook" parameter in StepExecutionContext
        chunkContext
                .getStepContext()
                .getStepExecution()
                .getExecutionContext()
//                .put("file.list", files); files list case
                .put("fileName", inputFileNameList[1]);

        return RepeatStatus.FINISHED;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

}
