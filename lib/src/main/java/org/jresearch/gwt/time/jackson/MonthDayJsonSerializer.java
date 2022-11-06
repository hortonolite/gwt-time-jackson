package org.jresearch.gwt.time.jackson;

import java.time.MonthDay;

import org.dominokit.jackson.JsonSerializationContext;
import org.dominokit.jackson.JsonSerializer;
import org.dominokit.jackson.JsonSerializerParameters;
import org.dominokit.jackson.stream.JsonWriter;

public class MonthDayJsonSerializer extends JsonSerializer<MonthDay> {

	private static final MonthDayJsonSerializer INSTANCE = new MonthDayJsonSerializer();

	public static MonthDayJsonSerializer getInstance() {
		return INSTANCE;
	}

	/** {@inheritDoc} */
	@Override
	public void doSerialize(JsonWriter writer, MonthDay value, JsonSerializationContext ctx, JsonSerializerParameters params) {
		writer.beginArray();
		writer.value(value.getMonthValue());
		writer.value(value.getDayOfMonth());
		writer.endArray();
	}

}
