package POM.locators;

import org.openqa.selenium.support.PageFactory;

public class SalesDelasLocators {
    public static final String SALESANDDEALS = "#TopNav > div.TopNav_linksContainer_03 > div:nth-child(14) > a";
    public static final String SALESANDDEALS_NAVBAR_LIST ="#TopNav > div.TopNav_linksContainer_03 > div > a";
    public static final String SHHOP_BY_DEPARTMENT_LIST = "#dealsPage > div.department_deptSection_0b div.department_deptTileCallout1_4d > div";
    public static final String SEASONAL_SALES_HEADINGS = "#dealsPage  div.seasonal_seasonalHeadingWrapper_5a > h2";
    public static final String DEALS_BY_DEPARTMENT_HEADING ="#dealsPage  div.department_deptHeadingWrapper_0b > h2";
    public static final String FILTER_CATEGORY_LIST = "//*[@id='refinementNav']/div[2]/div[@id]";//xpath
    public static final String FILTER_COLOR_LIST = "#colors-list > li > a > div > label > span.refinement-text";
    public static final String FILTER_COLOR_RESULT ="#refinementNav > div.restrictions-wrapper-container > ul > li[title='color']";
    public static final String PRODUCT_PRICE_LIST = "article div.priceRatingTitle > div.productPricing._2DfMCJ > div";
    public static final String PRODUCT_DETAILS_BUTTON = "article:nth-child(1) > a  div.infoButtonContainer ";
    public static final String DETAILS_RESULT ="div._1Xxn4R  h2 > a";
    public static final String ADD_PRODUCT_QUANTITY = "addqty23122779";//ID
    public static final String QUANTITY_DROP_DOWN_LIST = "#addqty23122779 > option";
    public static final String ADD_T0_CART_BUTTON = "addCartMain_addCartButton";//ID
    public static final String ADD_T0_CART_ALERT_MESSAGE = "#optbreakout > div > div.alert.error-message";
    public static final String ADD_T0_CART_PRODUCT_COLOR_OPTION = "#optbreakout div.facets.thumbnails > button:nth-child(2)";
    public static final String ADD_T0_CART_ERROR_MESSAGE = "body > h1";
}
