import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static StringTokenizer st;
	static TrieNode trie = new TrieNode();

	static void make() throws IOException {
		int N = init();

		for (int i = 0; i < N; i++) {
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			int K = init(st);

			for (int j = 1; j < K + 1; j++) {
				sb.append(st.nextToken()).append(",");
			}

			trie.insert(sb.toString());
		}
	}

	static class TrieNode {
		Map<String, TrieNode> childNode = new HashMap<>();

		TrieNode() {
		}

		public void insert(String strs) {
			TrieNode trieNode = this;
			String[] str = strs.split(",");
			for (String s : str) {
				// putIfAbsent(key, value) : 기존데이터에 key가 없으면 저장
				trieNode.childNode.putIfAbsent(s, new TrieNode());
				trieNode = trieNode.childNode.get(s);
			}
		}

		public void print(TrieNode cur, int depth) {
			TrieNode trieNode = cur;

			if (trieNode.childNode != null) {
				List<String> list = new ArrayList<>(trieNode.childNode.keySet());
				Collections.sort(list);
				for (String str : list) {
					for (int i = 0; i < depth; i++) {
						System.out.print("--");
					}
					System.out.println(str);
					print(trieNode.childNode.get(str), depth + 1);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		trie.print(trie, 0);
	}

	static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
}
