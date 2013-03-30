package com.deploymentzone.devdoctor.javadoc

import spock.lang.Specification;

class DocumentParserWithNoDescriptionSpecification extends Specification {
  DocumentParser parser

  def setup() {
    def text = getClass().getResourceAsStream("/groovy-javadoc/AbstractFactory.html").text
    parser = DocumentParser.parse(text)
  }

  def "description"() {
    expect:
    parser.description.length() == 0
  }
}
