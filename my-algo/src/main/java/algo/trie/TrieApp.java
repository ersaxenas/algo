package algo.trie;

public class TrieApp {

	public void testRwayTries(){
		System.out.println("Testing Rway Tries.");
		RwayTrie trie = new RwayTrie();
		trie.put("abcd", "1");
		trie.put("abed", "2");
		trie.put("afcd", "3");
		trie.put("arcd", "4");
		trie.put("abkd", "5");
		trie.put("abhjd", "6");
		trie.put("zhd", "7");
		System.out.println("Key:"+trie.getKey("sdfd"));
		System.out.println("Key:"+trie.getKey("abcd"));
		System.out.println("Key:"+trie.getKey("afcd"));
		System.out.println("Key:"+trie.getKey("zhd"));
		System.out.println("Key:"+trie.getKey("abkd"));
		System.out.println("Key:"+trie.getKey("abkdd"));
		System.out.println("Key:"+trie.getKey("abcde"));
		//trie.deleteKey("zhd");
		trie.deleteKey("abkdd");
		System.out.println("Key:"+trie.getKey("abkdd"));
		System.out.println("Key:"+trie.getKey("abkd"));
		System.out.println("Done Testing Rway Tries.");
	}
	
	public void testTernaryTries(){
		System.out.println("Testing Ternary Tries.");
		TernaryTrie trie = new TernaryTrie();
		trie.put("abcd", "1");
		trie.put("abed", "2");
		trie.put("afcd", "3");
		trie.put("arcd", "4");
		trie.put("abkd", "5");
		trie.put("abhjd", "6");
		trie.put("zhd", "7");
		System.out.println("Key:"+trie.getVal("sdfd"));
		System.out.println("Key:"+trie.getVal("abcd"));
		System.out.println("Key:"+trie.getVal("afcd"));
		System.out.println("Key:"+trie.getVal("zhd"));
		System.out.println("Key:"+trie.getVal("abkd"));
		System.out.println("Key:"+trie.getVal("abkdd"));
		System.out.println("Key:"+trie.getVal("abcde"));
		System.out.println(trie.iterator());
		System.out.println("Done Ternary Rway Tries.");
		
	}
	
	public static void main(String args[]) {
		TrieApp app = new TrieApp();
		app.testTernaryTries();
	}
	
}
