package WordLadder;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] words = {"hot","dot","lot","log","cog"};
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList(words);
        Main a = new Main();
        System.out.println(a.ladderLength_neighbor(beginWord,endWord,wordList));
    }

    public int ladderLength_neighbor(String beginWord, String endWord, List<String> wordList){
        if(wordList == null || !wordList.contains(endWord))
            return 0;
        System.out.println(beginWord);
        Queue<String> queue = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);
        queue.offer(beginWord);
        //dict.add(endWord);
        //dict.remove(beginWord)
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String temp = queue.poll();
                if(temp.equals(endWord))
                    return level;
                for(String neighbor : neighbors(temp,wordList)){
                    queue.offer(neighbor);
                }
            }
            level++;
        }
        return 0;
    }

    public List<String> neighbors(String s, List<String> wordList){
        List<String> res = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);

        for(int i=0;i<s.length();i++){
            char[] temp = s.toCharArray();
            for(char ch='a';ch<='z';ch++){
                temp[i] = ch;
                //System.out.println(temp[i]);
                //String temp2 = temp.toString(); // char 배열에서 문자열 변환 시에는 사용 불가!!!!
                //String temp2 = new String(temp);
                String temp2 = String.valueOf(temp);
                System.out.println(temp2);
                if(dict.remove(temp2)){
                    res.add(temp2);
                }
            }
        }
        return res;
    }
}
