import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static class TrieNode {
		// 자식 노드 맵
		private Map<Character, TrieNode> childNodes = new HashMap<>();
		// 마지막 글자인지 여부
		private boolean isLastChar;

		Map<Character, TrieNode> getChildNodes() {
			return this.childNodes;
		}

		boolean isLastChar() {
			return this.isLastChar;
		}

		void setIsLastChar(boolean isLastChar) {
			this.isLastChar = isLastChar;
		}
	}

	static class Trie {

		private TrieNode rootNode;

		Trie() {
			rootNode = new TrieNode();
		}

		// ----저장----
		void insert(String word) {
			TrieNode thisNode = this.rootNode;

			for (int i = 0; i < word.length(); i++) {
				thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
			}
			thisNode.setIsLastChar(true);
		}

		// ----확인----
		int contains(String word) {
			TrieNode thisNode = this.rootNode;
			int count = 1;

			thisNode = thisNode.getChildNodes().get(word.charAt(0));
			for (int i = 1; i < word.length(); i++) {
				if (thisNode.getChildNodes().size() >= 2)
					count++;

				else if (thisNode.getChildNodes().size() == 1 && thisNode.isLastChar())
					count++;

				char character = word.charAt(i);
				TrieNode node = thisNode.getChildNodes().get(character);

				thisNode = node;
			}

			return count;
		}
	}

	static void solution() {
	}

	static void make() throws IOException {
		String str;
		while ((str = br.readLine()) != null) {
			try {
				int N = Integer.parseInt(str);

				List<String> list = new ArrayList<String>();
				Trie trie = new Trie();

				// 입력 받기
				for (int i = 0; i < N; i++) {
					String word = br.readLine();
					list.add(word);
					trie.insert(word);
				}

				// 정답 찾기
				double sum = 0;
				for (String ele : list) {
					sum += trie.contains(ele);
				}

				// 평균 출력
				double avg = sum / N;
				
				System.out.println(String.format("%.2f", avg));
			} catch (NumberFormatException e) {
				return;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		make();
	}

	static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
}