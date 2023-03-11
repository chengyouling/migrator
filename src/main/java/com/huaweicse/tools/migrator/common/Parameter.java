package com.huaweicse.tools.migrator.common;

import java.util.Arrays;
import java.util.List;

public class Parameter {
  public String annotation;

  public String type;

  public String name;

  public List<String> simpleType =
      Arrays.asList("int", "long", "double", "float", "byte", "short", "boolean",
          "Integer", "Long", "Double", "Float", "Byte", "Short", "Boolean",
          "Date",
          "AdapterType", "OmsType", "E3Type", "LogisticsType", "WmsType", "TaxType", "TmsType", "ILOType"); // enums

  public Parameter(String annotation, String type, String name) {
    this.annotation = annotation;
    this.type = type;
    this.name = name;
  }

  public boolean isSimpleType() {
    return simpleType.contains(type);
  }

  public boolean isStringType() {
    return "String".equals(type);
  }
}
