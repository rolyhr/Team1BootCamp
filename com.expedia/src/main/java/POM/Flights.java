package POM;
import POM.locators.FlightsLocators;
import base.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

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

   @FindBy(css = SUBMIT_BUTTON)
   public  WebElement submitButton;

   @FindBy(css = FLIGHTS_SEARCH_ERROR_MESSAGE)
   public  WebElement searchError;

   @FindBy(css = GOING_TO)
   public  WebElement goingTo;

   @FindBy(css = LEAVING_FORM)
   public  WebElement leavingFrom;

   @FindBy(xpath =SEARCH_RESULT)
   public WebElement searchResult;

   @FindBy(css =  GOING_TO_SUGGESTION)
   public WebElement goingToSuggestion;

   @FindBy(css =  LEAVING_FORM_SUGGESTION)
   public WebElement leavingFromSuggestion;


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

   public void sendValueGoingTo(String startLocation ){
      goingTo.sendKeys(startLocation);


   }

   public void sendValueLeavingFrom(String endLocation ){
      leavingFrom.sendKeys(endLocation);

   }

   public String clickOnTravelerDropDown(){

      clickJScript(travelerDropDown);
      return travelerDropDown.getAttribute("aria-expanded");
   }
   public void clickOnSubmitButton(){
    clickOnElement(submitButton);

   }

   public String getSearchErrorMessage(){
      navigateToFlights();
      clickOnSubmitButton();
     return searchError.getText();
   }

   public void searchFlightWithStartAndEndLocation(String startLocation,String endLocation){
      navigateToFlights();
      sendValueLeavingFrom(startLocation);
      clickOnElement(leavingFromSuggestion);
      sendValueGoingTo(endLocation);
      clickOnElement(goingToSuggestion);
      clickOnSubmitButton();
   }
   public String searchFlightWithoutLeavingFromLocation(String endLocation){
      navigateToFlights();
      sendValueGoingTo(endLocation);
      clickOnElement(goingToSuggestion);
      clickOnSubmitButton();
     return searchError.getText();
   }

   public String searchFlightWithoutGoingToLocation(String startLocation){
      navigateToFlights();
      sendValueLeavingFrom(startLocation);
      clickOnElement(leavingFromSuggestion);
      clickOnSubmitButton();
      return searchError.getText();
   }

   public String getSearchResult(){
      return searchResult.getText();
   }
}
