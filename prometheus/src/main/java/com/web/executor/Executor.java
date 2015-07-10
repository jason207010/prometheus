package com.web.executor;

/**
 * @author jayson   2015-07-10-14:24
 * @since v1.0
 */
public interface Executor<T> {
    public void execute(T task);
}
