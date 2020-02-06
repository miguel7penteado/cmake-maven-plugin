/*
 * Copyright (c) 2019 Gili Tzabari
 * Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 */
package org.bitbucket.cowwoc.requirements.java.internal.extension;

import org.bitbucket.cowwoc.requirements.java.CollectionVerifier;
import org.bitbucket.cowwoc.requirements.java.SizeVerifier;
import org.bitbucket.cowwoc.requirements.java.extension.ExtensibleArrayVerifier;
import org.bitbucket.cowwoc.requirements.java.internal.CollectionVerifierNoOp;
import org.bitbucket.cowwoc.requirements.java.internal.SizeVerifierNoOp;

import java.util.Collection;
import java.util.function.Consumer;

/**
 * An {@code ExtensibleArrayVerifier} that does nothing.
 *
 * @param <S> the type of verifier returned by the methods
 * @param <E> the type of elements in the array
 * @param <A> the type of the array
 */
public abstract class AbstractArrayVerifierNoOp<S, E, A>
	extends AbstractObjectVerifierNoOp<S, A>
	implements ExtensibleArrayVerifier<S, E, A>
{
	@Override
	public S isEmpty()
	{
		return getThis();
	}

	@Override
	public S isNotEmpty()
	{
		return getThis();
	}

	@Override
	public S contains(E expected)
	{
		return getThis();
	}

	@Override
	public S contains(E expected, String name)
		throws NullPointerException, IllegalArgumentException
	{
		return getThis();
	}

	@Override
	public S containsExactly(Collection<E> expected)
	{
		return getThis();
	}

	@Override
	public S containsExactly(Collection<E> expected, String name)
	{
		return getThis();
	}

	@Override
	public S containsAny(Collection<E> expected)
	{
		return getThis();
	}

	@Override
	public S containsAny(Collection<E> expected, String name)
	{
		return getThis();
	}

	@Override
	public S containsAll(Collection<E> expected)
	{
		return getThis();
	}

	@Override
	public S containsAll(Collection<E> expected, String name)
	{
		return getThis();
	}

	@Override
	public S doesNotContain(E element)
	{
		return getThis();
	}

	@Override
	public S doesNotContain(E element, String name)
	{
		return getThis();
	}

	@Override
	public S doesNotContainExactly(Collection<E> element)
	{
		return getThis();
	}

	@Override
	public S doesNotContainExactly(Collection<E> element, String name)
	{
		return getThis();
	}

	@Override
	public S doesNotContainAny(Collection<E> elements)
	{
		return getThis();
	}

	@Override
	public S doesNotContainAny(Collection<E> element, String names)
	{
		return getThis();
	}

	@Override
	public S doesNotContainAll(Collection<E> elements)
	{
		return getThis();
	}

	@Override
	public S doesNotContainAll(Collection<E> element, String names)
	{
		return getThis();
	}

	@Override
	public S doesNotContainDuplicates()
	{
		return getThis();
	}

	@Override
	public SizeVerifier length()
	{
		return SizeVerifierNoOp.getInstance();
	}

	@Override
	public S length(Consumer<SizeVerifier> consumer)
	{
		if (consumer == null)
			throw new NullPointerException("consumer may not be null");
		return getThis();
	}

	@Override
	public CollectionVerifier<Collection<E>, E> asCollection()
	{
		return CollectionVerifierNoOp.getInstance();
	}

	@Override
	public S asCollection(Consumer<CollectionVerifier<Collection<E>, E>> consumer)
	{
		if (consumer == null)
			throw new NullPointerException("consumer may not be null");
		return getThis();
	}
}
