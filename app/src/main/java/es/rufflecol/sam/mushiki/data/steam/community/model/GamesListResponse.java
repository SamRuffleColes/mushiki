package es.rufflecol.sam.mushiki.data.steam.community.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "gamesList")
public class GamesListResponse {

    @Element(name = "steamID64")
    private long steamId64;

    @Element(name = "steamID")
    private String steamId;

    @ElementList(name = "games")
    private List<SteamGame> games;

    public long getSteamId64() {
        return steamId64;
    }

    public String getSteamId() {
        return steamId;
    }

    public List<SteamGame> getGames() {
        return games;
    }

    public GamesListResponse(long steamId64, String steamId, List<SteamGame> games) {
        this.steamId64 = steamId64;
        this.steamId = steamId;
        this.games = games;
    }

    public GamesListResponse() {
        //required for simplexml
    }
}
