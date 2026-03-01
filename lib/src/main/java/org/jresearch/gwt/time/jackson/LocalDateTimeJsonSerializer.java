package org.jresearch.gwt.time.jackson;

import java.time.LocalDateTime;

import org.dominokit.jackson.JsonSerializationContext;
import org.dominokit.jackson.JsonSerializer;
import org.dominokit.jackson.JsonSerializerParameters;
import org.dominokit.jackson.stream.JsonWriter;

public class LocalDateTimeJsonSerializer extends JsonSerializer<LocalDateTime> {

	private static final LocalDateTimeJsonSerializer INSTANCE = new LocalDateTimeJsonSerializer();

	public static LocalDateTimeJsonSerializer getInstance() {
		return INSTANCE;
	}

	/** {@inheritDoc} */
	@Override
	public void doSerialize(JsonWriter writer, LocalDateTime value, JsonSerializationContext ctx, JsonSerializerParameters params) {
		writer.beginArray();
		writer.value(value.getYear());
		writer.value(value.getMonthValue());
		writer.value(value.getDayOfMonth());
		writer.value(value.getHour());
		writer.value(value.getMinute());
		writer.value(value.getSecond());
		writer.value(value.getNano());
		writer.endArray();
	}

}
