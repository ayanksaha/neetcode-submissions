class Solution {

    public String encode(List<String> strs) {
    final StringBuilder encodedString = new StringBuilder();
    for (String str : strs) {
      encodedString.append(str.length()).append(":/").append(str);
    }
    return encodedString.toString();
  }

  public List<String> decode(String str) {
    final List<String> strs = new ArrayList<>();

    while (str.length() > 0) {
      int separatorIdx = str.indexOf(":/");
      int noOfChars = Integer.parseInt(str.substring(0, separatorIdx));
      int endIdx = separatorIdx + noOfChars + 1 + 1;
      strs.add(str.substring(separatorIdx + ":/".length(), endIdx));
      str = str.substring(endIdx);
    }
    return strs;
  }
}
