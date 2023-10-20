package com.example;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class CaveExplorer {

    private Map<Integer, Set<Integer>> adjList = new HashMap<>();

    
    //  Load data from CAV.IN.
    
    public void loadData() {
        Path inputFile = Paths.get("data/CAV.IN");
        try (BufferedReader reader = Files.newBufferedReader(inputFile)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                int cave1 = Integer.parseInt(parts[0]);
                int cave2 = Integer.parseInt(parts[1]);

                adjList.putIfAbsent(cave1, new HashSet<>());
                adjList.putIfAbsent(cave2, new HashSet<>());

                adjList.get(cave1).add(cave2);
                adjList.get(cave2).add(cave1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Find the cave exploring path.
    
    public List<Integer> findPath() {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        if (!adjList.isEmpty()) {
            dfs(adjList.keySet().iterator().next(), visited, result);
        }
        return result;
    }

    private void dfs(Integer current, Set<Integer> visited, List<Integer> result) {
        visited.add(current);
        result.add(current);
        for (Integer neighbor : adjList.get(current)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited, result);
            }
        }
    }

    //  Save the exploring path to CAV.OUT.
     
    public void savePath(List<Integer> path) {
        Path outputFile = Paths.get("data/CAV.OUT");
        try (BufferedWriter writer = Files.newBufferedWriter(outputFile)) {
            for (Integer cave : path) {
                writer.write(cave.toString());
                writer.write(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CaveExplorer explorer = new CaveExplorer();
        explorer.loadData();
        List<Integer> path = explorer.findPath();
        explorer.savePath(path);
    }
    
    public Map<Integer, Set<Integer>> getAdjList() {
        return adjList;
    }
    
}
