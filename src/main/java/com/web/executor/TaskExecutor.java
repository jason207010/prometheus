package com.web.executor;

/**
 * @author jayson   2015-07-12 14:58
 * @since v1.0
 * 任务执行器
 */
public interface TaskExecutor<T extends Task> {
    public void execute(T task);
}