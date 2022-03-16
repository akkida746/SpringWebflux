package browser.controller;

import browser.service.BrowserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
public class BrowserController {

    @Autowired
    private BrowserService browserService;

    @GetMapping("/start/{browser}/{url}")
    public void start(@PathVariable String browser, @PathVariable String url) throws URISyntaxException, IOException {
        browserService.start(browser, url);
    }

    @GetMapping("/stop/{browser}")
    public void stop(@PathVariable String browser) throws IOException {
        browserService.stop(browser);
    }

    @GetMapping("/cleanup/{browser}")
    public void cleanup(@PathVariable String browser){
        browserService.cleanup(browser);
    }

    @GetMapping("/geturl/{browser}")
    public void geturl(@PathVariable String browser) throws IOException {
        browserService.geturl(browser);
    }

}
