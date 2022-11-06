package org.jresearch.gwt.time.jackson;

import java.time.LocalDate;

import org.dominokit.jackson.JsonDeserializationContext;
import org.dominokit.jackson.JsonDeserializer;
import org.dominokit.jackson.JsonDeserializerParameters;
import org.dominokit.jackson.stream.JsonReader;

public class LocalDateJsonDeserializer extends JsonDeserializer<LocalDate> {

	private static final LocalDateJsonDeserializer INSTANCE = new LocalDateJsonDeserializer();

	public static LocalDateJsonDeserializer getInstance() {
		return INSTANCE;
	}

	/** {@inheritDoc} */
	@Override
	public LocalDate doDeserialize(JsonReader reader, JsonDeserializationContext ctx, JsonDeserializerParameters params) {
		reader.beginArray();
		int year = reader.nextInt();
		int month = reader.nextInt();
		int day = reader.nextInt();
		reader.endArray();
		return LocalDate.of(year, month, day);
	}

}
