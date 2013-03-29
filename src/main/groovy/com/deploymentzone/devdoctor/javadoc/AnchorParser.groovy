package com.deploymentzone.devdoctor.javadoc
import org.htmlcleaner.*

class AnchorParser {
  List<Link> links

  public static AnchorParser parse(String contents) {
    AnchorParser result = new AnchorParser()
    def cleaner = new HtmlCleaner();
    def node = cleaner.clean(contents);
    def props = cleaner.getProperties()
    def serializer = new SimpleXmlSerializer(props)
    def xml = serializer.getAsString(node);
    def page = new XmlSlurper(false,false).parseText(xml)
    result.links = Links.from(page.depthFirst().collect { it }.findAll { it.name() == "a" })
    result
  }
}
