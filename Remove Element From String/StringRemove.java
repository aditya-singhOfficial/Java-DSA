public class StringRemove {
    static String removeStr(String base, String rmv) {
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        while (i < base.length()) {
            if (i + rmv.length() <= base.length()
                    && base.substring(i, i + rmv.length()).toLowerCase().equals(rmv.toLowerCase())) {
                i += rmv.length();
            } else {
                sb.append(base.charAt(i));
                i++;
            }
        }
        System.out.println(sb.toString());

        return base.replaceAll(rmv, "");
    }

    public static void main(String[] args) {
        String base = "This is a fish";
        String rmv = "IS";
        // System.out.println(removeStr(base, rmv));

        String name = "I am  Aryan";
        for (String s : name.split("\\s+")) {
            System.out.println(s);
        }
    }
}