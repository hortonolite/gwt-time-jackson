package org.jresearch.gwt.time.jackson;

import java.math.BigDecimal;
import java.time.Duration;

import org.dominokit.jackson.JsonDeserializationContext;
import org.dominokit.jackson.JsonDeserializer;
import org.dominokit.jackson.JsonDeserializerParameters;
import org.dominokit.jackson.annotation.CustomDeserializer;
import org.dominokit.jackson.stream.JsonReader;

@CustomDeserializer(Duration.class)
public class DurationJsonDeserializer extends JsonDeserializer<Duration> {

	private static final DurationJsonDeserializer INSTANCE = new DurationJsonDeserializer();

	public static DurationJsonDeserializer getInstance() {
		return INSTANCE;
	}

	/** {@inheritDoc} */
	@Override
	public Duration doDeserialize(JsonReader reader, JsonDeserializationContext ctx, JsonDeserializerParameters params) {
		BigDecimal seconds = new BigDecimal(reader.nextString());
		return DecimalUtils.extractSecondsAndNanos(seconds, Duration::ofSeconds);
	}

}
