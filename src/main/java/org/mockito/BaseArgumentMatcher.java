/*
 * Copyright (c) 2016 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito;

import org.mockito.internal.util.Decamelizer;

/**
 * Base class for classes that implement {@link ArgumentMatcher}.
 *
 * <p>This was provided to simplify migration from pre 2.x implementations; it provides a default
 * implementation of {@link #toString()} that provides equivalent behavior to the pre 2.x version.
 */
public abstract class BaseArgumentMatcher<T> implements ArgumentMatcher<T> {

    /**
     * By default this method decamelizes matchers name to promote meaningful names for matchers.
     *
     * <p>For example <b>StringWithStrongLanguage</b> matcher will generate 'String with strong
     * language' description in case of failure.
     *
     * <p>You might want to override this method to provide more specific description of the matcher
     * (useful when verification failures are reported).
     *
     * @return the string representation of this matcher.
     */
    @Override
    public String toString() {
        String className = getClass().getSimpleName();
        return Decamelizer.decamelizeMatcher(className);
    }
}
