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

    public static final String TOP_EVENTS_DOWNDOWN_MENU_ITEMS = "//*[@id=\"global-scoreboard\"]/div/div/div[1]/div[2]/ul/li/a";
    public static final int expectedElementTopEventsDropdownCount = 10;
    public static final String webElementNFLDropdownMenuItemsLeft = "#global-nav > ul > li.sports.menu-nfl>div>ul:nth-child(1)>li:not([style*=\"display: none;\"])>a>span>span:not([class*=\"link-text-short\"])";
    public static final int expectedHeaderDropdownListSize = 9;
    public static final String[] expectedElementNFLDropdownMenuItemsLeft = {"Home", "Scores", "Schedule", "Teams", "Standings", "Stats", "Draft", "Depth Charts", "Free Agency"};
    public static final String webElementNFLDropdownMenuLinksLeft = "#global-nav > ul > li.sports.menu-nfl>div>ul:nth-child(1)>li:not([style*=\"display: none;\"])>a";
    public static final String [] expectedElementNFLDropdownMenuLeftLinks = {"https://www.espn.com/nfl/", "https://www.espn.com/nfl/scoreboard", "https://www.espn.com/nfl/schedule", "https://www.espn.com/nfl/teams", "https://www.espn.com/nfl/standings",
                                                                             "https://www.espn.com/nfl/stats", "https://www.espn.com/nfl/draft/news", "https://www.espn.com/nfl/story/_/id/29098001/2020-nfl-depth-charts-all-32-teams",
                                                                             "https://www.espn.com/nfl/nfl-free-agency/"};
    public static final String webElementNFLDropdownMenuDivisions = "#global-nav > ul > li.sports.menu-nfl > div > ul:nth-child(2) > li > div > ul>li>span>span:not([class*=\"link-text-short\"])";
    public static final String[] expectedElementNFLDivisions = {"AFC East", "AFC North", "AFC South", "AFC West", "NFC East", "NFC North", "NFC South", "NFC West"};
    public static final String webElementNFLDropdownMenuTeams = "#global-nav > ul > li.sports.menu-nfl.hover > div > ul:nth-child(2) > li > div ul>li:not([class*=\"conference label group\"])>a>span>span:not([class*=\"link-text-short\"])";
    public static final int expectedNFLTeamsCount = 32;
    public static final String[] expectedNFLTeamNames = {"Buffalo Bills", "Miami Dolphins", "New England Patriots", "New York Jets", "Baltimore Ravens", "Cincinnati Bengals", "Cleveland Browns", "Pittsburgh Steelers", "Houston Texans", "Indianapolis Colts", "Jacksonville Jaguars", "Tennessee Titans",
                                                         "Denver Broncos", "Kansas City Chiefs", "Las Vegas Raiders", "Los Angeles Chargers", "Dallas Cowboys", "New York Giants", "Philadelphia Eagles", "Washington Redskins", "Chicago Bears", "Detroit Lions", "Green Bay Packers", "Minnesota Vikings", "Atlanta Falcons", "Carolina Panthers",
                                                         "New Orleans Saints", "Tampa Bay Buccaneers", "Arizona Cardinals", "Los Angeles Rams", "San Francisco 49ers", "Seattle Seahawks"};
    public static final String webElementNBADropdownMenuItemsLeft = "#global-nav > ul > li.sports.menu-nba.hover > div > ul:nth-child(1) > li:not([style*=\"display: none;\"])>a>span>span:not([class=\"link-text-short\"])";
    public static final String[] expectedElementNBADropdownMenuItemsLeft = {"Home", "Orlando Playoffs", "The Last Dance", "Scores", "Schedule", "Standings", "Stats", "Teams", "Draft"};
    public static final String webElementNBADropdownMenuLinksLeft = "#global-nav > ul > li.sports.menu-nba.hover > div > ul:nth-child(1)>li:not([style*=\"display: none;\"])>a";
    public static final String[] expectedElementNBADropdownMenuLeftLinks = {"https://www.espn.com/nba/", "https://www.espn.com/nba/story/_/id/28911848/when-nba-return-latest-updates-amid-coronavirus-suspension", "https://www.espn.com/nba/story/_/id/28973557/the-last-dance-updates-untold-story-michael-jordan-chicago-bulls",
                                                                            "https://www.espn.com/nba/scoreboard", "https://www.espn.com/nba/schedule", "https://www.espn.com/nba/standings", "https://www.espn.com/nba/stats", "https://www.espn.com/nba/teams", "http://www.espn.com/nba/draft/news"};
    public static final int expectedNBATeamsCount = 30;
    public static final String[] expectedNBATeamNames = {"Boston Celtics", "Brooklyn Nets", "New York Knicks", "Philadelphia 76ers", "Toronto Raptors", "Chicago Bulls", "Cleveland Cavaliers", "Detroit Pistons", "Indiana Pacers", "Milwaukee Bucks", "Atlanta Hawks", "Charlotte Hornets",
            "Miami Heat", "Orlando Magic", "Washington Wizards", "Golden State Warriors", "LA Clippers", "Los Angeles Lakers", "Phoenix Suns", "Sacramento Kings", "Dallas Mavericks", "Houston Rockets", "Memphis Grizzlies", "New Orleans Pelicans", "San Antonio Spurs", "Denver Nuggets",
            "Minnesota Timberwolves", "Oklahoma City Thunder", "Portland Trail Blazers", "Utah Jazz"};
    public static final String webElementMLBDropdownMenuItemsLeft = "#global-nav > ul > li.sports.menu-mlb.hover > div > ul:nth-child(1) > li:not([style*=\"display: none;\"])>a>span>span:not([class=\"link-text-short\"])";
    public static final String[] expectedElementMLBDropdownMenuItemsLeft = {"Home", "Draft", "When could MLB return?", "KBO League", "Teams", "Scores", "Schedule", "Standings", "Stats"};
    public static final String[] expectedElementMLBDivisions = {"AL East", "AL Central", "AL West", "NL East", "NL Central", "NL West"};
    public static final String[] expectedElementMLBDropdownMenuLeftLinks = {"https://www.espn.com/mlb/", "https://www.espn.com/mlb/story/_/id/29144339/2020-mlb-draft-mock-drafts-rankings-order-more", "https://www.espn.com/mlb/story/_/id/28910482/when-mlb-actually-return-here-latest-hearing",
            "https://www.espn.com/mlb/story/_/id/29136672/kbo-espn-schedule-how-watch-teams-korea-baseball-league-more", "https://www.espn.com/mlb/teams", "https://www.espn.com/mlb/scoreboard", "https://www.espn.com/mlb/schedule", "https://www.espn.com/mlb/standings", "https://www.espn.com/mlb/stats"};
    public static final String webElementMLBDropdownMenuLinksLeft = "#global-nav > ul > li.sports.menu-mlb.hover > div > ul:nth-child(1)>li:not([style*=\"display: none;\"])>a";
    public static final String webElementMLBDropdownMenuDivisions = "#global-nav > ul > li.sports.menu-mlb.hover > div > ul:nth-child(2) > li > div >ul>li[class*=\"conference label group\"]>span>span:not([class*=\"link-text-short\"])";
    public static final String webElementMLBDropdownMenuTeams = "#global-nav > ul > li.sports.menu-mlb.hover > div > ul:nth-child(2)>li>div>ul>li[class*=\"team\"]>a>span>span:not([class*=\"link-text-short\"])";
    public static final int expectedMLBTeamsCount = 30;
    public static final String[] expectedMLBTeamNames = {"Baltimore Orioles", "Boston Red Sox", "New York Yankees", "Tampa Blue Rays", "Toronto Blue Jays", "Chicago White Sox", "Cleveland Indians", "Detroit Tigers", "Kansas City Royals", "Minnesota Twins",
            "Houston Astros", "Los Angeles Angels", "Oakland Athletics", "Seattle Mariners", "Texas Rangers", "Atlanta Braves", "Miami Marlins", "New York Mets", "Philadelphia Phillies", "Washington Nationals", "Chicago Cubs", "Cincinnati Reds",
            "Milwaukee Brewers", "Pittsburgh Pirates", "St. Louis Cardinals", "Arizona Diamondbacks", "Colorado Rockies", "Los Angeles Dodgers", "San Diego Padres", "San Francisco Giants"};
    public static final String expectedElementLoginErrorMessage = "The credentials you entered are incorrect.\nReminder: Passwords are case sensitive.";
    public static final String webElementsContainerESPNSitesListItems = "#main-container > div > section.col-one > article:nth-child(5) > div > ul > li a div span";
    public static final String expectedElementESPNSitesHeaderTitle = "ESPN Sites";
    public static final int expectedElementESPNSitesListCount = 6;
    public static final String[] expectedElementsESPNSitesListItemNames = {"ESPN Deportes", "The Undefeated", "espnW", "ESPNFC", "X Games", "SEC Network"};
    public static final String webElementsContainerFollowESPNListItems = "#main-container > div > section.col-one > article:nth-child(7) > div > ul li div:not([class=\"quicklinks_list__icon\"])>span";
    public static final String expectedElementFollowESPNHeaderTitle = "Follow ESPN";
    public static final int expectedElementFollowESPNListCount = 9;
    public static final String[] expectedElementsFollowESPNListItemNames = {"Facebook", "Twitter", "Instagram", "Snapchat", "YouTube", "Quibi", "The ESPN Daily Podcast", "The ESPN Daily Newsletter", "ESPN Daily Calendar"};
    public static final String webElementNBADropdownMenuDivisions = "#global-nav > ul > li.sports.menu-nba.hover > div > ul:nth-child(2) > li > div >ul>li[class*=\"conference label group\"]>span>span:not([class*=\"link-text-short\"])";
    public static final String[] expectedElementNBADivisions = {"Atlantic", "Central", "Southeast", "Pacific", "Southwest", "Northwest"};
    public static final String webElementNBADropdownMenuTeams = "#global-nav > ul > li.sports.menu-nba.hover > div > ul:nth-child(2)>li>div>ul>li[class*=\"team\"]>a>span>span:not([class*=\"link-text-short\"])";

}
