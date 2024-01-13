class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> smp = new HashMap<>();
        Map<Character, Integer> tmp = new HashMap<>();
        int cnt = 0;

        for (char a : s.toCharArray()) {
            smp.put(a, smp.getOrDefault(a, 0) + 1);
        }

        for (char a : t.toCharArray()) {
            tmp.put(a, tmp.getOrDefault(a, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : smp.entrySet()) {
            char key = entry.getKey();
            if (tmp.containsKey(key)) {
                if (entry.getValue().equals(tmp.get(key))) {
                    cnt += entry.getValue();
                } else {
                    cnt += Math.min(entry.getValue(), tmp.get(key));
                }
            }
        }

        return s.length() - cnt;
    }
}