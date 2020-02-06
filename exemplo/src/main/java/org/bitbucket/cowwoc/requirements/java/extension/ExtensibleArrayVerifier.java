/*
 * Copyright (c) 2019 Gili Tzabari
 * Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 */
package org.bitbucket.cowwoc.requirements.java.extension;

import org.bitbucket.cowwoc.requirements.java.ArrayVerifier;
import org.bitbucket.cowwoc.requirements.java.CollectionVerifier;
import org.bitbucket.cowwoc.requirements.java.SizeVerifier;

import java.util.Collection;
import java.util.function.Consumer;

/**
 * Verifies the requirements of an array of elements but the implementing verifier is not guaranteed to be a
 * {@link ArrayVerifier}.
 *
 * @param <S> the type of verifier returned by the methods
 * @param <E> the type of elements in the array
 * @param <A> the type of the array
 */
public interface ExtensibleArrayVerifier<S, E, A> extends ExtensibleObjectVerifier<S, A>
{
	/**
	 * Ensures that the actual value is empty.
	 *
	 * @return the updated verifier
	 * @throws IllegalArgumentException if the array is not empty
	 */
	S isEmpty();

	/**
	 * Ensures that the actual value is not empty.
	 *
	 * @return the updated verifier
	 * @throws IllegalArgumentException if the array is empty
	 */
	S isNotEmpty();

	/**
	 * Ensures that the actual value contains an element.
	 *
	 * @param expected the element
	 * @return the updated verifier
	 * @throws IllegalArgumentException if the array does not contain {@code expected}
	 */
	S contains(E expected);

	/**
	 * Ensures that the actual value contains an element.
	 *
	 * @param expected the element
	 * @param name     the name of the element
	 * @return the updated verifier
	 * @throws NullPointerException     if {@code name} is null
	 * @throws IllegalArgumentException if the array does not contain {@code expected}. If {@code name} is empty.
	 */
	S contains(E expected, String name);

	/**
	 * Ensures that the actual value contains the specified elements; nothing less, nothing more.
	 *
	 * @param expected the elements that must exist
	 * @return the updated verifier
	 * @throws NullPointerException     if {@code expected} is null
	 * @throws IllegalArgumentException if the array is missing any element found in {@code expected};
	 *                                  if the array contains any element not found in {@code expected}
	 */
	S containsExactly(Collection<E> expected);

	/**
	 * Ensures that the actual value contains the specified elements; nothing less, nothing more.
	 *
	 * @param expected the elements that must exist
	 * @param name     the name of the elements
	 * @return the updated verifier
	 * @throws NullPointerException     if {@code expected} or {@code name} are null
	 * @throws IllegalArgumentException if the array is missing any element found in {@code expected}. If the
	 *                                  array contains any element not found in {@code expected}. If
	 *                                  {@code name} is empty.
	 */
	S containsExactly(Collection<E> expected, String name);

	/**
	 * Ensures that the actual value contains any of the specified elements.
	 *
	 * @param expected the elements that must exist
	 * @return the updated verifier
	 * @throws NullPointerException     if {@code expected} is null
	 * @throws IllegalArgumentException if the array does not contain any of {@code expected}
	 */
	S containsAny(Collection<E> expected);

	/**
	 * Ensures that the actual value contains any of the specified elements.
	 *
	 * @param expected the elements that must exist
	 * @param name     the name of the elements
	 * @return the updated verifier
	 * @throws NullPointerException     if {@code expected} or {@code name} are null
	 * @throws IllegalArgumentException if the array does not contain any of {@code expected}. If
	 *                                  {@code name} is empty.
	 */
	S containsAny(Collection<E> expected, String name);

	/**
	 * Ensures that the actual value contains all of the specified elements.
	 *
	 * @param expected the elements that must exist
	 * @return the updated verifier
	 * @throws NullPointerException     if {@code expected} is null
	 * @throws IllegalArgumentException if the array does not contain all of {@code expected}
	 */
	S containsAll(Collection<E> expected);

	/**
	 * Ensures that the actual value contains all of the specified elements.
	 *
	 * @param expected the elements that must exist
	 * @param name     the name of the elements
	 * @return the updated verifier
	 * @throws NullPointerException     if {@code expected} or {@code name} are null
	 * @throws IllegalArgumentException if the array does not contain all of {@code expected}. If
	 *                                  {@code name} is empty.
	 */
	S containsAll(Collection<E> expected, String name);

	/**
	 * Ensures that the actual value does not contain an element.
	 *
	 * @param element the element that must not exist
	 * @return the updated verifier
	 * @throws IllegalArgumentException if the array contains {@code element}
	 */
	S doesNotContain(E element);

	/**
	 * Ensures that the actual value does not contain an element.
	 *
	 * @param element the element that must not exist
	 * @param name    the name of the element
	 * @return the updated verifier
	 * @throws NullPointerException     if {@code name} is null
	 * @throws IllegalArgumentException if the array contains {@code element}. If {@code name} is empty.
	 */
	S doesNotContain(E element, String name);

	/**
	 * Ensures that the actual value does not contain exactly the specified elements; nothing less, nothing more.
	 *
	 * @param other the elements that must not exist
	 * @return the updated verifier
	 * @throws NullPointerException     if {@code other} is null
	 * @throws IllegalArgumentException if the array contains all of the elements in {@code other};
	 *                                  nothing less, nothing more.
	 */
	S doesNotContainExactly(Collection<E> other);

	/**
	 * Ensures that the actual value does not contain exactly the specified elements; nothing less, nothing more.
	 *
	 * @param other the elements that must not exist
	 * @param name  the name of the collection
	 * @return the updated verifier
	 * @throws NullPointerException     if {@code other} or {@code name} are null
	 * @throws IllegalArgumentException if the array contains all of the elements in {@code other};
	 *                                  nothing less, nothing more. If {@code name} is empty.
	 */
	S doesNotContainExactly(Collection<E> other, String name);

	/**
	 * Ensures that the actual value does not contain any of the specified elements.
	 *
	 * @param elements the elements that must not exist
	 * @return the updated verifier
	 * @throws NullPointerException     if {@code elements} is null
	 * @throws IllegalArgumentException if the array contains any of {@code elements}
	 */
	S doesNotContainAny(Collection<E> elements);

	/**
	 * Ensures that the actual value does not contain any of the specified elements.
	 *
	 * @param elements the elements that must not exist
	 * @param name     the name of the elements
	 * @return the updated verifier
	 * @throws NullPointerException     if {@code elements} or {@code name} are null
	 * @throws IllegalArgumentException if the array contains any of {@code elements}. If {@code name} is empty.
	 */
	S doesNotContainAny(Collection<E> elements, String name);

	/**
	 * Ensures that the actual value does not contain all of the specified elements.
	 *
	 * @param elements the elements that must not exist
	 * @return the updated verifier
	 * @throws NullPointerException     if {@code elements} is null
	 * @throws IllegalArgumentException if the array contains all of {@code elements}
	 */
	S doesNotContainAll(Collection<E> elements);

	/**
	 * Ensures that the actual value does not contain all of specified elements.
	 *
	 * @param elements the elements that must not exist
	 * @param name     the name of the elements
	 * @return the updated verifier
	 * @throws NullPointerException     if {@code elements} or {@code name} are null
	 * @throws IllegalArgumentException if the array contains all of {@code elements}. If {@code name} is empty.
	 */
	S doesNotContainAll(Collection<E> elements, String name);

	/**
	 * Ensures that the actual value does not contain any duplicate elements.
	 *
	 * @return the updated verifier
	 * @throws IllegalArgumentException if the array contains any duplicate elements
	 */
	S doesNotContainDuplicates();

	/**
	 * Returns a verifier over the array's length.
	 *
	 * @return a verifier over the array's length
	 */
	SizeVerifier length();

	/**
	 * Verifies nested requirements. This mechanism can be used to
	 * <a href="https://bitbucket.org/cowwoc/requirements.java/wiki/Features#markdown-header-grouping-nested-requirements">
	 * group related requirements</a>.
	 *
	 * @param consumer verifies the array's length
	 * @return the updated verifier
	 * @throws NullPointerException if {@code consumer} is null
	 */
	@SuppressWarnings("LongLine")
	S length(Consumer<SizeVerifier> consumer);

	/**
	 * Returns a verifier for the actual value as a collection.
	 *
	 * @return a verifier for the actual value as a collection
	 */
	CollectionVerifier<Collection<E>, E> asCollection();

	/**
	 * Verifies nested requirements. This mechanism can be used to
	 * <a href="https://bitbucket.org/cowwoc/requirements.java/wiki/Features#markdown-header-grouping-nested-requirements">
	 * group related requirements</a>.
	 *
	 * @param consumer verifies the actual value as a collection
	 * @return the updated verifier
	 * @throws NullPointerException if {@code consumer} is null
	 */
	@SuppressWarnings("LongLine")
	S asCollection(Consumer<CollectionVerifier<Collection<E>, E>> consumer);
}
