package org.jresearch.gwt.time.jackson;

import java.time.Instant;

import org.dominokit.jackson.JsonDeserializationContext;
import org.dominokit.jackson.JsonDeserializer;
import org.dominokit.jackson.JsonDeserializerParameters;
import org.dominokit.jackson.stream.JsonReader;

public class InstantJsonDeserializer extends JsonDeserializer<Instant> {

	private static final InstantJsonDeserializer INSTANCE = new InstantJsonDeserializer();

	public static InstantJsonDeserializer getInstance() {
		return INSTANCE;
	}

	// TODO Fix for https://github.com/DominoKit/domino-jackson/issues/51
//	private InstantJsonDeserializer() {
//	}

	/** {@inheritDoc} */
	@Override
	public Instant doDeserialize(JsonReader reader, JsonDeserializationContext ctx, JsonDeserializerParameters params) {
		return Instant.ofEpochMilli(reader.nextLong());
	}
}
