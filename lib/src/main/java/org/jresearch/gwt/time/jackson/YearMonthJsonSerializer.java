package org.jresearch.gwt.time.jackson;

import org.dominokit.jackson.JsonSerializationContext;
import org.dominokit.jackson.JsonSerializer;
import org.dominokit.jackson.JsonSerializerParameters;
import org.dominokit.jackson.stream.JsonWriter;

import java.time.YearMonth;

public class YearMonthJsonSerializer extends JsonSerializer<YearMonth> {

	private static final YearMonthJsonSerializer INSTANCE = new YearMonthJsonSerializer();

	public static YearMonthJsonSerializer getInstance() {
		return INSTANCE;
	}

	/** {@inheritDoc} */
	@Override
	public void doSerialize(JsonWriter writer, YearMonth value, JsonSerializationContext ctx, JsonSerializerParameters params) {
		writer.beginArray();
		writer.value(value.getYear());
		writer.value(value.getMonthValue());
		writer.endArray();
	}

}
