class Solution {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> availableSupplies = new HashSet<>();
        Map<String, Integer> recipeToIndex = new HashMap<>();
        Map<String, List<String>> depcyGraph = new HashMap<>();

        for (String supply : supplies)
            availableSupplies.add(supply);

        for (int idx = 0; idx < recipes.length; idx++)
            recipeToIndex.put(recipes[idx], idx);

        int[] inDegree = new int[recipes.length];

        for (int idx = 0; idx < recipes.length; idx++) {
            for (String ingredient : ingredients.get(idx)) {
                if (!availableSupplies.contains(ingredient)) {
                    depcyGraph.putIfAbsent(ingredient, new ArrayList<String>());
                    depcyGraph.get(ingredient).add(recipes[idx]);
                    inDegree[idx]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int idx = 0; idx < recipes.length; idx++) {
            if (inDegree[idx] == 0)
                queue.add(idx);
        }

        List<String> createdRecipes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            String recipe = recipes[idx];
            createdRecipes.add(recipe);

            if (!depcyGraph.containsKey(recipe)) 
                continue;

            for (String dependentRecipe : depcyGraph.get(recipe)) {
                if (--inDegree[recipeToIndex.get(dependentRecipe)] == 0) {
                    queue.add(recipeToIndex.get(dependentRecipe));
                }
            }
        }

        return createdRecipes;
    }
}