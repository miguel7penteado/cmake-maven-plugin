/*
 * Copyright (c) 2013 Gili Tzabari
 * Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 */
package org.bitbucket.cowwoc.requirements.java;

import org.bitbucket.cowwoc.requirements.java.extension.ExtensibleObjectVerifier;

/**
 * Verifies the requirements of a {@link Class} value.
 * <p>
 * All methods (except those found in {@link ExtensibleObjectVerifier}) imply {@link #isNotNull()}.
 *
 * @param <T> the type of the class
 */
public interface ClassVerifier<T> extends ExtensibleObjectVerifier<ClassVerifier<T>, Class<T>>
{
	/**
	 * Ensures that the actual value is a superclass or super-interface of a type.
	 *
	 * @param type the type to compare to
	 * @return the updated verifier
	 * @throws NullPointerException     if {@code type} is null
	 * @throws IllegalArgumentException if actual value is not a supertype of {@code type}
	 */
	ClassVerifier<T> isSupertypeOf(Class<?> type);

	/**
	 * Ensures that the actual value is a subclass or sub-interface of a type.
	 *
	 * @param type the type to compare to
	 * @return the updated verifier
	 * @throws NullPointerException     if {@code type} is null
	 * @throws IllegalArgumentException if actual value is not a subtype of {@code type}
	 */
	ClassVerifier<T> isSubtypeOf(Class<?> type);
}
