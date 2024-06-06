class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char l: word.toCharArray()) {
            current = current.children.computeIfAbsent(l, c -> new TrieNode());
        }
        current.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char l: word.toCharArray()) {
            TrieNode node = current.children.get(l);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.endOfWord;
    }
}