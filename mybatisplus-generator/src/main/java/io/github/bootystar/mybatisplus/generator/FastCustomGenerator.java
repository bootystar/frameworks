/*
 * Copyright (c) 2011-2022, baomidou (jobob@qq.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.bootystar.mybatisplus.generator;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import io.github.bootystar.mybatisplus.generator.config.CustomConfig;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * mybatis plus FastCustomGenerator
 *
 * @author L.cm, lanjerry  booty
 * @since 2021-07-22 =
 */
public final class FastCustomGenerator {

    /**
     * 数据源配置 Builder
     */
    private final DataSourceConfig.Builder dataSourceConfigBuilder;

    /**
     * 全局配置 Builder
     */
    private final GlobalConfig.Builder globalConfigBuilder;

    /**
     * 包配置 Builder
     */
    private final PackageConfig.Builder packageConfigBuilder;

    /**
     * 策略配置 Builder
     */
    private final StrategyConfig.Builder strategyConfigBuilder;

    /**
     * 注入配置 Builder
     */
    private final InjectionConfig.Builder injectionConfigBuilder;

    /**
     * 模板配置 Builder
     */
    private final TemplateConfig.Builder templateConfigBuilder;
    /**
     * 自定义配置
     */
    private final CustomConfig.Builder customConfigBuilder;

    /**
     * 模板引擎
     */
    private AbstractTemplateEngine templateEngine;

    private FastCustomGenerator(DataSourceConfig.Builder dataSourceConfigBuilder) {
        this.dataSourceConfigBuilder = dataSourceConfigBuilder;
        this.globalConfigBuilder = new GlobalConfig.Builder();
        this.packageConfigBuilder = new PackageConfig.Builder();
        this.strategyConfigBuilder = new StrategyConfig.Builder();
        this.injectionConfigBuilder = new InjectionConfig.Builder();
        this.templateConfigBuilder = new TemplateConfig.Builder();
        this.customConfigBuilder = new CustomConfig.Builder();
    }

    public static FastCustomGenerator create(@NotNull String url, String username, String password) {
        return new FastCustomGenerator(new DataSourceConfig.Builder(url, username, password));
    }

    public static FastCustomGenerator create(@NotNull DataSourceConfig.Builder dataSourceConfigBuilder) {
        return new FastCustomGenerator(dataSourceConfigBuilder);
    }

    /**
     * 读取控制台输入内容
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * 控制台输入内容读取并打印提示信息
     *
     * @param message 提示信息
     * @return String
     */
    public String scannerNext(String message) {
        System.out.println(message);
        String nextLine = scanner.nextLine();
        if (StringUtils.isBlank(nextLine)) {
            // 如果输入空行继续等待
            return scanner.next();
        }
        return nextLine;
    }

    /**
     * 全局配置
     *
     * @param consumer 自定义全局配置
     * @return FastAutoGenerator
     */
    public FastCustomGenerator dataSourceConfig(Consumer<DataSourceConfig.Builder> consumer) {
        consumer.accept(this.dataSourceConfigBuilder);
        return this;
    }

    public FastCustomGenerator dataSourceConfig(BiConsumer<Function<String, String>, DataSourceConfig.Builder> biConsumer) {
        biConsumer.accept(this::scannerNext, this.dataSourceConfigBuilder);
        return this;
    }

    /**
     * 全局配置
     *
     * @param consumer 自定义全局配置
     * @return FastAutoGenerator
     */
    public FastCustomGenerator globalConfig(Consumer<GlobalConfig.Builder> consumer) {
        consumer.accept(this.globalConfigBuilder);
        return this;
    }

    public FastCustomGenerator globalConfig(BiConsumer<Function<String, String>, GlobalConfig.Builder> biConsumer) {
        biConsumer.accept(this::scannerNext, this.globalConfigBuilder);
        return this;
    }

    /**
     * 包配置
     *
     * @param consumer 自定义包配置
     * @return FastAutoGenerator
     */
    public FastCustomGenerator packageConfig(Consumer<PackageConfig.Builder> consumer) {
        consumer.accept(this.packageConfigBuilder);
        return this;
    }

    public FastCustomGenerator packageConfig(BiConsumer<Function<String, String>, PackageConfig.Builder> biConsumer) {
        biConsumer.accept(this::scannerNext, this.packageConfigBuilder);
        return this;
    }

    /**
     * 策略配置
     *
     * @param consumer 自定义策略配置
     * @return FastAutoGenerator
     */
    public FastCustomGenerator strategyConfig(Consumer<StrategyConfig.Builder> consumer) {
        consumer.accept(this.strategyConfigBuilder);
        return this;
    }

    public FastCustomGenerator strategyConfig(BiConsumer<Function<String, String>, StrategyConfig.Builder> biConsumer) {
        biConsumer.accept(this::scannerNext, this.strategyConfigBuilder);
        return this;
    }

    /**
     * 注入配置
     *
     * @param consumer 自定义注入配置
     * @return FastAutoGenerator
     */
    public FastCustomGenerator injectionConfig(Consumer<InjectionConfig.Builder> consumer) {
        consumer.accept(this.injectionConfigBuilder);
        return this;
    }

    public FastCustomGenerator injectionConfig(BiConsumer<Function<String, String>, InjectionConfig.Builder> biConsumer) {
        biConsumer.accept(this::scannerNext, this.injectionConfigBuilder);
        return this;
    }

    /**
     * 模板配置
     *
     * @param consumer 自定义模板配置
     * @return FastAutoGenerator
     */
    public FastCustomGenerator templateConfig(Consumer<TemplateConfig.Builder> consumer) {
        consumer.accept(this.templateConfigBuilder);
        return this;
    }

    public FastCustomGenerator templateConfig(BiConsumer<Function<String, String>, TemplateConfig.Builder> biConsumer) {
        biConsumer.accept(this::scannerNext, this.templateConfigBuilder);
        return this;
    }

    /**
     * 自定义配置
     *
     * @param consumer 自定义配置
     * @return FastAutoGenerator
     */
    public FastCustomGenerator customConfig(Consumer<CustomConfig.Builder> consumer) {
        consumer.accept(this.customConfigBuilder);
        return this;
    }

    /**
     * 自定义配置
     *
     * @param biConsumer bi消费者
     * @return {@code FastCustomGenerator }
     * @author booty
     * @date 2023/07/14 11:41
     */
    public FastCustomGenerator customConfig(BiConsumer<Function<String, String>, CustomConfig.Builder> biConsumer) {
        biConsumer.accept(this::scannerNext, this.customConfigBuilder);
        return this;
    }


    /**
     * 模板引擎配置
     *
     * @param templateEngine 模板引擎
     * @return FastAutoGenerator
     */
    public FastCustomGenerator templateEngine(AbstractTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
        return this;
    }



    public void execute() {
        new AutoGenerator(this.dataSourceConfigBuilder.build())
            // 全局配置
            .global(this.globalConfigBuilder.build())
            // 包配置
            .packageInfo(this.packageConfigBuilder.build())
            // 策略配置
            .strategy(this.strategyConfigBuilder.build())
            // 注入配置
            .injection(this.injectionConfigBuilder.build())
            // 模板配置
            .template(this.templateConfigBuilder.build())
            // 执行
            .execute(this.templateEngine);
    }
}
