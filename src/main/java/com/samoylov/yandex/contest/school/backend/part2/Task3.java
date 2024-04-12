package com.samoylov.yandex.contest.school.backend.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task3 {
    private static final int INF = Integer.MAX_VALUE / 2;

    static class Edge implements Comparable<Edge> {
        int src, dest, weight, cost, index;
        boolean isProposal;

        Edge(int src, int dest, int weight, int cost, int index, boolean isProposal) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
            this.cost = cost;
            this.index = index;
            this.isProposal = isProposal;
        }

        public int compareTo(Edge other) {
            if (this.cost != other.cost)
                return Integer.compare(this.cost, other.cost);
            return Integer.compare(this.index, other.index);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);

        int[][] dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        System.out.println("Инициализация матрицы расстояний для " + N + " узлов.");

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String[] edgeInfo = reader.readLine().split(" ");
            int U = Integer.parseInt(edgeInfo[0]);
            int V = Integer.parseInt(edgeInfo[1]);
            int T = Integer.parseInt(edgeInfo[2]);
            edges.add(new Edge(U, V, T, 0, -1, false));
            dist[U][V] = dist[V][U] = T;
        }

        System.out.println("Прочитано " + M + " существующих оптоволоконных линий.");

        // Applying Floyd-Warshall to find shortest paths with existing edges
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        System.out.println("Алгоритм Флойда-Варшалла применен для нахождения кратчайших путей.");

        String[] proposalsInfo = reader.readLine().split(" ");
        int K = Integer.parseInt(proposalsInfo[0]);
        List<Edge> proposals = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            String[] proposalInfo = reader.readLine().split(" ");
            int U = Integer.parseInt(proposalInfo[0]);
            int V = Integer.parseInt(proposalInfo[1]);
            int T = Integer.parseInt(proposalInfo[2]);
            int C = Integer.parseInt(proposalInfo[3]);
            proposals.add(new Edge(U, V, T, C, i + 1, true));
        }

        System.out.println("Прочитано " + K + " предложений о строительстве новых линий.");

        String[] requirementsInfo = reader.readLine().split(" ");
        int P = Integer.parseInt(requirementsInfo[0]);
        List<int[]> requirements = new ArrayList<>();

        for (int i = 0; i < P; i++) {
            String[] reqInfo = reader.readLine().split(" ");
            int A = Integer.parseInt(reqInfo[0]);
            int B = Integer.parseInt(reqInfo[1]);
            int T = Integer.parseInt(reqInfo[2]);
            requirements.add(new int[]{A, B, T});
        }

        System.out.println("Прочитано " + P + " требований к времени прохождения сигналов.");

        // Implementing Kruskal's algorithm with Union-Find to find the minimal maximum cost of new edges
        Collections.sort(proposals);  // Sort by cost
        int[] parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        List<Edge> usedProposals = new ArrayList<>();
        for (Edge proposal : proposals) {
            if (find(parent, proposal.src) != find(parent, proposal.dest)) {
                union(parent, proposal.src, proposal.dest);
                usedProposals.add(proposal);
                // Update dist matrix with the newly added edge
                dist[proposal.src][proposal.dest] = dist[proposal.dest][proposal.src] = proposal.weight;
                // Re-run Floyd-Warshall for only this edge (localized update)
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        if (dist[i][j] > dist[i][proposal.src] + proposal.weight + dist[proposal.dest][j]) {
                            dist[i][j] = dist[i][proposal.src] + proposal.weight + dist[proposal.dest][j];
                        }
                        if (dist[i][j] > dist[i][proposal.dest] + proposal.weight + dist[proposal.src][j]) {
                            dist[i][j] = dist[i][proposal.dest] + proposal.weight + dist[proposal.src][j];
                        }
                    }
                }
            }
        }

        System.out.println("Процесс выбора новых линий завершен. Проверка требований...");

        // Check if all requirements are satisfied with the added proposals
        boolean allRequirementsMet = true;
        for (int[] req : requirements) {
            if (dist[req[0]][req[1]] > req[2]) {
                allRequirementsMet = false;
                break;
            }
        }

        if (!allRequirementsMet) {
            System.out.println("-1");
        } else if (usedProposals.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(usedProposals.size());
            System.out.print("Необходимо удовлетворить следующие предложения: ");
            usedProposals.sort(Comparator.comparingInt(a -> a.index));
            for (Edge e : usedProposals) {
                System.out.print(e.index + " ");
            }
            System.out.println();
        }
    }

    static int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);  // Path compression
        }
        return parent[i];
    }

    static void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY) {
            parent[rootY] = rootX;  // Union by rank can be optimized further
        }
    }
}