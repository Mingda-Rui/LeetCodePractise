package pers.mingda.leetcode;

import java.util.Arrays;
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

    public List<String> findAllRecipesDfs(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> result = new LinkedList<>();
        Set<String> supplySet = new HashSet<>(Arrays.asList(supplies));
        Map<String, Set<String>> ingredMap = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            List<String> ingreds = ingredients.get(i);
            ingredMap.putIfAbsent(recipe, new HashSet<>());
            ingredMap.get(recipe).addAll(ingreds);
        }
        Set<String> visited = new HashSet<>();

        for (String recipe: recipes) {
            if (findRecipe(recipe, ingredMap, supplySet, visited)) {
                result.add(recipe);
            }
        }
        return result;
    }

    private boolean findRecipe(String recipe, Map<String, Set<String>> ingredMap, Set<String> supplySet, Set<String> visited) {
        if (supplySet.contains(recipe))
            return true;
        if (visited.contains(recipe))
            return false;
        if (!ingredMap.containsKey(recipe))
            return false;
        visited.add(recipe);
        for (String ingred: ingredMap.get(recipe)) {
            if (!supplySet.contains(ingred) && !findRecipe(ingred, ingredMap, supplySet, visited)) {
                return false;
            }
        }
        supplySet.add(recipe);
        visited.remove(recipe);
        return true;
    }
}
