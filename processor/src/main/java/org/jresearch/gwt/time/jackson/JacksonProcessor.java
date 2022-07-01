package org.jresearch.gwt.time.jackson;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

import org.dominokit.jackson.JsonDeserializer;
import org.dominokit.jackson.JsonSerializer;
import org.dominokit.jackson.processor.TypeRegistry;

import com.google.auto.service.AutoService;

import dominojackson.shaded.com.squareup.javapoet.ClassName;

@AutoService(Processor.class)
public class JacksonProcessor extends AbstractProcessor {

	@Override
	public SourceVersion getSupportedSourceVersion() {
		return SourceVersion.latestSupported();
	}

	@Override
	public synchronized void init(ProcessingEnvironment env) {
		register(Instant.class, InstantJsonDeserializer.class, InstantJsonSerializer.class);
		register(LocalDate.class, LocalDateJsonDeserializer.class, LocalDateJsonSerializer.class);
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
