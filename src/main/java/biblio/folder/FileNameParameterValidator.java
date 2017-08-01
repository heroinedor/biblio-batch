package biblio.folder;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.JobParametersValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;

import java.io.File;
import java.io.IOException;

public class FileNameParameterValidator implements JobParametersValidator, ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    private Resource[] resources;

    public void validate(JobParameters parameters) throws JobParametersInvalidException {
        String fileNames = parameters.getString("input.folder.name");

        try {
            resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources(fileNames);
        } catch (IOException e) {
            throw new JobParametersInvalidException(e.getMessage());
        }

        if (resources == null || resources.length == 0) {
            throw new JobParametersInvalidException(fileNames + " : no file found.");
        } else {
            for (Resource res : resources) {
                File file = null;
                try {
                    file = res.getFile();
                    if (file.isDirectory()) {
                        throw new JobParametersInvalidException(res.getFilename() + " is a folder.");
                    }
                } catch (IOException e) {
                    throw new JobParametersInvalidException(res.getFilename() + " : " + e.getMessage());
                }
            }
        }
    }


    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}