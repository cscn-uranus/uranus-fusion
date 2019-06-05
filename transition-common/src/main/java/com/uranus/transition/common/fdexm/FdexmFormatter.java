package com.uranus.transition.common.fdexm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author XiaoPeng
 * @date 2018/10/15
 */
public class FdexmFormatter {

  private static final Pattern LIST_PATTERN =
      Pattern.compile(
          "(?<list>(?<begin>-BEGIN[\\s]+[^-{}\\[\\]\"]*)(?<body>[\\s\\S]*?)(?<end>-END[\\s]+[^-{}\\[\\]\"]*))");

  private static final Pattern OBJECT_PATTERN =
      Pattern.compile(
          "(?<object>"
              + "(?<objectTag>-(FAC|PT|RUNWAY|LPS|TIME)[\\s]+)"
              + "(?<objectBody>((?!-(FAC|PT|RUNWAY|LPS|TIME)[\\s])[^{}\\[\\]\"])*)"
              + ")");

  private static final Pattern PAIR_PATTERN =
      Pattern.compile(
          "(?<pair>(?<field>-[^-{}\\[\\]\"\\s]*)(?<sep>[\\s]*)(?<value>[^-{}\\[\\]\"]*))");

  private static final Pattern PAIR_NOVALUE_PATTERN =
      Pattern.compile(
          "(?<pair>(?<field>-[^{}\\[\\]\"\\s]*)(?<sep>[\\s]*)(?<emptyValue>[^-{}\\[\\]\"]*))");

  private static final Pattern CROSS_PAIR_PATTERN =
      Pattern.compile(
          "(?<crossPair>(?<pre>[^:\"]*)(?<quote>(\"[\\s]*\"|][\\s]*\"))(?<next>[^{}\\[\\]:\"]+))");

  public static String fdexm2Json(String input) {
    String jsonText = input;
    jsonText = trimSpecialChar(jsonText);
    jsonText = transformHeaderAndTail(jsonText);
    jsonText = transformList(jsonText);
    jsonText = transformPairWithValue(jsonText);
    jsonText = insertCommaBetweenPair(jsonText);
    return jsonText;
  }

  private static String trimSpecialChar(String input) {
    String transformed = input;
    transformed = transformed.replaceAll("[{}\\[\\]\\\\\"]", "");
    return transformed;
  }

  private static String transformHeaderAndTail(String input) {
    String transformed = input;
    transformed = transformed.replace("ZCZC", "{").replace("NNNN", "}");
    return transformed;
  }

  private static String transformList(String input) {

    String transformed = input;

    Matcher matcher = LIST_PATTERN.matcher(input);

    while (matcher.find()) {
      String list;
      String begin;
      String body;
      String end;

      list = matcher.group("list");

      begin = matcher.group("begin");
      body = matcher.group("body");
      end = matcher.group("end");

      String beginTag = begin.replace("-BEGIN", "").trim();
      String endTag = end.replace("-END", "").trim();

      if (FdexmValidator.isValidList(beginTag, endTag)) {
        String listReplacement;
        String beginReplacement;
        String bodyReplacement;
        String endReplacement;

        beginReplacement = "\"" + beginTag + "\"" + ": [";
        bodyReplacement = body.trim();
        endReplacement = "]";
        listReplacement = beginReplacement + bodyReplacement + endReplacement;

        listReplacement = transformObjectInList(listReplacement);
        transformed = transformed.replace(list, listReplacement);
      }
    }
    return transformed;
  }

  private static String transformObjectInList(String input) {
    String transformed;
    transformed = input;

    Matcher matcher = OBJECT_PATTERN.matcher(transformed);
    while (matcher.find()) {
      String object = matcher.group("object");
      String objectTag = matcher.group("objectTag");
      String objectBody = matcher.group("objectBody");

      String objectTagReplacement = "";
      String objectBodyReplacement = "{" + objectBody.trim() + "}";
      String objectReplacement = objectTagReplacement + objectBodyReplacement;

      transformed = transformed.replaceAll(object, objectReplacement);
    }
    transformed = transformed.replace("}{", "},{");
    return transformed;
  }

  private static String transformPairWithValue(String input) {
    String transformed = input;

    Matcher matcher = PAIR_PATTERN.matcher(input);
    while (matcher.find()) {
      String pair = matcher.group("pair");
      String field = matcher.group("field");
      String value = matcher.group("value");
      String fieldReplacement = "\"" + field.replace("-", "").trim() + "\"";
      String valueReplacement = "\"" + value.trim() + "\"";
      String pairReplacement = fieldReplacement + ":" + valueReplacement;
      transformed = transformed.replace(pair, pairReplacement);
    }
    return transformed;
  }

  private static String insertCommaBetweenPair(String input) {
    String transformed = input;

    Matcher matcher = CROSS_PAIR_PATTERN.matcher(transformed);
    while (matcher.find()) {
      String crossPair = matcher.group("crossPair");
      String pre = matcher.group("pre");
      String quote = matcher.group("quote");
      String next = matcher.group("next");
      String preReplacement = pre.trim();
      String quoteReplacement;
      quoteReplacement = "\",\"";
      if (quote.startsWith("]")) {
        quoteReplacement = "],\"";
      }
      String nextReplacement = next.trim();

      String crossPairReplacement = preReplacement + quoteReplacement + nextReplacement;
      transformed = transformed.replace(crossPair, crossPairReplacement);
    }
    return transformed;
  }
}
