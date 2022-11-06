package org.jresearch.gwt.time.jackson;

import java.time.Instant;

import org.dominokit.jackson.JsonSerializationContext;
import org.dominokit.jackson.JsonSerializer;
import org.dominokit.jackson.JsonSerializerParameters;
import org.dominokit.jackson.stream.JsonWriter;

public class InstantJsonSerializer extends JsonSerializer<Instant> {

	private static final InstantJsonSerializer INSTANCE = new InstantJsonSerializer();

	public static InstantJsonSerializer getInstance() {
		return INSTANCE;
	}

	/** {@inheritDoc} */
	@Override
	public void doSerialize(JsonWriter writer, Instant value, JsonSerializationContext ctx, JsonSerializerParameters params) {
		writer.value(DecimalUtils.toBigDecimal(value.getEpochSecond(), value.getNano()));
	}

}
