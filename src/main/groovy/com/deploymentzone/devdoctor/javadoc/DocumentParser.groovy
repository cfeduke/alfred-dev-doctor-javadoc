package com.deploymentzone.devdoctor.javadoc

import groovy.util.slurpersupport.GPathResult;

class DocumentParser {
  String description
  static DocumentParser parse(String contents) {
    DocumentParser result = new DocumentParser()
    GPathResult page = new HtmlToXmlConverter(contents).convert()
    def paragraphs = page.depthFirst().collect { it }.findAll { it.name() == "p" }
    if (paragraphs.any()) {
      String[] raw = paragraphs[0].text().replaceFirst("\n", "").split("\n")
      result.description = raw[0].trim()
    }
    result
  }
}
