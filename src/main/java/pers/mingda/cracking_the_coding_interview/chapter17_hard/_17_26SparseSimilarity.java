package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _17_26SparseSimilarity {
    Map<SparseSimilarityDocPair, Double> computeSimilarities(List<SparseSimilarityDocument> documents) {
        Map<Integer, List<SparseSimilarityDocument>> wordToDoc = new HashMap<>();
        for (SparseSimilarityDocument document : documents) {
            for (Integer word : document.words()) {
                wordToDoc.computeIfAbsent(word, w -> new ArrayList<>()).add(document);
            }
        }

        Map<SparseSimilarityDocPair, Double> intersections = new HashMap<>();
        for (int word: wordToDoc.keySet()) {
            List<SparseSimilarityDocument> docs = wordToDoc.get(word);
            if (docs.size() == 1) {
                continue;
            }
            calculateIntersection(docs, intersections);
        }

        return calculateSimilarity(intersections, documents);
    }

    private void calculateIntersection(List<SparseSimilarityDocument> docs, Map<SparseSimilarityDocPair, Double> intersections) {
        docs.sort(Comparator.comparingInt(SparseSimilarityDocument::docId));
        for (int i = 0; i < docs.size(); i++) {
            for (int j = i + 1; j < docs.size(); j++) {
                SparseSimilarityDocument doc1 = docs.get(i);
                SparseSimilarityDocument doc2 = docs.get(j);
                SparseSimilarityDocPair docPair = new SparseSimilarityDocPair(doc1.docId(), doc2.docId());
                double count = intersections.getOrDefault(docPair, 0d);
                intersections.put(docPair, count + 1);
            }
        }
    }

    private Map<SparseSimilarityDocPair, Double> calculateSimilarity(Map<SparseSimilarityDocPair, Double> intersections,
                                                            List<SparseSimilarityDocument> documents) {
        return intersections.entrySet()
                .stream()
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                e -> e.getValue() / (getDocSizeById(e.getKey().doc1(), documents) + getDocSizeById(e.getKey().doc1(), documents) - e.getValue())));
    }

    private int getDocSizeById(int docId, List<SparseSimilarityDocument> documents) {
        return documents.get(docId).words().size();
    }
}

record SparseSimilarityDocPair(int doc1, int doc2) {
}

record SparseSimilarityDocument(List<Integer> words, int docId) {
    public int size() {
        return words == null ? 0 : words.size();
    }
}
