class Solution {

    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int totalSkill = 0;
        Map<Integer, Integer> skillMap = new HashMap<>();

        for (int s : skill) {
            totalSkill += s;
            skillMap.put(s, skillMap.getOrDefault(s, 0) + 1);
        }

        int k = n / 2;
        if (totalSkill % k != 0)
            return -1;

        int teamSkill = totalSkill / k;
        long totalChemistry = 0;

        for (int currSkill : skillMap.keySet()) {
            int currFreq = skillMap.get(currSkill);
            int partnerSkill = teamSkill - currSkill;

            if (!skillMap.containsKey(partnerSkill) ||
                    currFreq != skillMap.get(partnerSkill)) {
                return -1;
            }

            totalChemistry += (long) currSkill * (long) partnerSkill * (long) currFreq;
        }

        return totalChemistry / 2;
    }
}