package org.jresearch.gwt.time.jackson;

import java.math.BigDecimal;
import java.time.Duration;
import org.dominokit.jackson.JsonSerializationContext;
import org.dominokit.jackson.JsonSerializer;
import org.dominokit.jackson.JsonSerializerParameters;
import org.dominokit.jackson.stream.JsonWriter;

public class DurationJsonSerializer extends JsonSerializer<Duration> {

	private static final DurationJsonSerializer INSTANCE = new DurationJsonSerializer();

	public static DurationJsonSerializer getInstance() {
		return INSTANCE;
	}

	/** {@inheritDoc} */
	@Override
	public void doSerialize(JsonWriter writer, Duration value, JsonSerializationContext ctx, JsonSerializerParameters params) {
		BigDecimal nanos = DecimalUtils.toBigDecimal(value.getSeconds(), value.getNano());
		if (value.isNegative()) {
			nanos = nanos.negate();
		}
		writer.value(nanos);
	}

}
