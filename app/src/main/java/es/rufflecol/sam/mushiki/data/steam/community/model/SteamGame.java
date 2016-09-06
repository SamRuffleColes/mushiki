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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SteamGame steamGame = (SteamGame) o;

        if (appId != steamGame.appId) return false;
        if (Double.compare(steamGame.hoursPlayedInTheLastFortnight, hoursPlayedInTheLastFortnight) != 0)
            return false;
        if (Double.compare(steamGame.hoursPlayedInAllTime, hoursPlayedInAllTime) != 0) return false;
        if (name != null ? !name.equals(steamGame.name) : steamGame.name != null) return false;
        if (logo != null ? !logo.equals(steamGame.logo) : steamGame.logo != null) return false;
        if (storeLink != null ? !storeLink.equals(steamGame.storeLink) : steamGame.storeLink != null)
            return false;
        if (statsLink != null ? !statsLink.equals(steamGame.statsLink) : steamGame.statsLink != null)
            return false;
        return globalStatsLink != null ? globalStatsLink.equals(steamGame.globalStatsLink) : steamGame.globalStatsLink == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (appId ^ (appId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        result = 31 * result + (storeLink != null ? storeLink.hashCode() : 0);
        temp = Double.doubleToLongBits(hoursPlayedInTheLastFortnight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(hoursPlayedInAllTime);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (statsLink != null ? statsLink.hashCode() : 0);
        result = 31 * result + (globalStatsLink != null ? globalStatsLink.hashCode() : 0);
        return result;
    }
}
