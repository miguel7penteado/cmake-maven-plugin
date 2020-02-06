/*
 * Copyright (c) 2016 Gili Tzabari
 * Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 */
package org.bitbucket.cowwoc.requirements.java.internal.diff;

/**
 * A terminal that supports ANSI color codes.
 */
interface ColoredDiff
{
	/**
	 * @param text the text that did not change
	 * @return the (possibly decorated) text
	 */
	String decorateUnchangedText(String text);

	/**
	 * @param text the text that was inserted
	 * @return the (possibly decorated) text
	 */
	String decorateInsertedText(String text);

	/**
	 * @param text the text that was deleted
	 * @return the (possibly decorated) text
	 */
	String decorateDeletedText(String text);

	/**
	 * Ends any ongoing text decoration.
	 *
	 * @return the text to insert
	 */
	String stopDecoration();
}
