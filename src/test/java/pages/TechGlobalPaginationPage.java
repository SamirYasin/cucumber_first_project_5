package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TechGlobalPaginationPage extends TechGlobalBasePage {
    public TechGlobalPaginationPage(){
        super();
    }

    @FindBy(id = "main_heading")
    public WebElement heading;

    @FindBy(id = "sub_heading")
    public WebElement subHeading;

    @FindBy(id = "content")
    public WebElement paragraph;

    @FindBy(id = "previous")
    public WebElement previous;

    @FindBy(id = "next")
    public WebElement next;

    @FindBy(css = ".city_info")
    public WebElement city;

    @FindBy(css = ".country_info")
    public WebElement country;

    @FindBy(css = "population_info")
    public WebElement population;
}


