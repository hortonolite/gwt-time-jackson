package org.jresearch.gwt.time.jackson;

import java.time.LocalTime;

import org.dominokit.jackson.JsonSerializationContext;
import org.dominokit.jackson.JsonSerializer;
import org.dominokit.jackson.JsonSerializerParameters;
import org.dominokit.jackson.stream.JsonWriter;

public class LocalTimeJsonSerializer extends JsonSerializer<LocalTime> {

	private static final LocalTimeJsonSerializer INSTANCE = new LocalTimeJsonSerializer();

	public static LocalTimeJsonSerializer getInstance() {
		return INSTANCE;
	}

	/** {@inheritDoc} */
	@Override
	public void doSerialize(JsonWriter writer, LocalTime value, JsonSerializationContext ctx, JsonSerializerParameters params) {
		writer.beginArray();
		writer.value(value.getHour());
		writer.value(value.getMinute());
		writer.value(value.getSecond());
		writer.value(value.getNano());
		writer.endArray();
	}

}
