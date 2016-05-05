package eu.over9000.cathode.endpoints;

import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.TopGameList;
import eu.over9000.cathode.data.parameters.OffsetPagination;

/**
 * <pre>
 * /games/top                                  GET
 * </pre>
 */
public interface Games {

	String PATH = "games";

	Result<TopGameList> getTopGames(OffsetPagination pagination);
}
