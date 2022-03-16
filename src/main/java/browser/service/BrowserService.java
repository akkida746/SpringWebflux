package browser.service;

import java.io.IOException;
import java.net.URISyntaxException;

public interface BrowserService {

    public void start(String browser, String url) throws URISyntaxException, IOException;

    public void stop(String browser) throws IOException;

    public void cleanup(String browser);

    public void geturl(String browser) throws IOException;
}
