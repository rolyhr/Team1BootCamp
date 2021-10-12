package POM.locators;

import org.openqa.selenium.support.PageFactory;

public class FashionLocators {
 //   public static  final String FASHION_NAV = "div.hl-cat-nav > ul > li:nth-child(4) > a";
    //category
    public static  final String FASHION_NAV = "#mainContent > div.hl-cat-nav > ul > li:nth-child(4)";
    public static  final String FASHION_CATEGORY_DROPDOWN_MENU = "div.hl-cat-nav > ul > li:nth-child(4) > a";
    public static  final String FASHION_SUBCATEGORY_PANEL = "#mainContent  li.hl-cat-nav__js-tab.hl-cat-nav__js-show  div.hl-cat-nav__sub-cats";
    public static  final String FASHION_CATEGORY_LIST = "#mainContent > div.hl-cat-nav > ul > li:nth-child(4) > div.hl-cat-nav__flyout > div.hl-cat-nav__sub-cats > nav:nth-child(1) > ul>li";
    public static final String FASHION_MORE_CATEGORY_LIST = "#mainContent > div.hl-cat-nav > ul > li:nth-child(4) > div.hl-cat-nav__flyout > div.hl-cat-nav__sub-cats > nav:nth-child(2) > ul>li";
    public static final String FASHION_SHOP_BY_CATEGORY_LIST = "#mainContent > section.b-module.b-visualnav > div.b-visualnav__grid > a > div.b-visualnav__title ";


    //search
    public static final String SEARCHBOX = "gh-ac";
    public static final String SEARCH_BUTTON = "gh-btn";
    public static final String SEARCH_RESULT = "#mainContent   div:nth-child(1) > div.srp-controls__control.srp-controls__count > h1 > span:nth-child(1)";

    //women shoees modal Window
   public static final  String SEE_ALL_WOMENSHOES_SH0PBYBRAND = "#mainContent  div.b-carousel__seeall > button > span:nth-child(1)";
   public static final  String SEE_ALL_CONTAINER  = "x-overlay__form";//ID
   public static final String DELEIVERY_OPTION = "c3-mainPanel-delivery";//ID
   public static final String CHECK_BOX_FREE_INTERNATIONAL_SHIPPING = "c3-subPanel-LH_FS_Free%20International%20Shipping_cbx";//ID
   public static final String APPLY_BUTTON = "#x-overlay__form > div.x-overlay__container > button > svg";
   public static final String FILTER_RESULT = "span.brm-pill__item-label";

   //breadcrumb
    public static final String BREAD_CRUMB_LIST = "div.pagecontainer.srp-main--isLarge > div.pagecontainer__top > nav > ol > li";

    //filter buying format radio button
    public static final String BUYING_FORMAT_FILTER = "#s0-27_3-9-0-1\\[0\\]-0-1-6-6-4\\[7\\]-flyout > button > span";
    public static final String BUYING_FORMAT_FILTER_DROP_DOWN_CONTAINER = "#s0-27_3-9-0-1\\[0\\]-0-1-6-6-4\\[7\\]-flyout > div";
    public static final String BUYING_FORMAT_FILTER_LIST = "#s0-27_3-9-0-1\\[0\\]-0-1-6-6-4\\[7\\]-flyout > div li";
    public static final String BUYING_FORMAT_FILTER_RESULT = "#s0-27_1-9-0-1\\[0\\]-0-1 > section  a > span.brm-pill__item-label";

    //fiter condition checkbox
    public static final String CONDITION_FILTER = "#s0-27_3-9-0-1\\[0\\]-0-1-6-6-4\\[5\\]-flyout > button > span";
    public static final String CONDITION_FILTER_DROP_DOWN_CONTAINER = "#s0-27_3-9-0-1\\[0\\]-0-1-6-6-4\\[5\\]-flyout > div";
    public static final String CONDITION_FILTER_LIST = "#s0-27_3-9-0-1\\[0\\]-0-1-6-6-4\\[5\\]-flyout > div li";
    public static final String CONDITION_FILTER_RESULT = "#s0-27_1-9-0-1\\[0\\]-0-1 > section  a > span.brm-pill__item-label";

}
