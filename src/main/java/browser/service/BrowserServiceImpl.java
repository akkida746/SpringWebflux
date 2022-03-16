package browser.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BrowserServiceImpl implements BrowserService {

    String chromePath = "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe";
    Process process = null;

    public void start(String browser, String url) throws URISyntaxException, IOException {
        log.info("Starting..");
        log.info(browser);
        log.info(url);

        String os = System.getProperty("os.name").toLowerCase();
        Runtime rt = Runtime.getRuntime();

        if (false && browser.equalsIgnoreCase("chrome")) {
            //process = rt.exec(new String[]{chromePath, url});
            List<String> list = new ArrayList<>();
            list.add(chromePath);
            list.add(url);
            ProcessBuilder pb = new ProcessBuilder(list);
            process = pb.start();
        } else {
            process = rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
        }

    }

    public void stop(String browser) throws IOException {
        if (process != null) {
            process.destroyForcibly();
        }
        Runtime rt = Runtime.getRuntime();
        rt.exec("taskkill /IM \"chrome.exe\" /F");
    }

    public void cleanup(String browser) {

    }

    public void geturl(String browser) throws IOException {

        try (BufferedReader input =
                     new BufferedReader(new
                             InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        }

    }
}
