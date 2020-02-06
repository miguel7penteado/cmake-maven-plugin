/*
 * Copyright (c) 2016 Gili Tzabari
 * Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 */
package org.bitbucket.cowwoc.requirements.java.internal.scope;

import org.bitbucket.cowwoc.requirements.java.internal.terminal.Terminal;

import java.util.function.Supplier;

/**
 * The JVM configuration.
 * <p>
 * Implementations must be thread-safe.
 */
public interface JvmScope extends AutoCloseable
{
	/**
	 * @return the terminal attached to the process
	 */
	Terminal getTerminal();

	/**
	 * @return the global configuration inherited by all verifiers
	 */
	GlobalConfiguration getGlobalConfiguration();

	/**
	 * @return the configuration of all verifiers invoked by the current thread
	 */
	Supplier<ThreadConfiguration> getThreadConfiguration();

	@Override
	void close();
}
