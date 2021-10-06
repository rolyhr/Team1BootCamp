package espnLocators;

public class ESPNLocators {

    public static final String TOP_EVENTS_DROPDOWN = "//button[contains(text(),'Top Events')]";
    public static final String TOP_EVENTS_DROPDOWN_MENU = "#global-scoreboard > div > div > div.scoreboard-dropdown-wrapper.scoreboard-menu > div.dropdown-wrapper.league-nav-desktop.desktop-dropdown.hoverable > ul";
    public static final String UFC_HEADER_TILE = "#leagues > li:nth-child(1) > div > div.scoreLabel.mma.js-show > div";
    public static final String HEADER_SCROLL_RIGHT = "#global-scoreboard > div > div > div.scores-next.controls";
    public static final String HEADER_SCROLL_LEFT = "#global-scoreboard > div > div > div.scores-prev.controls";
    public static final String NFL_DROPDOWN = "#global-nav > ul > li.sports.menu-nfl > a > span";
    public static final String NFL_DROPDOWN_MENU_LEFT = "//*[@id=\"global-nav\"]/ul/li[1]/div/ul[1]";
    public static final String NFL_DROPDOWN_MENU_RIGHT = "#global-nav > ul > li.sports.menu-nfl.hover > div > ul:nth-child(2) > li > div";
    public static final String NBA_DROPDOWN = "#global-nav > ul > li.sports.menu-nba > a > span";
    public static final String NBA_DROPDOWN_MENU_LEFT = "#global-nav > ul > li.sports.menu-nba.hover > div > ul:nth-child(1)";
    public static final String NBA_DROPDOWN_MENU_RIGHT = "#global-nav > ul > li.sports.menu-nba.hover > div > ul:nth-child(2) > li > div";
    public static final String MLB_DROPDOWN = "#global-nav > ul > li.sports.menu-mlb > a > span";
    public static final String MLB_DROPDOWN_MENU_LEFT = "#global-nav > ul > li.sports.menu-mlb.hover > div > ul:nth-child(1)";
    public static final String MLB_DROPDOWN_MENU_RIGHT = "#global-nav > ul > li.sports.menu-mlb.hover > div > ul:nth-child(2) > li > div";

    //REGISTRATION & LOGIN
    public static final String I_FRAME = "//div/iframe[@id=\"disneyid-iframe\"]";
    public static final String LOGIN_BUTTON = "//article[@id=\"sideLogin-left-rail\"]/button[2]";
    public static final String INPUT_EMAIL_ADDRESS = "//*[@id=\"did-ui-view\"]//div[@class=\"field-group\"]//span/input[@type=\"email\"]";
    public static final String INPUT_PASSWORD = "//*[@id=\"did-ui-view\"]//div[@class=\"field-group\"]//span/input[@type=\"password\"]";
    public static final String FORM_LOGIN_BUTTON = "//*[@id=\"did-ui-view\"]//div[@class=\"btn-group touch-print-btn-group-wrapper\"]//button";
    public static final String WARNING_LOGIN_ERROR_MSG = "//*[@id=\"did-ui-view\"]//div[@ng-repeat=\"item in parsedItems\"]";
    public static final String CONTAINER_ESPN_SITE_HEADER = "#main-container > div > section.col-one > article:nth-child(5) > div > header";
    public static final String CONTAINER_ESPN_SITE_LIST = "#main-container > div > section.col-one > article:nth-child(5) > div > ul";
    public static final String CONTAINER_FOLLOW_ESPN_HEADER = "#main-container > div > section.col-one > article:nth-child(7) > div > header > h2";
    public static final String CONTAINER_FOLLOW_ESPN_LIST = "#main-container > div > section.col-one > article:nth-child(7) > div > ul";

    public static final String TOP_EVENTS_DROPDOWN_MENU_ITEMS = "//*[@id=\"global-scoreboard\"]/div/div/div[1]/div[2]/ul/li/a";
    public static final int TOP_EVENT_DROPDOWN_COUNT = 10;
    public static final String NFL_DROPDOWN_LEFT_MENU_ITEMS = "#global-nav > ul > li.sports.menu-nfl>div>ul:nth-child(1)>li:not([style*=\"display: none;\"])>a>span>span:not([class*=\"link-text-short\"])";
    public static final int HEADER_DROPDOWN_LIST_SIZE = 9;
    public static final String[] NFL_DROPDOWN_MENU_LEFT_ITEMS = {"Home", "Scores", "Schedule", "Teams", "Standings", "Stats", "Draft", "Depth Charts", "Free Agency"};
    public static final String NFL_DROPDOWN_LEFT_MENU_LINKS = "#global-nav > ul > li.sports.menu-nfl>div>ul:nth-child(1)>li:not([style*=\"display: none;\"])>a";
    public static final String [] EXPECTED_NFL_DROPDOWN_LEFT_MENU_LINKS = {"https://www.espn.com/nfl/", "https://www.espn.com/nfl/scoreboard", "https://www.espn.com/nfl/schedule", "https://www.espn.com/nfl/teams", "https://www.espn.com/nfl/standings",
                                                                           "https://www.espn.com/nfl/stats", "https://www.espn.com/nfl/draft/news", "https://www.espn.com/nfl/story/_/id/29098001/2020-nfl-depth-charts-all-32-teams",
                                                                           "https://www.espn.com/nfl/nfl-free-agency/"};
    public static final String NFL_DROPDOWN_MENU_DIVISION = "#global-nav > ul > li.sports.menu-nfl > div > ul:nth-child(2) > li > div > ul>li>span>span:not([class*=\"link-text-short\"])";
    public static final String[] EXPECTED_NFL_DIVISION = {"AFC East", "AFC North", "AFC South", "AFC West", "NFC East", "NFC North", "NFC South", "NFC West"};
    public static final String NFL_DROPDOWN_MENU_TEAMS = "#global-nav > ul > li.sports.menu-nfl.hover > div > ul:nth-child(2) > li > div ul>li:not([class*=\"conference label group\"])>a>span>span:not([class*=\"link-text-short\"])";
    public static final int NFL_TEAMS_COUNT = 32;
    public static final String[] EXPECTED_NFL_TEAM_NAMES = {"Buffalo Bills", "Miami Dolphins", "New England Patriots", "New York Jets", "Baltimore Ravens", "Cincinnati Bengals", "Cleveland Browns", "Pittsburgh Steelers", "Houston Texans", "Indianapolis Colts", "Jacksonville Jaguars", "Tennessee Titans",
                                                            "Denver Broncos", "Kansas City Chiefs", "Las Vegas Raiders", "Los Angeles Chargers", "Dallas Cowboys", "New York Giants", "Philadelphia Eagles", "Washington Redskins", "Chicago Bears", "Detroit Lions", "Green Bay Packers", "Minnesota Vikings", "Atlanta Falcons", "Carolina Panthers",
                                                            "New Orleans Saints", "Tampa Bay Buccaneers", "Arizona Cardinals", "Los Angeles Rams", "San Francisco 49ers", "Seattle Seahawks"};
    public static final String NBA_DROPDOWN_MENU_ITEMS_LEFT = "#global-nav > ul > li.sports.menu-nba.hover > div > ul:nth-child(1) > li:not([style*=\"display: none;\"])>a>span>span:not([class=\"link-text-short\"])";
    public static final String[] EXPECTED_NBA_DROPDOWN_MENU_ITEMS_LEFT = {"Home", "Orlando Playoffs", "The Last Dance", "Scores", "Schedule", "Standings", "Stats", "Teams", "Draft"};
    public static final String NBA_DROPDOWN_MENU_LINKS_LEFT = "#global-nav > ul > li.sports.menu-nba.hover > div > ul:nth-child(1)>li:not([style*=\"display: none;\"])>a";
    public static final String[] EXPECTED_NBA_DROPDOWN_MENU_LEFT_LINKS = {"https://www.espn.com/nba/", "https://www.espn.com/nba/story/_/id/28911848/when-nba-return-latest-updates-amid-coronavirus-suspension", "https://www.espn.com/nba/story/_/id/28973557/the-last-dance-updates-untold-story-michael-jordan-chicago-bulls",
                                                                          "https://www.espn.com/nba/scoreboard", "https://www.espn.com/nba/schedule", "https://www.espn.com/nba/standings", "https://www.espn.com/nba/stats", "https://www.espn.com/nba/teams", "http://www.espn.com/nba/draft/news"};
    public static final int EXPECTED_NBA_TEAMS_COUNT = 30;
    public static final String[] EXPECTED_NBA_TEAM_NAMES = {"Boston Celtics", "Brooklyn Nets", "New York Knicks", "Philadelphia 76ers", "Toronto Raptors", "Chicago Bulls", "Cleveland Cavaliers", "Detroit Pistons", "Indiana Pacers", "Milwaukee Bucks", "Atlanta Hawks", "Charlotte Hornets",
                                                         "Miami Heat", "Orlando Magic", "Washington Wizards", "Golden State Warriors", "LA Clippers", "Los Angeles Lakers", "Phoenix Suns", "Sacramento Kings", "Dallas Mavericks", "Houston Rockets", "Memphis Grizzlies", "New Orleans Pelicans", "San Antonio Spurs", "Denver Nuggets",
                                                         "Minnesota Timberwolves", "Oklahoma City Thunder", "Portland Trail Blazers", "Utah Jazz"};
    public static final String MLB_DROPDOWN_LEFT_MENU_ITEM = "#global-nav > ul > li.sports.menu-mlb.hover > div > ul:nth-child(1) > li:not([style*=\"display: none;\"])>a>span>span:not([class=\"link-text-short\"])";
    public static final String[] MLB_DROPDOWN_MENU_ITEMS_LEFT = {"Home", "Draft", "When could MLB return?", "KBO League", "Teams", "Scores", "Schedule", "Standings", "Stats"};
    public static final String[] EXPECTED_ELEMENT_MLB_DIVISIONS = {"AL East", "AL Central", "AL West", "NL East", "NL Central", "NL West"};
    public static final String[] EXPECTED_MLB_DROPDOWN_MENU_LEFT_LINKS = {"https://www.espn.com/mlb/", "https://www.espn.com/mlb/story/_/id/29144339/2020-mlb-draft-mock-drafts-rankings-order-more", "https://www.espn.com/mlb/story/_/id/28910482/when-mlb-actually-return-here-latest-hearing",
                                                                          "https://www.espn.com/mlb/story/_/id/29136672/kbo-espn-schedule-how-watch-teams-korea-baseball-league-more", "https://www.espn.com/mlb/teams", "https://www.espn.com/mlb/scoreboard", "https://www.espn.com/mlb/schedule", "https://www.espn.com/mlb/standings", "https://www.espn.com/mlb/stats"};
    public static final String MLB_DROPDOWN_LEFT_MENU_LINKS = "#global-nav > ul > li.sports.menu-mlb.hover > div > ul:nth-child(1)>li:not([style*=\"display: none;\"])>a";
    public static final String MLB_DROPDOWN_MENU_DIVISIONS = "#global-nav > ul > li.sports.menu-mlb.hover > div > ul:nth-child(2) > li > div >ul>li[class*=\"conference label group\"]>span>span:not([class*=\"link-text-short\"])";
    public static final String MLB_DROPDOWN_MENU_TEAMS = "#global-nav > ul > li.sports.menu-mlb.hover > div > ul:nth-child(2)>li>div>ul>li[class*=\"team\"]>a>span>span:not([class*=\"link-text-short\"])";
    public static final int EXPECTED_MLB_TEAMS_COUNT = 30;
    public static final String[] EXPECTED_MLB_TEAM_NAMES = {"Baltimore Orioles", "Boston Red Sox", "New York Yankees", "Tampa Blue Rays", "Toronto Blue Jays", "Chicago White Sox", "Cleveland Indians", "Detroit Tigers", "Kansas City Royals", "Minnesota Twins",
                                                         "Houston Astros", "Los Angeles Angels", "Oakland Athletics", "Seattle Mariners", "Texas Rangers", "Atlanta Braves", "Miami Marlins", "New York Mets", "Philadelphia Phillies", "Washington Nationals", "Chicago Cubs", "Cincinnati Reds",
                                                         "Milwaukee Brewers", "Pittsburgh Pirates", "St. Louis Cardinals", "Arizona Diamondbacks", "Colorado Rockies", "Los Angeles Dodgers", "San Diego Padres", "San Francisco Giants"};
    public static final String LOGIN_ERROR_MESSAGE = "The credentials you entered are incorrect.\nReminder: Passwords are case sensitive.";
    public static final String ESPN_SITE_LIST_ITEMS = "#main-container > div > section.col-one > article:nth-child(5) > div > ul > li a div span";
    public static final String ESPN_SITES_HEADER_TITLE = "ESPN Sites";
    public static final int ESPN_SITES_LIST_COUNT = 6;
    public static final String[] ESPN_SITES_LIST_ITEM_NAMES = {"ESPN Deportes", "The Undefeated", "espnW", "ESPNFC", "X Games", "SEC Network"};
    public static final String ESPN_FOLLOW_LIST_ITEMS = "#main-container > div > section.col-one > article:nth-child(7) > div > ul li div:not([class=\"quicklinks_list__icon\"])>span";
    public static final String ESPN_FOLLOW_HEADER_TITLE = "Follow ESPN";
    public static final int ESPN_FOLLOW_LIST_COUNT = 9;
    public static final String[] ESPN_FOLLOW_LIST_ITEM_NAMES = {"Facebook", "Twitter", "Instagram", "Snapchat", "YouTube", "Quibi", "The ESPN Daily Podcast", "The ESPN Daily Newsletter", "ESPN Daily Calendar"};
    public static final String NBA_DROPDOWN_MENU_DIVISIONS = "#global-nav > ul > li.sports.menu-nba.hover > div > ul:nth-child(2) > li > div >ul>li[class*=\"conference label group\"]>span>span:not([class*=\"link-text-short\"])";
    public static final String[] NBA_DIVISIONS = {"Atlantic", "Central", "Southeast", "Pacific", "Southwest", "Northwest"};
    public static final String NBA_DROPDOWN_MENU_TEAMS = "#global-nav > ul > li.sports.menu-nba.hover > div > ul:nth-child(2)>li>div>ul>li[class*=\"team\"]>a>span>span:not([class*=\"link-text-short\"])";

    public static final String NBA_PAGE = "//*[@id=\"global-nav\"]/ul/li[2]/a/span/span[1]";
    public static final String NBA_PAGE_URL = "https://www.espn.com/nba/";
    public static final String ESPN_PLUS_LIST = "//*[@id=\"main-container\"]/div/section[1]/article[1]/div/ul/li";
    public static final String QUICK_LINK_LIST = "//*[@id=\"main-container\"]/div/section[1]/article[2]/div/ul/li";
    public static final String STATS_BOX = "//*[@id=\"global-nav-secondary\"]/div/ul/li[8]/a";
    public static final String STATS_LISTS_SUB_HEADER = "//*[@id=\"global-nav-secondary\"]/div/ul/li[8]/div/ul/li/a";
    public static final String TEAMS_BOX = "//*[@id=\"global-nav-secondary\"]/div/ul/li[9]/a";
    public static final String TEAMS_SUB_HEADER = "//*[@id=\"global-nav-secondary\"]/div/ul/li[9]/div/ul/li/div/ul/li/a";
    public static final String PODCAST_LISTS = "//*[@id=\"main-container\"]/div/section[1]/article[5]/div/ul/li";
    public static final String FANTASY_LIST = "//*[@id=\"main-container\"]/div/section[1]/article[6]/div/ul/li";
    public static final String ESPN_SITE_LIST = "//*[@id=\"main-container\"]/div/section[1]/article[7]/div/ul/li";
    public static final String ESPN_APPS_LIST = "//*[@id=\"main-container\"]/div/section[1]/article[8]/div/ul/li/a";
    public static final String ESPN_FOLLOW_LIST = "//*[@id=\"main-container\"]/div/section[1]/article[9]/div/ul/li/a";
    public static final String TOP_EVENT_DROPDOWN = "//button[contains(text(),'Top Events')]";
    public static final String TOP_EVENT_DROPDOWN_MENU = "#global-scoreboard > div > div > div.scoreboard-dropdown-wrapper.scoreboard-menu > div.dropdown-wrapper.league-nav-desktop.desktop-dropdown.hoverable > ul";
    public static final String TOP_EVENT_DROPDOWN_MENU_ITEMS = "//*[@id=\"global-scoreboard\"]/div/div/div[1]/div[2]/ul/li/a";
    public static final String ESPN_FOOTER_LIST = "//*[@id=\"main-container\"]/div/footer/div[2]/div/div[2]/ul/li/a";
    public static final String NBA_DROPDOWN_LIST = "#global-nav > ul > li.sports.menu-nba > a > span";
    public static final String NBA_DROPDOWN_LEFT_MENU = "#global-nav > ul > li.sports.menu-nba.hover > div > ul:nth-child(1)";

}
