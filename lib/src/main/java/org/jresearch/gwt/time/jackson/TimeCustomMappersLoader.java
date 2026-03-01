package org.jresearch.gwt.time.jackson;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;

import org.dominokit.jackson.CustomMappersLoader;
import org.dominokit.jackson.RegistryWrapper;

import com.google.auto.service.AutoService;

@AutoService(CustomMappersLoader.class)
public final class TimeCustomMappersLoader implements CustomMappersLoader {

	@Override
	public void register(RegistryWrapper registry) {
		register(registry, Duration.class, DurationJsonDeserializer.class, DurationJsonSerializer.class);
		register(registry, Instant.class, InstantJsonDeserializer.class, InstantJsonSerializer.class);
		register(registry, LocalDate.class, LocalDateJsonDeserializer.class, LocalDateJsonSerializer.class);
		register(registry, LocalDateTime.class, LocalDateTimeJsonDeserializer.class, LocalDateTimeJsonSerializer.class);
		register(registry, LocalTime.class, LocalTimeJsonDeserializer.class, LocalTimeJsonSerializer.class);
		register(registry, MonthDay.class, MonthDayJsonDeserializer.class, MonthDayJsonSerializer.class);
		register(registry, Year.class, YearJsonDeserializer.class, YearJsonSerializer.class);
		register(registry, YearMonth.class, YearMonthJsonDeserializer.class, YearMonthJsonSerializer.class);
	}

	private static <T> void register(
	                                 RegistryWrapper registry,
	                                 Class<T> targetType,
	                                 Class<? extends org.dominokit.jackson.JsonDeserializer<?>> deserializer,
	                                 Class<? extends org.dominokit.jackson.JsonSerializer<?>> serializer) {
		String typeName = targetType.getName();
		registry.registerDeserializer(typeName, deserializer);
		registry.registerSerializer(typeName, serializer);
	}
}
