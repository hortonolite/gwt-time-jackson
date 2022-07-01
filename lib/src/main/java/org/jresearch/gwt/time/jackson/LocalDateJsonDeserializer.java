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

// TODO Fix for https://github.com/DominoKit/domino-jackson/issues/51
//	private InstantJsonDeserializer() {
//	}

	/** {@inheritDoc} */
	@Override
	public LocalDate doDeserialize(JsonReader reader, JsonDeserializationContext ctx, JsonDeserializerParameters params) {
		return LocalDate.ofEpochDay(reader.nextLong());
	}

}
