package org.jresearch.gwt.time.jackson;

import java.time.LocalDateTime;

import org.dominokit.jackson.JsonDeserializationContext;
import org.dominokit.jackson.JsonDeserializer;
import org.dominokit.jackson.JsonDeserializerParameters;
import org.dominokit.jackson.stream.JsonReader;

public class LocalDateTimeJsonDeserializer extends JsonDeserializer<LocalDateTime> {

	private static final LocalDateTimeJsonDeserializer INSTANCE = new LocalDateTimeJsonDeserializer();

	public static LocalDateTimeJsonDeserializer getInstance() {
		return INSTANCE;
	}

	/** {@inheritDoc} */
	@Override
	public LocalDateTime doDeserialize(JsonReader reader, JsonDeserializationContext ctx, JsonDeserializerParameters params) {
		reader.beginArray();
		int year = reader.nextInt();
		int month = reader.nextInt();
		int day = reader.nextInt();
		int hour = reader.nextInt();
		int minute = reader.nextInt();
		int second = reader.nextInt();
		int nanoOfSecond = reader.nextInt();
		reader.endArray();
		return LocalDateTime.of(year, month, day, hour, minute, second, nanoOfSecond);
	}

}
