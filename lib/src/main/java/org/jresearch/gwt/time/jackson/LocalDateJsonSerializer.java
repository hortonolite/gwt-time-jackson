package org.jresearch.gwt.time.jackson;

import java.time.LocalDate;

import org.dominokit.jackson.JsonSerializationContext;
import org.dominokit.jackson.JsonSerializer;
import org.dominokit.jackson.JsonSerializerParameters;
import org.dominokit.jackson.stream.JsonWriter;

public class LocalDateJsonSerializer extends JsonSerializer<LocalDate> {

	private static final LocalDateJsonSerializer INSTANCE = new LocalDateJsonSerializer();

	public static LocalDateJsonSerializer getInstance() {
		return INSTANCE;
	}

//TODO Fix for https://github.com/DominoKit/domino-jackson/issues/51
//	private InstantJsonSerializer() {
//	}

	/** {@inheritDoc} */
	@Override
	public void doSerialize(JsonWriter writer, LocalDate value, JsonSerializationContext ctx, JsonSerializerParameters params) {
		writer.beginArray();
		writer.value(value.getYear());
		writer.value(value.getMonthValue());
		writer.value(value.getDayOfMonth());
		writer.endArray();
	}

}
