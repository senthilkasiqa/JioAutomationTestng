package com.jio.common.utilities;

import com.google.common.base.Function;
/**
 * 
 * @author reliancejio
 *
 * @param <O>
 * @param <T>
 */

public interface ExpectedCondition<O,T> extends Function<O, T> {}

