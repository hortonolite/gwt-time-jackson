package org.jresearch.gwt.time.jackson;

import org.dominokit.jackson.JsonDeserializationContext;
import org.dominokit.jackson.JsonDeserializer;
import org.dominokit.jackson.JsonDeserializerParameters;
import org.dominokit.jackson.stream.JsonReader;

import java.time.MonthDay;

public class MonthDayJsonDeserializer extends JsonDeserializer<MonthDay> {

	private static final MonthDayJsonDeserializer INSTANCE = new MonthDayJsonDeserializer();

	public static MonthDayJsonDeserializer getInstance() {
		return INSTANCE;
	}

	/** {@inheritDoc} */
	@Override
	public MonthDay doDeserialize(JsonReader reader, JsonDeserializationContext ctx, JsonDeserializerParameters params) {
		reader.beginArray();
		int month = reader.nextInt();
		int dayOfMonth = reader.nextInt();
		reader.endArray();
		return MonthDay.of(month, dayOfMonth);
	}

}
