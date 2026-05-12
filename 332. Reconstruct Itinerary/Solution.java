class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, String> ticketFromTo = new HashMap<>();
        for(int i=0; i<tickets.size(); i++){
            ticketFromTo.put(tickets.get(i).get(0),tickets.get(i).get(1));
        }

        String start = getStartPoint(tickets, ticketFromTo);
       
        List<String> list = new ArrayList<>();
        list.add(start);
        for(String key: ticketFromTo.keySet()){
            list.add(ticketFromTo.get(start));
            start = ticketFromTo.get(start);
        }

        return list;
    }

    static String getStartPoint(List<List<String>> tickets, HashMap<String, String> ticketFromTo){
        HashMap<String, String> ticketToFrom = new HashMap<>();
        for(int i=0; i<tickets.size(); i++){
            ticketToFrom.put(tickets.get(i).get(1),tickets.get(i).get(0));
        }

        for(String s: ticketFromTo.keySet()){
            if(ticketToFrom.get(s) == null) return s;
        }
        return "";
    }
}