package com.huaweicse.tools.migrator;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MigratorApplication implements CommandLineRunner {

  private static final Logger LOGGER = LoggerFactory.getLogger(MigratorApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(MigratorApplication.class, args);
  }

  @Autowired
  ApplicationContext applicationContext;

  @Override
  public void run(String... args) {
    Map<String, Action> beansOfType = applicationContext.getBeansOfType(Action.class);
    if (args.length <= 0) {
      printUsage(beansOfType);
      return;
    }
    Action action = targetAction(args[0], beansOfType);
    if (action == null) {
      printUsage(beansOfType);
      return;
    }
    action.run(args);
  }

  private Action targetAction(String arg, Map<String, Action> beansOfType) {
    for (Map.Entry<String, Action> entry : beansOfType.entrySet()) {
      if (entry.getValue().name().equals(arg)) {
        return entry.getValue();
      }
    }
    return null;
  }

  private void printUsage(Map<String, Action> beansOfType) {
    LOGGER.error("Usage: ");
    LOGGER.error("java -jar migrator-0.0.1-SNAPSHOT.jar action [options]");
    LOGGER.error("Available actions: ");
    beansOfType.forEach((k, v) -> LOGGER.error(v.name()));
  }
}