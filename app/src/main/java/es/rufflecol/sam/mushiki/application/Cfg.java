package es.rufflecol.sam.mushiki.application;

public final class Cfg {

    private Cfg() {
        //no instantiation
    }

    public static final long HTTP_READ_TIMEOUT = 30;
    public static final long HTTP_CONNECTION_TIMEOUT = 30;

    public static final String STEAM_COMMUNITY_API_BASE_URL = "http://steamcommunity.com";
}
