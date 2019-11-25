package denys;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal();

    private DriverManager(){}

    public static WebDriver getDriver(){
        if (threadDriver.get()==null){
            initDriver();
        }
        return threadDriver.get();
    }

    private static void initDriver() {
        WebDriverManager.chromedriver().setup();
        threadDriver.set(new ChromeDriver());

        //threadDriver.get().manage().window().fullscreen();
        threadDriver.get().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        threadDriver.get().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    public static void killDriver(){
        threadDriver.get().close();
        threadDriver.remove();
    }
}
