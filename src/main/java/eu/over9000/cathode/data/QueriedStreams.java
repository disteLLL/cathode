package eu.over9000.cathode.data;

import com.google.gson.annotations.SerializedName;
import eu.over9000.cathode.data.meta.PaginatedContainer;

import java.util.List;

public class QueriedStreams implements PaginatedContainer<Stream> {

	@SerializedName("_total")
	private final long total;
	private final List<Stream> streams;

	public QueriedStreams(final long total, final List<Stream> streams) {
		this.total = total;
		this.streams = streams;
	}

	@Override
	public String toString() {
		return "QueriedStreams{" +
				"total=" + total +
				", streams=" + streams +
				'}';
	}

	public long getTotal() {
		return total;
	}

	public List<Stream> getStreams() {
		return streams;
	}

	@Override
	public List<Stream> getChunk() {
		return streams;
	}
}
