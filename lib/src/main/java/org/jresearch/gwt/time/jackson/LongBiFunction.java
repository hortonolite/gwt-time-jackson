package org.jresearch.gwt.time.jackson;

@FunctionalInterface
public interface LongBiFunction<R> {

	R apply(long t, long u);

}
