class Solution {
    private boolean chk(int a, int b, int c, int d) {
        // if new numbers are answer
        if (b - a < d - c) {
            return true;
        } else if (b - a == d - c) {
            if (a < c) {
                return true;
            }
        }
        // new number doesn't have minimum difference uptill now
        return false;
    }

    public int[] smallestRange(List<List<Integer>> a) {
        int ansx = -100000, ansy = 100000;
        int total_list = a.size();

        List<int[]> vp = new ArrayList<>();
        for (int i = 0; i < total_list; i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                vp.add(new int[]{a.get(i).get(j), i});
            }
        }

        vp.sort(Comparator.comparingInt(x -> x[0]));

        Map<Integer, Integer> um = new HashMap<>();
        int l = 0, r = 0;
        int n = vp.size();
        while (r < n) {
            int num = vp.get(r)[0];
            int list = vp.get(r)[1];

            um.put(list, um.getOrDefault(list, 0) + 1);

            while (um.size() >= total_list) {
                if (chk(vp.get(l)[0], vp.get(r)[0], ansx, ansy)) {
                    ansx = vp.get(l)[0];
                    ansy = vp.get(r)[0];
                }

                int old_list = vp.get(l)[1];
                um.put(old_list, um.get(old_list) - 1);
                if (um.get(old_list) == 0) {
                    um.remove(old_list);
                }
                l++;
            }

            r++;
        }

        return new int[]{ansx, ansy};
    }
}