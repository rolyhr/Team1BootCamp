package POM.locators;

public class FlightsLocators {

    public static final String FLIGHTS = "div.uitk-tabs-container ul li:nth-child(2)"; //css

    public static final String ROUND_TRIP = "//*[@id=\"uitk-tabs-button-container\"]//span[text()='Roundtrip']"; //xpath
    public static final String MULTI_CITY = "//*[@id=\"uitk-tabs-button-container\"]//span[text()='Multi-city']"; //xpath
    public static final String ONE_WAY = "//*[@id=\"uitk-tabs-button-container\"]//span[text()='One-way']"; //xpath

    public static final String TRAVELER_DROPDOWN = "#adaptive-menu > a"; //CSS

    public static final String FLIGHTS_SEARCH_ERROR_MESSAGE = "div.uitk-error-summary h3";
    public static final String SUBMIT_BUTTON = "#wizard-flight-pwa button[type*='Submit']";
    public static final String LEAVING_FORM= "#location-field-leg1-origin-menu  button";
    public static final String GOING_TO = "#location-field-leg1-destination-menu  button";
    public static final String SEARCH_RESULT  ="//*[@id='app-layer-base']/div[2]/div[3]/div[1]/aside/fieldset/div/legend";
    public static final String GOING_TO_SUGGESTION = "#location-field-leg1-destination-menu > div.uitk-menu-container.uitk-menu-open.uitk-menu-pos-left.uitk-menu-container-text-nowrap > ul > li:nth-child(1)";
    public static final String LEAVING_FORM_SUGGESTION = "#location-field-leg1-origin-menu > div.uitk-menu-container.uitk-menu-open.uitk-menu-pos-left.uitk-menu-container-text-nowrap > ul > li:nth-child(1) > button > div > div.is-subText.truncate";
}
