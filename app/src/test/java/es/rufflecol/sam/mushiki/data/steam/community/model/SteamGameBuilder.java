package es.rufflecol.sam.mushiki.data.steam.community.model;

public class SteamGameBuilder {

    private long appId;
    private String name;
    private String logo;
    private String storeLink;
    private double hoursPlayedInTheLastFortnight;
    private double hoursPlayedInAllTime;
    private String statsLink;
    private String globalStatsLink;

    public SteamGameBuilder appId(long appId) {
        this.appId = appId;
        return this;
    }

    public SteamGameBuilder name(String name) {
        this.name = name;
        return this;
    }

    public SteamGameBuilder logo(String logo) {
        this.logo = logo;
        return this;
    }

    public SteamGameBuilder storeLink(String storeLink) {
        this.storeLink = storeLink;
        return this;
    }

    public SteamGameBuilder hoursPlayedInTheLastFortnight(double hoursPlayedInTheLastFortnight) {
        this.hoursPlayedInTheLastFortnight = hoursPlayedInTheLastFortnight;
        return this;
    }

    public SteamGameBuilder hoursPlayedInAllTime(double hoursPlayedInAllTime) {
        this.hoursPlayedInAllTime = hoursPlayedInAllTime;
        return this;
    }

    public SteamGameBuilder statsLink(String statsLink) {
        this.statsLink = statsLink;
        return this;
    }

    public SteamGameBuilder globalStatsLink(String globalStatsLink) {
        this.globalStatsLink = globalStatsLink;
        return this;
    }

    public SteamGame build() {
        return new SteamGame(appId, name, logo, storeLink, hoursPlayedInTheLastFortnight, hoursPlayedInAllTime, statsLink, globalStatsLink);
    }
}
