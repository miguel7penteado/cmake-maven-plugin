/*
 * Copyright (c) 2019 Gili Tzabari
 * Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 */
package org.bitbucket.cowwoc.requirements.java.internal;

import org.bitbucket.cowwoc.requirements.java.InetAddressValidator;
import org.bitbucket.cowwoc.requirements.java.InetAddressVerifier;
import org.bitbucket.cowwoc.requirements.java.SizeValidator;
import org.bitbucket.cowwoc.requirements.java.SizeVerifier;
import org.bitbucket.cowwoc.requirements.java.StringValidator;
import org.bitbucket.cowwoc.requirements.java.StringVerifier;
import org.bitbucket.cowwoc.requirements.java.UriValidator;
import org.bitbucket.cowwoc.requirements.java.UriVerifier;
import org.bitbucket.cowwoc.requirements.java.UrlValidator;
import org.bitbucket.cowwoc.requirements.java.UrlVerifier;
import org.bitbucket.cowwoc.requirements.java.internal.extension.AbstractObjectVerifier;

import java.util.function.Consumer;

/**
 * Default implementation of {@code StringVerifier}.
 */
public final class StringVerifierImpl
	extends AbstractObjectVerifier<StringVerifier, StringValidator, String>
	implements StringVerifier
{
	/**
	 * @param validator the validator to delegate to
	 * @throws AssertionError if {@code validator} is null
	 */
	public StringVerifierImpl(StringValidator validator)
	{
		super(validator);
	}

	@Override
	protected StringVerifier getThis()
	{
		return this;
	}

	@Override
	public StringVerifier isEmpty()
	{
		validator = validator.isEmpty();
		return validationResult();
	}

	@Override
	public StringVerifier isNotEmpty()
	{
		validator = validator.isNotEmpty();
		return validationResult();
	}

	@Override
	public StringVerifier trim()
	{
		validator = validator.trim();
		return validationResult();
	}

	@Override
	public StringVerifier isTrimmed()
	{
		validator = validator.isTrimmed();
		return validationResult();
	}

	@Override
	public InetAddressVerifier asInetAddress()
	{
		InetAddressValidator newValidator = validator.asInetAddress();
		return validationResult(() -> new InetAddressVerifierImpl(newValidator));
	}

	@Override
	public StringVerifier asInetAddress(Consumer<InetAddressVerifier> consumer)
	{
		if (consumer == null)
			throw new NullPointerException("consumer may not be null");
		consumer.accept(asInetAddress());
		return this;
	}

	@Override
	public UriVerifier asUri()
	{
		UriValidator newValidator = validator.asUri();
		return validationResult(() -> new UriVerifierImpl(newValidator));
	}

	@Override
	public StringVerifier asUri(Consumer<UriVerifier> consumer)
	{
		if (consumer == null)
			throw new NullPointerException("consumer may not be null");
		consumer.accept(asUri());
		return this;
	}

	@Override
	public UrlVerifier asUrl()
	{
		UrlValidator newValidator = validator.asUrl();
		return validationResult(() -> new UrlVerifierImpl(newValidator));
	}

	@Override
	public StringVerifier asUrl(Consumer<UrlVerifier> consumer)
	{
		if (consumer == null)
			throw new NullPointerException("consumer may not be null");
		consumer.accept(asUrl());
		return this;
	}

	@Override
	public StringVerifier startsWith(String prefix)
	{
		validator = validator.startsWith(prefix);
		return validationResult();
	}

	@Override
	public StringVerifier doesNotStartWith(String prefix)
	{
		validator = validator.doesNotStartWith(prefix);
		return validationResult();
	}

	@Override
	public StringVerifier endsWith(String suffix)
	{
		validator = validator.endsWith(suffix);
		return validationResult();
	}

	@Override
	public StringVerifier doesNotEndWith(String suffix)
	{
		validator = validator.doesNotEndWith(suffix);
		return validationResult();
	}

	@Override
	public StringVerifier contains(String expected)
	{
		validator = validator.contains(expected);
		return validationResult();
	}

	@Override
	public StringVerifier doesNotContain(String value)
	{
		validator = validator.doesNotContain(value);
		return validationResult();
	}

	@Override
	public SizeVerifier length()
	{
		SizeValidator newValidator = validator.length();
		return validationResult(() -> new SizeVerifierImpl(newValidator));
	}

	@Override
	public StringVerifier length(Consumer<SizeVerifier> consumer)
	{
		if (consumer == null)
			throw new NullPointerException("consumer may not be null");
		consumer.accept(length());
		return this;
	}
}
