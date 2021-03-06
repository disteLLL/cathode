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

package eu.over9000.cathode.data.parameters;

import eu.over9000.cathode.data.meta.PaginatedContainer;

public abstract class Pagination implements Parameter {
	private static final int TWITCH_PAGINATION_MAX = 100;
	protected long limit = 25;
	private String cursor;

	Pagination() {

	}

	Pagination(long limit) {
		if (limit > TWITCH_PAGINATION_MAX) {
			limit = TWITCH_PAGINATION_MAX;
		}
		this.limit = limit;
	}

	public abstract boolean hasMore(PaginatedContainer<?> chunk);

	public abstract void next(PaginatedContainer<?> currentItem);

	public enum PaginationType {OFFSET, CURSOR}
}
