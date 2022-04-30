package pers.mingda.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LC2115FindAllPossibleRecipesFromGivenSupplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> result = new LinkedList<>();
        Map<String, Integer> ingredMap = new HashMap<>();
        Map<String, Set<String>> cookableMap = new HashMap<>();

        for (int i = 0; i <  recipes.length; i++) {
            String recipe = recipes[i];
            for (String ingredient: ingredients.get(i)) {
                int count = ingredMap.getOrDefault(recipe, 0);
                ingredMap.put(recipe, count + 1);

                cookableMap.putIfAbsent(ingredient, new HashSet<>());
                cookableMap.get(ingredient).add(recipe);
            }
        }

        Queue<String> supplyQueue = new LinkedList<>();
        for (String supply: supplies)
            supplyQueue.add(supply);
        while (!supplyQueue.isEmpty()) {
            String supply = supplyQueue.remove();

            Set<String> cookables = cookableMap.getOrDefault(supply, Collections.emptySet());
            for (String cookable: cookables) {
                ingredMap.computeIfPresent(cookable, (k, v) -> v - 1);
                if (ingredMap.getOrDefault(cookable, -1) == 0) {
                    supplyQueue.add(cookable);
                    result.add(cookable);
                }
            }
        }
        return result;
    }
}
