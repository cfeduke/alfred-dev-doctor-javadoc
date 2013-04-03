package com.deploymentzone.devdoctor.javadoc
import java.io.File
class FrameParser {
  final String baseUrl
  final String overviewUrl
  final String allClassesUrl

  FrameParser(String baseUrl) {
    this.baseUrl = baseUrl
    if (!this.baseUrl.endsWith(File.separator)) {
      this.baseUrl += File.separator
    }

    overviewUrl = this.baseUrl + "overview-frame.html"
    allClassesUrl = this.baseUrl + "allclasses-frame.html"
  }

  String toFullUrl(String partialUrl) {
    baseUrl + partialUrl
  }
}
