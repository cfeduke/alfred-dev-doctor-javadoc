package com.deploymentzone.devdoctor.javadoc

import spock.lang.*

class AnchorParserWithOneAnchor extends spock.lang.Specification {
  AnchorParser parser;

  def setup() {
    def text = getClass().getResourceAsStream("/groovy-javadoc/allclasses-frame-one-link.html").text
    parser = AnchorParser.parse(text);
  }

  def "links"() {
    expect:
    parser.links.size() == 1
    parser.links.getAt(0).href == "org/codehaus/groovy/syntax/ASTHelper.html"
    parser.links.getAt(0).text == "ASTHelper"
  }

}
