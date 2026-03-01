package org.jresearch.gwt.time.jackson;

import java.time.LocalTime;

import org.dominokit.jackson.JsonDeserializationContext;
import org.dominokit.jackson.JsonDeserializer;
import org.dominokit.jackson.JsonDeserializerParameters;
import org.dominokit.jackson.stream.JsonReader;

public class LocalTimeJsonDeserializer extends JsonDeserializer<LocalTime> {

	private static final LocalTimeJsonDeserializer INSTANCE = new LocalTimeJsonDeserializer();

	public static LocalTimeJsonDeserializer getInstance() {
		return INSTANCE;
	}

	/** {@inheritDoc} */
	@Override
	public LocalTime doDeserialize(JsonReader reader, JsonDeserializationContext ctx, JsonDeserializerParameters params) {
		reader.beginArray();
		int hour = reader.nextInt();
		int minute = reader.nextInt();
		int second = reader.nextInt();
		int nanoOfSecond = reader.nextInt();
		reader.endArray();
		return LocalTime.of(hour, minute, second, nanoOfSecond);
	}

}
