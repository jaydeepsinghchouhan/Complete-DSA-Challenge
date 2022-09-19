import java.util.*;

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {

        // Set up the result list.
        List<List<String>> result = new ArrayList<>();

        // Return an empty list if there is no item in the paths.
        if (paths.length == 0) {
            return result;
        }

        // Use a HashMap to record the content (key) and the file path list (value).
        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            // Split each path into the directory and contents.
            // Example:
            // String path = "root/a 1.txt(abcd) 2.txt(efgh)"
            // path.split(" ") = ["root/a", "1.txt(abcd)", "2.txt(efgh)"]
            String[] strings = path.split(" ");

            // We know that path[0] is always the directory.
            String directory = strings[0];
			
            // So, i = 1, and we check for the content.
            for (int i = 1; i < strings.length; i++) {
                // From "(" onwards, all letters are the contents (including the final ")"), to check for duplicates.
                int index = strings[i].indexOf("(");

                // Example:
                // content = "abcd)" or "efgh)".
                String content = strings[i].substring(index);

                // Example:
                // "root/a" + "/" + "1.txt" = "root/a/1.txt"
                // "root/a" + "/" + "2.txt" = "root/a/2.txt"
                String filename = directory + "/" + strings[i].substring(0, index);

                // If the list contains the content (e.g. "abcd)" or "efgh)"),
                // we add the 'filename' ("root/a/1.txt") to the list.
                List<String> filenames = map.getOrDefault(content, new ArrayList<>());
                filenames.add(filename);

                // Record the file path list as the key, into the 'map'.
                // Since if content is the same, meaning it is duplicate file in different directories.
                map.put(content, filenames);
            }
        }

        // Check all the key (content) if there are duplicates (size > 1).
        // If there are duplicates, add the list to the result.
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                result.add(map.get(key));
            }
        }

        return result;
    }
}