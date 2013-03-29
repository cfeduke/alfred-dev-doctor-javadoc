package com.deploymentzone.devdoctor.javadoc

class AnchorParser {
  List<Link> links

  static AnchorParser parse(String contents) {
    AnchorParser result = new AnchorParser()
    def page = new HtmlToXmlConverter(contents).convert();
    result.links = Links.from(page.depthFirst().collect { it }.findAll { it.name() == "a" })
    result
  }
}
