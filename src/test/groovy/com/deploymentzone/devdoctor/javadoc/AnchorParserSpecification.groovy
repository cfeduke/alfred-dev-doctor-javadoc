package com.deploymentzone.devdoctor.javadoc
import spock.lang.*

class AnchorParserSpecification extends spock.lang.Specification {
  AnchorParser parser

  def setup() {
    def text = getClass().getResourceAsStream("/groovy-javadoc/allclasses-frame.html").text
    parser = AnchorParser.parse(text)
  }

  def "links.size"() {
    expect:
    parser.links.size() == 1263
  }

  def "links:first" () {
    expect:
    parser.links.getAt(0).href == "org/codehaus/groovy/syntax/ASTHelper.html"
    parser.links.getAt(0).text == "ASTHelper"
  }

  def "links:last"() {
    expect:
    parser.links.getAt(parser.links.size() - 1).href == "org/codehaus/groovy/classgen/genMathModification.html"
    parser.links.getAt(parser.links.size() - 1).text == "genMathModification"
  }

  def "links:contains"() {
    expect:
    parser.links.any { it.href == "org/codehaus/groovy/tools/groovydoc/gstringTemplates/GroovyDocTemplateInfo.html" && it.text == "GroovyDocTemplateInfo" }
  }
}
