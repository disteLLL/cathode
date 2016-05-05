package eu.over9000.cathode.endpoints;

import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.ChannelList;
import eu.over9000.cathode.data.GameList;
import eu.over9000.cathode.data.StreamList;
import eu.over9000.cathode.data.parameters.OffsetPagination;
import eu.over9000.cathode.data.parameters.SearchChannelOptions;
import eu.over9000.cathode.data.parameters.SearchGamesOptions;
import eu.over9000.cathode.data.parameters.SearchStreamsOptions;

/**
 * <pre>
 * /search/channels                            GET
 * /search/games                               GET
 * /search/streams                             GET
 * </pre>
 */
public interface Search {

	String PATH = "search";

	Result<ChannelList> getChannels(SearchChannelOptions options, OffsetPagination pagination);

	Result<GameList> getGames(SearchGamesOptions options);

	Result<StreamList> getStreams(SearchStreamsOptions options, OffsetPagination pagination);
}
