/*
 * Copyright (c) 2016 s1mpl3x <jan[at]over9000.eu>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package eu.over9000.cathode;

import eu.over9000.cathode.data.meta.PaginatedContainer;
import eu.over9000.cathode.data.parameters.Pagination;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by Jan on 05.05.2016.
 */
public class PaginationUtility {

	public static <Inner, Outer extends PaginatedContainer<Inner>> Result<List<Inner>> collectPaginated(final Pagination pagination, final Supplier<Result<Outer>> dataSource) {

		final List<Inner> result = new ArrayList<>();

		Outer chunk;
		do {
			final Result<Outer> chunkResult = dataSource.get();

			if (chunkResult.isOk()) {
				chunk = chunkResult.getResultRaw();

				if (!chunk.isEmpty()) {
					result.addAll(chunk.getChunk());
				}

			} else {
				return new Result<>(chunkResult.getErrorRaw());
			}

			pagination.next(chunk);

		} while (pagination.hasMore(chunk));

		return new Result<>(result);
	}
}
