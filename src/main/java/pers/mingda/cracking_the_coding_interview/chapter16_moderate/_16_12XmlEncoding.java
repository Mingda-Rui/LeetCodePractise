package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

public class _16_12XmlEncoding {
  String encodeToString(XmlEncodingElement root) {
    StringBuilder sb = new StringBuilder();
    encode(root, sb);
    return sb.toString();
  }

  void encode(XmlEncodingElement root, StringBuilder sb) {
    encode(root.getNameCode(), sb);
    for (XmlEncodingAttribute a : root.attributes) {
      encode(a, sb);
    }
    encode("0", sb);
    if (root.value != null && !root.value.isEmpty()) {
      encode(root.value, sb);
    } else {
      for (XmlEncodingElement e : root.children) {
        encode(e, sb);
      }
    }
    encode("0", sb);
  }

  void encode(String v, StringBuilder sb) {
    sb.append(v);
    sb.append(" ");
  }

  void encode(XmlEncodingAttribute attr, StringBuilder sb) {
    encode(attr.getTagCode(), sb);
    encode(attr.value, sb);
  }
}

abstract class XmlEncodingElement {
  XmlEncodingAttribute[] attributes;
  String value;
  XmlEncodingElement[] children;

  abstract String getNameCode();
}

abstract class XmlEncodingAttribute {
  String value;

  abstract String getTagCode();
}
