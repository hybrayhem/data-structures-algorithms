package question;

class Q1 {

    public Q1() {
        System.out.printf("%n/* ----------------------------------- Q1 ----------------------------------- */%n%n");
    }

    
    /** 
     * @param string Bigger string to search inside
     * @param key The key will be searched in string
     * @param i Occurence of the query string
     * @param result Start index of ith occurence of key, -1 for not found
     * @return int Returns result
     */
    public int rOccurenceSearch(String string, String key, int i, int result) {
        if (string.length() == 0 || string.length() < key.length())
            return -1;

        if (i == 0)
            return result - key.length();

        if (key.equals(string.substring(0, key.length()))) {
            result += key.length();
            return rOccurenceSearch(string.substring(key.length()), key, --i, result);
        }

        return rOccurenceSearch(string.substring(1), key, i, ++result);
    }

}
