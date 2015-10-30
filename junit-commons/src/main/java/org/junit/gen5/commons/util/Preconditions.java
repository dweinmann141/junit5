/*
 * Copyright 2015 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.junit.gen5.commons.util;

import java.util.function.Supplier;

/**
 * @author Sam Brannen
 * @since 5.0
 */
public final class Preconditions {

	private Preconditions() {
		/* no-op */
	}

	public static void notNull(Object object, String message) {
		condition(object != null, message);
	}

	public static void notNull(Object object, Supplier<String> messageSupplier) {
		condition(object != null, messageSupplier);
	}

	/**
	 * @see StringUtils#isEmpty(CharSequence)
	 */
	public static void notEmpty(String str, String message) {
		condition(!StringUtils.isEmpty(str), message);
	}

	/**
	 * @see StringUtils#isEmpty(CharSequence)
	 */
	public static void notEmpty(String str, Supplier<String> messageSupplier) {
		condition(!StringUtils.isEmpty(str), messageSupplier);
	}

	/**
	 * @see StringUtils#isBlank(String)
	 */
	public static void notBlank(String str, String message) {
		condition(!StringUtils.isBlank(str), message);
	}

	/**
	 * @see StringUtils#isBlank(String)
	 */
	public static void notBlank(String str, Supplier<String> messageSupplier) {
		condition(!StringUtils.isBlank(str), messageSupplier);
	}

	public static void condition(boolean predicate, String message) {
		if (!predicate) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void condition(boolean predicate, Supplier<String> messageSupplier) {
		if (!predicate) {
			throw new IllegalArgumentException(messageSupplier.get());
		}
	}

}
