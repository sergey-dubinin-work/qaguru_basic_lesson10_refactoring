package guru.qa.demoqa.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;

public enum Browsers {

    CHROME(
            WebDriverManager.chromedriver()
    );


    final WebDriverManager webDriverManager;

    Browsers(WebDriverManager webDriverManager){
        this.webDriverManager = webDriverManager;
    }
}
