package com.demo.configuration;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringConfiguration implements WebMvcConfigurer {

  @Override
  public void addFormatters(final @NotNull FormatterRegistry registry) {
    //Adds useful formatter for our MVC binding, for example StringToEnumIgnoringCaseConverterFactory.
    ApplicationConversionService.configure(registry);
  }
}
