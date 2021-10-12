package POM;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MotorsHomePage extends Base {

    public MotorsHomePage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath="/html/body/div[5]/div[2]/h1/span")
    public WebElement eBayMotors;


    @FindBy(xpath="//*[@id=\"s0-27_1-9-0-1[0]-0-2-4-0-CAR_AND_TRUCK-tab\"]")
    public WebElement selectCarsAndTrucksHeader;

    @FindBy(xpath="//*[@id=\"s0-27_1-9-0-1[0]-0-2-4-CAR_AND_TRUCK_0\"]/select/option[5]")
    public WebElement selectYearForCarsAndTrucks;

    @FindBy(css="//*[@id=\"s0-27-9-0-1[0]-0-2-4-CAR_AND_TRUCK_1\"]/select")
    public WebElement selectMakeForCarsAndTrucks;

    @FindBy(xpath="//*[@id=\"s0-27-9-0-1[0]-0-2-4-CAR_AND_TRUCK_2\"]/select")
    public WebElement selectModelForCarsAndTrucks;

    @FindBy(css="//*[@id=\"s0-27-9-0-1[0]-0-2-4-CAR_AND_TRUCK_3\"]/select")
    public WebElement trimForCarsAndTrucks;

    @FindBy(xpath="//*[@id=\"s0-27-9-0-1[0]-0-2-4-CAR_AND_TRUCK_4\"]/select")
    public WebElement engineForCarsAndTrucks;

    @FindBy(css="//*[@id=\"s0-27-9-0-1[0]-0-2-4-7[0[0]]\"]")
    public WebElement searchPartsForCarsAndTrucks;

    @FindBy(xpath="//*[@id=\"mainContent\"]/section[1]/div[1]/h2")
    public WebElement shopPartsAndAccessoriesCategoriesForCarsAndTrucks;


    @FindBy(css="//*[@id=\"mainContent\"]/section[1]/div[2]/a/div[2]")
    public List<WebElement> categoryListForCarsAndTrucks;

    @FindBy(xpath="//*[@id=\"s0-27-9-0-1[0]-0-2-4-0-MOTORCYCLE-tab\"]/span")
    public WebElement motorcycles;

    @FindBy(xpath="//*[@id=\"s0-27-9-0-1[0]-0-2-4-MOTORCYCLE_0\"]/select")
    public WebElement selectYearMotorcycles;

    @FindBy(css="//*[@id=\"s0-27-9-0-1[0]-0-2-4-MOTORCYCLE_1\"]/select")
    public WebElement selectMakeMotorcycles;

    @FindBy(xpath="//*[@id=\"s0-27-9-0-1[0]-0-2-4-MOTORCYCLE_2\"]/select")
    public WebElement modelMotorcycles;

    @FindBy(css="//*[@id=\"s0-27-9-0-1[0]-0-2-4-MOTORCYCLE_3\"]/select")
    public WebElement subModelMotorcycles;

    @FindBy(css="//*[@id=\"s0-27-9-0-1[0]-0-2-4-7[0[1]]\"]")
    public WebElement searchPartsForMotorcycles;

    @FindBy(xpath="//*[@id=\"mainContent\"]/section[1]/div[1]/h2")
    public WebElement shopPartsAndAccessoriesCategoriesMotorcycles;


    @FindBy(css="//*[@id=\"mainContent\"]/section[1]/div[2]/a/div[2]")
    public List<WebElement> categoryListMotorcycles;

    @FindBy(xpath="//*[@id=\"s0-27-9-0-1[0]-0-2-4-0-OTHER_VEHICLE-tab\"]/span")
    public WebElement otherVehicles;

    @FindBy(xpath="//*[@id=\"s0-27-9-0-1[0]-0-2-4-OTHER_VEHICLE_0\"]/select")
    public WebElement aviationPartsAndAccessoriesForOtherVehicles;

    @FindBy(xpath="//*[@id=\"s0-27-9-0-1[0]-0-2-4-OTHER_VEHICLE-tabpanel\"]/section/div/span[2]/span/input")
    public WebElement WheelsForotherVehicles;

    @FindBy(xpath="//*[@id=\"s0-27-9-0-1[0]-0-2-4-7[0[2]]\"]")
    public WebElement searchPartsForOtherVehicles;



//    public WebElement getFindPartsAndAccessoriesHeader() {
//        return findPartsAndAccessoriesHeader;
//    }

    public void CarsAndTruck(){
        clickOnElement(selectCarsAndTrucksHeader);
    }



}
