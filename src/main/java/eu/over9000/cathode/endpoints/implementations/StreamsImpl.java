package eu.over9000.cathode.endpoints.implementations;

import eu.over9000.cathode.Dispatcher;
import eu.over9000.cathode.Response;
import eu.over9000.cathode.data.FeaturedStreams;
import eu.over9000.cathode.data.QueriedStreams;
import eu.over9000.cathode.data.StreamBox;
import eu.over9000.cathode.data.StreamSummary;
import eu.over9000.cathode.data.parameters.Pagination;
import eu.over9000.cathode.data.parameters.StreamsQuery;
import eu.over9000.cathode.endpoints.Streams;

public class StreamsImpl extends AbstractEndpoint implements Streams {

	public StreamsImpl(final Dispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public Response<StreamBox> getStream(final String channelName) {
		return dispatcher.getAPIResponse(StreamBox.class, Streams.PATH + "/" + channelName);
	}

	@Override
	public Response<StreamSummary> getSummary() {
		return dispatcher.getAPIResponse(StreamSummary.class, Streams.PATH + "/summary");
	}

	@Override
	public Response<FeaturedStreams> getFeatured(final Pagination pagination) {
		return dispatcher.getAPIResponse(FeaturedStreams.class, Streams.PATH + "/featured", pagination);
	}

	@Override
	public Response<QueriedStreams> getQuery(final StreamsQuery query, final Pagination pagination) {
		return dispatcher.getAPIResponse(QueriedStreams.class, Streams.PATH, query, pagination);
	}
}
