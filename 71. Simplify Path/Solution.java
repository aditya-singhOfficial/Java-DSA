class Solution {
    public String simplifyPath(String path) {

        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String ch : parts) {
            if (ch.equals("") || ch.equals(".")) {
                continue;
            }
            else if (ch.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (String dir : stack) {
            sb.append("/");
            sb.append(dir);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}