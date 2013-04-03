package com.deploymentzone.devdoctor.javadoc

import spock.lang.*;

class FrameParserSpecification extends Specification {
  FrameParser frameParser

  def setup() {
    frameParser = new FrameParser("http://example.com")
  }
  def "overviewUrl returns overview-frame.html"() {
    expect:
    frameParser.overviewUrl == "http://example.com/overview-frame.html"
  }
  def "allClassesUrl returns allclasses-frame.html"() {
    expect:
    frameParser.allClassesUrl == "http://example.com/allclasses-frame.html"
  }
  def "toFullUrl returns appropriate URL"() {
    expect:
    frameParser.toFullUrl("org/spring/test.html") == "http://example.com/org/spring/test.html"
  }
}
