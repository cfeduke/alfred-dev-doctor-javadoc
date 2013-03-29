package com.deploymentzone.devdoctor.javadoc

import spock.lang.Specification

class DocumentParserWithDescriptionSpecification extends Specification {
  DocumentParser parser;

  def setup() {
    def text = getClass().getResourceAsStream("/groovy-javadoc/AnnotatedNode.html").text
    parser = DocumentParser.parse(text)
  }

  def "description"() {
    expect:
    parser.description == "Base class for any AST node which is capable of being annotated"
  }
}
