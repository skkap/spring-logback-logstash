package com.skkap.spring.elk;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfiguration {
  private final Logger logger = LoggerFactory.getLogger(getClass());

  @Value("${spring.profiles.active}")
  private String activeProfile;

  @PostConstruct
  public void init() {
    MDC.put("profile", activeProfile);
    
    logger.trace("trace message");
    logger.debug("debug message");
    logger.info("info message");
    logger.warn("warn message");
    logger.error("error message");
  }
}
