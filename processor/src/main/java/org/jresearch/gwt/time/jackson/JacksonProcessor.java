package org.jresearch.gwt.time.jackson;

import java.time.Instant;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;

import org.dominokit.jackson.processor.TypeRegistry;

import com.google.auto.service.AutoService;

import dominojackson.shaded.com.squareup.javapoet.ClassName;

@AutoService(Processor.class)
public class JacksonProcessor extends AbstractProcessor {

	private static final String INSTANT = Instant.class.getName();

	@Override
	public synchronized void init(ProcessingEnvironment env) {
		if (!TypeRegistry.containsDeserializer(INSTANT)) {
			TypeRegistry.registerDeserializer(INSTANT, ClassName.get(InstantJsonDeserializer.class));
		}
		if (!TypeRegistry.containsSerializer(INSTANT)) {
			TypeRegistry.registerSerializer(INSTANT, ClassName.get(InstantJsonSerializer.class));
		}
		super.init(env);
	}

	@Override
	public boolean process(final Set<? extends TypeElement> annotations, final RoundEnvironment roundEnv) {
		return false;
	}

}
