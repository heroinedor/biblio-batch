package biblio.folder;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class FileNameParameterValidator implements ResourceLoaderAware {
    //TODO implement a JobParametersValidator interface
    // with the validate method which validates that the "fileName" parameter points to a valid file
    private ResourceLoader resourceLoader;

    private Resource[] resources;

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
