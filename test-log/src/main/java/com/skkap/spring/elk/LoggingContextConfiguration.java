package com.skkap.spring.elk;

import javax.annotation.PostConstruct;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingContextConfiguration {
  @Value("${spring.profiles.active}")
  private String activeProfile;

  @Value("${K8S_NODE_NAME}")
  private String kubernetesNodeName;

  @Value("${K8S_POD_NAMESPACE}")
  private String kubernetesPodNamespace;

  @Value("${K8S_POD}")
  private String kubernetesPod;

  @PostConstruct
  public void init() {
    MDC.put("activeProfile", activeProfile);
    MDC.put("kubernetesNodeName", kubernetesNodeName);
    MDC.put("kubernetesPodNamespace", kubernetesPodNamespace);
    MDC.put("kubernetesPod", kubernetesPod);
  }
}
