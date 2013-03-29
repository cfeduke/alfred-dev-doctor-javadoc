package com.deploymentzone.devdoctor.javadoc
import spock.lang.*

class LinksSpecification extends spock.lang.Specification {
  def "from with one link"() {
    List<Link> links
    when:
    def raw = new XmlSlurper().parseText("<a href='/home/index.html'>text</a>")
    links = Links.from(raw)
    then:
    links.size() == 1
    links.getAt(0).href == "/home/index.html"
    links.getAt(0).text == "text"
  }
}
