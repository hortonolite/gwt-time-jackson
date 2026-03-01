package org.jresearch.gwt.time.jackson;

import java.time.Year;

import org.dominokit.jackson.JsonDeserializationContext;
import org.dominokit.jackson.JsonDeserializer;
import org.dominokit.jackson.JsonDeserializerParameters;
import org.dominokit.jackson.stream.JsonReader;

public class YearJsonDeserializer extends JsonDeserializer<Year> {

	private static final YearJsonDeserializer INSTANCE = new YearJsonDeserializer();

	public static YearJsonDeserializer getInstance() {
		return INSTANCE;
	}

	/** {@inheritDoc} */
	@Override
	public Year doDeserialize(JsonReader reader, JsonDeserializationContext ctx, JsonDeserializerParameters params) {
		int value = reader.nextInt();
		return Year.of(value);
	}

}
