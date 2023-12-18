/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.scheduling.concurrent;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Juergen Hoeller
 */
public class ThreadPoolExecutorFactoryBeanTests {

    @Test
    public void defaultExecutor() throws Exception {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ExecutorConfig.class);
        ExecutorService executor = context.getBean(ExecutorService.class);

        FutureTask<String> task = new FutureTask<>(() -> "foo");
        executor.execute(task);
        assertThat(task.get()).isEqualTo("foo");
        context.close();
    }


    @Configuration
    public static class ExecutorConfig {

        @Bean
        public ThreadPoolExecutorFactoryBean executor() {
            return new ThreadPoolExecutorFactoryBean();
        }

    }

}
