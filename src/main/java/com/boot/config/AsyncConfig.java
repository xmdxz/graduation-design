package com.boot.config;

import cn.hutool.core.util.ObjectUtil;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author TateBrown
 * @date 2021/3/5 10:35 下午
 * 异步任务可以传递上下文
 * fixme 需要注意的是异步任务完成后清空上下文防止内存泄漏
 */
@Configuration
@EnableAsync
@ConfigurationProperties(prefix = "async")
@Data
public class AsyncConfig implements AsyncConfigurer {


    private Integer coreSize;

    private Integer maxPoolSize;

    private Integer queueSize;

    private Integer keepAlive;

    private String threadName;

    private RejectEnum rejectHandle;

    private enum RejectEnum {
        /**
         * 放弃
         */
        ABORT,
        /**
         * 由线程调用者去执行
         */
        CALLER,
        /**
         * 默认删除队列开头的任务，再次尝试
         */
        DISCARD_OLDEST,
        /**
         * 该任务将被删除
         */
        DISCARD;

        static RejectedExecutionHandler getInstance(RejectEnum rejectEnum) {
            if (ObjectUtil.isNull(rejectEnum)) {
                return new ThreadPoolExecutor.CallerRunsPolicy();
            }
            switch (rejectEnum) {
                case ABORT:
                    return new ThreadPoolExecutor.AbortPolicy();
                case DISCARD:
                    return new ThreadPoolExecutor.DiscardPolicy();
                case DISCARD_OLDEST:
                    return new ThreadPoolExecutor.DiscardOldestPolicy();
                case CALLER:
                default:
                    return new ThreadPoolExecutor.CallerRunsPolicy();
            }
        }
    }


    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程数
        executor.setCorePoolSize(coreSize);
        //最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        //队列最大长度
        executor.setQueueCapacity(queueSize);
        //救济线程的最大活动时间
        executor.setKeepAliveSeconds(keepAlive);
        //线程池前缀
        executor.setThreadNamePrefix(threadName);
        //拒绝策略
        executor.setRejectedExecutionHandler(
                RejectEnum.getInstance(rejectHandle)
        );
        // TODO 设置任务的装饰

        //线程初始化
        executor.initialize();
        return executor;
    }


//
//    static class ContextCopyingDecorator implements TaskDecorator {
//        //上下文传递装饰器，Dubbo中的写法
//        //todo 未来可替换成阿里的transmitThreadLocal
//        @NotNull
//        @Override
//        public Runnable decorate(@NotNull Runnable runnable) {
//            try {
//                RequestAttributes context = RequestContextHolder.currentRequestAttributes();
//                UserContext userContext = UserContextHandler.get();
////                Map<String,String> previous = MDC.getCopyOfContextMap();
////                SecurityContext securityContext = SecurityContextHolder.getContext();
//                return () -> {
//                    try {
//                        RequestContextHolder.setRequestAttributes(context);
//                        UserContextHandler.set(userContext);
////                        MDC.setContextMap(previous);
////                        SecurityContextHolder.setContext(securityContext);
//                        runnable.run();
//                    } finally {
//                        //清理上下文，防止内存泄漏
//                        RequestContextHolder.resetRequestAttributes();
//                        UserContextHandler.remove();
////                        SecurityContextHolder.clearContext();
//                    }
//                };
//            } catch (IllegalStateException e) {
//                return runnable;
//            }
//        }
//    }
}
