package org.jresearch.gwt.time.jackson;

import org.dominokit.jackson.JsonSerializationContext;
import org.dominokit.jackson.JsonSerializer;
import org.dominokit.jackson.JsonSerializerParameters;
import org.dominokit.jackson.stream.JsonWriter;

import java.time.Year;

public class YearJsonSerializer extends JsonSerializer<Year> {

	private static final YearJsonSerializer INSTANCE = new YearJsonSerializer();

	public static YearJsonSerializer getInstance() {
		return INSTANCE;
	}

	/** {@inheritDoc} */
	@Override
	public void doSerialize(JsonWriter writer, Year value, JsonSerializationContext ctx, JsonSerializerParameters params) {
		writer.value(value.getValue());
	}

}
