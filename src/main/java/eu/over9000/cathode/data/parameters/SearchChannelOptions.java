package eu.over9000.cathode.data.parameters;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.Collections;
import java.util.List;

public class SearchChannelOptions implements Parameter {
	private final String query;

	public SearchChannelOptions(final String query) {
		this.query = query;
	}

	public String getQuery() {
		return query;
	}

	@Override
	public List<NameValuePair> buildParamPairs() {
		return Collections.singletonList(new BasicNameValuePair("query", query));
	}
}
