package com.deploymentzone.devdoctor.javadoc

class Links {
  private Links() { }

  public static List<Link> from(nodes) {
    nodes.collect {
      new Link(href: it.@href, text: it.text())
    }
  }
}
