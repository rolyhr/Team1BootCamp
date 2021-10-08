package POM;
import POM.locators.FlightsLocators;
import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static POM.locators.FlightsLocators.*;


public class Flights extends Base {

   public Flights() {
      PageFactory.initElements(driver, this);
   }

   @FindBy(css = FLIGHTS)
   public WebElement navigateToFlights;

   @FindBy(xpath = ONE_WAY)
   public WebElement navigateToOneWay;

   @FindBy(xpath = ROUND_TRIP)
   public WebElement navigateToRoundTrip;

   @FindBy(xpath = MULTI_CITY)
   public WebElement navigateToMultiCity;

   @FindBy(css = TRAVELER_DROPDOWN)
   public WebElement travelerDropDown;

   public void navigateToFlights(){
      clickOnElement(navigateToFlights);
    //  clickJScript(navigateToFlights);
   }

   public void navigateToOneWayTab(){
      clickOnElement(navigateToOneWay);
   }

   public void navigateToMultiCityTab(){
      clickOnElement(navigateToMultiCity);
   }

   public void navigateToRoundTripTab(){
      clickJScript(navigateToRoundTrip);
   }

   public String clickOnTravelerDropDown(){

      clickJScript(travelerDropDown);
      String areaExpanded = travelerDropDown.getAttribute("aria-expanded");
      return areaExpanded;
   }

}
