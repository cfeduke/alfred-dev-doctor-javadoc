package com.deploymentzone.devdoctor.javadoc;

import groovy.util.slurpersupport.GPathResult;
import org.htmlcleaner.*

class HtmlToXmlConverter {
  String contents
  def HtmlToXmlConverter(String contents) {
    this.contents = contents
  }

  GPathResult convert() {
    def cleaner = new HtmlCleaner();
    def node = cleaner.clean(contents);
    def props = cleaner.getProperties()
    def serializer = new SimpleXmlSerializer(props)
    def xml = serializer.getAsString(node);
    return new XmlSlurper(false,false).parseText(xml)
  }
}
