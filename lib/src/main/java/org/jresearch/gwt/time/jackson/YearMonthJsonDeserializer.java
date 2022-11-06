package org.jresearch.gwt.time.jackson;

import org.dominokit.jackson.JsonDeserializationContext;
import org.dominokit.jackson.JsonDeserializer;
import org.dominokit.jackson.JsonDeserializerParameters;
import org.dominokit.jackson.stream.JsonReader;

import java.time.YearMonth;

public class YearMonthJsonDeserializer extends JsonDeserializer<YearMonth> {

	private static final YearMonthJsonDeserializer INSTANCE = new YearMonthJsonDeserializer();

	public static YearMonthJsonDeserializer getInstance() {
		return INSTANCE;
	}

	/** {@inheritDoc} */
	@Override
	public YearMonth doDeserialize(JsonReader reader, JsonDeserializationContext ctx, JsonDeserializerParameters params) {
		reader.beginArray();
		int year = reader.nextInt();
		int month = reader.nextInt();
		reader.endArray();
		return YearMonth.of(year, month);
	}

}
