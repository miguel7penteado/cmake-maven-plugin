/*
 * Copyright (c) 2019 Gili Tzabari
 * Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 */
package org.bitbucket.cowwoc.requirements.java.internal.extension;

import org.bitbucket.cowwoc.requirements.java.Configuration;
import org.bitbucket.cowwoc.requirements.java.ValidationFailure;
import org.bitbucket.cowwoc.requirements.java.extension.ExtensibleIntegerValidator;
import org.bitbucket.cowwoc.requirements.java.internal.ValidationFailureImpl;
import org.bitbucket.cowwoc.requirements.java.internal.scope.ApplicationScope;

import java.util.List;

/**
 * Extensible implementation of {@code ExtensibleIntegerValidator}.
 *
 * @param <S> the type of validator returned by the methods
 * @param <T> the type of the value being validated
 */
public abstract class AbstractIntegerValidator<S, T extends Number & Comparable<? super T>>
	extends AbstractNumberValidator<S, T>
	implements ExtensibleIntegerValidator<S, T>
{
	/**
	 * @param scope    the application configuration
	 * @param config   the instance configuration
	 * @param name     the name of the value
	 * @param actual   the actual value
	 * @param failures the list of validation failures
	 * @throws AssertionError if {@code scope}, {@code config}, {@code name} or {@code failures} are null. If
	 *                        {@code name} is empty.
	 */
	protected AbstractIntegerValidator(ApplicationScope scope, Configuration config, String name, T actual,
	                                   List<ValidationFailure> failures)
	{
		super(scope, config, name, actual, failures);
	}

	@Override
	public S isWholeNumber()
	{
		return getThis();
	}

	@Override
	public S isNotWholeNumber()
	{
		ValidationFailure failure = new ValidationFailureImpl(scope, config, IllegalArgumentException.class,
			name + " may not be a whole number.").
			addContext("Actual", actual);
		addFailure(failure);
		return getThis();
	}
}
