import java.util.*;

public class hard332 {

    LinkedList<String> res = new LinkedList<>();
    Map<String,Map<String,Integer>> map = new HashMap<>();

    private boolean backtrack(int ticketNum) {
        if (res.size() == ticketNum + 1) {
            return true;
        }

        String last = res.getLast();
        if (map.containsKey(last)) {
            for (Map.Entry<String, Integer> entry : map.get(last).entrySet()) {
                int count = entry.getValue();
                if (count > 0) {
                    res.add(entry.getKey());
                    entry.setValue(count - 1);
                    if (backtrack(ticketNum)) {
                        return true;
                    }
                    entry.setValue(count);
                    res.removeLast();
                }
            }
        }
        return false;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            Map<String, Integer> temp;
            if (map.containsKey(ticket.get(0))) {
                temp = map.get(ticket.get(0));
                temp.put(ticket.get(1), temp.getOrDefault(ticket.get(1), 0) + 1);
            } else {
                temp = new TreeMap<>();
                temp.put(ticket.get(1),1);
            }
            map.put(ticket.get(0), temp);
        }
        res.add("JFK");
        backtrack(tickets.size());
        return new ArrayList<>(res);
    }
}
