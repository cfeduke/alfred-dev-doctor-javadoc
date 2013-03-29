package com.deploymentzone.devdoctor.javadoc

import spock.lang.Specification;

class LinkSpecification extends Specification {
  def link
  def setup() {
    link = new Link(href: 'href', text: 'text')
  }
  def "it"() {
    expect:
    link.href == "href"
    link.text == "text"
  }
}
