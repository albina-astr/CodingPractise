package array;

import java.util.*;

/**
 * https://leetcode.com/problems/keys-and-rooms/
 *
 * @author Albina Gimaletdinova on 10/11/2022
 */
public class CanVisitRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) {
            return false;
        }

        Map<Integer, Set<Integer>> vertexMap = buildVertexMap(rooms);
        Set<Integer> visitedRooms = new HashSet<>();

        Deque<Integer> q = new ArrayDeque<>();
        q.add(0);
        visitedRooms.add(0);

        while (!q.isEmpty()) {
            Integer currentRoom = q.poll();
            Set<Integer> relatedRooms = vertexMap.get(currentRoom);

            if (relatedRooms == null || relatedRooms.isEmpty()) {
                continue;
            }

            for (int room : relatedRooms) {
                if (!visitedRooms.contains(room)) {
                    visitedRooms.add(room);
                    q.add(room);
                }
            }
        }

        return visitedRooms.size() == rooms.size();
    }

    private Map<Integer, Set<Integer>> buildVertexMap(List<List<Integer>> rooms) {
        Map<Integer, Set<Integer>> map = new LinkedHashMap<>();

        int roomNumber = 0;
        for (List<Integer> nodes : rooms) {
            map.put(roomNumber, new HashSet<>(nodes));
            roomNumber++;
        }

        return map;
    }
}
