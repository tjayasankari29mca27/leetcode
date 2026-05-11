import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        // Split by one or more slashes
        String[] components = path.split("/");

        for (String directory : components) {
            // 1. If it's ".." go up one level (pop from stack)
            if (directory.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } 
            // 2. Skip empty strings (from //) or "." (current directory)
            else if (directory.equals(".") || directory.isEmpty()) {
                continue;
            } 
            // 3. It's a valid directory or file name (like "home" or "...")
            else {
                stack.push(directory);
            }
        }

        // 4. Build the final path
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        // Return "/" if the stack is empty, otherwise the built string
        return result.length() == 0 ? "/" : result.toString();
    }
}
