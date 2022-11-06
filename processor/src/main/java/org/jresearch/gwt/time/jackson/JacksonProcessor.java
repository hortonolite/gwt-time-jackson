package org.jresearch.gwt.time.jackson;

import com.google.auto.service.AutoService;
import dominojackson.shaded.com.squareup.javapoet.ClassName;
import org.dominokit.jackson.JsonDeserializer;
import org.dominokit.jackson.JsonSerializer;
import org.dominokit.jackson.processor.TypeRegistry;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.util.Collections;
import java.util.Set;

@AutoService(Processor.class)
public class JacksonProcessor extends AbstractProcessor {

	@Override
	public Set<String> getSupportedAnnotationTypes() {
		return Collections.emptySet();
	}

	@Override
	public SourceVersion getSupportedSourceVersion() {
		return SourceVersion.latestSupported();
	}

	@Override
	public synchronized void init(ProcessingEnvironment env) {
		register(Duration.class, DurationJsonDeserializer.class, DurationJsonSerializer.class);
		register(Instant.class, InstantJsonDeserializer.class, InstantJsonSerializer.class);
		register(LocalDate.class, LocalDateJsonDeserializer.class, LocalDateJsonSerializer.class);
		register(LocalDateTime.class, LocalDateTimeJsonDeserializer.class, LocalDateTimeJsonSerializer.class);
		register(LocalTime.class, LocalTimeJsonDeserializer.class, LocalTimeJsonSerializer.class);
		register(MonthDay.class, MonthDayJsonDeserializer.class, MonthDayJsonSerializer.class);
//		register(OffsetDateTime.class, OffsetDateTimeJsonDeserializer.class, OffsetDateTimeJsonSerializer.class);
//		register(ZonedDateTime.class, ZonedDateTimeJsonDeserializer.class, ZonedDateTimeJsonSerializer.class);
//		register(OffsetTime.class, OffsetTimeJsonDeserializer.class, OffsetTimeJsonSerializer.class);
//		register(Period.class, PeriodJsonDeserializer.class, PeriodJsonSerializer.class);
		register(Year.class, YearJsonDeserializer.class, YearJsonSerializer.class);
		register(YearMonth.class, YearMonthJsonDeserializer.class, YearMonthJsonSerializer.class);
//		register(ZoneId.class, ZoneIdJsonDeserializer.class, ZoneIdJsonSerializer.class);
//		register(ZoneOffset.class, ZoneOffsetJsonDeserializer.class, ZoneOffsetJsonSerializer.class);
		super.init(env);
	}

	private static <T> void register(Class<T> target, Class<? extends JsonDeserializer<T>> jsonDeserializer, Class<? extends JsonSerializer<T>> jsonSerializer) {
		String id = target.getName();
		if (!TypeRegistry.containsDeserializer(id)) {
			TypeRegistry.registerDeserializer(id, ClassName.get(jsonDeserializer));
		}
		if (!TypeRegistry.containsSerializer(id)) {
			TypeRegistry.registerSerializer(id, ClassName.get(jsonSerializer));
		}
	}

	@Override
	public boolean process(final Set<? extends TypeElement> annotations, final RoundEnvironment roundEnv) {
		return false;
	}

}
