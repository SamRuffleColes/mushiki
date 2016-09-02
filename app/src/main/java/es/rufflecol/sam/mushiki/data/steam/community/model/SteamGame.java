package es.rufflecol.sam.mushiki.data.steam.community.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "game")
public class SteamGame {

    @Element(name = "appID")
    private long appId;

    @Element(name = "name")
    private String name;

    @Element(name = "logo")
    private String logo;

    @Element(name = "storeLink")
    private String storeLink;

    @Element(name = "hoursLast2Weeks", required = false)
    private double hoursPlayedInTheLastFortnight;

    @Element(name = "hoursOnRecord", required = false)
    private double hoursPlayedInAllTime;

    @Element(name = "statsLink", required = false)
    private String statsLink;

    @Element(name = "globalStatsLink", required = false)
    private String globalStatsLink;

    public long getAppId() {
        return appId;
    }

    public String getName() {
        return name;
    }

    public String getLogo() {
        return logo;
    }

    public String getStoreLink() {
        return storeLink;
    }

    public double getHoursPlayedInTheLastFortnight() {
        return hoursPlayedInTheLastFortnight;
    }

    public double getHoursPlayedInAllTime() {
        return hoursPlayedInAllTime;
    }

    public String getStatsLink() {
        return statsLink;
    }

    public String getGlobalStatsLink() {
        return globalStatsLink;
    }

    public SteamGame(long appId, String name, String logo, String storeLink, double hoursPlayedInTheLastFortnight, double hoursPlayedInAllTime, String statsLink, String globalStatsLink) {
        this.appId = appId;
        this.name = name;
        this.logo = logo;
        this.storeLink = storeLink;
        this.hoursPlayedInTheLastFortnight = hoursPlayedInTheLastFortnight;
        this.hoursPlayedInAllTime = hoursPlayedInAllTime;
        this.statsLink = statsLink;
        this.globalStatsLink = globalStatsLink;
    }

    public SteamGame() {
        //required for simplexml
    }

}
